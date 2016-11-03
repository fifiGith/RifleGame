package com.rifle.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Rifle {
	private Vector2 position;
	private World world;
	private float angle;
	 
    public Rifle(int x, int y) {
        position = new Vector2(x,y);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
}
