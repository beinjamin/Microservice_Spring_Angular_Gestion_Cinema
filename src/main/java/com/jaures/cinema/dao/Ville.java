package com.jaures.cinema.dao;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GenerationType;




@Entity
@Data
@NoArgsContructor
@ArgsConstructor
public class Ville {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private String name;
	private double logitude,latidude,altitude;
	private Collection<Cinema> cinemas;

}
