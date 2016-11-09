package com.rifle.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Target {
	
	private float speed = 1f;
	private int x = 810;
	private int y;
	
	private SpriteBatch batch;
	private Texture targetImg;
	private Sprite targetSprite;
	
	public Target(int randomy) {
		batch = RifleGame.batch;
		targetImg = new Texture("Target.png");
		targetSprite = new Sprite(targetImg);
		targetSprite.setOriginCenter();
		y = randomy;
	}
	
	public void update() {
		targetSprite.setPosition(x -= speed, y);
	}
	
	public void render() {
		update();
		targetSprite.draw(batch);
	}
	
}
