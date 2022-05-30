import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class UpdateC {
    Connection con;
    Statement st;
    ResultSet rs;
	public JFrame frame;
	private JTextField courseIdtxtfld;
	private JTextField Nametxtfld;
	private JTextField creditHourtxtfld;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update window = new Update();
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
	public UpdateC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 14));
		frame.setBounds(100, 100, 620, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 604, 106);
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("    Update A Course");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(165, 28, 189, 21);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 107, 194, 389);
		panel_1.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(74, 23, 46, -4);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Course  ID");
		lblNewLabel_2.setBounds(22, 30, 151, 28);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Course Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(22, 96, 151, 20);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Credit Hour");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(22, 167, 125, 28);
		panel_1.add(lblNewLabel_4);
		
		courseIdtxtfld = new JTextField();
		courseIdtxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		courseIdtxtfld.setBounds(228, 136, 172, 27);
		frame.getContentPane().add(courseIdtxtfld);
		courseIdtxtfld.setColumns(10);
		
		JButton btnOk = new JButton("Update");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			      	String p="jdbc:ucanaccess://F:Courses.accdb";
					con=DriverManager.getConnection(p);
					st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					String a="Select * From Table1";
					rs=st.executeQuery(a);
					rs.next();
					rs.moveToCurrentRow();
					rs.updateString("Course ID",courseIdtxtfld.getText());
					rs.updateString("Course Name",Nametxtfld.getText());
					rs.updateString("Credit Hour",creditHourtxtfld.getText());
					rs.updateRow();
					JOptionPane.showMessageDialog(null, "Your record has been updated");
					st.close();
					rs.close();
					con.close();
					
					courseIdtxtfld.setText("");
					Nametxtfld.setText("");
     				creditHourtxtfld.setText("");
					
					
				}catch(Exception a){
					JOptionPane.showMessageDialog(null, a.getMessage());
				}
			  
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOk.setBounds(338, 353, 89, 23);
		frame.getContentPane().add(btnOk);
		
		Nametxtfld = new JTextField();
		Nametxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		Nametxtfld.setBounds(228, 200, 172, 27);
		frame.getContentPane().add(Nametxtfld);
		Nametxtfld.setColumns(10);
		
		creditHourtxtfld = new JTextField();
		creditHourtxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		creditHourtxtfld.setBounds(228, 277, 172, 27);
		frame.getContentPane().add(creditHourtxtfld);
		creditHourtxtfld.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new min().frame.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(215, 355, 89, 23);
		frame.getContentPane().add(btnBack);
		 int i=0;
		   try{
			   String id = JOptionPane.showInputDialog("Enter Course ID");
			   String p="jdbc:ucanaccess://F:Courses.accdb";
				con=DriverManager.getConnection(p);
				st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				String a="Select * From Table1";
				rs=st.executeQuery(a);
				
				while(rs.next()){
					String checkid = rs.getString("Course ID");
					
					if(checkid.equals(id))
					{   i++;
					courseIdtxtfld.setText(rs.getString("Course ID"));	
					Nametxtfld.setText(rs.getString("Course Name"));
				   creditHourtxtfld.setText(rs.getString("Credit Hour"));
						
						break;
					}
				}
				st.close();
				rs.close();
				con.close();
		   }catch(Exception sr)
		   {
			   JOptionPane.showMessageDialog(null, sr.getMessage());
		   }
		   if(i==0)
		   {
			   JOptionPane.showMessageDialog(null,"Your Record is not found");
		   }
		
	}
}
