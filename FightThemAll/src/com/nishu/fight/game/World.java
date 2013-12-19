package com.nishu.fight.game;

import org.lwjgl.input.Keyboard;

import com.nishu.fight.game.maps.Map;
import com.nishu.fight.utilities.Constants;
import com.nishu.utils.ScreenTools;

public class World {
	
	private Map map;
	
	private float scrollx, scrolly;
	
	public World(){
		initGL();
		init();
	}

	private void initGL(){
		ScreenTools.renderOrtho(0, Constants.WIDTH, 0, Constants.HEIGHT);
	}

	private void init(){
		map = new Map();
		map.create();
	}
	
	public void update(){
		updateInput();
		map.update();
	}
	
	private void updateInput(){
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			scrollx -= Constants.scrollSpeed;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			scrollx += Constants.scrollSpeed;
		}
	}

	public void render(){
		map.render(scrollx, scrolly);
	}

	public void dispose(){
		map.dispose();
	}
}
