package com.nishu.fightthemall.tiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nishu.fightthemall.utilities.SpriteStore;

public class Tile {
	
	Sprite sprite;
	
	public Tile(String type){
		this.sprite = SpriteStore.getSprite(type);
	}
	
	public void update(){
		
	}
	
	public void render(float x, float y, SpriteBatch batch){
		setPos(x, y);
		getSprite().draw(batch);
	}
	
	public void setPos(float x, float y){
		getSprite().setPosition(x * 8, y * 8);
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

}
