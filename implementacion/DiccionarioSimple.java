package implementacion;

import tdas.ConjuntoTDA;

public class DiccionarioSimple implements tdas.DiccionarioSimpleTDA {

	class nodo{
		int clave;
		int valor;
		nodo siguiente;
	}
	
	private nodo primero;
	
	@Override
	public void inicializar() {
		primero=null;
	}

	@Override
	public void agregar(int clave, int valor) {
		nodo actual = primero;
		boolean encontrado=false;
		while(actual!=null&&!encontrado){
			if(actual.clave==clave){
				actual.valor=valor;
				encontrado=true;
			}
			actual=actual.siguiente;
		}
		if(!encontrado){
			nodo aux=new nodo();
			aux.clave=clave;
			aux.valor=valor;
			aux.siguiente=primero;
			primero=aux;
		}
	}

	@Override
	public void eliminar(int clave) {
		nodo actual = primero;
		nodo anterior = null;
		boolean	encontrado=false;
		while(actual!=null && !encontrado){
			if(actual.clave==clave){
				if(anterior==null){
					primero=primero.siguiente;
				}
				else{
					anterior.siguiente=actual.siguiente;
				}
				encontrado=true;
			}
			anterior=actual;
			actual=actual.siguiente;
		}
	}

	@Override
	public int recuperar(int clave) {
		nodo actual = primero;
		boolean busqueda=false;
		int valor=0;
		while(actual!=null && !busqueda){
			if(actual.clave==clave){
				valor=actual.valor;
				busqueda=true;
			}
			actual=actual.siguiente;
		}
		return valor;
	}

	@Override
	public ConjuntoTDA obtenerClaves() {
		ConjuntoTDA resultado = new Conjunto();
		resultado.inicializar();
		nodo actual = primero;
		while(actual!=null) {
			resultado.agregar(actual.clave);
			actual = actual.siguiente;
		}
		return resultado;

	}

}
