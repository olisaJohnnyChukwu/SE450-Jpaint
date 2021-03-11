package Command;

import java.util.ArrayList;

import Shape.Ishape;

public interface repository {
	public void addshape(Ishape shape);
	public void removeshape(Ishape shape);
	public boolean contains(Ishape shape);
	public void addlist(repository list);
	public ArrayList<Ishape> list();
	public void clear();
	public int size();
	public void redraw();
	public void addGroup(Ishape shape);
	

}
