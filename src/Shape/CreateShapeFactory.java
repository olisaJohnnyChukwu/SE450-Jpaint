package Shape;

import model.ShapeType;
import model.interfaces.IApplicationState;

public class CreateShapeFactory implements IshapeFactory {

	public Ishape CreateShape(shapeProperties properties,IApplicationState applicationState) {
		Ishape shape=null;
		//applicationState.setActiveShape();
		ShapeType shapeType=applicationState.getActiveShapeType();
		
		if(shapeType.equals(ShapeType.RECTANGLE)) {
			shape=new Rectangle(properties);
			System.out.println( shape.getId()+" Rectangle Drawn ");
			//shape.getId()
			
		}else if(shapeType.equals(ShapeType.TRIANGLE)) {
			shape=new Triangle(properties);
			System.out.println(shape.getId()+" Triangle Drawn");
		}else {
			shape=new  Ellipse(properties);
			System.out.println(shape.getId()+" Ellipse Drawn");
		}
		// TODO Auto-generated method stub
		//return new Rectangle(properties);
		//return new Triangle(properties);
		return shape;
	}

	@Override
	public Ishape CreateShape2(shapeProperties properties,ShapeType shapeType) {
		// TODO Auto-generated method stub
		Ishape shape=null;
		//applicationState.setActiveShape();
		//ShapeType shapeType=properties.getType();
		
		if(shapeType.equals(ShapeType.RECTANGLE)) {
			shape=new Rectangle(properties);
			System.out.println( shape.getId()+" Rectangle Drawn ");
			//shape.getId()
			
		}else if(shapeType.equals(ShapeType.TRIANGLE)) {
			shape=new Triangle(properties);
			System.out.println(shape.getId()+" Triangle Drawn");
		}else if(shapeType.equals(ShapeType.ELLIPSE)){
			shape=new  Ellipse(properties);
			System.out.println(shape.getId()+" Ellipse Drawn");
		}
		// TODO Auto-generated method stub
		//return new Rectangle(properties);
		//return new Triangle(properties);
		return shape;
	}
	

}
