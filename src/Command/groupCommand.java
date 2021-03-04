package Command;

import java.io.IOException;
import java.util.ArrayList;

import Shape.*;

public class groupCommand implements IUndoable, Icommand {
	
	SelectedShapeList selectedShape;
	ShapeList shapelist;
	ArrayList<Ishape> clipboard;
	shapeGroup groupIshape;
	
	

	public groupCommand(SelectedShapeList selectedShape, ShapeList shapelist) {
		super();
		this.selectedShape = selectedShape;
		this.shapelist = shapelist;
		clipboard=new ArrayList<Ishape>();
		
	}

	

	@Override
	public void run() throws IOException {
		// TODO Auto-generated method stub
		for(Ishape a:selectedShape.selectedshapelist) {
			clipboard.add(a);
		}
		groupIshape=new shapeGroup(clipboard);
		shapelist.AddShape(groupIshape);
		CommandHistory.add(this);
		
	

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		for(Ishape shape:clipboard) {
			//shapelist.AddShape(shape);
			groupIshape.removeShape(shape);
		}
		System.out.println(groupIshape.getGroup().size());

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		for(Ishape shape:clipboard) {
			shapelist.RemoveShape(shape);
			groupIshape.addShape(shape);
		}
		System.out.println(groupIshape.getGroup().size());

	}

}
