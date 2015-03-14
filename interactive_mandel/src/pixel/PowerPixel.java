package pixel;

import math.ComplexPower;

public class PowerPixel extends ScreenPixel {

	double xPos;
	double yPos;
	
	private double X_00 = 0;
	private double Y_00 = 0;
	
	private double C_X = 0;
	private double C_Y = 0;
	
	////////////////////////////////////////////////
	private double THRESHOLD_TO_TAKE_AS_INFINITY = 1000000000;

	private int numberOfIterations;
	
	public PowerPixel(double xPos, double yPos, int numberOfIterations){
		this.xPos = xPos;
		this.yPos = yPos;
		this.numberOfIterations = numberOfIterations;
	}
	
	public int isConvergentWithin(double a, double b, int iterations, int maxIndex){
		double x=a,y=b,xt,yt;
		for(int i=0;i<iterations;i++){
			xt = ComplexPower.realPower(x, y, a, b) + X_00;
			yt = ComplexPower.imagPower(x, y, a, b) + Y_00;
			//xt = reSquareC(x,y)+X_00;
			//yt = imSquareC(x,y)+Y_00;

			x = xt;
			y = yt;
			
			if(findMagnitude(x,y)>THRESHOLD_TO_TAKE_AS_INFINITY){
				//change iterations as needed based on how close convergence strips should be
				return (int)Math.floor(i*maxIndex/iterations);
			}
		}
		return -1;
	}
	
	public double getIndex(int maxIndex){
		int col = isConvergentWithin(xPos, yPos, numberOfIterations, maxIndex);
		return col;
	}
	
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
	
}
