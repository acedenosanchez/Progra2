package Test;

import implementacion.ColaString;
import tdas.ColaStringTDA;

public class TestColaString {
    public static void main(String[] args) {
        ColaStringTDA cola = new ColaString();
        cola.inicializarCola();

        // Test acolar
        cola.acolar("Uno");
        cola.acolar("Dos");
        cola.acolar("Tres");

        // Test primero + desacolar
        while (!cola.colaVacia()) {
            System.out.println("Primero en la cola: " + cola.primero());
            cola.desacolar();
        }

        // Test cola vacía
        System.out.println("¿La cola está vacía? " + cola.colaVacia()); // true

        // Test desacolar o primero en vacía (si querés probar comportamiento seguro)
        try {
            System.out.println("Intentando acceder a primero en cola vacía:");
            System.out.println(cola.primero()); // Debería manejarse con validación o fallo controlado
        } catch (Exception e) {
            System.out.println("Error controlado: " + e.getMessage());
        }
    }
}

