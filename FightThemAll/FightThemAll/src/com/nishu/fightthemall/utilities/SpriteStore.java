package com.nishu.fightthemall.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteStore {

	private static enum type {
		GRASS, DIRT, TEST;
	}

	public static type getType(String t) {
		String str = t;
		switch (str) {
		case "Grass":
			return type.GRASS;
		case "Dirt":
			return type.DIRT;
		case "test":
			return type.TEST;
		default:
			return type.GRASS;
		}
	}

	public static Sprite getSprite(String t) {
		type tiletype = getType(t);
		if(tiletype != null){
			Sprite s = new Sprite(getTexLoc(tiletype));
			return s;
		}
		return null;
	}
	
	private static Texture getTexLoc(type t){
		switch(t){
		case GRASS:
			return new Texture(Gdx.files.internal("res/tiles/grass.png"));
		case DIRT:
			return new Texture(Gdx.files.internal("res/tiles/dirt.png"));
		case TEST:
			return new Texture(Gdx.files.internal("res/player/test.png"));
		default:
			return new Texture(Gdx.files.internal("res/tiles/grass.png"));
		}
	}

}
