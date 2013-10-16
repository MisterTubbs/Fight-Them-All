package com.nishu.fightthemall.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.nishu.fightthemall.entities.Player;

public class Camera {
	
	private OrthographicCamera cam;
	
	public Camera(){
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	public void update(Player p){
		cam.update(true);
		setPosition(p);
	}
	
	public void setPosition(Player p){
		cam.position.set(p.getX(), p.getY(), 0);
	}
	
	public void translate(Player p) {
		cam.translate(p.getX() / 2, p.getY() / 2);
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
