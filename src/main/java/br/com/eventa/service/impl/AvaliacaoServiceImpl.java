package br.com.eventa.service.impl;

import br.com.eventa.model.Avaliacao;
import br.com.eventa.repository.AvaliacaoRepository;
import br.com.eventa.service.AvaliacaoService;
import br.com.eventa.service.ClienteService;
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
public class AvaliacaoServiceImpl implements AvaliacaoService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Avaliacao> buscarTodos() {
        // Buscar todos os Clientes.
        return avaliacaoRepository.findAll();
    }

    @Override
    public Avaliacao buscarPorId(Long id) {
        // Buscar Cliente por ID.
        Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(id);
        return avaliacao.orElse(null);
    }

    @Override
    public void inserir(Avaliacao avaliacao) {
        //salvarClienteComCep(avaliacao);
        avaliacaoRepository.save(avaliacao);
    }

    @Override
    public void atualizar(Long id, Avaliacao avaliacao) {
        // Buscar Cliente por ID, caso exista:
        Optional<Avaliacao> avaliacaoBd = avaliacaoRepository.findById(id);
        if (avaliacaoBd.isPresent()) {
            return;
        }
    }

    @Override
    public void deletar(Long id) {
        // Deletar Cliente por ID.
        avaliacaoRepository.deleteById(id);
    }

   /* private void salvarClienteComCep(Cliente cliente) {
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        clienteRepository.save(cliente);
    } *
    } */

}
