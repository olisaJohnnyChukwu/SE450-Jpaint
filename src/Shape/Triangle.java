package Shape;

import java.awt.Graphics2D;
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

public class Triangle implements Ishape {
	private shapeProperties properties;
	
	private setColorMap map= new setColorMap();
	private  UUID uuid=UUID.randomUUID();
	private  String Id;
	private int[] xarray=new int[3];
	private int[] yarray=new int[3];
	
	public Triangle(shapeProperties properties) {
		super();
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
	public ShapeType ShapeName() {
		// TODO Auto-generated method stub
		return ShapeType.TRIANGLE;
	}


	@Override
	public shapeProperties getProperties() {
		// TODO Auto-generated method stub
		return properties;
	}
	
	public String getId() {
		// TODO Auto-generated method stub
		return Id;
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
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		Ishape that=(Ishape)o;
		
		return  getId().equals(that.getId());
	}



	public void positivedisplacement(int dx,int dy){
		// TODO Auto-generated method stub
		move move=new move(dx,dy,this);
		ImoveStrategy moveStrategy=new positiveDisplacement();
		move.displace(moveStrategy);
		
	}

	
	@Override
	public void negativedisplacement(int dx,int dy) {
		// TODO Auto-generated method stub
		move move=new move(dx,dy,this);
		ImoveStrategy moveStrategy=new negativeDisplacement();
		move.displace(moveStrategy);
		
	}



	@Override
	public Ishape copy(Ishape shape,int x) {
		// TODO Auto-generated method stub
		shapeProperties prop=shape.getProperties();
		int a=prop.getX()+x;
		int b=prop.getY()-x;
		int w=prop.getWidth();
		int h=prop.getHeight();
		ShapeShadingType shade=prop.getShade();
		ShapeType shapetype=prop.getType();
		ShapeColor shapecolor=prop.getColor();
		shapeProperties prop2=new shapeProperties(a, b, w, h, shade, shapecolor, shapetype);
		IshapeFactory factory=new CreateShapeFactory();
		Ishape copy=factory.CreateShape2(prop2,shapetype);
		return copy;
	}
	
	
	@Override
	public void delete(Ishape shape, ShapeList shapelist) {
		// TODO Auto-generated method stub
		shapelist.RemoveShape(shape);
		
	}

	@Override
	public void addtolist(Ishape shape, ShapeList shapelist) {
		// TODO Auto-generated method stub
		shapelist.AddShape(shape);
		
	}
	
	
	
	

}
