//import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Update_Search{
    private String id=null;
	public JFrame frame;
	private JTextField idtxtfld;
	public Update_Search() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame("Search For Updating");
		frame.setBounds(100, 100, 725, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 201, 397);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStudentId.setBounds(20, 130, 156, 43);
		panel.add(lblStudentId);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOk.setBounds(30, 197, 146, 43);
		panel.add(btnOk);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    frame.setVisible(false);  
			    id = idtxtfld.getText();
		        new Update_Student().frame.setVisible(true);
			}});
		
		
		idtxtfld = new JTextField();
		idtxtfld.setFont(new Font("Tahoma", Font.BOLD, 16));
		idtxtfld.setBounds(243, 128, 231, 43);
		frame.getContentPane().add(idtxtfld);
		idtxtfld.setColumns(10);
		  
		
	}

}
