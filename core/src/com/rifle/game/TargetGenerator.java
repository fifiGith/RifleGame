package com.rifle.game;

import java.util.ArrayList;

public class TargetGenerator {
	
	private int min = 300;
	private int max = 600;
	private int chance = 10;
			
	private int randomy;
	
	private Target target;
	private ArrayList<Target> targetList;

	public TargetGenerator() {
		targetList = new ArrayList<Target>();
	}
	
	ArrayList<Target> getTargetList() {
		return targetList;
	}
	
	public void random() {
		randomy = (int) Math.round((Math.random() * (max - min)) + min);
	}
	
	public void update() {
		if ((Math.random() * 100) <= chance) {
			random();
		    targetList.add(new Target(randomy));	
		}
	}
	
	public void render() {
		update();
		for (Target target : targetList) {
			target.render();
    	}
	}
}
