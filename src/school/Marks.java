package school;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;

public class Marks extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Marks frame = new Marks("gds");
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
	public Marks(String s) {
		
		
		getContentPane().add(table, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Marks");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(157, 11, 109, 25);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		try {
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kps",
                    "root", "root");
		PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select lastname, firstname from pupil where username=?");
		st.setString(1, s);
        ResultSet rs = st.executeQuery();
        String ln = rs.getString("lastname");
        String fn = rs.getString("firstname");
        String n = ln + fn;
        PreparedStatement pst = (PreparedStatement) connection.prepareStatement("Select marks from math where name=?");
        pst.setString(1, n);
        ResultSet res = pst.executeQuery();
        String mark = res.getString("marks");
        textField.setText(mark);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		textField.setEditable(false);
		textField.setBounds(10, 34, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
