package br.com.eventa.service.impl;

import br.com.eventa.model.Local;
import br.com.eventa.repository.EnderecoRepository;
import br.com.eventa.repository.LocalRepository;
import br.com.eventa.service.ClienteService;
import br.com.eventa.service.LocalService;
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
public class LocalServiceImpl implements LocalService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private LocalRepository localRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Local> buscarTodos() {
        // Buscar todos os Clientes.
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
        localRepository.save(local);

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

}
