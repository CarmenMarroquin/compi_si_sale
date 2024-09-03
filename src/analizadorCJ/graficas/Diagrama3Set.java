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

    public Diagrama3Set(Color setColor, Expresion expr, ArrayList<String> nConjs, String opName) {
        super(nConjs, expr, setColor, opName);
    }


	@Override
	protected void dibujarDiagrama(Graphics2D g2d, int width, int height){
        // Crear tres conjuntos como círculos
        ArrayList<Ellipse2D> elipses = new ArrayList<>();
        Ellipse2D circle1 = new Ellipse2D.Double(150, 100, 200, 200);
        Ellipse2D circle2 = new Ellipse2D.Double(250, 100, 200, 200);
        Ellipse2D circle3 = new Ellipse2D.Double(200, 200, 200, 200);
        elipses.add(circle1);
        elipses.add(circle2);
        elipses.add(circle3);

        Area result = this.expr.dibujar(elipses, nombreConjuntos);


        g2d.setPaint(this.colorArea);
        g2d.fill(result);


        g2d.setColor(Color.BLACK);
        g2d.draw(circle1);
        g2d.draw(circle2);
        g2d.draw(circle3);

        Rectangle universo = new Rectangle(10, 40, 470, 440);
		g2d.draw(universo);

		dibujarTexto(g2d, nombreConjuntos.get(0), 100, 100, new Font("Arial", Font.PLAIN, 14));
		dibujarTexto(g2d, nombreConjuntos.get(1), 380, 100, new Font("Arial", Font.PLAIN, 14));
		dibujarTexto(g2d, nombreConjuntos.get(2), 250, 450, new Font("Arial", Font.PLAIN, 14));

		dibujarTexto(g2d, this.opName, 80, 30, new Font("Arial", Font.BOLD, 16));

	}
}
