package demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import demo.entity.Alumno;

public interface AlumnoRepository extends MongoRepository<Alumno, String> {
	
	public Alumno findByDni(String dni);

}
