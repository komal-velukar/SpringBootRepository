package com.soft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.model.Player;
import com.soft.repository.Repository;

@Service
public class PlayerService {

	@Autowired
	private Repository  repository;
	public List<Player> getAllPLayers(){
		return repository.findAll();
	}
	
	public Player getPlayerById(Long id) {
		return repository.getById(id).orElse(null);
		
	}
	public Player addPlayer(Player player) {
		return repository.save(player);
	}
	public Player updateplayer(Long id,Player updateplayer) {
		Player existingPlayer =repository.findById(id).orElse(null);
		if(existingPlayer !=null) {
			existingPlayer.setName(updateplayer.getName());
			existingPlayer.setTeam(updateplayer.getTeam());
			existingPlayer.setRuns(updateplayer.getRuns());
			return repository.save(existingPlayer);
		}
		return null;
	}
	public void deletePlayer(Long id) {
		repository.deleteById(id);
		
	}
	//public void deletePlayer(Team name) {
		//repository.deleteByname(id);
		
}
