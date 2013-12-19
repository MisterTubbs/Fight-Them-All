package com.nishu.fight.game.tiles;

import com.nishu.fight.utilities.Spritesheet;

public class TileLeaf extends Tile {

	@Override
	public float[] getTexCoords() {
		return new float[] { 0, 0 + Spritesheet.tiles.uniformSize() };
	}

	@Override
	public boolean isSolid() {
		return false;
	}

	@Override
	public byte getID() {
		return 5;
	}

	@Override
	public boolean transparent() {
		return true;
	}

}
