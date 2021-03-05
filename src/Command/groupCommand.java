package Command;

import java.io.IOException;
import java.util.ArrayList;

import Shape.*;
import view.interfaces.PaintCanvasBase;

public class groupCommand implements IUndoable, Icommand {
	
	SelectedShapeList selectedShape;
	ShapeList shapelist;
	ArrayList<Ishape> clipboard;
	Ishape groupIshape;
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
		
		
		System.out.println("groupIshape2.getId()");
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
		
		shapelist.RemoveShape(groupIshape);
		shapeGroup group=(shapeGroup)groupIshape;
		for(Ishape a:group.getGroup() ){
			shapelist.AddShape(a);
		}
	

	}

	@Override
	public void redo() {
		for(Ishape shape:clipboard) {
			shapelist.RemoveShape(shape);
		}
		shapelist.AddShape(groupIshape);

	}

}

