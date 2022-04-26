package com.jaures.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaures.cinema.entities.Place;


public interface PlaceRepository extends JpaRepository<Place, Long> {

}
