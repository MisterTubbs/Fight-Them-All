package com.nishu.fightthemall.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Camera {
	
	private OrthographicCamera cam;
	
	private float x, y, moveSpeed = 8f;
	
	public Camera(){
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	public void update(){
		cam.update(true);
	}
	
	public void move(){
		if (Gdx.input.isKeyPressed(Keys.W)) {
			y += moveSpeed;
		}
		if (Gdx.input.isKeyPressed(Keys.S)) {
			y -= moveSpeed;
		}
		if (Gdx.input.isKeyPressed(Keys.A)) {
			x -= moveSpeed;
		}
		if (Gdx.input.isKeyPressed(Keys.D)) {
			x += moveSpeed;
		}
		
		translate(this.x, this.y);
		x = 0;
		y = 0;
	}
	
	public void translate(float x, float y) {
		cam.translate(x, y);
	}

	public OrthographicCamera getCam() {
		return cam;
	}

	public void setCam(OrthographicCamera cam) {
		this.cam = cam;
	}

}
