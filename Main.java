
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hecto
 */
public class Main {
    public static void main(String[] args) throws IOException{
        Scanner stdin = new Scanner(System.in);
        GrafoGuate g = new GrafoGuate();
        boolean x = true;
        while (x){
            System.out.println("Menu");
            System.out.println("1. Ruta mas corta");
            System.out.println("2. Nombre de la ciudad que queda en el centro del grafo");
            System.out.println("3. Interrumpcion de trafico ");
            System.out.println("4. Crear relacion entre 2 ciudades con km de distancia");
            System.out.println("5. Terminar el programa");
            
            int op = stdin.nextInt();
            if(op ==1){
                System.out.println("Ciudades");
                for(int i = 0; i< g.ciudades.size(); i++){
                    System.out.println(i+". "+g.ciudades.get(i).getNombre());
                }
                System.out.println("Ciudad 1");
                int start = stdin.nextInt();
                System.out.println("Ciudad 2");
                int end = stdin.nextInt();
                g.findShortestPath(start, end);
            }
            if (op == 2){
                
            }
            if (op == 3){
                System.out.println("Ciudades");
                for(int i = 0; i< g.ciudades.size(); i++){
                    System.out.println(i+". "+g.ciudades.get(i).getNombre());
                }
                System.out.println("Ciudad 1");
                String ciudad1 = stdin.next();
                System.out.println("Ciudad 2");
                String ciudad2 = stdin.next();
                g.interrumpir(ciudad1, ciudad2);
                System.out.println("Se ha interrumpido");
            }
            if (op == 4){
                System.out.println("Ciudad 1");
                String ciudad1 = stdin.next();
                System.out.println("Ciudad 2");
                String ciudad2 = stdin.next();
                System.out.println("Ingrese la distancia en KM");
                int km = stdin.nextInt();
                g.agregarRelacion(ciudad1, ciudad2, km);
            }
            if (op == 5){
                System.out.println("Fin");
                x = false;
            }
        }
    }
}
