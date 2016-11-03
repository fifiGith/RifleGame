package com.rifle.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private RifleGame rifleGame;
	private World world;
	private Texture rifleImg;
	private SpriteBatch batch;
	private Rifle rifle;

	public WorldRenderer(RifleGame rifleGame, World world) {
        this.rifleGame = rifleGame;
        batch = rifleGame.batch;
 
        this.world = world;
 
        rifleImg = new Texture("Rifle.png");
        
        rifle = world.getRifle();
    }
	
    public void render(float delta) {
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	SpriteBatch batch = rifleGame.batch;
        batch.begin();
        Vector2 pos = world.getRifle().getPosition();
        batch.draw(rifleImg, pos.x, pos.y);
        batch.end();
    }
}
