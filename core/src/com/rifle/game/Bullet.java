package com.rifle.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bullet {
	private float SPEED = 8f;
	
	private Vector2 vector;
    private Sprite bulletSprite;
    private Texture bulletImg;
    private SpriteBatch batch;
    private Rectangle bulletRectangle;
	
	public Bullet(Rifle rifle) {
		vector = new Vector2();
		float angle = rifle.getAngle();
		vector.set((float)Math.cos(angle * Math.PI / 180), (float)Math.sin(angle * Math.PI / 180));
		
		batch = RifleGame.batch;
		bulletImg = new Texture("LongBullet.png");
		
		bulletSprite = new Sprite(bulletImg);
		bulletSprite.setOriginCenter();
		bulletSprite.setPosition(World.X , World.Y);
		bulletSprite.setRotation(angle);
		
		bulletRectangle = new Rectangle(bulletSprite.getX(), bulletSprite.getY(), bulletSprite.getHeight(), bulletSprite.getWidth());
		bulletRectangle.setPosition(World.X, World.Y);
	}
	
	public Rectangle getRectangle() {
		return bulletRectangle;
	}
	
	public void update() {
		bulletSprite.translate(vector.x * SPEED, vector.y * SPEED);
		bulletRectangle.setPosition(getX(), getY());
	}
	
	public void render() {
		update();
		bulletSprite.draw(batch);
	}
	
	public float getX() {
		return bulletSprite.getX();
	}
	
	public float getY() {
		return bulletSprite.getY();
	}
}
