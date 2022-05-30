import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Search_Instructor {
Connection con;
Statement st;
ResultSet rs;
	public JFrame frame;
	private JTextField Name;
	private JTextField ID;
	private JTextField Email;
	private JTextField Number;
	private JTextField Birth;
	private JTextField Adress;
	public Search_Instructor() {
		initialize();
	}

	 
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 820, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 804, 82);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("Add Instructor");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(262, 11, 223, 36);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(10, 129, 133, 23);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Instructor ID");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(10, 152, 133, 23);
		frame.getContentPane().add(label_2);
		
		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(153, 132, 155, 20);
		frame.getContentPane().add(Name);
		
		ID = new JTextField();
		ID.setColumns(10);
		ID.setBounds(153, 155, 155, 20);
		frame.getContentPane().add(ID);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(594, 132, 155, 20);
		frame.getContentPane().add(Email);
		
		Number = new JTextField();
		Number.setColumns(10);
		Number.setBounds(594, 155, 155, 20);
		frame.getContentPane().add(Number);
		
		JLabel label_3 = new JLabel("Email");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(451, 129, 133, 23);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Contect Number");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(451, 152, 133, 23);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Date of Birth");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(10, 197, 133, 23);
		frame.getContentPane().add(label_5);
		
		Birth = new JTextField();
		Birth.setColumns(10);
		Birth.setBounds(153, 200, 155, 20);
		frame.getContentPane().add(Birth);
		
		JLabel label_6 = new JLabel("Gender");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_6.setBounds(10, 231, 133, 23);
		frame.getContentPane().add(label_6);
		
		JCheckBox Mcheck = new JCheckBox("Male");
		Mcheck.setFont(new Font("Tahoma", Font.BOLD, 15));
		Mcheck.setBounds(163, 233, 97, 23);
		frame.getContentPane().add(Mcheck);
		
		JCheckBox Fcheck = new JCheckBox("Female");
		Fcheck.setFont(new Font("Tahoma", Font.BOLD, 15));
		Fcheck.setBounds(271, 233, 97, 23);
		frame.getContentPane().add(Fcheck);
		
		Adress = new JTextField();
		Adress.setColumns(10);
		Adress.setBounds(153, 268, 155, 82);
		frame.getContentPane().add(Adress);
		
		JLabel label_7 = new JLabel("Address");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_7.setBounds(10, 265, 133, 23);
		frame.getContentPane().add(label_7);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Instructor().frame.setVisible(true);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(362, 381, 89, 36);
		frame.getContentPane().add(button);
	
		int i=0;
		try {
			
			String b=JOptionPane.showInputDialog("Enter ID for updation");
			
			String s ="jdbc:ucanaccess://F:Database4.accdb";
			con= DriverManager.getConnection(s);
			st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sb="Select * from ThisTable";
			rs= st.executeQuery(sb);
		  	while(rs.next())
		   	{
		   		String idcheck = rs.getString("ID");
		   	if(idcheck.equals(b)){
		 		    i++;
					Name.setText(rs.getString("Name"));
					ID.setText(rs.getString("ID"));
					Email.setText(rs.getString("Email"));
					Number.setText(rs.getString("Contect"));
					Adress.setText(rs.getString("Adress"));
					Birth.setText(rs.getString("DateOfBirth"));
					if (rs.getString("Gender").equals("Male")){
						Mcheck.setSelected(true);
					}
					if (rs.getString("Gender").equals("Female")){
						Fcheck.setSelected(true);
					}
					st.close();
					rs.close();
					
					break;
				}
				
			}
		
		}catch (Exception ex){
			JOptionPane.showMessageDialog(null,ex.getMessage());
			
		}
	 if(i==0)
	 {
		 JOptionPane.showMessageDialog(null,"Your record is not found");
	 }
	}
	
	
}
