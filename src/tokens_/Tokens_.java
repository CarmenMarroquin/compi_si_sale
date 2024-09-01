/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tokens_;

/**
 *
 * @author carme
 */
public class Tokens_ {
    String lexema;
    String nombre;
    String linea;
    String columna;

    
    
    public Tokens_ (String lexema,String nombre,String linea, String columna){
    
         this. lexema = lexema;
         this.nombre = nombre;
         this.linea = linea;
          this.columna = columna;
    
    }
    
     public String getNombre() {
        return nombre;
    }

    public String getLexema() {
        return lexema;
    }

    public String getLinea() {
        return linea;
    }

    public String getColumna() {
        return columna;
    }
    
}
