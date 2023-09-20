package br.com.eventa.controller;

import br.com.eventa.model.Avaliacao;
import br.com.eventa.service.AvaliacaoService;
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
@RequestMapping("/avaliacao")
public class AvaliacaoController {
	@Autowired
	private AvaliacaoService avaliacaoService;

	@GetMapping()
	public ResponseEntity<Iterable<Avaliacao>> buscarTodos() {
		return ResponseEntity.ok(avaliacaoService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Avaliacao> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(avaliacaoService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Avaliacao> inserir(@RequestBody Avaliacao avaliacao) {
		avaliacaoService.inserir(avaliacao);
		return ResponseEntity.ok(avaliacao);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Avaliacao> atualizar(@PathVariable Long id, @RequestBody Avaliacao avaliacao) {
		avaliacaoService.atualizar(id, avaliacao);
		return ResponseEntity.ok(avaliacao);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		avaliacaoService.deletar(id);
		return ResponseEntity.ok().build();
	}


}
