package com.nishu.fight.game.tiles;

public abstract class Tile {

	public static Tile Void = new TileVoid();
	public static Tile Stone = new TileStone();
	public static Tile TopGrass = new TileTopGrass();

	/* Tiles
	 * -1 - Air
	 * 0 - Void
	 * 1 - Stone
	 * 2 - TopGrass
	 */
	
	public abstract float[] getTexCoords();
	public abstract boolean isSolid();
	public abstract byte getID();

	public static Tile getTile(byte id) {
		switch (id) {
		case 0:
			return Tile.Void;
		case 1:
			return Tile.Stone;
		case 2:
			return Tile.TopGrass;
		default:
			return Tile.Void;
		}
	}

}
