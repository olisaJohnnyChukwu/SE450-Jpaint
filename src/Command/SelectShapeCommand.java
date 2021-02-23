package Command;


import java.io.IOException;

import view.interfaces.PaintCanvasBase;

public class SelectShapeCommand implements Icommand{
	
	SelectedShapeList selectedShape;
	ShapeList list;
	ClickHandler.point point;
	

	public SelectShapeCommand(SelectedShapeList selectedShape, ShapeList list, ClickHandler.point point) {
		super();
		this.selectedShape = selectedShape;
		this.list = list;
		this.point = point;
		
	}


	@Override
	public void run() throws IOException {
		// TODO Auto-generated method stub
		selectedShape.clear();
		selectedShape.inRange(point, list);
		
		
	}
	

	

}
