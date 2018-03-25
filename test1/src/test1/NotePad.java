package test1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class NotePad extends JPanel implements ActionListener
{
  JTextArea text;          ///文字输入区    
  JButton 保存日志,删除日志;
  Hashtable table;          ///保存日志的散列表   
  JLabel 信息条;            //// 用来保存日期的信息条  
  int year,month,day;       //// 日至记录日期  
  File file;                ////保存散列表的文件   
  adult calendar;
  public  NotePad(adult calendar)
   {
     this.calendar=calendar;
     year=calendar.getYear();
     month=calendar.getMonth();
     day=calendar.getDay();;
     table=calendar.getHashtable();
     file=calendar.getFile();
     信息条=new JLabel(""+year+"年"+month+"月"+day+"日",JLabel.CENTER);
     信息条.setFont(new Font("TimesRoman",Font.BOLD,16));
     信息条.setForeground(Color.blue);
     text=new JTextArea(10,10);
     保存日志=new JButton("保存日志") ;
     删除日志=new JButton("删除日志") ;
     保存日志.addActionListener(this);
     删除日志.addActionListener(this);
     setLayout(new BorderLayout());
     JPanel pSouth=new JPanel();       
     add(信息条,BorderLayout.NORTH);
     pSouth.add(保存日志);
     pSouth.add(删除日志);
     add(pSouth,BorderLayout.SOUTH);
     add(new JScrollPane(text),BorderLayout.CENTER);
   }
 public void actionPerformed(ActionEvent e)
   {
     if(e.getSource()==保存日志)
      {
        保存日志(year,month,day);
      }
     else if(e.getSource()==删除日志)
      {
       删除日志(year,month,day);
      }
   }
  public void setYear(int year)
  {
    this.year=year;
  }
 public int getYear()
  {
    return year;
  }
 public void setMonth(int month)
  {
    this.month=month;
  } 
  public int getMonth()
  {
    return month;
  } 
  public void setDay(int day)
  {
    this.day=day;
  }
  public int getDay()
   {
    return day;
   }
 public void 设置信息条(int year,int month,int day)
   {
     信息条.setText(""+year+"年"+month+"月"+day+"日");
   }
  public void 设置文本区(String s)
   {
     text.setText(s);
   }
  public void 获取日志内容(int year,int month,int day)
   {
       String key=""+year+""+month+""+day;
       try
             {
              FileInputStream   inOne=new FileInputStream(file);
              ObjectInputStream inTwo=new ObjectInputStream(inOne);
              table=(Hashtable)inTwo.readObject();         
              inOne.close();
              inTwo.close();
             }
       catch(Exception ee)
             {
             }
       if(table.containsKey(key))	///如果散列表中包含选中的日期项，则弹出询问对话框
          {
            String m=""+year+"年"+month+"月"+day+"这一天有日志记载,想看吗?";
            int ok=JOptionPane.showConfirmDialog(this,m,"询问",JOptionPane.YES_NO_OPTION,
                                               JOptionPane.QUESTION_MESSAGE);
                if(ok==JOptionPane.YES_OPTION)
                  {
                    text.setText((String)table.get(key));
                  }
                else
                  {
                   text.setText(""); 
                  }
          } 
       else
          {
            text.setText("无记录");
          } 
   }
  public void 保存日志(int year,int month,int day)
   {
     String 日志内容=text.getText();
        String key=""+year+""+month+""+day;
        
        String m=""+year+"年"+month+"月"+day+"保存日志吗?";
        int ok=JOptionPane.showConfirmDialog(this,m,"询问",JOptionPane.YES_NO_OPTION,
                                               JOptionPane.QUESTION_MESSAGE);
        if(ok==JOptionPane.YES_OPTION)
          {
           try
             {
              FileInputStream   inOne=new FileInputStream(file);
              ObjectInputStream inTwo=new ObjectInputStream(inOne);
              table=(Hashtable)inTwo.readObject();///首先到文件中去读取HASHTABLE对象
              inOne.close();
              inTwo.close();
              table.put(key,日志内容);     ////将日志内容添加到散列表对象                             
              FileOutputStream out=new FileOutputStream(file);
              ObjectOutputStream objectOut=new ObjectOutputStream(out);
              objectOut.writeObject(table);
              objectOut.close();
              out.close();
             }
           catch(Exception ee)
             {
             }
         }
   }
  public void 删除日志(int year,int month,int day)
   {
      String key=""+year+""+month+""+day;
         if(table.containsKey(key))
          {  
            String m="删除"+year+"年"+month+"月"+day+"日的日志吗?";
            int ok=JOptionPane.showConfirmDialog(this,m,"询问",JOptionPane.YES_NO_OPTION,
                                               JOptionPane.QUESTION_MESSAGE);
            if(ok==JOptionPane.YES_OPTION)
              { 
              try
                {
                 FileInputStream   inOne=new FileInputStream(file);
                 ObjectInputStream inTwo=new ObjectInputStream(inOne);
                 table=(Hashtable)inTwo.readObject();
                 inOne.close();
                 inTwo.close();
                 table.remove(key);    /////删除日志                                    
                 FileOutputStream out=new FileOutputStream(file);
                 ObjectOutputStream objectOut=new ObjectOutputStream(out);
                 objectOut.writeObject(table);
                 objectOut.close();
                 out.close();
                 text.setText(null);
                }
               catch(Exception ee)
                {
                }
              }
          }
        else
          {
            
            String m=""+year+"年"+month+"月"+day+"无日志记录";
            JOptionPane.showMessageDialog(this,m,"提示",JOptionPane.WARNING_MESSAGE);
          }
   }

}
