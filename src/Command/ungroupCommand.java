package Command;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.*;
import java.util.*;

import Shape.Ishape;
import Shape.shapeGroup;
import view.interfaces.PaintCanvasBase;

public class ungroupCommand implements Icommand, IUndoable {
	
	ArrayList<Ishape> clipboard;
	repository shaperepository;
	repository selectshaperepository;
	PaintCanvasBase canvas;
	public ungroupCommand(repository shaperepository,
			repository selectshaperepository,PaintCanvasBase canvas) {
		super();
		
		clipboard=new ArrayList<Ishape>();
		this.shaperepository = shaperepository;
		this.selectshaperepository = selectshaperepository;
		this.canvas=canvas;
	}
	
	

	

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
		for(Ishape sh:clipboard) {
			shapeGroup s=(shapeGroup)sh;
			for(Ishape a:s.getGroup()) {
				shaperepository.removeshape(a);
			}
			addGroup(sh, shaperepository);
		}
		

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		for(Ishape a:clipboard) {
			a.ungroup(a,shaperepository,clipboard);
		}
		
	}

	@Override
	public void run() throws IOException {
		// TODO Auto-generated method stub
		for(Ishape a:selectshaperepository.list()) {
			a.ungroup(a, shaperepository,clipboard);
		}
		CommandHistory.add(this);
		
	}
	
	public void addGroup(Ishape shape,repository shaperepository) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        shaperepository.addshape(shape);
		shape.Draw(canvas);
		
	}
	

}
