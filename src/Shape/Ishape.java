package Shape;

import java.util.ArrayList;


import Command.*;
import model.*;

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
	public void delete(Ishape shape,repository shaperepository);
	public void addtolist(Ishape shape,repository shaperepository);
	public void ungroup(Ishape shape,repository shaperepository, ArrayList<Ishape> clipboard);

}
