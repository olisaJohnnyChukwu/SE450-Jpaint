package Command;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Shape.Ishape;
import Shape.shapeGroup;
import view.interfaces.PaintCanvasBase;

public class shapelistrepo extends repoList {

	
	public shapelistrepo(ArrayList<Ishape> list, PaintCanvasBase canvas) {
		super(list, canvas);
		// TODO Auto-generated constructor stub
	}
	
	public void addshape(Ishape shape) {

		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        list.add(shape);
       
        
		for(Ishape s: list) {
			s.Draw(canvas);
		}
		System.out.println(list.size());
	}
	
	public void removeshape(Ishape shape) {
		list.remove(shape);
		//Graphics2D g=canvas.getGraphics2D();
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		
		for(Ishape s: list) {
			s.Draw(canvas);
		}
		System.out.println(list.size());
	}
	
	
	
	
	
	
	
	

}
