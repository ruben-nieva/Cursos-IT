package demo.util;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import demo.entity.Alumno;

public class AlumnoUtil {
	
	
	private static String[] listaNombres = { "DANIEL", "CHRISTIAN", "NELSON", "JORGE", "JAVIER", "OLGA", "CLARA", "WALTER", "EDWIN",
			"ROSARIO", "CESAR", "MARINA", "GIZELLA", "ZARITA", "CARLOS", "FLOR", "ROBERTO", "ELENA", "OSCAR", "ELIZABETH" , "LEANDRO"};
			
	private static String[] listaApellidos = { "ACEVEDO", "HERNANDEZ", "CASTILLO", "TORRES", "VILLEGAS", "MEDINA", "CARBAJAL", "PAREDES", "MALDONADO",
			"TAFUR", "BOZA", "DE LOAYZA", "MORENO", "BAIOCCHI", "GAMIO", "VALDIVIA", "CARRERA", "SALINAS", "TEJEDO", "RUIZ" , "VILLARREAL", "NIETO"};
	
	public static List<Alumno> create(int size) {
		List<Alumno> alumnos = new LinkedList<Alumno>();
		for (int x = 0; x < size; x++) {
			alumnos.add(AlumnoUtil.create());
		}
		return alumnos;		
	}

	public static Alumno create() {	
		Calendar calendar = Calendar.getInstance();
		Alumno alumno = new Alumno();
		int mes, dia, anio;
		
		alumno.setNombre(listaNombres[ThreadLocalRandom.current().nextInt(1, listaNombres.length-1)]);
		alumno.setApellido(listaApellidos[ThreadLocalRandom.current().nextInt(1, listaApellidos.length-1)]);
		alumno.setDni( Long.toString(ThreadLocalRandom.current().nextLong(20000000, 40000000)) );
		alumno.setTelefono("156" + ThreadLocalRandom.current().nextLong(100000, 999999));
		
		// Asignamos año, mes y día.
		mes = ThreadLocalRandom.current().nextInt(1, 12);
		dia = ThreadLocalRandom.current().nextInt(1, 30);
		anio = ThreadLocalRandom.current().nextInt(1950, 2010);		
		calendar.set(anio, mes, dia);
		alumno.setFechaNacimiento(calendar.getTime());

		return alumno;
	}

}
