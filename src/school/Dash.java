package school;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Dash extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dash frame = new Dash();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(172, 11, 76, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Click here to register a pupil");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(59, 46, 311, 24);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBounds(172, 81, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register reg = new Register();
				reg.setVisible(true);
				Dash.super.dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Click here to view all registered pupils");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(59, 115, 311, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton_1 = new JButton("View Registered Pupils");
		btnNewButton_1.setBounds(123, 141, 179, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registered regd = new Registered();
				regd.setVisible(true);
				Dash.super.dispose();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Click here to record pupil's marks");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(59, 168, 311, 24);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton_1_1 = new JButton("Record Pupil's Marks");
		btnNewButton_1_1.setBounds(123, 203, 179, 23);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Record rcd = new Record();
				rcd.setVisible(true);
				Dash.super.dispose();
			}
		});
		contentPane.add(btnNewButton_1_1);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
