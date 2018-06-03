/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Set;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hecto
 */
public class GrafoTest {
    
    public GrafoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of agregarArco method, of class Grafo.
     */
    @Test
    public void testAgregarArco() {
        System.out.println("agregarArco");
        Vertice v1 = new Vertice("Hola");
        Vertice v2 = new Vertice("Hola2");
        int peso = 0;
        Grafo instance = new Grafo();
        boolean expResult = true;
        boolean result = instance.agregarArco(v1, v2, peso);
        assertEquals(expResult, result);
    }

    /**
     * Test of containsArco method, of class Grafo.
     */
    @Test
    public void testContainsArco() {
        System.out.println("containsArco");
        Vertice v1 = new Vertice("Hola");
        Vertice v2 = new Vertice("Hola2");
        int peso = 0;
           Grafo instance = new Grafo();
        boolean result2 = instance.agregarArco(v1, v2, peso);
        Arco a = new Arco(v1,v2,peso);
        boolean expResult = true;
        boolean result = instance.containsArco(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }



    /**
     * Test of agregarVertice method, of class Grafo.
     */
    @Test
    public void testAgregarVertice() {
        System.out.println("agregarVertice");
        Vertice vertice = new Vertice("Nombre");
        boolean existente = false;
        Grafo instance = new Grafo();
        boolean expResult = true;
        boolean result = instance.agregarVertice(vertice, existente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }





    
}
