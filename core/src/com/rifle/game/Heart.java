package com.rifle.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Heart {
	private float speed = 1f;
	private int x = 810;
	private int y;
	
	private SpriteBatch batch;
	private Texture heartImg;
	private Sprite heartSprite;
	private Rectangle heartRectangle;
	
	public Heart(int randomy) {
		batch = RifleGame.batch;
		heartImg = new Texture("Heart.png");
		
		heartSprite = new Sprite(heartImg);
		heartSprite.setOriginCenter();
		
		heartRectangle = new Rectangle(heartSprite.getX(), heartSprite.getY(), heartSprite.getHeight(), heartSprite.getWidth());
		
		y = randomy;
	}
	
	public void update() {
		heartSprite.setPosition(x -= speed, y);
		heartRectangle.setPosition(x -= speed, y);
	}
	
	public Rectangle getRectangle() {
		return heartRectangle;
	}

	public void render() {
		update();
		heartSprite.draw(batch);
	}
	
	public float getX() {
		return heartSprite.getX();
	}
	
	public float getY() {
		return heartSprite.getY();
	}
}
