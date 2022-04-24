package com.jaures.cinema.dao;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cinema implements Serializable  {
	private Long id ;
	private String name;
	private double longitude,latitude,altitude;
	private int nombreSalles;

}
