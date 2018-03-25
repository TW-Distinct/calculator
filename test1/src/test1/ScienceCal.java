package test1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;

public class ScienceCal extends JFrame implements ActionListener {
	private final String[] KEYS = {"←","CE","C","sin","cos","tan","lg","ln","e^x",
			"arcsin","arccos","arctan",
			"7", "8", "9", "+","x√y", "n!","4", "5", "6","-","x^2","3√x",
			 "1", "2", "3","*","x^y","√", "0","+/-",".","/","π","=", };
	//计算器上的功能键的显示名字 */ 
	private final String[] M = { " ", "MC", "MR", "MS", "M+" };
	//计算器上键的按钮 */
	 private JButton keys[] = new JButton[KEYS.length];
	
	// 计算器上的功能键的按钮 */
	private JTextField resultText = new JTextField("0");
	// 标志用户按的是否是整个表达式的第一个数字,或者是运算符后的第一个数字
	private boolean firstDigit = true;
	// 计算的中间结果。
	private double resultNum = 0.0;
	// 当前运算的运算符
	private String operator = "=";
	// 操作是否合法
	private boolean operateValidFlag = true;
	//设置精度，避免一些精度BUG（如cos60 = 0.5000000...1）的出现。
	DecimalFormat df = new DecimalFormat( "0.000000");  

	/**
	 * 构造函数
	 */
	public ScienceCal() {
		super();
		// 初始化计算器
		init();
		
		ImageIcon img = new ImageIcon("image\\blue2.jpg");
		JLabel imgLabel = new JLabel(img);
		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		((JPanel)getContentPane()).setOpaque(false); 
		
		JMenuBar mb = new JMenuBar();//创建菜单栏
		JMenu b1 = new JMenu("操作");
		JMenu b2 = new JMenu("帮助");
		JMenuItem c1 = new JMenuItem("主页");
		JMenuItem c2 = new JMenuItem("科学计算器");
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
		this.setTitle("科学计算器");
		// 在屏幕(300, 200)坐标处显示计算器
		this.setLocation(300, 200);
		
		// 不许修改计算器的大小
		this.setResizable(false);
		// 使计算器中各组件大小合适
		this.pack();
		//this.setVisible(true);
	}

	/**
	 * 初始化计算器
	 */
	private void init() {
		// 文本框中的内容采用右对齐方式
		resultText.setHorizontalAlignment(JTextField.RIGHT);
		// 不允许修改结果文本框
		resultText.setEditable(false);
		// 设置文本框背景颜色为白色
		resultText.setBackground(Color.white);

		// 初始化计算器上键的按钮，将键放在一个画板内
		JPanel calckeysPanel = new JPanel();
		
		calckeysPanel.setOpaque(false);
		
		// 用网格布局器，6行，6列的网格，网格之间的水平方向间隔为3个象素，垂直方向间隔为3个象素
		calckeysPanel.setLayout(new GridLayout(6, 6, 3, 3));
		for (int i = 0; i < KEYS.length; i++) {
			keys[i] = new JButton(KEYS[i]);
			calckeysPanel.add(keys[i]);
			keys[i].setForeground(Color.blue);
			keys[i].setBackground(Color.white);
			keys[i].setFont(new Font("宋体", Font.PLAIN, 17));
		}
		// 运算符键用红色标示，其他键用蓝色表示
		keys[20].setForeground(Color.black);
		keys[18].setForeground(Color.black);
		keys[19].setForeground(Color.black);
		keys[12].setForeground(Color.black);
		keys[13].setForeground(Color.black);
		keys[14].setForeground(Color.black);
		keys[24].setForeground(Color.black);
		keys[25].setForeground(Color.black);
		keys[26].setForeground(Color.black);
		
		keys[20].setBackground(Color.white);
		keys[18].setBackground(Color.white);
		keys[19].setBackground(Color.white);
		keys[12].setBackground(Color.white);
		keys[13].setBackground(Color.white);
		keys[14].setBackground(Color.white);
		keys[24].setBackground(Color.white);
		keys[25].setBackground(Color.white);
		keys[26].setBackground(Color.white);


	

		// 下面进行计算器的整体布局，将calckeys和command画板放在计算器的中部，
		// 将文本框放在北部，将calms画板放在计算器的西部。

		// 新建一个大的画板，将上面建立的command和calckeys画板放在该画板内
		JPanel panel1 = new JPanel();
		panel1.setOpaque(false);
		// 画板采用边界布局管理器，画板里组件之间的水平和垂直方向上间隔都为3象素
		panel1.add( calckeysPanel);

		// 建立一个画板放文本框
		JPanel top = new JPanel();
		top.setOpaque(false);
		top.setLayout(new BorderLayout());
		top.add("Center", resultText);

		// 整体布局
		getContentPane().add("North", top);
		getContentPane().add("Center", panel1);
		for (int i = 0; i < KEYS.length; i++) {
			keys[i].addActionListener(this);
		}
	}

	/**
	 * 处理事件
	 */
	public void actionPerformed(ActionEvent e) {
		// 获取事件源的标签
		String label = e.getActionCommand();
		if (label.equals("←")) {
			// 用户按了"←"键
			handleBackspace();
		} else if (label.equals("CE")) {
			// 用户按了"CE"键
			resultText.setText("0");
		} else if (label.equals("C")) {
			// 用户按了"C"键
			handleC();
		} else if ("0123456789.".indexOf(label) >= 0) {
			// 用户按了数字键或者小数点键
			handleNumber(label);
			// handlezero(zero);
		} else {
			// 用户按了运算符键
			handleOperator(label);
		}
	}

	/**
	 * 处理←键被按下的事件
	 */
	private void handleBackspace() {
		String text = resultText.getText();
		int i = text.length();
		if (i > 0) {
			// 退格，将文本最后一个字符去掉
			text = text.substring(0, i - 1);
			if (text.length() == 0) {
				// 如果文本没有了内容，则初始化计算器的各种值
				resultText.setText("0");
				firstDigit = true;
				operator = "=";
			} else {
				// 显示新的文本
				resultText.setText(text);
			}
		}
	}

	/**
	 * 处理数字键被按下的事件
	 * 
	 * @param key
	 */
	private void handleNumber(String key) {
		if (firstDigit) {
			// 输入的第一个数字
			resultText.setText(key);
		} else if ((key.equals(".")) && (resultText.getText().indexOf(".") < 0)) {
			// 输入的是小数点，并且之前没有小数点，则将小数点附在结果文本框的后面
			resultText.setText(resultText.getText() + ".");
		} else if (!key.equals(".")) {
			// 如果输入的不是小数点，则将数字附在结果文本框的后面
			resultText.setText(resultText.getText() + key);
		}
		// 以后输入的肯定不是第一个数字了
		firstDigit = false;
	}

	/**
	 * 处理C键被按下的事件
	 */
	private void handleC() {
		// 初始化计算器的各种值
		resultText.setText("0");
		firstDigit = true;
		operator = "=";
	}

	/**
	 * 处理运算符键被按下的事件
	 * 
	 * @param key
	 */
	private void handleOperator(String key) {
		if (operator.equals("/")) {
			// 除法运算
			// 如果当前结果文本框中的值等于0
			if (getNumberFromText() == 0.0) {
				// 操作不合法
				operateValidFlag = false;
				resultText.setText("除数不能为零");
			} else {
				resultNum /= getNumberFromText();
			}
		} else if (operator.equals("1/x")) {
			// 倒数运算
			if (resultNum == 0.0) {
				// 操作不合法
				operateValidFlag = false;
				resultText.setText("零没有倒数");
			} else {
				resultNum = 1 / resultNum;
			}
		} else if (operator.equals("+")) {
			// 加法运算
			resultNum += getNumberFromText();
		} else if (operator.equals("-")) {
			// 减法运算
			resultNum -= getNumberFromText();
		} else if (operator.equals("*")) {
			// 乘法运算
			resultNum *= getNumberFromText();
		} else if (operator.equals("√")) {
			
			// 平方根运算
			resultNum = Math.sqrt(resultNum);
		} else if (operator.equals("%")) {
			// 百分号运算，除以100
			resultNum = resultNum / 100;
		} else if (operator.equals("+/-")) {
			// 正数负数运算
			resultNum = resultNum * (-1);
		}
		else if (operator.equals("sin")) {
			// sin运算
			resultNum = Double.parseDouble(df.format(Math.sin(Math.toRadians(getNumberFromText()))));
		}
		else if (operator.equals("cos")) {
			// cos运算
			resultNum = Double.parseDouble(df.format(Math.cos(Math.toRadians(getNumberFromText()))));
		}
		else if (operator.equals("tan")) {
			// tan运算
			resultNum = Double.parseDouble(df.format(Math.tan(Math.toRadians(getNumberFromText()))));
		}
		else if (operator.equals("x^2")) {
			// 平方运算
			resultNum = Double.parseDouble(df.format(Math.pow(resultNum,2)));
		}
		else if (operator.equals("3√x")) {
			// 立方运算
			resultNum = Math.cbrt(resultNum);
			
		}
		
		else if (operator.equals("x^y")) {
			// 次方运算
			resultNum = Math.pow(resultNum,getNumberFromText());
		}
		else if (operator.equals("e^x")) {
			// 次方运算
			resultNum = Math.pow(Math.E,getNumberFromText());
		}
		else if (operator.equals("ln")) {
			// ln运算
			resultNum = Math.log(resultNum);
		}
		else if (operator.equals("lg")) {
			// lg运算
			resultNum = Math.log10(resultNum);
		}
		else if (operator.equals("arcsin")) {
			// 反正弦运算 Math.asin返回的是弧度 需要转化为角度
			//.format返回的是String,需要调用Double.parseDouble()方法转化为double类型

			resultNum = Double.parseDouble(df.format(Math.asin(resultNum)/Math.PI*180));
			
		}
		else if (operator.equals("arccos")) {
			// 反余弦运算
			resultNum = Double.parseDouble(df.format(Math.acos(resultNum)/Math.PI*180));
		}
		else if (operator.equals("arctan")) {
			// 反正切运算
			resultNum = Double.parseDouble(df.format(Math.atan(resultNum)/Math.PI*180));
		}
		else if (operator.equals("x√y")) {
			// 
			resultNum = Math.pow(resultNum,1/getNumberFromText());
		}
		else if(operator.equals("n!")){
			resultNum = func(resultNum);
		}
		else if(operator.equals("π")){
			resultNum = Math.PI;
		}
		
		else if (operator.equals("=")) {
			// 赋值运算
			resultNum = getNumberFromText();
		}
		if (operateValidFlag) {
			// 双精度浮点数的运算
			long t1;
			double t2;
			t1 = (long) resultNum;
			t2 = resultNum - t1;
			if (t2 == 0) {
				resultText.setText(String.valueOf(t1));
			} else {
				resultText.setText(String.valueOf(resultNum));
			}
		}
		// 运算符等于用户按的按钮
		operator = key;
		firstDigit = true;
		operateValidFlag = true;
	}

	/**
	 * 从结果文本框中获取数字
	 * 
	 * @return
	 */
	private double getNumberFromText() {
		double result = 0;
		try {
			result = Double.valueOf(resultText.getText()).doubleValue();
		} catch (NumberFormatException e) {
		}
		return result;
	}
	private int func(double d){
		int result=1;
		for(int i=2;i<=d;++i)
			result*=i;
		return result;
	}

	
}
