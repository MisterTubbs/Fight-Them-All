package com.nishu.fight.game.tiles;

import com.nishu.fight.utilities.Spritesheet;

public class TileTopGrass extends Tile {

	@Override
	public float[] getTexCoords() {
		return new float[] { 0 + (2 * Spritesheet.tiles.uniformSize()), 0 };
	}

	@Override
	public boolean isSolid() {
		return true;
	}

	@Override
	public byte getID() {
		return 2;
	}

	@Override
	public boolean transparent() {
		return false;
	}

}
