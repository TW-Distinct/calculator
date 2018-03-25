package test1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Month extends Box implements ActionListener
{
  int month;                           
  JTextField showMonth=null;      ///显示月份的文本条     
  JButton 下月,上月;
  adult 日历;
  public Month(adult 日历)
  {  
     super(BoxLayout.X_AXIS);        
     this.日历=日历;
     showMonth=new JTextField(2);
     month=日历.getMonth();
     showMonth.setEditable(false);
     showMonth.setForeground(Color.blue);
     showMonth.setFont(new Font("TimesRomn",Font.BOLD,16)); 
     下月=new JButton("下月");
     上月=new JButton("上月");
     add(上月);
     add(showMonth);
     add(下月);
     上月.addActionListener(this);
     下月.addActionListener(this);
     showMonth.setText(""+month);
  }
 public void setMonth(int month)
  {
    if(month<=12&&month>=1)
      {
       this.month=month;
      }
    else
      {
        this.month=1;
      }
    showMonth.setText(""+month);
  }
 public int getMonth()
  {
    return month;
  } 
 public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==上月)
      {
        if(month>=2)
         {
            month=month-1;
            日历.setMonth(month);
            日历.设置日历牌(日历.getYear(),month);
         }
        else if(month==1)
         {
            month=12;
            日历.setMonth(month);
            日历.设置日历牌(日历.getYear(),month);
         }
       showMonth.setText(""+month);
      }
    else if(e.getSource()==下月)
      {
        if(month<12)
          {
            month=month+1;
            日历.setMonth(month);
            日历.设置日历牌(日历.getYear(),month);
          }
        else if(month==12)
          {
            month=1;
            日历.setMonth(month);
            日历.设置日历牌(日历.getYear(),month);
          }
        showMonth.setText(""+month);
      }
  }   
}
