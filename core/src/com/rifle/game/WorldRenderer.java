package com.rifle.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
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
//        this.rifleGame = rifleGame;
        batch = RifleGame.batch;
 
        this.world = world;
        
        Pixmap pm = new Pixmap(Gdx.files.internal("Cursor.png"));
        Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm, 16, 16));
        pm.dispose();
        
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
    	world.getRifle().update();
        batch.begin();
        rifleSprite.draw(batch);
        rifleSprite.setRotation(rifle.getAngle());
        batch.end();
    }
}
