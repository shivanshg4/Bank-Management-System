package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transaction extends JFrame implements ActionListener {
	
	JButton deposit, withdrawal, fastCash, miniStatement, pinChange, balance, exit;
	String pin;
	Transaction(String pin){
		
		this.pin=pin;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\atm2.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel i4 = new JLabel(i3);
		i4.setBounds(0, 0, 900, 900);
		add(i4);
		
		JLabel text= new JLabel("Select Your Transaction");
		text.setFont(new Font("Ariel",Font.BOLD,20));
		text.setBounds(210,250,700,30);
		text.setForeground(Color.WHITE);
		i4.add(text);
		
		deposit = new JButton("Deposit ");
		deposit.setFont(new Font("Ariel",Font.BOLD,12));
		deposit.setBounds(150,405,135,30);
		i4.add(deposit);
		deposit.addActionListener(this);
		
		withdrawal = new JButton("Cash Withdrawal");
		withdrawal.setFont(new Font("Ariel",Font.BOLD,12));
		withdrawal.setBounds(350,405,135,30);
		i4.add(withdrawal);
		withdrawal.addActionListener(this);
		
		fastCash = new JButton("FastCash");
		fastCash.setFont(new Font("Ariel",Font.BOLD,12));
		fastCash.setBounds(150,445,135,30);
		i4.add(fastCash);
		fastCash.addActionListener(this);
		
		miniStatement = new JButton("MiniStatement");
		miniStatement.setFont(new Font("Ariel",Font.BOLD,12));
		miniStatement.setBounds(350,445,135,30);
		i4.add(miniStatement);
		miniStatement.addActionListener(this);

		pinChange = new JButton("PinChange");
		pinChange.setFont(new Font("Ariel",Font.BOLD,12));
		pinChange.setBounds(150,485,135,30);
		i4.add(pinChange);
		pinChange.addActionListener(this);
		
		balance = new JButton("Balance Enquiry");
		balance.setFont(new Font("Ariel",Font.BOLD,12));
		balance.setBounds(350,485,135,30);
		i4.add(balance);
		balance.addActionListener(this);

		exit = new JButton("Exit");
		exit.setFont(new Font("Ariel",Font.BOLD,12));
		exit.setBounds(350,525,135,30);
		i4.add(exit);
		exit.addActionListener(this);

		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==deposit) {
			setVisible(false);
			new Deposit(pin);
		}else if(ae.getSource()==withdrawal) {
			setVisible(false);
			new Withdrawl(pin);
			
		}else if(ae.getSource()==fastCash) {
			setVisible(false);
			new FastCash(pin);
		}else if(ae.getSource()==miniStatement) {
			new MiniStatement(pin);
		}else if(ae.getSource()==pinChange) {
			setVisible(false);
			new PinChange(pin).setVisible(true);
		}else if(ae.getSource()==balance) {
			setVisible(false);
			new Balance(pin).setVisible(true);
		}else if(ae.getSource()==exit) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Transaction("");
	}
}
