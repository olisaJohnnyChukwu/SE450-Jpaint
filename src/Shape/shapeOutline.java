package Shape;

import model.ShapeType;
import view.interfaces.PaintCanvasBase;

public abstract class shapeOutline implements Ishape {
	protected Ishape outline;
	
	public shapeOutline(Ishape outline) {
		super();
		this.outline = outline;
	}

	@Override
	public void Draw(PaintCanvasBase canvas) {
		// TODO Auto-generated method stub

	}

	

}
