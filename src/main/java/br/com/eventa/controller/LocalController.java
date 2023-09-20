package br.com.eventa.controller;

import br.com.eventa.model.Local;
import br.com.eventa.service.LocalService;
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
@RequestMapping("/local")
public class LocalController {

    @Autowired
    private LocalService localService;

    @GetMapping()
    public ResponseEntity<Iterable<Local>> buscarTodos() {
        return ResponseEntity.ok(localService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Local> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(localService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Local> inserir(@RequestBody Local local) {
        localService.inserir(local);
        return ResponseEntity.ok(local);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Local> atualizar(@PathVariable Long id, @RequestBody Local local) {
        localService.atualizar(id, local);
        return ResponseEntity.ok(local);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        localService.deletar(id);
        return ResponseEntity.ok().build();
    }
}