package Command;
import java.awt.Graphics2D;
import java.util.*;

import ClickHandler.point;
import Shape.Ishape;
import Shape.shapeProperties;
import model.ShapeType;
import view.gui.PaintCanvas;
import view.interfaces.PaintCanvasBase;

public class SelectedShapeList {
	ArrayList<Ishape> selectedshapelist;
	
	

	public SelectedShapeList() {
		super();
		this.selectedshapelist = new ArrayList<>();
		
	}
	public void inRange(point point,ShapeList list) {
		int Ax1=point.getX1();
		int Ax2=point.getX1()+point.getWidth();
		int Ay1=point.getY1();
		int Ay2=point.getY1()+point.getHeight();
		
		
		
		
		for(Ishape shape:list.getList()) {
			shapeProperties properties=shape.getProperties();
		if(Ax1<properties.getX()+properties.getWidth()&&Ax2>properties.getX()&&Ay1<properties.getY()+properties.getHeight()&&Ay2>properties.getY()) {
					
					
					if(!selectedshapelist.contains(shape)) {
					selectedshapelist.add(shape);
					}
					}
				
				
			
		}
		
		
		System.out.println("Number of selected shapes"+selectedshapelist.size());
		
		
			
		}
		
		
	
	public void clear() {
		selectedshapelist.clear();
	}
	
	public ArrayList<Ishape> getSelectedshapelist() {
		return selectedshapelist;
	}
	
	
	
	

}
