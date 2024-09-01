/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interprete.expresiones;

import analizadorCJ.graficas.Graficar;
import interprete.herramientas.Conjunto;
import interprete.herramientas.Entorno;
import interprete.lenguaje.Instruccion;

/**
 *
 * @author carme
 */
public abstract class Expresion extends Instruccion implements Graficar{
    
    public Expresion(int fila, int columna){
        super(fila, columna);
    }
    
    public abstract Conjunto evaluar(Entorno entorno) throws Exception;
    
    @Override
    public void ejecutar(Entorno entorno) throws Exception{
       
        evaluar(entorno);
    }
    
}
