package Shape;

import ClickHandler.point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ApplicationState;
//first
public class shapeProperties {
	point point;
	private int x;
	private int y;
	private int width;
	private int height;
	ShapeShadingType shade;
	ShapeColor shapecolor;
	ShapeType shapeType;
	
	
	
	public shapeProperties(int x,int y,int width,int height,ShapeShadingType shade,ShapeColor shapecolor,ShapeType shapeType) {
		this.shade=shade;
		this.shapecolor=shapecolor;
		this.shapeType=shapeType;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		
	}
	
	public shapeProperties(point point,ShapeShadingType shade,ShapeColor shapecolor,ShapeType shapeType) {
		super();
		this.point = point;
		this.x = point.getX1();
		this.y = point.getY1();
		this.width =point.getWidth();
		this.height = point.getHeight();
		this.shade=shade;
		this.shapecolor=shapecolor;
		this.shapeType=shapeType;
		
		
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public ShapeShadingType getShade() {
		return shade;
		
	}
	public ShapeColor getColor() {
		return shapecolor;
		
	}
	public ShapeType getType() {
		return shapeType;
		
	}
	
	

}
