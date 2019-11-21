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
import javax.swing.JButton;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblEnterTheRc = new JLabel("Enter the RC Details");
		lblEnterTheRc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterTheRc.setBounds(116, 11, 258, 26);
		frame.getContentPane().add(lblEnterTheRc);

		JLabel lblRegNo = new JLabel("Reg No :");
		lblRegNo.setBounds(54, 58, 46, 14);
		frame.getContentPane().add(lblRegNo);

		JLabel lblEngNo = new JLabel("Eng No :");
		lblEngNo.setBounds(54, 93, 46, 14);
		frame.getContentPane().add(lblEngNo);

		JLabel lblFuel = new JLabel("Fuel :");
		lblFuel.setBounds(54, 130, 46, 14);
		frame.getContentPane().add(lblFuel);

		JLabel lblCov = new JLabel("COV :");
		lblCov.setBounds(54, 167, 46, 14);
		frame.getContentPane().add(lblCov);

		textField = new JTextField();
		textField.setBounds(99, 55, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(99, 90, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(99, 127, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(99, 164, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JLabel lblDoi = new JLabel("DOI :");
		lblDoi.setBounds(249, 58, 46, 14);
		frame.getContentPane().add(lblDoi);

		JLabel lblExpiryDate = new JLabel("Expiry Date :");
		lblExpiryDate.setBounds(232, 93, 63, 14);
		frame.getContentPane().add(lblExpiryDate);

		JLabel lblModel = new JLabel("Model :");
		lblModel.setBounds(249, 130, 46, 14);
		frame.getContentPane().add(lblModel);

		JLabel lblOwnerId = new JLabel("Owner ID :");
		lblOwnerId.setBounds(232, 167, 63, 14);
		frame.getContentPane().add(lblOwnerId);

		textField_4 = new JTextField();
		textField_4.setBounds(305, 55, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(305, 90, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(305, 127, 86, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(305, 164, 86, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);

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
		btnSubmit.setBounds(171, 216, 89, 23);
		frame.getContentPane().add(btnSubmit);

		JButton btnPrev = new JButton("prev");
		btnPrev.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
			}
		});
		btnPrev.setBounds(0, 228, 59, 25);
		frame.getContentPane().add(btnPrev);
	}

}
