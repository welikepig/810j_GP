import java.awt.*;  
import javax.swing.*;
import java.awt.event.*;


public class StartFrame extends JFrame {  
  private GoBoard goBoard;  
  private JPanel toolbar;  
  private JButton startButton,backButton,exitButton;  
    
  private JMenuBar menuBar;  
  private JMenu sysMenu,startMenu1,startMenu2;  
  private JMenuItem item1,item2,item3,item4;  

  public StartFrame(){  
      setTitle("GO/WEIQI");
      goBoard=new GoBoard();    
	  Container contentPane=getContentPane();
	  contentPane.add(goBoard);
	  
      menuBar =new JMenuBar();
      menuBar.setBackground(new Color(88,161,176));
      sysMenu=new JMenu("Menu");
   
      
      startMenu1 = new JMenu("Play with AI");
      startMenu2 = new JMenu("Two people Play");
      item1 = new JMenuItem("Start with Black");
      item2 = new JMenuItem("start with White");
      item3 = new JMenuItem("Start with Black");
      item4 = new JMenuItem("start with White");
      startMenu1.add(item1);
      startMenu1.add(item2);
      startMenu2.add(item3);
      startMenu2.add(item4);

      sysMenu.add(startMenu1); 
      sysMenu.add(startMenu2);
      
      
      menuBar.add(sysMenu); 
      setJMenuBar(menuBar); 
        
      toolbar=new JPanel();
      toolbar.setBackground(new Color(88,161,176));
      startButton=new JButton("RESTART");
      exitButton=new JButton("QUIT");  
      backButton=new JButton("UNDO");  

      toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));  
      toolbar.add(startButton);  
      toolbar.add(exitButton);  
      toolbar.add(backButton);  
      
      contentPane.add(toolbar,BorderLayout.SOUTH);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      setSize(830,920);
      setResizable(false);
      setVisible(true);
        
  }  
  public static void main(String[] args){  
         new StartFrame();      
  }  
}