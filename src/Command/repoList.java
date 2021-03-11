package Command;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

import Shape.Ishape;
import Shape.shapeGroup;
import view.interfaces.PaintCanvasBase;

public class repoList implements repository {
	protected ArrayList<Ishape> list;
	protected PaintCanvasBase canvas;
	
	public repoList(ArrayList<Ishape> list, PaintCanvasBase canvas) {
		super();
		this.list = list;
		this.canvas = canvas;
	}

	public repoList() {
		super();
		this.list = new ArrayList<>();
	}

	@Override
	public void addshape(Ishape shape) {
		// TODO Auto-generated method stub
		list.add(shape);

	}

	@Override
	public void removeshape(Ishape shape) {
		// TODO Auto-generated method stub
		list.remove(shape);

	}

	@Override
	public boolean contains(Ishape shape){
		// TODO Auto-generated method stub
		for(Ishape s:list) {
			if(shape.equals(s)) {
				return true;
			}
		}
		return false;
	
	}

	@Override
	public void addlist(repository clonelist) {
		// TODO Auto-generated method stub
		ArrayList<Ishape> a=clonelist.list();
		for(Ishape shape:a) {
			list.add(shape);
		}

	}

	@Override
	public ArrayList<Ishape> list() {
		// TODO Auto-generated method stub
		ArrayList<Ishape> copy=new ArrayList<Ishape>();
		for(Ishape a:list) {
			copy.add(a);
		}
		return copy;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		list.clear();
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	
	public void redraw() {
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        for(Ishape s: list) {
			s.Draw(canvas);
		}
	}

	public void addGroup(Ishape shape) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		list.add(shape);
		shapeGroup sh=(shapeGroup)shape;
		
		for(Ishape a:sh.getGroup())
			a.Draw(canvas);
		
	}
	

}
