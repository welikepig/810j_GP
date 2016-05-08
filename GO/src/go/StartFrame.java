package go;
/*
 * This class is a JFrame including the meunBar, toolBar 
 * And three modes in menuBar: Play with AI start with black or white, Play with people 
 * Three functions in toolBar: Clear board, Undo, Quit
 */
import java.awt.*;  
import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;


public class StartFrame extends JFrame {  
  /**
	 * 
	 */
	private static final long serialVersionUID = 2L;


public static GoBoard goBoard = new GoBoard();  
  public static JPanel toolbar;
  public static JTextField display;
  public static JButton startButton,backButton,exitButton,saveButton,loadButton,passButton;  
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
      goBoard=new GoBoard(); 
      
		
	  Container contentPane=getContentPane();
	  contentPane.add(goBoard);
	  display = new JTextField("Choose mode,default is PVP");
	  display.setFont(new Font("TimesRoman", Font.PLAIN, 24));
	  display.setEditable(false);
	  contentPane.add(display,BorderLayout.NORTH);
      startMenu1 = new JMenu("Play with AI");
      item1 = new JMenuItem("Start with Black");
      item2 = new JMenuItem("start with White");
      item3 = new JMenuItem("Two people Play");
      startMenu1.add(item1);
      startMenu1.add(item2);
    //  startMenu2.add(item3);
      item3.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  goBoard.clear();
    		  goBoard.setMode(0);
    		  display.setText("Two people Play");  
    	  }
      });
      item1.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  goBoard.clear();
    		  goBoard.setMode(-1);
    		  display.setText("Play with AI"+": "+item1.getText() );

    	  }
      });
      item2.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  goBoard.clear();
    		  goBoard.setMode(1);
    		  display.setText("Play with AI"+": "+item2.getText() );

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
    		  goBoard.clear();
    		  display.setText("Restart");

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
    		  display.setText("Undo");
    	  }
      });
      saveButton = new JButton("SAVE");
      saveButton.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  try {
				goBoard.save();
				display.setText("Save Board");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	  }
      });
      loadButton = new JButton("LOAD");
      loadButton.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  try {
				goBoard.load();
		   		display.setText("Load Board");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	  }
      });
      passButton=new JButton("PASS");
      passButton.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  goBoard.pass();
    		  display.setText("Pass");
    	  }
      });
      
      toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));  
      toolbar.add(startButton);  
      toolbar.add(exitButton);  
      toolbar.add(backButton);  
      toolbar.add(saveButton);
      toolbar.add(loadButton);
      toolbar.add(passButton);
      
      contentPane.add(toolbar,BorderLayout.SOUTH);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      setSize(610,720);
      setResizable(false);
      setVisible(true);
      setLocationRelativeTo(null);   
          
  }  
 
}