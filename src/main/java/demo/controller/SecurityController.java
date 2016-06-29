package demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityController.class);
	
	@RequestMapping("/")
	public String goHome(){
		
		LOGGER.debug("Debug - Function:  goHome");
		
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
		
		return "hello";   // ALDANA -> Aqui hay que hacer el redirect a la pagina/vista del administrador.
	}
	
	@RequestMapping("/login")
	public String doLogin(){
		
		LOGGER.debug("Debug - Function:  doLogin");
		
		return "login";   
	}

}
