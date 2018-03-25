package test1;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.Calendar;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MenuItemListener implements ActionListener {//响应菜单事件
	static Calculator a = new Calculator();
	static ScienceCal b = new ScienceCal();
	static child ch = new child();
	
	 static int y=Calendar.getInstance().get(Calendar.YEAR);           ///获取年份
     static int m=Calendar.getInstance().get(Calendar.MONTH)+1;        ///获取月份
    static  int d=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);  
	static adult ad = new adult(y,m,d);
	
	static GeneticHeight gene = new GeneticHeight();
	static youth yo = new youth();
	static Chess che = new Chess();
	static TabbedPane lo = new TabbedPane();
	static JMine mine = new JMine();
	
	static clock3 cl=new clock3();

	//static ExchangeRate ex=new ExchangeRate();


	public static void main(String[] args){ 
		 a.setVisible(true);
		 a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if ("主页".equals(e.getActionCommand())) {
			b.setVisible(false);
			a.setVisible(true);//切换到简易计算器窗口
			yo.setVisible(false);
			 ch.setVisible(false);
			 ad.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false);
			 mine.setVisible(false);
			 //ma.setVisible(false);	
			 cl.setVisible(false);
		} else if ("现在时间".equals(e.getActionCommand())){
			 a.setVisible(false);
			 b.setVisible(false);	
			 yo.setVisible(false);
			 ch.setVisible(false);
			 ad.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false);
			 mine.setVisible(false);	
			 cl.setVisible(true);
		}
		
		else if ("科学计算器".equals(e.getActionCommand())){
			 a.setVisible(false);
			 b.setVisible(true);	
			 yo.setVisible(false);
			 ch.setVisible(false);
			 ad.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false);
			 mine.setVisible(false);
			 //ma.setVisible(false);
			 cl.setVisible(false);
			
		}
		
	    else if (e.getActionCommand().equals("About...")) {
			JTextArea aboutArea = new JTextArea();
			aboutArea.setText("时光轴计算器\n组员：田陇宁    王珊珊");
			JOptionPane.showMessageDialog(null, aboutArea, "关于 计算器", JOptionPane.PLAIN_MESSAGE);
		}
		
	    else if ("孩童时光".equals(e.getActionCommand())) {
	    	ad.setVisible(false);
	    	yo.setVisible(false);
			 ch.setVisible(true);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false);
			 mine.setVisible(false);
			// ma.setVisible(false);
			 cl.setVisible(false);
	    }else if ("青年时期".equals(e.getActionCommand())){
	    	ch.setVisible(false);
	    	ad.setVisible(false);
			 yo.setVisible(true);	
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false);
			 mine.setVisible(false);
			 //ma.setVisible(false);
			 cl.setVisible(false);
	    }else if ("成年生活".equals(e.getActionCommand())) {
	    	ch.setVisible(false);
	    	yo.setVisible(false);
			 ad.setVisible(true);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false);
			 mine.setVisible(false);
			 //ma.setVisible(false);
			cl.setVisible(false);
	    }else if ("遗传身高计算器".equals(e.getActionCommand())) {
	    	ch.setVisible(false);
	    	yo.setVisible(false);
			 ad.setVisible(false);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(true);
			 che.setVisible(false); 
			 lo.setVisible(false);
			 mine.setVisible(false);
			 //ma.setVisible(false);
			 cl.setVisible(false);
	    }else if ("BMI指数计算器".equals(e.getActionCommand())) {
	    	ch.setVisible(true);
	    	yo.setVisible(false);
			 ad.setVisible(false);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false);
			 mine.setVisible(false);
			 //ma.setVisible(false);
			 cl.setVisible(false);
	    }else if ("简易版专注神器".equals(e.getActionCommand())) {
	    	ch.setVisible(false);
	    	yo.setVisible(true);
			 ad.setVisible(false);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false); 
			 mine.setVisible(false);
			// ma.setVisible(false);
			 cl.setVisible(false);
	    }else if ("贷款还款金额的计算".equals(e.getActionCommand())) {
	    	ch.setVisible(false);
	    	yo.setVisible(false);
			 ad.setVisible(false);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(true); 
			 mine.setVisible(false);
			//ma.setVisible(false);
			 cl.setVisible(false);
	    }else if ("轻松一刻——中国象棋".equals(e.getActionCommand())) {
	    	ch.setVisible(false);
	    	yo.setVisible(false);
			 ad.setVisible(false);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(true);
			 lo.setVisible(false); 
			 mine.setVisible(false);	
			 cl.setVisible(false);
	    }  else if ("轻松一刻——扫雷".equals(e.getActionCommand())) {
	    	ch.setVisible(false);
	    	yo.setVisible(false);
			 ad.setVisible(false);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false); 
			 mine.setVisible(true);	
			 cl.setVisible(false);
	    }   else if ("日历记事本".equals(e.getActionCommand())) {
	    	ch.setVisible(false);
	    	yo.setVisible(false);
			 ad.setVisible(true);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false); 
			 mine.setVisible(false);
			 cl.setVisible(false);
	    }  
	    else if ("汇率换算".equals(e.getActionCommand())) {
	    	ch.setVisible(false);
	    	yo.setVisible(false);
			 ad.setVisible(false);
			 a.setVisible(false);
			 b.setVisible(false);
			 gene.setVisible(false);
			 che.setVisible(false);
			 lo.setVisible(false); 
			 cl.setVisible(false);
			 mine.setVisible(false);
			 ExchangeRate.main(null);
	    }  
		
		
	}
}
   