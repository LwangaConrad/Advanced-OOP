package school;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Timetable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Timetable frame = new Timetable("gds");
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
	public Timetable(String s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Timetable");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(94, 11, 228, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Monday");
		lblNewLabel_1.setBounds(10, 65, 73, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tuesday");
		lblNewLabel_1_1.setBounds(10, 99, 73, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Wednesday");
		lblNewLabel_1_2.setBounds(10, 132, 73, 23);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Thursday");
		lblNewLabel_1_3.setBounds(10, 166, 73, 23);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Friday");
		lblNewLabel_1_4.setBounds(10, 200, 73, 23);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("8-10am");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_5.setBounds(92, 35, 60, 23);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("10-12am");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_5_1.setBounds(162, 35, 60, 23);
		contentPane.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("2-4pm");
		lblNewLabel_1_5_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_5_2.setBounds(251, 35, 60, 23);
		contentPane.add(lblNewLabel_1_5_2);
		
		JLabel lblNewLabel_1_5_3 = new JLabel("4-6pm");
		lblNewLabel_1_5_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_5_3.setBounds(334, 35, 60, 23);
		contentPane.add(lblNewLabel_1_5_3);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(92, 66, 60, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(92, 100, 60, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(92, 133, 60, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(92, 167, 60, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(94, 201, 60, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(162, 66, 60, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(162, 100, 60, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(162, 133, 60, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(162, 167, 60, 20);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(162, 201, 60, 20);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(232, 66, 60, 20);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(232, 100, 60, 20);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(232, 133, 60, 20);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(232, 167, 60, 20);
		contentPane.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(232, 201, 60, 20);
		contentPane.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setEditable(false);
		textField_15.setColumns(10);
		textField_15.setBounds(316, 66, 60, 20);
		contentPane.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBounds(316, 100, 60, 20);
		contentPane.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setEditable(false);
		textField_17.setColumns(10);
		textField_17.setBounds(316, 133, 60, 20);
		contentPane.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setEditable(false);
		textField_18.setColumns(10);
		textField_18.setBounds(316, 167, 60, 20);
		contentPane.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setEditable(false);
		textField_19.setColumns(10);
		textField_19.setBounds(316, 201, 60, 20);
		contentPane.add(textField_19);
		
		try {
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kps",
                    "root", "root");
		PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select lastname, firstname, class from pupil where username=?");
		st.setString(1, s);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
	        String ln = rs.getString("lastname");
	        String fn = rs.getString("firstname");
	        String cl = rs.getString("class");
	        String n = ln + " " + fn;
	        PreparedStatement pst = (PreparedStatement) connection.prepareStatement("Select * from french where name=?");
	        pst.setString(1, n);
	        ResultSet res = pst.executeQuery();
	        if(res.next()) {
		        //show french in timetable
	        	switch(cl)  
	            {  
	                case "p1g":   
	                	textField.setText("sst");
	                	textField_1.setText("science");
	                	textField_2.setText("math");
	                	textField_3.setText("english");
	                	textField_4.setText("french");
	                	textField_5.setText("sst");
	                	textField_6.setText("math");
	                	textField_7.setText("science");
	                	textField_8.setText("french");
	                	textField_9.setText("english");
	                	textField_10.setText("math");
	                	textField_11.setText("science");
	                	textField_12.setText("english");
	                	textField_13.setText("sst");
	                	textField_14.setText("french");
	                	textField_15.setText("science");
	                	textField_16.setText("english");
	                	textField_17.setText("sst");
	                	textField_18.setText("math");
	                	textField_19.setText("french");
	                    break;  
	                case "p2y":   
	                	textField.setText("science");
	                	textField_1.setText("sst");
	                	textField_2.setText("english");
	                	textField_3.setText("math");
	                	textField_4.setText("sst");
	                	textField_5.setText("french");
	                	textField_6.setText("science");
	                	textField_7.setText("math");
	                	textField_8.setText("english");
	                	textField_9.setText("french");
	                	textField_10.setText("science");
	                	textField_11.setText("math");
	                	textField_12.setText("sst");
	                	textField_13.setText("english");
	                	textField_14.setText("english");
	                	textField_15.setText("french");
	                	textField_16.setText("science");
	                	textField_17.setText("math");
	                	textField_18.setText("french");
	                	textField_19.setText("sst");
	                    break;  
	                case "p3s":   
	                	textField.setText("math");
	                	textField_1.setText("french");
	                	textField_2.setText("sst");
	                	textField_3.setText("english");
	                	textField_4.setText("french");
	                	textField_5.setText("sst");
	                	textField_6.setText("math");
	                	textField_7.setText("science");
	                	textField_8.setText("french");
	                	textField_9.setText("english");
	                	textField_10.setText("math");
	                	textField_11.setText("science");
	                	textField_12.setText("english");
	                	textField_13.setText("sst");
	                	textField_14.setText("french");
	                	textField_15.setText("science");
	                	textField_16.setText("english");
	                	textField_17.setText("sst");
	                	textField_18.setText("math");
	                	textField_19.setText("french");
	                    break;  
	                case "p4w":   
	                	textField.setText("sst");
	                	textField_1.setText("science");
	                	textField_2.setText("math");
	                	textField_3.setText("english");
	                	textField_4.setText("french");
	                	textField_5.setText("sst");
	                	textField_6.setText("math");
	                	textField_7.setText("science");
	                	textField_8.setText("french");
	                	textField_9.setText("english");
	                	textField_10.setText("math");
	                	textField_11.setText("science");
	                	textField_12.setText("english");
	                	textField_13.setText("sst");
	                	textField_14.setText("french");
	                	textField_15.setText("science");
	                	textField_16.setText("english");
	                	textField_17.setText("sst");
	                	textField_18.setText("math");
	                	textField_19.setText("french");  
	                    break;  
	                case "p5r":   
	                	textField.setText("sst");
	                	textField_1.setText("science");
	                	textField_2.setText("math");
	                	textField_3.setText("english");
	                	textField_4.setText("french");
	                	textField_5.setText("sst");
	                	textField_6.setText("math");
	                	textField_7.setText("science");
	                	textField_8.setText("french");
	                	textField_9.setText("english");
	                	textField_10.setText("math");
	                	textField_11.setText("science");
	                	textField_12.setText("english");
	                	textField_13.setText("sst");
	                	textField_14.setText("french");
	                	textField_15.setText("science");
	                	textField_16.setText("english");
	                	textField_17.setText("sst");
	                	textField_18.setText("math");
	                	textField_19.setText("french");
	                    break;  
	                case "p6t":   
	                	textField.setText("sst");
	                	textField_1.setText("science");
	                	textField_2.setText("math");
	                	textField_3.setText("english");
	                	textField_4.setText("french");
	                	textField_5.setText("sst");
	                	textField_6.setText("math");
	                	textField_7.setText("science");
	                	textField_8.setText("french");
	                	textField_9.setText("english");
	                	textField_10.setText("math");
	                	textField_11.setText("science");
	                	textField_12.setText("english");
	                	textField_13.setText("sst");
	                	textField_14.setText("french");
	                	textField_15.setText("science");
	                	textField_16.setText("english");
	                	textField_17.setText("sst");
	                	textField_18.setText("math");
	                	textField_19.setText("french");
	                    break;  
	                case "p7p":   
	                	textField.setText("sst");
	                	textField_1.setText("science");
	                	textField_2.setText("math");
	                	textField_3.setText("english");
	                	textField_4.setText("french");
	                	textField_5.setText("sst");
	                	textField_6.setText("math");
	                	textField_7.setText("science");
	                	textField_8.setText("french");
	                	textField_9.setText("english");
	                	textField_10.setText("math");
	                	textField_11.setText("science");
	                	textField_12.setText("english");
	                	textField_13.setText("sst");
	                	textField_14.setText("french");
	                	textField_15.setText("science");
	                	textField_16.setText("english");
	                	textField_17.setText("sst");
	                	textField_18.setText("math");
	                	textField_19.setText("french");
	                    break;  
	            } 
	        }
	        else {
	        	//show art
	        	switch(cl)  
	            {  
	                case "p1g":   
	                	textField.setText("sst");
	                	textField_1.setText("science");
	                	textField_2.setText("math");
	                	textField_3.setText("english");
	                	textField_4.setText("art");
	                	textField_5.setText("sst");
	                	textField_6.setText("math");
	                	textField_7.setText("science");
	                	textField_8.setText("art");
	                	textField_9.setText("english");
	                	textField_10.setText("math");
	                	textField_11.setText("science");
	                	textField_12.setText("english");
	                	textField_13.setText("sst");
	                	textField_14.setText("art");
	                	textField_15.setText("science");
	                	textField_16.setText("english");
	                	textField_17.setText("sst");
	                	textField_18.setText("math");
	                	textField_19.setText("art");
	                    break;  
	                case "p2y":   
	                	textField.setText("science");
	                	textField_1.setText("sst");
	                	textField_2.setText("english");
	                	textField_3.setText("math");
	                	textField_4.setText("sst");
	                	textField_5.setText("art");
	                	textField_6.setText("science");
	                	textField_7.setText("math");
	                	textField_8.setText("english");
	                	textField_9.setText("art");
	                	textField_10.setText("science");
	                	textField_11.setText("math");
	                	textField_12.setText("sst");
	                	textField_13.setText("english");
	                	textField_14.setText("english");
	                	textField_15.setText("art");
	                	textField_16.setText("science");
	                	textField_17.setText("math");
	                	textField_18.setText("art");
	                	textField_19.setText("sst");
	                    break;  
	                case "p3s":   
	                	textField.setText("math");
	                	textField_1.setText("art");
	                	textField_2.setText("sst");
	                	textField_3.setText("english");
	                	textField_4.setText("art");
	                	textField_5.setText("sst");
	                	textField_6.setText("math");
	                	textField_7.setText("science");
	                	textField_8.setText("art");
	                	textField_9.setText("english");
	                	textField_10.setText("math");
	                	textField_11.setText("science");
	                	textField_12.setText("english");
	                	textField_13.setText("sst");
	                	textField_14.setText("art");
	                	textField_15.setText("science");
	                	textField_16.setText("english");
	                	textField_17.setText("sst");
	                	textField_18.setText("math");
	                	textField_19.setText("art");
	                    break;  
	                case "p4w":   
	                	textField.setText("sst");
	                	textField_1.setText("science");
	                	textField_2.setText("math");
	                	textField_3.setText("english");
	                	textField_4.setText("art");
	                	textField_5.setText("sst");
	                	textField_6.setText("math");
	                	textField_7.setText("science");
	                	textField_8.setText("art");
	                	textField_9.setText("english");
	                	textField_10.setText("math");
	                	textField_11.setText("science");
	                	textField_12.setText("english");
	                	textField_13.setText("sst");
	                	textField_14.setText("art");
	                	textField_15.setText("science");
	                	textField_16.setText("english");
	                	textField_17.setText("sst");
	                	textField_18.setText("math");
	                	textField_19.setText("art");  
	                    break;  
	                case "p5r":   
	                	textField.setText("sst");
	                	textField_1.setText("science");
	                	textField_2.setText("math");
	                	textField_3.setText("english");
	                	textField_4.setText("art");
	                	textField_5.setText("sst");
	                	textField_6.setText("math");
	                	textField_7.setText("science");
	                	textField_8.setText("art");
	                	textField_9.setText("english");
	                	textField_10.setText("math");
	                	textField_11.setText("science");
	                	textField_12.setText("english");
	                	textField_13.setText("sst");
	                	textField_14.setText("art");
	                	textField_15.setText("science");
	                	textField_16.setText("english");
	                	textField_17.setText("sst");
	                	textField_18.setText("math");
	                	textField_19.setText("art");
	                    break;  
	                case "p6t":   
	                	textField.setText("sst");
	                	textField_1.setText("science");
	                	textField_2.setText("math");
	                	textField_3.setText("english");
	                	textField_4.setText("art");
	                	textField_5.setText("sst");
	                	textField_6.setText("math");
	                	textField_7.setText("science");
	                	textField_8.setText("art");
	                	textField_9.setText("english");
	                	textField_10.setText("math");
	                	textField_11.setText("science");
	                	textField_12.setText("english");
	                	textField_13.setText("sst");
	                	textField_14.setText("art");
	                	textField_15.setText("science");
	                	textField_16.setText("english");
	                	textField_17.setText("sst");
	                	textField_18.setText("math");
	                	textField_19.setText("art");
	                    break;  
	                case "p7p":   
	                	textField.setText("sst");
	                	textField_1.setText("science");
	                	textField_2.setText("math");
	                	textField_3.setText("english");
	                	textField_4.setText("art");
	                	textField_5.setText("sst");
	                	textField_6.setText("math");
	                	textField_7.setText("science");
	                	textField_8.setText("art");
	                	textField_9.setText("english");
	                	textField_10.setText("math");
	                	textField_11.setText("science");
	                	textField_12.setText("english");
	                	textField_13.setText("sst");
	                	textField_14.setText("art");
	                	textField_15.setText("science");
	                	textField_16.setText("english");
	                	textField_17.setText("sst");
	                	textField_18.setText("math");
	                	textField_19.setText("art");
	                    break;	
	        }
        }
		}}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
