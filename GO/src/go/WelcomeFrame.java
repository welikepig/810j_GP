package go;
/*
 * This class is a JFrame, Giving a welcome page
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class WelcomeFrame extends JFrame {
	public WelcomeFrame(){
		Container c=getContentPane();
		c.setBackground(new Color(238,173,14));
		
		JButton s=new JButton("Let's Play");
		JLabel l=new JLabel("<html>Project: Go/Weiqi<br/>Zhiyuan Chen<br/>Yudi Dong<html>",JLabel.CENTER);
		
		Font font=new Font("Project: Go/Weiqi",Font.BOLD,50);
		Font font1=new Font("Let's Play",Font.BOLD,45);
		l.setFont(font);
		s.setFont(font1);
		s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StartFrame();
				dispose();
			}
		});
		
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		
		c.setLayout(new BorderLayout());
		
		p1.add(l,BorderLayout.CENTER);
		p2.add(new ImagePanel());
		p3.add(s);
		
		c.add(p1,BorderLayout.NORTH);
		c.add(p2,BorderLayout.CENTER);
		c.add(p3,BorderLayout.SOUTH);
		
		
		setTitle("Project: Go/Weiqi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		setSize(610,700);
	    setResizable(false);
	    setVisible(true);
	    setLocationRelativeTo(null);

	}
	
	public static void main(String[] args) {
		new WelcomeFrame();
	}
}

class ImagePanel extends JPanel{
	private ImageIcon imageIcon=new ImageIcon("image/weiqi.jpg");
	private Image image=imageIcon.getImage();
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		if (image==null)
			g.drawImage(image,0,0,getWidth(),getHeight(),this);
	}
}
