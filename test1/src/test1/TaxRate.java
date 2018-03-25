package test1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField; 
public class TaxRate {
    public static void placeComponents(JPanel panel) {

        panel.setLayout(null);
     
        // 创建 JLabel
        JLabel preLabel = new JLabel("税前工资：");
        /* 定义了组件位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        preLabel.setBounds(10,20,80,25);
        panel.add(preLabel);

        /* 
         * 创建文本域用于用户输入税前工资
         */
        JTextField preTaxText = new JTextField(20);
        preTaxText.setBounds(100,20,160,25);
        panel.add(preTaxText);
        
        // 输出税后工资的文本域
        JLabel after1Label = new JLabel("税后月薪：");
        after1Label.setBounds(10,50,80,25);
        panel.add(after1Label);

        /* 
         *创建文本域用于输出税后工资
         */
        JTextField after1TaxText = new JTextField(20);
        after1TaxText.setEditable(false);
        after1TaxText.setBounds(100,50,160,25);
        panel.add(after1TaxText);

        // 输出应纳税额的文本域
        JLabel taxPayableLabel = new JLabel("应纳税额：");
        taxPayableLabel.setBounds(10,80,80,25);
        panel.add(taxPayableLabel);

        /* 
         *创建文本域用于输出应纳税额
         */
        JTextField taxPayableText = new JTextField(20);
        taxPayableText.setEditable(false);
        taxPayableText.setBounds(100,80,160,25);
        panel.add(taxPayableText);
        
        // 创建计算按钮
        JButton calculation = new JButton("计算");
        calculation.setBounds(260, 20, 80, 25);
        panel.add(calculation);
        
        //创建清空按钮
        JButton empty = new JButton("清空");
        empty.setBounds(350, 20, 80, 25);
        panel.add(empty);
        
        JLabel detailLabel = new JLabel("-----------------------------五险一金汇缴明细-----------------------------");
        detailLabel.setBounds(10,110,600,25);
        panel.add(detailLabel);
        
        // 输出个人应缴的文本域
        JLabel individualLabel = new JLabel("个人应缴部分：");
        individualLabel.setBounds(80,130,110,25);
        panel.add(individualLabel);
        
        // 输出单位应缴的文本域
        JLabel unitLabel = new JLabel("单位应缴部分：");
        unitLabel.setBounds(380,130,110,25);
        panel.add(unitLabel);
        
        // 输出养老保险金的文本域
        JLabel oldAgeLabel = new JLabel("养老保险金：");
        oldAgeLabel.setBounds(10,160,80,25);
        panel.add(oldAgeLabel);

        /* 
         *创建文本域用于输出个人应缴养老保险金
         */
        JTextField oldAgeText = new JTextField(20);
        oldAgeText.setEditable(false);
        oldAgeText.setBounds(150,160,100,25);
        panel.add(oldAgeText);
        
        //输出养老保险金的个人应缴百分比
        JLabel oldPercentLabel = new JLabel("(8%)");
        oldPercentLabel.setBounds(250,160,80,25);
        panel.add(oldPercentLabel);
        
        /* 
         *创建文本域用于输出单位应缴养老保险金
         */
        JTextField unitOldAgeText = new JTextField(20);
        unitOldAgeText.setEditable(false);
        unitOldAgeText.setBounds(373,160,100,25);
        panel.add(unitOldAgeText);
        
        //输出养老保险金的单位应缴百分比
        JLabel unitOldAgePercentLabel = new JLabel("(19%)");
        unitOldAgePercentLabel.setBounds(473,160,80,25);
        panel.add(unitOldAgePercentLabel);
        
        // 输出医疗保险金的文本域
        JLabel medicalLabel = new JLabel("医疗保险金：");
        medicalLabel.setBounds(10,190,80,25);
        panel.add(medicalLabel);

        /* 
         *创建文本域用于输出医疗保险金
         */
        JTextField medicalText = new JTextField(20);
        medicalText.setEditable(false);
        medicalText.setBounds(150,190,100,25);
        panel.add(medicalText);
        
        //输出医疗保险金个人应缴百分比
        JLabel medicalPercentLabel = new JLabel("(2%)");
        medicalPercentLabel.setBounds(250,190,80,25);
        panel.add(medicalPercentLabel);
        
        /* 
         *创建文本域用于输出单位应缴医疗保险金
         */
        JTextField unitMedicalText = new JTextField(20);
        unitMedicalText.setEditable(false);
        unitMedicalText.setBounds(373,190,100,25);
        panel.add(unitMedicalText);
        
        //输出医疗保险金的单位应缴百分比
        JLabel unitMedicalPercentLabel = new JLabel("(10%)");
        unitMedicalPercentLabel.setBounds(473,190,80,25);
        panel.add(unitMedicalPercentLabel);
        
        // 输出失业保险金的文本域
        JLabel unemploymentLabel = new JLabel("失业保险金：");
        unemploymentLabel.setBounds(10,220,80,25);
        panel.add(unemploymentLabel);

        /* 
         *创建文本域用于输出失业保险金
         */
        JTextField unemploymentText = new JTextField(20);
        unemploymentText.setEditable(false);
        unemploymentText.setBounds(150,220,100,25);
        panel.add(unemploymentText);
        
        //输出失业保险金个人应缴百分比
        JLabel unemploymentPercentLabel = new JLabel("(0.2%)");
        unemploymentPercentLabel.setBounds(250,220,80,25);
        panel.add(unemploymentPercentLabel);
        
        /* 
         *创建文本域用于输出单位应缴失业保险金
         */
        JTextField unitUnemploymentText = new JTextField(20);
        unitUnemploymentText.setEditable(false);
        unitUnemploymentText.setBounds(373,220,100,25);
        panel.add(unitUnemploymentText);
        
        //输出失业保险金的单位应缴百分比
        JLabel unitUnemploymentPercentLabel = new JLabel("(0.8%)");
        unitUnemploymentPercentLabel.setBounds(473,220,80,25);
        panel.add(unitUnemploymentPercentLabel);
        
        // 输出工伤保险金的文本域
        JLabel inductrialInjuryLabel = new JLabel("工伤保险金：");
        inductrialInjuryLabel.setBounds(10,250,80,25);
        panel.add(inductrialInjuryLabel);

        /* 
         *创建文本域用于输出工伤保险金
         */
        JTextField inductrialInjuryText = new JTextField(20);
        inductrialInjuryText.setEditable(false);
        inductrialInjuryText.setBounds(150,250,100,25);
        panel.add(inductrialInjuryText);
        
        //输出工伤保险金的个人应缴百分比
        JLabel inductrialInjuryPercentLabel = new JLabel("(0%)");
        inductrialInjuryPercentLabel.setBounds(250,250,80,25);
        panel.add(inductrialInjuryPercentLabel);
        /* 
         *创建文本域用于输出单位应缴工伤保险金
         */
        JTextField unitInductrialInjuryText = new JTextField(20);
        unitInductrialInjuryText.setEditable(false);
        unitInductrialInjuryText.setBounds(373,250,100,25);
        panel.add(unitInductrialInjuryText);
        
        //输出工伤保险金的单位应缴百分比
        JLabel unitInductrialInjuryPercentLabel = new JLabel("(0.4%)");
        unitInductrialInjuryPercentLabel.setBounds(473,250,80,25);
        panel.add(unitInductrialInjuryPercentLabel);
        
        // 输出生育保险金的文本域
        JLabel procreationLabel = new JLabel("生育保险金：");
        procreationLabel.setBounds(10,280,80,25);
        panel.add(procreationLabel);

        /* 
         *创建文本域用于输出生育保险金
         */
        JTextField procreationText = new JTextField(20);
        procreationText.setEditable(false);
        procreationText.setBounds(150,280,100,25);
        panel.add(procreationText);
        
        //输出生育保险金的单个人应缴百分比
        JLabel procreationPercentLabel = new JLabel("(0%)");
        procreationPercentLabel.setBounds(250,280,80,25);
        panel.add(procreationPercentLabel);
        
        /* 
         *创建文本域用于输出单位应缴生育保险金
         */
        JTextField unitProcreationText = new JTextField(20);
        unitProcreationText.setEditable(false);
        unitProcreationText.setBounds(373,280,100,25);
        panel.add(unitProcreationText);
        
        //输出生育保险金的单位应缴百分比
        JLabel unitProcreationPercentLabel = new JLabel("(0.8%)");
        unitProcreationPercentLabel.setBounds(473,280,80,25);
        panel.add(unitProcreationPercentLabel);
        
        // 输出基本住房公积金的文本域
        JLabel basicHousingLabel = new JLabel("基本住房公积金：");
        basicHousingLabel.setBounds(10,310,120,25);
        panel.add(basicHousingLabel);
        
        /* 
         *创建文本域用于输出基本住房公积金
         */
        JTextField basicHousingText = new JTextField(20);
        basicHousingText.setEditable(false);
        basicHousingText.setBounds(150,310,100,25);
        panel.add(basicHousingText);
        
        //输出基本住房公积金个人应缴百分比
        JLabel basicPercentLabel = new JLabel("(12%)");
        basicPercentLabel.setBounds(250,310,80,25);
        panel.add(basicPercentLabel);
        
        /* 
         *创建文本域用于输出单位应缴基本住房公积金
         */
        JTextField unitBasicText = new JTextField(20);
        unitBasicText.setEditable(false);
        unitBasicText.setBounds(373,310,100,25);
        panel.add(unitBasicText);
        
        //输出基本住房公积金的单位应缴百分比
        JLabel unitBasicPercentLabel = new JLabel("(12%)");
        unitBasicPercentLabel.setBounds(473,310,80,25);
        panel.add(unitBasicPercentLabel);
        
    		// 输出补充住房公积金的文本域
        JLabel replenishmentHousingLabel = new JLabel("补充住房公积金：");
        replenishmentHousingLabel.setBounds(10,340,120,25);
        panel.add(replenishmentHousingLabel);

        /* 
         *创建文本域用于输出补充住房公积金
         */
        JTextField replenishmentHousingText = new JTextField(20);
        replenishmentHousingText.setEditable(false);
        replenishmentHousingText.setBounds(150,340,100,25);
        panel.add(replenishmentHousingText);
        
        //输出补充住房公积金个人应缴百分比
        JLabel replenishmentPercentLabel = new JLabel("(0%)");
        replenishmentPercentLabel.setBounds(250,340,80,25);
        panel.add(replenishmentPercentLabel);
        
        /* 
         *创建文本域用于输出单位应缴补充住房公积金
         */
        JTextField unitReplenishmentText = new JTextField(20);
        unitReplenishmentText.setEditable(false);
        unitReplenishmentText.setBounds(373,340,100,25);
        panel.add(unitReplenishmentText);
        
        //输出补充住房公积金的单位应缴百分比
        JLabel unitReplenishmentPercentLabel = new JLabel("(0%)");
        unitReplenishmentPercentLabel.setBounds(473,340,80,25);
        panel.add(unitReplenishmentPercentLabel);
        
        // 输出共计支出的文本域
        JLabel totalSpendingLabel = new JLabel("共计支出：");
        totalSpendingLabel.setBounds(10,370,120,25);
        panel.add(totalSpendingLabel);

        /* 
         *创建文本域用于输出共计支出
         */
        JTextField totalSpendingText = new JTextField(20);
        totalSpendingText.setEditable(false);
        totalSpendingText.setBounds(150,370,100,25);
        panel.add(totalSpendingText);
        
        /* 
         *创建文本域用于输出单位共计支出
         */
        JTextField unitTotalSpendingText = new JTextField(20);
        unitTotalSpendingText.setEditable(false);
        unitTotalSpendingText.setBounds(373,370,100,25);
        panel.add(unitTotalSpendingText);
        
        // 输出扣除五险一金后月薪的文本域
        JLabel deductLabel = new JLabel("扣除五险一金后月薪：");
        deductLabel.setBounds(10,400,180,25);
        panel.add(deductLabel);

        /* 
         *创建文本域用于输出扣除五险一金后月薪
         */
        JTextField deductText = new JTextField(20);
        deductText.setEditable(false);
        deductText.setBounds(150,400,100,25);
        panel.add(deductText);
        
        // 输出个人所得税的文本域
        JLabel taxLabel = new JLabel("个人所得税：");
        taxLabel.setBounds(10,430,180,25);
        panel.add(taxLabel);

        /* 
         *创建文本域用于输出个人所得税
         */
        JTextField taxText = new JTextField(20);
        taxText.setEditable(false);
        taxText.setBounds(150,430,100,25);
        panel.add(taxText);
        
        // 输出个人所得税的文本域
        JLabel after2Label = new JLabel("税后月薪：");
        after2Label.setBounds(10,460,180,25);
        panel.add(after2Label);

        /* 
         *创建文本域用于输出个人所得税
         */
        JTextField after2TaxText = new JTextField(20);
        after2TaxText.setEditable(false);
        after2TaxText.setBounds(150,460,100,25);
        panel.add(after2TaxText);
        
        //给清空按钮添加单击事件
        empty.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				preTaxText.setText("");
				after1TaxText.setText("");
				taxPayableText.setText("");
				
				oldAgeText.setText("");
				medicalText.setText("");
				unemploymentText.setText("");
				inductrialInjuryText.setText("");
				procreationText.setText("");
				basicHousingText.setText("");
				replenishmentHousingText.setText("");
				totalSpendingText.setText("");
				deductText.setText("");
				taxText.setText("");
				after2TaxText.setText("");
				
				unitOldAgeText.setText("");
				unitMedicalText.setText("");
				unitUnemploymentText.setText("");
				unitInductrialInjuryText.setText("");
				unitProcreationText.setText("");
				unitBasicText.setText("");
				unitReplenishmentText.setText("");
				unitTotalSpendingText.setText("");
			}
        });
        //给计算按钮添加单击事件
        calculation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculation();
            }
			private void calculation() {
				//获取税前工资，字符串类型
				String preTax = preTaxText.getText();
				try {
					//用户在正确输入工资时计算
					if(preTax!= null && preTax != "" && Double.parseDouble(preTax)>0) {
						//将字符串类型的税前工资转化为浮点型类型
						double pre = Double.parseDouble(preTax);
						//汇缴养老、医疗、失业、工伤、生育保险金，基本住房公积金，补充住房公积金
						//个人应缴养老保险金
						double pension = pre*0.08;
						//单位应缴养老保险金
						double pension2 = pre*0.19;
						//设置个人应缴养老保险金的下限和上限，并显示到对应的文本域中
						if(pension<=246.56) {
							pension=246.56;
							oldAgeText.setText(pension+"");
						}else if(pension>=1849.44) {
							pension=1849.44;
							oldAgeText.setText(pension+"");
						}
						//将个人应缴养老保险金四舍五入到小数点后两位，并显示到对应的文本域中
						oldAgeText.setText(String.format("%.2f",pension));
						//设置单位应缴养老保险金的下限和上限，并显示到对应的文本域中
						if(pension2<=585.58) {
							pension2=585.58;
							unitOldAgeText.setText(pension2+"");
						}else if(pension2>=4392.42) {
							pension2=4392.42;
							unitOldAgeText.setText(pension2+"");
						}
						//将单位应缴养老保险金四舍五入到小数点后两位，并显示到对应的文本域中
						unitOldAgeText.setText(String.format("%.2f", pension2));
						
						//个人应缴医疗保险金
						double medicalCare = pre*0.02;
						//单位应缴医疗保险金
						double medicalCare2 = pre*0.1;
						//设置个人应缴医疗保险金的下限和上限，并显示到对应的文本域中
						if(medicalCare<=61.64) {
							medicalCare=61.64;
							medicalText.setText(medicalCare+"");
						}else if(medicalCare>=462.36) {
							medicalCare=462.36;
							medicalText.setText(medicalCare+"");
						}
						//将个人应缴医疗保险金四舍五入到小数点后两位，并显示到对应的文本域中
						medicalText.setText(String.format("%.2f",medicalCare));
						//设置单位应缴医疗保险金的下限和上限，并显示到对应到文本域中
						if(medicalCare2<=308.20) {
							medicalCare2=308.20;
							unitMedicalText.setText(medicalCare2+"");
						}else if(medicalCare2>=2311.80) {
							medicalCare2=2311.80;
							unitMedicalText.setText(medicalCare2+"");
						}
						//将单位应缴医疗保险金四舍五入到小数点后两位，并显示到对应的文本域中
						unitMedicalText.setText(String.format("%.2f",medicalCare2));
						
						//个人应缴失业保险金
						double unemployment = pre*0.002;
						//单位应缴失业保险金
						double unemployment2 = pre*0.008;
						//设置个人应缴失业保险金的下限和上限，并显示到对应的文本域中
						if(unemployment<=6.16) {
							unemployment=6.16;
							unemploymentText.setText(unemployment+"");
						}else if(unemployment>=46.24) {
							unemployment=46.24;
							unemploymentText.setText(unemployment+"");
						}
						//将个人应缴失业保险金四舍五入到小数点后两位，并显示到对应的文本域中
						unemploymentText.setText(String.format("%.2f",unemployment));
						//设置单位应缴失业保险金的下限和上限，并显示到对应的文本域中
						if(unemployment2<=24.66) {
							unemployment2=24.66;
							unitUnemploymentText.setText(unemployment2+"");
						}else if(unemployment2>=184.94) {
							unemployment2=184.94;
							unitUnemploymentText.setText(unemployment2+"");
						}
						//将单位应缴失业保险金四舍五入到小数点后两位，并显示到对应的文本域中
						unitUnemploymentText.setText(String.format("%.2f",unemployment2));
						
						//个人应缴基本住房公积金
						double housing = pre*0.12;
						//单位应缴基本住房公积金
						double housing2 = pre*0.12;
						//设置个人应缴基本住房公积金的下限和上限，并显示到对应到文本域中
						if(housing<=257.76) {
							housing=257.76;
							basicHousingText.setText(housing+"");
						}else if(housing>=2774.16) {
							housing=2774.16;
							basicHousingText.setText(housing+"");
						}
						//将个人应缴基本住房公积金四舍五入到小数点后两位，并显示到对应到文本域中
						basicHousingText.setText(String.format("%.2f",housing));
						//设置单位应缴基本住房公积金到下限和上限，并显示到对应到文本域中
						if(housing2<=257.76) {
							housing2=257.76;
							unitBasicText.setText(housing2+"");
						}else if(housing2>=2774.16) {
							housing2=2774.16;
							unitBasicText.setText(housing2+"");
						}
						//将单位应缴基本住房公积金四舍五入到小数点后两位，并显示到对应到文本域中
						unitBasicText.setText(String.format("%.2f",housing2));
						
						//设置个人应缴工伤保险金到对应的文本域中
						inductrialInjuryText.setText("0.00");
						//单位应缴工伤保险金
						double inductrialInjury = pre*0.004;
						//设置单位应缴工伤保险金的下限和上限，并显示到对应到文本域中
						if(inductrialInjury<=12.33) {
							inductrialInjury=12.33;
							unitInductrialInjuryText.setText(inductrialInjury+"");
						}else if(inductrialInjury>=92.47) {
							inductrialInjury=92.47;
							unitInductrialInjuryText.setText(inductrialInjury+"");
						}
						//将单位应缴工伤保险金四舍五入到小数点后两位，并显示到对应的文本域中
						unitInductrialInjuryText.setText(String.format("%.2f",inductrialInjury));
						//设置个人应缴生育保险金到对应的文本域中
						procreationText.setText("0.00");
						//单位应缴生育保险金
						double procreation = pre*0.008;
						//设置单位应缴生育保险金的下限和上限，并显示到对应的文本域中
						if(procreation<=24.66){
							procreation=24.66;
							unitProcreationText.setText(procreation+"");
						}else if(procreation>=184.94){
							procreation=184.94;
							unitProcreationText.setText(procreation+"");
						}
						//将单位应缴生育保险金四舍五入到小数点后两位，并显示到对应的文本框
						unitProcreationText.setText(String.format("%.2f", procreation));
						
						//设置个人应缴补充住房公积金到对应到文本域中
						replenishmentHousingText.setText("0.00");
						//单位应缴补充住房公积金
						unitReplenishmentText.setText("0.00");
						//获取单位总支出
						double unitTotal = pension2+medicalCare2+unemployment2+housing2+inductrialInjury+procreation;
						//设置单位总支出到对应的文本域中
						unitTotalSpendingText.setText(String.format("%.2f",unitTotal));
						
						//获取扣除五险一金以及减去起征点后的工资，以此判断薪水范围来计算对应的应纳税额以及税后工资
						double afterReduction = pre - pension - medicalCare - unemployment - housing - 3500;
						//计算五险一金共计支出
						double total = pension+medicalCare+unemployment+housing;
						//将五险一金共计支出显示到文本域中，保留小数点后两位
						totalSpendingText.setText(String.format("%.2f", total));
						//计算扣除五险一金后月薪
						double deduct = pre-total;
						//将扣除后的月薪显示到文本域中，保留小数点后两位
						deductText.setText(String.format("%.2f", deduct));
						
						//对扣除五险一金后且高于起征点3500元的工资进行计算税后工资
						if(afterReduction>0) {
							//计算税后月薪
							//获取应纳税额
							double taxPayable = payable(afterReduction);
							//获取税后工资
							double after = pre-taxPayable-total;
							//将税后工资显示到文本域中，保留小数点后两位
							after1TaxText.setText(String.format("%.2f", after));
							after2TaxText.setText(String.format("%.2f", after));
							//将应纳税额显示到应纳税额文本域中，保留小数点后两位
							taxPayableText.setText(String.format("%.2f", taxPayable));
							//将个人所得税显示到个人所得税文本域中，保留小数点后两位
							taxText.setText(String.format("%.2f", taxPayable));
						}else {
							//不需要纳税的给予提示，保留小数点后两位
							after1TaxText.setText(String.format("%.2f", afterReduction+3500)+" 扣除五险一金后");
							taxPayableText.setText("您无需纳税");
							//设置应纳税额为0
							taxText.setText("0");
							//设置税后工资
							after2TaxText.setText(String.format("%.2f", pre-total));
						}
					}else {
						//用户输入负数，给予提示，并将所有数据都清空
						after1TaxText.setText("请输入正确的工资");
						taxPayableText.setText("0");
						empty();
					}
				} catch (Exception e) {
					//用户未输入正确的工资后显示，并将所有数据清空
					after1TaxText.setText("请输入工资");
					taxPayableText.setText("无");
					empty();
				}
			}
			public void empty() {
				oldAgeText.setText("");
				medicalText.setText("");
				unemploymentText.setText("");
				inductrialInjuryText.setText("");
				procreationText.setText("");
				basicHousingText.setText("");
				replenishmentHousingText.setText("");
				totalSpendingText.setText("");
				deductText.setText("");
				taxText.setText("");
				after2TaxText.setText("");
				
				unitOldAgeText.setText("");
				unitMedicalText.setText("");
				unitUnemploymentText.setText("");
				unitInductrialInjuryText.setText("");
				unitProcreationText.setText("");
				unitBasicText.setText("");
				unitReplenishmentText.setText("");
				unitTotalSpendingText.setText("");
			}
        });
    }

    public static double payable(double afterReduction) {
    		//应纳税额
    		double taxPayable = 0;
    		//根据薪水计算应纳税额
    		if(afterReduction<1500) {
    			taxPayable = afterReduction*0.03;
    		}else if(afterReduction<4500) {
    			taxPayable = afterReduction*0.1-105;
    		}else if(afterReduction<9000) {
    			taxPayable = afterReduction*0.2-555;
    		}else if(afterReduction<35000) {
    			taxPayable = afterReduction*0.25-1005;
    		}else if(afterReduction<55000) {
    			taxPayable = afterReduction*0.3-2755;
    		}else if(afterReduction<80000) {
    			taxPayable = afterReduction*0.35-5505;
    		}else {
    			taxPayable = afterReduction*0.45-13505;
    		}
		//将应纳税额返回
    		return taxPayable;
    }
}
