import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Add_Transfer
{

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
					Add_Transfer window = new Add_Transfer();
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
	public Add_Transfer()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterTheTransfer = new JLabel("Enter the Transfer Details");
		lblEnterTheTransfer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterTheTransfer.setBounds(106, 11, 242, 24);
		frame.getContentPane().add(lblEnterTheTransfer);
		
		JLabel lblNewLabel = new JLabel("Transfer No :");
		lblNewLabel.setBounds(61, 48, 86, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(145, 43, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblBid = new JLabel("BID :");
		lblBid.setBounds(61, 71, 46, 14);
		frame.getContentPane().add(lblBid);
		
		JLabel lblSid = new JLabel("SID :");
		lblSid.setBounds(61, 96, 46, 14);
		frame.getContentPane().add(lblSid);
		
		JLabel lblRegNo = new JLabel("Reg No :");
		lblRegNo.setBounds(61, 119, 60, 14);
		frame.getContentPane().add(lblRegNo);
		
		JLabel lblFuel = new JLabel("Fuel :");
		lblFuel.setBounds(61, 146, 46, 14);
		frame.getContentPane().add(lblFuel);
		
		JLabel lblBody = new JLabel("Date :");
		lblBody.setBounds(61, 171, 46, 14);
		frame.getContentPane().add(lblBody);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 68, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(145, 93, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(145, 118, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(145, 143, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(145, 168, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblCov = new JLabel("COV :");
		lblCov.setBounds(61, 196, 46, 14);
		frame.getContentPane().add(lblCov);
		
		textField_6 = new JTextField();
		textField_6.setBounds(145, 199, 86, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
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
				          
				            String q1 = "insert into transfer values( "+textField.getText() +  
				                                    "," + textField_1.getText()+","+textField_2.getText()+
				                                    ",'"+textField_3.getText()+"','"+textField_4.getText()+
				                                    "','"+textField_5.getText()+"','"+textField_6.getText()+"')";
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
		btnSubmit.setBounds(206, 229, 89, 23);
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
