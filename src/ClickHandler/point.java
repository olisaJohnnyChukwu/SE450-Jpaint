package ClickHandler;

public class point {
	private int x1=0;
    private int x2=0;
    private int y1=0;
    private int y2=0;
    private int diffx=0;
    private int diffy=0;
    private int width;
    private int height;
    
    
    
    public point(){

    }

    void setX1(int num){
        this.x1=num;
        
    }
    void setX2(int num){
    	
        if(num<this.x1){
            int temp=this.x1;
            this.x1=num;
            this.x2=temp;
            this.width=getdiffx();
            
        }else{
            this.x2=num;
            this.width=getdiffx();
        }
    }
    
    void setY1(int num){
       
            this.y1=num;
           
        
    }
    void setY2(int num){
    	
        if(num<this.y1){
            int temp=this.y1;
            this.y1=num;
            this.y2=temp;
            this.height=getdiffy();
            
        }else{
            this.y2=num;
            this.height=getdiffy();
        }
        
    }
    int[] xrray() {
    	
    	int x[]= {x1,x1+width,x1};
		return x;
    	
    }
    int[] yrray() {
    	
    	int x[]= {y1,y1+height,y1+height};
		return x;
    	
    }
    
    public int getWidth() {
		return width;
	}

	
	public int getHeight() {
		return height;
	}



	public int getdiffx(){
        return this.x2-this.x1;
    }

    public int getdiffy(){
        return this.y2-this.y1;
    }

	public int getY1() {
		// TODO Auto-generated method stub
		return y1;
	}

	public int getX1() {
		// TODO Auto-generated method stub
		return x1;
	}
	public int getY2() {
		// TODO Auto-generated method stub
		return y2;
	}

	public int getX2() {
		// TODO Auto-generated method stub
		return x2;
	}

}
