package com.nishu.fight.utilities;

import static org.lwjgl.opengl.GL11.*;

public class Shape {
	
	public static void renderTile(int x, int y, float[] texCoords){
		glTexCoord2f(texCoords[0], texCoords[1] + Spritesheet.tiles.uniformSize());
		glVertex2f(x, y);
		glTexCoord2f(texCoords[0] + Spritesheet.tiles.uniformSize(), texCoords[1] + Spritesheet.tiles.uniformSize());
		glVertex2f(x + Constants.TILE_SIZE, y);
		glTexCoord2f(texCoords[0] + Spritesheet.tiles.uniformSize(), texCoords[1]);
		glVertex2f(x + Constants.TILE_SIZE, y + Constants.TILE_SIZE);
		glTexCoord2f(texCoords[0], texCoords[1]);
		glVertex2f(x, y + Constants.TILE_SIZE);
	}

}
