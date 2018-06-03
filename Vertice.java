
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hecto
 */
public class Vertice {
    private ArrayList<Arco> at;
    private String nombre;
    
    public Vertice(String nombre){
        this.nombre = nombre;
        this.at = new ArrayList<Arco>();
    }
    
    public void agregar(Arco arco){
        if(this.at.contains(arco)){
            return;
        } else
            this.at.add(arco);
    }
    
    public Arco getArco(int i){
        return this.at.get(i);
    }
    
    public Arco removeArco(int i){
        return this.at.remove(i);
    }
    
    public void removeArco(Arco a){
        this.at.remove(a);
    }
    
    public int getCount(){
        return this.at.size();
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public ArrayList<Arco> getAt(){
        return new ArrayList<Arco>(this.at);
    }
    
    public boolean contains(Arco otro){
        return this.at.contains(otro);
    }
}
