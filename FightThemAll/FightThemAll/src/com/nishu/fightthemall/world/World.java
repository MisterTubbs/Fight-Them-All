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
		this.p = new Player(1, rand.nextInt(sWidth), 512, this);

		create();
	}

	public void create() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				double h = SimplexNoise.noise(x / 100f, 0) * 10;
				if (y + h < height && y + h > 0) {
					System.out.println(y + h);
					tiles[x][(int) (y + h)] = getTile((int) x, (int) ((int) y + h));
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

	public void update() {
		// client.send("Hello World".getBytes());

		p.update(tiles);

		if (Gdx.input.isKeyPressed(Keys.R)) {
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					tiles[x][y] = null;
				}
			}
			create();
		}
		if (Gdx.input.isKeyPressed(Keys.F3)) {
			Screenshot s = new Screenshot();
			s.getScreenshot(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);
			s.saveScreenshot();
		}
	}

	public void render() {
		batch.begin();
		cam.update(p);

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
	
	public void dispose(){
		batch.dispose();
		client.dispose();
		server.dispose();
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public Camera getCam() {
		return cam;
	}

	public void setCam(Camera cam) {
		this.cam = cam;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getsWidth() {
		return sWidth;
	}

	public void setsWidth(int sWidth) {
		this.sWidth = sWidth;
	}

	public int getsHeight() {
		return sHeight;
	}

	public void setsHeight(int sHeight) {
		this.sHeight = sHeight;
	}

}
