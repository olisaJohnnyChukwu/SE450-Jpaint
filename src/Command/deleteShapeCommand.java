package Command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Shape.Ishape;

public class deleteShapeCommand implements Icommand, IUndoable {
	ShapeList shapelist;
	SelectedShapeList selectedShape;
	List<Ishape> clipboard;
	
	
	public deleteShapeCommand(ShapeList shapelist, SelectedShapeList selectedShape) {
		super();
		this.shapelist = shapelist;
		this.selectedShape = selectedShape;
		clipboard=new ArrayList<>();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
		for(Ishape shape:clipboard) {
			//shapelist.AddShape(shape);
			shape.addtolist(shape, shapelist);
			
			
		}
		
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		for(Ishape shape:selectedShape.getSelectedshapelist()) {
			
			//shapelist.RemoveShape(shape);
			shape.delete(shape, shapelist);
		}
	
	}

	@Override
	public void run() throws IOException {
		// TODO Auto-generated method stub
		for(Ishape shape:selectedShape.getSelectedshapelist()) {
			clipboard.add(shape);
			//shapelist.RemoveShape(shape);
			shape.delete(shape, shapelist);
		}
		
		CommandHistory.add(this);
	}

}
