/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorCJ.graficas;
import interprete.expresiones.Expresion;
import interprete.herramientas.Conjunto;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Diagrama1Set extends DiagramaSet {
    public Diagrama1Set(Color setColor, Expresion exp, ArrayList<String> nConjs) {
        super(nConjs, exp, setColor);

    }
    

	@Override
	protected void dibujarDiagrama(Graphics2D g2d, int width, int height){
        // Dibujar un conjunto como un solo círculo
        ArrayList<Ellipse2D> elipses = new ArrayList<>();
        Ellipse2D circle1 = new Ellipse2D.Double(150, 150, 200, 200);
        elipses.add(circle1);
        
        Area result = this.expr.dibujar(elipses, nombreConjuntos);
        
        g2d.setColor(Color.BLACK);
        g2d.draw(circle1);

        g2d.setPaint(this.colorArea);
        g2d.fill(result);
		
	}
}
