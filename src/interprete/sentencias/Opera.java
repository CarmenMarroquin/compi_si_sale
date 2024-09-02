/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interprete.sentencias;

import analizadorCJ.graficas.*;
import analizadorCJ.graficas.Graficar;
import interprete.expresiones.AccederId;
import interprete.expresiones.Expresion;
import interprete.herramientas.Conjunto;
import interprete.herramientas.Entorno;
import interprete.herramientas.Operaciones;
import interprete.herramientas.Simbolo;
import interprete.herramientas.Tipo;
import java.awt.Color;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 *
 * @author carme
 */
public class Opera extends Sentencia{
    public String id;
    public Expresion expr;
    public Conjunto resultado;
    public ArrayList<String> contadorConjuntos;
    public Opera(int fila, int columna, String id, Expresion expr){
        super(fila, columna);
        this.id = id;
        this.expr = expr;
    }
    
    @Override
    public void interpretar(Entorno entorno) throws Exception {

        Conjunto resultado = this.expr.evaluar(entorno);
        System.out.println("El numero final de conjuntos es: " + AccederId.contadorConjuntos);
        this.contadorConjuntos = AccederId.conjuntosAccedidos;
        
        AccederId.conjuntosAccedidos = new ArrayList<String>();
        Simbolo nuevoSimbolo = new Simbolo(this.fila, this.columna, this.id, resultado, entorno, Tipo.OPERA);
        entorno.setSimbolo(nuevoSimbolo);
    }

    
    public DiagramaSet dibujar() {
        int contador = this.contadorConjuntos.size();
        
        switch (contador) {
            case 1:
                return new Diagrama1Set(Color.yellow, this.expr, this.contadorConjuntos);
            case 2:
                return new Diagrama2Set(Color.yellow, expr, this.contadorConjuntos);
            case 3:
                return new Diagrama3Set(Color.yellow, expr, contadorConjuntos);
            case 4:
                return new Diagrama4Set(Color.yellow, expr, contadorConjuntos);
            
            default:
                throw new AssertionError();
        }
    }
    
    public ArrayList<String> simplificacion(){
        
    }
}
