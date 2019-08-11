package calc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Calculator extends JFrame implements Calculations {

	private JPanel contentPane;
	private JTextField TextField;
	private JLabel label;
	
	private boolean isDecimal = false;
	private String sign;
	private double a_firstnumber_tocalculate;
	
	/**
	 * Create the frame.
	 */
	public Calculator() {
		setResizable(false);
		
		setFont(new Font("Dialog", Font.PLAIN, 27));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PC-ASUS\\Downloads\\sb.png"));
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 341, 508);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		contentPane.setBorder(new LineBorder(new Color(128, 128, 128), 3, true));
		setContentPane(contentPane);
		
		JButton percentageButton = new JButton("%");
		percentageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(label.getText().length()>0 && TextField.getText().length()>0)
				{
					a_firstnumber_tocalculate = Double.parseDouble(TextField.getText());
					percentage(Double.parseDouble(label.getText().split(" ")[0]),a_firstnumber_tocalculate);
					
					
				}
			}
		});
		percentageButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		
		JButton sqrtButton = new JButton("sqrt");
		sqrtButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				a_firstnumber_tocalculate = Double.parseDouble(TextField.getText());
				square_root(a_firstnumber_tocalculate);
			}
		});
		sqrtButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		
		JButton squareButton = new JButton("x2");
		squareButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(TextField.getText().length()>0)
					{
						a_firstnumber_tocalculate = Double.parseDouble(TextField.getText());
					}
				square(a_firstnumber_tocalculate);
			}
		});
		squareButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton onebyx_Button = new JButton("1/x");
		onebyx_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(TextField.getText().length()>0)
				{
					a_firstnumber_tocalculate = Double.parseDouble(TextField.getText());
				}
			inverse(a_firstnumber_tocalculate);
			}
		});
		onebyx_Button.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton cButton = new JButton("C");    //Blank textfield and label
		cButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextField.setText("");        
				label.setText("");
			}
		});
		cButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JButton CEButton = new JButton("CE");    //blank only textfield
		CEButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextField.setText("");
			}
		});
		CEButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JButton backButton = new JButton("<-");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String value = TextField.getText();
				int length = value.length();
				if(length>0)
				{
					StringBuilder builder = new StringBuilder(value);
					builder.deleteCharAt(length-1);     //delete the numbers from right side
					TextField.setText(builder.toString());
				}
					
			}
		});
		backButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton cubeButton = new JButton("x3");
		cubeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(TextField.getText().length()>0)
				{
					a_firstnumber_tocalculate = Double.parseDouble(TextField.getText());
				}
				cube(a_firstnumber_tocalculate);
			}
		});
		cubeButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton divideButton = new JButton("/");
		divideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sign = "/";
				if(TextField.getText().length()>0)       
				{
					storetobe_calculatevalue(sign);       //store the values in label after click the operations button(here "/")
				}			
			}
		});
		divideButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton minusButton = new JButton("-");
		minusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sign = "-";
				if(TextField.getText().length()>0)
				{
					storetobe_calculatevalue(sign);
				}
			}
		});
		minusButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton plusButton = new JButton("+");
		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sign = "+";
				if(TextField.getText().length()>0)
				{
					storetobe_calculatevalue(sign);
				}			
			}
		});
		plusButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton multiplyButton = new JButton("*");
		multiplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sign = "*";
				if(TextField.getText().length()>0)
				{
					storetobe_calculatevalue(sign);
				}			
			}
		});
		multiplyButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton sixButton = new JButton("6");
		sixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextField.setText(TextField.getText()+"6");
			}
		});
		sixButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton fiveButton = new JButton("5");
		fiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextField.setText(TextField.getText()+"5");
			}
		});
		fiveButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton fourButton = new JButton("4");
		fourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextField.setText(TextField.getText()+"4");
			}
		});
		fourButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton nineButton = new JButton("9");
		nineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextField.setText(TextField.getText()+"9");
			}
		});
		nineButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton eightButton = new JButton("8");
		eightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextField.setText(TextField.getText()+"8");
			}
		});
		eightButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton sevenButton = new JButton("7");
		sevenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextField.setText(TextField.getText()+"7");
			}
		});
		sevenButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton oneButton = new JButton("1");
		oneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextField.setText(TextField.getText()+"1");
			}
		});
		oneButton.setBackground(UIManager.getColor("Label.disabledShadow"));
		oneButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton twoButton = new JButton("2");
		twoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextField.setText(TextField.getText()+"2");
			}
		});
		twoButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton threeButton = new JButton("3");
		threeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextField.setText(TextField.getText()+"3");
			}
		});
		threeButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton dotButton = new JButton(".");
		dotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(isDecimal==false)  // setting dot to only once in textfield
				{
					TextField.setText(TextField.getText()+".");
					isDecimal = true;
				}
			}
		});
		dotButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		JButton zeroButton = new JButton("0");
		zeroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextField.setText(TextField.getText()+"0");
			}
		});
		zeroButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		
		JButton equaltoButton = new JButton("=");
		equaltoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(TextField.getText().length()>0)   //execute if textfield has more than 1 number
				{
					double b = Double.parseDouble(TextField.getText());  //store the recent typed number
				
					switch(sign)
					{
						case "/":
							divide(a_firstnumber_tocalculate,b);
							break;
						case "*":
							multiply(a_firstnumber_tocalculate,b);
							break;
						case "+":
							add(a_firstnumber_tocalculate,b);
							break;
						case "-":
							subtract(a_firstnumber_tocalculate,b);
							break;
					}
				}
			}
		});
		equaltoButton.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 24));
		
		
		
		
		TextField = new JTextField();
		TextField.setHorizontalAlignment(SwingConstants.RIGHT);
		TextField.setForeground(Color.GRAY);
		TextField.setFont(new Font("Arial Black", Font.BOLD, 24));
		TextField.setColumns(10);
		
		label = new JLabel("");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Arial Black", Font.BOLD, 22));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(TextField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
						.addComponent(label, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(cButton, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(CEButton, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(fourButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(fiveButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(sixButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(sevenButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addComponent(eightButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addGap(9)
									.addComponent(nineButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(dotButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(zeroButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(equaltoButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(oneButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(twoButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(threeButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(minusButton, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
										.addComponent(divideButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(multiplyButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addComponent(plusButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
								.addComponent(onebyx_Button)))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(percentageButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(sqrtButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(squareButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cubeButton, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)))
					.addGap(37))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(TextField, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(percentageButton)
						.addComponent(sqrtButton)
						.addComponent(squareButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cubeButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(cButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(CEButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addComponent(onebyx_Button)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(nineButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addComponent(eightButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addComponent(sevenButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(sixButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addComponent(fiveButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addComponent(fourButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(divideButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(multiplyButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(plusButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(oneButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addComponent(twoButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addComponent(threeButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(dotButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(zeroButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addComponent(equaltoButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addComponent(minusButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
					.addGap(17))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	// all the operations :
	@Override
	public void add(double a, double b) {
		
		setResult(a+b);
	}
	
	@Override
	public void subtract(double a, double b) {
		
		setResult(a-b);
	}
	
	@Override
	public void multiply(double a, double b) {

		setResult(a*b);
	}
	
	@Override
	public void divide(double a, double b) {

		setResult(a/b);
	}
	
	private void setResult(double result)            //to change the calculated double value to string 
	{
		TextField.setText(Double.toString(result));
		label.setText("");
		
		
	}
	
	private void percentage(double a,double b)
	{
		switch(sign)
		{
			case "/":
				divide(((a*b)/100),a);
				break;
			case "*":
				multiply(((a*b)/100),a);
				break;
			case "+":
				add(((a*b)/100),a);
				break;
			case "-":
				subtract(((a*b)/100),a);
				break;
		}
	}
	
	private void square_root(double a)
	{
		TextField.setText(Double.toString(Math.sqrt(a)));
	}
	
	private void square(double a)
	{
		TextField.setText(Double.toString(a*a));
	}
	private void cube(double a)
	{
		TextField.setText(Double.toString(a*a*a));
	}
	private void inverse(double a)
	{
		TextField.setText(Double.toString(1/a));
	}
	
	
	
	private void storetobe_calculatevalue(String sign)     //to store the double value in label
	{
		String value = TextField.getText();            //store Textfield value as string 
		
		a_firstnumber_tocalculate = Double.parseDouble(value);     //stored value changed to number (a_firstnumber_tocalculate) which will call for operations
		
		label.setText(value+" "+sign);  //setting typed value in label
		TextField.setText("");
	}
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
