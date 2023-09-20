package br.com.eventa.service.impl;

import br.com.eventa.model.Endereco;
import br.com.eventa.repository.EnderecoRepository;
import br.com.eventa.service.ClienteService;
import br.com.eventa.service.EnderecoService;
import br.com.eventa.service.ViaCepService;
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
public class EnderecoServiceImpl implements EnderecoService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Endereco> buscarTodos() {
        // Buscar todos os Clientes.
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco buscarPorId(String cep) {
        // Buscar Cliente por ID.
        Optional<Endereco> cliente = enderecoRepository.findById(cep);
        return cliente.orElse(null);
    }

    @Override
    public void inserir(Endereco endereco) {

        Endereco enderecoBanco = enderecoRepository.findById(endereco.getCep()).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(endereco.getCep());
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

    }


}
