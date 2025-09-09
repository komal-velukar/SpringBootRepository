package com.soft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soft.model.Player;



public interface Repository extends JpaRepository<Player,Long> {

}
