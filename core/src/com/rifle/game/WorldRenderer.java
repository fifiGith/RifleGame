package com.rifle.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private RifleGame rifleGame;
	private World world;
	private SpriteBatch batch;
	private Rifle rifle;
	private Bullet bullet;
	private Texture heartImg, bgImg;
	private Target target;
	private TargetGenerator targetGenerator;
	private BitmapFont font;

	public WorldRenderer(RifleGame rifleGame, World world) {
        batch = RifleGame.batch;
        this.world = world;
        
        font = new BitmapFont();
        
        Pixmap pm = new Pixmap(Gdx.files.internal("Cursor.png"));
        Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm, 16, 16));
        pm.dispose();
        
        rifle = world.getRifle();
        targetGenerator = world.getTargetGenerator();
        
        bgImg = new Texture("Background.png");
        heartImg = new Texture("Heart.png");
    }
	
	public void update() {
		world.removeOnCollisions();
		world.removeAtEdge();
	}
	
    public void render(float delta) {
    	update();
        batch.begin();
        batch.draw(bgImg, 0, 0);
        rifle.render();
        targetGenerator.render();
        font.draw(batch, "Score: " + world.getScore(), 300, 50);
        font.draw(batch," X " + world.getLife(), 450, 50);
        batch.draw(heartImg, 415, 35);
        batch.end();
    }
}
