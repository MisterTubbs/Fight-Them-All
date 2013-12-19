package com.nishu.fight;

import org.lwjgl.input.Keyboard;

import com.nishu.fight.game.World;
import com.nishu.fight.utilities.Constants;
import com.nishu.utils.Color4f;
import com.nishu.utils.GameLoop;
import com.nishu.utils.Screen;
import com.nishu.utils.ScreenTools;
import com.nishu.utils.Window;

public class Main extends Screen {

	private GameLoop loop;
	private World world;

	public Main() {
		loop = new GameLoop();
		loop.setScreen(this);
		loop.start(60);
	}

	@Override
	public void init() {
		world = new World();
	}

	@Override
	public void initGL() {
	}

	@Override
	public void render() {
		ScreenTools.clearScreen(false, new Color4f(0, 0.1f, 0.75f, 1));
		world.render();
	}

	@Override
	public void update() {
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			dispose();
		}
		world.update();
	}

	@Override
	public void dispose() {
		world.dispose();
		Window.dispose();
		System.exit(0);
	}

	public static void main(String[] args) {
		Window.createWindow(Constants.WIDTH, Constants.HEIGHT, false);
		new Main();
	}

}
