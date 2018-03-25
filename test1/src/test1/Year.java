package test1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Year extends Box implements ActionListener
{
  int year;                           
  JTextField showYear=null;     ///表示年份的文本条      
  JButton 明年,去年;
  adult 日历;
  public Year(adult 日历)
  {  
     super(BoxLayout.X_AXIS);    ////一个水平分布组件的BOX容器    
     showYear=new JTextField(4);
     showYear.setForeground(Color.blue);
     showYear.setFont(new Font("TimesRomn",Font.BOLD,14)); 
     this.日历=日历;
     year=日历.getYear();
     明年=new JButton("下年");
     去年=new JButton("上年");
     add(去年);
     add(showYear);
     add(明年);
     showYear.addActionListener(this);
     去年.addActionListener(this);
     明年.addActionListener(this);
  }
 public void setYear(int year)
  {
    this.year=year;
    showYear.setText(""+year);
  }
 public int getYear()
  {
    return year;
  } 
 public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==去年)
      {
        year=year-1;
        showYear.setText(""+year);
        日历.setYear(year);
        日历.设置日历牌(year,日历.getMonth());
      }
    else if(e.getSource()==明年)
      {
        year=year+1;
        showYear.setText(""+year);
        日历.setYear(year);
        日历.设置日历牌(year,日历.getMonth());
      }
    else if(e.getSource()==showYear)
      {
         try
            {
              year=Integer.parseInt(showYear.getText());
              showYear.setText(""+year);
              日历.setYear(year);
              日历.设置日历牌(year,日历.getMonth());
            }
         catch(NumberFormatException ee)////输入的年份不是整数则恢复为此前显示的的年份
            {
              showYear.setText(""+year);
              日历.setYear(year);
              日历.设置日历牌(year,日历.getMonth());
            }
      }
  }   
}
