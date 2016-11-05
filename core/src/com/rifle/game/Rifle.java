package com.rifle.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Rifle {
	private Vector2 position;
	private World world;
	private float angle;
	private Bullet bullet;
	 
    public Rifle(int x, int y) {
        position = new Vector2(x,y);
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
    	bullet = new Bullet(this);
    	bullet.render(1);
    }
}
