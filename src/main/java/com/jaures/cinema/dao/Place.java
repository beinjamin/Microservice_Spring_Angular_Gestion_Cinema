package com.jaures.cinema.dao;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Place {
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	private int numero;
	private double longitude,latidude,altitude;
	@ManyToOne
	private Salle salle;
	@OneToMany(mappedBy="place")
	private Collection<Ticket> tickets;

}
