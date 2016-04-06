package go;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GoBoard extends JPanel{
	private static final int MARGIN=30; 
	private static final int GRID_SPAN=30;
	private static final int RADIUS=13; 
	private static final int ROWS=19; 
	private static final int COLS=19; 
	private int count;
	private gridOfBoard GoB;
	private gridOfBoard[] go;
	
	public GoBoard(){
		GoB=new gridOfBoard();
		go=new gridOfBoard[500];
	}
	
	public gridOfBoard getBoard(){
		return GoB;
	}
	public void undo(){
		GoB=go[count-1];
		repaint();
		System.out.println(count);
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
	    	    		g2.setColor(GoB.board[i][j].c);
	    	    		g2.fillOval(j* GRID_SPAN  + (int)(Math.sqrt(2)*RADIUS) -2 ,
	    	    				 i * GRID_SPAN + (int)(Math.sqrt(2)*RADIUS) -2 , 2*RADIUS,2*RADIUS);
	    	    }
	       }
	   	   
	   	addMouseListener(
				new MouseListener() {
					
					public void mousePressed(MouseEvent e) {
					
					}
					public void mouseReleased(MouseEvent e) {
					      
									
					}
					public void mouseEntered(MouseEvent e) {
						
					}

					
					public void mouseExited(MouseEvent e) {					
						
					}
					public void mouseClicked(MouseEvent e) {
						
							int row = Math.round((float) (e.getY() - GRID_SPAN)
				                    / GRID_SPAN);
				            int col = Math.round((float) (e.getX() - GRID_SPAN)
				                    /GRID_SPAN);

				            // DEBUG INFO
				            //System.out.println(String.format("y: %d, x: %d", row, col));

				            if (row >= ROWS || col >= COLS || row < 0 || col < 0) {
				                return;
				            }
				            
				            if (GoB.isToaken(row, col)) {
				                return;
				            }
				           
				            GoB.addStone(row, col);
				            count++;
				            go[count]=GoB;
				            repaint();
				           
  
					}
				} );
	   	   
    }
    
}