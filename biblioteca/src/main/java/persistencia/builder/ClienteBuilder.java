package persistencia.builder;

import dominio.Cliente;
import dominio.Libro;
import persistencia.entitad.ClienteEntity;
import persistencia.entitad.LibroEntity;

public class ClienteBuilder {

	public ClienteBuilder (){}
	
	
	public static Cliente convertirADominio(ClienteEntity clienteEntity) {
		Cliente cliente = null;
		if(clienteEntity != null) {
			cliente = new Cliente(clienteEntity.getNombreUsuario(),clienteEntity.getCedula());
		}
		return cliente;
	}
	
	public static ClienteEntity convertirAEntity(Cliente cliente) {
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setNombreUsuario(cliente.getNombreUsuario());
		clienteEntity.setCedula(cliente.getCedula());
		return clienteEntity;
	}
}
