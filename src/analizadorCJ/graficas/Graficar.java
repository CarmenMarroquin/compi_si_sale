/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorCJ.graficas;

import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 *
 * @author carmen
 * matrices
 *** tener un numero limitado
 ****** max 4

 *** Usar Graphics2D para encontrar las intersecciones entre las necesarias
 *** Usarlo de forma recursiva. (pasando contexto de cada una)
 * 
 * 
 */
public interface Graficar {
    Area dibujar(ArrayList<Ellipse2D> conjuntos, ArrayList<String> nombreConjs);
}
