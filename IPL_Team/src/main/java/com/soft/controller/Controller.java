package com.soft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soft.model.Player;
import com.soft.service.PlayerService;


@RestController
@RequestMapping("/players")
public class Controller {
	
	@Autowired
	private PlayerService playerservice;
	
	@GetMapping
	public List<Player> getAllPlayer(){
		return playerservice.getAllPLayers();
	}
	
	@GetMapping("/{id}")
	public Player getPlayerById(@PathVariable Long id) {
		return playerservice.getPlayerById(id);
	}
	@PostMapping
	public Player addPlayer(@RequestBody Player player) {
		return playerservice.addPlayer(player);
	}
	@PutMapping("/{id}")
public Player updatePlayer(@PathVariable Long id, @RequestBody Player player) {
	return playerservice.updateplayer(id, player);
}
	@DeleteMapping
	public void deletePlayer(@PathVariable Long id) {
		playerservice.deletePlayer(id);
	}
}
