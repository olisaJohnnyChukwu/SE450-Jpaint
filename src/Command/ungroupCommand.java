package Command;

import java.io.*;
import java.util.*;

import Shape.Ishape;
import Shape.shapeGroup;

public class ungroupCommand implements Icommand, IUndoable {
	SelectedShapeList selectedShape;
	ShapeList shapelist;
	ArrayList<Ishape> clipboard;
	
	

	public ungroupCommand(SelectedShapeList selectedShape, ShapeList shapelist) {
		super();
		this.selectedShape = selectedShape;
		this.shapelist = shapelist;
		clipboard=new ArrayList<Ishape>();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
		for(Ishape sh:clipboard) {
			shapeGroup s=(shapeGroup)sh;
			for(Ishape a:s.getGroup()) {
				shapelist.RemoveShape(a);
			}
			shapelist.addGroup(sh);
			
		}
		

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		for(Ishape a:clipboard) {
			//a.addtolist(a, shapelist);
			a.ungroup(a, shapelist,clipboard);
			
		}
		
	}

	@Override
	public void run() throws IOException {
		// TODO Auto-generated method stub
		for(Ishape a:selectedShape.getSelectedshapelist()) {
			a.ungroup(a, shapelist,clipboard);
		}
		
		CommandHistory.add(this);
		
	}

}
