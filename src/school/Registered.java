package school;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class Registered extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registered frame = new Registered();
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
	public Registered() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Registered Pupils");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(131, 11, 173, 31);
		contentPane.add(lblNewLabel);
		
		JTextField textField_2 = new JTextField();
		contentPane.add(textField_2);
		textField_2.setPreferredSize( new Dimension(100, 24) );
		
		String[] columnNames = {"username", "firstname", "lastname", "registrationNo", "password", "gender", "age", "class"};
		DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(columnNames);
		table = new JTable(model);
		table.setBounds(0, 307, 499, -247);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        String uname = "";
        String sear = "";
        String firstname = "";
        String lastname = "";
        String registrationNo = "";
        String pass = "";
        String gender = "";
        String age = "";
        String clas = "";
        try {
				Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kps",
                        "root", "root");
            PreparedStatement pst = connection.prepareStatement("select * from pupil");
            ResultSet rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
            	registrationNo = rs.getString("registrationNo");
            	if(sear.equals("")) {
	                uname = rs.getString("username");
	                firstname = rs.getString("firstname");
	                lastname = rs.getString("lastname");
	                registrationNo = rs.getString("registrationNo");
	                pass = rs.getString("password");
	                gender = rs.getString("gender");
	                age = rs.getString("age");
	                clas = rs.getString("class");
	                model.addRow(new Object[]{uname, firstname, lastname, registrationNo, pass, gender, age, clas});
	                i++;
            	}
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        JButton btnNewButton = new JButton("Search");
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setRowCount(0);
				String uname = "";
		        String firstname = "";
		        String lastname = "";
		        String registrationNo = "";
		        String pass = "";
		        String gender = "";
		        String age = "";
		        String clas = "";
				String sear = textField_2.getText();
				try {
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kps",
	                        "root", "root");
	            PreparedStatement pst = connection.prepareStatement("select * from pupil");
	            ResultSet rs = pst.executeQuery();
	            while (rs.next()) {
				if(sear.contains("18")) {
            		uname = rs.getString("username");
	                firstname = rs.getString("firstname");
	                lastname = rs.getString("lastname");
	                registrationNo = rs.getString("registrationNo");
	                pass = rs.getString("password");
	                gender = rs.getString("gender");
	                age = rs.getString("age");
	                clas = rs.getString("class");
	                if(registrationNo.equals(sear)) {
	                model.addRow(new Object[]{uname, firstname, lastname, registrationNo, pass, gender, age, clas});
	                }
            	}
            	else if(!sear.isEmpty()){
            		PreparedStatement prst = connection.prepareStatement("select * from " + sear);
                    ResultSet resl = prst.executeQuery();
                    while(resl.next()) {
    	                String reg = resl.getString("regNo");
    	                uname = rs.getString("username");
    	                firstname = rs.getString("firstname");
    	                lastname = rs.getString("lastname");
    	                registrationNo = rs.getString("registrationNo");
    	                pass = rs.getString("password");
    	                gender = rs.getString("gender");
    	                age = rs.getString("age");
    	                clas = rs.getString("class");
    	                if(registrationNo.equals(reg)) {
    	                model.addRow(new Object[]{uname, firstname, lastname, registrationNo, pass, gender, age, clas});
    	                }
                    }
            	}}			
			}catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }}
		});
        contentPane.add(new JScrollPane(table));
	}
}
