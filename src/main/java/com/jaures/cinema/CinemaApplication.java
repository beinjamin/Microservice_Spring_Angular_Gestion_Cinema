package com.jaures.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jaures.cinema.service.ICinemaInitService;

@SpringBootApplication
public class CinemaApplication implements CommandLineRunner{

	
	
	
	@Autowired
	private ICinemaInitService cinemaInitService;
	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
    cinemaInitService.initVilles();
    cinemaInitService.initCinemas();
    cinemaInitService.intiSalles();
    cinemaInitService.initPlaces();
    cinemaInitService.initCategories();
    cinemaInitService.initFilms();
    cinemaInitService.initProjections();
    cinemaInitService.initTickets();
    
    
	}

}
