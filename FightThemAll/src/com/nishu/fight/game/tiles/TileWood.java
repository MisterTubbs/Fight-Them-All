package com.nishu.fight.game.tiles;

import com.nishu.fight.utilities.Spritesheet;

public class TileWood extends Tile{

	@Override
	public float[] getTexCoords() {
		return new float[]{5 * Spritesheet.tiles.uniformSize(), 0};
	}

	@Override
	public boolean isSolid() {
		return false;
	}

	@Override
	public boolean transparent() {
		return false;
	}

	@Override
	public byte getID() {
		return 7;
	}

}
