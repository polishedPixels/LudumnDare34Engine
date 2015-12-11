package Game;

import static org.lwjgl.opengl.GL11.*;

import Game.Map.Tile;
import Game.Map.Tile.Color;

public abstract class Draw {
	
	public static void Square(Point center, double width)
	{
		glColor3f(1f, 1f, 1f);
		glBegin(GL_QUADS);
		{
			glVertex2d(center.posX - width/2, center.posY + width/2);
			glVertex2d(center.posX + width/2, center.posY + width/2);
			glVertex2d(center.posX + width/2, center.posY - width/2);
			glVertex2d(center.posX - width/2, center.posY - width/2);
		}
		glEnd();
		
	}
	
	public static void Square(Point center, double width, Tile.Color color)
	{

		switch(color)
		{
		case White:
			glColor3f(1, 1, 1);
			break;
		case Blue:
			glColor3f(0, 0, 1);
			break;
		case Red:
			glColor3f(1, 0, 0);
			break;
			default:
				glColor3f(1, 1, 1);

				break;
		}	
		glBegin(GL_QUADS);
		{
			glVertex2d(center.posX - width/2, center.posY + width/2);
			glVertex2d(center.posX + width/2, center.posY + width/2);
			glVertex2d(center.posX + width/2, center.posY - width/2);
			glVertex2d(center.posX - width/2, center.posY - width/2);
		}
		glEnd();
		
	}

	
}
