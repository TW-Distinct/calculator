package test1;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class AboutFrame extends JFrame implements MouseListener{
	private JPanel aboutPane;
	private JLabel msg;
	private JLabel msg1;
	private JLabel msg2;
	private JButton exit;

	public AboutFrame(String strName) {
		super(strName);
		setSize(180, 170);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		aboutPane = new JPanel();
		msg = new JLabel("时光轴计算器");
		msg1 = new JLabel("         享受生活!           ");
		msg2 = new JLabel("加油               ");
		exit = new JButton("退出");
		exit.addMouseListener(this);
		aboutPane.add(msg);
		aboutPane.add(msg1);
		aboutPane.add(msg2);
		aboutPane.add(exit);

		setContentPane(aboutPane);
		setLocation(250,220);
	}


	// the event handle to deal with the mouse click
	public void mouseClicked(MouseEvent e) {
		this.setVisible(false);	
	}

	public void mousePressed(MouseEvent e) {
		//System.out.println("Jerry Press");

	}
	public void mouseReleased(MouseEvent e) {
		//System.out.println("Jerry Release");
	}
	public void mouseExited(MouseEvent e) {
		//System.out.println("Jerry Exited");

	}
	public void mouseEntered(MouseEvent e) {
		//System.out.println("Jerry Entered");

	}

	public static void main(String[] args) {
		AboutFrame about = new AboutFrame("胜利");
		about.show();
	}
}
