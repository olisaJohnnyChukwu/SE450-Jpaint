package Command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Shape.CreateShapeFactory;
import Shape.Ishape;
import Shape.IshapeFactory;
import Shape.shapeProperties;
import Stategy.ImoveStrategy;
import Stategy.move;
import Stategy.positiveDisplacement;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;

public class pasteCommand implements Icommand, IUndoable {
	int num;
	CopyShapeList copyList;
	ShapeList shapelist;
	List<Ishape> clipboard;
	IApplicationState applicationState;
	int x;

	
	
	 
	public pasteCommand(int num, CopyShapeList copyList, ShapeList shapelist,IApplicationState applicationState,int x) {
		super();
		this.num = num;
		this.copyList = copyList;
		this.shapelist = shapelist;
		clipboard=new ArrayList<>();
		this.applicationState=applicationState;
		this.x=x;
		
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		for(Ishape s:clipboard) {
			shapelist.traverse(s);
		}
		
		shapelist.redraw();
		
		
		
		
		
	}

	@Override
	public void redo() {
		
		
		for(Ishape s:clipboard) {
			shapelist.AddShape(s);
		}
		
	}

	@Override
	public void run() throws IOException {
		
		for(Ishape shape:copyList.getCopyList()) {
			shapeProperties prop=shape.getProperties();
			int a=prop.getX()+x;
			int b=prop.getY()-x;
			int w=prop.getWidth();
			int h=prop.getHeight();
			ShapeShadingType shade=prop.getShade();
			ShapeType shapetype=prop.getType();
			ShapeColor shapecolor=prop.getColor();
			shapeProperties prop2=new shapeProperties(a, b, w, h, shade, shapecolor, shapetype);
			IshapeFactory factory=new CreateShapeFactory();
			Ishape copy=factory.CreateShape2(prop2,shapetype);
			System.out.println(copy.equals(shape));
			clipboard.add(copy);
			shapelist.AddShape(copy);
			}
		System.out.println(shapelist.getList());
		
		CommandHistory.add(this);
	}

}
