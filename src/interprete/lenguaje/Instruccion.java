/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interprete.lenguaje;

import interprete.herramientas.Entorno;

/**
 *
 * @author carme
 */
public abstract class Instruccion {
    public int fila;
    public int columna;
    
    // 
    public Instruccion(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }
    
    // este metodo sera implementado
    public abstract void ejecutar(Entorno entorno) throws Exception;
    
}
