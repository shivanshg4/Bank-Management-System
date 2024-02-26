package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupThree extends JFrame implements ActionListener {

	long form = SignupOne.form;

	JRadioButton r1, r2, r3, r4;
	JButton submit, cancel;
	JCheckBox s1, s2, s3, s4, s5, s6, agreement;

	SignupThree() {

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\logo.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel i4 = new JLabel(i3);
		i4.setBounds(20, 20, 100, 100);
		add(i4);
		JLabel formNo = new JLabel("Application Form no. " + form);
		formNo.setFont(new Font("Ariel", Font.BOLD, 28));
		formNo.setBounds(250, 50, 500, 30);
		add(formNo);

		JLabel pageNo = new JLabel("Page Three : Account Details");
		pageNo.setFont(new Font("Ariel", Font.BOLD, 20));
		pageNo.setBounds(280, 110, 500, 30);
		add(pageNo);

		JLabel account = new JLabel("Account Type :");
		account.setFont(new Font("Ariel", Font.BOLD, 20));
		account.setBounds(150, 175, 200, 23);
		add(account);

		r1 = new JRadioButton("Saving Account");
		r1.setBackground(Color.WHITE);
		r1.setFont(new Font("Ariel", 0, 18));
		r1.setBounds(150, 210, 200, 20);
		add(r1);

		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setBackground(Color.WHITE);
		r2.setFont(new Font("Ariel", 0, 18));
		r2.setBounds(420, 210, 300, 20);
		add(r2);

		r3 = new JRadioButton("Current Account");
		r3.setBackground(Color.WHITE);
		r3.setFont(new Font("Ariel", 0, 18));
		r3.setBounds(150, 240, 200, 20);
		add(r3);

		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setBackground(Color.WHITE);
		r4.setFont(new Font("Ariel", 0, 18));
		r4.setBounds(420, 240, 300, 20);
		add(r4);

		ButtonGroup type = new ButtonGroup();
		type.add(r1);
		type.add(r2);
		type.add(r3);
		type.add(r4);

		JLabel cardL1 = new JLabel("Card Number ");
		cardL1.setFont(new Font("Ariel", Font.BOLD, 20));
		cardL1.setBounds(150, 300, 200, 23);
		add(cardL1);

		JLabel cardL2 = new JLabel("Your 16 Digit Card Number");
		cardL2.setFont(new Font("Ariel", 0, 15));
		cardL2.setBounds(150, 320, 500, 23);
		add(cardL2);

		JLabel cardNo = new JLabel("XXXX-XXXX-XXXX-4184");
		cardNo.setFont(new Font("Ariel", Font.BOLD, 20));
		cardNo.setBounds(420, 300, 400, 23);
		add(cardNo);

		JLabel pinL1 = new JLabel("PIN");
		pinL1.setFont(new Font("Ariel", Font.BOLD, 20));
		pinL1.setBounds(150, 370, 200, 23);
		add(pinL1);

		JLabel pinL2 = new JLabel("Your 4 Digit Password");
		pinL2.setFont(new Font("Ariel", 0, 15));
		pinL2.setBounds(150, 390, 500, 23);
		add(pinL2);

		JLabel pinNo = new JLabel("XXXX");
		pinNo.setFont(new Font("Ariel", Font.BOLD, 20));
		pinNo.setBounds(420, 370, 400, 23);
		add(pinNo);

		JLabel serviceL1 = new JLabel("Service Required ");
		serviceL1.setFont(new Font("Ariel", Font.BOLD, 20));
		serviceL1.setBounds(150, 435, 200, 23);
		add(serviceL1);

		s1 = new JCheckBox("ATM Card");
		s1.setFont(new Font("Ariel", 0, 18));
		s1.setBackground(Color.WHITE);
		s1.setBounds(150, 470, 200, 23);
		add(s1);

		s2 = new JCheckBox("Internet Banking");
		s2.setFont(new Font("Ariel", 0, 18));
		s2.setBackground(Color.WHITE);
		s2.setBounds(420, 470, 200, 23);
		add(s2);

		s3 = new JCheckBox("Mobile Banking");
		s3.setFont(new Font("Ariel", 0, 18));
		s3.setBackground(Color.WHITE);
		s3.setBounds(150, 500, 200, 23);
		add(s3);

		s4 = new JCheckBox("Email & SMS Alerts");
		s4.setFont(new Font("Ariel", 0, 18));
		s4.setBackground(Color.WHITE);
		s4.setBounds(420, 500, 200, 23);
		add(s4);

		s5 = new JCheckBox("Cheque Book");
		s5.setFont(new Font("Ariel", 0, 18));
		s5.setBackground(Color.WHITE);
		s5.setBounds(150, 530, 200, 23);
		add(s5);

		s6 = new JCheckBox("E-Statement");
		s6.setFont(new Font("Ariel", 0, 18));
		s6.setBackground(Color.WHITE);
		s6.setBounds(420, 530, 200, 23);
		add(s6);

		agreement = new JCheckBox(
				"I hearby declare that the above shared details are correct to the best of my knowledge");
		agreement.setFont(new Font("Ariel", Font.BOLD, 15));
		agreement.setBackground(Color.WHITE);
		agreement.setBounds(100, 590, 900, 23);
		add(agreement);

		submit = new JButton("SUBMIT");
		submit.setBackground(Color.black);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Ariel", 0, 20));
		submit.setBounds(150, 650, 220, 30);
		submit.addActionListener(this);
		add(submit);

		cancel = new JButton("CANCEL");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Ariel", 0, 20));
		cancel.setBounds(410, 650, 220, 30);
		cancel.addActionListener(this);
		add(cancel);

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("Automated Teller Machine");
		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {

		try {
			if (ae.getSource() == cancel) {
				setVisible(false);
				new SignupOne();
			} else if (ae.getSource() == submit) {

				String formNo = "" + form;

				String account = null;
				if (r1.isSelected()) {
					account = "Saving Account";
				} else if (r2.isSelected()) {
					account = "Fixed Deposit Account";
				} else if (r3.isSelected()) {
					account = "Current Account";
				} else if (r4.isSelected()) {
					account = "Recurring Deposit Account";
				}

				Random rand = new Random();
				String cardNumber = "" + Math.abs((rand.nextLong() % 90000000L + 504093600000000L));
				String pin = "" + Math.abs((rand.nextLong() % 9000L) + 1000L);

				String facility = null;
				if (s1.isSelected()) {
					facility = facility + "ATM Card ";
				}
				if (s2.isSelected()) {
					facility = facility + "Internet Banking ";
				}
				if (s3.isSelected()) {
					facility = facility + "Mobile Banking ";
				}
				if (s4.isSelected()) {
					facility = facility + "Email & SMS Alarts ";
				}
				if (s5.isSelected()) {
					facility = facility + "CheckBook ";
				}
				if (s6.isSelected()) {
					facility = facility + "E-Statement";
				}
				
				String query1 = "INSERT INTO signupThree values('"+formNo+"','"+account+"','"+cardNumber+"','"+pin+"','"+facility+"');";
				String query2 = "INSERT INTO login values('"+formNo+"','"+cardNumber+"','"+pin+"');";
			JOptionPane.showMessageDialog(null,"Your Card Number: "+cardNumber+"\nPin: "+pin);
			
			Conn c = new Conn();
			c.s.executeUpdate(query1);
			c.s.executeUpdate(query2);
				setVisible(false);
				new Deposit(pin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		new SignupThree();
	}

}
