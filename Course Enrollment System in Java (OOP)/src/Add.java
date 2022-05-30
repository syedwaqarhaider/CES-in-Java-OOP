import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Add {
	Connection con;
	Statement st;
	ResultSet rs;
	

	public JFrame frame;
	private JTextField CourseName;
	private JTextField CourseID;
	private JTextField Credithours;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add window = new Add();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 708, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 692, 87);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(197, 25, 46, 14);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("         Adding A Course");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(212, 25, 244, 37);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(211, 98, -50, 160);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setForeground(Color.WHITE);
		panel_2.setBounds(0, 88, 193, 409);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("  Course Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 29, 128, 36);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("  Course ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 105, 128, 36);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("  Credit Hours");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 193, 111, 26);
		panel_2.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String p="jdbc:ucanaccess://F:Courses.accdb";
					con=DriverManager.getConnection(p);
					st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					String a="Select * From Table1";
					rs=st.executeQuery(a);
					rs.moveToInsertRow();
					rs.updateString("Course Name",CourseName.getText() );
					rs.updateString("Course ID",CourseID.getText());
					rs.updateString("Credit Hour",Credithours.getText() );
					rs.insertRow();
					st.close();
					rs.close();
					JOptionPane.showMessageDialog(null, "Your record is added");
					
					CourseName.setText("");
					CourseID.setText("");
					Credithours.setText("");
					
				}catch(Exception a){
					JOptionPane.showMessageDialog(null, a.getMessage());
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(32, 296, 128, 36);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new min().frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(32, 343, 128, 36);
		panel_2.add(btnNewButton_1);
		
		CourseName = new JTextField();
		CourseName.setBounds(211, 123, 220, 29);
		frame.getContentPane().add(CourseName);
		CourseName.setColumns(10);
		
		CourseID = new JTextField();
		CourseID.setBounds(211, 198, 220, 29);
		frame.getContentPane().add(CourseID);
		CourseID.setColumns(10);
		
		Credithours = new JTextField();
		Credithours.setBounds(211, 282, 220, 29);
		frame.getContentPane().add(Credithours);
		Credithours.setColumns(10);
	
	}
}
