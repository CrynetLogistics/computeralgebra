package raytracer;

import javax.swing.JFrame;

public class ZoomProperties {

	private int xSize;
	private int ySize; 
	private int numberOfIterations;
	private double centreX;
	private double centreY;
	private double sampleInterval;
	private JFrame f;
	
	public ZoomProperties(double centreX, double centreY, double sampleInterval, JFrame f,int numberOfIterations,int xSize,int ySize){
		this.centreX = centreX;
		this.centreY = centreY;
		this.sampleInterval = sampleInterval;
		this.f = f;
		this.numberOfIterations = numberOfIterations;
		this.xSize = xSize;
		this.ySize = ySize;
	}
	
	public int getXSize(){
		return xSize;
	}
	
	public int getYSize(){
		return ySize;
	}
	
	public void setXSize(int xSize){
		this.xSize = xSize;
	}
	
	public void setYSize(int ySize){
		this.ySize = ySize;
	}
	
	public int getNumberOfIterations(){
		return numberOfIterations;
	}
	
	public void setNumberOfIterations(int numberOfIterations){
		this.numberOfIterations = numberOfIterations;
	}
	
	public double getCentreX(){
		return centreX;
	}
	
	public double getCentreY(){
		return centreY;
	}
	
	public double getSampleInterval(){
		return sampleInterval;
	}
	
	public void setCentreX(double centreX){
		this.centreX = centreX;
	}
	
	public void setCentreY(double centreY){
		this.centreY = centreY;
	}
	
	public void setSampleInterval(double sampleInterval){
		this.sampleInterval = sampleInterval;
	}
	
}
