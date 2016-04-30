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
	private ArrayList<One> stones;
	private Color c;
	public int GroupNum;
	public Group(){

	}
	public int getGroupNum(){
		return GroupNum;
	}
	public Group(One stone){
	
		stones=new ArrayList<>();
		stones.add(stone);
	}
	public int size(){
		return getStones().size();
	}
	public void setGroupNum(int GroupNum){
		this.GroupNum=GroupNum;
	}
	
	
	public One get(int num){
		return getStones().get(num);
	}
	
	
	public int getLiberties() {
	    int total = 0;
	    for (One one : stones) {
	        total += one.getLiberties();
	    }
	    return total;
	}
	public void addStone(One one) {
	    one.setGroup(this);
	    stones.add(one);
	    //System.out.println(getStones().size());
	}
	public void remove(One one){
		stones.remove(one);
	}
	public void mergeTwoGroup(Group g){
		for(int i=0;i<g.size();i++){
			addStone(g.get(i));
		}
	}
	
	public Color getColor(){
		return c;
	}
	
	public ArrayList<One> getStones() {
		return stones;
	}
	public void setStones(ArrayList<One> stones) {
		this.stones = stones;
	}
	public void clear() {
		stones=null;
	}
}
