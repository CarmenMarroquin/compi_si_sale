/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interprete.sentencias;

import interprete.herramientas.Entorno;
import java.util.ArrayList;

/**
 *
 * @author carme
 */
public class Encapsulado extends Sentencia{
    public ArrayList<Sentencia> sentencias;
    
    public Encapsulado(int fila, int columna, ArrayList<Sentencia> sentencias){
        super(fila, columna);
        this.sentencias = sentencias;
    }
    
    
    @Override
    public void interpretar(Entorno entorno) throws Exception {

        for (Sentencia sent : this.sentencias){
            sent.interpretar(entorno);
        }

    }
}
