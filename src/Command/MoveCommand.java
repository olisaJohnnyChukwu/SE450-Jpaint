package Command;

import java.io.IOException;
import java.util.ArrayList;

import Shape.Ishape;
import Shape.shapeProperties;
import Stategy.ImoveStrategy;
import Stategy.move;
import Stategy.negativeDisplacement;
import Stategy.positiveDisplacement;

public class MoveCommand implements Icommand, IUndoable {
	
	SelectedShapeList selectedShape;
	ShapeList list;
	int dx;
	int dy;
	
	

	public MoveCommand(SelectedShapeList selectedShape, ShapeList list, int dx, int dy) {
		super();
		this.selectedShape = selectedShape;
		this.list = list;
		this.dx = dx;
		this.dy = dy;
	}

	

	@Override
	public void undo() {
		// TODO Auto-generated method stub

		
		for(Ishape shape:list.getList()) {
			if(selectedShape.getSelectedshapelist().contains(shape)) {
				move move=new move(dx,dy,shape);
				ImoveStrategy moveStrategy=new negativeDisplacement();
				move.displace(moveStrategy);
			}
			
		}
		list.redraw();

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		

		
		for(Ishape shape:list.getList()) {
			if(selectedShape.getSelectedshapelist().contains(shape)) {
				move move=new move(dx,dy,shape);
				ImoveStrategy moveStrategy=new positiveDisplacement();
				move.displace(moveStrategy);
			}
			
		}
		list.redraw();
		
		
	}

	@Override
	public void run() throws IOException {
		for(Ishape shape:list.getList()) {
			if(selectedShape.getSelectedshapelist().contains(shape)) {
				move move=new move(dx,dy,shape);
				ImoveStrategy moveStrategy=new positiveDisplacement();
				move.displace(moveStrategy);
			}
			
		}
		list.redraw();
		CommandHistory.add(this);
		
		
		
		// TODO Auto-generated method stub

	}

}
