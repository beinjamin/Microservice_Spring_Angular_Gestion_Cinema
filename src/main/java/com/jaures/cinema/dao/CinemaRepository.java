package com.jaures.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaures.cinema.entities.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Long>{

}
