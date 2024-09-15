package com.show.dragqueens.dao;


import com.show.dragqueens.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Event, Long> {}