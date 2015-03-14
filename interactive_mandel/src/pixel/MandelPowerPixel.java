package pixel;

import math.ComplexPower;

public class MandelPowerPixel extends ScreenPixel {

	double xPos;
	double yPos;

	private double THRESHOLD_TO_TAKE_AS_INFINITY = 2;

	private int numberOfIterations;
	
	public MandelPowerPixel(double xPos, double yPos, int numberOfIterations){
		this.xPos = xPos;
		this.yPos = yPos;
		this.numberOfIterations = numberOfIterations;
	}
	
	public int isConvergentWithin(double a, double b, int iterations, int maxIndex){
		double x=a,y=b,xt,yt;
		ComplexPower cp;
		for(int i=0;i<iterations;i++){
			cp = new ComplexPower(x,y,0,2);
			xt = cp.realPower() + a;
			yt = cp.imagPower() + b;

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
	
}
