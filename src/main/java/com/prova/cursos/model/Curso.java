package com.prova.cursos.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document (collection = "cursos")
@EnableMongoAuditing
public class Curso {
	@Id
	private String codigo;
	private String descricao;
	private String criacao;
	@DBRef
    private List<Disciplina> disciplinas;
	
	/**
     * Nao consegui fazer
     * @PrePersist
     * @PreUpdate
     * para MongoDB
     */
}