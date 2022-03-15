package com.prova.cursos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document (collection = "disciplinas")
@EnableMongoAuditing
public class Disciplina {
	@Id
	private String codigo;
	private String descricao;
	private int cargaHTotal;
	private int cargaHPratica;
	private int cargaHTeorica;
	private int qtdeAlunos;
	private String usuario;
	private String criacao;

    /**
     * Nao consegui fazer
     * @PrePersist
     * @PreUpdate
     * para MongoDB
     */	    
}
