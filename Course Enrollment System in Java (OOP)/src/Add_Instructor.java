import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Add_Instructor {
   
	Connection con ;
	Statement st;
	ResultSet rs;
	public JFrame frame;
	private JTextField NameTextFeild;
	private JTextField IdTextFeild;
	private JTextField EmailTextFeild;
	private JTextField ContectTextFeild;
	private JTextField Birth;
	private JTextField AddressTextF;
	public Add_Instructor() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 820, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 149, 133, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFatherName = new JLabel("Instructor ID");
		lblFatherName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFatherName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFatherName.setBounds(20, 172, 133, 23);
		frame.getContentPane().add(lblFatherName);
		
		NameTextFeild = new JTextField();
		NameTextFeild.setBounds(163, 152, 155, 20);
		frame.getContentPane().add(NameTextFeild);
		NameTextFeild.setColumns(10);
		
		IdTextFeild = new JTextField();
		IdTextFeild.setColumns(10);
		IdTextFeild.setBounds(163, 175, 155, 20);
		frame.getContentPane().add(IdTextFeild);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(461, 149, 133, 23);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblContectNumber = new JLabel("Contect Number");
		lblContectNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblContectNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContectNumber.setBounds(461, 172, 133, 23);
		frame.getContentPane().add(lblContectNumber);
		
		EmailTextFeild = new JTextField();
		EmailTextFeild.setColumns(10);
		EmailTextFeild.setBounds(604, 152, 155, 20);
		frame.getContentPane().add(EmailTextFeild);
		
		ContectTextFeild = new JTextField();
		ContectTextFeild.setColumns(10);
		ContectTextFeild.setBounds(604, 175, 155, 20);
		frame.getContentPane().add(ContectTextFeild);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 804, 82);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Add Instructor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(262, 11, 223, 36);
		panel.add(lblNewLabel_1);
		
		JLabel lblGender = new JLabel("Date of Birth");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(20, 211, 133, 23);
		frame.getContentPane().add(lblGender);
		
		JLabel lblAdress = new JLabel("Gender");
		lblAdress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdress.setBounds(20, 245, 133, 23);
		frame.getContentPane().add(lblAdress);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(20, 279, 133, 23);
		frame.getContentPane().add(lblAddress);
		
		Birth = new JTextField();
		Birth.setColumns(10);
		Birth.setBounds(163, 214, 155, 20);
		frame.getContentPane().add(Birth);
		
		AddressTextF = new JTextField();
		AddressTextF.setColumns(10);
		AddressTextF.setBounds(163, 282, 155, 82);
		frame.getContentPane().add(AddressTextF);
		
		
		JCheckBox MaleCheck = new JCheckBox("Male");
		MaleCheck.setFont(new Font("Tahoma", Font.BOLD, 15));
		MaleCheck.setBounds(173, 247, 97, 23);
		frame.getContentPane().add(MaleCheck);
		
		JCheckBox Femalecheck = new JCheckBox("Female");
		Femalecheck.setFont(new Font("Tahoma", Font.BOLD, 15));
		Femalecheck.setBounds(281, 247, 97, 23);
		frame.getContentPane().add(Femalecheck);
		ButtonGroup bg= new ButtonGroup();
		bg.add(MaleCheck);
		bg.add(Femalecheck);
		
		
		JButton SaveButton = new JButton("Save");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					
					String s ="jdbc:ucanaccess://F:Database4.accdb";
					con= DriverManager.getConnection(s);
					st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					String sb="Select * from ThisTable";
					rs= st.executeQuery(sb);
					rs.moveToInsertRow();
					rs.updateString("ID",IdTextFeild.getText() );
					rs.updateString("Name",NameTextFeild.getText() );
					rs.updateString("Email",EmailTextFeild.getText() );
					rs.updateString("Contect",ContectTextFeild.getText() );
					rs.updateString("Adress",AddressTextF.getText() );
					rs.updateString("DateOfBirth",Birth.getText() );
					if(MaleCheck.isSelected()){
						rs.updateString("Gender", "Male");
						
					}
					else {
						rs.updateString("Gender", "Female");
					}
					rs.insertRow();
					JOptionPane.showMessageDialog(null, "Instructor has been Registered");
					st.close();
					rs.close();
					
					IdTextFeild.setText(" ");
					NameTextFeild.setText(" ");
					EmailTextFeild.setText(" ");
					ContectTextFeild.setText(" ");
					AddressTextF.setText(" ");
					Birth.setText(" ");
					MaleCheck.setSelected(false);
					Femalecheck.setSelected(false);
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null,ex.getMessage());
					
				}

			}
		});

		SaveButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		SaveButton.setBounds(64, 395, 89, 36);
		frame.getContentPane().add(SaveButton);
		
		JButton btnMainMenue = new JButton("Main Menue");
		btnMainMenue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Instructor().frame.setVisible(true);
			}
		});
		btnMainMenue.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMainMenue.setBounds(196, 395, 133, 36);
		frame.getContentPane().add(btnMainMenue);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new Instructor().frame.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(372, 395, 89, 36);
		frame.getContentPane().add(btnBack);
		
		
		
	}
}
