package go;
/*
 * This class is a JFrame including the meunBar, toolBar 
 * And three modes in menuBar: Play with AI start with black or white, Play with people 
 * Three functions in toolBar: Clear board, Undo, Quit
 */
import java.awt.*;  
import javax.swing.*;
import java.awt.event.*;


public class StartFrame extends JFrame {  
  public static GoBoard goBoard = new GoBoard();  
  public static JPanel toolbar,display,p1,p2;  
  public static JButton startButton,backButton,exitButton;  

  public static JMenuBar menuBar;  
  public static JMenu sysMenu,startMenu1;  
  public static JMenuItem item1,item2,item3;  


  public StartFrame(){  
      setTitle("GO/WEIQI");
      menuBar =new JMenuBar();
      menuBar.setBackground(new Color(88,161,176));
      sysMenu=new JMenu("Menu");
      menuBar.add(sysMenu); 
      setJMenuBar(menuBar); 
      
	  Container contentPane=getContentPane();
	  display = new JPanel();
	  JLabel show1 = new JLabel("  ");
	  Font f = new Font("Helvetica", Font.BOLD, 14);
	  show1.setFont(f);
	  display.add(show1);
	  contentPane.add(display,BorderLayout.NORTH);
      
      startMenu1 = new JMenu("Play with AI");
      item1 = new JMenuItem("Start with Black");
      item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBoard.getBoard().clear();
	    		goBoard.setMode(-1);
				contentPane.add(goBoard);
	    		toolbar=new JPanel();
	    	    toolbar.setBackground(new Color(88,161,176));
	    	    startButton=new JButton("RESTART");
	    	    backButton=new JButton("UNDO");
	    	    exitButton=new JButton("QUIT");  
	    	    toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));  
	    	    toolbar.add(startButton);
	    	    toolbar.add(backButton); 
	    	    toolbar.add(exitButton);  
	    	     
	    	    contentPane.add(toolbar,BorderLayout.SOUTH);
				show1.setText("Play with AI"+": "+item1.getText() );
			}
		});
      item2 = new JMenuItem("start with White");
      item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBoard.getBoard().clear();
	    		goBoard.setMode(1);
	    		goBoard.AiFirstStep();
				show1.setText("Play with AI"+": "+item2.getText() );
				contentPane.add(goBoard);
	    		toolbar=new JPanel();
	    	    toolbar.setBackground(new Color(88,161,176));
	    	    startButton=new JButton("RESTART");
	    	    backButton=new JButton("UNDO");
	    	    exitButton=new JButton("QUIT");  

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
	    	    toolbar.add(backButton);
	    	    toolbar.add(exitButton);  
	    	    contentPane.add(toolbar,BorderLayout.SOUTH);
			}
		});
      
      item3 = new JMenuItem("Two people Play");
      startMenu1.add(item1);
      startMenu1.add(item2);

      item3.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  goBoard.getBoard().clear();
    		  goBoard.setMode(0);
    		  contentPane.add(goBoard);
    		  toolbar=new JPanel();
    	      toolbar.setBackground(new Color(88,161,176));
    	      startButton=new JButton("RESTART");
    	      backButton=new JButton("UNDO");
    	      exitButton=new JButton("QUIT");  
    	      
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
    	      toolbar.add(backButton);
    	      toolbar.add(exitButton);  
    	      contentPane.add(toolbar,BorderLayout.SOUTH);
    		  show1.setText("Two people Play");  
    	  }
      });
      sysMenu.add(item3);
      sysMenu.add(startMenu1); 

	  
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      setSize(610,700+30);
      setResizable(false);
      setVisible(true);
      setLocationRelativeTo(null);   
          
  }  
 
}