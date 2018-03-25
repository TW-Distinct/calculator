package test1;

import java.util.Calendar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Hashtable;
public class adult extends JFrame implements MouseListener
{
   int year,month,day;
   Hashtable hashtable;  ////用来保存日志的散列表           
   File file;            ////保存散列表的文件           
   JTextField showDay[]; ////显示日期的文本条数组            
   JLabel title[];       ////日历牌的星期标题            
   Calendar 日历;
   int 星期几; 
   NotePad notepad=null;             
   Month 负责改变月;
   Year  负责改变年;
   String 星期[]={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
   JPanel leftPanel,rightPanel;    ////左面日历右面记事本
  public  adult(int year,int month,int day)
   { 
     leftPanel=new JPanel();
     JPanel leftCenter=new JPanel();
     JPanel leftNorth=new JPanel();
     leftCenter.setLayout(new GridLayout(7,7));////////////第一行显示星期标题的标签，后六行显示日期标签
         
     JMenuBar mb = new JMenuBar();// 创建菜单栏
		JMenu b1 = new JMenu("选项");
		JMenu b2 = new JMenu("帮助");
		JMenuItem c1 = new JMenuItem("主页");
		JMenuItem c2 = new JMenuItem("贷款还款金额的计算");
		JMenuItem c4 = new JMenuItem("汇率换算");
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
		c1.addActionListener(new MenuItemListener());// 
		c2.addActionListener(new MenuItemListener());// 
		c4.addActionListener(new MenuItemListener());// 
		c3.addActionListener(new MenuItemListener());// 
		// 设置计算器的背景颜色
		this.setBackground(Color.LIGHT_GRAY);
		this.setTitle("日历记事本");
		
		/*this.pack();*这个是适合屏幕的宽度，达不到自己设置的目的/
		// this.setVisible(true);*/
                                                  
     rightPanel=new JPanel();
     this.year=year;
     this.month=month;
     this.day=day;
     负责改变年=new Year(this);
     负责改变年.setYear(year);
     负责改变月=new Month(this);
     负责改变月.setMonth(month);
  
     title=new JLabel[7];            /////显示星期标题的标签             
     showDay=new JTextField[42];     ////  显示日期标题的标签            
     for(int j=0;j<7;j++)                         
       {
         title[j]=new JLabel();
         title[j].setText(星期[j]);
         title[j].setBorder(BorderFactory.createRaisedBevelBorder());
         leftCenter.add(title[j]);
       } 
     title[0].setForeground(Color.red);
     title[6].setForeground(Color.blue);

     for(int i=0;i<42;i++)                        
       {
         showDay[i]=new JTextField();
         showDay[i].addMouseListener(this);
         showDay[i].setEditable(false);
         leftCenter.add(showDay[i]);
       }
         
     日历=Calendar.getInstance();
     Box box=Box.createHorizontalBox(); ////日历牌最上方创建一个水平BOX容器，从左向右显示年月         
     box.add(负责改变年);
     box.add(负责改变月);
     leftNorth.add(box);
     leftPanel.setLayout(new BorderLayout());
     leftPanel.add(leftNorth,BorderLayout.NORTH);
     leftPanel.add(leftCenter,BorderLayout.CENTER);
     leftPanel.add(new Label("所查年份(负数表示公元前)"),
                  BorderLayout.SOUTH) ;
     leftPanel.validate();
     Container con=getContentPane();
     JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                     leftPanel,rightPanel);////组件分割
     
     con.add(split,BorderLayout.CENTER);
     con.validate();
    
     hashtable=new Hashtable();
     file=new File("日历记事本.txt");
      if(!file.exists())
      {
       try{
           FileOutputStream out=new FileOutputStream(file);
           ObjectOutputStream objectOut=new ObjectOutputStream(out);
           objectOut.writeObject(hashtable);
           objectOut.close();
           out.close();
          }
       catch(IOException e)
          {
          }
      } 
     notepad=new NotePad(this);    /////////////////////记事本对象                                  
     rightPanel.add(notepad);
     
     设置日历牌(year,month);
     addWindowListener(new WindowAdapter()
                    { public void windowClosing(WindowEvent e)
                       {
                         System.exit(0);
                       }
                    });
    
    setBounds(100,50,524,350);
    validate();
   }
  public void 设置日历牌(int year,int month)
   {
     日历.set(year,month-1,1);              
     ///日历翻到YEAR年MONTH月一日，0表示一月；
     星期几=日历.get(Calendar.DAY_OF_WEEK)-1;///计算当月一日是星期几，日返回1；六返回7
     if(month==1||month==3||month==5||month==7
                        ||month==8||month==10||month==12)
        {
            排列号码(星期几,31);         
        }
     else if(month==4||month==6||month==9||month==11)
        {
            排列号码(星期几,30);
        }
     else if(month==2)
        {
         if((year%4==0&&year%100!=0)||(year%400==0))  
           {
             排列号码(星期几,29);
           }
         else
           {
             排列号码(星期几,28);
           }
       }
   } 
  public void 排列号码(int 星期几,int 月天数)
   {
      for(int i=星期几,n=1;i<星期几+月天数;i++)
             {
               showDay[i].setText(""+n);
               if(n==day)
                 {
                   showDay[i].setForeground(Color.green); 
                   showDay[i].setFont(new Font("TimesRoman",Font.BOLD,20));
                 }
               else
                 { 
                  showDay[i].setFont(new Font("TimesRoman",Font.BOLD,12));
                  showDay[i].setForeground(Color.black);
                 }
               if(i%7==6)
                 {
                  showDay[i].setForeground(Color.blue);  
                 }
               if(i%7==0)
                 {
                  showDay[i].setForeground(Color.red);  
                 }
               n++; 
             }
       for(int i=0;i<星期几;i++)
             {
                showDay[i].setText("");
             }
       for(int i=星期几+月天数;i<42;i++)
             {
                showDay[i].setText("");
             }
   }
 public int getYear()
   {
    return year;
   } 
 public void setYear(int y)
   {
     year=y;
     notepad.setYear(year);
   }
 public int getMonth()
   {
    return month;
   }
 public void setMonth(int m)
   {
     month=m;
     notepad.setMonth(month); 
   }
 public int getDay()
   {
    return day;
   }
 public void setDay(int d)
   {
    day=d;
    notepad.setDay(day);
   }
 public Hashtable getHashtable()
   {
     return hashtable;
   }
 public File getFile()
   {
     return file;
   }
 public void mousePressed(MouseEvent e)             /////响应鼠标事件
   {
     JTextField source=(JTextField)e.getSource();
     try{
         day=Integer.parseInt(source.getText());
         notepad.setDay(day);
         notepad.设置信息条(year,month,day);
         notepad.设置文本区(null);
         notepad.获取日志内容(year,month,day);
        } 
      catch(Exception ee)
        {
        }
   }
 public void mouseClicked(MouseEvent e)
   {
   }
 public void mouseReleased(MouseEvent e)
   {
   }
 public void mouseEntered(MouseEvent e)
   {
   }
 public void mouseExited(MouseEvent e)
   {
   }
 
 
}  
