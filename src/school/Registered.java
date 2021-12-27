package school;

import java.awt.BorderLayout;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;

public class Registered extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registered Pupils");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(131, 11, 173, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search RegNo.");
		lblNewLabel_1.setBounds(10, 39, 91, 21);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(111, 39, 112, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Subject");
		lblNewLabel_2.setBounds(233, 40, 45, 20);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(288, 39, 138, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		String[] columnNames = {"username", "firstname", "lastname", "registrationNo", "password", "gender", "age", "class"};
		DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(columnNames);
		table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        String uname = "";
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
            if (rs.next()) {
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
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        contentPane.add(table);
	}
}
