package go;
/*
 * This class is make one single stone
 * It includes one stone's row, column ,liberties, group, color and function to get these data
 */
import java.awt.Color;


public class One
{
	private int getRow;
	private int col;
	private int Liberties;
	private Color c;
	private Group group;

	public One(int row, int col,Color c){
    	this.getRow=row;
    	this.col=col;
    	Liberties=calcuLiberty();
    	this.c=c;
    }
    
	public Group getGroup(){
		return group;
	}
    public int calcuLiberty(){
		if((getRow==0&&col==0)||(getRow==18&&col==0)||
				(getRow==0&&col==18)||(getRow==18&&col==18)){
			Liberties=2;
		}
		else if(getRow==0||col==0||getRow==18||col==18){
			Liberties=3;
		}
		else
			Liberties=4;
    	return Liberties;
    }
    
    public void setGroup(Group group) {
		this.group = group;
	}
    
    public int getLiberties(){
    	return Liberties;
    }
    
    public void setLiberties(int Liberties) {
		this.Liberties = Liberties;
		
		if (Liberties < 0)
			Liberties = 0;
	}
    
    
    public Color getColor(){
    	return c;
    }
    public int getRow(){
    	return getRow;
    }
    public int getCol(){
    	return col;
    }
}
