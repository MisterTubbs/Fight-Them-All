package com.nishu.fightthemall.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nishu.fightthemall.utilities.SpriteStore;

public class Player extends Entity{
	
	Sprite sprite;
	private final float MOVESPEED = 4f;

	public Player(int id, float x, float y) {
		super(id, x, y);
		sprite = SpriteStore.getSprite("test");
		getSprite().setPosition(x, y);
	}

	@Override
	public void render(SpriteBatch batch) {
		getSprite().draw(batch);
	}

	@Override
	public void update(float delta) {
		move();
	}
	
	private void move(){
		if(getRand().nextInt(10) == 0){
			int dir = getRand().nextInt(2);
			if(dir == 0) addX(1 * MOVESPEED);
			if(dir == 1) subX(1 * MOVESPEED);
		}
		getSprite().setPosition(getX(), getY());
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

}
