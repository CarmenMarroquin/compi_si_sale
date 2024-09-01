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
    public Expresion  exp2;

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
    
}
