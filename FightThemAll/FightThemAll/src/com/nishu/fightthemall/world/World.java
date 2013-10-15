package com.nishu.fightthemall.world;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.nishu.fightthemall.entities.Player;
import com.nishu.fightthemall.net.Client;
import com.nishu.fightthemall.net.Server;
import com.nishu.fightthemall.noise.SimplexNoise;
import com.nishu.fightthemall.tiles.Tile;
import com.nishu.fightthemall.utilities.Camera;
import com.nishu.fightthemall.utilities.Screenshot;

public class World {

	private Tile[][] tiles;
	private SpriteBatch batch;
	private Camera cam;

	private Server server;
	private Client client;
	
	private Player p;

	private int width, height, sWidth, sHeight;

	Random rand;

	public World(SpriteBatch batch, int width, int height) {
		this.batch = batch;
		this.sWidth = width;
		this.sHeight = height;
		this.width = sWidth / 32;
		this.height = sHeight / 32;
		this.cam = new Camera();
		this.tiles = new Tile[width][height];
		this.rand = new Random();
		this.client = new Client("localhost");
		this.client.start();
		this.server = new Server();
		this.server.start();
		this.p = new Player(1, rand.nextInt(sHeight), 15);

		for (int i = 0; i < 5; i++) {
			create();
		}
	}

	public void create() {
		int l = rand.nextInt(64) + 1;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				double h = SimplexNoise.noise(x / l, 16) * 32;
				if (y + h < height && y + h > 0) {
					int _y = (int) ((int) y + h);
					tiles[x][(int) (_y)] = getTile((int) x, _y);
				}
			}
		}
	}

	private Tile getTile(int x, int y) {
		if (y >= 15) {
			if (rand.nextInt(20) == 0) {
				return new Tile(x, y, "Dirt");
			}
			if (rand.nextInt(1) == 0) {
				return new Tile(x, y, "Grass");
			}
		}
		return new Tile(x, y, "Dirt");
	}

	public void update(float delta) {
		cam.move();

		//client.send("Hello World".getBytes());

		p.update(delta);
		
		if (Gdx.input.isKeyPressed(Keys.R)) {
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					tiles[x][y] = null;
				}
			}
			for (int i = 0; i < 5; i++) {
				create();
			}
		}
		if (Gdx.input.isKeyPressed(Keys.F3)) {
			Screenshot s = new Screenshot();
			s.getScreenshot(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);
			s.saveScreenshot();
		}
	}

	public void render() {
		cam.update();
		batch.begin();

		batch.setProjectionMatrix(cam.getCam().combined);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (cam.getCam().frustum.sphereInFrustum(new Vector3(x * 32, y * 32, 0), 32)) {
					if (tiles[x][y] != null) {
						tiles[x][y].render(batch);
					}
				}
			}
		}
		p.render(batch);
		batch.end();
	}

}
