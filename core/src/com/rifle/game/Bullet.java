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
    private RifleGame rifleGame;
    public SpriteBatch batch;
	
	public Bullet(Rifle rifle) {
		vector = new Vector2();
		Vector2 pos = rifle.getPosition();
		float angle = rifle.getAngle();
		vector.set(pos);
		batch = rifleGame.batch;
		bulletImg = new Texture("Bullet.png");
		bulletSprite = new Sprite(bulletImg);
		bulletSprite.setOriginCenter();
		bulletSprite.setPosition(vector.x, vector.y);
		bulletSprite.setRotation(angle);
	}
	
	public void render(float delta) {
		bulletSprite.translate(vector.x * SPEED, vector.y * SPEED);
		batch.begin();
		bulletSprite.draw(batch);
		batch.end();
	}
}
