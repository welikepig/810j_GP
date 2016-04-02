import java.awt.*;
import javax.swing.*;

public class GoBoard extends JPanel{
	private static final int MARGIN=30; 
	private static final int GRID_SPAN=40;
	private static final int ROWS=19; 
	private static final int COLS=19;  
	
    public void paintComponent(Graphics g){  
	       super.paintComponent(g);  
	       for(int i=0;i<=ROWS;i++){ 
	              g.drawLine(MARGIN, MARGIN+i*GRID_SPAN, MARGIN+COLS*GRID_SPAN, MARGIN+i*GRID_SPAN);  
	       }  
	       for(int i=0;i<=COLS;i++){ 
	              g.drawLine(MARGIN+i*GRID_SPAN, MARGIN, MARGIN+i*GRID_SPAN, MARGIN+ROWS*GRID_SPAN);  
	       }  
	   	   setBackground(new Color(238,173,14));
    }
    
}