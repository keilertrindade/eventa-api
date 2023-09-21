package br.com.eventa.service;

import br.com.eventa.model.Local;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * @author Keiler Trindade
 */
public interface LocalService {

	Iterable<Local> buscarTodos();

	Local buscarPorId(Long id);

	void inserir(Local local);

	void atualizar(Long id, Local local);
	void deletar(Long id);

}
