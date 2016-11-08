package com.rifle.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

public class Rifle {
	private Vector2 position;
	private World world;
	private float angle;
	private Bullet bullet;
	private ArrayList<Bullet> bulletList;
	private Sound shot;
	 
    public Rifle(int x, int y) {
        //position = new Vector2(x - 39, y - 13);
    	position = new Vector2(x, y);
        bulletList = new ArrayList<Bullet>();
        shot = Gdx.audio.newSound(Gdx.files.internal("shot.mp3"));
    }
    
    public Vector2 getPosition() {
        return position;    
    }
    
    public void updateAngle() {
    	Vector2 cursorPos = new Vector2(Gdx.input.getX(), RifleGame.HEIGHT - Gdx.input.getY());
    	Vector2 rifleCenterPos = position;
    	angle = (float) (Math.atan2(cursorPos.y - rifleCenterPos.y, cursorPos.x - rifleCenterPos.x) * (180/Math.PI));
    	if (angle < 0) {
    		angle += 360;
    	}
    }
    
    public float getAngle() {
    	updateAngle();
    	return angle;
    }
    
    public void shoot() {
    	bulletList.add(new Bullet(this));
    	shot.play(1.0f);
    }
    
    public void update() {
    	if (Gdx.input.justTouched()) {
    	    shoot();
    	}
    	for (Bullet bullet : bulletList) {
    	    bullet.render();
    	}
    }
}
