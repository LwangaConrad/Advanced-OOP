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
	private JTextField mat;
	private JTextField ss;
	private JTextField englis;
	private JTextField frenc;
	private JTextField scienc;

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
		
		JLabel lblNewLabel_1 = new JLabel("Art");
		lblNewLabel_1.setBounds(55, 41, 76, 20);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		try {
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kps",
                    "root", "root");
		PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select lastname, firstname from pupil where username=?");
		st.setString(1, s);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
	        String ln = rs.getString("lastname");
	        String fn = rs.getString("firstname");
	        String n = ln + " " + fn;
	        PreparedStatement pst = (PreparedStatement) connection.prepareStatement("Select marks from art where name=?");
	        pst.setString(1, n);
	        ResultSet res = pst.executeQuery();
	        if(res.next()) {
		        String mark = res.getString("marks");
		        System.out.println(mark);
		        textField.setText(mark);
	        }
	        else {
	        	textField.setVisible(false);
	        	lblNewLabel_1.setVisible(false);
	        }
        }
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		textField.setEditable(false);
		textField.setBounds(167, 41, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Math");
		lblNewLabel_1_1.setBounds(55, 72, 76, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("SST");
		lblNewLabel_1_2.setBounds(55, 103, 76, 20);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("English");
		lblNewLabel_1_3.setBounds(55, 134, 76, 20);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("French");
		lblNewLabel_1_4.setBounds(55, 165, 76, 20);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Science");
		lblNewLabel_1_5.setBounds(55, 196, 76, 20);
		contentPane.add(lblNewLabel_1_5);
		
		mat = new JTextField();
		try {
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kps",
                    "root", "root");
		PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select lastname, firstname from pupil where username=?");
		st.setString(1, s);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
	        String ln = rs.getString("lastname");
	        String fn = rs.getString("firstname");
	        String n = ln + " " + fn;
	        PreparedStatement pst = (PreparedStatement) connection.prepareStatement("Select marks from math where name=?");
	        pst.setString(1, n);
	        ResultSet res = pst.executeQuery();
	        if(res.next()) {
		        String mark = res.getString("marks");
		        System.out.println(mark);
		        mat.setText(mark);
	        }
	        else {
	        	mat.setVisible(false);
	        	lblNewLabel_1_1.setVisible(false);	        	
	        }
        }
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		mat.setEditable(false);
		mat.setColumns(10);
		mat.setBounds(167, 72, 96, 20);
		contentPane.add(mat);
		
		ss = new JTextField();
		try {
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kps",
                    "root", "root");
		PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select lastname, firstname from pupil where username=?");
		st.setString(1, s);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
	        String ln = rs.getString("lastname");
	        String fn = rs.getString("firstname");
	        String n = ln + " " + fn;
	        PreparedStatement pst = (PreparedStatement) connection.prepareStatement("Select marks from sst where name=?");
	        pst.setString(1, n);
	        ResultSet res = pst.executeQuery();
	        if(res.next()) {
		        String mark = res.getString("marks");
		        System.out.println(mark);
		        ss.setText(mark);
	        }
	        else {
	        	ss.setVisible(false);
	        	lblNewLabel_1_2.setVisible(false);	        	
	        }
        }
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		ss.setEditable(false);
		ss.setColumns(10);
		ss.setBounds(170, 103, 96, 20);
		contentPane.add(ss);
		
		englis = new JTextField();
		try {
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kps",
                    "root", "root");
		PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select lastname, firstname from pupil where username=?");
		st.setString(1, s);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
	        String ln = rs.getString("lastname");
	        String fn = rs.getString("firstname");
	        String n = ln + " " + fn;
	        PreparedStatement pst = (PreparedStatement) connection.prepareStatement("Select marks from english where name=?");
	        pst.setString(1, n);
	        ResultSet res = pst.executeQuery();
	        if(res.next()) {
		        String mark = res.getString("marks");
		        System.out.println(mark);
		        englis.setText(mark);
	        }
	        else {
	        	englis.setVisible(false);
	        	lblNewLabel_1_3.setVisible(false);	        	
	        }
        }
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		englis.setEditable(false);
		englis.setColumns(10);
		englis.setBounds(170, 134, 96, 20);
		contentPane.add(englis);
		
		frenc = new JTextField();
		try {
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kps",
                    "root", "root");
		PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select lastname, firstname from pupil where username=?");
		st.setString(1, s);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
	        String ln = rs.getString("lastname");
	        String fn = rs.getString("firstname");
	        String n = ln + " " + fn;
	        PreparedStatement pst = (PreparedStatement) connection.prepareStatement("Select marks from french where name=?");
	        pst.setString(1, n);
	        ResultSet res = pst.executeQuery();
	        if(res.next()) {
		        String mark = res.getString("marks");
		        frenc.setText(mark);
	        }
	        else {
	        	frenc.setVisible(false);
	        	lblNewLabel_1_4.setVisible(false);	        	
	        }
        }
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		frenc.setEditable(false);
		frenc.setColumns(10);
		frenc.setBounds(170, 165, 96, 20);
		contentPane.add(frenc);
		
		scienc = new JTextField();
		try {
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kps",
                    "root", "root");
		PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select lastname, firstname from pupil where username=?");
		st.setString(1, s);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
	        String ln = rs.getString("lastname");
	        String fn = rs.getString("firstname");
	        String n = ln + " " + fn;
	        PreparedStatement pst = (PreparedStatement) connection.prepareStatement("Select marks from science where name=?");
	        pst.setString(1, n);
	        ResultSet res = pst.executeQuery();
	        if(res.next()) {
		        String mark = res.getString("marks");
		        System.out.println(mark);
		        scienc.setText(mark);
	        }
	        else {
	        	scienc.setVisible(false);
	        	lblNewLabel_1_5.setVisible(false);	        	
	        }
        }
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		scienc.setEditable(false);
		scienc.setColumns(10);
		scienc.setBounds(170, 196, 96, 20);
		contentPane.add(scienc);
	}
}
