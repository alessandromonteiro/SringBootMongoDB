package com.prova.cursos.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.cursos.model.Disciplina;
import com.prova.cursos.repository.DisciplinaRepository;
import com.prova.cursos.services.IService;
import com.prova.cursos.util.Util;

@Service
public class DisciplinaService implements IService<Disciplina, String> {

	@Autowired
	private DisciplinaRepository repo;
	
	@Override
	public List<Disciplina> obterTodos() {
		return this.repo.findAll();
	}

	@Override
	public Disciplina obterPorCodigo(String codigo) {
		return this.repo.
				findById(codigo).orElseThrow(() ->
				new IllegalArgumentException("Disciplina não esiste."));
	}

	@Override
	public Disciplina criar(Disciplina t) {
		t.setCriacao(Util.getSysDateTime());
		return this.repo.save(t);
	}

	@Override
	public Disciplina atualizar(String codigo, Disciplina t) {
		Disciplina atualiza = 
				this.repo.findById(codigo).orElseThrow(() ->
				new IllegalArgumentException("Disciplina não esiste."));

		atualiza.setDescricao(t.getDescricao());
		atualiza.setCargaHPratica(t.getCargaHPratica());
		atualiza.setCargaHTeorica(t.getCargaHTeorica());
		atualiza.setCargaHTotal(t.getCargaHTotal());
		atualiza.setQtdeAlunos(t.getQtdeAlunos());
		atualiza.setUsuario(t.getUsuario());
		atualiza.setCriacao(Util.getSysDateTime());

		return this.repo.save(atualiza);
	}

}
