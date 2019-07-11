package persistencia.repositorio;

import javax.persistence.EntityManager;

import dominio.Cliente;
import dominio.repositorio.RepositorioCliente;
import persistencia.builder.ClienteBuilder;
import persistencia.builder.LibroBuilder;

public class RepositorioClientePersistente implements RepositorioCliente {

	private EntityManager entityManager;
	
	
	public RepositorioClientePersistente(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}	
	
	@Override
	public void agregar(Cliente cliente) {
		// TODO Auto-generated method stub
		entityManager.persist(ClienteBuilder.convertirAEntity(cliente));
		
	}

}
