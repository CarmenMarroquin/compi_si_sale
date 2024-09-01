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

public class Diagrama3Set extends DiagramaSet {

    public Diagrama3Set(Color setColor, Expresion expr, ArrayList<String> nConjs) {
        super(nConjs, expr, setColor);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Crear tres conjuntos como círculos
        ArrayList<Ellipse2D> elipses = new ArrayList<>();
        Ellipse2D circle1 = new Ellipse2D.Double(150, 100, 200, 200);
        Ellipse2D circle2 = new Ellipse2D.Double(250, 100, 200, 200);
        Ellipse2D circle3 = new Ellipse2D.Double(200, 200, 200, 200);
        elipses.add(circle1);
        elipses.add(circle2);
        elipses.add(circle3);


        Area result = this.expr.dibujar(elipses, nombreConjuntos);

        g2.setPaint(this.colorArea);
        g2.fill(result);
        
        g2.setColor(Color.BLACK);
        g2.draw(circle1);
        g2.draw(circle2);
        g2.draw(circle3);
    }
}
