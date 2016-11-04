package com.rifle.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Rifle {
	private Vector2 position;
	private World world;
	private double angle;
	 
    public Rifle(int x, int y) {
        position = new Vector2(x,y);
    }
    
    public Vector2 getPosition() {
        return position;    
    }
    
    public void updateAngle() {
    	Vector2 cursorPos = new Vector2(Gdx.input.getX(), RifleGame.HEIGHT - Gdx.input.getY());
    	Vector2 rifleCenterPos = position;
    	angle = Math.atan2(cursorPos.y - rifleCenterPos.y, cursorPos.x - rifleCenterPos.x) * (180/Math.PI);
    	if (angle < 0) {
    		angle += 360;
    	}
    }
    
    public double getAngle() {
    	updateAngle();
    	return angle;
    }
}
