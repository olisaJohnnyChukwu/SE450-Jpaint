package Stategy;

import Shape.Ishape;
import Shape.shapeProperties;

public class negativeDisplacement implements ImoveStrategy {

	@Override
	public void displace(Ishape shape,int dx,int dy) {
		shapeProperties properties=shape.getProperties();
		// TODO Auto-generated method stub
		int x=properties.getX()-dx;
		int y=properties.getY()-dy;
		
		properties.setX(x);
		properties.setY(y);
		System.out.println("Negative displacement");
		shape.setProperties(properties);

	}

}
