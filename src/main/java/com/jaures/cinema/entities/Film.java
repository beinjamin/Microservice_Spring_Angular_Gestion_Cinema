package com.jaures.cinema.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Film {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)

	private Long id;
	private String titre;
	private String description;
	private String realisateur;
	private Date dateSortie;
	private double duree;
	private String photo;
    @OneToMany(mappedBy="film")
	private Collection<Projection> projections;
    @ManyToOne
	private Categorie categorie;
}
