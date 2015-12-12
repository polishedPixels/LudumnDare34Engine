package Game;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Main {

	public static final short WindowWidth = 1600;
	public static final short WindowHeight = 900;
	

	private static void init(short width, short height)
	{
		try {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.setTitle("LudumnDare34");
            Display.create();
            
            glMatrixMode(GL_PROJECTION);
            glLoadIdentity(); // Resets any previous projection matrices
            glOrtho(-width/2, width/2, -height/2, height/2, 1, -1);
            glMatrixMode(GL_MODELVIEW);
            
        } catch (LWJGLException e) {
            System.err.println("Display wasn't initialized correctly.");
            System.exit(1);
        }
	}
	
	private static void gameInit()
	{
		Scene.init();
		Camera.setPosition(100, 0);
	}
	private static void draw()
	{
		Scene.getCurTilemap().draw();
		
	}
	private static void inputUpdate()
	{
		Input.update();
		
	}
	
    public static void main(String[] args) {
    	
    	init(WindowWidth, WindowHeight);
    	gameInit();
        while (!Display.isCloseRequested()) {
        	
        	Time.UpdateFirstFrame();
        	glClear(GL_COLOR_BUFFER_BIT);
        	
        	inputUpdate();
        	draw();
        	
            Display.update(); 
            Time.UpdateLastFrame();
            Display.sync(60);
           
        }
 
        Display.destroy();
        System.exit(0);
    }
    
    public static void printXYCoords(String note, double X, double Y)
    {
    	System.out.println(note + "- X: " + X + " Y: " + Y);
    }
}