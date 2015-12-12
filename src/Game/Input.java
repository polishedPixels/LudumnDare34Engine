package Game;


import org.lwjgl.input.Mouse;

import Game.Map.Tile;
import Game.Map.Tilemap;

public abstract class Input {

	static double X, Y;
	public static void update()
	{
		X = Mouse.getX();
		Y = Mouse.getY();
	}
	public static double getMouseX()
	{
		return X + Camera.Xoffset - Main.WindowWidth/2;
	}
	public static double getMouseY()
	{
		return Y + Camera.Yoffset - Main.WindowHeight/2;
	}
	public static Tile getCurTile() {
		Tile curTile = null;
		if (getMouseX() >= 0 && getMouseX() <= Scene.getCurTilemap().getSceneSizeX() && getMouseY() >= 0 && getMouseY() <= Scene.getCurTilemap().getSceneSizeY()) {
			int TileX, TileY;

			TileX = (int) (getMouseX() / Tilemap.tileSize);
			TileY = (int) (getMouseY() / Tilemap.tileSize);
			curTile = Scene.getCurTilemap().getTile(TileX, TileY);

		}else{
			curTile = Scene.getCurTilemap().getTile(0, 0);
			//System.err.println("Point GetCurTile Out of Bounds");
		}
		return curTile;
	}
}
