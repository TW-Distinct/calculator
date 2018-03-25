
package test1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class youth extends JFrame implements ActionListener {
	private static final long serialVersionUID = -3439634693767815667L;
	private JLabel startTime, pastTime, label1, label2, lyear, lmonth, lday, lhour, lmin, lsec;
	private JTextField year, month, day, hour, min, sec;
	private JButton ok;
	private String str;
	private int y, m, d, h, mi, s;
	private boolean runflag = true;

	public youth() { 
		super(); 
		
		ImageIcon img = new ImageIcon("image\\focus2.jpg");
		JLabel imgLabel = new JLabel(img);
		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		((JPanel)getContentPane()).setOpaque(false); 
		
		// 初始化计算器*/
		setBounds(100, 100, 600,440);  
		label1 = new JLabel("距离专注时间结束还有:");
		label2 = new JLabel();
		startTime = new JLabel("开始时间：");
		pastTime = new JLabel("已过时间：");

		JPanel north = new JPanel();
		north.setOpaque(false);
		north.setLayout(new BorderLayout());
		north.add(label1, BorderLayout.CENTER);
		north.add(startTime, BorderLayout.NORTH);

		this.add(north, BorderLayout.NORTH);
		this.add(label2, BorderLayout.CENTER);

		JPanel south = new JPanel();
		south.setOpaque(false);
		south.setLayout(new BorderLayout());
		JPanel south_center = new JPanel();
		south_center.setOpaque(false);
		Calendar c = Calendar.getInstance();
		year = new JTextField(c.get(Calendar.YEAR) + "", 6);
		month = new JTextField(c.get(Calendar.MONTH) + 1 + "", 4);
		day = new JTextField(c.get(Calendar.DAY_OF_MONTH) + "", 4);
		hour = new JTextField(c.get(Calendar.HOUR_OF_DAY) + "", 4);
		min = new JTextField(c.get(Calendar.MINUTE) + "", 4);
		sec = new JTextField(c.get(Calendar.SECOND) + "", 4);
		lyear = new JLabel("年");
		lmonth = new JLabel("月");
		lday = new JLabel("日");
		lhour = new JLabel("时");
		lmin = new JLabel("分");
		lsec = new JLabel("秒");
		ok = new JButton("开始计时");
		south_center.add(year);
		south_center.add(lyear);
		south_center.add(month);
		south_center.add(lmonth);
		south_center.add(day);
		south_center.add(lday);
		south_center.add(hour);
		south_center.add(lhour);
		south_center.add(min);
		south_center.add(lmin);
		south_center.add(sec);
		south_center.add(lsec);
		south_center.add(ok);
		south.add(south_center, BorderLayout.CENTER);
		south.add(pastTime, BorderLayout.NORTH);
		this.add(south, BorderLayout.SOUTH);

		ok.addActionListener(this);
		label1.setFont(new Font("宋体", Font.BOLD, 20));
		label2.setFont(new Font("宋体", Font.BOLD, 26));
		label1.setForeground(new Color(154, 0, 255));
		label2.setForeground(new Color(154, 0, 255));
		
		JMenuBar mb = new JMenuBar();// 创建菜单栏
		JMenu b1 = new JMenu("选项");
		JMenu b2 = new JMenu("帮助");
		JMenuItem c1 = new JMenuItem("主页");
		JMenuItem c2 = new JMenuItem("轻松一刻——中国象棋");
		JMenuItem c4= new JMenuItem("轻松一刻——扫雷");
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
		// 设置计算器的背景颜色
		this.setBackground(Color.LIGHT_GRAY);
		this.setTitle("简易版专注神器");

	}
	public synchronized void stopthread() {
		runflag = false;
	}

	public synchronized void startthread() {
		runflag = true;
	}

	public synchronized boolean getrunflag() {
		return runflag;
	}

	class MyThread extends Thread {
		Calendar target = null;
		Calendar startTime = null;
		long targetInMill = 0;
		long startInMill = 0;

		private MyThread(int y, int m, int d, int h, int mi, int s) {
			target = new GregorianCalendar(y, m - 1, d, h, mi, s);
			startTime = Calendar.getInstance();
			startInMill = startTime.getTimeInMillis();
			targetInMill = target.getTimeInMillis();
		}

		public void run() {
			while (runflag) {
				runflag = true;
				Calendar today = new GregorianCalendar();
				long todayInMill = today.getTimeInMillis();
				long dd = targetInMill - todayInMill;
				long dis = dd / 1000;
				long ms = (dd / 100) % 10;
				long mms = (dd / 10) % 10;
				String d;

				int day = (int) (dis / (3600 * 24));
				int hour = (int) (dis % (3600 * 24) / 3600);
				int min = (int) (dis % 3600 / 60);
				int sec = (int) (dis % 60);
				if (day < 10)
					d = "  " + day;
				else if (day >= 10 && day < 100)
					d = " " + day;
				else
					d = day + "";
				String s = d + " 天 " + intToString(hour) + " 小时 " + intToString(min) + " 分 " + intToString(sec) + " 秒"
						+ ms + " " + mms;
				label2.setText(s);
				pastTime();
				if (dd <= 0) {
					ok.setText("重新开始");
					JOptionPane.showMessageDialog(youth.this, "时间到");
					break;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		private void pastTime() {
			Calendar today = new GregorianCalendar();
			long nowInMill = today.getTimeInMillis();
			long dd = nowInMill - startInMill;
			long dis = dd / 1000;
			long ms = (dd / 100) % 10;
			long mms = (dd / 10) % 10;
			String d;

			int day = (int) (dis / (3600 * 24));
			int hour = (int) (dis % (3600 * 24) / 3600);
			int min = (int) (dis % 3600 / 60);
			int sec = (int) (dis % 60);
			if (day < 10)
				d = "  " + day;
			else if (day >= 10 && day < 100)
				d = " " + day;
			else
				d = day + "";
			String s = d + " 天 " + intToString(hour) + " 小时 " + intToString(min) + " 分 " + intToString(sec) + " 秒" + ms
					+ " " + mms;
			pastTime.setText("已过时间：" + s);
		}
	}

	public String intToString(int i) {
		if (i < 10) {
			str = "0" + i;
			return str;
		} else
			return i + "";
	}

	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		MyThread t = null;
		if (str.equals("开始计时")) {
			try {
				this.startthread();
				startTime.setText("开始时间：" + new Timestamp(System.currentTimeMillis()));
				y = Integer.parseInt(year.getText());
				m = Integer.parseInt(month.getText());
				d = Integer.parseInt(day.getText());
				h = Integer.parseInt(hour.getText());
				mi = Integer.parseInt(min.getText());
				s = Integer.parseInt(sec.getText());
				year.setEditable(false);
				month.setEditable(false);
				day.setEditable(false);
				hour.setEditable(false);
				min.setEditable(false);
				sec.setEditable(false);
				// ok.setEnabled(false);
				ok.setText("停止");
				t = new MyThread(y, m, d, h, mi, s);
				t.start();
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "对不起，请输入数字！", "错误提示", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (str.equals("停止") || str.equals("重新开始")) {
			this.stopthread();
			year.setEditable(true);
			month.setEditable(true);
			day.setEditable(true);
			hour.setEditable(true);
			min.setEditable(true);
			sec.setEditable(true);
			ok.setText("开始计时");
		}

	}

	/*
	 * public static void main(String[] args) { try {
	 * UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); new
	 * Countdown(); } catch (ClassNotFoundException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } catch (InstantiationException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch
	 * (IllegalAccessException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (UnsupportedLookAndFeelException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */
}
