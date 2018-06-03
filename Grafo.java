
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hecto
 */
public class Grafo {
    private HashMap<Integer, Arco> arcos;
    private HashMap<String, Vertice> vertices;

public Grafo(){
    this.vertices = new HashMap<String, Vertice>();
    this.arcos = new HashMap<Integer, Arco>();
}
public Grafo(ArrayList<Vertice> vertices){
    this.arcos = new HashMap<Integer, Arco>();
    this.vertices = new HashMap<String, Vertice>();
    
    for (Vertice v: vertices){
        this.vertices.put(v.getNombre(), v);
    }
 }

public boolean agregarArco(Vertice v1, Vertice v2, int peso){
    if (v1.equals(v2)){
        return false;
    } else{
        Arco a = new Arco(v1,v2,peso);
        if (arcos.containsKey(a.hashCode())){
            return false;
        }else if(v1.contains(a) || v2.contains(a)){
            return false;
        }
        
        arcos.put(a.hashCode(), a);
        v1.agregar(a);
        v2.agregar(a);
        return true;
    }
}

public boolean containsArco(Arco a){
    if (a.getV1() == null || a.getV2() == null){
        return false;
    }
    
    return this.arcos.containsKey(a.hashCode());
}

public Arco removeArco(Arco a){
    a.getV1().removeArco(a);
    a.getV2().removeArco(a);
    return this.arcos.remove(a.hashCode());
}

public Vertice getVertice(String nombre){
    return vertices.get(nombre);
}

public boolean agregarVertice(Vertice vertice, boolean existente){
    Vertice v = this.vertices.get(vertice.getNombre());
    if (v != null){
        if(!existente){
            return false;
        }
        
        while(v.getCount() > 0){
            this.removeArco(v.getArco(0));
        }
    }
    
    vertices.put(vertice.getNombre(), vertice);
    return true;
}

public Vertice removeVertice(String nombre){
    Vertice v = vertices.remove(nombre);
    while (v.getCount() > 0){
        this.removeArco(v.getArco(0));
    }
    return v;
}

public Set<String> verticeKeys(){
    return this.vertices.keySet();
}

public Set<Arco> getArcos(){
    return new HashSet<Arco>(this.arcos.values());
}

public boolean containsVertice(String vertice){
    if(this.vertices.get(vertice) != null){
        return true;
    } else {
        return false;
    }
}
}
