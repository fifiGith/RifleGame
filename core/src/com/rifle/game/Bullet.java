package com.rifle.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bullet {
	public static final float SPEED = 60f;
	
	private Vector2 vector;
    private Sprite bulletSprite;
    private Texture bulletImg;
    public SpriteBatch batch;
	
	public Bullet(Rifle rifle) {
		vector = new Vector2();
		Vector2 pos = rifle.getPosition();
		float angle = rifle.getAngle();
		vector.set((float)Math.cos(angle * Math.PI / 180),(float)Math.sin(angle * Math.PI / 180));
		this.batch = RifleGame.batch;
		bulletImg = new Texture("LongBullet.png");
		bulletSprite = new Sprite(bulletImg);
		bulletSprite.setOriginCenter();
		bulletSprite.setPosition(pos.x, pos.y);
		bulletSprite.setRotation(angle);
	}
	
	public void render() {
		bulletSprite.translate(vector.x * SPEED, vector.y * SPEED);
		batch.begin();
		bulletSprite.draw(batch);
		batch.end();
	}
}
