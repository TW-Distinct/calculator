package test1;

import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

//import test1.MenuItemListener;





public class clock3 extends JFrame{
	
ImagePane imagePane[];
String mypic;
static Calendar now;
static Float s;
static Float m;
static Float h;	
Thread ts;
Thread tm;
Thread th;



class s extends Thread
   {
	  public void run()
	  {
		  while(true) {
		  gettime();
		  s = (float)(now.get(Calendar.SECOND) * 6);// 获得秒转换成度数，每秒转1次(1/360圆周)
		  imagePane[0].ratoteImage(s*Math.PI/180);//秒针旋转
		  try {Thread.sleep(1000);}
		  catch (Exception ex) {}
	  }}
   }

class m extends Thread
{
	  public void run()
	  {
		  while(true) {
		  gettime();
		  m = (float)(now.get(Calendar.MINUTE) * 6+Math.rint(now.get(Calendar.SECOND)/15)*1.5);// 获得分钟,每15秒转1次(1/360圆周)
		  imagePane[1].ratoteImage(m*Math.PI/180);//分针旋转
		  try {Thread.sleep(15000);}
		  catch (Exception ex) {}
	  }}
}


class h extends Thread
{
	  public void run()
	  {
		while(true) {
		  gettime();
		  h = (float)((now.get(Calendar.HOUR_OF_DAY) - 12) * 30+ Math.rint(now.get(Calendar.MINUTE)/2));// 获得小时，每12分转1格(1/360圆周)
		  imagePane[2].ratoteImage(h*Math.PI/180);//时针旋转
		  try {Thread.sleep(120000);}
		  catch (Exception ex) {}
	  }}
}

public static void gettime()
{
	now = new GregorianCalendar();

}

public clock3()
{
	super("java时钟"); //调用父类构造函数
	
	
	
	
	JMenuBar mb = new JMenuBar();//创建菜单栏
		JMenu b1 = new JMenu("选项");
		JMenu b2 = new JMenu("帮助");
		JMenuItem c1 = new JMenuItem("主页");
		JMenuItem c3 = new JMenuItem("About...");
		setJMenuBar(mb);//添加菜单栏
		mb.add(b1);
		mb.add(b2);//添加菜单
		b1.add(c1);
		b2.add(c3);
		b1.setFont(new Font("宋体", Font.ROMAN_BASELINE, 17));
		b2.setFont(new Font("宋体", Font.PLAIN, 17));
		c1.addActionListener(new MenuItemListener());//监听简易计算器
		c3.addActionListener(new MenuItemListener());//监听关于
	
	imagePane=new ImagePane[4]; 
	Container container=getContentPane(); //得到窗口容器

for(int i=0;i<4;i++)
{
	imagePane[i]=new ImagePane();
	imagePane[i].setOpaque(false);//设置透明
	imagePane[i].loadImage("image/"+(3-i)+".png"); //装载图片
	imagePane[i].setBounds(0, 0, 500, 600);//设置位置
	container.add(imagePane[i]); //增加组件到容器上
}


 ts=this.new s();
tm=this.new m();
 th=this.new h();
 gettime();
 ts.start();tm.start();th.start();

this.setSize(520,620); //设置窗口尺寸
//this.setVisible(true); //设置窗口可视
this.setResizable(false);//不可改变大小
this.setLocationRelativeTo(null);//居中
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭窗口时退出程序 

}


}
