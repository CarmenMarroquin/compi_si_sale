/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorCJ.graficas;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author zibas
 */
public class ImagenPanel extends JPanel{
	private BufferedImage imagen;

	public ImagenPanel(BufferedImage imagen) {
		this.imagen = imagen;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (imagen != null) {
			g.drawImage(imagen, 0, 0, this);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(imagen.getWidth(), imagen.getHeight());
	}
}
