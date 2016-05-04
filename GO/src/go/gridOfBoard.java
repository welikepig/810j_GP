package go;

/*
 * This class to make all the logical function to implement all rules
 * Data: Including the lastMove, board, rows,cols and ArrayList of the board and groups, also a number of current piece on board 
 * Four main function:updateGroup,updateLiberties,checkLiberties,addStone
 * Supplementary function: isSuiside, isTaken, clear, undo, snapShot, isEqual
 *@author: Zhiyuan Chen
 *@author: Yudi Dong
 */
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;
<<<<<<< HEAD
import javax.swing.*;

=======
>>>>>>> origin/master


public class gridOfBoard {//Make logic function here
	int lastMove;
	protected One[][] board;
	private static final int ROWS=19; 
	private static final int COLS=19; 
	private ArrayList<One[][]> history = new ArrayList<>();
	private ArrayList<Group> groups = new ArrayList<>();
	private int current;
	public static Random ran=new Random();
<<<<<<< HEAD
	public Font f = new Font("Helvetica", Font.BOLD, 24);

	    
=======
		
>>>>>>> origin/master
	public gridOfBoard(){
		board=new One[ROWS][COLS];
		lastMove=1;
		current=0;
		history.add(snapShot(board));
		System.out.println("new grid");
	}
	
	public void clear(){
		 for(int i=0;i<ROWS;i++){ 
	    	    for(int j=0;j<COLS;j++){ 
	    	    	board[i][j]=null;
	    	    }
		 }
		 history.clear();
		 history.add(snapShot(board));
		 groups.clear();
		 current=0;
		 lastMove=1;
	}

	public boolean isTaken(int row, int col) {
		return board[row][col]!=null;
	}
	
	public boolean isEqual(One[][] board){
		for(int i=0;i<ROWS;i++){ 
    	    for(int j=0;j<COLS;j++){
    	    	if(this.board[i][j]==null){
    	    		if(board[i][j]==null){
    	    			continue;
    	    		}
    	    		else{
    	    			//System.out.println("History is not null, now is null,i:"+i+" j: "+j);
    	    			return false;
    	    		}
    	    	}
    	    	else if(board[i][j]==null){
    	    		//System.out.println("History is null, now is not null,i:"+i+" j: "+j);
    	    		return false;
    	    	}
    	    	else if(this.board[i][j].getColor()!=board[i][j].getColor()){
    	    		//System.out.println("History is one color, now is another");
    	    		return false;
    	    	}
    	    }
		}
		return true;
	}
	
	public boolean checkLiberties2(One stone){
		//After adding a stone on the board, we need recalculate all group's liberty
		//if one group's liberties is 0, move all stones in this group out of board
		boolean dele= false;
		int GPNum = 0;
		for (int i = 0; i < groups.size(); i++) {
			boolean dead = true;
			//System.out.println("Group's num"+groups.get(i).getGroupNum());
			//System.out.println("Stone's Group's num"+board[stone.getRow()][stone.getCol()].getGroup().getGroupNum());
			if(groups.get(i).getGroupNum()==board[stone.getRow()][stone.getCol()].getGroup().getGroupNum()){
				GPNum=i;
				//System.out.println("My gp num is"+GPNum);
				continue;
			}
			for (int j = 0; j < groups.get(i).size(); j++) {
				if (groups.get(i).get(j).getLiberties() != 0) {
					dead = false;
					break;
				}
			}
			if (dead) {
				for (int j = 0; j < groups.get(i).size(); j++) {
					board[groups.get(i).get(j).getRow()][groups.get(i).get(j).getCol()] = null;
				}
				dele= true;
			}
		}
		if(dele==false){
			//System.out.println("No dele, check self");
			//System.out.println("****");
			for (int j = 0; j < groups.get(GPNum).size(); j++) {
				if (groups.get(GPNum).get(j).getLiberties() != 0) {
					return false;
				}
			}
			for (int j = 0; j < groups.get(GPNum).size(); j++) {
				board[groups.get(GPNum).get(j).getRow()][groups.get(GPNum).get(j).getCol()] = null;
			}
<<<<<<< HEAD
			JFrame a = new JFrame();
			a.setTitle("Warning");   
			JLabel b = new JLabel();
			a.add(b,BoxLayout.X_AXIS);
			b.setText("Suiside, you cannot do that");
			b.setFont(f);
			a.setSize(400,100);
			a.setResizable(false);
			a.setVisible(true);
			a.setLocationRelativeTo(null);
=======
>>>>>>> origin/master
			System.out.println("Suiside, you cannot do that");
			return true;
		}
		return false;
	}
	
	private void updateGroups2() {
		//Here we need find and set all the groups then we can check the groups' liberties when we do the checkLiberties function
		int GPnum=0;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if(board[i][j]==null){
					continue;
				}
				if(board[i][j].getGroup()==null){
					Group gp=new Group(board[i][j]);
					GPnum++;
					gp.setGroupNum(GPnum);
					board[i][j].setGroup(gp);
					groups.add(gp);
					
				}
				int i1;
				int j1;
				for ( i1 = -1; i1 <=1; i1++) {
					for ( j1 = -1; j1 <=1; j1++) {
						if(Math.abs(i1)!=Math.abs(j1)){
							if(i+i1<0||i+i1>18||j+j1<0||j+j1>18){
								continue;
							}
							if(board[i+i1][j+j1]==null){
								continue;
							}
						
							if (board[i][j].getColor() != board[i+i1][j+j1].getColor()){
								//System.out.println("different color");
								continue;
							}
							if(board[i+i1][j+j1].getGroup()==null){
								board[i][j].getGroup().addStone(board[i+i1][j+j1]);
							}
							if (board[i][j].getGroup() != board[i+i1][j+j1].getGroup()) {
								//System.out.println("mergeTwo");
								groups.remove(board[i+i1][j+j1].getGroup());
								board[i][j].getGroup().mergeTwoGroup(board[i+i1][j+j1].getGroup());
							}	
						
						}
					}
				}
			}
		}
	}

	public void updateLiberties2() {
		//Before we do the checkLiberties function, we need first update all single piece's liberties
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if(board[i][j]==null){
					continue;
				}
				board[i][j].setLiberties(board[i][j].calcuLiberty());
				One[] neighbors=new One[4];
				if (i> 0) {//0 up; 1;down; 2 left; 3 right;
			        neighbors[0] = board[i- 1][j];
			    }
			    if (i< ROWS - 1) {
			    	neighbors[1] = board[i +1][j];
			    }
			    if (j > 0) {
			    	neighbors[2] = board[i][j-1];
			    }
			    if (j < COLS - 1) {
			    	neighbors[3] = board[i][j+1];
			    }
				for(int k=0;k<4;k++){
					if (neighbors[k] == null) {
			            continue;
			        }
					board[i][j].setLiberties(board[i][j].getLiberties()-1);
				}
				//System.out.println("Row:"+i+"Cols:"+j+"  "+board[i][j].getLiberties());
				//System.out.println("****");
			}
		}

	}
	public void addStone2(int row, int col) {
		Color c;
		if(lastMove==1){
			c= Color.BLACK;
		}
		else
			c=Color.WHITE;
		One stone=new One(row,col,c);
		stone.setNumber(current);
		board[row][col]=stone;
		board=snapShot(board);
		groups.clear();
		current++;
		updateGroups2();
		updateLiberties2();
		boolean isSuiside=checkLiberties2(stone);
		history.add(snapShot(board));
		//System.out.println("Group size:"+groups.size());
	   // System.out.println("current is:"+current+"size is:"+history.size());
		lastMove*=-1;
		if(history.size()>2){
			if(isEqual(history.get(history.size()-3))){
				System.out.println("Ko rule, cannot place there");
				undo();
			}
		}
		if(isSuiside){
			undo();
		}
<<<<<<< HEAD
	}
	
	public void AiaddStone(){
		boolean take=true;
		int airow=0;
		int aicol=0;
		while(take){
			airow=ran.nextInt(19);
			aicol=ran.nextInt(19);
			if(isTaken(airow,aicol)){
				continue;
			}
			else
				take=false;
		}
		//System.out.println("ai, row:"+airow+"ai,col:"+aicol);
		try {
	        Thread.sleep(1000);
		} catch (InterruptedException e) {
	        e.printStackTrace();
		}
		Color c;
		if(lastMove==1){
			c= Color.BLACK;
		}
		else
			c=Color.WHITE;
		One aistone=new One(airow,aicol,c);
		aistone.setNumber(current);
		board[airow][aicol]=aistone;
		board=snapShot(board);
		groups.clear();
		current++;
		updateGroups2();
		updateLiberties2();
		boolean isSuisuide=checkLiberties2(aistone);
		history.add(snapShot(board));
		lastMove*=-1;
		if(history.size()>2){
			if(isEqual(history.get(history.size()-3))){
				JFrame a = new JFrame();
				a.setTitle("Warning");   
				JLabel b = new JLabel();
				a.add(b,BoxLayout.X_AXIS);
				b.setText("Suiside, you cannot do that");
				b.setFont(f);
				a.setSize(400,100);
				a.setResizable(false);
				a.setVisible(true);
				a.setLocationRelativeTo(null);
				System.out.println("Ko rule, cannot place there");
				undo();
				AiaddStone();
			}
		}
		if(isSuisuide){
			undo();
			AiaddStone();
		}
	}
	
=======
	}
	
	public void AiaddStone(){
		boolean take=true;
		int airow=0;
		int aicol=0;
		while(take){
			airow=ran.nextInt(19);
			aicol=ran.nextInt(19);
			if(isTaken(airow,aicol)){
				continue;
			}
			else
				take=false;
		}
		//System.out.println("ai, row:"+airow+"ai,col:"+aicol);
		try {
	        Thread.sleep(1000);
		} catch (InterruptedException e) {
	        e.printStackTrace();
		}
		Color c;
		if(lastMove==1){
			c= Color.BLACK;
		}
		else
			c=Color.WHITE;
		One aistone=new One(airow,aicol,c);
		aistone.setNumber(current);
		board[airow][aicol]=aistone;
		board=snapShot(board);
		groups.clear();
		current++;
		updateGroups2();
		updateLiberties2();
		boolean isSuisuide=checkLiberties2(aistone);
		history.add(snapShot(board));
		lastMove*=-1;
		if(history.size()>2){
			if(isEqual(history.get(history.size()-3))){
				System.out.println("Ko rule, cannot place there");
				undo();
				AiaddStone();
			}
		}
		if(isSuisuide){
			undo();
			AiaddStone();
		}
	}
	
>>>>>>> origin/master
	public void undo(){
		if(current<1){
			return;
		}
		board = snapShot(history.get(history.size()-2));
		history.remove(history.size()-1);
		lastMove*=-1;
		current--;
		//System.out.println("current is:"+current+"size is:"+history.size());
	}

	private One[][] snapShot(One[][] stones) { //Only copy the stone's color
		
		One[][] temp = new One[19][19];
		
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if(stones[i][j]==null){
					temp[i][j]=null;
				}
				else{
					temp[i][j]=One.copy(stones[i][j]);
					temp[i][j].setGroup(null);
				}
			}
		}
		return temp;
	}
}	

/**	 This is the first method I used, but cannot fulfill the undo function
*	So I totally used another method to do it.
	public void addStone(int row, int col) {
		
		Color c;
		if(lastMove==1){
			c= Color.BLACK;
		}
		else
			c=Color.WHITE;
		One stone=new One(row,col,c);
		board[row][col]=stone;
		Group gp=updateGroups(stone);
		//System.out.println(gp.size());
		/**At first I want to use another suiside, but it's complicate, I'll try later
		 * if(gp==null){
			System.out.println("Suiside!! U cannot do it");
			board[row][col]=null;
			return;
		}
		stone.setGroup(gp);
		stone = updateLiberties(stone);
		
		if(isSuiside(stone)){
			if (stone.getRow() > 0) {//0 up; 1;down; 2 left; 3 right;
				board[stone.getRow() - 1][stone.getCol()].setLiberties(
	    				board[stone.getRow() - 1][stone.getCol()].getLiberties()+1);
		    }
		    if (stone.getRow() < ROWS - 1) {
		    	board[stone.getRow() +1][stone.getCol() ].setLiberties(
	    				board[stone.getRow() +1 ][stone.getCol()].getLiberties()+1);
		    }
		    if (stone.getCol() > 0) {
		    	board[stone.getRow()][stone.getCol() -1].setLiberties(
	    				board[stone.getRow() ][stone.getCol()-1].getLiberties()+1);
		    }
		    if (stone.getCol() < COLS - 1) {
		    	board[stone.getRow()][stone.getCol() +1].setLiberties(
	    				board[stone.getRow() ][stone.getCol()+1].getLiberties()+1);
		    }
			board[row][col]=null;
			return;
		}	
		current++;
		history.add(snapShot(board));
		historyPiece.add(row+","+col);
	    System.out.println("current is:"+current+"size is:"+history.size());
		lastMove*=-1;
		
	}
	
	public Group updateGroups(One stone){
		One[] neighbors=new One[4];
		if (stone.getRow() > 0) {//0 up; 1;down; 2 left; 3 right;
	        neighbors[0] = board[stone.getRow() - 1][stone.getCol()];
	    }
	    if (stone.getRow() < ROWS - 1) {
	    	neighbors[1] = board[stone.getRow() +1][stone.getCol()];
	    }
	    if (stone.getCol() > 0) {
	    	neighbors[2] = board[stone.getRow()][stone.getCol() -1];
	    }
	    if (stone.getCol() < COLS - 1) {
	    	neighbors[3] = board[stone.getRow()][stone.getCol()+1];
	    }
	    int count=0;
		for(int i=0;i<4;i++){
			if (neighbors[i] == null||(neighbors[i].getColor()!=stone.getColor())) {
				//System.out.println("null or different color");
				count++;
	            continue;
	        }
			switch(i){
			case 0:	
				if(stone.getGroup()==null){
					board[stone.getRow()-1][stone.getCol() ].getGroup().addStone(stone);
					stone.setGroup(board[stone.getRow()-1][stone.getCol() ].getGroup());
				}	
				else if(stone.getGroup()!=board[stone.getRow() - 1][stone.getCol()].getGroup()){
						stone.getGroup().mergeTwoGroup(board[stone.getRow() - 1][stone.getCol()].getGroup());
				}
				break;
			case 1:
				if(stone.getGroup()==null){
					board[stone.getRow()+1][stone.getCol()].getGroup().addStone(stone);
					stone.setGroup(board[stone.getRow()+1][stone.getCol()].getGroup());
				}
				else if(stone.getGroup()!=board[stone.getRow() + 1][stone.getCol()].getGroup()){
						stone.getGroup().mergeTwoGroup(board[stone.getRow() + 1][stone.getCol()].getGroup());
				}
				break;
			case 2:
				if(stone.getGroup()==null){
					board[stone.getRow()][stone.getCol() -1].getGroup().addStone(stone);
					stone.setGroup(board[stone.getRow()][stone.getCol() -1].getGroup());
				}
				else if(stone.getGroup()!=board[stone.getRow()][stone.getCol() -1].getGroup()){
						stone.getGroup().mergeTwoGroup(board[stone.getRow()][stone.getCol() -1].getGroup());	
				}	
				break;
			case 3:
				if(stone.getGroup()==null){
					board[stone.getRow()][stone.getCol() +1].getGroup().addStone(stone);
					stone.setGroup(board[stone.getRow()][stone.getCol() +1].getGroup());
				}
				else if(stone.getGroup()!=board[stone.getRow()][stone.getCol()+1].getGroup()){
					stone.getGroup().mergeTwoGroup(board[stone.getRow()][stone.getCol()+1].getGroup());
				}
				break;
			}
		}
		if(count==4){
				Group gp=new Group(stone);
				stone.setGroup(gp);
				System.out.println("Create a new group");
			}		
		return stone.getGroup();
	}
	

	public One updateLiberties(One stone) {
		One[] neighbors=new One[4];
		if (stone.getRow() > 0) {//0 up; 1;down; 2 left; 3 right;
	        neighbors[0] = board[stone.getRow() - 1][stone.getCol()];
	    }
	    if (stone.getRow() < ROWS - 1) {
	    	neighbors[1] = board[stone.getRow() +1][stone.getCol()];
	    }
	    if (stone.getCol() > 0) {
	    	neighbors[2] = board[stone.getRow()][stone.getCol() -1];
	    }
	    if (stone.getCol() < COLS - 1) {
	    	neighbors[3] = board[stone.getRow()][stone.getCol()+1];
	    }
		for(int i=0;i<4;i++){
			if (neighbors[i] == null) {
	            continue;
	        }
			stone.setLiberties(stone.getLiberties()-1);
			switch(i){
			case 0:
				board[stone.getRow() - 1][stone.getCol()].setLiberties(
        				board[stone.getRow() - 1][stone.getCol()].getLiberties()-1);
				break;
			case 1:
				board[stone.getRow() + 1][stone.getCol()].setLiberties(
        				board[stone.getRow() + 1][stone.getCol()].getLiberties()-1);
				break;
			case 2:
				board[stone.getRow()][stone.getCol() -1].setLiberties(
        				board[stone.getRow() ][stone.getCol()-1].getLiberties()-1);
				break;
			case 3:
				board[stone.getRow()][stone.getCol()+1].setLiberties(
        				board[stone.getRow()][stone.getCol()+1].getLiberties()-1);
				break;
			}
			
			checkLiberties(neighbors[i]);
			//System.out.println("Group liberties: "+neighbors[i].getGroup().getLiberties());
			//System.out.println("check liberties");
		}checkLiberties(stone);
		//System.out.println("Stone liberties:"+stone.getLiberties());
		//System.out.println("Group liberties: "+stone.getGroup().getLiberties());
		return stone;
	}

	public void checkLiberties(One one) {
		System.out.println(one.getRow()+" "+one.getCol()+":Group liberties: "+one.getGroup().getLiberties());
	    if (one.getGroup().getLiberties() == 0) {
	    	//System.out.println("Group liberty is 0");
	    	Group groupFinal=one.getGroup();
	        for (One stone : groupFinal.getStones()) {
	          
	            if (stone.getRow() > 0) {
	            	if(board[stone.getRow() - 1][stone.getCol()]!=null)
	            		board[stone.getRow() - 1][stone.getCol()].setLiberties(
	            				board[stone.getRow() - 1][stone.getCol()].getLiberties()+1);
	    	    }
	    	    if (stone.getRow() < ROWS - 1) {
	    	    	if(board[stone.getRow() + 1][stone.getCol()]!=null)
	    	    		board[stone.getRow() + 1][stone.getCol()].setLiberties(
	    	    				board[stone.getRow() + 1][stone.getCol()].getLiberties()+1);
	    	    }
	    	    if (stone.getCol()> 0) {
	    	    	if(board[stone.getRow() ][stone.getCol()-1]!=null)
	    	    	 board[stone.getRow() ][stone.getCol()-1].setLiberties(
	    	    			 board[stone.getRow() ][stone.getCol()-1].getLiberties()+1);
	    	    }
	    	    if (stone.getCol() < COLS - 1) {
	    	    	if(board[stone.getRow() ][stone.getCol()+1]!=null)
	    	    		board[stone.getRow() ][stone.getCol()+1].setLiberties(
	    	    				board[stone.getRow() ][stone.getCol()+1].getLiberties()+1);
	    	    }
	            board[stone.getRow()][stone.getCol()] = null;   
	        }
	    }
	}
	
	
	private boolean isSuiside(One stone) {
		One[] neighbors=new One[4];
		if (stone.getRow() > 0) {
	        neighbors[0] = board[stone.getRow() - 1][stone.getCol()];
	    }
	    if (stone.getRow() < ROWS - 1) {
	    	neighbors[1] = board[stone.getRow() +1][stone.getCol()];
	    }
	    if (stone.getCol() > 0) {
	    	neighbors[2] = board[stone.getRow()][stone.getCol() -1];
	    }
	    if (stone.getCol() < COLS - 1) {
	    	neighbors[3] = board[stone.getRow()][stone.getCol()+1];
	    }
	    if(stone.getLiberties()==0){
	    	//System.out.println("It's a suiside, u cannot do that");
			for(One neighbor:neighbors){
				if(neighbor==null){
					continue;
				}
				if(neighbor.getColor()==stone.getColor()){
					return false;
				}
			}
			return true;
	    }
	   return false;
	    
	}
	
}*/