import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;


public class LogIn {
    Connection con;
    Statement st;
    ResultSet rs;
	private JFrame frame;
	private JTextField userNametxtfld;
	private JTextField usertxtfld;
	private JTextField passtxtfld;
	private JPasswordField passwordfld;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
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
	public LogIn() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 887, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(0, 0, 871, 89);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserName.setBounds(523, 11, 107, 25);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(523, 47, 107, 25);
		panel.add(lblPassword);
		
		userNametxtfld = new JTextField();
		userNametxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		userNametxtfld.setBounds(635, 10, 185, 30);
		panel.add(userNametxtfld);
		userNametxtfld.setColumns(10);
		
		passwordfld = new JPasswordField();
		passwordfld.setBounds(635, 47, 185, 31);
		panel.add(passwordfld);
		
		JCheckBox malecheck = new JCheckBox("Male");
		malecheck.setFont(new Font("Tahoma", Font.BOLD, 15));
		malecheck.setBounds(250, 273, 86, 19);
		frame.getContentPane().add(malecheck);
		
		JCheckBox femalecheck = new JCheckBox("Female");
		femalecheck.setFont(new Font("Tahoma", Font.BOLD, 15));
		femalecheck.setBounds(354, 273, 86, 19);
		frame.getContentPane().add(femalecheck);
		
		
		
		usertxtfld = new JTextField();
		usertxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		usertxtfld.setColumns(10);
		usertxtfld.setBounds(255, 175, 185, 30);
		frame.getContentPane().add(usertxtfld);
		
		passtxtfld = new JTextField();
		passtxtfld.setFont(new Font("Tahoma", Font.BOLD, 14));
		passtxtfld.setColumns(10);
		passtxtfld.setBounds(255, 219, 185, 30);
		frame.getContentPane().add(passtxtfld);



		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			      try{		
			    	  String db = "jdbc:ucanaccess://F:Sign.accdb";	
			             con = DriverManager.getConnection(db); 
			             st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			             String sql = "select * from Table1";
			            rs = st.executeQuery(sql);
			    	    rs.moveToInsertRow();
		                rs.updateString("UserName",usertxtfld.getText() );
		                rs.updateString("Password",passtxtfld.getText());
		                if(malecheck.isSelected()){
							rs.updateString("Gender","male");
							}
							else if(femalecheck.isSelected())
							{
								rs.updateString("Gender","female");
								
							}
		                rs.insertRow();
						JOptionPane.showMessageDialog(null, "Your record has been Added");
						st.close();
						rs.close();
						
						usertxtfld.setText("");
						passtxtfld.setText("");
						malecheck.setSelected(false);
						femalecheck.setSelected(false);
                      
			      }catch(Exception save)
			      {
			    	  JOptionPane.showMessageDialog(null,save.getMessage());
			      }		
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOk.setBounds(211, 327, 115, 32);
		frame.getContentPane().add(btnOk);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				
				int i=0;
				try{
					String userName = userNametxtfld.getText().trim();
			   		String password = passwordfld.getText().trim();
				    String db = "jdbc:ucanaccess://F:\\Sign.accdb";
		            con = DriverManager.getConnection(db); 
		            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);		             String sql = "select * from Table1" ; 
		            rs = st.executeQuery(sql);
		              
				   	while(rs.next())
				   	{
				   		 String s = rs.getString("UserName");
				   		 String p = rs.getString("Password");
				   		if(s.equals(userName) && p.equals(password))
					   	{	
					   		i++;
					   
					     break;
				     	}
				   	}
				   	st.close();
					rs.close();
					con.close();
				   	if(i>0)
				   	{
				   		frame.setVisible(false);
				   	 new Main().frame1.setVisible(true);
				   	 
				   	}
				   	else if (i==0)
					{
						JOptionPane.showMessageDialog(null, "Your User Name and Password Incorrect");
						
						usertxtfld.setText("");
						passtxtfld.setText("");
						malecheck.setSelected(false);
						femalecheck.setSelected(false);
                      
					  
					}
				   	}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
				
			
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogIn.setBounds(697, 100, 115, 32);
		frame.getContentPane().add(btnLogIn);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSignUp.setBounds(255, 111, 120, 32);
		frame.getContentPane().add(lblSignUp);
		
		JLabel label = new JLabel("User Name");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(147, 171, 107, 25);
		frame.getContentPane().add(label);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword_1.setBounds(147, 215, 107, 25);
		frame.getContentPane().add(lblPassword_1);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(147, 270, 107, 25);
		frame.getContentPane().add(lblGender);
		
		
		
		
	}
}
