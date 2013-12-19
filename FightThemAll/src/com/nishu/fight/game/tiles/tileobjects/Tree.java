package com.nishu.fight.game.tiles.tileobjects;

import com.nishu.fight.game.tiles.Tile;
import com.nishu.fight.utilities.Constants;

public class Tree extends TileObject {

	@Override
	public byte[][] getObject(byte[][] tiles, int x, int y) {
		int mx = (4 * Constants.WIDTH) / Constants.TILE_SIZE;
		int my = Constants.HEIGHT / Constants.TILE_SIZE + 1;
		//System.out.println(mx + " , " + my);
		// trunk
		if (x + 3 < mx)
			tiles[x + 3][y] = Tile.Tree.getID();
		if (x + 3 < mx && y + 1 < my)
			tiles[x + 3][y + 1] = Tile.Tree.getID();

		// level 1 leaves (5)
		if (x + 4 < mx && y + 2 < my)
			tiles[x + 4][y + 2] = Tile.Leaf.getID();
		if (x + 5 < mx && y + 2 < my)
			tiles[x + 5][y + 2] = Tile.Leaf.getID();
		if (x + 1 < mx && y + 2 < my)
			tiles[x + 1][y + 2] = Tile.Leaf.getID();
		if (x + 2 < mx && y + 2 < my)
			tiles[x + 2][y + 2] = Tile.Leaf.getID();
		if (x + 3 < mx && y + 2 < my)
			tiles[x + 3][y + 2] = Tile.Leaf.getID();

		// level 2 leaves (3)
		if (x + 4 < mx && y + 3 < my)
			tiles[x + 4][y + 3] = Tile.Leaf.getID();
		if (x + 3 < mx && y + 3 < my)
			tiles[x + 3][y + 3] = Tile.Leaf.getID();
		if (x + 2 < mx && y + 3 < my)
			tiles[x + 2][y + 3] = Tile.Leaf.getID();

		// level 3 leaves (1)
		if(x + 3 < mx && y + 4 < my) 
			tiles[x + 3][y + 4] = Tile.Leaf.getID();
		
		return tiles;
	}
}
