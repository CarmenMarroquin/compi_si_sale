/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorCJ.graficas;
import interprete.expresiones.Expresion;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Diagrama4Set extends DiagramaSet {


    public Diagrama4Set(Color setColor, Expresion expr, ArrayList<String> nConjs) {
        super(nConjs, expr, setColor);
       
    }


	@Override
	protected void dibujarDiagrama(Graphics2D g2d, int width, int height){
        // Crear cuatro conjuntos como círculos
        ArrayList<Ellipse2D> elipses = new ArrayList<>();
        Ellipse2D circle1 = new Ellipse2D.Double(150, 100, 200, 200);
        Ellipse2D circle2 = new Ellipse2D.Double(250, 100, 200, 200);
        Ellipse2D circle3 = new Ellipse2D.Double(150, 200, 200, 200);
        Ellipse2D circle4 = new Ellipse2D.Double(250, 200, 200, 200);

        elipses.add(circle1);
        elipses.add(circle2);
        elipses.add(circle3);
        elipses.add(circle4);
		
        Area result = this.expr.dibujar(elipses, nombreConjuntos);

        g2d.setPaint(this.colorArea);
        g2d.fill(result);

        g2d.setColor(Color.BLACK);
        g2d.draw(circle1);
        g2d.draw(circle2);
        g2d.draw(circle3);
        g2d.draw(circle4);


	}
}
