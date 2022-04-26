package com.jaures.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaures.cinema.entities.Seance;


public interface SeanceRepository extends JpaRepository<Seance, Long>{

}
