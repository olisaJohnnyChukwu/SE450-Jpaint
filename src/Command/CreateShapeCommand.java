package Command;

import java.io.IOException;

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
	ShapeList list;
	shapeProperties properties;
	Ishape shape;
	IApplicationState applicationState;
	
	
	
	
	
	public CreateShapeCommand(ShapeList list,shapeProperties properties,IApplicationState applicationState) {
		super();
		
		this.list = list;
		this.properties=properties;
		this.applicationState=applicationState;
		
		
		
	}
	public void run() throws IOException {
		/*ShapeFactory factory = new ShapeFactory();
		shape=factory.getRectangle(properties);*/
		IshapeFactory factory=new CreateShapeFactory();
		shape=factory.CreateShape(properties,applicationState);	
		
		list.AddShape(shape);
		CommandHistory.add(this);
		System.out.println("Shape created");

		// TODO Auto-generated method stub
		
	}
	@Override
	public void undo() {
		list.RemoveShape(this.shape);
		System.out.println("Created shape undone");
		// TODO Auto-generated method stub
		}
	@Override
	public void redo() {
		
	list.AddShape(shape);
	System.out.println("Shape Redrawn");
		// TODO Auto-generated method stub
		
	}
	
	

}
