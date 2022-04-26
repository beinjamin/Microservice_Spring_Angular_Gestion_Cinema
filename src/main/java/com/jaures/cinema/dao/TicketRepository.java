package com.jaures.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaures.cinema.entities.Ticket;


public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
