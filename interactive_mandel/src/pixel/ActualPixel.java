package pixel;

public class ActualPixel extends ScreenPixel {

	private double THRESHOLD_TO_TAKE_AS_INFINITY = 2;
	
	public ActualPixel(double xPos, double yPos, int numberOfIterations){
		super(numberOfIterations,xPos,yPos);
	}
	
	@Override
	public int isConvergentWithin(double a,double b,int iterations,int maxIndex){
		double x=a,y=b,xt,yt;
		for(int i=0;i<iterations;i++){
			//mandelbrot set
			xt = reSquareC(x,y)+a;
			yt = imSquareC(x,y)+b;
			
			//other sets
			//xt = reCubeC(x,y)+a;
			//yt = imCubeC(x,y)+b;
			
			
			x = xt;
			y = yt;
			
			if(findMagnitude(x,y)>THRESHOLD_TO_TAKE_AS_INFINITY){
				//change iterations as needed based on how close convergence strips should be
				return (int)Math.floor(i*maxIndex/iterations);
			}
		}
		// for convergence
		return -1;
	}

}
