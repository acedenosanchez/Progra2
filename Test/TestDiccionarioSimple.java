package Test;

import implementacion.Conjunto;
import implementacion.DiccionarioSimple;
import tdas.ConjuntoTDA;
import tdas.DiccionarioSimpleTDA;

public class TestDiccionarioSimple {
    public static void main(String[] args) {
        DiccionarioSimpleTDA d1 = new DiccionarioSimple();
        d1.inicializar();
        d1.agregar(10,10);
        d1.agregar(10,30);
        d1.agregar(50,40);
        d1.agregar(40,30);
        d1.agregar(30,20);
        d1.agregar(20,10);

        ConjuntoTDA claves = d1.obtenerClaves();

        while(!claves.estaVacio()){
            int claveABuscar=claves.elegir();
                System.out.println("Clave: " + claveABuscar + " Valor: " + d1.recuperar(claveABuscar));
                claves.sacar(claveABuscar);
        }
    }
}
