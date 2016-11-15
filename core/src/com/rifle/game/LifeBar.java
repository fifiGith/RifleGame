package com.rifle.game;

import java.util.ArrayList;

public class LifeBar {
	
	World world;
	
	private int life;
	
	private ArrayList<Life> lifeList;

	public LifeBar(World world) {
		this.world = world;
		
		life = world.getLife();
		
		lifeList = new ArrayList<Life>();
	}
	
	public void update() {
		if (life < world.getLife()) {
			life = world.getLife();
		}
		
		for (int i = 0; i < life; i++) {
			lifeList.add(new Life(i));
		}
	}
	
	public void render() {
		update();
		for (Life life : lifeList) {
			life.render();
		}
	}
	
	public void remove() {
		update();
		lifeList.remove(lifeList.size() - 1);
	}
	
}
