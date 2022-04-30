package com.jaures.cinema.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaures.cinema.dao.CategorieRepository;
import com.jaures.cinema.dao.CinemaRepository;
import com.jaures.cinema.dao.FilmRepository;
import com.jaures.cinema.dao.PlaceRepository;
import com.jaures.cinema.dao.ProjectionRepository;
import com.jaures.cinema.dao.SalleRepository;
import com.jaures.cinema.dao.SeanceRepository;
import com.jaures.cinema.dao.TicketRepository;
import com.jaures.cinema.dao.VilleRepository;
import com.jaures.cinema.entities.Categorie;
import com.jaures.cinema.entities.Cinema;
import com.jaures.cinema.entities.Film;
import com.jaures.cinema.entities.Place;
import com.jaures.cinema.entities.Salle;
import com.jaures.cinema.entities.Seance;
import com.jaures.cinema.entities.Ville;

@Service

public class CinemaInitServiceImpl implements ICinemaInitService {

	
	@Autowired
	private VilleRepository villeRepository;
	@Autowired
    private CinemaRepository cinemaRepository;
	@Autowired
    private SalleRepository salleRepository;
	@Autowired
	private PlaceRepository placeRepository;
	@Autowired
    private SeanceRepository seanceRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private ProjectionRepository projectionRepository;
	@Autowired
    private CategorieRepository categorieRepository;
	@Autowired
    private TicketRepository ticketRepository;
	

	
	
	
	
	
	
	
	
	
	@Override
	public void initVilles() {
		Stream.of("Douala",
				"Yaoundé",
				"Baffoussam",
				"Kribie",
				"Edea",
				"Limbé").forEach(nameVille->{
			Ville ville=new Ville();
			ville.setName(nameVille);
			villeRepository.save(ville);
			
			
			//villeRepository.save(new Ville(null,v));
		});
    		
	} 
	@Override
	public void initCinemas() {
		villeRepository.findAll().forEach(v->{
			Stream.of("CinéWourir",
					"CinéBependa",
					"CinéGrandMall",
					"CinéJapoma")
			.forEach(nameCinema->{
				Cinema cinema=new Cinema();
				cinema.setName(nameCinema);
				cinema.setNombreSalles(3+(int)(Math.random()*7));
				cinema.setVille(v);
				cinemaRepository.save(cinema);
			});
		});
		
		
	}
	@Override
	public void intiSalles() {
		cinemaRepository.findAll().forEach(cinema->{
			for(int i=0;i<cinema.getNombreSalles();i++) {
			Salle salle=new Salle();
			salle.setName("Salle" +(i+1));
			salle.setCinema(cinema);
			salle.setNombrePlace(20+(int)(Math.random()*35));
			salleRepository.save(salle);
			}
		
		});
		
	}

	@Override
	public void initPlaces() {
       salleRepository.findAll().forEach(salle->{
    	   for(int i=0;i<salle.getNombrePlace();i++) {
    		   Place place=new Place();
    		   place.setNumero(i+1);  
    		   place.setSalle(salle);  
    		   placeRepository.save(place);    	   }
       });		
	}
	
	@Override
	public void initSeances() {
        DateFormat dateFormat=new SimpleDateFormat("HH:mm");
		Stream.of("10:00",
				"12:00",
				"15:00",
				"17:00",
				"20:00",
				"22:00")
		.forEach(s->{
			Seance seance=new Seance();
			try {
				seance.setHeureDebut(dateFormat.parse(s));
				seanceRepository.save(seance);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
	}


	@Override
	public void initCategories() {
		Stream.of("Histoire",
				"Actions",
				"Fiction",
				"Drame",
				"Aventure")
      .forEach(cat->{
    	  Categorie categorie=new Categorie();
    	  categorie.setName(cat);  
    	  categorieRepository.save(categorie) ; 
    	  });		
	}

	@Override
	public void initFilms() {
		Stream.of("Le Callendrier",
				"The After",
				"Les 50 Nuance de Grey",
				"Superman",
				"Spiderman",
				"les Avengers",
				"Social Network")
        .forEach(titreFilm->{
        	Film film=new Film();
        	film.setTitre(titreFilm) ;
        	film.setDuree(duree);        	
        
        
        });
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
