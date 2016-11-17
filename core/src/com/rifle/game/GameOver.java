package com.rifle.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GameOver {
	
	public boolean mainMenu;
	public boolean tryAgain;

	private int mmx, mmy;
	private int tax, tay;
	
	private MainMenu mainMenuObj;
	
	private SpriteBatch batch;
	private Texture screen;
	private Rectangle mainMenuRect;
	private Rectangle tryAgainRect;
	
	public GameOver() {
		batch = RifleGame.batch;
		screen = new Texture("GameOver.png");
		
		mainMenu = false;
		tryAgain = false;
		
		mainMenuRect = new Rectangle(298, 118, 202, 31);
		mmx = (int) (mainMenuRect.x + mainMenuRect.width);
		mmy = (int) (mainMenuRect.y + mainMenuRect.height);
		tryAgainRect = new Rectangle(306, 172, 190, 31);
		tax = (int) (tryAgainRect.x + tryAgainRect.width);
		tay = (int) (tryAgainRect.y + tryAgainRect.height);
	}
	
	public boolean mainMenu() {
		return mainMenu = true;
	}
	
	public boolean tryAgain() {
		return tryAgain = true;
	}
	
	public boolean tryAgainClicked() {
		return tryAgain = false;
	}
	
	public void update() {
		int x = Gdx.input.getX();
		int y = RifleGame.HEIGHT - Gdx.input.getY();

		if ((x >= mainMenuRect.x && x <= mmx) && (y >= mainMenuRect.y && y <= mmy)) {
			screen = new Texture("GameOverMenu.png");
			if (Gdx.input.justTouched()) {
				mainMenu();
			}
		} else if ((x >= tryAgainRect.x && x <= tax) && (y >= tryAgainRect.y && y <= tay)) {
			screen = new Texture("TryAgain.png");
			if (Gdx.input.justTouched()) {
				tryAgain();
			}
		} else {
			screen = new Texture("GameOver.png");
		}
	}
	
	public void render() {
		update();
		batch.begin();
		batch.draw(screen, 0, 0);
		batch.end();
	}
}
