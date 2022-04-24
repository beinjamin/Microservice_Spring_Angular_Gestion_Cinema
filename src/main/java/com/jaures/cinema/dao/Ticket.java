package com.jaures.cinema.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nomClient;
	private double prix;
	private int codePayement;
	private boolean reserve;
	@ManyToOne
	private Place place;
	@ManyToOne
	private Projection projection;

}
