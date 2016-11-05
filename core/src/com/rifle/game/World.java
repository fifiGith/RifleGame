package com.rifle.game;

public class World {
	private Rifle rifle;
	private RifleGame rifleGame;
	private Bullet bullet;
	
	public static final int X = 300;
	public static final int Y = 300;
	
	World(RifleGame rifleGame) {
		this.rifleGame = rifleGame;
		
		rifle = new Rifle(X, Y);
	}
	
	Rifle getRifle() {
		return rifle;
	}
	
	Bullet getBullet() {
		return bullet;
	}
}
