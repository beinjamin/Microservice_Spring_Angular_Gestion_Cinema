package com.jaures.cinema.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaures.cinema.dao.FilmRepository;
import com.jaures.cinema.entities.Film;

@RestController
public class CinemaRestController {
	private FilmRepository filmRepository;
	
	
	@GetMapping("/listFilms")
	public List<Film> films(){
		return filmRepository.findAll();
		
	}
	

}
