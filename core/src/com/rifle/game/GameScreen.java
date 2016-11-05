package com.rifle.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
	
	private RifleGame rifleGame;
	private Texture rifleImg;
	private Rifle rifle;
	private World world;
	private WorldRenderer worldRenderer;
	 
    public GameScreen(RifleGame rifleGame) {
        this.rifleGame = rifleGame;

        world = new World(rifleGame);
        worldRenderer = new WorldRenderer(rifleGame, world);
    }
    
    private void update(float delta) {
    	if (Gdx.input.justTouched()) {
    		
    	}
    }
    
    @Override
    public void render(float delta) {
        update(delta);
 
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
 
        worldRenderer.render(delta);
    }
}
