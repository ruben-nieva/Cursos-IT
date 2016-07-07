package demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="docente")
public class Docente {
	
	@Id
	String idDocente;
	
	String dni;	
	String nombre;
	String apellido;	
	String telefono;
	
	public Docente(){}
	
	public Docente(String dni, String nombre, String apellido, String telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Docente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + "]";
	}

	public String getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(String idDocente) {
		this.idDocente = idDocente;
	}
	

}
