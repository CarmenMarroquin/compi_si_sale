/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interprete.herramientas;

/**
 *
 * @author carme
 */
public class Simbolo {
    public String id;
    public Conjunto conjunto;
    public int fila;
    public int columna;
    public Entorno entorno;
    public Tipo tipo;
    public Object obj;
        
    public Simbolo(int fila, int columna, String id, Conjunto conjunto, Entorno entorno, Tipo tipo){
        this.fila = fila;
        this.columna = columna;
        this.id = id;
        this.conjunto = conjunto;
        this.entorno = entorno;
        this.tipo = tipo;
    }
    
    public Simbolo(int fila, int columna, String id, Object obj, Entorno entorno, Tipo tipo){
        
        this.fila = fila;
        this.columna = columna;
        this.id = id;
        this.obj = obj;
        this.entorno = entorno;
        this.tipo = tipo;
    }
    
}
