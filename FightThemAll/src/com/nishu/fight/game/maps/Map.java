package com.nishu.fight.game.maps;

import com.nishu.fight.game.tiles.Tile;
import com.nishu.fight.utilities.Constants;
import com.nishu.fight.utilities.Shape;
import com.nishu.fight.utilities.Spritesheet;

import static org.lwjgl.opengl.GL11.*;

public class Map {

	private byte[][] tiles;

	public static int mx = (Constants.WIDTH * 4) / Constants.TILE_SIZE;
	public static int my = Constants.HEIGHT / Constants.TILE_SIZE + 1;

	private int renderID;

	public Map() {
		initGL();
	}

	private void initGL() {
		renderID = glGenLists(1);
	}

	public void create() {
		tiles = new byte[mx][my];
		glNewList(renderID, GL_COMPILE);
		glBegin(GL_QUADS);
		for (int x = 0; x < mx; x++) {
			for (int y = 0; y < my; y++) {
				tiles[x][y] = 1;
				if(y == Constants.HEIGHT / 2 / Constants.TILE_SIZE) tiles[x][y] = 2;
				if (y > Constants.HEIGHT / 2 / Constants.TILE_SIZE)
					tiles[x][y] = -1;
				if (tiles[x][y] != -1) {
					Shape.renderTile(x * Constants.TILE_SIZE, y * Constants.TILE_SIZE, Tile.getTile(tiles[x][y]).getTexCoords());
				}
			}
		}
		glEnd();
		glEndList();
	}

	public void update() {
	}

	public void render(float scrollx, float scrolly) {
		Spritesheet.tiles.bind();
		glPushMatrix();
		glTranslatef(scrollx, scrolly, 0);
		glCallList(renderID);
		glPopMatrix();
	}

	public void dispose() {
		glDeleteLists(renderID, 1);
	}
}
