package com.GreenPeak.controller;

import com.GreenPeak.model.Residuo;
import com.GreenPeak.service.Residuo.ResiduoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/residuos")
public class ResiduoController {

    private final ResiduoService service;

    public ResiduoController(ResiduoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Residuo> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Residuo> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Residuo criar(@RequestBody Residuo residuo) {
        return service.salvar(residuo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Residuo> atualizar(@PathVariable Long id, @RequestBody Residuo novosDados) {
        try {
            Residuo atualizado = service.atualizar(id, novosDados);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}