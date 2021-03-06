package Shape;

import java.awt.Graphics2D;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;
import java.util.*;

import Command.ShapeList;
import Stategy.ImoveStrategy;
import Stategy.move;
import Stategy.negativeDisplacement;
import Stategy.positiveDisplacement;

public class Ellipse extends shape {
	private shapeProperties properties;
	
	private setColorMap map= new setColorMap();
	private  UUID uuid=UUID.randomUUID();
	private  String Id;
	
	

	
	public Ellipse(shapeProperties properties) {
		super(properties);
		this.properties = properties;
		Id=uuid.toString();
	}

	@Override
	public void Draw(PaintCanvasBase canvas) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = canvas.getGraphics2D();
		EnumMap<ShapeColor,java.awt.Color> m=map.getMap();
		graphics2d.setColor(m.get(properties.getColor()));
		
		if (properties.getShade().equals(ShapeShadingType.OUTLINE)) {
			graphics2d.drawOval(properties.getX(), properties.getY(), properties.getWidth(),properties.getHeight());
		
		 }else if (properties.getShade().equals(ShapeShadingType.FILLED_IN)) {
        	graphics2d.fillOval(properties.getX(), properties.getY(), properties.getWidth(),properties.getHeight());
        	
        }else if (properties.getShade().equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
        	graphics2d.fillOval(properties.getX(), properties.getY(), properties.getWidth(),properties.getHeight());
        	graphics2d.drawOval(properties.getX(), properties.getY(), properties.getWidth(),properties.getHeight());
        	
        }
		

	}
	
	@Override
	public ShapeType ShapeName() {
		// TODO Auto-generated method stub
		return ShapeType.ELLIPSE;
	}
	

}
