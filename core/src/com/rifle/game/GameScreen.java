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
	private MainMenu mainMenu;
	private GameOver gameOver;
	 
    public GameScreen(RifleGame rifleGame) {
        this.rifleGame = rifleGame;

        world = new World(rifleGame);
        worldRenderer = new WorldRenderer(rifleGame, world);
        mainMenu = new MainMenu();
        gameOver = new GameOver();
    }
    
    private void update(float delta) {
    }
    
    @Override
    public void render(float delta) {
        update(delta);
 
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        if (mainMenu.exit) {
        	Gdx.app.exit();
        } else if (!mainMenu.start) {
        	mainMenu.render();
        } else {
        	if (world.getLife() > 0) {
            	worldRenderer.render(delta);
            } else {
            	gameOver.render();
            	if (gameOver.mainMenu) {
            		mainMenu.backToMainMenu();
            		world = new World(rifleGame);
            		worldRenderer = new WorldRenderer(rifleGame, world);
            	} else if (gameOver.tryAgain) {
            		world = new World(rifleGame);
            		worldRenderer = new WorldRenderer(rifleGame, world);
            		gameOver.tryAgainClicked();
            	}
            }
        }  
    }
}
