package implementacion;

import java.util.Random;
import tdas.ConjuntoStringTDA;

public class ConjuntoString implements ConjuntoStringTDA {

	class nodo {
		String valor;
		nodo siguiente;
	}

	private nodo primero;
	private int cantidad;
	private Random r;

	@Override
	public void inicializar() {
		new nodo();
		cantidad = 0;
		primero = null;
	}

	@Override
	public void agregar(String valor) {
		if (!pertenece(valor)) {
			nodo aux = new nodo();
			aux.valor = valor;
			aux.siguiente = primero;
			primero = aux;
			cantidad++;
		}
	}

	@Override
	public void sacar(String valor) {
		nodo nodoActual = primero;
		nodo nodoAnterior = null;
		boolean encontrado = false;
		while (!encontrado && nodoActual != null) {
			if (nodoActual.valor.equals(valor)) {
				if(nodoAnterior ==null){
					primero=nodoActual.siguiente;
				}
				else{
					nodoAnterior.siguiente=nodoActual.siguiente;
					nodoActual=nodoActual.siguiente;
				}
				encontrado=true;
				cantidad--;
			}
			nodoAnterior=nodoActual;
			nodoActual=nodoActual.siguiente;
		}
	}

	@Override
	public String elegir() {
		r=new Random();
		int posicion = r.nextInt(cantidad);
		nodo nodoActual = primero;
		while(posicion>0){
			nodoActual=nodoActual.siguiente;
			posicion--;
		}
		return nodoActual.valor;

	}

	@Override
	public boolean pertenece(String valor) {
		nodo nodoActual = primero;
		while (nodoActual != null) {
			if (nodoActual.valor.equalsIgnoreCase(valor)) {
				return true;
			}
			nodoActual = nodoActual.siguiente;
		}
		return false;

	}

	@Override
	public boolean estaVacio() {
		return primero == null;

	}

}

