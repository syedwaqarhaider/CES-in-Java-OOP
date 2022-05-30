import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.sql.*
;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;public class show_All_S {
   Connection con;
   Statement st;
   ResultSet rs;
   
	
	public  JFrame frame;
	//private JTable table;

	/**
	 * Launch the application.
	 */

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					show_all window = new show_all();
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
	public show_All_S() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(00,00,1380, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	/*	table = new JTable();
		table.setBounds(92, 72, 1, 1);
		frame.getContentPane().add(table);
		*/
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1354, 73);
		panel.setBackground(new Color(221, 160, 221));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStudentRecord = new JLabel("Student Record");
		lblStudentRecord.setBounds(508, 11, 325, 62);
		lblStudentRecord.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(lblStudentRecord);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new Student().frame.setVisible(true);
				
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(10, 11, 114, 33);
		panel.add(btnBack);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(0, 72, 77, 26);
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblStudentId);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(87, 72, 100, 26);
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblStudentName);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setBounds(197, 72, 93, 26);
		lblFatherName.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblFatherName);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setBounds(300, 72, 115, 26);
		lblContactNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblContactNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(488, 72, 93, 26);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblEmail);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setBounds(626, 72, 93, 26);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(729, 72, 93, 26);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblGender);
		
		JLabel lblCast = new JLabel("Cast");
		lblCast.setBounds(796, 72, 47, 26);
		lblCast.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblCast);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(868, 72, 63, 26);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblAddress);
		
		JLabel lblCourseId = new JLabel("Course ID");
		lblCourseId.setBounds(941, 72, 77, 26);
		lblCourseId.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblCourseId);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(1017, 72, 93, 26);
		lblCourseName.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblCourseName);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(1120, 72, 83, 26);
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblDepartment);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setFont(new Font("Monospaced", Font.BOLD, 12));
		txtArea.setBounds(0, 106, 1354, 554);
		frame.getContentPane().add(txtArea);
		
		JLabel lblTotalFees = new JLabel("Total Fees");
		lblTotalFees.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalFees.setBounds(1213, 72, 77, 26);
		frame.getContentPane().add(lblTotalFees);
		
		
		
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSemester.setBounds(1287, 72, 77, 26);
		frame.getContentPane().add(lblSemester);
	    try
	    {
	    	  String db = "jdbc:ucanaccess://F:NewForm.accdb";
	             con = DriverManager.getConnection(db); 
	             st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	             String sql = "select * from NewForm";
	            rs = st.executeQuery(sql);
	            while(rs.next())
	            {
	            	txtArea.append("   " +rs.getString("Student ID")+"       "+rs.getString("Student Name")+"    "+rs.getString("Father Name")+"    "
	            			+rs.getString("Contact Number")+"     "+rs.getString("Email")+"  "+rs.getString("Date of Birth")+"     "+rs.getString("Gender")
	            			+"    "+rs.getString("Cast")+"    "+rs.getString("Address")+"      "+rs.getString("Course ID")+"        "
	            		     +rs.getString("Course Name")+"           "+rs.getString("Department")+"          "+rs.getString("Total Fees")+"    "+rs.getString("Semester"));  
	            	txtArea.append("\n");
	            }

	    }catch(Exception sh)
	    {
	    	JOptionPane.showMessageDialog(null,sh.getMessage());
	    }
	
	}
}
