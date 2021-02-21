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

	@Override
	public ShapeType ShapeName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public shapeProperties getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperties(shapeProperties properties) {
		// TODO Auto-generated method stub

	}

}
