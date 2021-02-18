package Command;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

import Shape.CreateShapeFactory;
import Shape.Ishape;
import Shape.IshapeFactory;
import Shape.shapeProperties;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;


public class ShapeList {
	 ArrayList<Ishape> list=new ArrayList<>();
	//private ArrayList<Ishape> list2=new ArrayList<>();
	
	private PaintCanvasBase canvas;
	
	

	public ShapeList(PaintCanvasBase canvas) {
		super();
		this.canvas = canvas;
	}

	public void traverse(Ishape shape) {
		for(Ishape s:list) {
			if(shape.equals(s)) {
				list.remove(shape);
				break;
				//list.remove(shape);
				
			}
			
		}
		System.out.println(list);
	}

	public void AddShape(Ishape shape) {
		
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        list.add(shape);
        
		for(Ishape s: list) {
			s.Draw(canvas);
		}
		//shape.Draw(canvas);
		//new ShapeDrawer(getList(),canvas);
	}
	public void RemoveShape(Ishape shape) {
		list.remove(shape);
		//Graphics2D g=canvas.getGraphics2D();
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		
		for(Ishape s: list) {
			s.Draw(canvas);
		}
	}

	public ArrayList<Ishape> getList() {
		return list;
	}
	
	

	public PaintCanvasBase getCanvas() {
		return canvas;
	}
	
	public void redraw() {
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        for(Ishape s: list) {
			s.Draw(canvas);
		}
	}
	public void removeAtback() {
		int i=list.size()-1;
		list.remove(i);
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		
		for(Ishape s: list) {
			s.Draw(canvas);
		}
		
	}
	public Ishape makeShape(Ishape shape,IApplicationState applicationState,int a) {
		
		
		
		shapeProperties prop2=shape.getProperties();
		int x=prop2.getX()+a;
		int y=prop2.getY()-a;
		int w=prop2.getWidth();
		int h=prop2.getHeight();
		
		ShapeShadingType shade=prop2.getShade();
		ShapeType shapetype=prop2.getType();
		ShapeColor shapecolor=prop2.getColor();
		
		shapeProperties prop=new shapeProperties(x, y, w, h, shade, shapecolor,shapetype);
		IshapeFactory factory=new CreateShapeFactory();
		//Ishape copy=factory.CreateShape(prop, applicationState);
		Ishape copy=factory.CreateShape2(prop,shapetype);
		//copy.Draw(canvas);
		list.add(copy);
		System.out.println(shape.getId());
		System.out.println(copy.getId());
		

		return copy;
		
	}
	public int size() {
		return list.size();
	}
	public Ishape shapeAt(int i) {
		return list.get(i);
	}
	public boolean contains(Ishape shape) {
		for(Ishape s:list) {
			if(shape.equals(s)) {
				return true;
			}
		}
		return false;
	}


	/*public void setList(ArrayList<Ishape> list) {
		this.list = list;
	}*/

	
	
	
	
	

}
