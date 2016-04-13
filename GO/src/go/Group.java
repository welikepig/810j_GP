package go;
/*
 * This class is to make the group of stones
 * Every same color stone linked directly should be in same group
 */
import java.awt.Color;
import java.util.ArrayList;

public class Group {
	private ArrayList<One> stones=new ArrayList<>();
	private Color c;
	
	public Group(){
		
	}
	
	public Group(One stone) {
		stones.add(stone);
	}
	public int size(){
		return getStones().size();
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
			this.addStone(g.get(i));
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
