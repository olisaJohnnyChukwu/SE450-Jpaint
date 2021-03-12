package Command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Shape.*;
import model.interfaces.IApplicationState;



public class pasteCommand implements Icommand, IUndoable {
	
	List<Ishape> clipboard;
	IApplicationState applicationState;
	repository shaperepository;
	repository coyshaperepository;
	int x;

	public pasteCommand(IApplicationState applicationState,int x,repository shaperepository,repository coyshaperepository) {
		super();
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
		shaperepository.redraw();
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

