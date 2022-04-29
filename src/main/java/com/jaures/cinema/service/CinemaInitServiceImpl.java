package com.jaures.cinema.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaures.cinema.dao.CinemaRepository;
import com.jaures.cinema.dao.VilleRepository;
import com.jaures.cinema.entities.Cinema;
import com.jaures.cinema.entities.Ville;

@Service

public class CinemaInitServiceImpl implements ICinemaInitService {

	
	@Autowired
	private VilleRepository villeRepository;
	@Autowired
    private CinemaRepository cinemaRepository;
	
	
	
	
	
	
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
		villeRepository.findAll().forEach(v->{
			Stream.of("CinéWourir","CinéBependa","CinéGrandMall","CinéJapoma")
			.forEach(nameCinema->{
				Cinema cinema=new Cinema();
				cinema.setName(nameCinema);
				cinema.setNombreSalles(3+(int)(Math.random()*7));
				cinema.setVille(v);
			});
		});
		
		
	}

	@Override
	public void intiSalles() {
		cinemaRepository.findAll().forEach(c->{
			Stream.of("Salle Douala Manga Belle", "Salle Melone","Salle A6","Salle Est")
			.forEach(nameSalle->{
				
			})
		});
		
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
