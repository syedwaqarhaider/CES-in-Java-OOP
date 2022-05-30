import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class Update_Instructor {
	Connection con;
	Statement st;
	ResultSet rs;

	public JFrame frame;
	private JTextField NameText;
	private JTextField IDText;
	private JTextField EmailText;
	private JTextField NumberText;
	private JTextField BirthText;
	private JTextField AdressText;

	public Update_Instructor() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 810, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 804, 82);
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("Add Instructor");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(262, 11, 223, 36);
		panel.add(label);
		
		NameText = new JTextField();
		NameText.setColumns(10);
		NameText.setBounds(170, 120, 155, 20);
		frame.getContentPane().add(NameText);
		
		JLabel label1 = new JLabel("Name");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label1.setBounds(27, 117, 133, 23);
		frame.getContentPane().add(label1);
		
		JLabel Label2 = new JLabel("Instructor ID");
		Label2.setHorizontalAlignment(SwingConstants.CENTER);
		Label2.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label2.setBounds(27, 140, 133, 23);
		frame.getContentPane().add(Label2);
		
		IDText = new JTextField();
		IDText.setColumns(10);
		IDText.setBounds(170, 143, 155, 20);
		frame.getContentPane().add(IDText);
		
		EmailText = new JTextField();
		EmailText.setColumns(10);
		EmailText.setBounds(611, 120, 155, 20);
		frame.getContentPane().add(EmailText);
		
		NumberText = new JTextField();
		NumberText.setColumns(10);
		NumberText.setBounds(611, 143, 155, 20);
		frame.getContentPane().add(NumberText);
		
		JLabel label7 = new JLabel("Contect Number");
		label7.setHorizontalAlignment(SwingConstants.CENTER);
		label7.setFont(new Font("Tahoma", Font.BOLD, 15));
		label7.setBounds(468, 140, 133, 23);
		frame.getContentPane().add(label7);
		
		JLabel label6 = new JLabel("Email");
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		label6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label6.setBounds(468, 117, 133, 23);
		frame.getContentPane().add(label6);
		
		JLabel Label3 = new JLabel("Date of Birth");
		Label3.setHorizontalAlignment(SwingConstants.CENTER);
		Label3.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label3.setBounds(26, 179, 133, 23);
		frame.getContentPane().add(Label3);
		
		BirthText = new JTextField();
		BirthText.setColumns(10);
		BirthText.setBounds(169, 182, 155, 20);
		frame.getContentPane().add(BirthText);
		
		JLabel label4 = new JLabel("Gender");
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label4.setBounds(26, 213, 133, 23);
		frame.getContentPane().add(label4);
		
		JCheckBox M_Check = new JCheckBox("Male");
		M_Check.setFont(new Font("Tahoma", Font.BOLD, 15));
		M_Check.setBounds(179, 215, 97, 23);
		frame.getContentPane().add(M_Check);
		
		JCheckBox F_Check = new JCheckBox("Female");
		F_Check.setFont(new Font("Tahoma", Font.BOLD, 15));
		F_Check.setBounds(287, 215, 97, 23);
		frame.getContentPane().add(F_Check);
		ButtonGroup gb= new ButtonGroup();
		gb.add(M_Check);
		gb.add(F_Check);
	
		
		AdressText = new JTextField();
		AdressText.setColumns(10);
		AdressText.setBounds(169, 250, 155, 82);
		frame.getContentPane().add(AdressText);
		
		JLabel label5 = new JLabel("Address");
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label5.setBounds(26, 247, 133, 23);
		frame.getContentPane().add(label5);
		
		JButton Update = new JButton("Update");
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		try {
					
					String s ="jdbc:ucanaccess://F:Database4.accdb";
					con= DriverManager.getConnection(s);
					st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					String sb="Select * from ThisTable";
					rs= st.executeQuery(sb);
					rs.next();
					rs.moveToInsertRow();
					rs.updateString("ID",IDText.getText() );
					rs.updateString("Name",NameText.getText() );
					rs.updateString("Email",EmailText.getText() );
					rs.updateString("Contect",NumberText.getText() );
					rs.updateString("Adress",AdressText.getText() );
					rs.updateString("DateOfBirth",BirthText.getText() );
					if(M_Check.isSelected()){
						rs.updateString("Gender", "Male");
						
					}
					else {
						rs.updateString("Gender", "Female");
					}
					rs.updateRow();
					JOptionPane.showMessageDialog(null, "Instructor has been Registered");
					st.close();
					rs.close();
					con.close();
					IDText.setText(" ");
					NameText.setText(" ");
					EmailText.setText(" ");
					NumberText.setText(" ");
					AdressText.setText(" ");
					BirthText.setText(" ");
					M_Check.setSelected(false);
					F_Check.setSelected(false);
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null,ex.getMessage());
					
				}	
			}
		});
		Update.setFont(new Font("Tahoma", Font.BOLD, 15));
		Update.setBounds(65, 346, 89, 36);
		frame.getContentPane().add(Update);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    frame.setVisible(false);
				new Instructor().frame.setVisible(true);
				
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(373, 346, 89, 36);
		frame.getContentPane().add(button_1);
		
		
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
		 		    NameText.setText(rs.getString("Name"));
					IDText.setText(rs.getString("ID"));
					EmailText.setText(rs.getString("Email"));
					NumberText.setText(rs.getString("Contect"));
					AdressText.setText(rs.getString("Adress"));
					BirthText.setText(rs.getString("DateOfBirth"));
					if (rs.getString("Gender").equals("Male")){
						M_Check.setSelected(true);
					}
					else if (rs.getString("Gender").equals("Female")){
						F_Check.setSelected(true);
					}
					
					break;
				}
				
			}st.close();
			rs.close();
			con.close();
		
		}catch (Exception ex){
			JOptionPane.showMessageDialog(null,ex.getMessage());
			
		}
	 if(i==0)
	 {
		 JOptionPane.showMessageDialog(null,"Your record is not found");
	 }

	}
}
