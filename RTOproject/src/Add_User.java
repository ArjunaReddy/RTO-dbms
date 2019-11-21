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
		frame.setBounds(100, 100, 1265, 739);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel Enter = new JLabel("Enter the User Details");
		Enter.setBounds(482, 23, 256, 42);
		Enter.setFont(new Font("Tahoma", Font.PLAIN, 25));

		JLabel lblName = new JLabel("First Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(398, 113, 124, 25);

		textField = new JTextField();
		textField.setBounds(514, 111, 171, 35);
		textField.setColumns(10);

		JLabel lblAadharNo = new JLabel("Aadhar No :");
		lblAadharNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAadharNo.setBounds(398, 310, 116, 25);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setBounds(514, 305, 171, 35);
		textField_1.setColumns(10);

		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(410, 376, 94, 25);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setBounds(514, 371, 171, 35);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setBounds(514, 440, 171, 35);
		textField_3.setColumns(10);

		JLabel lblPhoneNo = new JLabel("Phone No:");
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNo.setBounds(405, 438, 99, 25);

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
		btnSubmit.setBounds(536, 541, 129, 42);

		JButton btnPrev = new JButton("prev");
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
		textField_4.setBounds(514, 174, 171, 35);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		JLabel lblMiddleName = new JLabel("Middle Name:");
		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMiddleName.setBounds(384, 175, 129, 26);
		frame.getContentPane().add(lblMiddleName);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(514, 241, 171, 35);
		frame.getContentPane().add(textField_5);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLastName.setBounds(398, 242, 116, 26);
		frame.getContentPane().add(lblLastName);


	}
}
