package com.show.dragqueens.controller;

import com.show.dragqueens.model.Event;
import com.show.dragqueens.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Event> getAllEventos() {
        return eventoService.getAllEventos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventoById(@PathVariable Long id) {
        Event evento = eventoService.getEvento(id);
        if (evento != null) {
            return ResponseEntity.ok().body(evento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Event> createEvento(@RequestBody Event evento) {
        Event createdEvento = eventoService.saveEvento(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvento(
            @PathVariable Long id, @RequestBody Event evento) {
        Event updatedEvento = eventoService.updateEvento(id, evento);
        if (updatedEvento != null) {
            return ResponseEntity.ok().body(updatedEvento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
        eventoService.deleteEvento(id);
        return ResponseEntity.noContent().build();
    }
}