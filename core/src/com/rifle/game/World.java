package com.rifle.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class World {
	
	public static final int X = 100;
	public static final int Y = 100;
	
	private int score;
	private Rifle rifle;
	private RifleGame rifleGame;
	private TargetGenerator targetGenerator;
	private ArrayList<Target> targetList;
	private ArrayList<Bullet> bulletList;
	private Sound pop;
	private ArrayList<Skull> skullList;
	

	World(RifleGame rifleGame) {
		targetGenerator = new TargetGenerator();
		rifle = new Rifle(X, Y);
		score = 0;
		pop = Gdx.audio.newSound(Gdx.files.internal("cutePop.mp3"));
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
		
		for (int i = 1; i < skullList.size(); i++) {
			Skull skull = skullList.get(i);
			if (skull.getX() < -30 || skull.getY() > RifleGame.HEIGHT) {
				skullList.remove(i);
			}
		}
	}
	
	public void removeOnCollistions() {
		update();
		
		//bullet + target
		for (int i = 0; i < bulletList.size(); i++) {
			Bullet bullet = bulletList.get(i);
			for (int j = 0; j < targetList.size(); j++) {
				Target target = targetList.get(j);
				if (target.getRectangle().overlaps(bullet.getRectangle())) {
					pop.play(100.0f);
					targetList.remove(j);
					bulletList.remove(i);
					score += 1;
				}
			}
		}
		
		//bullet + skull
		for (int i = 0; i < bulletList.size(); i++) {
			Bullet bullet = bulletList.get(i);
			for (int j = 0; j < skullList.size(); j++) {
				Skull skull = skullList.get(j);
				if (skull.getRectangle().overlaps(bullet.getRectangle())) {
					pop.play(100.0f);
					skullList.remove(j);
					bulletList.remove(i);
				}
			}
		}
	}
	
	public void update() {
		targetList = targetGenerator.getTargetList();
		bulletList = rifle.getBulletList();
		skullList = targetGenerator.getSkullList();
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
