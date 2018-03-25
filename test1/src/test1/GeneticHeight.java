    package test1; 
      
    import javax.swing.*;  
    import javax.swing.border.EmptyBorder;  
      
    import java.awt.*;  
    import java.awt.event.*;  
    import java.text.DecimalFormat;  
    import java.util.regex.*;  
      
      
    public class GeneticHeight extends JFrame {       
        private static final long serialVersionUID = 1L;  
        private JPanel contentPane;  
        private JLabel titleLabel;  
        private JPanel contentPanel;  
        private JButton submitButton;  
        private ButtonGroup bg;  
        private JPanel sexPanel;  
        
        private JRadioButton BoyRadio;  
        private JRadioButton GirlRadio;  
        
        private JPanel whPanel;  
        private JLabel heightLabel;  
        private JLabel weightLabel;  
        private JTextField heightText;  
        private JTextField weightText;  
        private JPanel consolePanel;  
        private JLabel consoleLabel;  
        private JTextField consoleText;  
          
        private double fatherh;   
        private double motherh;  
        private double height;  
          
        /** 
         * Launch the application. 
         */  
     
      
        /** 
         * Create the frame. 
         */  
        public GeneticHeight() {  
        	super();
            setTitle("遗传身高");  
            
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            setBounds(100, 100, 600,450);  

           
            
            JMenuBar mb = new JMenuBar();//创建菜单栏
    		JMenu b1 = new JMenu("选项");
    		JMenu b2 = new JMenu("帮助");
    		JMenuItem c1 = new JMenuItem("主页");
    		JMenuItem c2 = new JMenuItem("BMI指数计算器");
    		JMenuItem c3 = new JMenuItem("About...");
    		setJMenuBar(mb);//添加菜单栏
    		mb.add(b1);
    		mb.add(b2);//添加菜单
    		b1.add(c2);
    		b1.add(c1);
    		b2.add(c3);
    		b1.setFont(new Font("宋体", Font.PLAIN, 17));
    		b2.setFont(new Font("宋体", Font.PLAIN, 17));
    		c1.addActionListener(new MenuItemListener());//监听简易计算器
    		c2.addActionListener(new MenuItemListener());//监听科学计算器
    		c3.addActionListener(new MenuItemListener());//监听关于
    		// 设置计算器的背景颜色
    		this.setBackground(Color.LIGHT_GRAY);
    		
            
            
            //主容器  
            contentPane = new JPanel();  
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  
            contentPane.setLayout(new BorderLayout(0, 0));  
            setContentPane(contentPane);  

        ImageIcon img = new ImageIcon("image\\height4.jpg");
   		JLabel imgLabel = new JLabel(img);
   		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
   		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
   		((JPanel)getContentPane()).setOpaque(false); 
   		
            //标题，主容器北  
            titleLabel = new JLabel("遗传身高计算器");  
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);  
            contentPane.add(titleLabel, BorderLayout.NORTH);  
            //存放选项的panel，主容器中  
            contentPanel = new JPanel();  
            
            contentPanel.setOpaque(false); 
            
            contentPanel.setLayout(new BorderLayout());  
            contentPane.add(contentPanel,BorderLayout.CENTER);  
            //提交按钮，主容器南  
            submitButton = new JButton("计算");  
            contentPane.add(submitButton, BorderLayout.SOUTH);  
              
            //存放性别选择的panel，选项北  
            bg = new ButtonGroup();  
            sexPanel = new JPanel();  
            
            sexPanel.setOpaque(false); 
            
            sexPanel.setLayout(new FlowLayout());  
            contentPanel.add(sexPanel,BorderLayout.NORTH);  
            
            BoyRadio = new JRadioButton("男生");  
            BoyRadio.setSelected(true);  
            
            GirlRadio = new JRadioButton("女生");  
          
            
            bg.add(BoyRadio);  
            bg.add(GirlRadio);  
            
            sexPanel.add(BoyRadio);  
            sexPanel.add(GirlRadio);  
           
            //存放身高体重的panel，选项中  
            whPanel = new JPanel();  
            
            whPanel.setOpaque(false); 
            
            whPanel.setLayout(new FlowLayout());  
            contentPanel.add(whPanel,BorderLayout.CENTER);  
            
            heightLabel = new JLabel("父亲身高（米/m）：");  
            weightLabel = new JLabel("母亲身高（米/m）：");  
            heightText = new JTextField(10);  
            heightText.setToolTipText("请输入身高");  
            weightText = new JTextField(10);  
            weightText.setToolTipText("请输入身高");  
            whPanel.add(heightLabel);  
            whPanel.add(heightText);  
            whPanel.add(weightLabel);  
            whPanel.add(weightText);  
            //结果  
            consolePanel = new JPanel();  
            
            consolePanel.setOpaque(false); 
            
            consolePanel.setLayout(new FlowLayout());  
            consoleLabel = new JLabel("你的遗传身高为：");  
            consoleText = new JTextField(28);  
            consoleText.setEditable(false);  
            consolePanel.add(consoleLabel);  
            consolePanel.add(consoleText);  
            contentPanel.add(consolePanel,BorderLayout.SOUTH);  
              
            submitButton.addActionListener(new ActionListener(){  
                public void actionPerformed(ActionEvent e) {  
                    String hstr = heightText.getText();  
                    String wstr = weightText.getText();  
                    Pattern pattern = Pattern.compile("^[0-9]+(.[0-9]+)?$");   
                    Matcher hisNum = pattern.matcher(hstr);  
                    Matcher wisNum = pattern.matcher(wstr);  
                    boolean acc = true;  
                    if( !hisNum.matches()|| !wisNum.matches()){  
                           acc = false;   
                    }   
                    if(acc)  
                    {  
                        fatherh = Double.parseDouble(hstr);  
                        motherh = Double.parseDouble(wstr); 
                        if(BoyRadio.isSelected())  
                        {  
                          height = (fatherh+motherh)*1.08/2;
                        }
                        else if (GirlRadio.isSelected()) 
                        {
                        	height=(fatherh*0.923+motherh)/2;
                        }
                        DecimalFormat df = new DecimalFormat("#.00");  
                                      
                        consoleText.setText("你的遗传身高为："+df.format(height)+"(米/m)");  
                    }  
                      
                }  
            });  
        }  
      
    }  