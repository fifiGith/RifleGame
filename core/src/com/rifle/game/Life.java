package com.rifle.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Life {
	private int x = 10;
	private int y = 20;
	private int space = 8;
	
	private SpriteBatch batch;
	private Texture lifeImg;
	private Sprite lifeSprite;
	
	public Life(int i) {
		batch = RifleGame.batch;
		
		i += 1;

		lifeImg = new Texture("Heart.png");
		lifeSprite = new Sprite(lifeImg);
		
		x = ((int) (lifeSprite.getWidth() + space)) * i;
		
		lifeSprite.setPosition(x, y);
	}
	
	public void render() {
		lifeSprite.draw(batch);
	}
}
