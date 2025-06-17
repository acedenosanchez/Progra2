package Test;

import implementacion.ColaPrioridad;
import tdas.ColaPrioridadTDA;

public class TestColaPrioridad {
    public static void main(String[] args) {
        ColaPrioridadTDA cola = new ColaPrioridad();
        cola.inicializarCola();
        cola.acolarPrioridad(10,1);
        cola.acolarPrioridad(30,5);
        cola.acolarPrioridad(24,6);
        cola.acolarPrioridad(10,7);
        cola.acolarPrioridad(50,1);
        cola.acolarPrioridad(160,6);
        cola.acolarPrioridad(105,8);

        while(!cola.colaVacia()){
            System.out.println("El valor es " + cola.primero() + " La prioridad es " + cola.prioridad());
            cola.desacolar();
        }
    }
}
