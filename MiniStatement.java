package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame implements ActionListener {
	
	String pin;
	MiniStatement(String pin){
		this.pin=pin;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\logo.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel i4 = new JLabel(i3);
		i4.setBounds(20, 20, 100, 100);
		add(i4);
		
		JLabel name = new JLabel("My Bank");
		name.setFont(new Font("Raleway",Font.BOLD,25));
		name.setBounds(160,60,100,30);
		add(name);
		
		JLabel card = new JLabel();
		card.setFont(new Font("Raleway",Font.BOLD,16));
		card.setBounds(20,140,400,30);
		add(card);
		
		JLabel mini = new JLabel();
		mini.setFont(new Font("Raleway",Font.BOLD,15));
		mini.setBounds(20,20,400,400);
		add(mini);
		
		JLabel bal = new JLabel();
		bal.setFont(new Font("Raleway",Font.BOLD,16));
		bal.setBounds(20,450,400,30);
		add(bal);
		
		Conn c = new Conn();
		try {
			ResultSet rs =  c.s.executeQuery("select * from login where pin = '"+pin+"';");
			rs.next();
			String cardString = rs.getString("cardnumber");
			card.setText("Card Number : "+cardString.substring(0,4)+"XXXXXXX"+cardString.substring(11));
			
			int balance=0;
			rs =  c.s.executeQuery("select * from bank where pin = '"+pin+"';");
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance+= Integer.parseInt(rs.getString("amount"));
				}
				if(rs.getString("type").equals("Withdrawl")) {
					balance-= Integer.parseInt(rs.getString("amount"));
				}
				
				mini.setText(mini.getText()+"<html>"+ rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br>"+"<html>");
			}
			
			
			
			bal.setText("Your Account Balance is : "+balance);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		setBounds(20,20,400,600);
		setTitle("Mini Statement");
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
	}
	
	public static void main(String[] args) {
		new MiniStatement("");
	}
}