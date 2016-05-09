package go;
/*
 * This class is to build a JPanel to show the background of a go board
 * Process the mouse event to add stone
 * Paint the board whenever a new stone is added
 *@author: Zhiyuan Chen
 *@author: Yudi Dong
 *
 */
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

import javax.swing.*;

public class GoBoard extends JPanel{
//This class add the mouseListener and paint the graph(backgroud and stone)
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private static final int MARGIN=30;
	private static final int GRID_SPAN=30;
	private static final int RADIUS=13; 
	private static final int ROWS=19; 
	private static final int COLS=19; 
	private static JLabel turn;
	private BoardLogic BLogic;
	private int mode;

	
	public void setMode(int n){//set the play mode
		mode=n;
	}
	
	public int getMode(){
		return mode;
	}
	public void AiFirstStep(){//Let AI move first
		BLogic.AiaddStone();	
	}
	public void pass(){//Change the lastMove in Boardlogic
		BLogic.lastMove*=-1;
		if(Math.abs(mode)==1)
        	BLogic.AiaddStone();
	}
	
	public GoBoard(){//Constructor create the BoardLogic and add mouseListener
		BLogic=new BoardLogic();
		turn =new JLabel();
		add(turn,BorderLayout.NORTH);
		addMouseListener(
				new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {//Find the row and col, add a stone when mouse relase
						int row = Math.round((float) (e.getY() - GRID_SPAN)
			                    / GRID_SPAN);
			            int col = Math.round((float) (e.getX() - GRID_SPAN)
			                    /GRID_SPAN);

			            if (row >= ROWS || col >= COLS || row < 0 || col < 0) {
			                return;
			            }
			            
			            if (BLogic.isTaken(row, col)) {//Check if the place is already taken
			   
			            	StartFrame.display.setText("This place is Already taken!!");
			            	System.out.println("This place is Already taken!!");
			                return;
			            }
			     
			            BLogic.addStone2(row, col);
			            paintComponent(getGraphics());	
			            if(Math.abs(mode)==1)
			            	BLogic.AiaddStone();
			            //System.out.println(String.format("y: %d, x: %d", row, col))
					}
					public void mouseClicked(MouseEvent e) {
						
					}
				} );
	   	   
    }
	
	public void clear(){//Call clear in Boradlogic
		BLogic.clear();
	}
	public void undo(){//Call undo in Boradlogic
		BLogic.undo();
		if(Math.abs(mode)==1)
			BLogic.undo();
		//repaint();
	}
	public void save() throws FileNotFoundException{//Call save in Boradlogic
		BLogic.save();
	}
	public void load() throws FileNotFoundException{//Call load in Boradlogic
		BLogic.load();
		paintComponent(getGraphics());
	}
	
	public void setBack(Graphics2D g2){	//Set the backgroud of a Go board
		setBackground(Color.WHITE);
			for(int i=0;i<ROWS;i++){ 
	            g2.drawLine(MARGIN, MARGIN+i*GRID_SPAN, MARGIN+(COLS-1)*GRID_SPAN, MARGIN+i*GRID_SPAN);
	            if(i==3||i==9||i==15){
	          	  g2.setColor(Color.BLACK);
	          	  g2.fillOval(MARGIN+i*GRID_SPAN-5, MARGIN+3*GRID_SPAN-5, 10,10);
	          	  g2.fillOval(MARGIN+i*GRID_SPAN-5, MARGIN+9*GRID_SPAN-5, 10,10);
	          	  g2.fillOval(MARGIN+i*GRID_SPAN-5, MARGIN+15*GRID_SPAN-5, 10,10);
	            }
	     }  
	     for(int i=0;i<COLS;i++){ 
	            g2.drawLine(MARGIN+i*GRID_SPAN, MARGIN, MARGIN+i*GRID_SPAN, MARGIN+(ROWS-1)*GRID_SPAN);  
	     }  
	     
	 	   setBackground(new Color(238,173,14));
		
	}
	
    public void paintComponent(Graphics g){ //Paint the background and the stone on JPanel
    	   super.paintComponent(g);  
	       Graphics2D g2 = (Graphics2D) g;
	       setBack(g2);
	       
	       if(BLogic.lastMove==1){
	    	   turn.setText("BLACK TURN");
	       }
	       else if(BLogic.lastMove==-1){
	    	   turn.setText("WHITE TURN");
	       }
	       for(int i=0;i<ROWS;i++){ 
	    	    for(int j=0;j<COLS;j++){ 
	    	    	if(BLogic.board[i][j]==null){
	    	    		continue;
	    	    	}
	    	    		g2.setColor(BLogic.board[i][j].getColor());
	    	    		g2.fillOval(j* GRID_SPAN  + (int)(Math.sqrt(2)*RADIUS) -2 ,
	    	    				 i * GRID_SPAN + (int)(Math.sqrt(2)*RADIUS) -2 , 2*RADIUS,2*RADIUS);
	    	    }
	       }	
    } 
}