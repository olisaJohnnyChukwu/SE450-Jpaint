package Command;

import java.util.ArrayList;

import Shape.Ishape;
import view.interfaces.PaintCanvasBase;

public class ShapeDrawer {
	
	ArrayList<Ishape> list;
	PaintCanvasBase canvas;
	public ShapeDrawer(ArrayList<Ishape> list, PaintCanvasBase canvas) {
		super();
		this.list=list;
		this.canvas = canvas;
		
		for(Ishape shape:list) {
			shape.Draw(canvas);
		}
	}
	
	

}
