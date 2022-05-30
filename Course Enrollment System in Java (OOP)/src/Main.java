import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	public JFrame frame1;
	public Main() {
		initialize();
	}
	private void initialize() {
		frame1 = new JFrame();
		frame1.setBounds(0,0, 725, 526);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(0, 0, 207, 486);
		frame1.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton instructorbtn = new JButton("Instructor");
		instructorbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame1.setVisible(false); 
				new Instructor().frame.setVisible(true);
			}
		});
		instructorbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		instructorbtn.setBounds(30, 11, 177, 48);
		panel.add(instructorbtn);
		
		JButton studentbtn = new JButton("Student");
		studentbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame1.setVisible(false);
 			Student s = new Student();
			s.frame.setVisible(true);
			}
		});
		studentbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		studentbtn.setBounds(30, 60, 177, 48);
		panel.add(studentbtn);
		
		JButton coursebtn = new JButton("Course");
		coursebtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		coursebtn.setBounds(30, 109, 177, 48);
		panel.add(coursebtn);
		coursebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame1.setVisible(false);
 			new min().frame.setVisible(true);
			
			}
		});

		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(205, 0, 504, 486);
		frame1.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sana Ullah\\Desktop\\newwww.png"));
		lblNewLabel.setBounds(0, 0, 504, 486);
		panel_1.add(lblNewLabel);
	}
		}

