package com.nishu.fight.game.maps;

import static org.lwjgl.opengl.GL11.GL_COMPILE;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glCallList;
import static org.lwjgl.opengl.GL11.glDeleteLists;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glEndList;
import static org.lwjgl.opengl.GL11.glGenLists;
import static org.lwjgl.opengl.GL11.glNewList;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;

import com.nishu.fight.game.tiles.Tile;
import com.nishu.fight.game.tiles.tileobjects.Tree;
import com.nishu.fight.utilities.Constants;
import com.nishu.fight.utilities.Shape;
import com.nishu.fight.utilities.Spritesheet;

public class Map {

	private byte[][] tiles;

	public static int mx = (Constants.WIDTH * 4) / Constants.TILE_SIZE;
	public static int my = Constants.HEIGHT / Constants.TILE_SIZE + 1;

	private int tileID;

	public Map() {
		initGL();
	}

	private void initGL() {
		tileID = glGenLists(1);
	}

	public void create() {
		tiles = new byte[mx][my];
		glNewList(tileID, GL_COMPILE);
		glBegin(GL_QUADS);
		for (int x = 0; x < mx; x++) {
			for (int y = 0; y < my; y++) {
				tiles[x][y] = Tile.Air.getID();
				if (y < Constants.HEIGHT / 2 / Constants.TILE_SIZE) {
					tiles[x][y] = Tile.Stone.getID();
				}
				if (y == Constants.HEIGHT / 2 / Constants.TILE_SIZE) {
					tiles[x][y] = Tile.TopGrass.getID();
				}
				if (Constants.rand.nextInt(6) == 0 && y == Constants.HEIGHT / 2 / Constants.TILE_SIZE + 1) {
					tiles[x][y] = Tile.Grass.getID();
				}
				Shape.renderTile(x * Constants.TILE_SIZE, y * Constants.TILE_SIZE, Tile.getTile(tiles[x][y]).getTexCoords());
			}
		}
		for (int x = 0; x < mx; x++) {
			for (int y = 0; y < my; y++) {
				if (Constants.rand.nextInt(10) == 0 && y > 1) {
					if (tiles[x][y - 1] == Tile.TopGrass.getID()) {
						tiles = new Tree().getObject(tiles, x, y);
					}
				}
				Shape.renderTile(x * Constants.TILE_SIZE, y * Constants.TILE_SIZE, Tile.getTile(tiles[x][y]).getTexCoords());
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
		glCallList(tileID);
		glPopMatrix();
	}

	public void dispose() {
		glDeleteLists(tileID, 1);
	}
}
