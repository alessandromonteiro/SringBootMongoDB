package com.prova.cursos.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.cursos.model.Curso;
import com.prova.cursos.repository.CursoRepository;
import com.prova.cursos.services.IService;
import com.prova.cursos.util.Util;

@Service
public class CursoService implements IService<Curso, String> {

	@Autowired
	private CursoRepository repo;
	
	@Override
	public List<Curso> obterTodos() { 
		return this.repo.findAll();
	}

	@Override
	public Curso obterPorCodigo(String codigo) {
		return this.repo.
				findById(codigo).orElseThrow(() ->
				new IllegalArgumentException("Curso não esiste."));
	}

	@Override
	public Curso criar(Curso t) {
		t.setCriacao(Util.getSysDateTime());
		return this.repo.save(t);
	}

	@Override
	public Curso atualizar(String codigo, Curso t ) {

		Curso atualiza = 
				this.repo.findById(codigo).orElseThrow(() ->
				new IllegalArgumentException("Curso não esiste."));

		atualiza.setDescricao(t.getDescricao());
		atualiza.setCriacao(Util.getSysDateTime());

		return this.repo.save(atualiza);
	}

}
