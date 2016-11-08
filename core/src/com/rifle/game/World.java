package com.rifle.game;

public class World {
	private Rifle rifle;
	private RifleGame rifleGame;
	private Bullet bullet;
	private Target target;
	
	public static final int X = 100;
	public static final int Y = 100;
	
	World(RifleGame rifleGame) {
		this.rifleGame = rifleGame;

		rifle = new Rifle(X, Y);
	}
	
	Rifle getRifle() {
		return rifle;
	}
}
