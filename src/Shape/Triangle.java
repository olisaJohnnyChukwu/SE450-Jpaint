package Shape;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.UUID;

import Command.ShapeList;
import Stategy.ImoveStrategy;
import Stategy.move;
import Stategy.negativeDisplacement;
import Stategy.positiveDisplacement;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class Triangle extends shape {
	private shapeProperties properties;
	
	private setColorMap map= new setColorMap();
	private  UUID uuid=UUID.randomUUID();
	private  String Id;
	private int[] xarray=new int[3];
	private int[] yarray=new int[3];
	
	public Triangle(shapeProperties properties) {
		super(properties);
		this.properties = properties;
		this.Id=uuid.toString();
		xarray[0]=properties.getX();
		xarray[1]=properties.getX()+properties.getWidth();
		xarray[2]=properties.getX();
		
		yarray[0]=properties.getY();
		yarray[1]=properties.getY()+properties.getHeight();
		yarray[2]=properties.getY()+properties.getHeight();
		
		
	}
	

	@Override
	public void Draw(PaintCanvasBase canvas) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		//graphics2d.drawPolygon(properties.getXarray(),properties.getYarray(),3);
		EnumMap<ShapeColor,java.awt.Color> m=map.getMap();
		graphics2d.setColor(m.get(properties.getColor()));
		if (properties.getShade().equals(ShapeShadingType.OUTLINE)) {
			graphics2d.drawPolygon(xarray,yarray,3);
		 }else if (properties.getShade().equals(ShapeShadingType.FILLED_IN)) {
        	graphics2d.fillPolygon(xarray,yarray,3);
        }else if (properties.getShade().equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
        	graphics2d.drawPolygon(xarray,yarray,3);
        	graphics2d.fillPolygon(xarray,yarray,3);
        }
		
	
		// TODO Auto-generated method stub
	}


	


	@Override
	public void setProperties(shapeProperties properties) {
		// TODO Auto-generated method stub
		this.properties=properties;
		xarray[0]=properties.getX();
		xarray[1]=properties.getX()+properties.getWidth();
		xarray[2]=properties.getX();
		
		yarray[0]=properties.getY();
		yarray[1]=properties.getY()+properties.getHeight();
		yarray[2]=properties.getY()+properties.getHeight();
		
	}
	
	@Override
	public ShapeType ShapeName() {
		// TODO Auto-generated method stub
		return ShapeType.TRIANGLE;
	}
	
	

}

