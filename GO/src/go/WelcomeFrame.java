package go;
/*
 * This class is a JFrame, Giving a welcome page
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class WelcomeFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WelcomeFrame(){
		Container c=getContentPane();

		
		JButton s=new JButton("Let's play Weiqi");
		JLabel l1=new JLabel("Project: Go/Weiqi",JLabel.CENTER);
		JLabel l2=new JLabel("Zhiyuan Chen",JLabel.CENTER);
		JLabel l3=new JLabel("Yudi Dong",JLabel.CENTER);
		
		
		Font font=new Font("Project: Go/Weiqi",Font.CENTER_BASELINE,40);
		Font font1=new Font("name",Font.ITALIC,25);
		Font font2=new Font("play",Font.CENTER_BASELINE,30);
		l1.setFont(font);
		l2.setForeground(Color.WHITE);
		l2.setFont(font1);
		l3.setFont(font1);
		l3.setForeground(Color.WHITE);
		s.setFont(font2);
		s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StartFrame();
				dispose();
			}
		});
		s.setBackground(Color.gray);
		
		
		JPanel p1=new JPanel();
		ImageIcon img = new ImageIcon(getClass().getResource("/image/weiqi.jpg"));
		BackgroundPanel p2=new BackgroundPanel(img.getImage());
		JPanel p3=new JPanel();
         
		p1.setLayout(new BorderLayout());
		p1.setBackground(Color.lightGray);
		p1.add(l1,BorderLayout.NORTH);
		p1.add(l2,BorderLayout.CENTER);
		p1.add(l3,BorderLayout.SOUTH);
		p3.add(s);
		p3.setBackground(Color.lightGray);
        

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

class BackgroundPanel extends JPanel  {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	Image im;  
    public BackgroundPanel(Image im)  
    {  
        this.im=im;  
        this.setOpaque(false);  
    }  
    //Draw the back ground.  
    public void paintComponent(Graphics g)  
    {  
        super.paintComponents(g);  
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);  
          
    }  
}  
