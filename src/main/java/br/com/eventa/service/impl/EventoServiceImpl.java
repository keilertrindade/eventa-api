package br.com.eventa.service.impl;

import br.com.eventa.model.Evento;
import br.com.eventa.repository.EventoRepository;
import br.com.eventa.service.ClienteService;
import br.com.eventa.service.EventoService;
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
public class EventoServiceImpl implements EventoService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private EventoRepository eventoRepository;


    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Evento> buscarTodos() {
        // Buscar todos os Clientes.
        return eventoRepository.findAll();
    }

    @Override
    public Evento buscarPorId(Long id) {
        // Buscar Cliente por ID.
        Optional<Evento> evento = eventoRepository.findById(id);
        return evento.orElse(null);
    }

    @Override
    public void inserir(Evento evento) {
        eventoRepository.save(evento);
    }

    @Override
    public void atualizar(Long id, Evento evento) {
        // Buscar Cliente por ID, caso exista:
        Optional<Evento> eventoBd = eventoRepository.findById(id);
        if (eventoBd.isPresent()) {
            inserir(evento);
        }
    }

    @Override
    public void deletar(Long id) {
        // Deletar Cliente por ID.
        eventoRepository.deleteById(id);
    }



}
