
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hecto
 */
public class GrafoGuate {
    
    private Grafo guatemala;
    public ArrayList<Vertice> ciudades;
    
    public GrafoGuate() throws IOException {
        guatemala = new Grafo();
        ciudades = new ArrayList<Vertice>();
        leer();
        
    }
    
    public void leer() throws FileNotFoundException, IOException{
        File f = new File("./guateGrafo.txt");
        FileReader fr = new FileReader(f); 
        BufferedReader br = new BufferedReader(fr);
        String linea;
        int p;
        int d;
        String c1;
        String c2;
        while ((linea = br.readLine())!=null){
            p = 0;
            d = 0;
            c1= "";
            c2 = "";
            for(int i = 0; i<linea.length(); i++){
                if (!" ".equals(linea.substring(i , i+1))){
                    if (p == 0){
                        c1 = c1 + linea.substring(i, i+1);
                    }else if (p==1){
                        c2 = c2 + linea.substring(i, i+1);
                    }else{
                        d = Integer.parseInt(linea.substring(i,linea.length()));
                        break;
                    }
                }else {
                    p++;
                }
            }
            
            agregarRelacion(c1,c2,d);
        }
        br.close();
        fr.close();
    }
    
    public void agregarRelacion(String nombre1, String nombre2, int distancia){
        boolean b;
        Vertice c1 = new Vertice(nombre1);
        Vertice c2 = new Vertice(nombre2);
        if(!guatemala.containsVertice(nombre1)){
            b = guatemala.agregarVertice(c1, true);
            ciudades.add(c1);
        }
        
        if(!guatemala.containsVertice(nombre2)){
            b = guatemala.agregarVertice(c2, true);
            ciudades.add(c2);
        }
        
        b = guatemala.agregarArco(c1, c2, distancia);
    }
    
    public int getRelacion(String nombre1, String nombre2){
        Vertice c1 = guatemala.getVertice(nombre1);
        Vertice c2 = guatemala.getVertice(nombre2);
        if (nombre1 == null ? nombre2 == null : nombre1.equals(nombre2)){
            return 0;
        }
        
        if ((guatemala.containsVertice(nombre1))&&(guatemala.containsVertice(nombre2))){
            for (Arco x: guatemala.getArcos()){
                if ((x.getV1().getNombre() == null ? c2.getNombre() == null : x.getV1().getNombre().equals(c2.getNombre())) && (x.getV2().getNombre() == null ? c1.getNombre() == null : x.getV2().getNombre().equals(c1.getNombre()))){
                return x.getPeso();
            }
                if ((x.getV1().getNombre() == null ? c1.getNombre() == null : x.getV1().getNombre().equals(c1.getNombre())) && (x.getV2().getNombre() == null ? c2.getNombre() == null : x.getV2().getNombre().equals(c2.getNombre()))){   
                return x.getPeso();
                } 
            }
            return 10000;
        }else return 0;
    }
    public void copy(int[][] a, int[][] b){
        for (int i = 0; i < a.length; i++)
            for (int j = 0; i < a[0].length; i++)
                a[i][j] = b[i][j];
    }
    
    public static int min(int a, int b){
        if (a < b)
            return a;
        else
            return b;
    }
    
    public int[][] shortestpath(int [][] adj, int [][] path, int cv){
        int n = cv;
        int[][] ans = new int[n][n];
        copy(ans,adj);
        
        for (int k = 0; k < n; k++){
            for (int i = 0; i < n; i++){
                for(int j = 0; j<n; j++){
                    if (ans[i][k] + ans[k][j] < ans[i][j]){
                        ans[i][j] = ans[i][k] + ans[k][j];
                        path[i][j] = path [k][j];
                    }
                }
            }
        }
        
        return ans;
    }
    
    public void findShortestPath(int start, int end){
        int[][]m = new int[ciudades.size()][ciudades.size()];
        
        for (int x = 0; x < ciudades.size(); x++){
            for (int y = 0; y < ciudades.size(); y++){
                m[x][y] = getRelacion(ciudades.get(x).getNombre(),ciudades.get(y).getNombre());
            }
        }
        
        int[][] shortpath;
        int[][] path = new int[ciudades.size()][ciudades.size()];
        
        for (int i = 0; i< ciudades.size(); i++)
            for (int j = 0; j < ciudades.size(); j++)
                if (m[i][j] == 10000){
                    path[i][j] = -1;
                }else{
                    path[i][j] = i;
                }
        for(int i = 0; i < ciudades.size(); i++)
            path[i][i] = i;
        
        shortpath = shortestpath(m, path, ciudades.size());
        
        String myPath = ciudades.get(end).getNombre() + "";
        int newEnd = end;
        
        while (path[start][end] != start){
            myPath = ciudades.get(path[start][end]).getNombre() + " ---> " + myPath;
            end = path[start][end];
        }
        
        myPath = ciudades.get(start).getNombre() + " ---> "+ myPath;
        System.out.println("El camino mas corto es "+myPath);
        System.out.println("Distancia total: "+shortpath[start][newEnd]);
    }
    
    public void interrumpir(String nombre1, String nombre2){
        Boolean b;
        Vertice c1 = new Vertice(nombre1);
        Vertice c2 = new Vertice(nombre2);
        if ((guatemala.containsVertice(nombre1)) && (guatemala.containsVertice(nombre2))){
            guatemala.removeArco(new Arco(c1,c2));
        }
    }
}
