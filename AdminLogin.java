package appdevelop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import com.ibm.icu.util.BytesTrie.Result;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JPasswordField textField_1;
	protected JTextComponent textFeild1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AdminLogin");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(185, 10, 130, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("AdminId");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(40, 97, 140, 22);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(147, 101, 180, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(40, 186, 99, 22);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(146, 190, 181, 19);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					try 
					{
						String u1=textField.getText();
						String p1=textField_1.getText();
						String str="Select * from adminpage";
						Class.forName("org.h2.Driver");
						Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
						Statement stmt=conn.createStatement();
						ResultSet rs=stmt.executeQuery(str);
						rs.next();
						String Uname=rs.getString(1);
						String pass=rs.getString(2);
						if(u1.equals(Uname)&&p1.equals(pass)) {
							JOptionPane.showMessageDialog(btnNewButton,"LOGIN SUCCESS!!!");
							new AdminHomepage2().setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(btnNewButton,"LOGIN FAILED!!!");
							new AdminLogin().setVisible(true);
						}
						
						}
					catch(Exception t){
						System.out.println(t);
					
				
					}
				}
			}
		}
			
		);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(54, 266, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(269, 267, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
