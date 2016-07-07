package demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import demo.entity.Curso;

public interface CursoRepository extends MongoRepository<Curso, String>{
		
  public Curso findByNombre(String nombre);
  
  public Curso findByCodCurso(String id);

}
