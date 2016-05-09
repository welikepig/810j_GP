package go;
/*
 * This class is to make the group of stones
 * data member is an ArrayList of stones and the color of this group
 * Also remember the GroupNum in order to use it when check the liberties
 * Every same color stone linked directly should be in same group
 *@author: Zhiyuan Chen
 *@author: Yudi Dong
 */
import java.awt.Color;
import java.util.ArrayList;

public class Group {
//This class stands for a group contains the color groupNum and arraylist of stone
	private ArrayList<Stone> stones;
	private Color c;
	public int GroupNum;
	public Group(){

	}
	//We create set and get function for private data
	public int getGroupNum(){
		return GroupNum;
	}
	public Group(Stone stone){
	
		stones=new ArrayList<>();
		stones.add(stone);
	}
	public int size(){
		return getStones().size();
	}
	public void setGroupNum(int GroupNum){
		this.GroupNum=GroupNum;
	}
	
	
	public Stone get(int num){
		return getStones().get(num);
	}
	
	
	public int getLiberties() {
	    int total = 0;
	    for (Stone one : stones) {
	        total += one.getLiberties();
	    }
	    return total;
	}
	public void addStone(Stone one) {//Add a stone in this group
	    one.setGroup(this);
	    stones.add(one);
	    //System.out.println(getStones().size());
	}
	public void remove(Stone one){//Remove one stone is arraylist
		stones.remove(one);
	}
	public void mergeTwoGroup(Group g){
	//This function would set all stones' group in Group g to be current group
		for(int i=0;i<g.size();i++){
			addStone(g.get(i));
		}
	}
	
	public Color getColor(){
		return c;
	}
	
	public ArrayList<Stone> getStones() {
		return stones;
	}
	public void setStones(ArrayList<Stone> stones) {
		this.stones = stones;
	}
	public void clear() {
		stones=null;
	}
}
