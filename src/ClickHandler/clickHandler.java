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
import Command.repository;
import Shape.Ishape;

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
	repository shaperepository;
	repository selectshaperepository;
	int[] move=new int[4];
	

	public clickHandler(PaintCanvasBase canvas, ShapeList list,IApplicationState applicationState,SelectedShapeList selectedShape,repository shaperepository, repository selectshaperepository) {
		super();
		this.canvas = canvas;
		
		this.list = list;
		this.applicationState=applicationState;
		this.selectedShape=selectedShape;
		this.shaperepository=shaperepository;
		this.selectshaperepository = selectshaperepository;
	}

	

	public clickHandler(PaintCanvasBase canvas, ShapeList list, SelectedShapeList selectedShape, CopyShapeList copyList,
			IApplicationState applicationState, repository shaperepository, repository selectshaperepository)
			 {
		super();
		this.canvas = canvas;
		this.list = list;
		this.selectedShape = selectedShape;
		this.copyList = copyList;
		this.applicationState = applicationState;
		this.shaperepository = shaperepository;
		this.selectshaperepository = selectshaperepository;
		
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
		
		
		if(applicationState.getActiveMouseMode().equals( MouseMode.DRAW)) {
		ShapeShadingType shade=applicationState.getActiveShapeShadingType();
		ShapeColor shapeColor=applicationState.getActivePrimaryColor();
		ShapeType shapetype=applicationState.getActiveShapeType();
		shapeProperties properties=new shapeProperties(point,shade,shapeColor,shapetype);
		Icommand C= new CreateShapeCommand(shaperepository, properties,applicationState);
		try {
			C.run();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}else if(applicationState.getActiveMouseMode().equals(MouseMode.SELECT)) {
			shaperepository.redraw();
			 Icommand C= new SelectShapeCommand(shaperepository,selectshaperepository, point);
			 
			
			 selectshaperepository.clear();
			 try {
				C.run();
				for(Ishape a:selectshaperepository.list()) {
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
				
				Icommand C1= new MoveCommand(selectedShape, list, dx, dy, shaperepository, selectshaperepository);
				try {
					C1.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		}
		
		
	}

	
	

