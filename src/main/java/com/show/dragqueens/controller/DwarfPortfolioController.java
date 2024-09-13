package com.show.dragqueens.controller;

import com.show.dragqueens.model.DwarfPortfolio;
import com.show.dragqueens.repository.DwarfPortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dwarf-portfolios")
public class DwarfPortfolioController {

    @Autowired
    private DwarfPortfolioRepository dwarfPortfolioRepository;

    @GetMapping
    public List<DwarfPortfolio> getAllPortfolios() {
        return dwarfPortfolioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DwarfPortfolio> getPortfolioById(@PathVariable Long id) {
        return dwarfPortfolioRepository.findById(id)
                .map(portfolio -> ResponseEntity.ok().body(portfolio))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DwarfPortfolio createPortfolio(@RequestBody DwarfPortfolio portfolio) {
        return dwarfPortfolioRepository.save(portfolio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DwarfPortfolio> updatePortfolio(
            @PathVariable Long id, @RequestBody DwarfPortfolio portfolio) {
        return dwarfPortfolioRepository.findById(id)
                .map(existingPortfolio -> {
                    existingPortfolio.setName(portfolio.getName());
                    existingPortfolio.setBiography(portfolio.getBiography());
                    existingPortfolio.setPhotoLinks(portfolio.getPhotoLinks());
                    existingPortfolio.setVideoLinks(portfolio.getVideoLinks());
                    return ResponseEntity.ok().body(dwarfPortfolioRepository.save(existingPortfolio));
                })
                .orElse(ResponseEntity.notFound().build());
    }

}

