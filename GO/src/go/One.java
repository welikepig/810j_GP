package go;

import java.awt.Color;


public class One
{
	public int row;
	public int col;
    public int liberties;
    public Color c;
    public Group group;
    public One[] neighbor;
    public One(int row, int col,Color c){
    	this.row=row;
    	this.col=col;
    	liberties=calcuLiberty();
    	this.c=c;
    	group=null;
    	neighbor=new One[4];
    }
    
    public int calcuLiberty(){
		if((row==0&&col==0)||(row==18&&col==0)||
				(row==0&&col==18)||(row==18&&col==18)){
			liberties=2;
		}
		else if(row==0||col==0||row==18||col==18){
			liberties=3;
		}
		else
			liberties=4;
    	return liberties;
    }
    
  
}
