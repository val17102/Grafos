/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hecto
 */
public class Arco implements Comparable<Arco>{
    private Vertice v1, v2;
    private int peso;
    public Arco(Vertice v1, Vertice v2){
        this(v1,v2,1);
    }
    
    public Arco(Vertice v1, Vertice v2, int peso){
        this.v1 = (v1.getNombre().compareTo(v2.getNombre()) <= 0) ? v1:v2;
        this.v2 = (this.v1 == v1) ? v2 : v1;
        this.peso = peso;
    }
    
    public int compareTo(Arco otro){
        return this.peso - otro.peso;
    }
    
    public Vertice getRelacion(Vertice a){
        if (!(a.equals(v1) || a.equals(v2))){
            return null;
        }else
            return (a.equals(v1)) ? v2 : v1;
        
    }
    
    public Vertice getV1(){
        return this.v1;
    }
    
    public Vertice getV2(){
        return this.v2;
    }
    
    public int getPeso(){
        return this.peso;
    }
    
    public void setPeso(int peso){
        this.peso = peso;
    }
    
    public boolean equals(Object other){
        if(!(other instanceof Arco)){
            return false;
        }
        Arco a = (Arco)other;
        return a.v1.equals(this.v1) && a.v2.equals(this.v2);
    }
    
    public int hashCode(){
        return (v1.getNombre() + v2.getNombre()).hashCode();
    }
}
