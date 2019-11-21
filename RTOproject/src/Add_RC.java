import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class Add_RC 
{

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
					Add_RC window = new Add_RC();
					window.frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Add_RC() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 733);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblEnterTheRc = new JLabel("Enter the RC Details");
		lblEnterTheRc.setForeground(Color.WHITE);
		lblEnterTheRc.setFont(new Font("Bodoni MT Black", Font.PLAIN, 32));
		lblEnterTheRc.setBounds(393, 37, 481, 69);
		frame.getContentPane().add(lblEnterTheRc);

		JLabel lblRegNo = new JLabel("Reg No :");
		lblRegNo.setForeground(Color.WHITE);
		lblRegNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegNo.setBounds(220, 198, 94, 44);
		frame.getContentPane().add(lblRegNo);

		JLabel lblEngNo = new JLabel("Eng No :");
		lblEngNo.setForeground(Color.WHITE);
		lblEngNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEngNo.setBounds(220, 276, 106, 37);
		frame.getContentPane().add(lblEngNo);

		JLabel lblFuel = new JLabel("Fuel :");
		lblFuel.setForeground(Color.WHITE);
		lblFuel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFuel.setBounds(220, 351, 86, 35);
		frame.getContentPane().add(lblFuel);

		JLabel lblCov = new JLabel("COV :");
		lblCov.setForeground(Color.WHITE);
		lblCov.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCov.setBounds(220, 407, 86, 44);
		frame.getContentPane().add(lblCov);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(307, 205, 183, 37);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(307, 276, 183, 37);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setBounds(307, 342, 183, 37);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setBounds(307, 411, 183, 40);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JLabel lblDoi = new JLabel("DOI :");
		lblDoi.setForeground(Color.WHITE);
		lblDoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDoi.setBounds(577, 213, 76, 29);
		frame.getContentPane().add(lblDoi);

		JLabel lblExpiryDate = new JLabel("Expiry Date :");
		lblExpiryDate.setForeground(Color.WHITE);
		lblExpiryDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblExpiryDate.setBounds(577, 276, 116, 37);
		frame.getContentPane().add(lblExpiryDate);

		JLabel lblModel = new JLabel("Model :");
		lblModel.setForeground(Color.WHITE);
		lblModel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModel.setBounds(577, 346, 85, 44);
		frame.getContentPane().add(lblModel);

		JLabel lblOwnerId = new JLabel("Owner ID :");
		lblOwnerId.setForeground(Color.WHITE);
		lblOwnerId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOwnerId.setBounds(575, 409, 102, 41);
		frame.getContentPane().add(lblOwnerId);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setBounds(704, 205, 185, 37);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setBounds(704, 279, 185, 37);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setBounds(704, 342, 185, 37);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_7.setBounds(704, 414, 185, 37);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 23));
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

				            String q1 = "insert into rc values('" +textField.getText() +  
				                                    "','" + textField_1.getText()+"','"+textField_2.getText()+
				                                    "','"+textField_3.getText()+"','"+textField_4.getText()+
				                                    "','"+textField_5.getText()+"','"+textField_6.getText()+
				                                    "',"+textField_7.getText()+")";
				            int a=stmt.executeUpdate(q1);
				            conn.close(); 
			        } 
			        catch(Exception ex) 
			        { 
			            System.out.println(ex); 
			        }
			        }
			}
		});
		btnSubmit.setBounds(496, 594, 127, 44);
		frame.getContentPane().add(btnSubmit);

		JButton btnPrev = new JButton("prev");
		btnPrev.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnPrev.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
			}
		});
		btnPrev.setBounds(0, 649, 86, 37);
		frame.getContentPane().add(btnPrev);
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ArjunAmulya\\git\\RTO-dbms\\RTOproject\\images\\pic8alter.png"));
		lblNewLabel_1.setBounds(0, -1, 1182, 686);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
