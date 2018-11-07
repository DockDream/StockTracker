package code;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Point;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame {

	// attributes
	private JPanel contentPane;
	private JTextField display;
	private JTextField symbolText;
	private JTextField dayHighText;
	private JTextField dayLowText;
	private JTextField sevenDayHighText;
	private JTextField sevenDayLowText;
	private JTextField thirtyDayHighText;
	private JTextField thirtyDayLowText;
	private JTextField epsText;
	private JTextField growthRateText;
	private JTextField volatilityText;
	private JTextField peRatioText;
	private JTextField debtAssetText;
	private JTextField assetLiabilityText;
	
	String userExpression = "";
	String userFormula = "";
	private JTextField displayFormula;

	/**
	 * Start a calculator instance.
	 */
	public static void createCalculator() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator calcFrame = new Calculator();
					calcFrame.setVisible(true);
				} // end try
				
				catch (Exception e) {
					e.printStackTrace();
				} // end catch
			} // end run method
		}); // end EventQueue
	} // end createCalculator

	/**
	 * Create the frame.
	 */
	public Calculator() {
		// calculator colors
		Color background = new Color(1, 22, 39);
		Color redBtns = new Color(247, 23, 53);
		Color blueBtns = new Color(82, 235, 215);
		Color greyBtns = new Color(230, 232, 230);
		Color orangeBtns = new Color(255, 150, 0);
		Color displayColor = new Color(0, 250, 10);
		Color lightBtnText = new Color(255, 255, 250);
		Color darkBtnText = new Color (5, 0, 0);
		
		// Window
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Formula Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 60, 450, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(background );
		
		// Display field showing text entered and results
		display = new JTextField();
		display.setText("0");
		display.setBackground(displayColor);
		display.setEditable(false);
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setFont(new Font("Lucida Console", Font.BOLD, 22));
		display.setBounds(10, 89, 424, 29);
		contentPane.add(display);
		display.setColumns(10);
		
		// Buttons and Text fields
		JButton allClearBtn = new JButton("AC");
		allClearBtn.setBackground(redBtns);
		allClearBtn.setOpaque(true);
		allClearBtn.setForeground(lightBtnText);
		allClearBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		allClearBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		allClearBtn.setBounds(371, 129, 63, 29);
		contentPane.add(allClearBtn);
		
		JButton deleteBtn = new JButton("DEL");
		deleteBtn.setBackground(redBtns);
		deleteBtn.setOpaque(true);
		deleteBtn.setForeground(lightBtnText);
		deleteBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		deleteBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		deleteBtn.setBounds(298, 129, 63, 29);
		contentPane.add(deleteBtn);
		
		JButton rightParenBtn = new JButton(")");
		rightParenBtn.setBackground(greyBtns);
		rightParenBtn.setOpaque(true);
		rightParenBtn.setForeground(darkBtnText);
		rightParenBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		rightParenBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		rightParenBtn.setBounds(225, 129, 63, 29);
		contentPane.add(rightParenBtn);
		
		JButton leftParenBtn = new JButton("(");
		leftParenBtn.setBackground(greyBtns);
		leftParenBtn.setOpaque(true);
		leftParenBtn.setForeground(darkBtnText);
		leftParenBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		leftParenBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		leftParenBtn.setBounds(152, 129, 63, 29);
		contentPane.add(leftParenBtn);
		
		JButton dayHighBtn = new JButton("D H");
		dayHighBtn.setBackground(blueBtns);
		dayHighBtn.setOpaque(true);
		dayHighBtn.setForeground(darkBtnText);
		dayHighBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		dayHighBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		dayHighBtn.setBounds(10, 129, 63, 29);
		contentPane.add(dayHighBtn);
		
		JButton dayLowBtn = new JButton("D L");
		dayLowBtn.setBackground(blueBtns);
		dayLowBtn.setOpaque(true);
		dayLowBtn.setForeground(darkBtnText);
		dayLowBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		dayLowBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		dayLowBtn.setBounds(79, 129, 63, 29);
		contentPane.add(dayLowBtn);
		
		JButton sevenHighBtn = new JButton("7 H");
		sevenHighBtn.setBackground(blueBtns);
		sevenHighBtn.setOpaque(true);
		sevenHighBtn.setForeground(darkBtnText);
		sevenHighBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sevenHighBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		sevenHighBtn.setBounds(10, 169, 63, 29);
		contentPane.add(sevenHighBtn);
		
		JButton sevenLowBtn = new JButton("7 L");
		sevenLowBtn.setActionCommand("");
		sevenLowBtn.setOpaque(true);
		sevenLowBtn.setForeground(new Color(5, 0, 0));
		sevenLowBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sevenLowBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		sevenLowBtn.setBackground(new Color(82, 235, 215));
		sevenLowBtn.setBounds(79, 169, 63, 29);
		contentPane.add(sevenLowBtn);
		
		JButton thirtyHighBtn = new JButton("30 H");
		thirtyHighBtn.setOpaque(true);
		thirtyHighBtn.setForeground(new Color(5, 0, 0));
		thirtyHighBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		thirtyHighBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		thirtyHighBtn.setBackground(new Color(82, 235, 215));
		thirtyHighBtn.setBounds(10, 209, 63, 29);
		contentPane.add(thirtyHighBtn);
		
		JButton thirtyLowBtn = new JButton("30 L");
		thirtyLowBtn.setOpaque(true);
		thirtyLowBtn.setForeground(new Color(5, 0, 0));
		thirtyLowBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		thirtyLowBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		thirtyLowBtn.setBackground(new Color(82, 235, 215));
		thirtyLowBtn.setBounds(79, 209, 63, 29);
		contentPane.add(thirtyLowBtn);
		
		JButton volatilityBtn = new JButton("VOL");
		volatilityBtn.setOpaque(true);
		volatilityBtn.setForeground(new Color(5, 0, 0));
		volatilityBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		volatilityBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		volatilityBtn.setBackground(new Color(82, 235, 215));
		volatilityBtn.setBounds(10, 249, 63, 29);
		contentPane.add(volatilityBtn);
		
		JButton peBtn = new JButton("P/E");
		peBtn.setOpaque(true);
		peBtn.setForeground(new Color(5, 0, 0));
		peBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		peBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		peBtn.setBackground(new Color(82, 235, 215));
		peBtn.setBounds(79, 249, 63, 29);
		contentPane.add(peBtn);
		
		JButton epsBtn = new JButton("EPS");
		epsBtn.setOpaque(true);
		epsBtn.setForeground(new Color(5, 0, 0));
		epsBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		epsBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		epsBtn.setBackground(new Color(82, 235, 215));
		epsBtn.setBounds(10, 289, 63, 29);
		contentPane.add(epsBtn);
		
		JButton growthRateBtn = new JButton("GRW R");
		growthRateBtn.setOpaque(true);
		growthRateBtn.setForeground(new Color(5, 0, 0));
		growthRateBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		growthRateBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		growthRateBtn.setBackground(new Color(82, 235, 215));
		growthRateBtn.setBounds(79, 289, 63, 29);
		contentPane.add(growthRateBtn);
		
		JButton zeroBtn = new JButton("0");
		zeroBtn.setOpaque(true);
		zeroBtn.setForeground(new Color(5, 0, 0));
		zeroBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		zeroBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		zeroBtn.setBackground(new Color(230, 232, 230));
		zeroBtn.setBounds(152, 289, 63, 29);
		contentPane.add(zeroBtn);
		
		JButton oneBtn = new JButton("1");
		oneBtn.setOpaque(true);
		oneBtn.setForeground(new Color(5, 0, 0));
		oneBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		oneBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		oneBtn.setBackground(new Color(230, 232, 230));
		oneBtn.setBounds(152, 249, 63, 29);
		contentPane.add(oneBtn);
		
		JButton twoBtn = new JButton("2");
		twoBtn.setOpaque(true);
		twoBtn.setForeground(new Color(5, 0, 0));
		twoBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		twoBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		twoBtn.setBackground(new Color(230, 232, 230));
		twoBtn.setBounds(225, 249, 63, 29);
		contentPane.add(twoBtn);
		
		JButton threeBtn = new JButton("3");
		threeBtn.setOpaque(true);
		threeBtn.setForeground(new Color(5, 0, 0));
		threeBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		threeBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		threeBtn.setBackground(new Color(230, 232, 230));
		threeBtn.setBounds(298, 249, 63, 29);
		contentPane.add(threeBtn);
		
		JButton fourBtn = new JButton("4");
		fourBtn.setOpaque(true);
		fourBtn.setForeground(new Color(5, 0, 0));
		fourBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		fourBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		fourBtn.setBackground(new Color(230, 232, 230));
		fourBtn.setBounds(152, 209, 63, 29);
		contentPane.add(fourBtn);
		
		JButton fiveBtn = new JButton("5");
		fiveBtn.setOpaque(true);
		fiveBtn.setForeground(new Color(5, 0, 0));
		fiveBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		fiveBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		fiveBtn.setBackground(new Color(230, 232, 230));
		fiveBtn.setBounds(225, 209, 63, 29);
		contentPane.add(fiveBtn);
		
		JButton sixBtn = new JButton("6");
		sixBtn.setOpaque(true);
		sixBtn.setForeground(new Color(5, 0, 0));
		sixBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sixBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		sixBtn.setBackground(new Color(230, 232, 230));
		sixBtn.setBounds(298, 209, 63, 29);
		contentPane.add(sixBtn);
		
		JButton sevenBtn = new JButton("7");
		sevenBtn.setOpaque(true);
		sevenBtn.setForeground(new Color(5, 0, 0));
		sevenBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sevenBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		sevenBtn.setBackground(new Color(230, 232, 230));
		sevenBtn.setBounds(152, 169, 63, 29);
		contentPane.add(sevenBtn);
		
		JButton eightBtn = new JButton("8");
		eightBtn.setOpaque(true);
		eightBtn.setForeground(new Color(5, 0, 0));
		eightBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		eightBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		eightBtn.setBackground(new Color(230, 232, 230));
		eightBtn.setBounds(225, 169, 63, 29);
		contentPane.add(eightBtn);
		
		JButton nineBtn = new JButton("9");
		nineBtn.setOpaque(true);
		nineBtn.setForeground(new Color(5, 0, 0));
		nineBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		nineBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		nineBtn.setBackground(new Color(230, 232, 230));
		nineBtn.setBounds(298, 169, 63, 29);
		contentPane.add(nineBtn);
		
		JButton decimalBtn = new JButton(".");
		decimalBtn.setOpaque(true);
		decimalBtn.setForeground(new Color(5, 0, 0));
		decimalBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		decimalBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		decimalBtn.setBackground(new Color(230, 232, 230));
		decimalBtn.setBounds(225, 289, 63, 29);
		contentPane.add(decimalBtn);
		
		JButton divideBtn = new JButton("/");
		divideBtn.setOpaque(true);
		divideBtn.setForeground(new Color(5, 0, 0));
		divideBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		divideBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		divideBtn.setBackground(new Color(230, 232, 230));
		divideBtn.setBounds(371, 169, 63, 29);
		contentPane.add(divideBtn);
		
		JButton multiplyBtn = new JButton("x");
		multiplyBtn.setOpaque(true);
		multiplyBtn.setForeground(new Color(5, 0, 0));
		multiplyBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		multiplyBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		multiplyBtn.setBackground(new Color(230, 232, 230));
		multiplyBtn.setBounds(371, 209, 63, 29);
		contentPane.add(multiplyBtn);
		
		JButton subtractBtn = new JButton("-");
		subtractBtn.setOpaque(true);
		subtractBtn.setForeground(new Color(5, 0, 0));
		subtractBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		subtractBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		subtractBtn.setBackground(new Color(230, 232, 230));
		subtractBtn.setBounds(371, 249, 63, 29);
		contentPane.add(subtractBtn);
		
		JButton sumBtn = new JButton("+");
		sumBtn.setOpaque(true);
		sumBtn.setForeground(new Color(5, 0, 0));
		sumBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sumBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		sumBtn.setBackground(new Color(230, 232, 230));
		sumBtn.setBounds(371, 289, 63, 29);
		contentPane.add(sumBtn);
		
		JButton equalsBtn = new JButton("=");
		equalsBtn.setOpaque(true);
		equalsBtn.setForeground(new Color(5, 0, 0));
		equalsBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		equalsBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		equalsBtn.setBackground(new Color(230, 232, 230));
		equalsBtn.setBounds(298, 289, 63, 29);
		contentPane.add(equalsBtn);
		
		JLabel symbolLabel = new JLabel("Enter stock symbol");
		symbolLabel.setFont(new Font("Lucida Console", Font.BOLD, 14));
		symbolLabel.setForeground(lightBtnText);
		symbolLabel.setBounds(10, 11, 179, 27);
		contentPane.add(symbolLabel);
		
		symbolText = new JTextField();
		symbolText.setToolTipText("Enter stock symbol");
		symbolText.setFont(new Font("Lucida Console", Font.BOLD, 14));
		symbolText.setBackground(lightBtnText);
		symbolText.setForeground(darkBtnText);
		symbolText.setBounds(199, 11, 102, 27);
		contentPane.add(symbolText);
		symbolText.setColumns(10);
		
		JButton debtAssetBtn = new JButton("D/A");
		debtAssetBtn.setOpaque(true);
		debtAssetBtn.setForeground(new Color(5, 0, 0));
		debtAssetBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		debtAssetBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		debtAssetBtn.setBackground(new Color(82, 235, 215));
		debtAssetBtn.setBounds(10, 329, 63, 29);
		contentPane.add(debtAssetBtn);
		
		JButton assetLiabilityBtn = new JButton("A/L");
		assetLiabilityBtn.setOpaque(true);
		assetLiabilityBtn.setForeground(new Color(5, 0, 0));
		assetLiabilityBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		assetLiabilityBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		assetLiabilityBtn.setBackground(new Color(82, 235, 215));
		assetLiabilityBtn.setBounds(79, 329, 63, 29);
		contentPane.add(assetLiabilityBtn);
		
		JLabel dayHighLabel = new JLabel("Day High");
		dayHighLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dayHighLabel.setFont(new Font("Lucida Console", Font.BOLD, 12));
		dayHighLabel.setForeground(lightBtnText);
		dayHighLabel.setBounds(12, 382, 90, 20);
		contentPane.add(dayHighLabel);
		
		dayHighText = new JTextField();
		dayHighText.setText("0");
		dayHighText.setFont(new Font("Lucida Console", Font.BOLD, 12));
		dayHighText.setBackground(lightBtnText);
		dayHighText.setForeground(darkBtnText);
		dayHighText.setHorizontalAlignment(SwingConstants.CENTER);
		dayHighText.setBounds(12, 405, 90, 29);
		contentPane.add(dayHighText);
		dayHighText.setColumns(10);
		
		JLabel dayLowLabel = new JLabel("Day Low");
		dayLowLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dayLowLabel.setForeground(new Color(255, 255, 250));
		dayLowLabel.setFont(new Font("Lucida Console", Font.BOLD, 12));
		dayLowLabel.setBounds(120, 382, 90, 20);
		contentPane.add(dayLowLabel);
		
		dayLowText = new JTextField();
		dayLowText.setText("0");
		dayLowText.setHorizontalAlignment(SwingConstants.CENTER);
		dayLowText.setForeground(new Color(5, 0, 0));
		dayLowText.setFont(new Font("Lucida Console", Font.BOLD, 12));
		dayLowText.setColumns(10);
		dayLowText.setBackground(new Color(255, 255, 250));
		dayLowText.setBounds(120, 405, 90, 29);
		contentPane.add(dayLowText);
		
		JLabel sevenDayHighLabel = new JLabel("7 Day High");
		sevenDayHighLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sevenDayHighLabel.setForeground(new Color(255, 255, 250));
		sevenDayHighLabel.setFont(new Font("Lucida Console", Font.BOLD, 12));
		sevenDayHighLabel.setBounds(228, 382, 90, 20);
		contentPane.add(sevenDayHighLabel);
		
		sevenDayHighText = new JTextField();
		sevenDayHighText.setText("0");
		sevenDayHighText.setHorizontalAlignment(SwingConstants.CENTER);
		sevenDayHighText.setForeground(new Color(5, 0, 0));
		sevenDayHighText.setFont(new Font("Lucida Console", Font.BOLD, 12));
		sevenDayHighText.setColumns(10);
		sevenDayHighText.setBackground(new Color(255, 255, 250));
		sevenDayHighText.setBounds(228, 405, 90, 29);
		contentPane.add(sevenDayHighText);
		
		JLabel sevenDayLowLabel = new JLabel("7 Day Low");
		sevenDayLowLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sevenDayLowLabel.setForeground(new Color(255, 255, 250));
		sevenDayLowLabel.setFont(new Font("Lucida Console", Font.BOLD, 12));
		sevenDayLowLabel.setBounds(336, 382, 90, 20);
		contentPane.add(sevenDayLowLabel);
		
		sevenDayLowText = new JTextField();
		sevenDayLowText.setText("0");
		sevenDayLowText.setHorizontalAlignment(SwingConstants.CENTER);
		sevenDayLowText.setForeground(new Color(5, 0, 0));
		sevenDayLowText.setFont(new Font("Lucida Console", Font.BOLD, 12));
		sevenDayLowText.setColumns(10);
		sevenDayLowText.setBackground(new Color(255, 255, 250));
		sevenDayLowText.setBounds(336, 405, 90, 29);
		contentPane.add(sevenDayLowText);
		
		JLabel thirtyDayHighLabel = new JLabel("30 Day High");
		thirtyDayHighLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thirtyDayHighLabel.setForeground(new Color(255, 255, 250));
		thirtyDayHighLabel.setFont(new Font("Lucida Console", Font.BOLD, 12));
		thirtyDayHighLabel.setBounds(10, 445, 90, 20);
		contentPane.add(thirtyDayHighLabel);
		
		thirtyDayHighText = new JTextField();
		thirtyDayHighText.setText("0");
		thirtyDayHighText.setHorizontalAlignment(SwingConstants.CENTER);
		thirtyDayHighText.setForeground(new Color(5, 0, 0));
		thirtyDayHighText.setFont(new Font("Lucida Console", Font.BOLD, 12));
		thirtyDayHighText.setColumns(10);
		thirtyDayHighText.setBackground(new Color(255, 255, 250));
		thirtyDayHighText.setBounds(10, 468, 90, 29);
		contentPane.add(thirtyDayHighText);
		
		JLabel thirtyDayLowLabel = new JLabel("30 Day Low");
		thirtyDayLowLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thirtyDayLowLabel.setForeground(new Color(255, 255, 250));
		thirtyDayLowLabel.setFont(new Font("Lucida Console", Font.BOLD, 12));
		thirtyDayLowLabel.setBounds(120, 445, 90, 20);
		contentPane.add(thirtyDayLowLabel);
		
		thirtyDayLowText = new JTextField();
		thirtyDayLowText.setText("0");
		thirtyDayLowText.setHorizontalAlignment(SwingConstants.CENTER);
		thirtyDayLowText.setForeground(new Color(5, 0, 0));
		thirtyDayLowText.setFont(new Font("Lucida Console", Font.BOLD, 12));
		thirtyDayLowText.setColumns(10);
		thirtyDayLowText.setBackground(new Color(255, 255, 250));
		thirtyDayLowText.setBounds(120, 468, 90, 29);
		contentPane.add(thirtyDayLowText);
		
		JLabel epsLabel = new JLabel("EPS");
		epsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		epsLabel.setForeground(new Color(255, 255, 250));
		epsLabel.setFont(new Font("Lucida Console", Font.BOLD, 12));
		epsLabel.setBounds(10, 508, 90, 20);
		contentPane.add(epsLabel);
		
		epsText = new JTextField();
		epsText.setText("0");
		epsText.setHorizontalAlignment(SwingConstants.CENTER);
		epsText.setForeground(new Color(5, 0, 0));
		epsText.setFont(new Font("Lucida Console", Font.BOLD, 12));
		epsText.setColumns(10);
		epsText.setBackground(new Color(255, 255, 250));
		epsText.setBounds(10, 531, 90, 29);
		contentPane.add(epsText);
		
		JLabel growthRateLabel = new JLabel("Growth Rate");
		growthRateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		growthRateLabel.setForeground(new Color(255, 255, 250));
		growthRateLabel.setFont(new Font("Lucida Console", Font.BOLD, 12));
		growthRateLabel.setBounds(120, 508, 90, 20);
		contentPane.add(growthRateLabel);
		
		growthRateText = new JTextField();
		growthRateText.setText("0");
		growthRateText.setHorizontalAlignment(SwingConstants.CENTER);
		growthRateText.setForeground(new Color(5, 0, 0));
		growthRateText.setFont(new Font("Lucida Console", Font.BOLD, 12));
		growthRateText.setColumns(10);
		growthRateText.setBackground(new Color(255, 255, 250));
		growthRateText.setBounds(120, 531, 90, 29);
		contentPane.add(growthRateText);
		
		JLabel volatilityLabel = new JLabel("Volatility");
		volatilityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		volatilityLabel.setForeground(new Color(255, 255, 250));
		volatilityLabel.setFont(new Font("Lucida Console", Font.BOLD, 12));
		volatilityLabel.setBounds(225, 445, 90, 20);
		contentPane.add(volatilityLabel);
		
		volatilityText = new JTextField();
		volatilityText.setText("0");
		volatilityText.setHorizontalAlignment(SwingConstants.CENTER);
		volatilityText.setForeground(new Color(5, 0, 0));
		volatilityText.setFont(new Font("Lucida Console", Font.BOLD, 12));
		volatilityText.setColumns(10);
		volatilityText.setBackground(new Color(255, 255, 250));
		volatilityText.setBounds(225, 468, 90, 29);
		contentPane.add(volatilityText);
		
		JLabel peRatioLabel = new JLabel("P/E");
		peRatioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		peRatioLabel.setForeground(new Color(255, 255, 250));
		peRatioLabel.setFont(new Font("Lucida Console", Font.BOLD, 12));
		peRatioLabel.setBounds(336, 445, 90, 20);
		contentPane.add(peRatioLabel);
		
		peRatioText = new JTextField();
		peRatioText.setText("0");
		peRatioText.setHorizontalAlignment(SwingConstants.CENTER);
		peRatioText.setForeground(new Color(5, 0, 0));
		peRatioText.setFont(new Font("Lucida Console", Font.BOLD, 12));
		peRatioText.setColumns(10);
		peRatioText.setBackground(new Color(255, 255, 250));
		peRatioText.setBounds(336, 468, 90, 29);
		contentPane.add(peRatioText);
		
		JLabel debtAssetLabel = new JLabel("Debt/Asset");
		debtAssetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		debtAssetLabel.setForeground(new Color(255, 255, 250));
		debtAssetLabel.setFont(new Font("Lucida Console", Font.BOLD, 12));
		debtAssetLabel.setBounds(225, 508, 90, 20);
		contentPane.add(debtAssetLabel);
		
		debtAssetText = new JTextField();
		debtAssetText.setText("0");
		debtAssetText.setHorizontalAlignment(SwingConstants.CENTER);
		debtAssetText.setForeground(new Color(5, 0, 0));
		debtAssetText.setFont(new Font("Lucida Console", Font.BOLD, 12));
		debtAssetText.setColumns(10);
		debtAssetText.setBackground(new Color(255, 255, 250));
		debtAssetText.setBounds(225, 531, 90, 29);
		contentPane.add(debtAssetText);
		
		JLabel assetLiabilityLabel = new JLabel("Asset/Lblty");
		assetLiabilityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		assetLiabilityLabel.setForeground(new Color(255, 255, 250));
		assetLiabilityLabel.setFont(new Font("Lucida Console", Font.BOLD, 12));
		assetLiabilityLabel.setBounds(336, 508, 90, 20);
		contentPane.add(assetLiabilityLabel);
		
		assetLiabilityText = new JTextField();
		assetLiabilityText.setText("0");
		assetLiabilityText.setHorizontalAlignment(SwingConstants.CENTER);
		assetLiabilityText.setForeground(new Color(5, 0, 0));
		assetLiabilityText.setFont(new Font("Lucida Console", Font.BOLD, 12));
		assetLiabilityText.setColumns(10);
		assetLiabilityText.setBackground(new Color(255, 255, 250));
		assetLiabilityText.setBounds(336, 531, 90, 29);
		contentPane.add(assetLiabilityText);
		
		JButton formulaOneBtn = new JButton("F1");
		formulaOneBtn.setOpaque(true);
		formulaOneBtn.setForeground(new Color(5, 0, 0));
		formulaOneBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		formulaOneBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		formulaOneBtn.setBackground(orangeBtns);
		formulaOneBtn.setBounds(152, 329, 63, 29);
		contentPane.add(formulaOneBtn);
		
		JButton formulaTwoBtn = new JButton("F2");
		formulaTwoBtn.setOpaque(true);
		formulaTwoBtn.setForeground(new Color(5, 0, 0));
		formulaTwoBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		formulaTwoBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		formulaTwoBtn.setBackground(new Color(255, 150, 0));
		formulaTwoBtn.setBounds(225, 329, 63, 29);
		contentPane.add(formulaTwoBtn);
		
		JButton formulaThreeBtn = new JButton("F3");
		formulaThreeBtn.setOpaque(true);
		formulaThreeBtn.setForeground(new Color(5, 0, 0));
		formulaThreeBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		formulaThreeBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		formulaThreeBtn.setBackground(new Color(255, 150, 0));
		formulaThreeBtn.setBounds(298, 329, 63, 29);
		contentPane.add(formulaThreeBtn);
		
		JButton formulaFourBtn = new JButton("F4");
		formulaFourBtn.setOpaque(true);
		formulaFourBtn.setForeground(new Color(5, 0, 0));
		formulaFourBtn.setFont(new Font("Lucida Console", Font.BOLD, 14));
		formulaFourBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		formulaFourBtn.setBackground(new Color(255, 150, 0));
		formulaFourBtn.setBounds(371, 329, 63, 29);
		contentPane.add(formulaFourBtn);
		
		displayFormula = new JTextField();
		displayFormula.setText("Formula");
		displayFormula.setHorizontalAlignment(SwingConstants.RIGHT);
		displayFormula.setFont(new Font("Lucida Console", Font.BOLD, 22));
		displayFormula.setEditable(false);
		displayFormula.setColumns(10);
		displayFormula.setBackground(new Color(0, 250, 10));
		displayFormula.setBounds(10, 49, 424, 29);
		contentPane.add(displayFormula);
		
		allClearBtn.addActionListener(new ListenToAllClear());
		deleteBtn.addActionListener(new ListenToDelete());
		rightParenBtn.addActionListener(new ListenToRightParen());
		leftParenBtn.addActionListener(new ListenToLeftParen());
		zeroBtn.addActionListener(new ListenToZero());
		oneBtn.addActionListener(new ListenToOne());
		twoBtn.addActionListener(new ListenToTwo());
		threeBtn.addActionListener(new ListenToThree());
		fourBtn.addActionListener(new ListenToFour());
		fiveBtn.addActionListener(new ListenToFive());
		sixBtn.addActionListener(new ListenToSix());
		sevenBtn.addActionListener(new ListenToSeven());
		eightBtn.addActionListener(new ListenToEight());
		nineBtn.addActionListener(new ListenToNine());
		decimalBtn.addActionListener(new ListenToDecimal());
		divideBtn.addActionListener(new ListenToDivide());
		multiplyBtn.addActionListener(new ListenToMultiply());
		subtractBtn.addActionListener(new ListenToSubtract());
		sumBtn.addActionListener(new ListenToSum());
		equalsBtn.addActionListener(new ListenToEquals());
		dayHighBtn.addActionListener(new ListenToDayHigh());
		dayLowBtn.addActionListener(new ListenToDayLow());
		sevenHighBtn.addActionListener(new ListenToSevenHigh());
		sevenLowBtn.addActionListener(new ListenToSevenLow());
		thirtyHighBtn.addActionListener(new ListenToThirtyHigh());
		thirtyLowBtn.addActionListener(new ListenToThirtyLow());
		volatilityBtn.addActionListener(new ListenToVolatility());
		peBtn.addActionListener(new ListenToPE());
		epsBtn.addActionListener(new ListenToEPS());
		growthRateBtn.addActionListener(new ListenToGrowthRate());
		debtAssetBtn.addActionListener(new ListenToDebtAsset());
		assetLiabilityBtn.addActionListener(new ListenToAssetLiability());
		
		symbolText.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent e) {
		    	String symbol = symbolText.getText();
		    	Stock currentStock = new Stock(symbol);
		    	try {
					URLConnectionReader.getData(symbol, currentStock);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, 
                            "Symbol not found. Check the symbol or try another.", 
                            "Symbol Not Found", 
                            JOptionPane.WARNING_MESSAGE);
				} // end try catch
		    	String dayHighString = Double.toString(currentStock.getDayHigh());
		    	dayHighText.setText(dayHighString);
		    } // end action performed
		}); // end symbolText.addActionListener
		
	} // end Calculator constructor
	
	// Action Listeners
			class ListenToAllClear implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					// set String to empty and display to "0"
					userExpression = "";
					display.setText("0");
					displayFormula.setText("Formula");
				} // end actionPerformed
			} // end ListenToAllClear
			
			class ListenToDelete implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					// remove last character entered from display
					userExpression = userExpression.substring(0, userExpression.length()-1);
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToDelete
			
			class ListenToRightParen implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					userExpression = userExpression + ")";
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToRightParen
			
			class ListenToLeftParen implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					userExpression = userExpression + "(";
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToLeftParen
			
			class ListenToZero implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					userExpression = userExpression + "0";
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToZero
			
			class ListenToOne implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					userExpression = userExpression + "1";
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToOne
			
			class ListenToTwo implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					userExpression = userExpression + "2";
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToTwo
			
			class ListenToThree implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					userExpression = userExpression + "3";
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToThree
			
			class ListenToFour implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					userExpression = userExpression + "4";
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToFour
			
			class ListenToFive implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					userExpression = userExpression + "5";
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToFive
			
			class ListenToSix implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					userExpression = userExpression + "6";
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToSix
			
			class ListenToSeven implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					userExpression = userExpression + "7";
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToSeven
			
			class ListenToEight implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					userExpression = userExpression + "8";
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToEight
			
			class ListenToNine implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					userExpression = userExpression + "9";
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToNine
			
			class ListenToDecimal implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					userExpression = userExpression + ".";
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToDecimal
			
			class ListenToDivide implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					userExpression = userExpression + "/";
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToDivide
			
			class ListenToMultiply implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					userExpression = userExpression + "*";
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToMultiply
			
			class ListenToSubtract implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					userExpression = userExpression + "-";
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToSubtract
			
			class ListenToSum implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					userExpression = userExpression + "+";
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToSum
			
			class ListenToEquals implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					double total = eval(userExpression);
					display.setText(String.valueOf(total));
				} // end actionPerformed
			} // end ListenToOne
			
			class ListenToDayHigh implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					String temp = dayHighText.getText();
					userExpression = userExpression + temp;
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToDayHigh
			
			class ListenToDayLow implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					String temp = dayLowText.getText();
					userExpression = userExpression + temp;
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToDayLow
			
			class ListenToSevenHigh implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					String temp = sevenDayHighText.getText();
					userExpression = userExpression + temp;
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToSevenHigh
			
			class ListenToSevenLow implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					String temp = sevenDayLowText.getText();
					userExpression = userExpression + temp;
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToSevenLow
			
			class ListenToThirtyHigh implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					String temp = thirtyDayHighText.getText();
					userExpression = userExpression + temp;
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToThirtyHigh
			
			class ListenToThirtyLow implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					String temp = thirtyDayLowText.getText();
					userExpression = userExpression + temp;
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToThirtyLow
			
			class ListenToVolatility implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					String temp = volatilityText.getText();
					userExpression = userExpression + temp;
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToVolatility
			
			class ListenToPE implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					String temp = peRatioText.getText();
					userExpression = userExpression + temp;
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToPE
			
			class ListenToEPS implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					String temp = epsText.getText();
					userExpression = userExpression + temp;
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToEPS
			
			class ListenToGrowthRate implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					String temp = growthRateText.getText();
					userExpression = userExpression + temp;
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToGrowthRate
			
			class ListenToDebtAsset implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					String temp = debtAssetText.getText();
					userExpression = userExpression + temp;
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToDebtAsset
			
			class ListenToAssetLiability implements ActionListener{
				public void actionPerformed(ActionEvent e) {
					String temp = assetLiabilityText.getText();
					userExpression = userExpression + temp;
					display.setText(userExpression);
				} // end actionPerformed
			} // end ListenToAssetLiability
			
			
			   
			
	
	
	/*
	 * The following method for parsing and evaluating expressions in String form
	 * is part of the public domain. It was taken from Stack Overflow and 
	 * written by user "Boann". Any modification to the original method will be
	 * noted with a comment. The original post can be found at this link:
	 * https://stackoverflow.com/questions/3422673/evaluating-a-math-expression-given-in-string-form#
	 */
	
	public static double eval(final String str) {
	    return new Object() {
	        int pos = -1, ch;

	        void nextChar() {
	            ch = (++pos < str.length()) ? str.charAt(pos) : -1;
	        }

	        boolean eat(int charToEat) {
	            while (ch == ' ') nextChar();
	            if (ch == charToEat) {
	                nextChar();
	                return true;
	            }
	            return false;
	        }

	        double parse() {
	            nextChar();
	            double x = parseExpression();
	            if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
	            return x;
	        }

	        // Grammar:
	        // expression = term | expression `+` term | expression `-` term
	        // term = factor | term `*` factor | term `/` factor
	        // factor = `+` factor | `-` factor | `(` expression `)`
	        //        | number | functionName factor | factor `^` factor

	        double parseExpression() {
	            double x = parseTerm();
	            for (;;) {
	                if      (eat('+')) x += parseTerm(); // addition
	                else if (eat('-')) x -= parseTerm(); // subtraction
	                else return x;
	            }
	        }

	        double parseTerm() {
	            double x = parseFactor();
	            for (;;) {
	                if      (eat('*')) x *= parseFactor(); // multiplication
	                else if (eat('/')) x /= parseFactor(); // division
	                else return x;
	            }
	        }

	        double parseFactor() {
	            if (eat('+')) return parseFactor(); // unary plus
	            if (eat('-')) return -parseFactor(); // unary minus

	            double x;
	            int startPos = this.pos;
	            if (eat('(')) { // parentheses
	                x = parseExpression();
	                eat(')');
	            } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
	                while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
	                x = Double.parseDouble(str.substring(startPos, this.pos));
	            } else if (ch >= 'a' && ch <= 'z') { // functions
	                while (ch >= 'a' && ch <= 'z') nextChar();
	                String func = str.substring(startPos, this.pos);
	                x = parseFactor();
	                if (func.equals("sqrt")) x = Math.sqrt(x);
	                else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
	                else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
	                else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
	                else throw new RuntimeException("Unknown function: " + func);
	            } else {
	                throw new RuntimeException("Unexpected: " + (char)ch);
	            }

	            if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

	            return x;
	        }
	    }.parse();
	} // end eval method
} // end Calculator class
