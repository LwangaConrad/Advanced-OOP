package school;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.GridBagConstraints;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import java.awt.Font;

public class Login extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public String uname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Login as Teacher");
		rdbtnNewRadioButton.setBounds(37, 70, 155, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnLoginAsPupil = new JRadioButton("Login as Pupil");
		rdbtnLoginAsPupil.setBounds(220, 70, 140, 23);
		contentPane.add(rdbtnLoginAsPupil);
		
		ButtonGroup bg =new ButtonGroup();
		bg.add(rdbtnLoginAsPupil);
		bg.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(26, 100, 78, 32);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(116, 100, 205, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(26, 143, 78, 32);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(116, 143, 205, 32);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(116, 212, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				uname = textField.getText();
				String psd = passwordField.getText();
				
				try {
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kps",
	                        "root", "root");

					if (rdbtnNewRadioButton.isSelected()) {
		                    PreparedStatement st = (PreparedStatement) connection
		                        .prepareStatement("Select username, password from teacher where username=? and password=?");

						st.setString(1, uname);
	                    st.setString(2, psd);
	                    ResultSet rs = st.executeQuery();
	                    if (rs.next()) {
							Dash dsh = new Dash();
							dsh.setVisible(true);
							Login.super.dispose();
						}
						else {
							JOptionPane.showMessageDialog(Login.this, "Invalid Username or Password");
						}
					}
					else if(rdbtnLoginAsPupil.isSelected()) {
		                    PreparedStatement st = (PreparedStatement) connection
		                        .prepareStatement("Select username, password from pupil where username=? and password=?");

						st.setString(1, uname);
	                    st.setString(2, psd);
	                    ResultSet rs = st.executeQuery();
	                    if (rs.next()) {
							DashP dshb = new DashP(uname);
							dshb.setVisible(true);
							Login.super.dispose();
						}
						else {
							JOptionPane.showMessageDialog(Login.this, "Invalid Username or Password");
						}
					}
					else {
						JOptionPane.showMessageDialog(Login.this, "Please select user type");
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show password");
		chckbxNewCheckBox.setBounds(138, 182, 132, 23);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox.isSelected()) {
	                passwordField.setEchoChar((char) 0);
	            } else {
	                passwordField.setEchoChar('*');
	            }
			}
		});
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_1 = new JLabel("Katikamu Primary School");
		lblNewLabel_1.setBounds(10, 11, 416, 31);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.setBounds(215, 212, 89, 23);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Signup sig = new Signup();
				sig.setVisible(true);
				Login.super.dispose();
			}
		});
		contentPane.add(btnSignUp);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
	public String getUsername() {
        return uname;
    }
}
