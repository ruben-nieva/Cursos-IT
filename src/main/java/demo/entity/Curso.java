package demo.entity;


import java.util.Date;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="curso")
public class Curso{
	
	@Id
	private String codCurso;
	
	@Field(value="nombre")
	private String nombre;
	
	private String descripcion;
	
    private Date fechaInicio;
	 
    private Date fechaFin;
    
    private int duracion;
    
    private int costo;
    
    private String nivel;
    
    private String imagen;

    private Docente docente;
    
    private List<Alumno> alumnos;
    
    public Curso(){
    	
    	imagen="default.png";
    	//alumnos = new LinkedList<Alumno>();
    }    

	public Curso(String nombre, String descripcion, Date fechaInicio, Date fechaFin, int duracion, String nivel,
			Docente docente) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.duracion = duracion;
		this.nivel = nivel;
		this.docente = docente;
	}

	public String getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}	
	
	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", duracion=" + duracion + ", costo=" + costo + ", nivel=" + nivel
				+ ", imagen=" + imagen + ", docente=" + docente + "]";
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public void addAlumno(Alumno al){
		
		this.alumnos.add(al);
	}
	
	public void deleteAlumno(Alumno al){			
				
//		this.alumnos.remove(al);
		this.alumnos.remove(1);
		
			
	}
	
	

}
