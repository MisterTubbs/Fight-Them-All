package com.nishu.fight;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window {

	public Window(int width, int height) {
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle("Nishu Voxels");
			Display.create();
			Mouse.setGrabbed(true);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isClosed(){
		return Display.isCloseRequested();
	}
	
	public void update(){
		Display.update();
	}
	
	public void dispose(){
		Display.destroy();
	}
}
