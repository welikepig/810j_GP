package go;
/*
 * This class is a JFrame includes the main,
 * All JButtons, JPanel, JMeunBar and some other things can be add here
 *@author: Zhiyuan Chen
 *@author: Yudi Dong
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
      startButton=new JButton("CLEAR BOARD");  
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
      
      add(toolbar,BorderLayout.SOUTH);  
      add(goBoard);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      setSize(700,930);
      setVisible(true);
        
  }  
  public static void main(String[] args){  
         new StartFrame();      
  }  
}