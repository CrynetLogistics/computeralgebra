package pixel;

public class JuliaPixel extends ScreenPixel {

	private double THRESHOLD_TO_TAKE_AS_INFINITY = 2;
	
	//JULIA SET PLOT PARAMETERS I.E. Z(n+1)=Z(n)^2+C in Z(0)=X_00+Y_00i
	private double X_00 = -0.4;
	private double Y_00 = 0.6;
	
	public JuliaPixel(double xPos, double yPos, int numberOfIterations){
		super(numberOfIterations,xPos,yPos);
	}
	
	@Override
	public int isConvergentWithin(double a, double b, int iterations, int maxIndex){
		double x=a,y=b,xt,yt;
		for(int i=0;i<iterations;i++){
			xt = reSquareC(x,y)+X_00;
			yt = imSquareC(x,y)+Y_00;

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
