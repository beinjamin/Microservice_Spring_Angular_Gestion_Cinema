package com.jaures.cinema.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seance {
	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	private Date heureDebut;
	

}
