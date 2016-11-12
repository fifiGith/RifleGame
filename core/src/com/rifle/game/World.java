package com.rifle.game;

import java.util.ArrayList;

public class World {
	
	public static final int X = 100;
	public static final int Y = 100;
	
	private int score;
	private Rifle rifle;
	private RifleGame rifleGame;
	private TargetGenerator targetGenerator;
	private ArrayList<Target> targetList;
	private ArrayList<Bullet> bulletList;

	World(RifleGame rifleGame) {
		targetGenerator = new TargetGenerator();
		rifle = new Rifle(X, Y);
		score = 0;
	}
	
	public void removeAtEdge() {
		update();
		for (int i = 1; i < bulletList.size(); i++) {
			Bullet bullet = bulletList.get(i);
			if (bullet.getX() < -30 || bullet.getY() > RifleGame.HEIGHT) {
				bulletList.remove(i);
			}
		}
		
		for (int i = 1; i < targetList.size(); i++) {
			Target target = targetList.get(i);
			if (target.getX() < -30 || target.getY() > RifleGame.HEIGHT) {
				targetList.remove(i);
			}
		}
	}
	
	public void removeOnCollistions() {
		update();
		for (int i = 0; i < bulletList.size(); i++) {
			Bullet bullet = bulletList.get(i);
			for (int j = 0; j < targetList.size(); j++) {
				Target target = targetList.get(j);
				if (target.getRectangle().overlaps(bullet.getRectangle())) {
					targetList.remove(j);
					bulletList.remove(i);
					score += 1;
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
	
	public int getScore() {
		return score;
	}
}
