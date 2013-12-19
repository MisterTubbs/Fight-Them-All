package com.nishu.fight.game;

import org.lwjgl.input.Keyboard;

import com.nishu.fight.game.maps.Map;
import com.nishu.fight.utilities.Constants;
import com.nishu.utils.ScreenTools;

import static org.lwjgl.opengl.GL11.*;

public class World {
	
	private Map map;
	
	private float scrollx, scrolly;
	
	public World(){
		initGL();
		init();
	}

	private void initGL(){
		ScreenTools.renderOrtho(0, Constants.WIDTH, 0, Constants.HEIGHT);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
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
		while(Keyboard.next()){
			if(Keyboard.getEventKeyState()){
				if(Keyboard.isKeyDown(Keyboard.KEY_R)){
					map.create();
				}
			}
		}
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
