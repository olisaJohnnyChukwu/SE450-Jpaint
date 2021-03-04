package Shape;

import java.awt.Graphics2D;

import model.ShapeType;
import view.interfaces.PaintCanvasBase;

public class shapeOutliner extends shapeOutline{

	public shapeOutliner(Ishape outline) {
		super(outline);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void Draw(PaintCanvasBase canvas) {
		
		shapeProperties prop=getOutline();
		Graphics2D graphics2d = canvas.getGraphics2D();
		if(outline.ShapeName().equals(ShapeType.GROUP)) {
			graphics2d.drawRect(prop.getX(), prop.getY(), prop.getWidth(), prop.getHeight());
			return;
			
		}
		
		if(outline.ShapeName().equals(ShapeType.RECTANGLE)) {
		graphics2d.drawRect(prop.getX(), prop.getY(), prop.getWidth(), prop.getHeight());
		}else if(outline.ShapeName().equals(ShapeType.ELLIPSE)){
		graphics2d.drawOval(prop.getX(), prop.getY(), prop.getWidth(), prop.getHeight());
			
		}
		else if(outline.ShapeName().equals(ShapeType.TRIANGLE)){
			int x[]=new int[3];
			int y[]=new int[3];
			
			x[0]=prop.getX();
			x[1]=prop.getX()+prop.getWidth();
			x[2]=prop.getX();
			y[0]=prop.getY();
			y[1]=prop.getY()+prop.getHeight();
			y[2]=prop.getY()+prop.getHeight();
			graphics2d.drawPolygon(x, y, 3);
		}
		
	}
	
	public shapeProperties getOutline(){
		shapeProperties prop=outline.getProperties();
		int x=prop.getX()-10;
		int y=prop.getY()-10;
		int width=prop.getWidth()+20;
		int height=prop.getHeight()+20;
		shapeProperties s=new shapeProperties(x, y,width,height, null, null, prop.getType());
		return s;
		
	}

}
