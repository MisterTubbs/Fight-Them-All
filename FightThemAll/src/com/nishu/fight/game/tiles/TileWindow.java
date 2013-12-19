package com.nishu.fight.game.tiles;

import com.nishu.fight.utilities.Spritesheet;

public class TileWindow extends Tile {

	@Override
	public float[] getTexCoords() {
		return new float[] { Spritesheet.tiles.uniformSize(), Spritesheet.tiles.uniformSize() };
	}

	@Override
	public boolean isSolid() {
		return false;
	}

	@Override
	public byte getID() {
		return 4;
	}

	@Override
	public boolean transparent() {
		return true;
	}

}
