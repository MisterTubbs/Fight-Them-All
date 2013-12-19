package com.nishu.fight.game.tiles;

import com.nishu.fight.utilities.Spritesheet;

public class TileGrass extends Tile{

	@Override
	public float[] getTexCoords() {
		return new float[]{2 * Spritesheet.tiles.uniformSize(), Spritesheet.tiles.uniformSize()};
	}

	@Override
	public boolean isSolid() {
		return false;
	}

	@Override
	public boolean transparent() {
		return true;
	}

	@Override
	public byte getID() {
		return 6;
	}

}
