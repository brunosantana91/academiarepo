package br.com.academia.persistencia;

import java.util.List;

public interface DaoInterface<T> {
	
	T buscarPorId(Integer id);
	List<T> listar();
	void adicionar(T objeto);
	void editar(T objeto);
	void remover(T objeto);
	T atualizar(T objeto);
}
