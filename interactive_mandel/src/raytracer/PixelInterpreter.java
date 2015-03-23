package raytracer;

import java.awt.*;

import javax.swing.*;

import pixel.ActualPixel;
import pixel.JuliaPixel;
import pixel.MandelPowerPixel;
import pixel.PowerPixel;
import pixel.ScreenPixel;

public class PixelInterpreter extends JPanel {
	
	private int xSize;
	private int ySize;
	private ScreenPixel[][] map;
	private ZoomProperties zoom;
	private int mode;
	
	public PixelInterpreter(int xSize, int ySize, JFrame f, ZoomProperties zoom, int mode){
		this.zoom = zoom;
		if(mode!=999){
			this.mode = mode;
		}
		this.xSize = xSize;
		this.ySize = ySize;
		
		map = new ScreenPixel[xSize][ySize];
		for(int i=0;i<xSize;i++){
			for(int j=0;j<ySize;j++){
				if(mode<5){
					map[i][j] = new ActualPixel(zoom.getCentreX()+(i-xSize/2)*zoom.getSampleInterval(),
												zoom.getCentreY()+(j-ySize/2)*zoom.getSampleInterval(), zoom.getNumberOfIterations());
				}else if(mode==20){
					map[i][j] = new PowerPixel(zoom.getCentreX()+(i-xSize/2)*zoom.getSampleInterval(),
											   zoom.getCentreY()+(j-ySize/2)*zoom.getSampleInterval(), zoom.getNumberOfIterations());
				}else if(mode==30){
					map[i][j] = new MandelPowerPixel(zoom.getCentreX()+(i-xSize/2)*zoom.getSampleInterval(),
							   				   		 zoom.getCentreY()+(j-ySize/2)*zoom.getSampleInterval(), zoom.getNumberOfIterations());
				}else{
					map[i][j] = new JuliaPixel(zoom.getCentreX()+(i-xSize/2)*zoom.getSampleInterval(),
											   zoom.getCentreY()+(j-ySize/2)*zoom.getSampleInterval(), zoom.getNumberOfIterations());
				}
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		this.setBackground(Color.WHITE);
		drawLoop(g);
	}
	
	public void drawLoop(Graphics g){
		int colourIndex;
		for(int i=0;i<xSize;i++){
			for(int j=0;j<ySize;j++){
				if(mode<100){
					colourIndex = (int)map[i][j].getIndex(1785)-254;
					g.setColor(new Color(indexToRed(colourIndex), indexToGreen(colourIndex), indexToBlue(colourIndex)));
				}else{
					colourIndex = (int)map[i][j].getIndex(255);
					g.setColor(new Color(colourIndex%255,0,0));
				}
				g.drawLine(i, j, i, j);
			}
		}
	}
	
	private int indexToRed(int index){
		if(index<0){return 0;}
		if(index>=1020){
			return 0;
		}else if(index>=255 && index<=765){
			return 255;
		}else if(index<=255){
			return index%255;
		}else if(index>=765 && index<=1020){
			return 255 - (index%255);
		}
		return 0;
	}
	private int indexToGreen(int index){
		if(index<0){return 255-Math.abs(index);}
		if(index>=510 && index<=1020){
			return 0;
		}else if(index<=255 || index>=1275){
			return 255;
		}else if(index>=1020 && index<=1275){
			return index%255;
		}else if(index>=255 && index<=510){
			return 255 - (index%255);
		}
		return 0;
	}
	private int indexToBlue(int index){
		if(index<0){return 0;}
		if(index<=510){
			return 0;
		}else if(index>=765 && index<=1275){
			return 255;
		}else if(index>=510 && index<=765){
			return index%255;
		}else if(index>=1275){
			return 255 - (index%255);
		}
		return 0;
	}
	
}
