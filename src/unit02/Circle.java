package unit02;

public class Circle
{
	private double radius;
	private double area;

	public void setRadius(double rad)
	{
		radius = rad;
	}

	public void calculateArea( )
	{
		area = Math.PI * Math.pow(radius, 2);
	}

	public void print( )
	{
		System.out.print("The area is :: ");
		
		System.out.print(String.format("%.4f", area));
	}
}