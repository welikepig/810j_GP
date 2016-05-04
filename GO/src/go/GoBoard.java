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


import javax.swing.*;

public class GoBoard extends JPanel{
	private static final int MARGIN=30;
	private static final int GRID_SPAN=30;
	private static final int RADIUS=13; 
	private static final int ROWS=19; 
	private static final int COLS=19; 
	private gridOfBoard GoB;
	private int mode;

	
	public void setMode(int n){
		mode=n;
	}
	
	public int getMode(){
		return mode;
	}
	public void AiFirstStep(){
		GoB.AiaddStone();	
	}
	
	public GoBoard(){
		GoB=new gridOfBoard();
		JLabel a = new JLabel();
		add(a,BorderLayout.NORTH);
		addMouseListener(
				new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						int row = Math.round((float) (e.getY() - GRID_SPAN)
			                    / GRID_SPAN);
			            int col = Math.round((float) (e.getX() - GRID_SPAN)
			                    /GRID_SPAN);

			            // DEBUG INFO
			           

			            if (row >= ROWS || col >= COLS || row < 0 || col < 0) {
			                return;
			            }
			            
			            if (GoB.isTaken(row, col)) {
			   
			            	a.setText("This place is Already taken!!");
			            	
			            	System.out.println("This place is Already taken!!");
			                return;
			            }
			       
			            int lastMove=GoB.lastMove;
			            GoB.addStone2(row, col);
			            paintComponent(getGraphics());	
			            if(Math.abs(mode)==1)
			            	GoB.AiaddStone();		
			           
			            //System.out.println(String.format("y: %d, x: %d", row, col))
					}
					public void mouseClicked(MouseEvent e) {
						
					}
				} );
	   	   
    }
	
	public gridOfBoard getBoard(){
		return GoB;
	}
	public void undo(){
		GoB.undo();
		if(Math.abs(mode)==1)
			GoB.undo();
		//repaint();
	}
	
	public void setBack(Graphics2D g2){	
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
	
    public void paintComponent(Graphics g){  
    	   super.paintComponent(g);  
	       Graphics2D g2 = (Graphics2D) g;
	    
	       setBack(g2);
	       for(int i=0;i<ROWS;i++){ 
	    	    for(int j=0;j<COLS;j++){ 
	    	    	if(GoB.board[i][j]==null){
	    	    		continue;
	    	    	}
	    	    		g2.setColor(GoB.board[i][j].getColor());
	    	    		g2.fillOval(j* GRID_SPAN  + (int)(Math.sqrt(2)*RADIUS) -2 ,
	    	    				 i * GRID_SPAN + (int)(Math.sqrt(2)*RADIUS) -2 , 2*RADIUS,2*RADIUS);
	    	    }
	       }	
    } 
}