

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
public class Update_Student{
	Connection con=null;
	Statement st;
    ResultSet rs;
	public JFrame frame;
	private JTextField studentIdtxtfld;
	private JTextField studentNametxtfld;
	private JTextField contactNumbertxtfld;
	private JTextField emailtxtfld;
	private JTextField fatherNametxtfld;
	private JTextField dateOfBirthtxtfld;
	private JTextField casttxtfld;
	private JTextField addresstxtfld;
	private JTextField courseIdtxtfld;
	private JTextField courseNametxtfld;
	private JTextField durationtxtfld;
	private JTextField totalFeestxtfld;
	private JTextField departmenttxtfld;
	public Update_Student() {
	
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
	
		frame = new JFrame();
		frame.setBounds(100, 100, 895, 618);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(new Color(127, 255, 212));
		panel.setBounds(0, 0, 903, 97);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("Student Information");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(51, 51, 255));
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(0, 0, 162, 29);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Student ID");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 204, 0));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(46, 28, 162, 29);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Student Name\r\n");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(0, 204, 0));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(46, 57, 162, 29);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Contact Number");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(0, 204, 0));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(512, 28, 162, 29);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Email");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(0, 204, 0));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(512, 57, 162, 29);
		panel.add(label_4);
		
		studentIdtxtfld = new JTextField();
		studentIdtxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		studentIdtxtfld.setColumns(10);
		studentIdtxtfld.setBounds(218, 28, 180, 29);
		panel.add(studentIdtxtfld);
		
		studentNametxtfld = new JTextField();
		studentNametxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		studentNametxtfld.setColumns(10);
		studentNametxtfld.setBounds(218, 63, 180, 29);
		panel.add(studentNametxtfld);
		
		contactNumbertxtfld = new JTextField();
		contactNumbertxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		contactNumbertxtfld.setColumns(10);
		contactNumbertxtfld.setBounds(667, 28, 180, 29);
		panel.add(contactNumbertxtfld);
		
		emailtxtfld = new JTextField();
		emailtxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		emailtxtfld.setColumns(10);
		emailtxtfld.setBounds(654, 63, 239, 29);
		panel.add(emailtxtfld);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBackground(new Color(127, 255, 212));
		panel_1.setBounds(10, 99, 456, 387);
		frame.getContentPane().add(panel_1);
		
		JLabel label_5 = new JLabel("Personal Information");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(new Color(51, 51, 255));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(0, 0, 162, 29);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("Father Name");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setForeground(new Color(0, 204, 0));
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(10, 40, 112, 29);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("Date Of Birth");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setForeground(new Color(0, 204, 0));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(10, 85, 112, 29);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("Gender");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setForeground(new Color(0, 204, 0));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(10, 125, 112, 29);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("Cast");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setForeground(new Color(0, 204, 0));
		label_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_9.setBounds(10, 167, 112, 29);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("Address");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setForeground(new Color(0, 204, 0));
		label_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_10.setBounds(10, 207, 112, 29);
		panel_1.add(label_10);
		
		fatherNametxtfld = new JTextField();
		fatherNametxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		fatherNametxtfld.setColumns(10);
		fatherNametxtfld.setBounds(217, 40, 180, 29);
		panel_1.add(fatherNametxtfld);
		
		dateOfBirthtxtfld = new JTextField();
		dateOfBirthtxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		dateOfBirthtxtfld.setColumns(10);
		dateOfBirthtxtfld.setBounds(217, 85, 180, 29);
		panel_1.add(dateOfBirthtxtfld);
		
		JCheckBox malecheck = new JCheckBox("Male");
		malecheck.setFont(new Font("Tahoma", Font.BOLD, 14));
		malecheck.setBounds(217, 125, 68, 23);
		panel_1.add(malecheck);
		
		JCheckBox femalecheck = new JCheckBox("Female");
		femalecheck.setFont(new Font("Tahoma", Font.BOLD, 14));
		femalecheck.setBounds(303, 125, 94, 23);
		panel_1.add(femalecheck);
		
		casttxtfld = new JTextField();
		casttxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		casttxtfld.setColumns(10);
		casttxtfld.setBounds(217, 167, 180, 29);
		panel_1.add(casttxtfld);
		
		addresstxtfld = new JTextField();
		addresstxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		addresstxtfld.setColumns(10);
		addresstxtfld.setBounds(217, 213, 180, 116);
		panel_1.add(addresstxtfld);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.setBackground(new Color(127, 255, 212));
		panel_2.setBounds(464, 99, 415, 387);
		frame.getContentPane().add(panel_2);
		
		JLabel lblCourseDetail = new JLabel("Course Detail");
		lblCourseDetail.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseDetail.setForeground(new Color(51, 51, 255));
		lblCourseDetail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourseDetail.setBounds(0, 0, 162, 29);
		panel_2.add(lblCourseDetail);
		
		JLabel label_12 = new JLabel("Course ID");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setForeground(new Color(0, 204, 0));
		label_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_12.setBounds(23, 40, 112, 29);
		panel_2.add(label_12);
		
		JLabel label_13 = new JLabel("Course Name");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setForeground(new Color(0, 204, 0));
		label_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_13.setBounds(23, 80, 112, 29);
		panel_2.add(label_13);
		
		JLabel label_14 = new JLabel("Duration");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setForeground(new Color(0, 204, 0));
		label_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_14.setBounds(23, 120, 112, 29);
		panel_2.add(label_14);
		
		JLabel label_15 = new JLabel("Total Fees");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		label_15.setForeground(new Color(0, 204, 0));
		label_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_15.setBounds(23, 160, 112, 29);
		panel_2.add(label_15);
		
		JLabel label_16 = new JLabel("Department");
		label_16.setHorizontalAlignment(SwingConstants.RIGHT);
		label_16.setForeground(new Color(0, 204, 0));
		label_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_16.setBounds(23, 206, 112, 29);
		panel_2.add(label_16);
		
		JLabel label_17 = new JLabel("Semester\r\n");
		label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		label_17.setForeground(new Color(0, 204, 0));
		label_17.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_17.setBounds(23, 246, 112, 29);
		panel_2.add(label_17);
		
		courseIdtxtfld = new JTextField();
		courseIdtxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		courseIdtxtfld.setColumns(10);
		courseIdtxtfld.setBounds(198, 40, 180, 29);
		panel_2.add(courseIdtxtfld);
		
		courseNametxtfld = new JTextField();
		courseNametxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		courseNametxtfld.setColumns(10);
		courseNametxtfld.setBounds(198, 80, 180, 29);
		panel_2.add(courseNametxtfld);
		
		durationtxtfld = new JTextField();
		durationtxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		durationtxtfld.setColumns(10);
		durationtxtfld.setBounds(198, 120, 180, 29);
		panel_2.add(durationtxtfld);
		
		totalFeestxtfld = new JTextField();
		totalFeestxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		totalFeestxtfld.setColumns(10);
		totalFeestxtfld.setBounds(198, 160, 180, 29);
		panel_2.add(totalFeestxtfld);
		
		departmenttxtfld = new JTextField();
		departmenttxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		departmenttxtfld.setColumns(10);
		departmenttxtfld.setBounds(198, 200, 180, 29);
		panel_2.add(departmenttxtfld);
		
		String semester[]={"1","2","3","4","5","6","7","8"};
		JComboBox semestercombo = new JComboBox(semester);
		semestercombo.setFont(new Font("Tahoma", Font.BOLD, 14));
		semestercombo.setEditable(true);
		semestercombo.setBounds(198, 246, 180, 29);
		panel_2.add(semestercombo);
		
		JButton button = new JButton("Main Menue");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    frame.setVisible(false);  
				new Main().frame1.setVisible(true);
			}});
		button.setForeground(Color.RED);
		button.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		button.setBounds(536, 497, 123, 39);
		frame.getContentPane().add(button);
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////

		int i=0;
		try{
			String id = JOptionPane.showInputDialog("Enter student id");
		    String db = "jdbc:ucanaccess://F:\\NewForm.accdb";
            con = DriverManager.getConnection(db); 
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql = "Select *  From NewForm";
              rs = st.executeQuery(sql);
              
		   	while(rs.next())
		   	{
		   		String idcheck = rs.getString("Student ID");
		   	if(idcheck.equals(id))
		   	{	
		   		i++;
			studentIdtxtfld.setText(rs.getString("Student ID"));
			studentNametxtfld.setText(rs.getString("Student Name"));
			contactNumbertxtfld.setText(rs.getString("Contact Number"));
			emailtxtfld.setText(rs.getString("Email"));
			fatherNametxtfld.setText(rs.getString("Father Name"));
			dateOfBirthtxtfld.setText(rs.getString("Date Of Birth"));
			if(rs.getString("Gender").equalsIgnoreCase("male"))
			{
			femalecheck.setSelected(false);	
			 malecheck.setSelected(true);
			}
			else if (rs.getString("Gender").equalsIgnoreCase("female"))
			{   
				malecheck.setSelected(false);
				femalecheck.setSelected(true);
			}
			casttxtfld.setText(rs.getString("Cast"));
			addresstxtfld.setText(rs.getString("Address"));
			courseIdtxtfld.setText(rs.getString("Course ID"));
			courseNametxtfld.setText(rs.getString("Course Name"));
			durationtxtfld.setText(rs.getString("Duration"));
			totalFeestxtfld.setText(rs.getString("Total fees"));
			departmenttxtfld.setText(rs.getString("Department"));
			semestercombo.setSelectedItem(rs.getString("Semester"));
		   st.close();
			rs.close();
		     break;
	     	}}}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		if (i==0)
		{
			JOptionPane.showMessageDialog(null, "Your Record is not found");
		  
		}
	
	  
		
		
		
		/*int i=0;
		String id = JOptionPane.showInputDialog("Enter student id");
		try{		
		    String db = "jdbc:ucanaccess://F:\\NewForm.accdb";
            con = DriverManager.getConnection(db); 
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql = "Select *  From NewForm";
              rs = st.executeQuery(sql);
              
		   	while(rs.next())
		   	{
		   		String idcheck = rs.getString("Student ID");
		   	if(idcheck.equals(id))
		   	{	
		   		
		   		i++;
			studentIdtxtfld.setText(rs.getString("Student ID"));
			studentNametxtfld.setText(rs.getString("Student Name"));
			contactNumbertxtfld.setText(rs.getString("Contact Number"));
			emailtxtfld.setText(rs.getString("Email"));
			fatherNametxtfld.setText(rs.getString("Father Name"));
			dateOfBirthtxtfld.setText(rs.getString("Date Of Birth"));
			if(rs.getString("Gender").equalsIgnoreCase("male"))
			{
			femalecheck.setSelected(false);	
			 malecheck.setSelected(true);
			}
			else if (rs.getString("Gender").equalsIgnoreCase("female"))
			{   
				malecheck.setSelected(false);
				femalecheck.setSelected(true);
			}
			casttxtfld.setText(rs.getString("Cast"));
			addresstxtfld.setText(rs.getString("Address"));
			courseIdtxtfld.setText(rs.getString("Course ID"));
			courseNametxtfld.setText(rs.getString("Course Name"));
			durationtxtfld.setText(rs.getString("Duration"));
			totalFeestxtfld.setText(rs.getString("Total fees"));
			departmenttxtfld.setText(rs.getString("Department"));
			semestercombo.setSelectedItem(rs.getString("Semester"));
		   st.close();
			rs.close();
			con.close();
	     	}
		   	break;
		   	}
		   	if (i==0)
			{
				
	    		JOptionPane.showMessageDialog(null, "Your Record is not found");
	    		new Student().frame.setVisible(true);
	    	 // new Update_Student().frame.setVisible(false);
			   frame.setVisible(false);
			}   	
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}*/
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		{	JButton button_1 = new JButton("Save");
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		button_1.setBounds(417, 497, 109, 39);
		frame.getContentPane().add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try{		
			    	     String db = "jdbc:ucanaccess://F:NewForm.accdb";
			             con = DriverManager.getConnection(db); 
			             st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			             String sql = "select * from NewForm";
			            rs = st.executeQuery(sql);
			             rs.next();
			    	     rs.moveToInsertRow();
		                rs.updateString("Student ID", studentIdtxtfld.getText()); 
						rs.updateString("Student Name", studentNametxtfld.getText());
						rs.updateString("Contact Number",contactNumbertxtfld.getText());
					    rs.updateString("Email",emailtxtfld.getText());
						rs.updateString("Father Name", fatherNametxtfld.getText());
				     	rs.updateString("Date Of Birth", dateOfBirthtxtfld.getText());
						if(malecheck.isSelected()){
						rs.updateString("Gender","male");
						}
						else if(femalecheck.isSelected())
						{
							rs.updateString("Gender","female");
						}
						rs.updateString("Cast", casttxtfld.getText());
						rs.updateString("Address",addresstxtfld.getText());
						rs.updateString("Course ID",courseIdtxtfld.getText());
						rs.updateString("Course Name", courseNametxtfld.getText());
						rs.updateString("Duration",durationtxtfld.getText());
						rs.updateString("Total fees", totalFeestxtfld.getText());
						rs.updateString("Department", departmenttxtfld.getText());
						rs.updateString("Semester", (String)semestercombo.getItemAt(0));
				    	rs.updateString("Semester", (String)semestercombo.getItemAt(1));
				    	rs.updateString("Semester", (String)semestercombo.getItemAt(2));
				    	rs.updateString("Semester", (String)semestercombo.getItemAt(3));
				    	rs.updateString("Semester", (String)semestercombo.getItemAt(4));
				    	rs.updateString("Semester", (String)semestercombo.getItemAt(5));
				    	rs.updateString("Semester", (String)semestercombo.getItemAt(6));
				    	rs.updateString("Semester", (String)semestercombo.getItemAt(7));
						rs.updateRow();
				    	JOptionPane.showMessageDialog(null, "Your record has been updated");
						st.close();
						rs.close();
						con.close();
						
						
						
						studentIdtxtfld.setText("");
						studentNametxtfld.setText("");
                        contactNumbertxtfld.setText("");
                        emailtxtfld.setText("");
                        fatherNametxtfld.setText("");
                        dateOfBirthtxtfld.setText("");
                        malecheck.setSelected(false);
                        femalecheck.setSelected(false);
                        casttxtfld.setText("");
                        addresstxtfld.setText("");
                        courseIdtxtfld.setText("");
                        courseNametxtfld.setText("");
                        durationtxtfld.setText("");
                        totalFeestxtfld.setText("");
                        departmenttxtfld.setText("");
                        semestercombo.setSelectedIndex(0);
			      }catch(Exception sv)
			      {
			    	  JOptionPane.showMessageDialog(null,sv.getMessage());
			      }
			
			
				}
			
});
		
		
		
	JButton button_2 = new JButton("Back");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    frame.setVisible(false);  
				new Main().frame1.setVisible(true);
			}});
		button_2.setForeground(Color.RED);
		button_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		button_2.setBounds(298, 497, 109, 39);
		frame.getContentPane().add(button_2);
		}
	}
	}



