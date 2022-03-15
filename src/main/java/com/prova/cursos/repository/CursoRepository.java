package com.prova.cursos.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.prova.cursos.model.Curso;

public interface CursoRepository extends 
						MongoRepository<Curso, String>{

}
