package demo.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="alumno")
public class Alumno {
	
	@Id
	private String idAlumno;
	
	private String dni;	
	private String nombre;
	private String apellido;	
	private String telefono;
	private Date fechaNacimiento;	
	
	public Alumno(){}

	public String getDni() {
		return dni;
	}

	public Alumno(String dni, String nombre, String apellido, String telefono, Date fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
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


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	public String getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}
	
	public String getNombreyApellido(){
		
		String str = nombre + " " + apellido; 
		
		return (str);
	}
	
}