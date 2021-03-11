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
	repository shaperepository;
	repository coyshaperepository;
	
	int x;

	
	
	 
	public pasteCommand(int num, CopyShapeList copyList, ShapeList shapelist,IApplicationState applicationState,int x,repository shaperepository,repository coyshaperepository) {
		super();
		this.num = num;
		this.copyList = copyList;
		this.shapelist = shapelist;
		clipboard=new ArrayList<>();
		this.applicationState=applicationState;
		this.x=x;
		this.shaperepository=shaperepository;
		this.coyshaperepository=coyshaperepository;
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		for(Ishape s:clipboard) {
			
			if(shaperepository.contains(s)) {
				shaperepository.removeshape(s);
			}
		}
		
		shaperepository.redraw();
		
		
		
		
		
	}

	@Override
	public void redo() {
		
		
		for(Ishape s:clipboard) {
			shaperepository.addshape(s);
		}
		
	}

	@Override
	public void run() throws IOException {
		
		for(Ishape shape:coyshaperepository.list()) {
			
			Ishape copy=shape.copy(shape,x);
			System.out.println(copy.equals(shape));
			clipboard.add(copy);
			shaperepository.addshape(copy);
			}
		System.out.println(shaperepository.list());
		
		CommandHistory.add(this);
	}

}
