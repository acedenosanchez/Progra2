package implementacion;

import java.util.Random;
import tdas.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {
	
	class nodo {
		int valor;
		nodo siguiente;
	}
	
	private nodo primero;
	private int cantidad;
	private Random r;
	
	@Override
	public void inicializar() {
		 new nodo();
		 cantidad = 0;
		 primero=null;
	}

	@Override
	public void agregar(int valor) {
		if (!pertenece(valor)){
			nodo aux = new nodo();
			aux.valor = valor;
			aux.siguiente = primero;
			primero = aux;
			cantidad++;
		}
	}

	@Override
	public boolean pertenece(int valor) {
		nodo nodoActual = primero;
		while (nodoActual != null) {
			if (nodoActual.valor == valor) {
				return true;
			}
			nodoActual = nodoActual.siguiente;
		}
		return false;
	}

		@Override
	public void sacar(int valor) {
			nodo nodoActual = primero;
			nodo nodoAnterior = null;
			boolean encontrado = false;
			while (!encontrado && nodoActual != null) {
				if (nodoActual.valor == valor) {
					if(nodoAnterior == null){
						primero=nodoActual.siguiente;
					}
					else{
						nodoAnterior.siguiente=nodoActual.siguiente;
						nodoActual=nodoActual.siguiente;
					}
					encontrado=true;
					cantidad--;
				}
				nodoAnterior = nodoActual;
				nodoActual=nodoActual.siguiente;
			}
	}

	@Override
	public int elegir() {
		r= new Random();
		int posicion = r.nextInt(cantidad);
		nodo nodoActual = primero;
		while (posicion>0){
			nodoActual = nodoActual.siguiente;
			posicion--;
		}
		return nodoActual.valor;
	}

	@Override
	public boolean estaVacio() {

		return primero==null;

	}

}