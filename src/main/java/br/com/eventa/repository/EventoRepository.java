package br.com.eventa.repository;


import br.com.eventa.model.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento,Long> {
}
