package demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.repository.DocenteRepository;


@Controller
public class DocenteController {
	
	@Autowired
	private DocenteRepository docenteRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);
	
	@RequestMapping(value = "/docentes", method = RequestMethod.GET)
    public String listarCursos(Model model){
        model.addAttribute("pagina", "docentes");
        model.addAttribute("listadeDocentes", this.docenteRepository.findAll());
        return "showDocentes";
    }
	
	
	

}
