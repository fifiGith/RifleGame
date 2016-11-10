package com.rifle.game;

import java.util.ArrayList;

public class World {
	
	public static final int X = 100;
	public static final int Y = 100;
	
	private Rifle rifle;
	private RifleGame rifleGame;
	private TargetGenerator targetGenerator;
	private ArrayList<Target> targetList;
	private ArrayList<Bullet> bulletList;
//	private Bullet bullet;
//	private Target target;
	
	World(RifleGame rifleGame) {
		targetGenerator = new TargetGenerator();
		rifle = new Rifle(X, Y);
	}
	
	public void removeOnCollistions() {
		update();
		for (int i = 0; i < bulletList.size(); i++) {
			for (int j = 0; j < targetList.size(); j++) {
				System.out.println(targetList.size());
				Target target = targetList.get(i);
				Bullet bullet = bulletList.get(i);
				if (target.getRectangle().overlaps(bullet.getRectangle())) {
					targetList.remove(i);
					bulletList.remove(i);
				}
			}
		}
	}
	
	public void update() {
		targetList = targetGenerator.getTargetList();
		bulletList = rifle.getBulletList();
	}
	
	TargetGenerator getTargetGenerator() {
		return targetGenerator;
	}
	
	Rifle getRifle() {
		return rifle;
	}
}
