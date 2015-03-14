package pixel;

public class ActualPixel extends ScreenPixel {

	private int numberOfIterations;
	
	public ActualPixel(double xPos, double yPos, int numberOfIterations){
		this.xPos = xPos;
		this.yPos = yPos;
		this.numberOfIterations = numberOfIterations;
	}
	
	public double getIndex(int maxIndex){
		int col = isConvergentWithin(xPos, yPos, numberOfIterations, maxIndex);
		return col;
	}

}
