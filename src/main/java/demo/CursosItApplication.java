package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

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
}
