package com.show.dragqueens.controller;

import com.show.dragqueens.model.Presentacion;
import com.show.dragqueens.services.PresentacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/presentaciones")
public class PresentacionController {

    @Autowired
    private PresentacionService presentacionService;

    @GetMapping
    public List<Presentacion> getAllPresentaciones() {
        return presentacionService.getAllPresentaciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Presentacion> getPresentacionById(@PathVariable Long id) {
        Presentacion presentacion = presentacionService.getPresentacion(id);
        if (presentacion != null) {
            return ResponseEntity.ok().body(presentacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Presentacion> createPresentacion(@RequestBody Presentacion presentacion) {
        Presentacion createdPresentacion = presentacionService.savePresentacion(presentacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPresentacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Presentacion> updatePresentacion(
            @PathVariable Long id, @RequestBody Presentacion presentacion) {
        Presentacion updatedPresentacion = presentacionService.updatePresentacion(id, presentacion);
        if (updatedPresentacion != null) {
            return ResponseEntity.ok().body(updatedPresentacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePresentacion(@PathVariable Long id) {
        presentacionService.deletePresentacion(id);
        return ResponseEntity.noContent().build();
    }
}