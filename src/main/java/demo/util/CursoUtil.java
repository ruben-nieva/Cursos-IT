package demo.util;

import demo.entity.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CursoUtil {

	private static String[] listaCursos = { "Angular", "Seguridad WEB", "NodeJS", "Linux", "Android",
			"GIT", "HTML5", "JavaScript", "Spring Boot", "Excel", "MongodDB", "PuntoNet", "Kubernetes" };
	
	private static String[] listaImagenes = { "curso-angular.jpg", "curso-seguridad.jpg", "curso-nodejs.jpg", "curso-linux.jpg", "curso-android.jpg",
			"curso-git.jpg", "curso-html5.jpg"};
	
//	private static String[] tags = { "Seguridad", "Base de Datos", "Sistemas Operativos", "Programacion" };
	
	private static String[] nivel = { "Basico", "Inicial", "Intermedio", "Avanzado", "Ninja" };
	
	public static List<Curso> create(int size) {
		List<Curso> cursos = new LinkedList<Curso>();
		for (int x = 0; x < size; x++) {
			cursos.add(CursoUtil.create());
		}
		return cursos;
	}

	public static Curso create() {
		Curso curso = new Curso();
		Date fecha= new Date();
		
		curso.setNombre(listaCursos[ThreadLocalRandom.current().nextInt(1, listaCursos.length-1)]);
		
		curso.setDescripcion("Todo lo que necesita saber de " + curso.getNombre());

     	curso.setDuracion(ThreadLocalRandom.current().nextInt(4, 12)*10); //Entre 40 y 120hs
     	
     	curso.setNivel(nivel[ThreadLocalRandom.current().nextInt(0, nivel.length-1)]);

		curso.setFechaInicio(fecha); 
		curso.setFechaFin( SumarFecha(fecha, ThreadLocalRandom.current().nextInt(30, 90))); //entre 1 y 3 meses de duracion
		
		curso.setCosto(ThreadLocalRandom.current().nextInt(10, 65)*100); // Entre 100 y 9500 pesos
		       
		return curso;
	}
	
	public static List<Curso> init() {
		
      List<Curso> cursos = new LinkedList<Curso>();
	  Curso c;
	  Date fecha;
		
	  for (int x = 0; x < 6 && x < listaImagenes.length; x++) {
		
		c= new Curso();		 
		fecha= new Date();
		
		fecha = SumarFecha(fecha, ThreadLocalRandom.current().nextInt(30, 90));
		
		c.setNombre(listaCursos[x]);
		c.setImagen(listaImagenes[x]);
		c.setDescripcion("Todo lo que necesita saber de " + c.getNombre());

	    c.setDuracion(ThreadLocalRandom.current().nextInt(4, 12)*10); //Entre 40 y 120hs
	     	
	    c.setNivel(nivel[ThreadLocalRandom.current().nextInt(0, nivel.length-1)]);

		c.setFechaInicio(fecha); 
		c.setFechaFin( SumarFecha(fecha, ThreadLocalRandom.current().nextInt(30, 90))); //entre 1 y 3 meses de duracion
		c.setCosto(ThreadLocalRandom.current().nextInt(10, 65)*100); // Entre 100 y 9500 pesos
		 
		cursos.add(c);
	  }	
	  
	  return cursos;
		
	}
	
	public static Date SumarFecha( Date fecha, int dias){
	     Calendar cal = new GregorianCalendar();
	     cal.setTimeInMillis(fecha.getTime());
	     cal.add(Calendar.DATE, dias);
	     
	     return new Date(cal.getTimeInMillis());     
	   }
	
}
