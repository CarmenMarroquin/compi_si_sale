/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interprete.sentencias;

import interprete.herramientas.Entorno;
import interprete.lenguaje.Instruccion;

/**
 *
 * @author carme
 */
public abstract class Sentencia extends Instruccion {
    
    public Sentencia(int fila, int columna){
        super(fila, columna);
        
    }
    
        
    public abstract void interpretar(Entorno entorno) throws Exception ;
    
    @Override
    public void ejecutar(Entorno entorno) throws Exception {
        
        interpretar(entorno);
    }
}
