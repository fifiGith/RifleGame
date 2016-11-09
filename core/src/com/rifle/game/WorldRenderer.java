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
	private Texture rifleImg, bulletImg, bgImg;
	private Target target;
	private TargetGenerator targetGenerator;

	public WorldRenderer(RifleGame rifleGame, World world) {
        batch = RifleGame.batch;
        this.world = world;
        
        Pixmap pm = new Pixmap(Gdx.files.internal("Cursor.png"));
        Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm, 16, 16));
        pm.dispose();
        
        rifle = world.getRifle();
        targetGenerator = world.getTargetGenerator();
        
        bgImg = new Texture("Background.png");
    }
	
	public void update() {
		world.getRifle().update();
	}
	
    public void render(float delta) {
    	update();
        batch.begin();
        targetGenerator.render();
        rifle.render();
        batch.end();
    }
}
