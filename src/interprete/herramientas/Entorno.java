/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interprete.herramientas;


import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author carme
 */
public class Entorno {
    public String nombre;
    public Entorno padre;
    public HashMap<String, Simbolo> tabla;
    public boolean global;
    
    public Entorno(Entorno padre, String nombre){
        this.padre = padre;
        this.global = false;
        this.tabla = new HashMap<>();
        this.nombre = nombre;
    }
    
    public Entorno(){
        this.padre = null;
        this.global = true;
        this.nombre = "global";
        this.tabla = new HashMap<>();
        setConsoleVar();
    }
    
    private void setConsoleVar(){
        ArrayList<String> console = new ArrayList<>();
        Simbolo nuevo = new Simbolo(0, 0, "PRINT",  console, this, Tipo.NATIVE);
        this.setSimbolo(nuevo);
    }
    
    public Entorno getGlobalEnv(){
        if (this.padre != null){
            return this.padre.getGlobalEnv();
        }
        return this;
    }
    
    public void setSimbolo(Simbolo simbolo){
        try{
            Entorno ent = this.resolveSimbolo(simbolo);
            
            ent.updateSimbolo(simbolo);
            
            // TODO, la variable ya esta declarada en el entorno
         } catch(Exception e){
             simbolo.entorno = this;
             this.tabla.put(simbolo.id, simbolo);
         }
    }
    
    public void updateSimbolo(Simbolo simbolo) throws  Exception{

         Entorno ent = this.resolveSimbolo(simbolo);
            
         Simbolo variable = ent.tabla.get(simbolo.id);
         variable.conjunto = simbolo.conjunto;

    }
    
    public Simbolo getSimbolo(Simbolo simbolo) throws  Exception{
        Entorno ent = this.resolveSimbolo(simbolo);
        
        return ent.tabla.get(simbolo.id);
        

    }
    
    public Entorno resolveSimbolo(Simbolo simbolo) throws Exception{
        
        if (this.tabla.containsKey(simbolo.id)){
            return this;
        }
        
        if (this.padre == null){
            // TODO nuevo error semantico
            throw new Exception("No se puede resolver");
        }
        
        return  this.padre.resolveSimbolo(simbolo);
    }
    
}
