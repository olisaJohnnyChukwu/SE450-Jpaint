package Command;

import java.util.ArrayList;

import Shape.Ishape;

public class CopyShapeList {
	private ArrayList<Ishape> copyList;

	public CopyShapeList() {
		super();
		this.copyList=new ArrayList<Ishape>();
	}
	
	public void addToList(SelectedShapeList selectedShapes) {
		ArrayList<Ishape> a= selectedShapes.getSelectedshapelist();
		copyList.clear();
		
		for(Ishape shape:a) {
			copyList.add(shape);
		}
	}

	public ArrayList<Ishape> getCopyList() {
		return copyList;
	}

	public void clear() {
		copyList.clear();
	}
	public int size() {
		return copyList.size();
	}
	
}
