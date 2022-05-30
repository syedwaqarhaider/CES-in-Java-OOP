import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Instructor {

	public  JFrame frame;
	public Instructor() {
		initialize();
	}
 
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLUE);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 810, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 203, 343);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Show all Instructor");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new ShowAllData().frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(0, 0, 203, 57);
		panel.add(btnNewButton);
		
		JButton btnAddInstructor = new JButton("Add Instructor");
		btnAddInstructor.setBackground(Color.WHITE);
		btnAddInstructor.setForeground(Color.BLACK);
		btnAddInstructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Add_Instructor().frame.setVisible(true);
			}
		});
		btnAddInstructor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnAddInstructor.setBounds(0, 55, 203, 57);
		panel.add(btnAddInstructor);
		
		JButton btnShowAllDelete = new JButton(" Delete Instructor");
		btnShowAllDelete.setBackground(Color.WHITE);
		btnShowAllDelete.setForeground(Color.BLACK);
		btnShowAllDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Delete_Instructor().delete();
			}
		});
		btnShowAllDelete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnShowAllDelete.setBounds(0, 112, 203, 57);
		panel.add(btnShowAllDelete);
		
		JButton btnUpdateInstructor = new JButton("Update Instructor");
		btnUpdateInstructor.setBackground(Color.WHITE);
		btnUpdateInstructor.setForeground(Color.BLACK);
		btnUpdateInstructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Update_Instructor().frame.setVisible(true);
			}
		});
		btnUpdateInstructor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnUpdateInstructor.setBounds(0, 170, 203, 57);
		panel.add(btnUpdateInstructor);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setForeground(Color.BLACK);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Search_Instructor().frame.setVisible(true);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnSearch.setBounds(0, 227, 203, 57);
		panel.add(btnSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnBack.setBounds(0, 280, 203, 64);
		panel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Main().frame1.setVisible(true);
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sana Ullah\\Desktop\\teacher.png"));
		lblNewLabel.setBounds(201, 0, 519, 288);
		frame.getContentPane().add(lblNewLabel);
	}
}
