package Shape;
import java.util.*;


import Command.repository;
import Stategy.*;

import model.ShapeType;
import view.interfaces.PaintCanvasBase;

public class shapeGroup implements Ishape {
	ArrayList<Ishape> group=new ArrayList<>();
	private  UUID uuid=UUID.randomUUID();
	private  String Id=uuid.toString();
	shapeProperties properties;
	
	
	public shapeGroup() {
		super();
		//this.group = group;
		boundary();
	}

	public shapeGroup(ArrayList<Ishape> clipboard) {
		// TODO Auto-generated constructor stub
		for(Ishape shape:clipboard) {
			group.add(shape);
		}
		System.out.println(group.size());
		boundary();
	}

	public ArrayList<Ishape> getGroup() {
		return group;
	}

	public void setGroup(ArrayList<Ishape> group) {
		this.group = group;
	}

	@Override
	public void Draw(PaintCanvasBase canvas) {
		// TODO Auto-generated method stub
		
		for(Ishape shape:group) {
			shape.Draw(canvas);
		}

	}
	@Override
	public ShapeType ShapeName() {
		// TODO Auto-generated method stub
		return ShapeType.RECTANGLE;
	}

	@Override
	public shapeProperties getProperties() {
		// TODO Auto-generated method stub
		return this.properties;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperties(shapeProperties properties) {
		// TODO Auto-generated method stub
		this.properties=properties;

	}
	
	public void addShape(Ishape shape) {
		group.add(shape);
		
	}
	
	public void removeShape(Ishape shape) {
		
		group.remove(shape);
	}
	public void boundary() {
		int boundary[]=new int[4];
		int sz=group.size();
		
		
		int x1[]=new int[sz];
		int x2[]=new int[sz];
		int[] y1=new int[sz];
		int[] y2=new int[sz];
		
		int i=0;
		for(Ishape shape:group) {
			x1[i]=shape.getProperties().getX();
			
			x2[i]=shape.getProperties().getX()+shape.getProperties().getWidth();
			
			y1[i]=shape.getProperties().getY();
			
			y2[i]=shape.getProperties().getY()+shape.getProperties().getHeight();
			
			i=i+1;
		}
		
		 int minx1 = getMinValue(x1);
		 int maxx2= getMaxValue(x2);
		 int miny1 = getMinValue(y1);
		 int maxy2= getMaxValue(y2);
		 
		 int array[]=new int[4];
		 array[0]=minx1;
		 array[1]=maxx2;
		 array[2]=miny1;
		 array[3]=maxy2;
		 
		
		 shapeProperties properties=new shapeProperties(minx1,miny1,maxx2-minx1,maxy2-miny1);
		 
		 
		 setProperties(properties);
		 
		
		 
		 
	}
	public int getMaxValue(int[] numbers){
		  int maxValue = numbers[0];
		  for(int i=1;i < numbers.length;i++){
		    if(numbers[i] > maxValue){
		      maxValue = numbers[i];
		    }
		  }
		  return maxValue;
		}
		public int getMinValue(int[] numbers){
		  int minValue = numbers[0];
		  for(int i=1;i<numbers.length;i++){
		    if(numbers[i] < minValue){
		      minValue = numbers[i];
		    }
		  }
		  return minValue;
		}

		public void negativedisplacement(int dx, int dy) {
			// TODO Auto-generated method stub
			for(Ishape shape:group) {
				shape.negativedisplacement(dx, dy);
				
			}
			boundary();
			
		}

		public void positivedisplacement(int dx, int dy) {
			// TODO Auto-generated method stub
			for(Ishape shape:group) {
				
				shape.positivedisplacement(dx, dy);
			}
			boundary();
		}

		@Override
		public Ishape copy(Ishape shape, int x) {
			// TODO Auto-generated method stub
			ArrayList<Ishape> list=new ArrayList<Ishape>();
			for(Ishape sh:group) {
				Ishape s=sh.copy(sh, x);
				list.add(s);
			}
			return new shapeGroup(list);
		}

		

		@Override
		public void ungroup(Ishape shape, repository shaperepository,ArrayList<Ishape> clipboard) {
			// TODO Auto-generated method stub
			for(Ishape sh:group) {
				shaperepository.addshape(sh);
			}
			
		if(!clipboard.contains(shape)) {
			clipboard.add(shape);}
		shaperepository.removeshape(shape);
		}

		@Override
		public void delete(Ishape shape, repository shaperepository) {
			// TODO Auto-generated method stub
			shaperepository.removeshape(shape);
			
		}

		@Override
		public void addtolist(Ishape shape, repository shaperepository) {
			// TODO Auto-generated method stub
			shaperepository.addshape(shape);
			
		}

		

	

}
