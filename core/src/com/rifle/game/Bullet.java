package com.rifle.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bullet {
	public static final int SPEED = 25;
	
	private Vector2 vector;
    private Sprite bulletSprite;
    private Texture bulletImg;
    private Rifle rifle;
    public SpriteBatch batch;
	
	public Bullet(Vector2 pos, float angle) {
		vector = new Vector2();
//		Vector2 pos = rifle.getPosition();
//		float angle = rifle.getAngle();
		vector.set(pos);
		batch = RifleGame.batch;
		bulletImg = new Texture("BulletTest.png");
		bulletSprite = new Sprite(bulletImg);
		bulletSprite.setOriginCenter();
		bulletSprite.setPosition(vector.x, vector.y);
		bulletSprite.setRotation(angle);
	}
	
	public void render() {
		bulletSprite.translate(vector.x * SPEED, vector.y * SPEED);
		System.out.println("Bullet");
		batch.begin();
		bulletSprite.draw(batch);
		batch.end();
	}
}
