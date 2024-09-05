/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interprete.expresiones;

import analizadorCJ.graficas.Graficar;
import interprete.herramientas.Conjunto;
import interprete.herramientas.Entorno;
import interprete.lenguaje.Instruccion;
import java.util.ArrayList;

/**
 *
 * @author carme
 */
public abstract class Expresion extends Instruccion implements Graficar {

	public ArrayList<String> registroSimplificacion;

	public Expresion(int fila, int columna) {
		super(fila, columna);
		this.registroSimplificacion = new ArrayList<>();
	}

	public abstract Conjunto evaluar(Entorno entorno) throws Exception;

	public abstract Expresion simplificar(ArrayList<String> registro);

	public abstract String aNotacionPolaca();

	public abstract boolean esIgualA(Expresion otra);

	@Override
	public void ejecutar(Entorno entorno) throws Exception {
		evaluar(entorno);
	}

	protected void agregarPaso(String paso) {
		this.registroSimplificacion.add(paso);
	}

	public ArrayList<String> obtenerRegistroSimplificacion() {
		return this.registroSimplificacion;
	}

}
