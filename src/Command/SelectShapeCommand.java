package Command;


import java.io.IOException;

import Shape.Ishape;
import Shape.shapeProperties;
import view.interfaces.PaintCanvasBase;
import ClickHandler.point;

public class SelectShapeCommand implements Icommand{
	
	
	point point;
	repository shaperepository;
	repository selectshaperepository;

	public SelectShapeCommand(repository shaperepository, repository selectshaperepository, point point) {
		super();
		this. shaperepository =  shaperepository;
		this.selectshaperepository = selectshaperepository;
		this.point = point;
		
	}


	@Override
	public void run() throws IOException {
		// TODO Auto-generated method stub
		
		
		selectshaperepository.clear();
		inRange(point);
		
		
		
	}
	public void inRange(point point) {
		int Ax1=point.getX1();
		int Ax2=point.getX1()+point.getWidth();
		int Ay1=point.getY1();
		int Ay2=point.getY1()+point.getHeight();
		
		
		
		
		for(Ishape shape:shaperepository.list()) {
			shapeProperties properties=shape.getProperties();
			
	if(Ax1<properties.getX()+properties.getWidth()&&Ax2>properties.getX()&&Ay1<properties.getY()+properties.getHeight()&&Ay2>properties.getY()) {
			if(!selectshaperepository.contains(shape)) {
				selectshaperepository.addshape(shape);
			   }
					}
				
				
			
		}
		
		
		System.out.println("Number of selected shapes"+selectshaperepository.size());
		
		
			
		}

	

}
