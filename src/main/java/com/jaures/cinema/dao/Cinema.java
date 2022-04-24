package com.jaures.cinema.dao;

import java.io.Serializable;

import javax.persistence.GenerationType;

@Entity
public class Cinema implements Serializable  {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	private String name;
	private double longitude,latitude,altitude;
	private int nombreSalles;

}
