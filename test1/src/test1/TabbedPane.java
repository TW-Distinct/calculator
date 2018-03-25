package test1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
	public class TabbedPane extends JFrame {
		
		
public TabbedPane() {
	super();
	
      setSize(600, 600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
       
       
       JMenuBar mb = new JMenuBar();// 创建菜单栏
		JMenu b1 = new JMenu("选项");
		JMenu b2 = new JMenu("帮助");
		JMenuItem c1 = new JMenuItem("主页");
		JMenuItem c2 = new JMenuItem("日历记事本");
		JMenuItem c4= new JMenuItem("汇率换算");
		JMenuItem c3 = new JMenuItem("About...");
		setJMenuBar(mb);// 添加菜单栏
		mb.add(b1);
		mb.add(b2);// 添加菜单
		b1.add(c1);
		b1.add(c2);
		b1.add(c4);
		b2.add(c3);
		
		b1.setFont(new Font("宋体", Font.PLAIN, 17));
		b2.setFont(new Font("宋体", Font.PLAIN, 17));
		c1.addActionListener(new MenuItemListener());// 监听简易计算器
		c2.addActionListener(new MenuItemListener());// 监听科学计算器
		c3.addActionListener(new MenuItemListener());// 监听关于
		c4.addActionListener(new MenuItemListener());// 监听
       
       
		//面板之外添加了背景
		ImageIcon img = new ImageIcon("image\\loan.jpg");
		JLabel imgLabel = new JLabel(img);
		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		((JPanel)getContentPane()).setOpaque(false); 
		
       //设置两个选项，流式布局
	   JPanel jp1 = new JPanel(new FlowLayout());
	   
	  /* JLabel imgLabel2 = new JLabel(img);
		jp1.add(imgLabel2, new Integer(Integer.MIN_VALUE));
		imgLabel2.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
	   jp1.setOpaque(false);*/ 
	   
	   JPanel jp2 = new JPanel(new FlowLayout());

	  /* JLabel imgLabel3 = new JLabel(img);
		jp1.add(imgLabel3, new Integer(Integer.MIN_VALUE));
		imgLabel3.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
	   jp2.setOpaque(false); */
	  
	   //调用对应的方法
	   TaxRate.placeComponents(jp1);
	   Mortgage.placeComponents(jp2);
	   //创建面板
	   JTabbedPane jt = new JTabbedPane();
	   
	
	  
	   //给面板添加两个选项
	   jt.addTab("税率计算器",jp1);
	   jt.addTab("等额本息贷款计算器",jp2); // jt.setOpaque(false); 
	   //给JFrame添加组件，并设置两个选项的位置。BorderLayout边界布局。
	   getContentPane().add(jt,BorderLayout.CENTER);
	   //设置关闭窗口方式
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	   //setVisible(true);
	  }
}
