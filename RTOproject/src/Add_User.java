import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Add_User
{

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Add_User window = new Add_User();
					window.frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Add_User()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.setBounds(100, 100, 1200, 733);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel Enter = new JLabel("Enter the User Details");
		Enter.setForeground(Color.WHITE);
		Enter.setBounds(398, 32, 392, 72);
		Enter.setFont(new Font("Bodoni MT Black", Font.PLAIN, 32));

		JLabel lblName = new JLabel("First Name :");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(432, 157, 124, 25);

		textField = new JTextField();
		textField.setBounds(548, 155, 171, 35);
		textField.setColumns(10);

		JLabel lblAadharNo = new JLabel("Aadhar No :");
		lblAadharNo.setForeground(Color.WHITE);
		lblAadharNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAadharNo.setBounds(432, 354, 116, 25);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setBounds(548, 349, 171, 35);
		textField_1.setColumns(10);

		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(444, 420, 94, 25);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setBounds(548, 415, 171, 35);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setBounds(548, 484, 171, 35);
		textField_3.setColumns(10);

		JLabel lblPhoneNo = new JLabel("Phone No:");
		lblPhoneNo.setForeground(Color.WHITE);
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNo.setBounds(439, 482, 99, 25);

		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(398, 636, 392, 42);
		frame.getContentPane().add(label);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				if (e.getSource() == btnSubmit)
				{
					try
			        { 
						 Class.forName("com.mysql.jdbc.Driver"); 
				            Connection conn = null;
				            conn = DriverManager.getConnection("jdbc:mysql://localhost/rto","root", ""); 
				            System.out.print("Database is connected !");
				            Statement stmt = conn.createStatement();

				            String q1 = "insert into users values('" +textField.getText() +  
				                                    "','" + textField_4.getText()+ "','"+textField_5.getText()+
				                                    "',"+textField_1.getText()+",'"+textField_2.getText()+"',"+textField_3.getText()+")";
				            int a=stmt.executeUpdate(q1);
				            label.setText("User Successfully Inserted.");
				            conn.close(); 
			        } 
			        catch(Exception ex) 
			        { 
			            System.out.println(ex); 
			        }
			        }
			}
		});

		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit.setBounds(526, 581, 129, 42);

		JButton btnPrev = new JButton("prev");
		btnPrev.setIcon(null);
		btnPrev.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPrev.setBounds(0, 643, 106, 49);
		btnPrev.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(Enter);
		frame.getContentPane().add(lblName);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(lblAadharNo);
		frame.getContentPane().add(textField_1);
		frame.getContentPane().add(lblAddress);
		frame.getContentPane().add(textField_2);
		frame.getContentPane().add(textField_3);
		frame.getContentPane().add(lblPhoneNo);
		frame.getContentPane().add(btnSubmit);
		frame.getContentPane().add(btnPrev);

		textField_4 = new JTextField();
		textField_4.setBounds(548, 218, 171, 35);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		JLabel lblMiddleName = new JLabel("Middle Name:");
		lblMiddleName.setForeground(Color.WHITE);
		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMiddleName.setBounds(418, 219, 129, 26);
		frame.getContentPane().add(lblMiddleName);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(548, 285, 171, 35);
		frame.getContentPane().add(textField_5);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLastName.setBounds(432, 286, 116, 26);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LC\\eclipse-workspace\\RTOproject\\images\\pic8alter.png"));
		lblNewLabel.setBounds(0, 0, 1182, 686);
		frame.getContentPane().add(lblNewLabel);


	}
}
