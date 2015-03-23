package pixel;

public abstract class ScreenPixel {

	//position of the pixel
	private double xPos;
	private double yPos;
	
	//resolution of the pixel - the higher, the more accurate
	private int numberOfIterations;
	
	public ScreenPixel(int numberOfIterations, double xPos, double yPos){
		this.numberOfIterations = numberOfIterations;
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public abstract int isConvergentWithin(double a,double b,int iterations,int maxIndex);
	
	public double findMagnitude(double a,double b){
		return Math.sqrt(a*a+b*b);
	}
	
	public double imSquareC(double a,double b){
		return 2*a*b;
	}
	
	public double reSquareC(double a,double b){
		return a*a-b*b;
	}
	
	public double imCubeC(double a, double b){
		return b*(3*a*a-b*b);
	}
	
	public double reCubeC(double a, double b){
		return a*(a*a-3*b*b);
	}
	
	public double getIndex(int maxIndex){
		int col = isConvergentWithin(xPos, yPos, numberOfIterations, maxIndex);
		return col;
	}
}