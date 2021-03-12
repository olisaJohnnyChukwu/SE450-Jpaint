package Command;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import Shape.*;
import view.interfaces.PaintCanvasBase;

public class groupCommand implements IUndoable, Icommand {
	
	
	ArrayList<Ishape> clipboard;
	Ishape groupIshape;
	PaintCanvasBase canvas;
	repository shaperepository;
	repository selectshaperepository;
	
	

	public groupCommand(repository shaperepository,repository selectshaperepository,PaintCanvasBase canvas) {
		super();
		
		clipboard=new ArrayList<Ishape>();
		this.canvas=canvas;
		this.shaperepository=shaperepository;
		this.selectshaperepository=selectshaperepository;
		
		
	}

	

	@Override
	public void run() throws IOException {
		// TODO Auto-generated method stub
		
		
		
		for(Ishape a:selectshaperepository.list()) {
			clipboard.add(a);
			shaperepository.removeshape(a);
		}
		
		groupIshape=new shapeGroup(clipboard);
		addGroup(groupIshape,shaperepository);
		shaperepository.redraw();
		CommandHistory.add(this);
		
	

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
		ungroup();
		shaperepository.removeshape(groupIshape);
		
		
	

	}

	@Override
	public void redo() {
		
		for(Ishape sh:clipboard) {
			shaperepository.removeshape(sh);
		}
		
		addGroup(groupIshape,shaperepository);
		shaperepository.redraw();

	}
	
	public void addGroup(Ishape shape,repository shaperepository) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        shaperepository.addshape(shape);
		shape.Draw(canvas);
		
	}
	public void ungroup() {
		// TODO Auto-generated method stub
		for(Ishape sh:clipboard) {
			shaperepository.addshape(sh);
		}
		
	if(!clipboard.contains(groupIshape)) {
		clipboard.add(groupIshape);}
		shaperepository.removeshape(groupIshape);
	}

}
