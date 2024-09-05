/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interprete.expresiones;

import interprete.herramientas.Conjunto;
import interprete.herramientas.Entorno;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 *
 * @author carme
 */
public class Union extends Expresion {

	public Expresion exp1;
	public Expresion exp2;

	public Union(int fila, int columna, Expresion exp1, Expresion exp2) {
		super(fila, columna);
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	@Override
	public Conjunto evaluar(Entorno entorno) throws Exception {

		Conjunto result = this.exp1.evaluar(entorno);
		result.itemsSet.addAll(this.exp2.evaluar(entorno).itemsSet);
		System.out.println("UNION");
		return result;

	}

	@Override
	public Area dibujar(ArrayList<Ellipse2D> conjuntos, ArrayList<String> nombreConjs) {
		Area area1 = this.exp1.dibujar(conjuntos, nombreConjs);
		Area area2 = this.exp2.dibujar(conjuntos, nombreConjs);

		Area union = new Area(area1);
		union.add(area2);

		return union;

	}

	@Override
	public Expresion simplificar(ArrayList<String> registro) {
		Expresion expIzq = this.exp1.simplificar(registro);
		Expresion expDer = this.exp2.simplificar(registro);

		// aplicar las reglas de simplificacion
		// PROPIEDAD DE IDEMPOTENCIA: A U A = A
		if (expIzq.esIgualA(expDer)) {
			registro.add("Propiedad idempotente");
			return expIzq;

		}

		// PROPIEDAD DE ABSORCION: A U (A n B) = A
		if (expDer instanceof Interseccion) {
			Interseccion interseccion = (Interseccion) expDer;
			if (interseccion.exp1.esIgualA(expIzq) || interseccion.exp2.esIgualA(expIzq)) {
				registro.add("Propiedad de absorcion");
				return expIzq;
			}
		}

		// PROPIEDAD DE ABSORCION: (A n B) U A = A
		if (expIzq instanceof Interseccion) {
			Interseccion interseccion = (Interseccion) expIzq;
			if (interseccion.exp1.esIgualA(expDer) || interseccion.exp2.esIgualA(expDer)) {
				registro.add("Propiedad de absorcion");
				return expDer;
			}
		}

		// PROPIEDAD CONMUTATIVA: A U B = B U A
		// esta ya es redundante con la funcion esIgualA()
		// PROPIEDAD ASOCIATIVA: A U (B U C) = (A U B) U C
		if (expDer instanceof Union) {
			Union union = (Union) expDer;
			registro.add("Propiedad asociativa");
			return new Union(fila, columna, new Union(fila, columna, expIzq, union.exp1), expDer);
		}

		// PROPIEDAD DISTRIBUTIBA: A U (B n C) = (A U B) n (A U C)
		if (expDer instanceof Interseccion) {
			Interseccion interseccion = (Interseccion) expDer;
			registro.add("Propiedad distributiba");
			return new Interseccion(
				fila,
				columna,
				new Union(fila, columna, expIzq, interseccion.exp1),
				new Union(fila, columna, expIzq, interseccion.exp2)
			);
		}

		return new Union(this.fila, this.columna, expIzq, expDer);
	}

	@Override
	public String aNotacionPolaca() {
		return "U " + this.exp1.aNotacionPolaca() + " " + this.exp2.aNotacionPolaca();
		//return this.exp1.aNotacionPolaca() + " U " + this.exp2.aNotacionPolaca();

	}

	@Override
	public boolean esIgualA(Expresion otra) {
		if (otra instanceof Union) {
			Union otraUnion = (Union) otra;
			return this.exp1.esIgualA(otraUnion.exp1) && this.exp2.esIgualA(otraUnion.exp2);
		}
		return false;
	}
}
