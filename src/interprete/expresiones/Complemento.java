/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interprete.expresiones;

import interprete.herramientas.Conjunto;
import interprete.herramientas.Entorno;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 *
 * @author carme
 */
public class Complemento extends Expresion {

	public Expresion exp;

	public Complemento(int fila, int columna, Expresion exp) {
		super(fila, columna);
		this.exp = exp;
	}

	@Override
	public Conjunto evaluar(Entorno entorno) throws Exception {

		Conjunto result = new Conjunto();
		result.rango('!', '~');
		System.out.println("COMPLEMENTO EVALUAR");
		result.itemsSet.removeAll(this.exp.evaluar(entorno).itemsSet);

		return result;
	}

	@Override
	public Area dibujar(ArrayList<Ellipse2D> conjuntos, ArrayList<String> nombreConjs) {
		Rectangle universo = new Rectangle(10, 40, 470, 440);

		Area areaUniverso = new Area(universo);

		Area result = this.exp.dibujar(conjuntos, nombreConjs);

		areaUniverso.subtract(result);
		return areaUniverso;
	}

	@Override
	public Expresion simplificar(ArrayList<String> registro) {
		Expresion expSimplificada = this.exp.simplificar(registro);

		// LEY DE DOBLE COMPLEMENTO: ^^A = A
		if (expSimplificada instanceof Complemento) {
			Complemento complemento = (Complemento) expSimplificada;
			registro.add("Ley de doble complemento");
			return complemento.exp;
		}

		// LEY DE MORGAN: ^(A n B) = ^A U ^B
		if (expSimplificada instanceof Interseccion) {
			Interseccion interseccion = (Interseccion) expSimplificada;
			registro.add("Ley de morgan (interseccion)");
			return new Union(
				fila,
				columna,
				new Complemento(fila, columna, interseccion.exp1),
				new Complemento(fila, columna, interseccion.exp2)
			);
		}

		// LEY DE MORGAN: ^(A U B) = ^A n ^B
		if (expSimplificada instanceof Union) {
			Union union = (Union) expSimplificada;
			registro.add("Ley de morgan (union)");
			return new Interseccion(
				fila,
				columna,
				new Complemento(fila, columna, union.exp1),
				new Complemento(fila, columna, union.exp2)
			);
		}

		return new Complemento(fila, columna, expSimplificada);
	}

	@Override
	public String aNotacionPolaca() {
		return "^ " + this.exp.aNotacionPolaca();
	}

	@Override
	public boolean esIgualA(Expresion otra) {
		if (otra instanceof Complemento) {
			Complemento otroComplemento = (Complemento) otra;
			return this.exp.esIgualA(otroComplemento.exp);
		}
		return false;
	}

}
