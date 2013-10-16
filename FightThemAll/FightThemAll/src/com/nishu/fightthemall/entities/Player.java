package com.nishu.fightthemall.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nishu.fightthemall.tiles.Tile;
import com.nishu.fightthemall.utilities.SpriteStore;
import com.nishu.fightthemall.world.World;

public class Player extends Entity {

	private Sprite sprite;
	private World world;
	public static final int MOVESPEED = 4;
	private boolean jumping, onFloor;
	private float velY, gravity;

	public Player(int id, float x, float y, World world) {
		super(id, x, y);
		sprite = SpriteStore.getSprite("test");
		getSprite().setOrigin(x / 2, y / 2);
		getSprite().setPosition(x, y);
		this.world = world;
	}

	@Override
	public void render(SpriteBatch batch) {
		getSprite().draw(batch);
	}

	public void update(Tile[][] tiles) {
		move(tiles);
	}

	public boolean isColliding(int x, int y, Tile[][] tiles) {
		float _x = (getX() / 32) + x;
		float _y = (getY() / 32) + y;
		if (_x > 0 && _x < world.getsWidth() && _y > 0 && _y < world.getsHeight() && tiles[(int) _x][(int) _y] != null) {
			return tiles[(int) _x][(int) _y].isSolid();
		}
		return false;
	}

	private void move(Tile[][] tiles) {
		System.out.println(onFloor);
		if(isColliding(0, -1, tiles)) onFloor = true;
		if (!isColliding(0, -1, tiles) && !jumping) {
			setVelY(12f);
			gravity = -0.5f;
			velY += gravity;
			addY(-velY);
		}
		if (onFloor && jumping) {
			jump();
		}
		if (Gdx.input.isKeyPressed(Keys.A)) {
			if (!isColliding(-1, 0, tiles)) {
				addX(-1 * MOVESPEED);
			}
		}
		if (Gdx.input.isKeyPressed(Keys.D)) {
			if (!isColliding(1, 0, tiles)) {
				addX(1 * MOVESPEED);
			}
		}
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			setVelY(-12.0f);
			gravity = 0.5f;
			jumping = true;
		}
		if (getId() != 1) {
			if (getRand().nextInt(10) == 0) {
				int dir = getRand().nextInt(2);
				if (dir == 0)
					addX(1 * MOVESPEED);
				if (dir == 1)
					subX(1 * MOVESPEED);
			}
		}
		getSprite().setPosition(getX(), getY());
	}

	public void jump() {
		velY += gravity;
		addY(-velY);
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	@Override
	public void update() {
	}

}
