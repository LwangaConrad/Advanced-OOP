package school;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Register extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField fir;
	private JTextField lass;
	private JTextField num;
	private JTextField subj;
	private JTextField calssy;
	private JTextField agee;
	private JPasswordField passwordField;
	private JTextField usern;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Registration Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(80, 11, 370, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 62, 75, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 100, 75, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Registration Number:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(10, 135, 127, 24);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gender:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(10, 175, 75, 24);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Age:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4.setBounds(10, 210, 75, 24);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Subject:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_5.setBounds(10, 248, 75, 24);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Class:");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_6.setBounds(10, 283, 75, 24);
		contentPane.add(lblNewLabel_1_6);
		
		fir = new JTextField();
		fir.setBounds(166, 62, 189, 24);
		contentPane.add(fir);
		fir.setColumns(10);
		
		lass = new JTextField();
		lass.setColumns(10);
		lass.setBounds(166, 100, 189, 24);
		contentPane.add(lass);
		
		num = new JTextField();
		num.setColumns(10);
		num.setBounds(166, 138, 189, 24);
		contentPane.add(num);
		
		subj = new JTextField();
		subj.setColumns(10);
		subj.setBounds(166, 249, 189, 24);
		contentPane.add(subj);
		
		calssy = new JTextField();
		calssy.setColumns(10);
		calssy.setBounds(166, 286, 89, 24);
		contentPane.add(calssy);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Male");
		comboBox.addItem("Female");
		comboBox.setBounds(166, 177, 89, 22);
		contentPane.add(comboBox);
		
		agee = new JTextField();
		agee.setColumns(10);
		agee.setBounds(166, 210, 89, 24);
		contentPane.add(agee);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBounds(166, 400, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//code for transferring data to database
				String fn = fir.getText();
				String ln = lass.getText();
				String reg = num.getText();
				String gnd = (String)comboBox.getSelectedItem();
				String ag = agee.getText();
				String sub = subj.getText();
				String cl = calssy.getText();
				String un = usern.getText();
				String ps = passwordField.getText();
				//code for transferring data to database
				try {
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kps",
	                        "root", "root");
					PreparedStatement st = connection.prepareStatement("insert into pupil(firstname, lastname, registrationNo, gender, age, class, username, password) values(?, ?, ?, ?, ?, ?, ?, ?)");
					PreparedStatement pst = connection.prepareStatement("insert into "+ sub +"(name, regNo, class) values(?, ?, ?)");
                    st.setString(1, fn);
                    st.setString(2, ln);
                    st.setString(3, reg);
                    st.setString(4, gnd);
                    st.setString(5, ag);
                    st.setString(6, cl);
                    st.setString(7, un);
                    st.setString(8, ps);
                    pst.setString(1, (ln + " " + fn));
                    pst.setString(2, reg);
                    pst.setString(3, cl);
                    st.execute();
                    pst.execute();
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Password");
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_6_1.setBounds(10, 364, 75, 24);
		contentPane.add(lblNewLabel_1_6_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(166, 365, 138, 24);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1_6_1_1 = new JLabel("Username");
		lblNewLabel_1_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_6_1_1.setBounds(10, 329, 75, 24);
		contentPane.add(lblNewLabel_1_6_1_1);
		
		usern = new JTextField();
		usern.setBounds(166, 330, 138, 24);
		contentPane.add(usern);
		usern.setColumns(10);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
