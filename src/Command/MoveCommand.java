package Command;

import java.io.IOException;
import java.util.ArrayList;

import Shape.*;


public class MoveCommand implements Icommand, IUndoable {
	
	
	ArrayList<Ishape> clipboard;
	int dx;
	int dy;
	repository shaperepository;
	repository selectshaperepository;
	
	

	public MoveCommand( int dx, int dy,repository shaperepository,repository selectshaperepository) {
		super();
		
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
			
				shape.negativedisplacement(dx, dy);
			
			
		}
		shaperepository.redraw();

		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		

		for(Ishape shape:clipboard) {
			
				shape.positivedisplacement(dx, dy);
			
			
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

