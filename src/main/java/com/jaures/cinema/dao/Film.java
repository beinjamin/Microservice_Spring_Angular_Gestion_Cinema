package com.jaures.cinema.dao;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Film {
	private Long id;
	private String titre;
	private String description;
	private String realisateur;
	private Date dateSortie;
	private double duree;
	private String photo;
	
    @OneToMany(mappedBy="film")
	private Collection<Projection> projections;
	private Categorie categorie;
}
