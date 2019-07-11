package dominio.repositorio;

import dominio.Cliente;

public interface RepositorioCliente {

	
	/**
	 * Permite agregar un cliente al repositorio
	 * @param Cliente
	 */
	void agregar(Cliente cliente);
}
