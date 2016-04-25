package go;
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
     // startMenu2 = new JMenu("Two people Play");
      item1 = new JMenuItem("Start with Black");
      item2 = new JMenuItem("start with White");
      item3 = new JMenuItem("Two people Play");
      item4 = new JMenuItem("start with White");
      startMenu1.add(item1);
      startMenu1.add(item2);
    //  startMenu2.add(item3);
      item3.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  goBoard.getBoard().clear();
    		  goBoard.setMode(0);
    	  }
      });
      item1.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  goBoard.getBoard().clear();
    		  goBoard.setMode(-1);
    	  }
      });
      item2.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  goBoard.getBoard().clear();
    		  goBoard.setMode(1);
    		  goBoard.AiFirstStep();
    	  }
      });
      sysMenu.add(item3);
      sysMenu.add(startMenu1); 
      
      menuBar.add(sysMenu); 
      setJMenuBar(menuBar); 
        
      toolbar=new JPanel();
      toolbar.setBackground(new Color(88,161,176));
      startButton=new JButton("RESTART");
      exitButton=new JButton("QUIT");  
      backButton=new JButton("UNDO");
      
      startButton.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  goBoard.getBoard().clear();
    	  }
      });
      exitButton=new JButton("QUIT"); 
      exitButton.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		 System.exit(0);
    	  }
      });
      backButton=new JButton("UNDO");  
      backButton.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  goBoard.undo();
    	  }
      });

      toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));  
      toolbar.add(startButton);  
      toolbar.add(exitButton);  
      toolbar.add(backButton);  
      
      contentPane.add(toolbar,BorderLayout.SOUTH);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      setSize(630,720);
      //setResizable(false);
      setVisible(true);
        
  }  
 
}