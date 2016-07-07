package demo.controller;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import demo.entity.Alumno;
import demo.entity.Curso;
import demo.repository.AlumnoRepository;
import demo.repository.CursoRepository;

@Controller
public class AlumnoController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
		
    
	@RequestMapping(value = "/listStudents/{id}", method = RequestMethod.GET)
    public String listarCursos(@PathVariable String id, Model model){
		
    	Curso curso = cursoRepository.findOne(id);
    	List<Alumno> lista;
    	
    	if(curso !=null){
    		LOGGER.debug("Rendering listarAlumnos: " + curso.getNombre());
    		model.addAttribute("curso", curso.getNombre());
    		model.addAttribute("idCurso", id);
    		lista = curso.getAlumnos();
    		
    		if(lista != null){    			
    			model.addAttribute("listaAlumnos", lista);
    			return "listStudents";
    		}else{
    			LOGGER.debug("El curso no tiene alumnos asignados aun!!!");
    		}
            
    	}else{
    		LOGGER.debug("ListStudents: No hay cursos con este id: " + id);    		
    	}     	
        
        return "redirect:/courses/";
    }
	
	@RequestMapping(value = "/deleteAlumno/{id}", method = RequestMethod.GET)
    public String deleteCourse(@PathVariable String id, final ModelMap model, RedirectAttributes redirectAttributes){
		
		Curso curso;
		Alumno alumno;
		
		String[] tokens = id.split(",");
		
		String idCurso = tokens[0];
		String dni = tokens[1];
    	
   	    curso = cursoRepository.findOne(idCurso);
   	    alumno = alumnoRepository.findByDni(dni);
   	    
   	    LOGGER.debug("DeleteAlumno: DNI: " + dni + " Curso: " + alumno.getDni() + "-" + dni);
   	    
   	    curso.deleteAlumno(alumno);
   	    cursoRepository.save(curso);
   	    
       //redirectAttributes.addAttribute("id", idCurso);

        return "redirect:/courses/";
    }
	
    @RequestMapping(value="/viewAlumno/{id}", method = RequestMethod.GET)
    public String viewCourse(@PathVariable String id, Model model) {    	
    	
		String[] tokens = id.split(",");
		
		String idCurso = tokens[0];
		String dni = tokens[1];
    	
    	LOGGER.debug("Rendering viewAlumno:" +  idCurso + "Dni: " + dni);
    	
        model.addAttribute("pagina", "alumno");
        model.addAttribute("idCurso", idCurso);
        model.addAttribute("alumno", this.alumnoRepository.findByDni(dni));
        return "alumno-view";
    }

}
