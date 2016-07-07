package demo.util;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import demo.entity.Docente;

public class DocenteUtil {
	
	private static String[][] listaDocentes = { { "Esteban", "Vaschalde" }, { "Matias", "Moreno" }, { "Aldana", "Carolina" },
			{ "Veronica", "Cochrone" }, { "Antonio", "Adolfo" }, { "Ruben", "Nieva" }, { "Rodrigo", "Chapeta" },
			{ "Pablo", "Lopez" } };


	public static List<Docente> iniciar() {
		
		List<Docente> docentes = new LinkedList<Docente>();
		Docente d;
		
		for (int x = 0; x < listaDocentes.length; x++) {
		
		 d= new Docente();
		 String[] tmpDocente = listaDocentes[x];
		 d.setNombre(tmpDocente[0]);
		 d.setApellido(tmpDocente[1]);
		 d.setDni( Long.toString(ThreadLocalRandom.current().nextLong(20000000, 40000000)) );
         d.setTelefono("156" + ThreadLocalRandom.current().nextLong(100000, 999999));               
         docentes.add(d);
		}
		
		return docentes;
	}

}
