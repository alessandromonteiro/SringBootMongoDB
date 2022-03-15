package com.prova.cursos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prova.cursos.model.Disciplina;

public interface DisciplinaRepository extends 
			MongoRepository<Disciplina, String>{
}