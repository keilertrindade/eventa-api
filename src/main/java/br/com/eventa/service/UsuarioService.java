package br.com.eventa.service;

import br.com.eventa.model.Usuario;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 *
 * @author falvojr
 */
public interface UsuarioService {

    Iterable<Usuario> buscarTodos();

    Usuario buscarPorId(Long id);

    void inserir(Usuario usuario);

    void atualizar(Long id, Usuario usuario);

    void deletar(Long id);

}
