package Game;

public class Point {
	
	// point in scene
	double posX,posY;
	
	public Point(double PosX, double PosY)
	{
		posX = PosX;
		posY = PosY;
	}
	
	public double getPosX()
	{
		return posX;
	}
	public double getPosY()
	{
		return posY;
	}
	public void setPosX(double PosX)
	{
		posX = PosX;
	}
	public void setPosY(double PosY)
	{
		posY = PosY;
	}

}
