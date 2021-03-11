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
	ArrayList<Ishape> clipboard;
	int dx;
	int dy;
	repository shaperepository;
	repository selectshaperepository;
	
	

	public MoveCommand(SelectedShapeList selectedShape, ShapeList list, int dx, int dy,repository shaperepository,repository selectshaperepository) {
		super();
		this.selectedShape = selectedShape;
		this.list = list;
		this.dx = dx;
		this.dy = dy;
		clipboard=new ArrayList<>();
		this.shaperepository=shaperepository;
		this.selectshaperepository=selectshaperepository;
	}

	

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		for(Ishape shape:clipboard) {
			if(selectshaperepository.contains(shape)) {
				shape.negativedisplacement(dx, dy);
			}
			
		}
		shaperepository.redraw();

		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		

		for(Ishape shape:clipboard) {
			if(selectshaperepository.contains(shape)) {
				shape.positivedisplacement(dx, dy);
			}
			
		}
		shaperepository.redraw();
		
		
	}

	@Override
	public void run() throws IOException {
		for(Ishape shape:shaperepository.list()) {
			if(selectshaperepository.contains(shape)) {
				shape.positivedisplacement(dx, dy);
				clipboard.add(shape);
			}
			
		}
		shaperepository.redraw();
		CommandHistory.add(this);
		
		
		
		// TODO Auto-generated method stub

	}

}
