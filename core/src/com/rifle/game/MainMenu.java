package com.rifle.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class MainMenu {

	public boolean start;
	public boolean exit;
	
	private int srx, sry;
	private int erx, ery;
	
	private SpriteBatch batch;
	private Texture screen;
	private Rectangle startRectangle;
	private Rectangle exitRectangle;

	public MainMenu() {
		start = false;
		exit = false;
		
		batch = RifleGame.batch;
		screen = new Texture("MainMenu.png");
		
		startRectangle = new Rectangle(317, 250, 171, 50);
		srx = (int) (startRectangle.x + startRectangle.width);
		sry = (int) (startRectangle.y + startRectangle.height);
		exitRectangle = new Rectangle(326, 158, 140, 50);
		erx = (int) (startRectangle.x + startRectangle.width);
		ery = (int) (startRectangle.y + startRectangle.height);
	}
	
	public boolean start() {
		return start = true;
	}
	
	public boolean exit() {
		return exit = true;
	}
	
	public boolean backToMainMenu() {
		return start = false;
	}
	
	public void update() {
		int x = Gdx.input.getX();
		int y = RifleGame.HEIGHT - Gdx.input.getY();

		if ((x >= startRectangle.x && x <= srx) && (y >= startRectangle.y && y <= sry)) {
			screen = new Texture("Start.png");
			if (Gdx.input.justTouched()) {
				GameScreen.click.play(1.0f);
				start();
			}
		} else if ((x >= exitRectangle.x && x <= erx) && (y >= exitRectangle.y && y <= ery)) {
			screen = new Texture("Exit.png");
			if (Gdx.input.justTouched()) {
				GameScreen.click.play(1.0f);
				exit();
			}
		} else {
			screen = new Texture("MainMenu.png");
		}
	}
	
	public void render() {
		update();
		batch.begin();
		batch.draw(screen, 0, 0);
		batch.end();
	}
}
