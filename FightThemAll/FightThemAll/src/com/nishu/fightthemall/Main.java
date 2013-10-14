package com.nishu.fightthemall;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nishu.fightthemall.world.World;

public class Main extends Game {
	
	World w;
	SpriteBatch batch;

	@Override
	public void create() {
		batch = new SpriteBatch();
		w = new World(batch, 1024, 1024);
	}
	
	public void render(){
		Gdx.gl10.glClear(GL10.GL_COLOR_BUFFER_BIT);
		Gdx.gl10.glClearColor(0f, 0f, 0.75f, 1f);
		
		w.update();
		w.render();
	}
		
	
}
