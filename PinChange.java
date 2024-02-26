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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PinChange extends JFrame implements ActionListener {

	JPasswordField npin, rpin;
	JButton change, back;
	String pin;

	PinChange(String pin) {
		this.pin = pin;

		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\atm2.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		JLabel text = new JLabel("Change Your PIN");
		text.setForeground(Color.WHITE);
		text.setBounds(240, 260, 200, 30);
		text.setFont(new Font("Raleway", Font.BOLD, 20));
		image.add(text);

		JLabel text2 = new JLabel("Enter New PIN");
		text2.setForeground(Color.WHITE);
		text2.setBounds(130, 320, 200, 30);
		text2.setFont(new Font("Raleway", Font.BOLD, 18));
		image.add(text2);

		npin = new JPasswordField();
		npin.setBounds(330, 320, 150, 30);
		npin.setFont(new Font("Raleway", Font.BOLD, 18));
		image.add(npin);

		JLabel text3 = new JLabel("Re-Enter New PIN");
		text3.setForeground(Color.WHITE);
		text3.setBounds(130, 360, 200, 30);
		text3.setFont(new Font("Raleway", Font.BOLD, 18));
		image.add(text3);

		rpin = new JPasswordField();
		rpin.setBounds(330, 360, 150, 30);
		rpin.setFont(new Font("Raleway", Font.BOLD, 18));
		image.add(rpin);

		change = new JButton("Change");
		change.setFont(new Font("Ariel", Font.BOLD, 16));
		change.setBounds(350, 485, 150, 30);
		image.add(change);
		change.addActionListener(this);

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
		}
		else {
			String newPin = npin.getText();
			String rNewPin = rpin.getText();
			if(newPin.equals("") || rNewPin.equals("")){
				JOptionPane.showMessageDialog(null, "Please Enter PIN");
				return;
			}else if(!newPin.equals(rNewPin)){
				JOptionPane.showMessageDialog(null, "PIN not Matched");
				return;
			}else
			{
				try {
					
					Conn c = new Conn();
					c.s.executeUpdate("update login set pin = '"+newPin+"' where pin= '"+pin+"';");
					c.s.executeUpdate("update signupthree set pin = '"+newPin+"' where pin= '"+pin+"';");
					c.s.executeUpdate("update bank set pin = '"+newPin+"' where pin= '"+pin+"';");
					
					JOptionPane.showMessageDialog(null, "PIN Changed");
					setVisible(false);
					new Transaction(newPin);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new PinChange("");
	}

}
