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

public class Diagrama2Set extends DiagramaSet {

    
    public Diagrama2Set(Color setColor, Expresion expr, ArrayList<String> nConj, String opName) {
        super(nConj, expr, setColor, opName);
    }

	@Override
	protected void dibujarDiagrama(Graphics2D g2d, int width, int height){
        // Crear dos conjuntos como círculos
        ArrayList<Ellipse2D> elipses = new ArrayList<>();
        Ellipse2D circle1 = new Ellipse2D.Double(100, 150, 200, 200);
        Ellipse2D circle2 = new Ellipse2D.Double(200, 150, 200, 200);
        elipses.add(circle1);
        elipses.add(circle2);

		// Dibujar las áreas según la expresión
		Area result = this.expr.dibujar(elipses, nombreConjuntos);


		// colorear area
		g2d.setPaint(this.colorArea);
		g2d.fill(result);


		// Dibujar los contornos de los círculos
		g2d.setColor(Color.BLACK);
		g2d.draw(circle1);
		g2d.draw(circle2);

        Rectangle universo = new Rectangle(10, 40, 470, 440);
		g2d.draw(universo);

		dibujarTexto(g2d, nombreConjuntos.get(0), 90, 150, new Font("Arial", Font.PLAIN, 14));
		dibujarTexto(g2d, nombreConjuntos.get(1), 350, 150, new Font("Arial", Font.PLAIN, 14));

		dibujarTexto(g2d, this.opName, 80, 30, new Font("Arial", Font.BOLD, 16));
	}
}
