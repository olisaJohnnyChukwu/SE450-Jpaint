package Command;

import java.io.*;
import java.util.*;


import Shape.Ishape;

public class deleteShapeCommand implements Icommand, IUndoable {
	
	List<Ishape> clipboard;
	repository shaperepository;
	repository selectshaperepository;
	
	
	public deleteShapeCommand(repository shaperepository,repository selectshaperepository) {
		super();
		
		clipboard=new ArrayList<>();
		this.shaperepository=shaperepository;
		this.selectshaperepository=selectshaperepository;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
		for(Ishape shape:clipboard) {
			//shapelist.AddShape(shape);
			shape.addtolist(shape, shaperepository);
			
			
		}
		
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		for(Ishape shape:selectshaperepository.list()) {
			
			//shapelist.RemoveShape(shape);
			shape.delete(shape, shaperepository);
		}
	
	}

	@Override
	public void run() throws IOException {
		// TODO Auto-generated method stub
		for(Ishape shape:selectshaperepository.list()) {
			clipboard.add(shape);
			//shapelist.RemoveShape(shape);
			shape.delete(shape, shaperepository);
		}
		
		CommandHistory.add(this);
	}

}
