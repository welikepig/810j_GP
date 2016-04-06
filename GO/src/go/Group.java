package go;

import java.util.ArrayList;

public class Group {
	public ArrayList<One> groups;
	
	public Group() {
		groups = new ArrayList<>();
	}
	public int getLiberties() {
	    int total = 0;
	    for (One one : groups) {
	        total += one.liberties;
	    }
	    return total;
	}
	public void addStone(One one) {
	    one.group = this;
	    groups.add(one);
	}

	public void join(Group group) {
	    for (One one : group.groups) {
	        addStone(one);
	    }
	}
}
