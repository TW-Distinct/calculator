
package test1;

import java.applet.Applet;

import java.io.*; 
import java.io.InputStreamReader; 
import java.net.*;
import java.util.List;
import java.util.Map;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ExchangeRate extends Applet implements ActionListener
{
	//String meihui = SendGET(null, null);
	//String meiyuan=meihui.substring(meihui.indexOf("第")+1,str.indexOf("号"));

	private JFrame frame=new JFrame("汇率转换");
private JTextField text1=new JTextField();
private JTextField text2=new JTextField();
private String s[]={"美元USD ","人民币CNY","日元 JPY",
"欧元EUR","韩元KPW","加拿大元CAD","澳元AUD","英镑GBP","台币TWD","新西兰元NZD"};
private float rate[]={1,(float)6.8269,(float)89.1821992,(float)0.684134911,(float)1162.7907 ,
(float)1.06079974 ,(float)1.09793588 ,(float) 0.615763547 ,(float)32.1646832,(float)1.38159713};
private JComboBox cb=null;
private JComboBox cb1=null;
private double sum;//兑换后的金额
JLabel num=new JLabel("兑换金额");
JLabel money=new JLabel ("由 ");
JLabel bmoney=new JLabel("兑换至 ");
JLabel bnum=new JLabel("兑换后的金额为");
Panel p1;
Panel p2;
Panel p3;
Panel p4;
Panel p5;
JButton button;
JButton back;

public void init()
{
cb=new JComboBox(s);
cb1=new JComboBox(s);
text1 = new JTextField(15);
text2= new JTextField(10) ;
p1=new Panel();
p2=new Panel();
p3=new Panel();
p4=new Panel();
p5=new Panel();
p1.add(num,BorderLayout.WEST);
p1.add(text1,BorderLayout.EAST);
p2.add(money,BorderLayout.WEST);
p2.add(cb,BorderLayout.EAST);
p3.add(bmoney,BorderLayout.WEST);
p3.add(cb1,BorderLayout.EAST);

add(p1,BorderLayout.NORTH);
add(p2,BorderLayout.CENTER);
add(p3,BorderLayout.SOUTH);
button=new JButton("兑换");
back=new JButton("主页");
p4.add(button,BorderLayout.WEST);
p4.add(back,BorderLayout.EAST);
add(p4);
p5.add(bnum,BorderLayout.WEST);
p5.add(text2,BorderLayout.EAST);
add(p5);
//cb.addActionListener(this);
//cb1.addActionListener(this);
button.addActionListener(this);
//back.addActionListener(new MenuItemListener());

back.addActionListener(new java.awt.event.ActionListener() { 
    public void actionPerformed(java.awt.event.ActionEvent e) {    	
    	MenuItemListener.a.setVisible(true);
    }
});


}

public void actionPerformed(ActionEvent e) {

	JButton button1=(JButton) e.getSource();
	java.text.DecimalFormat df=new java.text.DecimalFormat("#.000000");
	String text=text1.getText();
	String sum1;
	int cbx = cb.getSelectedIndex();//记录下标
	int cb1x=cb1.getSelectedIndex();
	if(button1==button)
	{
		sum=Float.parseFloat(text);

		if(sum>0)
		{

			sum1=df.format((double)rate[cb1x]/(double)rate[cbx]*sum);
			text2.setText(sum1);
		}
		else
			text2.setText("你输入的金额错误！");
	}

}
public static void main(String[] args) {
	ExchangeRate er = new ExchangeRate();
	Frame f = new Frame();
	f.add(er);
	f.setSize(500, 500);
	er.init();
	f.addWindowListener(new WindowListener(){
		public void windowActivated(WindowEvent e) {}

		public void windowClosed(WindowEvent e) {}

		public void windowClosing(WindowEvent e) {
			e.getWindow().dispose();
		}

		public void windowDeactivated(WindowEvent e) { }

		public void windowDeiconified(WindowEvent e) { }

		public void windowIconified(WindowEvent e) { }

		public void windowOpened(WindowEvent e) { } 

	});
	f.show();
	}




public static String SendGET(String url,String param){  
	String result="";//访问返回结果  
	BufferedReader read=null;//读取访问结果  
	
	try {  
		//创建url  
		URL realurl=new URL(url+"http://api.k780.com:88/?app=finance.rate&scur=USD&tcur=CNY&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4"+param);  
		//打开连接  
		URLConnection connection=realurl.openConnection();  
		// 设置通用的请求属性  
		connection.setRequestProperty("accept", "*/*");  
		connection.setRequestProperty("connection", "Keep-Alive");  
		connection.setRequestProperty("user-agent",  
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");  
		//建立连接  
		connection.connect();  
		// 获取所有响应头字段  
		Map<String, List<String>> map = connection.getHeaderFields();  
		// 遍历所有的响应头字段，获取到cookies等  
		for (String key : map.keySet()) {  
			System.out.println(key + "--->" + map.get(key));  
		}  
		// 定义 BufferedReader输入流来读取URL的响应  
		read = new BufferedReader(new InputStreamReader(  
				connection.getInputStream(),"UTF-8"));  
		String line;//循环读取  
		while ((line = read.readLine()) != null) {  
			result += line;  
		}  
	} catch (IOException e) {  
		e.printStackTrace();  
	}finally{  
		if(read!=null){//关闭流  
			try {  
				read.close();  
			} catch (IOException e) {  
				e.printStackTrace();  
			}  
		}  
	}  
	
	return result;   
}
}








