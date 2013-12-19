package com.nishu.fight.game.tiles;

public class TileVoid extends Tile {

	@Override
	public float[] getTexCoords() {
		return new float[] { 0, 0 };
	}

	@Override
	public boolean isSolid() {
		return true;
	}

	@Override
	public byte getID() {
		return 0;
	}

	@Override
	public boolean transparent() {
		return false;
	}

}
