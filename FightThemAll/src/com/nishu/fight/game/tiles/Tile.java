package com.nishu.fight.game.tiles;

public abstract class Tile {

	public static Tile Air = new TileAir();
	public static Tile Void = new TileVoid();
	public static Tile Stone = new TileStone();
	public static Tile TopGrass = new TileTopGrass();
	public static Tile Tree = new TileTree();
	public static Tile Wood = new TileWood();
	
	public static Tile Leaf = new TileLeaf();
	public static Tile Window = new TileWindow();
	public static Tile Grass = new TileGrass();

	/* Tiles
	 * -1 - Air
	 * 0 - Void
	 * 1 - Stone
	 * 2 - TopGrass
	 * 3 - Tree
	 * 4 - Window
	 * 5 - Leaf
	 * 6 - Grass
	 * 7 - Wood
	 */
	
	public abstract float[] getTexCoords();
	public abstract boolean isSolid();
	public abstract boolean transparent();
	public abstract byte getID();

	public static Tile getTile(byte id) {
		switch (id) {
		case -1:
			return Tile.Air;
		case 0:
			return Tile.Void;
		case 1:
			return Tile.Stone;
		case 2:
			return Tile.TopGrass;
		case 3:
			return Tile.Tree;
		case 4:
			return Tile.Window;
		case 5:
			return Tile.Leaf;
		case 6:
			return Tile.Grass;
		case 7:
			return Tile.Wood;
		default:
			return Tile.Void;
		}
	}

}
