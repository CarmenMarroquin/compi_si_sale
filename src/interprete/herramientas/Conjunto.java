/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interprete.herramientas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author carme
 */
public class Conjunto {
    private ArrayList<Character> items;

    public Set<Character> itemsSet;
    // amor no se escribir
    public Conjunto(ArrayList<Character> items){
        this.items = items;
        this.itemsSet = new HashSet<>(items);
    }
    
    public Conjunto(){
        this.items = new ArrayList<Character>();
        this.itemsSet = new HashSet<>();
    }

    
    public void agregar(Character item){
        this.items.add(item);
        this.itemsSet.add(item);
    }
    
    public void rango(Character start, Character end){
        for (int i = (int) start; i <= (int) end; i++){
            this.items.add((char) i);
            this.itemsSet.add((char) i);
        }
    }
}
