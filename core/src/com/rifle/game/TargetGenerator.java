package com.rifle.game;

import java.util.ArrayList;

public class TargetGenerator {
	
	private int randomy;
	
	private Target target;
	private ArrayList<Target> targetList;

	public TargetGenerator() {
		targetList = new ArrayList<Target>();
	}
	
	public void random() {
		randomy = (int) Math.round((Math.random() * 300) + 300);
	}
	
	public void update() {
		random();
	    targetList.add(new Target(randomy));
	}
	
	public void render() {
		update();
		System.out.println(randomy);
		for (Target target : targetList) {
			target.render();
    	}
	}
}
