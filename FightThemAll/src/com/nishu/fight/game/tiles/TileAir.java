package com.nishu.fight.game.tiles;


public class TileAir extends Tile{

	@Override
	public float[] getTexCoords() {
		return null;
	}

	@Override
	public boolean isSolid() {
		return false;
	}

	@Override
	public byte getID() {
		return -1;
	}

}
