/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interprete.sentencias;

import interprete.herramientas.Conjunto;
import interprete.herramientas.Entorno;
import interprete.herramientas.Simbolo;
import interprete.herramientas.Tipo;

/**
 *
 * @author carme
 */
public class Conj extends Sentencia{
    public String id;
    public Conjunto conjunto;
    
    public Conj(int fila, int columna, String id, Conjunto conjunto){
        super(fila, columna);
        this.id = id;
        this.conjunto = conjunto;
    }
    
    
    @Override
    public void interpretar(Entorno entorno) throws Exception {
        Simbolo nuevoSimbolo = new Simbolo(fila, columna, id, conjunto, entorno, Tipo.CONJ);
        try{

            entorno.setSimbolo(nuevoSimbolo);
        } catch(Exception e){
            // TODO guardar eror 
        }
        

    }
}
