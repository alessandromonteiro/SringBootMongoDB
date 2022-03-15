package com.prova.cursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prova.cursos.model.Disciplina;
import com.prova.cursos.services.imp.DisciplinaService;

@RestController
@RequestMapping(value = "/disciplina", path = "/disciplina")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService serv;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( method = RequestMethod.GET, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Disciplina> obterTodos() {
		return this.serv.obterTodos();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( value = "/{codigo}",
			method = RequestMethod.GET, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public Disciplina obterPorCodigo(@PathVariable String codigo) {
		return this.serv.obterPorCodigo(codigo);
	}
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
	public Disciplina criar (@RequestBody Disciplina disciplina) {
		return this.serv.criar(disciplina);
	}
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{codigo}",
    	method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
	public Disciplina atualizar (@PathVariable String codigo, @RequestBody Disciplina disciplina) {
		return this.serv.atualizar(codigo, disciplina);
	}
}

