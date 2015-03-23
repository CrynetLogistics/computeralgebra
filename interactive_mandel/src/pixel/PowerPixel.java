package pixel;

import math.ComplexPower;

public class PowerPixel extends ScreenPixel {
	
	private double X_00 = 0;
	private double Y_00 = 0;
	
	////////////////////////////////////////////////
	private double THRESHOLD_TO_TAKE_AS_INFINITY = 1000000000;
	
	public PowerPixel(double xPos, double yPos, int numberOfIterations){
		super(numberOfIterations,xPos,yPos);
	}
	
	@Override
	public int isConvergentWithin(double a, double b, int iterations, int maxIndex){
		double x=a,y=b,xt,yt;
		ComplexPower cp;
		for(int i=0;i<iterations;i++){
			cp = new ComplexPower(x,y,a,b);
			xt = cp.realPower() + X_00;
			yt = cp.imagPower() + Y_00;
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
}
