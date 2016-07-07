package demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.entity.Curso;
import demo.repository.CursoRepository;
import demo.repository.DocenteRepository;

import java.util.List;

@Controller
public class CourseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);
		
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private DocenteRepository docenteRepository;


    @ModelAttribute("courses")
    public List<Curso> PopulateCourses(Model model){        
		 return cursoRepository.findAll();
    }
    
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String listarCursos(Model model){
        model.addAttribute("pagina", "cursos");
        model.addAttribute("listadeCursos", this.cursoRepository.findAll());
        return "showCourses";
    }
    
    
    @RequestMapping(value="/newCourse")
    public String newCourse(ModelMap model) {
        model.addAttribute("pagina", "curso");
        model.addAttribute("nuevocurso", new Curso());
        model.addAttribute("listaDocentes", this.docenteRepository.findAll());
        return "newCourse";
    }
    
    
    @RequestMapping(value = "course", method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute Curso course, BindingResult bindingResult, final ModelMap model){
    	
    	//Add validation function to avoid malformed object 
    	  	
    	LOGGER.debug("Rendering POST ADD COURSE" + course.getNombre());
    	
    	if ( cursoRepository.findByNombre(course.getNombre()) == null){    		
    		cursoRepository.save(course);    		
    	}else{
    		LOGGER.debug("El curso ya ya existe");
    	}    	
    	        
        model.clear();
                
        return "redirect:/courses/";
    }
    
    
    @RequestMapping(value="/viewCourse/{id}", method = RequestMethod.GET)
    public String viewCourse(@PathVariable String id, Model model) {
    	
    	LOGGER.debug("Rendering view for Course:" + id);
    	
        model.addAttribute("pagina", "courses");
        model.addAttribute("curso", this.cursoRepository.findOne(id));
        return "course-view";
    }
    
    @RequestMapping(value = "/deleteCourse/{id}", method = RequestMethod.GET)
    public String deleteCourse(@PathVariable String id, Curso course, final ModelMap model){
    	
   	    course = cursoRepository.findOne(id);
   	     
   	    LOGGER.debug("Rendering Delete COURSE Name: " + course.getNombre()); 
    	
       	cursoRepository.delete(course);
        model.clear();

        return "redirect:/courses/";
    }
    
    
    @RequestMapping(value="/editCourse/{id}")
    public String updateCourse(@PathVariable String id, Model model) {
    	LOGGER.debug("Rendering view for editCourse ID:" + id);
    	
        model.addAttribute("pagina", "courses");
        model.addAttribute("nuevocurso", this.cursoRepository.findOne(id));
        return "newCourse";
    }
	

}
