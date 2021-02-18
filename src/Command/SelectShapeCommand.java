package Command;


import java.io.IOException;

import view.interfaces.PaintCanvasBase;

public class SelectShapeCommand implements Icommand, IUndoable {
	
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
		CommandHistory.add(this);
		
	}
	@Override
	public void undo() {
		/*selectedShape.clear();
		 * 
		 */
		//System.out.println(selectedShape.selectedshapelist);
		CommandHistory.undo();
		// TODO Auto-generated method stub*/

	}

	@Override
	public void redo() {
		/*selectedShape.clear();
		selectedShape.inRange(point, list);*/
		CommandHistory.redo();
		/*try {
			run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println(selectedShape.selectedshapelist);
		//CommandHistory.redo();
		// TODO Auto-generated method stub

	}

	

}
