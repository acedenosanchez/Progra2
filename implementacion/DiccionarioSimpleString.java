package implementacion;

import tdas.ConjuntoStringTDA;
import tdas.DiccionarioSimpleStringTDA;
import tdas.DiccionarioSimpleTDA;

public class DiccionarioSimpleString implements DiccionarioSimpleStringTDA {

	class nodo{
		String periodo;
		DiccionarioSimpleTDA precipitacionesMes;
		nodo siguiente;
	}
	
	private nodo primero;
	
	@Override
	public void inicializarDiccionario() {
		primero = null;
	}

	@Override
	public void agregar(String periodo, int dia, int cantidad) {
		nodo actual = primero;
		boolean existe = false;
		DiccionarioSimpleTDA d1 = new DiccionarioSimple();
		while(actual!=null && !existe){
			if(actual.periodo.equals(periodo)){
				actual.periodo=periodo;
				existe = true;
			}
			actual = actual.siguiente;
		}
		if(!existe){
			nodo aux = new nodo();
			aux.periodo = periodo;
			aux.precipitacionesMes.agregar(dia,cantidad);
			aux.siguiente = primero;
			primero = aux;
		}


	}

	@Override
	public void eliminar(String periodo) {
		nodo actual = primero;
		nodo anterior = null;
		boolean existe = false;
		while(actual!=null && !existe){
			if(actual.periodo.equals(periodo)){
				if(anterior==null){
					primero=primero.siguiente;
				}
				else {
					anterior.siguiente=actual.siguiente;
				}
				existe = true;
			}
			anterior=actual;
			actual=actual.siguiente;
		}

	}

	@Override
	public DiccionarioSimpleTDA recuperar(String periodo) {
		DiccionarioSimpleTDA resultado = new DiccionarioSimple();
		nodo actual = primero;
		boolean existe = false;
		while(actual!=null && !existe){
			if(actual.periodo.equals(periodo)){
				resultado=actual.precipitacionesMes;
				existe = true;
			}
			actual=actual.siguiente;
		}
		return resultado;

	}

	@Override
	public ConjuntoStringTDA claves() {
		ConjuntoStringTDA c1 = new ConjuntoString();
		nodo actual = primero;
		while(actual!=null){
			c1.agregar(actual.periodo);
			actual=actual.siguiente;
		}
		return c1;

	}
}
