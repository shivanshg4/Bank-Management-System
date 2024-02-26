	package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener {
	
	JButton rs100, rs500, rs1000, rs2000, rs5000, rs10000, back;
	String pin;
	FastCash(String pin){
		
		this.pin=pin;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\atm2.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel i4 = new JLabel(i3);
		i4.setBounds(0, 0, 900, 900);
		add(i4);
		
		JLabel text= new JLabel("Select Your Amount");
		text.setFont(new Font("Ariel",Font.BOLD,20));
		text.setBounds(210,250,700,30);
		text.setForeground(Color.WHITE);
		i4.add(text);
		
		rs100 = new JButton("Rs 100");
		rs100.setFont(new Font("Ariel",Font.BOLD,12));
		rs100.setBounds(150,405,135,30);
		i4.add(rs100);
		rs100.addActionListener(this);
		
		rs500 = new JButton("Rs 500");
		rs500.setFont(new Font("Ariel",Font.BOLD,12));
		rs500.setBounds(350,405,135,30);
		i4.add(rs500);
		rs500.addActionListener(this);
		
		rs1000 = new JButton("Rs 1000");
		rs1000.setFont(new Font("Ariel",Font.BOLD,12));
		rs1000.setBounds(150,445,135,30);
		i4.add(rs1000);
		rs1000.addActionListener(this);
		
		rs2000 = new JButton("Rs 2000");
		rs2000.setFont(new Font("Ariel",Font.BOLD,12));
		rs2000.setBounds(350,445,135,30);
		i4.add(rs2000);
		rs2000.addActionListener(this);

		rs5000 = new JButton("Rs 5000");
		rs5000.setFont(new Font("Ariel",Font.BOLD,12));
		rs5000.setBounds(150,485,135,30);
		i4.add(rs5000);
		rs5000.addActionListener(this);
		
		rs10000 = new JButton("Rs 10000");
		rs10000.setFont(new Font("Ariel",Font.BOLD,12));
		rs10000.setBounds(350,485,135,30);
		i4.add(rs10000);
		rs10000.addActionListener(this);

		back = new JButton("Back");
		back.setFont(new Font("Ariel",Font.BOLD,12));
		back.setBounds(350,525,135,30);
		i4.add(back);
		back.addActionListener(this);

		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	

	public void actionPerformed(ActionEvent ae) {
		
		int balance=0;
		if(ae.getSource()==back) {
			setVisible(false);
			new Transaction(pin);
		}else {
			String amount = ((JButton)ae.getSource()).getText().substring(3);
			
			Conn c = new Conn();
			try {
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"';");
				
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")){
						balance += Integer.parseInt(rs.getString("amount"));
					}else if(rs.getString("type").equals("Withdrawl")){
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				
				if(!ae.getSource().equals(back) && balance < Integer.parseInt(amount) ) {
					JOptionPane.showMessageDialog(null, "Insuffecient Balance");
					return;
				}else {
					Date date = new Date();
					c.s.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawl','"+amount+"');");
					JOptionPane.showMessageDialog(null,"Amount "+amount+" has been Withdraw");
					setVisible(false);
					new Transaction(pin);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Transaction("");
	}
}
