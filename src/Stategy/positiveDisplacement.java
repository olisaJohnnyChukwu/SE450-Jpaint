package Stategy;

import Shape.Ishape;
import Shape.shapeProperties;

public class positiveDisplacement implements ImoveStrategy {

	@Override
	public void displace(Ishape shape,int dx,int dy) {
		// TODO Auto-generated method stub
		shapeProperties properties=shape.getProperties();
		
		// TODO Auto-generated method stub
		int x=properties.getX()+dx;
		int y=properties.getY()+dy;
		
		properties.setX(x);
		properties.setY(y);
		
		shape.setProperties(properties);
		System.out.println("Positive Displacemt");
		
	}

	

}
