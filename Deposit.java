package bankManagementSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener {
	
	JButton deposit, back;
	JTextField amount; 
	String pin;
	Deposit(String pin){
		this.pin=pin;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\atm2.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("---Enter Amount You want to Deposit---");
		text.setFont(new Font("Ariel",Font.BOLD,18) );
		text.setForeground(Color.WHITE);
		text.setBounds(150,260,1000,30);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Ariel",Font.BOLD,16) );
		amount.setBounds(200,320,200,30);
		amount.setHorizontalAlignment(JTextField.CENTER);
		image.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setFont(new Font("Ariel",Font.BOLD,16));
		deposit.setBounds(350,485,150,30);
		image.add(deposit);
		deposit.addActionListener(this);

		
		back = new JButton("Back");
		back.setFont(new Font("Ariel",Font.BOLD,16));
		back.setBounds(350,530,150,30);
		image.add(back);
		back.addActionListener(this);
		
		setLocation(300,0);
		setSize(900,900);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==deposit) {
			String number = amount.getText();
			Date date = new Date();
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter Amount");
			}else {
				try {
					String query = "insert into bank values('"+pin+"','"+date+"','Deposit','"+number+"');";
					Conn c = new Conn();
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Amount "+number+" has been Debited");
					setVisible(false);
					new Transaction(pin);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(ae.getSource()==back) {
			setVisible(false);
			new Transaction(pin);
		}
	}
	
	public static void main(String[] args) {
		new Deposit("");
	}
}
