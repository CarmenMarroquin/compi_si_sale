/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorCJ.graficas;

import interprete.expresiones.Expresion;
import java.awt.Color;
import java.awt.Rectangle;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author carme
 */
public class DiagramaSet extends JPanel {
    public Color colorArea; 
    public Expresion expr;
    public ArrayList<String> nombreConjuntos;

    public DiagramaSet(ArrayList<String> nombreConjuntos, Expresion expr, Color setColor){
        
        this.nombreConjuntos = nombreConjuntos;
        this.expr = expr;
        this.colorArea = setColor;
    }
}
