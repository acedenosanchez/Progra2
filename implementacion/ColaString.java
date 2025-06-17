package implementacion;

import tdas.ColaStringTDA;

public class ColaString implements ColaStringTDA {

	class nodo{
		String valor;
		nodo siguiente;
	}
	
	private nodo primero;
	private nodo ultimo;
	
	@Override
	public void inicializarCola() {
		primero= null;
		ultimo= null;

	}

	@Override
	public void acolar(String valor) {
		nodo aux = new nodo();
		aux.valor = valor;
		//Es el primer elemento a acolar
		if(primero==null){
			primero = aux;
			ultimo = aux;
			aux=null;
		}
		else{
			ultimo.siguiente = aux;
			ultimo = aux;
		}

	}

	@Override
	public void desacolar() {
		primero = primero.siguiente;
		if(primero==null){
			ultimo=null;
		}
	}

	@Override
	public String primero() {
		return primero.valor;
	}

	@Override
	public boolean colaVacia() {
		return primero==null;
	}

}
