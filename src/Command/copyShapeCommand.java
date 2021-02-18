package Command;

import java.io.IOException;

import Shape.Ishape;

public class copyShapeCommand implements Icommand, IUndoable {
	//int numberofCopiedShapes;
	CopyShapeList copyList;
	SelectedShapeList selectedShape;

	public copyShapeCommand( CopyShapeList copyList, SelectedShapeList selectedShape) {
		super();
		//this.numberofCopiedShapes = numberofCopiedShapes;
		this.copyList = copyList;
		this.selectedShape = selectedShape;
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		copyList.clear();
		System.out.println(copyList.getCopyList());
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		try {
			run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() throws IOException {
		// TODO Auto-generated method stub
		copyList.addToList(selectedShape);
		System.out.println(copyList.getCopyList());
		

	}

}
