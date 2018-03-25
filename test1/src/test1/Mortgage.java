package test1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Mortgage {

		static double month = 6;

	    public static void placeComponents(JPanel panel) {
	    	
	    	
	    	/*ImageIcon img = new ImageIcon("image\\timg.jpg");
			JLabel imgLabel = new JLabel(img);
			panel.add(imgLabel, new Integer(Integer.MIN_VALUE));
	    	panel.setOpaque(false);*/
	        panel.setLayout(null);
	        
	        // 创建 JLabel
	        JLabel moneyLabel = new JLabel("贷款金额");
	        /* 定义了组件位置。
	         * setBounds(x, y, width, height)
	         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
	         */
	        moneyLabel.setBounds(10,20,80,25);
	        panel.add(moneyLabel);

	        /* 
	         * 创建文本域用于用户输入贷款金额
	         */
	        JTextField moneyText = new JTextField(20);
	        moneyText.setBounds(100,20,120,25);
	        panel.add(moneyText);
	        
	        // 创建 JLabel
	        JLabel y1Label = new JLabel("元");
	        y1Label.setBounds(220,20,80,25);
	        panel.add(y1Label);
	        
	        // 创建 JLabel,提示
	        JLabel promptingLabel = new JLabel("请输入正确的贷款金额");
	        promptingLabel.setBounds(240,20,150,25);
	        promptingLabel.setVisible(false);
	        promptingLabel.setForeground(new Color(255,0,0));
	        panel.add(promptingLabel);
	        
	        // 输入贷款期限的文本域
	        JLabel timeLabel = new JLabel("贷款期限");
	        timeLabel.setBounds(10,50,80,25);
	        panel.add(timeLabel);

	        /* 
	         *创建下拉选狂用于用户选择贷款期限
	         */
	        JComboBox<String> comboBox=new JComboBox<String>(); 
	        comboBox.setBounds(100, 50, 100, 25);
	        comboBox.addItem("6个月");  
	        comboBox.addItem("1年");  
	        comboBox.addItem("2年");
	        comboBox.addItem("3年");  
	        comboBox.addItem("4年");
	        comboBox.addItem("5年");  
	        comboBox.addItem("10年");
	        comboBox.addItem("15年");  
	        comboBox.addItem("20年");
	        comboBox.addItem("25年");  
	        comboBox.addItem("30年"); 
	        panel.add(comboBox);  
	        
	        // 输出年利率的文本域
	        JLabel rateLabel = new JLabel("年利率");
	        rateLabel.setBounds(10,80,80,25);
	        panel.add(rateLabel);
	        
	        /* 
	         *创建文本域用于输入年利率
	         */
	        JTextField rateText = new JTextField(20);
	       rateText.setBounds(100,80,80,25);
	        panel.add(rateText);
	        
	       
	        
	        // 创建计算按钮
	        JButton calculation = new JButton("计算");
	        calculation.setBounds(10, 110, 80, 25);
	        panel.add(calculation);
	        
	        // 输出每月还款的文本域
	        JLabel monthlyPaymentsLabel = new JLabel("每月还款");
	        monthlyPaymentsLabel.setBounds(10,150,80,25);
	        panel.add(monthlyPaymentsLabel);
	        
	        /* 
	         *创建文本域用于输出每月还款
	         */
	        JTextField monthlyPaymentsText = new JTextField(20);
	        monthlyPaymentsText.setEditable(false);
	        monthlyPaymentsText.setBounds(80,150,120,25);
	        panel.add(monthlyPaymentsText);
	        
	        // 创建 JLabel
	        JLabel y2Label = new JLabel("元");
	        y2Label.setBounds(200,150,80,25);
	        panel.add(y2Label);
	        
	        // 输出总支付利息的文本域
	        JLabel totalInterestLabel = new JLabel("总支付利息");
	        totalInterestLabel.setBounds(10,180,80,25);
	        panel.add(totalInterestLabel);
	        
	        /* 
	         *创建文本域用于输出总支付利息
	         */
	        JTextField totalInterestText = new JTextField(20);
	        totalInterestText.setEditable(false);
	        totalInterestText.setBounds(80,180,120,25);
	        panel.add(totalInterestText);
	        
	        // 创建 JLabel
	        JLabel y3Label = new JLabel("元");
	        y3Label.setBounds(200,180,80,25);
	        panel.add(y3Label);
	        
	        // 输出总本息合计（Total principal and interest）的文本域
	        JLabel tpaiLabel = new JLabel("本息合计");
	        tpaiLabel.setBounds(10,210,80,25);
	        panel.add(tpaiLabel);
	        
	        /* 
	         *创建文本域用于输出本息合计（Total principal and interest）
	         */
	        JTextField tpaiText = new JTextField(20);
	        tpaiText.setEditable(false);
	        tpaiText.setBounds(80,210,120,25);
	        panel.add(tpaiText);
	        
	        // 创建 JLabel
	        JLabel y4Label = new JLabel("元");
	        y4Label.setBounds(200,210,80,25);
	        panel.add(y4Label);
	        
	        // 创建清空按钮
	        JButton empty = new JButton("清空");
	        empty.setBounds(10, 240, 80, 25);
	        panel.add(empty);
	        
	        //给清空按钮添加单击事件
	        empty.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            		moneyText.setText("");
	            		rateText.setText("");
	            		monthlyPaymentsText.setText("");
					totalInterestText.setText("");
					tpaiText.setText(""); 
	            }
	        });
	        //监听选中
	        comboBox.addItemListener(new ItemListener(){
		        @Override
			        public void itemStateChanged(ItemEvent e){
			        		//如果选中了一个 
			        		if (e.getStateChange() == ItemEvent.SELECTED){
			        			//获取下拉选框中的值 
			        			String rate = comboBox.getSelectedItem().toString();
			        		}
			        	}
		       });
	        
	        //给计算按钮添加单击事件
	        calculation.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                //调用计算方法
	            		calculation();
	            }
				private void calculation() {
					//获取用户输入金额
					String moneyT = moneyText.getText();
					try {
						//判断用户输入是否符合规范
						if(moneyT !=null && moneyT !="" && Double.parseDouble(moneyT)>0) {
							//设置隐藏不符合规范提示
							promptingLabel.setVisible(false);
							//获取贷款金额
							double money = Integer.parseInt(moneyText.getText());
							//获取利率部分
							String []decimal = rateText.getText().split("%");
							//获取年利率
							double rateYear = Double.parseDouble(decimal[0])/100;
							//获取月利率
							double rateMonth = rateYear/12;
							//计算等额本息(每月还款)等额本息(principal And Interest)计算公式：〔贷款本金×月利率×（1＋月利率）＾还款月数〕÷〔（1＋月利率）＾还款月数－1〕
							double pai = (money*rateMonth*Math.pow(1+rateMonth,month))/(Math.pow(1+rateMonth,month)-1);
							//将等额本息(每月还款)四舍五入到小数点后两位并显示到文本框
							monthlyPaymentsText.setText(String.format("%.2f", pai));
							//计算总支付利息
							double interest = (pai-money/month)*month;
							//将总支付利息四舍五入后到小数点后两位并显示到文本框
							totalInterestText.setText(String.format("%.2f", interest));
							//计算本息合计
							double tpai = money+interest;
							//将本息合计四舍五入到小数点后两位并显示到文本框 
							tpaiText.setText(String.format("%.2f", tpai));
						}else {
							//不符合规范给予相应提示
							promptingLabel.setVisible(true);
							empty();
						}
							
					} catch (Exception e) {
						//不符合规范给予相应提示
						promptingLabel.setVisible(true);
						empty();
					}
				}
				public void empty() {
					monthlyPaymentsText.setText("");
					totalInterestText.setText("");
					tpaiText.setText("");
				}
	        });
	}
}
