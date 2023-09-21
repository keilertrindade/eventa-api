package br.com.eventa.service;

import br.com.eventa.model.Evento;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * @author Keiler Trindade
 */
public interface EventoService {

	Iterable<Evento> buscarTodos();

	Evento buscarPorId(Long id);

	void inserir(Evento evento);

	void atualizar(Long id, Evento evento);

	void deletar(Long id);

}
