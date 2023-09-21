package br.com.eventa.service.impl;

import br.com.eventa.model.Endereco;
import br.com.eventa.model.Local;
import br.com.eventa.model.Usuario;
import br.com.eventa.repository.EnderecoRepository;
import br.com.eventa.repository.LocalRepository;
import br.com.eventa.service.ClienteService;
import br.com.eventa.service.LocalService;
import br.com.eventa.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 *
 * @author Keiler Trindade
 */
@Service
public class LocalServiceImpl implements LocalService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private LocalRepository localRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Local> buscarTodos() {
        // Buscar todos os locais.
        return localRepository.findAll();
    }

    @Override
    public Local buscarPorId(Long id) {
        // Buscar Cliente por ID.
        Optional<Local> local = localRepository.findById(id);
        return local.orElse(null);
    }

    @Override
    public void inserir(Local local) {
        //localRepository.save(local);
        salvarLocalComCep(local);
    }

    @Override
    public void atualizar(Long id, Local local) {
        // Buscar Cliente por ID, caso exista:
        Optional<Local> localBd = localRepository.findById(id);
        if (localBd.isPresent()) {
            inserir(local);
        }
    }

    @Override
    public void deletar(Long id) {
        // Deletar Cliente por ID.
        localRepository.deleteById(id);
    }

    private void salvarLocalComCep(Local local) {
        String cep = local.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        local.setEndereco(endereco);
        localRepository.save(local);
    }

}
