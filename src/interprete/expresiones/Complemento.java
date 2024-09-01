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
public class Complemento extends Expresion{
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
         Rectangle universo = new Rectangle(50, 50, 500, 500);
        
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
