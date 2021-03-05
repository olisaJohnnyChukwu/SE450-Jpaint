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
			
			Ishape copy=shape.copy(shape,x);
			System.out.println(copy.equals(shape));
			clipboard.add(copy);
			shapelist.AddShape(copy);
			}
		System.out.println(shapelist.getList());
		
		CommandHistory.add(this);
	}

}

