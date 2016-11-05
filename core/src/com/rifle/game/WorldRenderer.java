package com.rifle.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private RifleGame rifleGame;
	private World world;
	private SpriteBatch batch;
	private Rifle rifle;
	private Bullet bullet;
	private Sprite rifleSprite;
	private Texture rifleImg, bulletImg, bgImg;

	public WorldRenderer(RifleGame rifleGame, World world) {
        this.rifleGame = rifleGame;
        batch = rifleGame.batch;
 
        this.world = world;
        
        rifle = world.getRifle();
        bullet = world.getBullet();
 
        rifleImg = new Texture("Rifle.png");
        bulletImg = new Texture("Bullet.png");
        bgImg = new Texture("Background.png");
        
        rifleSprite = new Sprite(rifleImg);
        rifleSprite.setOriginCenter();
        Vector2 riflePos = world.getRifle().getPosition();
        rifleSprite.setPosition(riflePos.x, riflePos.y);
    }
	
    public void render(float delta) {
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	SpriteBatch batch = rifleGame.batch;
        batch.begin();
        rifleSprite.draw(batch);
        rifleSprite.setRotation(rifle.getAngle());
//        Vector2 riflePos = world.getRifle().getPosition();
//        Vector2 bulletPos = world.getRifle().getPosition();
//        batch.draw(bgImg, 0, 0);
//        batch.draw(rifleImg, riflePos.x, riflePos.y);
//        batch.draw(bulletImg, bulletPos.x, bulletPos.y);
        batch.end();
    }
}
