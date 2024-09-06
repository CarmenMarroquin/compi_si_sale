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
public class Interseccion extends Expresion {

	public Expresion exp1;
	public Expresion exp2;

	public Interseccion(int fila, int columna, Expresion exp1, Expresion exp2) {
		super(fila, columna);
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	@Override
	public Conjunto evaluar(Entorno entorno) throws Exception {

		Conjunto result = this.exp1.evaluar(entorno);
		result.itemsSet.retainAll(this.exp2.evaluar(entorno).itemsSet);
		System.out.println("INTERSECCION");
		return result;

	}

	@Override
	public Area dibujar(ArrayList<Ellipse2D> conjuntos, ArrayList<String> nombreConjs) {
		Area area1 = this.exp1.dibujar(conjuntos, nombreConjs);
		Area area2 = this.exp2.dibujar(conjuntos, nombreConjs);

		Area interseccion = new Area(area1);
		interseccion.intersect(area2);
		return interseccion;
	}

	@Override
	public Expresion simplificar(ArrayList<String> registro) {
		Expresion expIzq = this.exp1.simplificar(registro);
		Expresion expDer = this.exp2.simplificar(registro);

		// PROPIEDAD IDEMPOTENCIA: A n A = A
		if (expIzq.esIgualA(expDer)) {
			registro.add("Propiedad idempotente");
			return expIzq;
		}

		// PROPIEDAD DE ABSORCION: A n (A U B) = A
		if (expDer instanceof Union) {
			Union union = (Union) expDer;
			if (union.exp1.esIgualA(expIzq) || union.exp2.esIgualA(expIzq)) {
				registro.add("Propiedad de absorcion");
				return expIzq;
			}
		}

		// PROPIEDAD DE ABSORCION: (A U B) n A = A
		if (expIzq instanceof Union) {
			Union union = (Union) expIzq;
			if (union.exp1.esIgualA(expDer) || union.exp2.esIgualA(expDer)) {
				registro.add("Propiedad de absorcion");
				return expDer;
			}
		}

		// PROPIEDAD ASOCIATIVA
		if (expDer instanceof Interseccion) {
			Interseccion interseccion = (Interseccion) expDer;
			registro.add("Propiedad asociativa");
			return new Interseccion(
				fila,
				columna,
				new Interseccion(fila, columna, expIzq, interseccion.exp1),
				interseccion.exp2
			);
		}

		// PROPIEDAD CONMUTATIVA: A U B = B U A
		// esta ya es redundante con la funcion esIgualA()
		// PROPIEDAD DISTRIBUTIBA
		if (expDer instanceof Union) {
			Union union = (Union) expDer;
			registro.add("Propiedad distributiva");
			return new Union(
				fila,
				columna,
				new Interseccion(fila, columna, expIzq, union.exp1),
				new Interseccion(fila, columna, expIzq, union.exp2)
			);
		}

		return new Interseccion(fila, columna, expIzq, expDer);

	}

	@Override
	public String aNotacionPolaca() {
		return "& " + this.exp1.aNotacionPolaca() + " " + this.exp2.aNotacionPolaca();
		//return this.exp1.aNotacionPolaca() + " & " + this.exp2.aNotacionPolaca();
	}

	@Override
	public boolean esIgualA(Expresion otra) {
		if (otra instanceof Interseccion) {
			Interseccion otraInterseccion = (Interseccion) otra;
			return this.exp1.esIgualA(otraInterseccion.exp1) && this.exp2.esIgualA(otraInterseccion.exp2);
		}
		return false;
	}

}
