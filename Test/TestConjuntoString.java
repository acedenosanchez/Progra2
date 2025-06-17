package Test;

import implementacion.ConjuntoString;
import tdas.ConjuntoStringTDA;

public class TestConjuntoString {
    public static void main(String[] args) {
        ConjuntoStringTDA conjunto = new ConjuntoString();
        conjunto.inicializar();

        // Test agregar
        conjunto.agregar("Manzana");
        conjunto.agregar("Pera");
        conjunto.agregar("Banana");
        conjunto.agregar("manzana"); // No debería agregarse si no se permiten duplicados por case-insensitive

        // Test pertenece
        System.out.println("¿Contiene 'Pera'? " + conjunto.pertenece("Pera"));         // true
        System.out.println("¿Contiene 'manzana'? " + conjunto.pertenece("manzana"));   // true
        System.out.println("¿Contiene 'Uva'? " + conjunto.pertenece("Uva"));           // false

        // Test elegir (debería dar alguno de los que están, sin sacarlo)
        System.out.println("Elemento elegido: " + conjunto.elegir());

        // Test sacar
        conjunto.sacar("Pera");
        System.out.println("¿Contiene 'Pera' luego de sacar? " + conjunto.pertenece("Pera")); // false

        // Test sacar algo que no existe (no debería romper)
        conjunto.sacar("Uva");

        // Test estaVacio (debería ser false)
        System.out.println("¿Está vacío? " + conjunto.estaVacio());

        // Vaciar el conjunto
        while (!conjunto.estaVacio()) {
            String elegido = conjunto.elegir();
            conjunto.sacar(elegido);
            System.out.println("Eliminando: " + elegido);
        }

        // Test final de vacío
        System.out.println("¿Está vacío al final? " + conjunto.estaVacio()); // true
    }
}


