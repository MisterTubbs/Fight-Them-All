package com.nishu.fight.game.tiles;

import com.nishu.fight.utilities.Spritesheet;

public class TileTree extends Tile{

	@Override
	public float[] getTexCoords() {
		return new float[]{(3 * Spritesheet.tiles.uniformSize()), 0};
	}

	@Override
	public boolean isSolid() {
		return false;
	}

	@Override
	public byte getID() {
		return 3;
	}

	@Override
	public boolean transparent() {
		return false;
	}

}
