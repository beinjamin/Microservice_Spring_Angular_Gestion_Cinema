package com.jaures.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaures.cinema.entities.Film;


public interface FilmRepository extends JpaRepository<Film, Long>{

}
