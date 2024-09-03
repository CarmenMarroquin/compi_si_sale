/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorCJ.graficas;

import interprete.expresiones.Expresion;

import java.awt.*;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author carme
 */
public class DiagramaSet extends JPanel {
    public Color colorArea; 
    public Expresion expr;
	public String opName;
    public ArrayList<String> nombreConjuntos;



    public DiagramaSet(ArrayList<String> nombreConjuntos, Expresion expr, Color setColor, String opName){
       	this.opName = opName; 
        this.nombreConjuntos = nombreConjuntos;
        this.expr = expr;
        this.colorArea = setColor;
    }

    public BufferedImage crearImagen(int width, int height){
		BufferedImage imagen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    	Graphics2D g2d = imagen.createGraphics();


		// Configuración básica
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, width, height);

		// Aquí las subclases implementarán la lógica específica de cada diagrama
		dibujarDiagrama(g2d, width, height);

		g2d.dispose();
		return imagen;
    }

	protected void dibujarDiagrama(Graphics2D g2d, int width, int height){

	}

	protected void dibujarTexto(Graphics2D g2d, String texto, int x, int y, Font font){
		g2d.setFont(font);
		g2d.setColor(Color.BLACK);
		g2d.drawString(texto, x, y);
	}


	public void guardarImagen(BufferedImage imagen, String filepath) throws IOException {
		File archivo = new File(filepath);
		ImageIO.write(imagen, "png", archivo);
		
	}
}
