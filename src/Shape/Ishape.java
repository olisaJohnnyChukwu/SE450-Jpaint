package Shape;

import model.ShapeType;
import view.interfaces.PaintCanvasBase;

public interface Ishape {
	

	
	
	public void Draw(PaintCanvasBase canvas);
	public ShapeType ShapeName();
	public shapeProperties getProperties();
	public String getId();
	public void  setId(String id);
	public void setProperties(shapeProperties properties);
	public boolean equals(Object o);
	
	

}
