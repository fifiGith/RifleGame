package com.rifle.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Skull {

	private float speed = 1f;
	private int x = 810;
	private int y;
	
	private SpriteBatch batch;
	private Texture skullImg;
	private Sprite skullSprite;
	private Rectangle skullRectangle;
	
	public Skull(int randomy) {
		batch = RifleGame.batch;
		skullImg = new Texture("Skull.png");
		
		skullSprite = new Sprite(skullImg);
		skullSprite.setOriginCenter();
		
		skullRectangle = new Rectangle(skullSprite.getX(), skullSprite.getY(), skullSprite.getHeight(), skullSprite.getWidth());
		
		y = randomy;
	}
	
	public void update() {
		skullSprite.setPosition(x -= speed, y);
		skullRectangle.setPosition(x -= speed, y);
	}
	
	public Rectangle getRectangle() {
		return skullRectangle;
	}

	public void render() {
		update();
		skullSprite.draw(batch);
	}
	
	public float getX() {
		return skullSprite.getX();
	}
	
	public float getY() {
		return skullSprite.getY();
	}
	
}
