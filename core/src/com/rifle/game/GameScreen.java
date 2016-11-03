package com.rifle.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	
	private RifleGame rifleGame;
	private Texture rifleImg;
	 
    public GameScreen(RifleGame rifleGame) {
        this.rifleGame = rifleGame;
        rifleImg = new Texture("Rifle.png");
    }
    
    @Override
    public void render(float delta) {
    	SpriteBatch batch = rifleGame.batch;
        batch.begin();
        batch.draw(rifleImg, 100, 100);
        batch.end();
    }
}
