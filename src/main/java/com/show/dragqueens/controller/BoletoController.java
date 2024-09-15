package com.show.dragqueens.controller;

import com.show.dragqueens.model.Boleto;
import com.show.dragqueens.services.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boletos")
public class BoletoController {

    @Autowired
    private BoletoService boletoService;

    @GetMapping
    public List<Boleto> getAllBoletos() {
        return boletoService.getAllBoletos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boleto> getBoletoById(@PathVariable Long id) {
        Boleto boleto = boletoService.getBoleto(id);
        if (boleto != null) {
            return ResponseEntity.ok().body(boleto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Boleto> createBoleto(@RequestBody Boleto boleto) {
        Boleto createdBoleto = boletoService.saveBoleto(boleto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBoleto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boleto> updateBoleto(
            @PathVariable Long id, @RequestBody Boleto boleto) {
        Boleto updatedBoleto = boletoService.updateBoleto(id, boleto);
        if (updatedBoleto != null) {
            return ResponseEntity.ok().body(updatedBoleto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoleto(@PathVariable Long id) {
        boletoService.deleteBoleto(id);
        return ResponseEntity.noContent().build();
    }
}