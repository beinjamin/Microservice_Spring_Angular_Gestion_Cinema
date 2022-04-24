package com.jaures.cinema.dao;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {
	private Long id;
	private String name;
	@OneToMany(mappedBy="categorie")
	private Collection<Film> films;

}
