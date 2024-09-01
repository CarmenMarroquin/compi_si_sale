/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interprete.sentencias;

import interprete.herramientas.Conjunto;
import interprete.herramientas.Entorno;
import interprete.herramientas.Simbolo;
import interprete.herramientas.Tipo;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author carme
 */
public class Evaluar extends Sentencia{
    public ArrayList<Character> charactersList;
    public String id;

    public Evaluar(int fila, int columna, ArrayList<Character> characters, String id) {
        super(fila, columna);
        this.charactersList = characters;
        this.id = id;
    }

    @Override
    public void interpretar(Entorno entorno) throws Exception {

        Simbolo temp = new Simbolo(0, 0, this.id, new Conjunto(), entorno, Tipo.OPERA);
        Simbolo simbolo;
        // Simbolo del conjunto a buscar
        simbolo = entorno.getSimbolo(temp);
        imprimirLinea("=========================", entorno);
        imprimirLinea("Evaluar: " + this.id, entorno);
        imprimirLinea("=========================", entorno);
        // copia de los caracteres a evaluar
        HashSet<Character> hashSetChars = new HashSet<>(this.charactersList);
        
        if (simbolo.conjunto.itemsSet.containsAll(hashSetChars)) {
            for (Character ch : hashSetChars){
                imprimirLinea(ch + "-> Exitoso" , entorno);
            }

        } else {
            // Creamos una copia de diferencia
            HashSet<Character> diferencia = new HashSet<>(hashSetChars);
            diferencia.removeAll(simbolo.conjunto.itemsSet);
            
            HashSet<Character> correctos = new HashSet<>(hashSetChars);
            correctos.removeAll(diferencia);
            
           for (Character ch : correctos){
                imprimirLinea(ch + "-> Exitoso" , entorno);
            }
           for (Character ch : diferencia){
                imprimirLinea(ch + "-> Fallido" , entorno);
            }
           
        }
        imprimirLinea("=========================", entorno);
        
    }
    
            
    private void imprimirLinea(String linea, Entorno entorno){

        try {
            Simbolo temp1 = new Simbolo(0, 0, "PRINT", new Object(), entorno, Tipo.NATIVE);
            ((ArrayList<String>) entorno.getSimbolo(temp1).obj).add(linea);

        } catch(Exception e){
            
        }
    }   
}
