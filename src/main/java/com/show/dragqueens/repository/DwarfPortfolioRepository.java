package com.show.dragqueens.repository;

import com.show.dragqueens.model.DwarfPortfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DwarfPortfolioRepository extends JpaRepository<DwarfPortfolio, Long> {
}
