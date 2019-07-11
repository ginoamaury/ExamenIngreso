package testdatabuilder;

import dominio.Cliente;
import dominio.Libro;

public class ClienteTestDataBuldier {
	private static final String NOMBREUSUARIO = "Gino Amaury Gongora";
	private static final String CEDULA = "1090506420";
	
	private String nombreUsuario;
	private String cedula;
	
	public ClienteTestDataBuldier() {
		super();
		this.nombreUsuario = NOMBREUSUARIO;
		this.cedula = CEDULA;
	}
	 
	public ClienteTestDataBuldier conNombre(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
		return this;
	}
	
	public ClienteTestDataBuldier conCedula(String cedula) {
		this.cedula = cedula;
		return this;
	}
	
	public Cliente build() {
		return new Cliente (this.nombreUsuario, this.cedula);
	}
	
}
