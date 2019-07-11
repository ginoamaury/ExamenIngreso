package dominio;

public class Cliente {
 private String nombreUsuario;
 private String cedula;
 
 
  public Cliente (String nombreUsuario, String cedula){
	  this.cedula = cedula;
	  this.nombreUsuario = nombreUsuario;
  }


public String getNombreUsuario() {
	return nombreUsuario;
}


public void setNombreUsuario(String nombreUsuario) {
	this.nombreUsuario = nombreUsuario;
}


public String getCedula() {
	return cedula;
}


public void setCedula(String cedula) {
	this.cedula = cedula;
}
  
  
}
