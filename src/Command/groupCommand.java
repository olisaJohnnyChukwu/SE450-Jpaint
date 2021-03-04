package Command;

import java.io.IOException;
import java.util.ArrayList;

import Shape.*;
import view.interfaces.PaintCanvasBase;

public class groupCommand implements IUndoable, Icommand {
	
	SelectedShapeList selectedShape;
	ShapeList shapelist;
	ArrayList<Ishape> clipboard;
	shapeGroup groupIshape;
	PaintCanvasBase canvas;
	
	

	public groupCommand(SelectedShapeList selectedShape, ShapeList shapelist) {
		super();
		this.selectedShape = selectedShape;
		this.shapelist = shapelist;
		clipboard=new ArrayList<Ishape>();
		canvas=shapelist.getCanvas();
		
	}

	

	@Override
	public void run() throws IOException {
		// TODO Auto-generated method stub
		for(Ishape a:selectedShape.selectedshapelist) {
			clipboard.add(a);
			shapelist.RemoveShape(a);
		}
		groupIshape=new shapeGroup(clipboard);
		shapelist.AddShape(groupIshape);
		CommandHistory.add(this);
		
	

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
		for(Ishape shape:clipboard) {
			groupIshape.removeShape(shape);
			shapelist.AddShape(shape);
		}
		shapelist.RemoveShape(groupIshape);
	

	}

	@Override
	public void redo() {
		
		// TODO Auto-generated method stub
		groupIshape.setGroup(clipboard);
		
		for(Ishape shape:clipboard) {
			shapelist.RemoveShape(shape);
			
			
		}
		

	}

}

