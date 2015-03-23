package pixel;

import math.ComplexPower;

public class MandelPowerPixel extends ScreenPixel {

	private double THRESHOLD_TO_TAKE_AS_INFINITY = 2;
	private double POWER_REAL_PART = 2;
	private double POWER_IMAG_PART = 0.05;
	
	public MandelPowerPixel(double xPos, double yPos, int numberOfIterations){
		super(numberOfIterations, xPos, yPos);
	}
	
	@Override
	public int isConvergentWithin(double a, double b, int iterations, int maxIndex){
		double x=a,y=b,xt,yt;
		ComplexPower cp;
		for(int i=0;i<iterations;i++){
			cp = new ComplexPower(x,y,POWER_REAL_PART,POWER_IMAG_PART);
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
}
