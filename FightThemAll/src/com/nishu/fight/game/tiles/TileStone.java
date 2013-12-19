package com.nishu.fight.game.tiles;

import com.nishu.fight.utilities.Spritesheet;

public class TileStone extends Tile {

	@Override
	public float[] getTexCoords() {
		return new float[] { 0 + Spritesheet.tiles.uniformSize(), 0 };
	}

	@Override
	public boolean isSolid() {
		return true;
	}

	@Override
	public byte getID() {
		return 1;
	}
}
