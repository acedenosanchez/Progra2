package Test;

import implementacion.Conjunto;
import tdas.ConjuntoTDA;

public class TestConjunto {
    public static void main(String[] args) {
        ConjuntoTDA aux = new Conjunto();
        aux.inicializar();
        aux.agregar(10);
        aux.agregar(15);
        aux.agregar(20);
        aux.agregar(25);
        aux.agregar(30);
        aux.agregar(35);
        aux.agregar(30);

        while(!aux.estaVacio()){
            int valor = aux.elegir();
            System.out.println(valor);
            aux.sacar(valor);
        }
    }


}
