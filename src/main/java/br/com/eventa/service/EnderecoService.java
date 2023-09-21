package br.com.eventa.service;

import br.com.eventa.model.Endereco;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * @author Keiler Trindade
 */
public interface EnderecoService {

	Iterable<Endereco> buscarTodos();

	Endereco buscarPorId(String cep);

	void inserir(Endereco endereco);


}
