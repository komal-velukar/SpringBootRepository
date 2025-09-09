package com.soft.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="players")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String team;
	private int runs;

	// default constructor
	public Player() {
		super();
	}

	public Player(Long id, String name, String team, int runs) {
		super();
		this.id = id;
		this.name = name;
		this.team = team;
		this.runs = runs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", team=" + team + ", runs=" + runs + "]";
	}

	public Player orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
