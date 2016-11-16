package com.rifle.game;

import java.util.ArrayList;

public class LifeBar {
	
	World world;
	
	private int size;
	
	private ArrayList<Life> lifeList;

	public LifeBar(World world) {
		this.world = world;
		
		lifeList = new ArrayList<Life>();
	}
	
	public void update() {
		size = world.getLife();
		
		for (int i = 0; i < size; i++) {
			lifeList.add(new Life(i));
		}
	}
	
	public void render() {
		update();
		for (int i = 0; i < lifeList.size() - 1; i++) {
			Life life = lifeList.get(i);
			life.render(i);
		}
	}
	
	public void remove() {
		update();
		if (lifeList.size() > 0) {
			lifeList.remove(lifeList.size() - 1);
		}
	}
	
	public ArrayList<Life> getLifeList() {
		return lifeList;
	}
}
