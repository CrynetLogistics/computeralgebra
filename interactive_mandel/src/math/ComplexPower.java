package math;

public class ComplexPower {

	private double factor;
	private double realPowerValue;
	private double imagPowerValue;
	
	public ComplexPower(double baseRe, double baseIm, double expRe, double expIm){
		double r = Math.sqrt(baseRe*baseRe+baseIm*baseIm);
		double s = Math.sqrt(expRe*expRe+expIm*expIm);
		double ro = Math.log(Math.pow(r,s));
		
		double theta = Math.atan2(baseIm, baseRe);
		double tau = theta*s;
		
		double phi = Math.atan2(expIm, expRe);
		double psi = phi+(Math.PI/2);
		
		factor = Math.pow(Math.E, ro*Math.cos(phi)+tau*Math.cos(psi));
		realPowerValue = factor*Math.cos(tau*Math.sin(psi)+ro*Math.sin(phi));
		imagPowerValue = factor*Math.sin(tau*Math.sin(psi)+ro*Math.sin(phi));
	}
	
	public double realPower(){
		return realPowerValue;
	}
	
	public double imagPower(){
		return imagPowerValue;
	}
	
}