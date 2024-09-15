package com.show.dragqueens.services;


import com.show.dragqueens.dao.ModeloRepository;
import com.show.dragqueens.model.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public Modelo saveModelo(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public void deleteModelo(Long id) {
        modeloRepository.deleteById(id);
    }

    public Modelo updateModelo(Long id, Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public Modelo getModelo(Long id) {
        return modeloRepository.findById(id).orElse(null);
    }

    public List<Modelo> getAllModelos() {
        return modeloRepository.findAll();
    }

}