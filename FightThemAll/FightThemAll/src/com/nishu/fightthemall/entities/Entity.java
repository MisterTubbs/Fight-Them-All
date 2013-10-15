package com.nishu.fightthemall.entities;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Entity {
	
	private float x, y;
	private int id;
	private Random rand;
	
	public Entity(int id, float x, float y){
		this.id = id;
		this.x = x;
		this.y = y;
		this.rand = new Random();
	}

	public abstract void render(SpriteBatch batch);
	public abstract void update(float delta);
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addX(float x){
		setX(x += getX());
	}
	
	public void addY(float Y){
		setY(Y += getY());
	}
	
	public void subX(float x){
		float lx = getX();
		setX(lx -= x);
	}
	
	public void subY(float Y){
		float ly = getY();
		setY(ly -= y);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}
	
}
