package com.rifle.game;

import com.badlogic.gdx.math.Vector2;

public class Bullet {
	public static final int SPEED = 25;
	
	private Vector2 position;
	
	public Bullet(int x, int y) {
		position = new Vector2(x, y);
	}
	
	public Vector2 getPosition() {
		return position;
	}
}
