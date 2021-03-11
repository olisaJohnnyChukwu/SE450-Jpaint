package Command;

import java.io.IOException;
import java.util.ArrayList;

import Shape.CreateShapeFactory;
import Shape.Ishape;
import Shape.IshapeFactory;
//import Shape.ShapeFactory;
import Shape.shapeProperties;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;
//first
public class CreateShapeCommand implements Icommand,IUndoable{
	PaintCanvasBase canvas;
	shapeProperties properties;
	Ishape shape;
	IApplicationState applicationState;
	repository shaperepository;
	
	
	
	
	
	public CreateShapeCommand(repository shaperepository,shapeProperties properties,IApplicationState applicationState) {
		super();
		
		this. shaperepository =  shaperepository;
		this.properties=properties;
		this.applicationState=applicationState;
		
		
		
	}
	public void run() throws IOException {
		
		IshapeFactory factory=new CreateShapeFactory();
		shape=factory.CreateShape(properties,applicationState);	
		shaperepository.addshape(shape);
		CommandHistory.add(this);
		System.out.println("Shape created");

		// TODO Auto-generated method stub
		
	}
	@Override
	public void undo() {
		shaperepository.removeshape(this.shape);
		System.out.println("Created shape undone");
		// TODO Auto-generated method stub
		}
	@Override
	public void redo() {
		
	shaperepository.addshape(shape);
	System.out.println("Shape Redrawn");
		// TODO Auto-generated method stub
		
	}
	
	

}
