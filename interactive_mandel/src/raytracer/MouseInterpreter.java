package raytracer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInterpreter extends MouseAdapter {

	ZoomProperties zoom;
	
	public MouseInterpreter(ZoomProperties zoom){
		this.zoom = zoom;
	}
	
	@Override
	public void mouseClicked(MouseEvent e){
		int i = e.getX();
		int j = e.getY();
		
		System.out.println(zoom.getCentreX()+(i-zoom.getXSize()/2)*zoom.getSampleInterval());
		System.out.println(-1*(zoom.getCentreY()+(j-zoom.getYSize()/2)*zoom.getSampleInterval()));
	}
	
}
