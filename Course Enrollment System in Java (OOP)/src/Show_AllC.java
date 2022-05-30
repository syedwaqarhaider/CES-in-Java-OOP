import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JTextArea;
import java.sql.*;
public class Show_AllC {
  Connection con;
  Statement st;
  ResultSet rs;
	public JFrame frame;
     private JButton b;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Show_All window = new Show_All();
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
	public Show_AllC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame("SHOW ALL COURSES");
		frame.getContentPane().setBackground(SystemColor.controlHighlight);
		frame.setBounds(00, 00, 1400, 820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(0, 0, 1384, 107);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAllCourses = new JLabel("All Courses");
		lblAllCourses.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllCourses.setBounds(515, 8, 385, 88);
		lblAllCourses.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(lblAllCourses);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBounds(0, 106, 1384, 51);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		b = new JButton("Back");
		b.setBounds(10,10,70,30);
		panel.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			  new min().frame.setVisible(true);
			}
			});
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCourseName.setBounds(10, 11, 146, 29);
		panel_1.add(lblCourseName);
		
		JLabel lblCourseId = new JLabel("Course ID");
		lblCourseId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCourseId.setBounds(498, 11, 146, 29);
		panel_1.add(lblCourseId);
		
		JLabel lblCreditHour = new JLabel("Credit Hour");
		lblCreditHour.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCreditHour.setBounds(907, 11, 146, 29);
		panel_1.add(lblCreditHour);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtArea.setColumns(3);
		txtArea.setBounds(0, 156, 1384, 625);
		frame.getContentPane().add(txtArea);
		
		try
		{
			String p="jdbc:ucanaccess://F:Courses.accdb";
			con=DriverManager.getConnection(p);
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String a="Select * From Table1";
			rs=st.executeQuery(a);
   
			  while(rs.next())
			  { 
				txtArea.append("     "+rs.getString("Course Name")+"\t\t\t\t\t"+rs.getString("Course ID")+"\t\t\t\t\t"+rs.getString("Credit Hour"));
				txtArea.append("\n");
			    
			  }
			    st.close();
			    rs.close();
			    con.close();
				
		}catch(Exception show)
		{
			JOptionPane.showMessageDialog(null,show.getMessage());
		}
	}
}
