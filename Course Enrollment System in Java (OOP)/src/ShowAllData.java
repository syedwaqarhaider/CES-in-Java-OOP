import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowAllData {
   Connection con;
   Statement st;
   ResultSet rs;
	public JFrame frame;
	public ShowAllData() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0,0,848,400);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 801, 69);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAllRegisteredInstructor = new JLabel("All Registered Instructor");
		lblAllRegisteredInstructor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAllRegisteredInstructor.setBounds(286, 29, 432, 29);
		panel.add(lblAllRegisteredInstructor);
		
		JButton Back = new JButton("\u2264");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new Instructor().frame.setVisible(true);
			}
		});
		Back.setFont(new Font("Tahoma", Font.BOLD, 16));
		Back.setBounds(0, 0, 67, 20);
		panel.add(Back);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 71, 88, 25);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(115, 71, 88, 25);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(225, 71, 88, 25);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblContect = new JLabel("Contect ");
		lblContect.setBounds(348, 71, 88, 25);
		lblContect.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContect.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblContect);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(471, 71, 88, 25);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblGender);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(582, 71, 88, 25);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblDateofbirth = new JLabel("DateOfBirth");
		lblDateofbirth.setBounds(692, 71, 172, 25);
		lblDateofbirth.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDateofbirth.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblDateofbirth);
		
		JTextArea TextArea = new JTextArea();
		TextArea.setBounds(0, 107, 832, 254);
		frame.getContentPane().add(TextArea);
		try {
			String s ="jdbc:ucanaccess://F:Database4.accdb";
			con= DriverManager.getConnection(s);
			st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sb="Select * from ThisTable";
			rs= st.executeQuery(sb);
			while(rs.next()){
				TextArea.append(rs.getString("ID")+"\t"+rs.getString("Name")+"\t"+rs.getString("Email")+"\t"+rs.getString("Contect")+"\t"+rs.getString("Adress")+"\t"+rs.getString("Gender")+"\t       "+rs.getString("DateOfBirth"));	
		TextArea.append("\n");
			}
			
			
			
			
		}catch(Exception ex){
			
		}
		
		
 	}
}
