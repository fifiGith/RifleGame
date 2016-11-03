package com.rifle.game;

public class World {
	private Rifle rifle;
	private RifleGame rifleGame;
	
	World(RifleGame rifleGame) {
		this.rifleGame = rifleGame;
		
		rifle = new Rifle(100, 100);
	}
	
	Rifle getRifle() {
		return rifle;
	}
}
