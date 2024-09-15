package com.show.dragqueens.services;

import com.show.dragqueens.dao.EventoRepository;
import com.show.dragqueens.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public Event saveEvento(Event evento) {
        return eventoRepository.save(evento);
    }

    public void deleteEvento(Long id) {
        eventoRepository.deleteById(id);
    }

    public Event updateEvento(Long id, Event evento) {
        return eventoRepository.save(evento);
    }

    public Event getEvento(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    public List<Event> getAllEventos() {
        return eventoRepository.findAll();
    }
}