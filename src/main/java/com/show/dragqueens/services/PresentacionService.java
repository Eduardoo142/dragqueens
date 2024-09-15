package com.show.dragqueens.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.show.dragqueens.model.Presentacion;
import com.show.dragqueens.dao.PresentacionRepository;

import java.util.List;

@Service
public class PresentacionService {

    @Autowired
    private PresentacionRepository presentacionRepository;

    public Presentacion savePresentacion(Presentacion presentacion) {
        return presentacionRepository.save(presentacion);
    }

    public void deletePresentacion(Long id) {
        presentacionRepository.deleteById(id);
    }

    public Presentacion updatePresentacion(Long id, Presentacion presentacion) {
        return presentacionRepository.save(presentacion);
    }

    public Presentacion getPresentacion(Long id) {
        return presentacionRepository.findById(id).orElse(null);
    }

    public List<Presentacion> getAllPresentaciones() {
        return presentacionRepository.findAll();
    }

}