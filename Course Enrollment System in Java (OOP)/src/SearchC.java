import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchC {
     
	Connection con;
	Statement st;
	ResultSet rs;
	public JFrame frame;
	private JTextField Name;
	private JTextField ID;
	private JTextField hour;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search window = new Search();
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
	public SearchC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 620, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 604, 97);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search A Course");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(209, 26, 194, 35);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 100, 192, 395);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewlabel = new JLabel("Search  By Name");
		lblNewlabel.setBounds(38, 22, 128, 17);
		lblNewlabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblNewlabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(23, 104, 143, 23);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			new min().frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(50, 334, 89, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblCreditHours = new JLabel("   Credit Hours");
		lblCreditHours.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCreditHours.setBounds(23, 208, 143, 23);
		panel_1.add(lblCreditHours);
		
		Name = new JTextField();
		Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		Name.setBounds(226, 117, 205, 26);
		frame.getContentPane().add(Name);
		Name.setColumns(10);
		
		ID = new JTextField();
		ID.setFont(new Font("Tahoma", Font.BOLD, 14));
		ID.setBounds(226, 199, 205, 26);
		frame.getContentPane().add(ID);
		ID.setColumns(10);
		
		hour = new JTextField();
		hour.setFont(new Font("Tahoma", Font.BOLD, 14));
		hour.setColumns(10);
		hour.setBounds(226, 310, 205, 26);
		frame.getContentPane().add(hour);
	
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
				ID.setText(rs.getString("Course ID"));	
				Name.setText(rs.getString("Course Name"));
			   hour.setText(rs.getString("Credit Hour"));
					st.close();
					rs.close();
					break;
				}
			}
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
