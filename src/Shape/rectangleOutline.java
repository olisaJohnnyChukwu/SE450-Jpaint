package Shape;

import java.awt.Graphics2D;

import view.interfaces.PaintCanvasBase;

public class rectangleOutline extends shapeOutline{

	public rectangleOutline(Ishape outline) {
		super(outline);
		// TODO Auto-generated constructor stub
	}
	
	public void Draw(PaintCanvasBase canvas) {
		shapeProperties prop=getOutline();
		Graphics2D graphics2d = canvas.getGraphics2D();
		graphics2d.drawRect(prop.getX(), prop.getY(), prop.getWidth(), prop.getHeight());
		
	}
	
	public shapeProperties getOutline(){
		shapeProperties prop=outline.getProperties();
		int x=prop.getX()-10;
		int y=prop.getY()-10;
		int width=prop.getWidth()+20;
		int height=prop.getHeight()+20;
		shapeProperties s=new shapeProperties(x, y,width,height, null, null, null);
		return s;
		
	}

	

}
