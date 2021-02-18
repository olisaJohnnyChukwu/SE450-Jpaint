package Shape;

import model.ShapeType;
import model.interfaces.IApplicationState;

public interface IshapeFactory {
	Ishape CreateShape(shapeProperties properties,IApplicationState applicationState);
	Ishape CreateShape2(shapeProperties properties,ShapeType shapeType);
	
	
	

}
