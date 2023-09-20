package br.com.eventa.service.impl;

import br.com.eventa.model.Cliente;
import br.com.eventa.model.Usuario;
import br.com.eventa.repository.EnderecoRepository;
import br.com.eventa.repository.UsuarioRepository;
import br.com.eventa.service.ClienteService;
import br.com.eventa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 *
 * @author falvojr
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Usuario> buscarTodos() {
        // Buscar todos os Clientes.
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        // Buscar Cliente por ID.
        Optional<Usuario> cliente = usuarioRepository.findById(id);
        return cliente.orElse(null);
    }

    @Override
    public void inserir(Usuario usuario) {
            usuarioRepository.save(usuario);
    }

    @Override
    public void atualizar(Long id, Usuario usuario) {
        // Buscar Cliente por ID, caso exista:
        Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
        if (usuarioBd.isPresent()) {
            usuarioRepository.save(usuario);
        }
    }

    @Override
    public void deletar(Long id) {
        // Deletar Cliente por ID.
        usuarioRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        /* Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        clienteRepository.save(cliente); */
    }

}
