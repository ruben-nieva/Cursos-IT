package demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import demo.repository.CursoRepository;

@Controller
public class SecurityController {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityController.class);
	
	@RequestMapping("/")
	public String goHome(Model model){
		
		LOGGER.debug("Debug - Function:  goHome");
		model.addAttribute("pagina", "cursos");
		model.addAttribute("listadeCursos", this.cursoRepository.findAll());
		
		return "index";
	}
	
	@RequestMapping("/hello")
	public String sayHello(){
		
		LOGGER.debug("Debug - Function:  sayHello");
		
		return "hello";
	}
	
	@RequestMapping("/admin")
	public String doLoginAdmin(){
		
		LOGGER.debug("Debug - Function:  Admin");
		
		return "redirect:/courses";   // ALDANA -> Aqui hay que hacer el redirect a la pagina/vista del administrador.
	}
	
	@RequestMapping("/login")
	public String doLogin(){
		
		LOGGER.debug("Debug - Function:  doLogin");
		
		return "login";   
	}

}
