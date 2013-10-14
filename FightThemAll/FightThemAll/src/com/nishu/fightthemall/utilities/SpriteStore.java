package com.nishu.fightthemall.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteStore {

	private static enum type {
		GRASS;
	}

	public static type getType(String t) {
		String str = t;
		switch (str) {
		case "Grass":
			return type.GRASS;
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
		default:
			return new Texture(Gdx.files.internal("res/tiles/grass.png"));
		}
	}

}
