package com.rifle.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Target {
	
	private float speed = 1f;
	private int x = 810;
	private int y;
	
	private SpriteBatch batch;
	private Texture targetImg;
	private Sprite targetSprite;
	private Rectangle targetRectangle;
	
	public Target(int randomy) {
		batch = RifleGame.batch;
		targetImg = new Texture("Target.png");
		
		targetSprite = new Sprite(targetImg);
		targetSprite.setOriginCenter();
		
		targetRectangle = new Rectangle(targetSprite.getX(), targetSprite.getY(), targetSprite.getHeight(), targetSprite.getWidth());
		
		y = randomy;
	}
	
	public void update() {
		targetSprite.setPosition(x -= speed, y);
		targetRectangle.setPosition(x -= speed, y);
	}
	
	public Rectangle getRectangle() {
		return targetRectangle;
	}

	public void render() {
		update();
		targetSprite.draw(batch);
	}
	
	public float getX() {
		return targetSprite.getX();
	}
	
	public float getY() {
		return targetSprite.getY();
	}
}
