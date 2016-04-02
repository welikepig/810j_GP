import java.awt.*;  
import javax.swing.*;  


public class StartFrame extends JFrame {  
  private GoBoard goBoard;  
  private JPanel toolbar;  
  private JButton startButton,backButton,exitButton;  
    
  private JMenuBar menuBar;  
  private JMenu sysMenu;  
  private JMenuItem startMenuItem,exitMenuItem,backMenuItem;  

  public StartFrame(){  
      setTitle("GO/WEIQI");
      goBoard=new GoBoard();    
      Container contentPane=getContentPane();  
      contentPane.add(goBoard); 
      
       
      menuBar =new JMenuBar();
      menuBar.setBackground(new Color(88,161,176));
      sysMenu=new JMenu("Menu");

      startMenuItem=new JMenuItem("START");  
      exitMenuItem =new JMenuItem("QUIT");  
      backMenuItem =new JMenuItem("UNDO");  

      sysMenu.add(startMenuItem);  
      sysMenu.add(exitMenuItem);  
      sysMenu.add(backMenuItem);  
      
      menuBar.add(sysMenu); 
      setJMenuBar(menuBar); 
        
      toolbar=new JPanel();
      toolbar.setBackground(new Color(88,161,176));
      startButton=new JButton("START");  
      exitButton=new JButton("QUIT");  
      backButton=new JButton("UNDO");  

      toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));  
      toolbar.add(startButton);  
      toolbar.add(exitButton);  
      toolbar.add(backButton);  
      
      add(toolbar,BorderLayout.SOUTH);  
      add(goBoard);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      setSize(830,920);
      setResizable(false);
      setVisible(true);
        
  }  
  public static void main(String[] args){  
         new StartFrame();      
  }  
}