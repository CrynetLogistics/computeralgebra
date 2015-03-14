package raytracer;

import javax.swing.*;

public class Raytrace {

	//LAUNCH PARAMETERS: 0 FOR NORMAL COLOUR 1 FOR RAINBOW COLOURS 10 FOR JULIA SETS 20 FOR POWERING PIXELS
	
	private static int XSIZE_INIT = 1920;
	private static int YSIZE_INIT = 1080;
	private static int STARTING_RESOLUTION = 12;
	
	public static void main(String[] args){
		JFrame f = new JFrame("Raytrace");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ZoomProperties zoom = new ZoomProperties(0,0,0.001,f,STARTING_RESOLUTION,XSIZE_INIT,YSIZE_INIT);
		
		zoom.setCentreX(0);  /////////////////////////////////////////////////////////////////////
		zoom.setCentreY(0);/////////////////////////////////////////////////////////////////////
		zoom.setSampleInterval(0.004);  //////////////////////////////////////////////////////////
		//zoom.setSampleInterval(0.004);  //////////////////////////////////////////////////////////
		zoom.setNumberOfIterations(10);//////////////////////////////////////////////////////////
		
		PixelInterpreter s = new PixelInterpreter(zoom.getXSize(), zoom.getYSize(), f, zoom, Integer.parseInt(args[0]));
		
		//s.revalidate();
		//f.setFocusable(true);
		f.setSize(zoom.getXSize(), zoom.getYSize());
		f.add(s);
		f.setVisible(true);
		f.addKeyListener(new KeyboardInterpreter(zoom, f, zoom.getXSize(), zoom.getYSize(), Integer.parseInt(args[0])));
	}
	
}
