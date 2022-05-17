package com.jaures.cinema.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.transaction.Transactional;

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
import com.jaures.cinema.entities.Projection;
import com.jaures.cinema.entities.Salle;
import com.jaures.cinema.entities.Seance;
import com.jaures.cinema.entities.Ticket;
import com.jaures.cinema.entities.Ville;

@Service
@Transactional

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
			salle.setNombrePlace(5+(int)(Math.random()*10));
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
		Stream.of("10:00","12:00","15:00","17:00","20:00","22:00")
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
		Stream.of("Histoire","Actions","Fiction","Drame","Aventure")
      .forEach(cat->{
    	  Categorie categorie=new Categorie();
    	  categorie.setName(cat);  
    	  categorieRepository.save(categorie) ; 
    	  });		
	}

	@Override
	public void initFilms() {
		double[] durees=new double[] {1,1.5,2,2.5,3};
		List<Categorie> categories=categorieRepository.findAll();
		Stream.of("Le Callendrier","The After","Les 50 Nuance de Grey","Superman","Spiderman","les Avengers","Social Network")
        .forEach(titreFilm->{
        	Film film=new Film();
        	film.setTitre(titreFilm) ;
        	film.setDuree(durees[new Random().nextInt(durees.length)]);
        	film.setPhoto(titreFilm.replaceAll(" ",""));
        	film.setCategorie(categories.get(new Random().nextInt(categories.size())));
        	filmRepository.save(film);
        
        
        });
	}

	@Override
	public void initProjections() {
		double[] prices=new double[] {2500,5000,6000,7500,9500,10000};
		villeRepository.findAll().forEach(ville->{
			ville.getCinemas().forEach(cinema->{
				cinema.getSalles().forEach(salle->{
					filmRepository.findAll().forEach(film->{
						seanceRepository.findAll().forEach(seance->{
							Projection projection=new Projection();
							projection.setDateProjection(new Date());
							projection.setFilm(film);
							projection.setPrix(prices[new Random().nextInt(prices.length)]);
							projection.setSalle(salle);
							projection.setSeance(seance);
							projectionRepository.save(projection);
							
							
						});
					});
				});
			});
		});

		
		
	}

	@Override
	public void initTickets() {
      projectionRepository.findAll().forEach(p->{
    	  p.getSalle().getPlaces().forEach(place->{
    		  Ticket ticket=new Ticket();
    		  ticket.setPlace(place);
    		  ticket.setPrix(p.getPrix());
    		  ticket.setProjection(p);
    		  ticket.setReserve(false);
    		  ticketRepository.save(ticket);
    		  
    		  
    	  });
      });
		
		
	}

}
