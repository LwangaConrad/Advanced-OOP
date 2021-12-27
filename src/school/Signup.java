package school;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Signup extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField nam;
	private JTextField subjec;
	private JTextField usernam;
	private JPasswordField passwor;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 334);
		contentPane =  new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(132, 11, 159, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 61, 87, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Subject");
		lblNewLabel_1_1.setBounds(10, 96, 87, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Username");
		lblNewLabel_1_2.setBounds(10, 130, 87, 24);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password");
		lblNewLabel_1_3.setBounds(10, 165, 87, 24);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Confirm Password");
		lblNewLabel_1_4.setBounds(10, 200, 112, 24);
		contentPane.add(lblNewLabel_1_4);
		
		nam = new JTextField();
		nam.setBounds(132, 63, 206, 24);
		contentPane.add(nam);
		nam.setColumns(10);
		
		subjec = new JTextField();
		subjec.setColumns(10);
		subjec.setBounds(132, 98, 206, 24);
		contentPane.add(subjec);
		
		usernam = new JTextField();
		usernam.setColumns(10);
		usernam.setBounds(132, 132, 206, 24);
		contentPane.add(usernam);
		
		passwor = new JPasswordField();
		passwor.setBounds(132, 167, 206, 24);
		contentPane.add(passwor);
		
		password = new JPasswordField();
		password.setBounds(132, 202, 206, 24);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setBounds(178, 263, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//code for transferring data to database
				String n = nam.getText();
				String sub = subjec.getText();
				String un = usernam.getText();
				String ps = passwor.getText();
				String c = password.getText();
				if(c.equals(ps)) {
					//code for transferring data to database
					try {
						Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kps",
		                        "root", "root");
						PreparedStatement st = connection.prepareStatement("insert into teacher(name, subject, username, password) values(?, ?, ?, ?)");
	                    st.setString(1, n);
	                    st.setString(2, sub);
	                    st.setString(3, un);
	                    st.setString(4, ps);
	                    st.execute();
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
					JOptionPane.showMessageDialog(Signup.this, "Enter matching password");
			}
		});
		contentPane.add(btnNewButton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
