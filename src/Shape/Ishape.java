package Shape;

import Command.ShapeList;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

public interface Ishape {
	
	public void Draw(PaintCanvasBase canvas);
	public ShapeType ShapeName();
	public shapeProperties getProperties();
	public String getId();
	public void setProperties(shapeProperties properties);
	public boolean equals(Object o);
	public void negativedisplacement(int dx, int dy);
	public void positivedisplacement(int dx, int dy);
	public Ishape copy(Ishape shape, int x);
	public void delete(Ishape shape,ShapeList shapelist);
	public void addtolist(Ishape shape,ShapeList shapelist);
	

}
