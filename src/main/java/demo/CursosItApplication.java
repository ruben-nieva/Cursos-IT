package demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import demo.entity.Alumno;
import demo.entity.Curso;
import demo.entity.Docente;
import demo.repository.AlumnoRepository;
import demo.repository.CursoRepository;
import demo.repository.DocenteRepository;
import demo.util.AlumnoUtil;
import demo.util.CursoUtil;
import demo.util.DocenteUtil;

@SpringBootApplication
public class CursosItApplication extends SpringBootServletInitializer{
	
	/**
	 * Used when run as JAR
	 */
	public static void main(String[] args) {
		SpringApplication.run(CursosItApplication.class, args);
	}
	
	
	/**
	 * Used when run as a WAR 
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(CursosItApplication.class);
	}
	
	@Bean
	CommandLineRunner runner(CursoRepository cursoRepository, DocenteRepository docenteRepository, AlumnoRepository alumnoRepository){
		return new CommandLineRunner() {
			@Override
			public void run(String... strings) throws Exception {
			
			List<Alumno> alumnos = null;
				
			//Borro todo lo que hubiera en la base
			docenteRepository.deleteAll();
			cursoRepository.deleteAll();
			alumnoRepository.deleteAll();
			
			List<Docente> docentes = DocenteUtil.iniciar();
			//List<Alumno> alumnos = AlumnoUtil.create(50);
			List<Curso> cursos = CursoUtil.init();
			
			for (Curso c: cursos){
				alumnos = AlumnoUtil.create(5);
				alumnoRepository.insert(alumnos);
				c.setAlumnos(alumnos);
			}
			
			docenteRepository.insert(docentes);
			//alumnoRepository.insert(alumnos);
			
			//Asigno docentes
			for(int x=0; x< cursos.size(); x++){			
				cursos.get(x).setDocente(docentes.get(x));				
			}
			
			cursoRepository.insert(cursos);
			
	        List<Curso> lista = cursoRepository.findAll();	        
			for(Curso c:lista){
				
				System.out.println(c.toString());
			}			
			
			}
		};
	}
}
