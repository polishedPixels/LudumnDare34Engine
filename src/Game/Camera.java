package Game;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

public abstract class Camera {
	
	static Point pos = new Point(0, 0);
	
	public static void setPosition(Point position)
	{
		pos = position;
		
		glMatrixMode(GL_PROJECTION);
        glLoadIdentity(); // Resets any previous projection matrices
        glOrtho((-Main.WindowWidth/2) + pos.posX, (Main.WindowWidth/2) + pos.posX, (-Main.WindowHeight/2) + pos.posY, (Main.WindowHeight/2) + pos.posY, 1, -1);
        glMatrixMode(GL_MODELVIEW);
		
	}
	public static Point getPosition()
	{
		return pos;
	}

}
