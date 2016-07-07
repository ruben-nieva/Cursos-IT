package demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import demo.entity.Docente;

public interface DocenteRepository extends MongoRepository<Docente, String> {

}
