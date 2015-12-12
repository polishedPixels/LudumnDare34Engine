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

import Game.Player.Type;

public class Main {

	public static final short WindowWidth = 1600;
	public static final short WindowHeight = 900;

	public static Player leftPlayer, rightPlayer;

	private static void init(short width, short height) {
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle("LudumnDare34");
			Display.create();

			glMatrixMode(GL_PROJECTION);
			glLoadIdentity(); // Resets any previous projection matrices
			glOrtho(-width / 2, width / 2, -height / 2, height / 2, 1, -1);
			glMatrixMode(GL_MODELVIEW);

		} catch (LWJGLException e) {
			System.err.println("Display wasn't initialized correctly.");
			System.exit(1);
		}
	}

	private static void gameInit() {
		Scene.init();
		Camera.setPosition(900, 450);

		leftPlayer = new Player(Type.Left, 50, new Point(400, 300));
		rightPlayer = new Player(Type.Right, 50, new Point(600, 300));
	}

	private static void draw() {
		Scene.getCurTilemap().draw();

		leftPlayer.draw();
		rightPlayer.draw();

	}

	private static void inputUpdate() {
		Input.update();
		leftPlayer.inputUpdate();
		rightPlayer.inputUpdate();

	}

	public static void main(String[] args) {

		init(WindowWidth, WindowHeight);
		gameInit();
		while (!Display.isCloseRequested()) {
			Time.resetLastFrame();
			glClear(GL_COLOR_BUFFER_BIT);

			inputUpdate();
			draw();

			Time.FPS();
			Display.update();
			
			Display.sync(120);
			Time.updateDelta();

		}

		Display.destroy();
		System.exit(0);
	}
	public static void setTitle(String title)
	{
		Display.setTitle(title);
	}
	public static void printXYCoords(String note, double X, double Y) {
		System.out.println(note + "| X: " + X + " Y: " + Y);
	}
}