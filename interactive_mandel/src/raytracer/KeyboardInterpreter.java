package raytracer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class KeyboardInterpreter extends KeyAdapter {

	private ZoomProperties zoom;
	private JFrame f;
	private int xSize;
	private int ySize;
	private int mode;
	
	private int ULTRA_RES =1000;
	private int HIGH_RES = 250;
	private int STANDARD_RES = 100;
	private int LOW_RES = 12;
	
	public KeyboardInterpreter(ZoomProperties zoom, JFrame f, int xSize, int ySize, int mode){
		this.zoom = zoom;
		this.f = f;
		this.xSize = xSize;
		this.ySize = ySize;
		this.mode = mode;
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		double MOVE_FACTOR = 200*zoom.getSampleInterval();
		double ZOOM_FACTOR = 0.3*zoom.getSampleInterval();
		if(e.getKeyChar()=='s'){
			System.out.println("out"+" for "+ZOOM_FACTOR);
			zoom.setSampleInterval(zoom.getSampleInterval()+ZOOM_FACTOR);
		}else if(e.getKeyChar()=='w'){
			System.out.println("in"+" for "+ZOOM_FACTOR);
			zoom.setSampleInterval(zoom.getSampleInterval()-ZOOM_FACTOR);
		}else if(e.getKeyChar()=='a'){
			System.out.println("left"+" for "+MOVE_FACTOR);
			zoom.setCentreX(zoom.getCentreX()-MOVE_FACTOR);
		}else if(e.getKeyChar()=='d'){
			System.out.println("right"+" for "+MOVE_FACTOR);
			zoom.setCentreX(zoom.getCentreX()+MOVE_FACTOR);
		}else if(e.getKeyChar()=='+'){
			System.out.println("down"+" for "+MOVE_FACTOR);
			zoom.setCentreY(zoom.getCentreY()+MOVE_FACTOR);
		}else if(e.getKeyChar()=='-'){
			System.out.println("up"+" for "+MOVE_FACTOR);
			zoom.setCentreY(zoom.getCentreY()-MOVE_FACTOR);
		}else if(e.getKeyChar()=='/'){
			System.out.println("ultra high res mode");
			zoom.setNumberOfIterations(ULTRA_RES);
		}else if(e.getKeyChar()=='8'){
			System.out.println("high res mode");
			zoom.setNumberOfIterations(HIGH_RES);
		}else if(e.getKeyChar()=='5'){
			System.out.println("standard res mode");
			zoom.setNumberOfIterations(STANDARD_RES);
		}else if(e.getKeyChar()=='2'){
			System.out.println("low res mode");
			zoom.setNumberOfIterations(LOW_RES);
		}else if(e.getKeyChar()=='9'){
			System.out.println("2880*1620 mode");
			xSize = 2880;
			ySize = 1620;
		}else if(e.getKeyChar()=='6'){
			System.out.println("1920*1080 mode");
			xSize = 1920;
			ySize = 1080;
		}else if(e.getKeyChar()=='3'){
			System.out.println("640*360 mode");
			xSize = 640;
			ySize = 360;
		}else if(e.getKeyChar()=='x'){
			System.out.println("POWER OVERRIDE");
			xSize = 2500;
			ySize = 1500;
			zoom.setSampleInterval(0.01);
			zoom.setNumberOfIterations(80);
		}else{
			System.out.println("who knows?!");
		}
		PixelInterpreter s = new PixelInterpreter(xSize,ySize,f,zoom,mode);
		zoom.setXSize(xSize);///////////////
		zoom.setYSize(ySize);///////////////
		f.setFocusable(true);
		//f.revalidate();
		f.add(s);
		f.setSize(xSize, ySize);
		f.setVisible(true);
	}
	
}
