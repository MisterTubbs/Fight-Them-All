package com.nishu.fightthemall.world;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.nishu.fightthemall.tiles.Tile;
import com.nishu.fightthemall.utilities.Camera;

public class World {

	private Tile[][] tiles;
	private SpriteBatch batch;
	private Camera cam;

	private int width, height, sWidth, sHeight;

	public World(SpriteBatch batch, int width, int height) {
		this.batch = batch;
		this.sWidth = width;
		this.sHeight = height;
		this.width = sWidth / 8;
		this.height = sHeight / 8;
		this.cam = new Camera();
		this.tiles = new Tile[width][height];

		create();
	}

	public void create() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				System.out.println("x: " + x + " y: " + y);
				tiles[x][y] = new Tile("Grass");
			}
		}
	}

	public void update() {
		cam.update();
		cam.move();
	}

	public void render() {
		batch.begin();
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (cam.getCam().frustum.sphereInFrustum(new Vector3(x, y, 0), 8)) {
					tiles[x][y].render(x, y, batch);
				}
			}
		}
		batch.end();
	}

}
