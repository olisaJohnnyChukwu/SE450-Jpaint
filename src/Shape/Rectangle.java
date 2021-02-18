package Shape;

import java.awt.Graphics2D;
import java.util.EnumMap;
import java.util.UUID;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class Rectangle implements Ishape{
	private shapeProperties properties;
	
	private setColorMap map= new setColorMap();
	private  UUID uuid=UUID.randomUUID();
	private  String Id;
	

	public Rectangle(shapeProperties properties) {
		super();
		this.properties = properties;
		this.Id=uuid.toString();
	}

	public void setId(String id) {
		this.Id = id;
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



	@Override
	public shapeProperties getProperties() {
		// TODO Auto-generated method stub
		return properties;
	}



	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return Id;
	}



	@Override
	public void setProperties(shapeProperties properties) {
		// TODO Auto-generated method stub
		this.properties=properties;
		
	}
	
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		Ishape that=(Ishape)o;
		
		return  getId().equals(that.getId());
	}


	

}
