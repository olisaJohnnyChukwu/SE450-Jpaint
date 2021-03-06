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
		
		
		
		for(Ishape a:selectedShape.getSelectedshapelist()) {
			clipboard.add(a);
			shapelist.RemoveShape(a);
		}
		
		groupIshape=new shapeGroup(clipboard);
		shapelist.addGroup(groupIshape);
		CommandHistory.add(this);
		
	

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
		shapeGroup gr=(shapeGroup)groupIshape;
		for(Ishape sh:gr.getGroup()) {
			sh.addtolist(sh, shapelist);
		}
		shapelist.RemoveShape(gr);
		
	

	}

	@Override
	public void redo() {
		
		for(Ishape sh:clipboard) {
			shapelist.RemoveShape(sh);
		}
		
		shapelist.addGroup(groupIshape);

	}

}
