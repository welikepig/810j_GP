package go;
/*
 * This class is make one single stone
 * data member: one stone's row, column ,liberties, group, color 
 * And some functions to get these data
 *@author: Zhiyuan Chen
 *@author: Yudi Dong
 */
import java.awt.Color;


public class Stone
{
	private int row;
	private int col;
	private int Liberties;
	private int number;
	private Color c;
	private Group group;

	public Stone(int row, int col,Color c){
    	this.row=row;
    	this.col=col;
    	Liberties=calcuLiberty();
    	this.c=c;
    }
    
	public Group getGroup(){
		return group;
	}
	public int getNumber(){
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
    public int calcuLiberty(){
		if((row==0&&col==0)||(row==18&&col==0)||
				(row==0&&col==18)||(row==18&&col==18)){
			Liberties=2;
		}
		else if(row==0||col==0||row==18||col==18){
			Liberties=3;
		}
		else
			Liberties=4;
    	return Liberties;
    }
    
    public void setGroup(Group group) {
		this.group = group;
	}
    
    public static Stone copy(Stone stone){
    	Stone temp=new Stone(stone.row,stone.col,stone.c);
    	return temp;
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
    	return row;
    }
    public int getCol(){
    	return col;
    }
}
