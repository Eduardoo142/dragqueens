package com.show.dragqueens.services;

import com.show.dragqueens.dao.BoletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.show.dragqueens.model.Boleto;
import java.util.List;

@Service
public class BoletoService {

    @Autowired
    private BoletoRepository boletoRepository;

    public Boleto saveBoleto(Boleto boleto) {
        return boletoRepository.save(boleto);
    }

    public void deleteBoleto(Long id) {
        boletoRepository.deleteById(id);
    }

    public Boleto updateBoleto(Long id, Boleto boleto) {
        return boletoRepository.save(boleto);
    }

    public Boleto getBoleto(Long id) {
        return boletoRepository.findById(id).orElse(null);
    }

    public List<Boleto> getAllBoletos() {
        return boletoRepository.findAll();
    }

}