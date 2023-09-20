package br.com.eventa.repository;

import br.com.eventa.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
}
