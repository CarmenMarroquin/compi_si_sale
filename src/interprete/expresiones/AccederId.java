/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interprete.expresiones;

import interprete.herramientas.Conjunto;
import interprete.herramientas.Entorno;
import interprete.herramientas.Simbolo;
import interprete.herramientas.Tipo;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author carme
 */
public class AccederId extends Expresion {

	public String id;
	public Set<Character> value;
	public static int contadorConjuntos = 0;
	public static int conjuntoActual = 0;
	public static ArrayList<String> conjuntosAccedidos = new ArrayList<>();

	public AccederId(int fila, int columna, String id) {
		super(fila, columna);
		this.id = id;
	}

	@Override
	public Conjunto evaluar(Entorno entorno) throws Exception {
		System.out.println("ACCEDERID.EVALUAR ");
		contadorConjuntos++;
		Simbolo temp = new Simbolo(0, 0, this.id, new Conjunto(), entorno, Tipo.CONJ);
		Simbolo simbolo;

		simbolo = entorno.getSimbolo(temp);
		int result = conjuntosAccedidos.indexOf(id);
		if (result == -1) {
			conjuntosAccedidos.add(id);
		}

		return simbolo.conjunto;

	}

	@Override
	public Area dibujar(ArrayList<Ellipse2D> conjuntos, ArrayList<String> nombreConjs) {

		int index = nombreConjs.indexOf(id);

		Area area1 = new Area(conjuntos.get(index));

		return area1;

	}

	@Override
	public Expresion simplificar(ArrayList<String> registro) {
		return this;
	}

	@Override
	public String aNotacionPolaca() {
		return this.id;
	}

	@Override
	public boolean esIgualA(Expresion otra) {
		if (otra instanceof AccederId) {
			AccederId otroconj = (AccederId) otra;
			int value = this.id.compareTo(otroconj.id);
			return value == 0;
		}
		return false;
	}

}
