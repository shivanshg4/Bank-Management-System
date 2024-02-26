package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.chrono.JapaneseDate;
import java.util.*;
import javax.swing.*;

public class SignupOne extends JFrame implements ActionListener {

	static long form;
	JTextField nameText, fnameText, dobText, emailText, addressText, stateText, cityText, pincodeText;
	JRadioButton maleRadio, femaleRadio, married, unmarried, other;

	public SignupOne() {
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\logo.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel i4 = new JLabel(i3);
		i4.setBounds(20, 20, 100, 100);
		add(i4);
		Random rand = new Random();
		form = Math.abs(rand.nextLong() % 9000L);
		JLabel formNo = new JLabel("Application Form no. " + form);
		formNo.setFont(new Font("Ariel", Font.BOLD, 28));
		formNo.setBounds(250, 50, 500, 30);
		add(formNo);

		JLabel pageNo = new JLabel("Page one : Personal Details");
		pageNo.setFont(new Font("Ariel", Font.BOLD, 20));
		pageNo.setBounds(280, 110, 500, 30);
		add(pageNo);

		JLabel name = new JLabel("Name :");
		name.setFont(new Font("Ariel", Font.BOLD, 20));
		name.setBounds(200, 170, 500, 30);
		add(name);

		nameText = new JTextField();
		nameText.setFont(new Font("Ariel", 0, 20));
		nameText.setBounds(400, 170, 300, 30);
		add(nameText);

		JLabel fName = new JLabel("Father's Name :");
		fName.setFont(new Font("Raleway", Font.BOLD, 18));
		fName.setBounds(200, 220, 500, 30);
		add(fName);

		fnameText = new JTextField();
		fnameText.setFont(new Font("Raleway", 0, 18));
		fnameText.setBounds(400, 220, 300, 30);
		add(fnameText);

		JLabel dob = new JLabel("Date of Birth :");
		dob.setFont(new Font("Raleway", Font.BOLD, 18));
		dob.setBounds(200, 270, 500, 30);
		add(dob);

		dobText = new JTextField();
		dobText.setToolTipText("dd/mm/yyyy");
		dobText.setFont(new Font("Raleway", 0, 18));
		dobText.setBounds(400, 270, 300, 30);
		add(dobText);

		JLabel gender = new JLabel("Gender :");
		gender.setFont(new Font("Ariel", Font.BOLD, 20));
		gender.setBounds(200, 320, 500, 30);
		add(gender);

		maleRadio = new JRadioButton("Male");
		maleRadio.setFont(new Font("Ariel", Font.BOLD, 15));
		maleRadio.setBounds(400, 320, 100, 30);
		maleRadio.setBackground(Color.WHITE);
		add(maleRadio);

		femaleRadio = new JRadioButton("Female");
		femaleRadio.setFont(new Font("Ariel", Font.BOLD, 15));
		femaleRadio.setBounds(600, 320, 100, 30);
		femaleRadio.setBackground(Color.WHITE);
		add(femaleRadio);

		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(maleRadio);
		genderGroup.add(femaleRadio);

		JLabel email = new JLabel("Email Address :");
		email.setFont(new Font("Ariel", Font.BOLD, 20));
		email.setBounds(200, 370, 500, 30);
		add(email);

		emailText = new JTextField();
		emailText.setFont(new Font("Raleway", 0, 18));
		emailText.setBounds(400, 370, 300, 30);
		add(emailText);

		JLabel marital = new JLabel("Marital Status :");
		marital.setFont(new Font("Ariel", Font.BOLD, 20));
		marital.setBounds(200, 420, 500, 30);
		add(marital);

		married = new JRadioButton("Married");
		married.setFont(new Font("Ariel", Font.BOLD, 15));
		married.setBounds(400, 420, 100, 30);
		married.setBackground(Color.WHITE);
		add(married);

		unmarried = new JRadioButton("Unmarried");
		unmarried.setFont(new Font("Ariel", Font.BOLD, 15));
		unmarried.setBounds(500, 420, 120, 30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);

		other = new JRadioButton("Other");
		other.setFont(new Font("Ariel", Font.BOLD, 15));
		other.setBounds(630, 420, 100, 30);
		other.setBackground(Color.WHITE);
		add(other);

		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(married);
		maritalGroup.add(unmarried);
		maritalGroup.add(other);

		JLabel Address = new JLabel("Address : ");
		Address.setFont(new Font("Ariel", Font.BOLD, 20));
		Address.setBounds(200, 470, 500, 30);
		add(Address);

		addressText = new JTextField();
		addressText.setFont(new Font("Raleway", 0, 18));
		addressText.setBounds(400, 470, 300, 30);
		add(addressText);

		JLabel city = new JLabel("City : ");
		city.setFont(new Font("Ariel", Font.BOLD, 20));
		city.setBounds(200, 520, 500, 30);
		add(city);

		cityText = new JTextField();
		cityText.setFont(new Font("Raleway", 0, 18));
		cityText.setBounds(400, 520, 300, 30);
		add(cityText);

		JLabel state = new JLabel("State : ");
		state.setFont(new Font("Ariel", Font.BOLD, 20));
		state.setBounds(200, 570, 500, 30);
		add(state);

		stateText = new JTextField();
		stateText.setFont(new Font("Raleway", 0, 18));
		stateText.setBounds(400, 570, 300, 30);
		add(stateText);

		JLabel pincode = new JLabel("Pin Code : ");
		pincode.setFont(new Font("Ariel", Font.BOLD, 20));
		pincode.setBounds(200, 620, 500, 30);
		add(pincode);

		pincodeText = new JTextField();
		pincodeText.setFont(new Font("Raleway", 0, 18));
		pincodeText.setBounds(400, 620, 300, 30);
		add(pincodeText);

		JButton next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(400, 670, 300, 30);
		add(next);
		next.addActionListener(this);

		getContentPane().setBackground(Color.WHITE);
		setTitle("Automated Teller Machine");
		setLocation(350, 10);
		setSize(850, 800);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		try {
			String formNo = "" + form;
			String name = nameText.getText();
			String dob = dobText.getText();
			String address = addressText.getText();
			String email = emailText.getText();
			String gender = null;
			if (maleRadio.isSelected()) {
				gender = "Male";
			} else if (femaleRadio.isSelected()) {
				gender = "Female";
			}
			String marital = null;
			if (married.isSelected()) {
				marital = "Married";
			} else if (unmarried.isSelected()) {
				marital = "Unmarried";
			} else if (other.isSelected()) {
				marital = "Other";
			}
			String state = stateText.getText();
			String city = cityText.getText();
			String pincode = pincodeText.getText();
			String fname = fnameText.getText();

			Conn c = new Conn();
			String query = "insert into signupone values('" + formNo + "','" + name + "','" + fname + "','" + dob
					+ "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + state
					+ "','" + pincode + "');";

			if (formNo.equals("") || name.equals("") || fname.equals("") || dob.equals("") || gender.equals("")
					|| email.equals("") || marital.equals("") || address.equals("") || city.equals("")
					|| state.equals("") || pincode.equals("")) {
				JOptionPane.showMessageDialog(null, "Please complete all given fields");

			} else {
				c.s.executeUpdate(query);
				setVisible(false);
				new SignupTwo();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SignupOne();
	}
}
