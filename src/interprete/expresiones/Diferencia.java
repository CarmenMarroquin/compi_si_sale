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
public class Diferencia extends Expresion {

	public Expresion exp1;
	public Expresion exp2;

	public Diferencia(int fila, int columna, Expresion exp1, Expresion exp2) {
		super(fila, columna);
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	@Override
	public Conjunto evaluar(Entorno entorno) throws Exception {

		Conjunto result = this.exp1.evaluar(entorno);
		System.out.println("CONJUNTO.EVALUAR ");
		result.itemsSet.removeAll(this.exp2.evaluar(entorno).itemsSet);

		return result;

	}

	@Override
	public Area dibujar(ArrayList<Ellipse2D> conjuntos, ArrayList<String> nombreConjs) {
		Area area1 = this.exp1.dibujar(conjuntos, nombreConjs);
		Area area2 = this.exp2.dibujar(conjuntos, nombreConjs);

		Area diferencia = new Area(area1);
		diferencia.subtract(area2);

		return diferencia;

	}

	@Override
	public Expresion simplificar(ArrayList<String> registro) {
		Expresion expIzq = this.exp1.simplificar(registro);
		Expresion expDer = this.exp2.simplificar(registro);

		return new Diferencia(fila, columna, expIzq, expDer);
	}

	@Override
	public String aNotacionPolaca() {
		return "- " + this.exp1.aNotacionPolaca() + " " + this.exp2.aNotacionPolaca();
	}

	@Override
	public boolean esIgualA(Expresion otra) {
		if (otra instanceof Diferencia) {
			Diferencia otraDiferencia = (Diferencia) otra;
			return this.exp1.esIgualA(otraDiferencia.exp1) && this.exp2.esIgualA(otraDiferencia.exp2);
		}
		return false;
	}

}
