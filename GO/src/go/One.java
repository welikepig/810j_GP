package go;
/*
 * This class is make one single stone
 * It includes one stone's row, column ,liberties, group, color and function to get these data
 *@author: Zhiyuan Chen
 *@author: Yudi Dong
 */
import java.awt.Color;


public class One
{
	private int row;
	private int col;
	private int Liberties;
	private int number;
	private Color c;
	private Group group;

	public One(int row, int col,Color c){
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
    
    public static One copy(One stone){
    	One temp=new One(stone.row,stone.col,stone.c);
    	temp.Liberties=stone.Liberties;
    	//System.out.println("L is"+temp.Liberties);
    	temp.group=stone.group;
    	//System.out.println("G L SIZE IS"+temp.group.size());
    	//System.out.println("GroupN is "+temp.group.getN());
    	//System.out.println("G L IS"+temp.group.getLiberties());
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
