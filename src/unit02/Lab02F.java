package unit02;

public class Lab02F {

	public static void main(String[] args) {
		Line slopeLine = new Line();
		
		slopeLine.setCoordinates(1, 9, 14, 2);
		slopeLine.calculateSlope();
		slopeLine.print();

	}

}
