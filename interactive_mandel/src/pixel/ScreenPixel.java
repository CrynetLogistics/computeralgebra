package pixel;

public abstract class ScreenPixel implements Pixel {

	double xPos;
	double yPos;
	private double THRESHOLD_TO_TAKE_AS_INFINITY = 2;

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