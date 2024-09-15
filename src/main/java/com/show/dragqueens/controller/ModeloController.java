package com.show.dragqueens.controller;

import com.show.dragqueens.model.Modelo;
import com.show.dragqueens.services.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelos") // Ajustar la ruta según la entidad
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public List<Modelo> getAllModelos() {
        return modeloService.getAllModelos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> getModeloById(@PathVariable Long id) {
        Modelo modelo = modeloService.getModelo(id);
        if (modelo != null) {
            return ResponseEntity.ok().body(modelo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Modelo> createModelo(@RequestBody Modelo modelo) {
        Modelo createdModelo = modeloService.saveModelo(modelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdModelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> updateModelo(
            @PathVariable Long id, @RequestBody Modelo modelo) {
        Modelo updatedModelo = modeloService.updateModelo(id, modelo);
        if (updatedModelo != null) {
            return ResponseEntity.ok().body(updatedModelo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModelo(@PathVariable Long id) {
        modeloService.deleteModelo(id);
        return ResponseEntity.noContent().build();
    }
}