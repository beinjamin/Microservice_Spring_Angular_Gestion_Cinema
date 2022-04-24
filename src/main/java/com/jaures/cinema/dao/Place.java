package com.jaures.cinema.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Place {
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	private int numero;
	private double longitude,latidude,altitude;
	private Salle salle;

}
