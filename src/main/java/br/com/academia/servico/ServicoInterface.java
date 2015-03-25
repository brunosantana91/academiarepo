package br.com.academia.servico;

import java.util.List;

import br.com.academia.exceptions.ParametroEmUsoException;

public interface ServicoInterface<T> {
	
	T buscarPorId(Integer id);
	List<T> listar();
	void adicionar(T objeto) throws ParametroEmUsoException;
	void editar(T objeto);
	void remover(T objeto);
	T atualizar(T objeto);

}
