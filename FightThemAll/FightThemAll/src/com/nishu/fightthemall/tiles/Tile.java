package com.nishu.fightthemall.tiles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nishu.fightthemall.utilities.SpriteStore;

public class Tile {

	Sprite sprite;

	public Tile(int x, int y, String type) {
		this.sprite = SpriteStore.getSprite(type);
		setPos(x, y);
	}

	public void update() {

	}

	public void render(SpriteBatch batch) {
		this.sprite.draw(batch);
	}

	public void setPos(float x, float y) {
		this.sprite.setPosition(x * 32, y * 32);
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

}
