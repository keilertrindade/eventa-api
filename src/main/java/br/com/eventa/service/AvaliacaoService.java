package br.com.eventa.service;

import br.com.eventa.model.Avaliacao;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 *
 *  @author Keiler Trindade
 */
public interface AvaliacaoService {

	Iterable<Avaliacao> buscarTodos();

	Avaliacao buscarPorId(Long id);

	void inserir(Avaliacao avaliacao);

	void atualizar(Long id, Avaliacao avaliacao);

	void deletar(Long id);

}
