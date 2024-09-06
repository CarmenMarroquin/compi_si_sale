/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorCJ.graficas;

import interprete.expresiones.Expresion;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author zibas
 */
public class Diagrama0Set extends DiagramaSet {

	public Diagrama0Set(ArrayList<String> nombreConjuntos, Expresion expr, Color setColor, String opName) {
		super(nombreConjuntos, expr, setColor, opName);
	}

	@Override
	protected void dibujarDiagrama(Graphics2D g2d, int width, int height) {
		// Dibujar un conjunto como un solo círculo

		Rectangle universo = new Rectangle(10, 40, 470, 440);
		g2d.draw(universo);

		dibujarTexto(g2d, "Muchos conjuntos, no graficar", 150, 150, new Font("Arial", Font.PLAIN, 14));

		dibujarTexto(g2d, this.opName, 80, 30, new Font("Arial", Font.BOLD, 16));

	}

}
