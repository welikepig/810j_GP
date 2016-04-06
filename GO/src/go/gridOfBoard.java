package go;

import java.awt.Color;

public class gridOfBoard {
	private int lastMove;
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
		//0 up; 1;down; 2 left; 3 right;
		if (row > 0) {
			stone.neighbor[0] = board[row - 1][col];
	    }
	    if (row < ROWS - 1) {
	    	stone.neighbor[1] = board[row + 1][col];
	    }
	    if (col > 0) {
	    	stone.neighbor[2] = board[row][col - 1];
	    }
	    if (col < COLS - 1) {
	    	stone.neighbor[3] = board[row][col + 1];
	    }
		lastMove*=-1;
		System.out.println(lastMove);
		Group gp=new Group();
		for(int i=0;i<stone.neighbor.length;i++){
			if(stone.neighbor[i]==null){
				continue;
			}
			else{
				stone.liberties--;
				stone.neighbor[i].liberties--;
			}
			if (stone.neighbor[i].c != stone.c) {
				checkLiberties(stone.neighbor[i]);
	            continue;
	        }

	        if (stone.neighbor[i].group != null) {
	            gp.join(stone.neighbor[i].group);
	        }
	    }
		if(isSuiside(stone)){
			gp.addStone(stone);
		}
		else{
			board[row][col]=null;
			return;
		}
	    System.out.println(stone.liberties);
		
	}
	private boolean isSuiside(One stone) {
		
		return stone.liberties!=0;
	}

	public boolean isToaken(int row, int col) {
		return board[row][col]!=null;
	}
	public void checkLiberties(One one) {
	    if (one.group.getLiberties() == 0) {
	        for (One stone : one.group.groups) {
	            stone.group = null;
	            if (stone.row > 0) {
	            	if(board[stone.row - 1][stone.col]!=null)
	            		board[stone.row - 1][stone.col].liberties++;
	    	    }
	    	    if (stone.row < ROWS - 1) {
	    	    	if(board[stone.row + 1][stone.col]!=null)
	    	    		board[stone.row + 1][stone.col].liberties++;
	    	    }
	    	    if (stone.col> 0) {
	    	    	if(board[stone.row ][stone.col-1]!=null)
	    	    	 board[stone.row ][stone.col-1].liberties++;
	    	    }
	    	    if (stone.col < COLS - 1) {
	    	    	if(board[stone.row ][stone.col+1]!=null)
	    	    		board[stone.row ][stone.col+1].liberties++;
	    	    }
	            board[stone.row][stone.col] = null;
	        }
	    }
	}
	public void clear(){
		 for(int i=0;i<ROWS;i++){ 
	    	    for(int j=0;j<COLS;j++){ 
	    	    	board[i][j]=null;
	    	    }
		 }
	}
}
