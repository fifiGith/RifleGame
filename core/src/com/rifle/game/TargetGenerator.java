package com.rifle.game;

import java.util.ArrayList;

public class TargetGenerator {
	
	private int min = 300;
	private int max = 550;
	
	private float chance = 1.85f;
	private float skullChance = 0.30f;
	private float heartChance = 0.25f;
			
	private int randomy;
	
	private ArrayList<Target> targetList;
	private ArrayList<Skull> skullList;
	private ArrayList<Heart> heartList;

	public TargetGenerator() {
		targetList = new ArrayList<Target>();
		skullList = new ArrayList<Skull>();
		heartList = new ArrayList<Heart>();
	}
	
	ArrayList<Target> getTargetList() {
		return targetList;
	}
	
	ArrayList<Skull> getSkullList() {
		return skullList;
	}
	
	ArrayList<Heart> getHeartList() {
		return heartList;
	}
	
	public void random() {
		randomy = (int) Math.round((Math.random() * (max - min)) + min);
	}
	
	public void update() {
		if ((Math.random() * 100) <= chance) {
			random();
		    targetList.add(new Target(randomy));	
		}
		
		if ((Math.random() * 100) <= skullChance) {
			random();
			skullList.add(new Skull(randomy));
		}
		
		if ((Math.random() * 100) <= heartChance) {
			random();
			heartList.add(new Heart(randomy));	
		}
	}
	
	public void render() {
		update();
		for (Target target : targetList) {
			target.render();
    	}
		for (Skull skull : skullList) {
			skull.render();
    	}
		for (Heart heart : heartList) {
			heart.render();
    	}
	}
}
