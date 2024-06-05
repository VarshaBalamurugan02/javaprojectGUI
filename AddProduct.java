package appdevelop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct frame = new AddProduct();
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
	public AddProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AddProduct");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(163, 10, 183, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ProductID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(57, 72, 114, 22);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(216, 72, 162, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ProductName");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(57, 134, 114, 22);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(216, 134, 162, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ProductPrice");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(62, 187, 134, 22);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(216, 187, 162, 23);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		 final JButton btnNewButton = new JButton("Addproduct");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					int pid=Integer.parseInt(textField.getText());
					String pname=textField_1.getText();
					int pprice=Integer.parseInt(textField_2.getText());
					String str2="insert into product values('"+pid+"','"+pname+"','"+pprice+"')";
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stmt=conn.createStatement();
					stmt.executeUpdate(str2);
					JOptionPane.showMessageDialog(btnNewButton,"Inserted...");
				
					
				}
				catch(Exception t)
				{
				  System.out.print(t);	
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(45, 269, 103, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String pid=textField.getText();
					String str1="select * from product where productid='"+pid+"'";
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(str1);
					rs.next();
					String r1=rs.getString(2);
					String r2=rs.getString(3);
					textField_1.setText(r1);
					textField_2.setText(r2);
					JOptionPane.showMessageDialog(btnNewButton_1,"Searching...");
					
				}
				catch(Exception t)
				
				{
					System.out.print(t);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(193, 270, 103, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String pid=textField.getText();
					String pname=textField_1.getText();
					String str1="update product set productname='"+pname+"'where productid='"+pid+"'";
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stmt=conn.createStatement();
					stmt.executeUpdate(str1);
					JOptionPane.showMessageDialog(btnNewButton_2,"updated");
					
				}
				catch(Exception t)
				{
					System.out.print(t);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(342, 270, 103, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String pid=textField.getText();
					String str1="delete from product where productid='"+pid+"'";
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stmt=conn.createStatement();
					stmt.executeUpdate(str1);
					JOptionPane.showMessageDialog(btnNewButton_3,"Deleted...");
				}
				catch(Exception t)
				{
					System.out.print(t);
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(393, 224, 85, 21);
		contentPane.add(btnNewButton_3);
	}

}
