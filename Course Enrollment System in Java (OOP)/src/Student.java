import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;

//import Project.Update_Student;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Student {
	

	public JFrame frame;
	public Student() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 725, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(0, 0, 194, 486);
		frame.getContentPane().add(panel);
		
		JButton btnShowAllStudent = new JButton("Show All Student");
		btnShowAllStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnShowAllStudent.setBounds(10, 11, 177, 48);
		panel.add(btnShowAllStudent);
		btnShowAllStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
           new show_All_S().frame.setVisible(true);
				}
		});
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Add_Student().frame.setVisible(true);;
			}
		});
		btnAddStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddStudent.setBounds(10, 60, 177, 48);
		panel.add(btnAddStudent);
		
		JButton btnUpdateStudent = new JButton("Update Student");
		btnUpdateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			new Update_Student().frame.setVisible(true);
				   
			}
		});
		btnUpdateStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateStudent.setBounds(10, 109, 177, 48);
		panel.add(btnUpdateStudent);
		
		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			   new Delete_Student().delete();
			}
		});
		btnDeleteStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDeleteStudent.setBounds(10, 157, 177, 48);
		panel.add(btnDeleteStudent);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
           new Search().frame.setVisible(true);;
				}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBounds(10, 205, 177, 48);
		panel.add(btnSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			 new Main().frame1.setVisible(true);
			}});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(10, 253, 177, 48);
		panel.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Sana Ullah\\Desktop\\Student.png"));
		label.setBounds(206, 0, 503, 486);
		frame.getContentPane().add(label);
	}

}
