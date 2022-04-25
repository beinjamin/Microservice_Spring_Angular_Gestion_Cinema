package com.jaures.cinema.dao;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;





@Entity
@Data


public class Ville {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double logitude,latidude,altitude;
	@OneToMany(mappedBy="ville")
	private Collection<Cinema> cinemas;

}
