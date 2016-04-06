import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class GoBoard extends JPanel implements MouseListener{
	private static final int MARGIN=30; 
	private static final int GRID_SPAN=40;
	private static final int ROWS=19; 
	private static final int COLS=19;  
	
	Point[] chessList=new Point[(ROWS+1)*(COLS+1)];  
	boolean isBlack=true;  
	boolean gameOver=false;
	int chessCount; 
	int xIndex,yIndex;
	
	public GoBoard(){  
	       addMouseListener(this);  
	       addMouseMotionListener(new MouseMotionListener(){  
	           public void mouseDragged(MouseEvent e){  
	                 
	           }  
	             
	           public void mouseMoved(MouseEvent e){  
	             int x1=(e.getX()-MARGIN+GRID_SPAN/2)/GRID_SPAN;  

	             int y1=(e.getY()-MARGIN+GRID_SPAN/2)/GRID_SPAN;  

	             if(x1<0||x1>ROWS||y1<0||y1>COLS||gameOver||findChess(x1,y1))  
	                 setCursor(new Cursor(Cursor.DEFAULT_CURSOR));  

	             else setCursor(new Cursor(Cursor.HAND_CURSOR));  
	               
	           }  
	       });  
	   }   
	
	
    public void paintComponent(Graphics g){  
	       super.paintComponent(g);  
	       for(int i=0;i<=ROWS;i++){ 
	              g.drawLine(MARGIN, MARGIN+i*GRID_SPAN, MARGIN+COLS*GRID_SPAN, MARGIN+i*GRID_SPAN);  
	       }  
	       for(int i=0;i<=COLS;i++){ 
	              g.drawLine(MARGIN+i*GRID_SPAN, MARGIN, MARGIN+i*GRID_SPAN, MARGIN+ROWS*GRID_SPAN);  
	       }  
	   	   setBackground(new Color(238,173,14));
	   	   
	       for(int i=0;i<chessCount;i++){  
	          
	           double xPos=chessList[i].getX()*GRID_SPAN+MARGIN;  
	           double yPos=chessList[i].getY()*GRID_SPAN+MARGIN;  
	           g.setColor(chessList[i].getColor());
	         
	           colortemp=chessList[i].getColor();  
	           if(colortemp==Color.black){  
	               RadialGradientPaint paint = new RadialGradientPaint(xPos-Point.DIAMETER/2+25, yPos-Point.DIAMETER/2+10, 20, new float[]{0f, 1f}  
	               , new Color[]{Color.WHITE, Color.BLACK});  
	               ((Graphics2D) g).setPaint(paint);  
	               ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
	               ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT);  
	  
	           }  
	           else if(colortemp==Color.white){  
	               RadialGradientPaint paint = new RadialGradientPaint(xPos-Point.DIAMETER/2+25, yPos-Point.DIAMETER/2+10, 70, new float[]{0f, 1f}  
	               , new Color[]{Color.WHITE, Color.BLACK});  
	               ((Graphics2D) g).setPaint(paint);  
	               ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  
	               ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT);  
	  
	           }  
	           
	           Ellipse2D e = new Ellipse2D.Float(xPos-Point.DIAMETER/2, yPos-Point.DIAMETER/2, 34, 35);  

	             
	           if(i==chessCount-1){  
	               g.setColor(Color.red);  
	               g.drawRect(xPos-Point.DIAMETER/2, yPos-Point.DIAMETER/2,  
	                           34, 35);  
	           }  
	       }
    }
    
    public void mousePressed(MouseEvent e){
        
    }
        

    private boolean findChess(int x,int y){  
        for(Point c:chessList){  
            if(c!=null&&c.getX()==x&&c.getY()==y)  
                return true;  
        }  
        return false;  
    }  
      
      
    private boolean isWin(){  
      
      }  
      
      
    private Point getChess(int xIndex,int yIndex,Color color){  
        for(Point p:chessList){  
            if(p!=null&&p.getX()==xIndex&&p.getY()==yIndex  
                    &&p.getColor()==color)  
                return p;  
        }  
        return null;  
    }  
      
      
    public void restartGame(){    
        for(int i=0;i<chessList.length;i++){  
            chessList[i]=null;  
        }  
        
        isBlack=true;  
        gameOver=false; 
        chessCount =0;   
        repaint();  
    }  
      
    public void goback(){  
        if(chessCount==0)  
            return ;  
        chessList[chessCount-1]=null;  
        chessCount--;  
        if(chessCount>0){  
            xIndex=chessList[chessCount-1].getX();  
            yIndex=chessList[chessCount-1].getY();  
        }  
        isBlack=!isBlack;  
        repaint();  
    }
    
}