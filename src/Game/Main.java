package Game;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.omg.CORBA.TIMEOUT;

import Game.Map.Tilemap;

import static org.lwjgl.opengl.GL11.*;

public class Main {

	public static final short WindowWidth = 640;
	public static final short WindowHeight = 480;
	
	static Tilemap tilemap;

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
		tilemap = new Tilemap(10, 10);
		
	}
	private static void draw()
	{
		tilemap.draw();
		Draw.Square(new Point(-100, -100), 50);
	}
	private static void inputUpdate()
	{
		//camera movement
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
			Camera.setPosition(new Point(Camera.getPosition().posX + 1 * Time.getDelta(), Camera.getPosition().posY));
		else if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
			Camera.setPosition(new Point(Camera.getPosition().posX - 1 * Time.getDelta(), Camera.getPosition().posY));
		else if(Keyboard.isKeyDown(Keyboard.KEY_UP))
			Camera.setPosition(new Point(Camera.getPosition().posX, Camera.getPosition().posY + 1 * Time.getDelta()));
		else if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
			Camera.setPosition(new Point(Camera.getPosition().posX, Camera.getPosition().posY - 1 * Time.getDelta()));
		
	}
	
    public static void main(String[] args) {
    	
    	init(WindowWidth, WindowHeight);
    	gameInit();
        while (!Display.isCloseRequested()) {
        	
        	glClear(GL_COLOR_BUFFER_BIT);
        	
        	inputUpdate();
        	draw();
        	
            Display.update(); 
            Time.Update();
            Display.sync(60);
           
        }
 
        Display.destroy();
        System.exit(0);
    }
}