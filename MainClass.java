package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainClass extends JFrame implements ActionListener{
	
	JButton login, signup, clear; 
	JPasswordField pinTextFeild;
	JTextField cardTextFeild;
	public MainClass() {
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\logo.png"));
		Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel lable = new JLabel(i3);
		add(lable);
		lable.setBounds(70,10,100,100);
		
		JLabel text = new JLabel("WELCOME TO MY BANK");
		add(text);
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(200,40,500,60);
		
		JLabel cardno = new JLabel(" Enter Card No. :");
		add(cardno);
		cardno.setFont(new Font("Ariel",Font.BOLD,28));
		cardno.setBounds(72,140,300,40);
		
		cardTextFeild = new JTextField();
		cardTextFeild.setFont(new Font("Ariel",0,28));

		cardTextFeild.setBounds(350,150,300,35);
		add(cardTextFeild);
		
		JLabel pin = new JLabel("Enter Pin :");
		add(pin);
		pin.setFont(new Font("Ariel",Font.BOLD,28));
		pin.setBounds(150,200,500,40);
		
		
		pinTextFeild = new JPasswordField();
		pinTextFeild.setBounds(350,210,300,35);
		pinTextFeild.setFont(new Font("Ariel",0,28));
		add(pinTextFeild);
		
		login = new JButton("LOGIN");
		login.setBounds(350,275,130,40);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		add(login);
		login.addActionListener(this);
		
		clear = new JButton("CLEAR");
		clear.setBounds(520,275,130,40);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		add(clear);
		clear.addActionListener(this);

		signup = new JButton("SIGN UP");
		signup.setBounds(350,340,300,40);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		add(signup);
		signup.addActionListener(this);
		
		
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		setTitle("Automated Teller Machine");
		setBounds(350,200,800,480);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==clear) {
			cardTextFeild.setText("");
			pinTextFeild.setText("");
		}else if(ae.getSource()==login) {
			
			String cardNumber = cardTextFeild.getText();
			String pin = pinTextFeild.getText();
			String query="select *from login where cardnumber='"+cardNumber+"'and pin='"+pin+"';" ;
			
			try {
				Conn c = new Conn();
				ResultSet result= c.s.executeQuery(query);
				if(result.next()) {
					setVisible(false);
					new Transaction(pin);
				}
				else {
					JOptionPane.showMessageDialog(null,"Card Number or Pin INCORRECT");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==signup) {
			setVisible(false);
			new SignupOne();
		}
	}
	public static void main(String[] args) {
		new MainClass();
	}

}
