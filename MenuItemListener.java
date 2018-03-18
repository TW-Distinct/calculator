package com.chp01.test1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MenuItemListener implements ActionListener {//响应菜单事件
	static Calculator a = new Calculator();
	static ScienceCal b = new ScienceCal();
	public static void main(String[] args){
		 a.setVisible(true);
		 a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if ("基本计算器".equals(e.getActionCommand())) {
			b.setVisible(false);
			a.setVisible(true);//切换到简易计算器窗口
		} else if ("科学计算器".equals(e.getActionCommand())) {
			
			 a.setVisible(false);
			 b.setVisible(true);
			 
		}
		
	else if (e.getActionCommand().equals("About...")) {
			JTextArea aboutArea = new JTextArea();
			aboutArea.setText("复合型计算器\n组员：何树林    徐助权    黄家俊");
			JOptionPane.showMessageDialog(null, aboutArea, "关于 计算器", JOptionPane.PLAIN_MESSAGE);
		}
	}
}
   