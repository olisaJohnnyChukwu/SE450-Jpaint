package Stategy;

import Shape.Ishape;

public class move {
	int dx;
	int dy;
	Ishape shape;
	
	public move(int dx, int dy,Ishape shape) {
		super();
		this.dx = dx;
		this.dy = dy;
		this.shape=shape;
		
	}
	public void displace(ImoveStrategy move) {
		move.displace(shape, dx, dy);
	}

}
