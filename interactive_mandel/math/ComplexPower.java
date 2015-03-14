package math;

public class ComplexPower {

	public static double realPower(double baseRe, double baseIm, double expRe, double expIm){
		double r = Math.sqrt(baseRe*baseRe+baseIm*baseIm);
		double s = Math.sqrt(expRe*expRe+expIm*expIm);
		double ro = Math.log(Math.pow(r,s));
		
		double theta = Math.atan2(baseIm, baseRe);
		double tau = theta*s;
		
		double phi = Math.atan2(expIm, expRe);
		double psi = phi+(Math.PI/2);
		
		double factor = Math.pow(Math.E, ro*Math.cos(phi)+tau*Math.cos(psi));
		double internal = Math.cos(tau*Math.sin(psi)+ro*Math.sin(phi));
		
		return factor*internal;
	}
	
	public static double imagPower(double baseRe, double baseIm, double expRe, double expIm){
		double r = Math.sqrt(baseRe*baseRe+baseIm*baseIm);
		double s = Math.sqrt(expRe*expRe+expIm*expIm);
		double ro = Math.log(Math.pow(r,s));
		
		double theta = Math.atan2(baseIm, baseRe);
		double tau = theta*s;
		
		double phi = Math.atan2(expIm, expRe);
		double psi = phi+(Math.PI/2);
		
		double factor = Math.pow(Math.E, ro*Math.cos(phi)+tau*Math.cos(psi));
		double internal = Math.sin(tau*Math.sin(psi)+ro*Math.sin(phi));
		
		return factor*internal;
	}
	
}
