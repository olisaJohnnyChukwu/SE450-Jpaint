
package ClickHandler;

import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import Command.CopyShapeList;
import Command.CreateShapeCommand;
import Command.Icommand;
import Command.MoveCommand;
import Command.SelectShapeCommand;
import Command.SelectedShapeList;
import Command.ShapeList;
import Shape.Ishape;
import Shape.rectangleOutline;
import Shape.shapeOutliner;
//import Shape.ShapeFactory;
import Shape.shapeProperties;
import model.MouseMode;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class clickHandler extends MouseAdapter{
	
	PaintCanvasBase canvas;
	point point=new point();
	ShapeList list;
	SelectedShapeList selectedShape;
	CopyShapeList copyList;
	IApplicationState applicationState;
	
	
	int[] move=new int[4];

	public clickHandler(PaintCanvasBase canvas, ShapeList list,IApplicationState applicationState,SelectedShapeList selectedShape) {
		super();
		this.canvas = canvas;
		
		this.list = list;
		this.applicationState=applicationState;
		this.selectedShape=selectedShape;
	}

	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		point.setX1(e.getX());
		point.setY1(e.getY());
		move[0]=e.getX();
		move[1]=e.getY();
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		point.setX2(e.getX());
		point.setY2(e.getY());
		move[2]=e.getX();
		move[3]=e.getY();
		
		
		//Graphics2D graphics2d = canvas.getGraphics2D();
		//graphics2d.fillRect(point.getX1(), point.getY1(), point.getdiffx(), point.getdiffy());
		//ShapeList list=new ShapeList(canvas);
		if(applicationState.getActiveMouseMode().equals( MouseMode.DRAW)) {
		ShapeShadingType shade=applicationState.getActiveShapeShadingType();
		ShapeColor shapeColor=applicationState.getActivePrimaryColor();
		ShapeType shapetype=applicationState.getActiveShapeType();
		shapeProperties properties=new shapeProperties(point,shade,shapeColor,shapetype);
		//shapeProperties properties=new shapeProperties(point,shade,shapeColor,shapetype);
		//copyList.clear();
		Icommand C= new CreateShapeCommand(list,properties,applicationState);
		try {
			C.run();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}else if(applicationState.getActiveMouseMode().equals(MouseMode.SELECT)) {
			 Icommand C= new SelectShapeCommand(selectedShape, list, point);
			 
			
			 selectedShape.clear();
			 try {
				C.run();
				for(Ishape a:selectedShape.getSelectedshapelist()) {
					 Ishape b=new shapeOutliner(a);
				        b.Draw(canvas);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		}else if(applicationState.getActiveMouseMode().equals(MouseMode.MOVE)) {
				int dx=move[2]-move[0];
				int dy=move[3]-move[1];
				
				/*Icommand C= new SelectShapeCommand(selectedShape, list, point);
				 selectedShape.clear();
				 try {
					C.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				Icommand C1= new MoveCommand(selectedShape, list, dx, dy);
				try {
					C1.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		}
		
		
	}

	



	

