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

public class Rectangle extends shape{
	private shapeProperties properties;
	
	private setColorMap map= new setColorMap();
	private  UUID uuid=UUID.randomUUID();
	private  String Id;
	

	public Rectangle(shapeProperties properties) {
		super(properties);
		this.properties = properties;
		this.Id=uuid.toString();
	}


	
	@Override
	public void Draw(PaintCanvasBase canvas) {
		Graphics2D graphics2d = canvas.getGraphics2D();
		//graphics2d.fillRect(properties.point.getX1(), properties.point.getY1(), properties.point.getdiffx(),properties.point.getdiffy());
		// TODO Auto-generated method stub
		
		EnumMap<ShapeColor,java.awt.Color> m=map.getMap();
		graphics2d.setColor(m.get(properties.getColor()));
		if (properties.getShade().equals(ShapeShadingType.OUTLINE)) {
			graphics2d.drawRect(properties.getX(), properties.getY(), properties.getWidth(),properties.getHeight());
		 }else if (properties.getShade().equals(ShapeShadingType.FILLED_IN)) {
			 graphics2d.fillRect(properties.getX(), properties.getY(), properties.getWidth(),properties.getHeight());
        }else if (properties.getShade().equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
        	graphics2d.fillRect(properties.getX(), properties.getY(), properties.getWidth(),properties.getHeight());
        	graphics2d.drawRect(properties.getX(), properties.getY(), properties.getWidth(),properties.getHeight());
        }
		
	}



	@Override
	public ShapeType ShapeName() {
		// TODO Auto-generated method stub
		return ShapeType.RECTANGLE;
	}
}
