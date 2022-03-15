package com.prova.cursos.services;

import java.util.List;

public interface IService <T, Id> {
	public List<T> obterTodos();
	public T obterPorCodigo(Id codigo);
	public T criar (T t);
	public T atualizar (Id codigo, T t);
	
}
