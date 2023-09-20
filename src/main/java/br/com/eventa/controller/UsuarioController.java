package br.com.eventa.controller;

import br.com.eventa.model.Usuario;
import br.com.eventa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 * 
 * @author falvojr
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping()
	public ResponseEntity<Iterable<Usuario>> buscarTodos() {
		return ResponseEntity.ok(usuarioService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(usuarioService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario usuario) {
		usuarioService.inserir(usuario);
		return ResponseEntity.ok(usuario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
		usuarioService.atualizar(id, usuario);
		return ResponseEntity.ok(usuario);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		usuarioService.deletar(id);
		return ResponseEntity.ok().build();
	}
}