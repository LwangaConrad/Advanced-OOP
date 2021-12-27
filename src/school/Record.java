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
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Record extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Record frame = new Record();
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
	public Record() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Record Pupil's Marks");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(115, 11, 195, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 52, 81, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Subject");
		lblNewLabel_1_1.setBounds(10, 89, 81, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mark");
		lblNewLabel_1_2.setBounds(10, 126, 81, 26);
		contentPane.add(lblNewLabel_1_2);
		
		textField = new JTextField();
		textField.setBounds(95, 55, 215, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(95, 89, 215, 23);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(95, 129, 81, 23);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Record");
		btnNewButton.setBounds(161, 229, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sub = textField_1.getText();
				String mar = textField_2.getText();
				String reg = textField_4.getText();
				//code for transferring data to database
				try {
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kps",
	                        "root", "root");
					PreparedStatement st = connection.prepareStatement("update " + sub + " set marks=? where regNo=?");
                    st.setString(1, mar);
                    st.setString(2, reg);
                    st.execute();
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Class");
		lblNewLabel_1_2_1.setBounds(10, 163, 81, 26);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("RegNo");
		lblNewLabel_1_2_2.setBounds(10, 200, 81, 26);
		contentPane.add(lblNewLabel_1_2_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(95, 163, 81, 23);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(95, 197, 215, 23);
		contentPane.add(textField_4);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
