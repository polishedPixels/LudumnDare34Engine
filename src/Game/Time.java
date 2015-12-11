package Game;

import org.lwjgl.Sys;

public class Time {
	// Under the class definition
	private static long lastFrame;
	
	private static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	public static long getDelta() {
		long currentTime = getTime();
		long delta = (long) currentTime - (long) lastFrame;
		
		lastFrame = getTime();
		return delta;
	}
	
	public static void Update()
	{
		lastFrame = getTime();
	}
}
