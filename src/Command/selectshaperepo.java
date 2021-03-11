package Command;

import java.util.ArrayList;

import ClickHandler.point;
import Shape.Ishape;
import Shape.shapeProperties;
import view.interfaces.PaintCanvasBase;

public class selectshaperepo extends repoList {

	public selectshaperepo(ArrayList<Ishape> list, PaintCanvasBase canvas) {
		super(list, canvas);
		// TODO Auto-generated constructor stub
	}

	
	public static void inRange(point point,repository shapelist,repository selectlist) {
		int Ax1=point.getX1();
		int Ax2=point.getX1()+point.getWidth();
		int Ay1=point.getY1();
		int Ay2=point.getY1()+point.getHeight();
		
		
		
		
		for(Ishape shape:shapelist.list()) {
			shapeProperties properties=shape.getProperties();
			
	if(Ax1<properties.getX()+properties.getWidth()&&Ax2>properties.getX()&&Ay1<properties.getY()+properties.getHeight()&&Ay2>properties.getY()) {
			if(!selectlist.contains(shape)) {
				selectlist.addshape(shape);
			   }
			}
				
				
			
		}
		
		
		System.out.println("Number of selected shapes"+selectlist.size());
		
		
			
		}

}
