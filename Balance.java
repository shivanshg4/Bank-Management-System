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

public class Balance extends JFrame implements ActionListener {

	JButton back;
	String pin;

	Balance(String pin) {
		this.pin = pin;

		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\atm2.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		Conn c = new Conn();
		int balance=0;
		try {
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"';");
			
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")){
					balance += Integer.parseInt(rs.getString("amount"));
				}else if(rs.getString("type").equals("Withdrawl")){
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
						
			JLabel text = new JLabel("Your Account Balance is Rs "+balance+".");
			text.setForeground(Color.WHITE);
			text.setBounds(200, 300, 400, 30);
			text.setFont(new Font("Raleway", Font.BOLD, 16));
			image.add(text);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		


		back = new JButton("Back");
		back.setFont(new Font("Ariel", Font.BOLD, 16));
		back.setBounds(350, 530, 150, 30);
		image.add(back);
		back.addActionListener(this);

		setBounds(300, 0, 900, 900);
		setUndecorated(true);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==back) {
			setVisible(false);
			new Transaction(pin);
		}
			
	}

	public static void main(String[] args) {
		new Balance("");
	}

}

