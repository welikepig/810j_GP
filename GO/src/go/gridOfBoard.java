package go;
/*
 * This class to make all the logical function to implement all rules
 * UpdateGroup UpdateLiberties CheckLiberties IsSuiside Istaken ,Addstone
 * Data
 */
import java.awt.Color;
import java.util.ArrayList;

public class gridOfBoard {//Make logic function here
	int lastMove;
	private int groupNum;
	protected One[][] board;
	private static final int ROWS=19; 
	private static final int COLS=19; 
	
	public gridOfBoard(){
		board=new One[ROWS][COLS];
		lastMove=1;
	}

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
		}*/
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
		
	    //System.out.println(stone.getLiberties());
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
				//System.out.println("Create a new group");
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

	public boolean isTaken(int row, int col) {
		return board[row][col]!=null;
	}
	public void checkLiberties(One one) {
		//System.out.println(one.getRow()+" "+one.getCol()+":Group liberties: "+one.getGroup().getLiberties());
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
	public void clear(){
		 for(int i=0;i<ROWS;i++){ 
	    	    for(int j=0;j<COLS;j++){ 
	    	    	board[i][j]=null;
	    	    }
		 }
		 lastMove=1;
	}
}
