package Game;


public class Time {
	// Under the class definition
	private static long lastFrame, firstFrame, delta;
	
	private static long getTime() {
		return System.currentTimeMillis();
	}
	
	public static long getDelta() {	
		System.out.println(delta);
		return delta;
	}
	public static void UpdateFirstFrame()
	{
		delta = lastFrame -firstFrame;
		firstFrame = getTime();
	}
	
	public static void UpdateLastFrame()
	{
		lastFrame = getTime();
	}
}
