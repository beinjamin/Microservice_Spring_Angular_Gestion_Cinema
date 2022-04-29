package com.jaures.cinema.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaures.cinema.dao.VilleRepository;
import com.jaures.cinema.entities.Ville;

@Service

public class CinemaInitServiceImpl implements ICinemaInitService {

	
	@Autowired
	private VilleRepository villeRepository;
	@Override
	public void initVilles() {
		Stream.of("Douala","Yaoundé","Baffoussam","Kribie","Edea","Limbé").forEach(nameVille->{
			Ville ville=new Ville();
			ville.setName(nameVille);
			villeRepository.save(ville);
			
			
			//villeRepository.save(new Ville(null,v));
		});
    		
	}

	@Override
	public void initCinemas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void intiSalles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initSeances() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initPlaces() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initCategories() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initFilms() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initProjections() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initTickets() {
		// TODO Auto-generated method stub
		
	}

}
