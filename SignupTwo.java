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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignupTwo extends JFrame implements ActionListener {

	long form=SignupOne.form;
	JComboBox religionBox, incomeBox, educationBox, catagoryBox, occupationBox;
	JTextField panText, aadharText;
	JRadioButton seniorRadio, notSeniorRadio, notExistingRadio, existingRadio;

	public SignupTwo() {
		setLayout(null);
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

		JLabel pageNo = new JLabel("Page Two : Additional Details");
		pageNo.setFont(new Font("Ariel", Font.BOLD, 20));
		pageNo.setBounds(280, 110, 500, 30);
		add(pageNo);

		JLabel religion = new JLabel("Religion :");
		religion.setFont(new Font("Ariel", Font.BOLD, 20));
		religion.setBounds(200, 170, 500, 30);
		add(religion);
		
		String list1[] = {" ","Hindu","Muslim","Sikh","Cristian","Other"};
		religionBox = new JComboBox(list1);
		religionBox.setFont(new Font("Ariel", 0, 18));
		religionBox.setBackground(Color.WHITE);
		religionBox.setBounds(400, 170, 300, 30);
		add(religionBox);

		JLabel catagory = new JLabel("Catagory :");
		catagory.setFont(new Font("Ariel", Font.BOLD, 20));
		catagory.setBounds(200, 220, 500, 30);
		add(catagory);

		String list2[] = {" ","General","OBC","SC","ST","Other"};
		catagoryBox = new JComboBox(list2);
		catagoryBox.setFont(new Font("Ariel", 0, 18));
		catagoryBox.setBackground(Color.WHITE);
		catagoryBox.setBounds(400, 220, 300, 30);
		add(catagoryBox);

		JLabel income = new JLabel("Income :");
		income.setFont(new Font("Ariel", Font.BOLD, 20));
		income.setBounds(200, 270, 500, 30);
		add(income);

		String list3[] = {"Null"," < 1,50,000 ","< 2,50,000", "< 5,00,000","UPTO 10,00,000","Student"};
		incomeBox = new JComboBox(list3);
		incomeBox.setFont(new Font("Ariel", 0, 18));
		incomeBox.setBackground(Color.WHITE);
		incomeBox.setBounds(400, 270, 300, 30);
		add(incomeBox);
		
		JLabel education1 = new JLabel("Educational ");
		education1.setFont(new Font("Ariel", Font.BOLD, 20));
		education1.setBounds(200, 320, 500, 30);
		add(education1);
		
		JLabel education2 = new JLabel("Qualification :");
		education2.setFont(new Font("Ariel", Font.BOLD, 20));
		education2.setBounds(200, 350, 500, 30);
		add(education2);
		
		String list4[] = {" ","Non-Graduate","Graduate", "Post Graduate","Doctrate","other"};
	    educationBox = new JComboBox(list4);
		educationBox.setFont(new Font("Ariel", 0, 18));
		educationBox.setBackground(Color.WHITE);
		educationBox.setBounds(400, 350, 300, 30);
		add(educationBox);

		JLabel occupation = new JLabel("Occupaiton :");
		occupation.setFont(new Font("Ariel", Font.BOLD, 20));
		occupation.setBounds(200, 400, 500, 30);
		add(occupation);
		
		String list5[] = {" ","Salaried","Self Employed", "Bussiness","Retired","Student","Other"};
		occupationBox = new JComboBox(list5);
		occupationBox.setFont(new Font("Ariel", 0, 18));
		occupationBox.setBackground(Color.WHITE);
		occupationBox.setBounds(400, 400, 300, 30);
		add(occupationBox);

		JLabel pan = new JLabel("PAN Number :");
		pan.setFont(new Font("Ariel", Font.BOLD, 20));
		pan.setBounds(200, 450, 500, 30);
		add(pan);
		
		panText = new JTextField();
		panText.setFont(new Font("Ariel", 0, 18));
		panText.setBounds(400, 450, 300, 30);
		add(panText);

		JLabel adhar = new JLabel("AADHAR Number : ");
		adhar.setFont(new Font("Ariel", Font.BOLD, 20));
		adhar.setBounds(200, 500, 500, 30);
		add(adhar);

		aadharText = new JTextField();
		aadharText.setFont(new Font("Raleway", 0, 18));
		aadharText.setBounds(400, 500, 300, 30);
		add(aadharText);

		JLabel senior = new JLabel("Senior citizen : ");
		senior.setFont(new Font("Ariel", Font.BOLD, 20));
		senior.setBounds(200, 550, 500, 30);
		add(senior);
		
		seniorRadio = new JRadioButton("Yes");
		seniorRadio.setFont(new Font("Ariel", Font.BOLD, 15));
		seniorRadio.setBounds(400, 550, 100, 30);
		seniorRadio.setBackground(Color.WHITE);
		add(seniorRadio);

		notSeniorRadio = new JRadioButton("No");
		notSeniorRadio.setFont(new Font("Ariel", Font.BOLD, 15));
		notSeniorRadio.setBounds(600, 550, 100, 30);
		notSeniorRadio.setBackground(Color.WHITE);
		add(notSeniorRadio);

		ButtonGroup seniorGroup = new ButtonGroup();
		seniorGroup.add(seniorRadio);
		seniorGroup.add(notSeniorRadio);

		JLabel existingAccount = new JLabel("Existing Account : ");
		existingAccount.setFont(new Font("Ariel", Font.BOLD, 20));
		existingAccount.setBounds(200, 600, 500, 30);
		add(existingAccount);
		
		existingRadio = new JRadioButton("Yes");
		existingRadio.setFont(new Font("Ariel", Font.BOLD, 15));
		existingRadio.setBounds(400, 600, 100, 30);
		existingRadio.setBackground(Color.WHITE);
		add(existingRadio);

		notExistingRadio = new JRadioButton("No");
		notExistingRadio.setFont(new Font("Ariel", Font.BOLD, 15));
		notExistingRadio.setBounds(600, 600, 100, 30);
		notExistingRadio.setBackground(Color.WHITE);
		add(notExistingRadio);

		ButtonGroup existingGroup = new ButtonGroup();
		existingGroup.add(existingRadio);
		existingGroup.add(notExistingRadio);
		

		JButton next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(400, 650, 300, 30);
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
			String pan = panText.getText();
			String aadhar = aadharText.getText();
			String senior = null;
			if (seniorRadio.isSelected()) {
				senior = "Yes";
			} else if (notSeniorRadio.isSelected()) {
				senior = "No";
			}
			String exist = null;
			if (existingRadio.isSelected()) {
				exist = "Yes";
			} else if (notExistingRadio.isSelected()) {
				exist = "No";
			} 
			
			String religion = (String)religionBox.getSelectedItem();
			String income = (String)incomeBox.getSelectedItem();
			String education = (String)educationBox.getSelectedItem();
			String catagory = (String)catagoryBox.getSelectedItem();
			String occupation = (String)occupationBox.getSelectedItem();
			
			if (formNo.equals("") || religion.equals("") || income.equals("") || education.equals("") || catagory.equals("")
					|| occupation.equals("") || senior.equals("") || exist.equals("") || pan.equals("")
					|| aadhar.equals("") ) {
				JOptionPane.showMessageDialog(null, "Please complete all given fields");

			}else {
				Conn c = new Conn();
				String query = "insert into signuptwo values('" + formNo + "','" + religion + "','" + income + "','" + education + "','"
							+ catagory + "','" + occupation + "','" + senior + "','" + exist + "','" + pan + "','" + aadhar + "');";
				
					c.s.executeUpdate(query);
				setVisible(false);
				new SignupThree();
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SignupTwo();
	}
}
