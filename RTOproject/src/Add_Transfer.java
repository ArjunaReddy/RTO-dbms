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
import java.awt.Color;
import javax.swing.ImageIcon;

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
		frame.setBounds(100, 100, 1200, 733);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblEnterTheTransfer = new JLabel("Enter the Transfer Details");
		lblEnterTheTransfer.setForeground(Color.WHITE);
		lblEnterTheTransfer.setFont(new Font("Bodoni MT Black", Font.PLAIN, 32));
		lblEnterTheTransfer.setBounds(352, 40, 461, 59);
		frame.getContentPane().add(lblEnterTheTransfer);

		JLabel lblNewLabel = new JLabel("Transfer No :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(385, 169, 130, 36);
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(527, 169, 179, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblBid = new JLabel("BID :");
		lblBid.setForeground(Color.WHITE);
		lblBid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBid.setBounds(385, 218, 86, 35);
		frame.getContentPane().add(lblBid);

		JLabel lblSid = new JLabel("SID :");
		lblSid.setForeground(Color.WHITE);
		lblSid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSid.setBounds(385, 266, 66, 33);
		frame.getContentPane().add(lblSid);

		JLabel lblRegNo = new JLabel("Reg No :");
		lblRegNo.setForeground(Color.WHITE);
		lblRegNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegNo.setBounds(379, 321, 118, 36);
		frame.getContentPane().add(lblRegNo);

		JLabel lblFuel = new JLabel("Fuel :");
		lblFuel.setForeground(Color.WHITE);
		lblFuel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFuel.setBounds(385, 378, 86, 36);
		frame.getContentPane().add(lblFuel);

		JLabel lblBody = new JLabel("Date :");
		lblBody.setForeground(Color.WHITE);
		lblBody.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBody.setBounds(385, 427, 86, 36);
		frame.getContentPane().add(lblBody);

		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(527, 218, 179, 36);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setBounds(527, 266, 179, 36);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setForeground(Color.BLACK);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setBounds(527, 322, 179, 36);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setForeground(Color.BLACK);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setBounds(527, 379, 179, 36);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setForeground(Color.BLACK);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setBounds(527, 428, 179, 36);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		JLabel lblCov = new JLabel("COV :");
		lblCov.setForeground(Color.WHITE);
		lblCov.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCov.setBounds(385, 476, 98, 36);
		frame.getContentPane().add(lblCov);

		textField_6 = new JTextField();
		textField_6.setForeground(Color.BLACK);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setBounds(527, 477, 179, 36);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Sylfaen", Font.PLAIN, 23));
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
		btnSubmit.setBounds(549, 572, 130, 45);
		frame.getContentPane().add(btnSubmit);

		JButton btnPrev = new JButton("prev");
		btnPrev.setFont(new Font("Sylfaen", Font.PLAIN, 23));
		btnPrev.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
			}
		});
		btnPrev.setBounds(0, 650, 98, 36);
		frame.getContentPane().add(btnPrev);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ArjunAmulya\\git\\RTO-dbms\\RTOproject\\images\\pic8alter.png"));
		lblNewLabel_1.setBounds(0, -1, 1182, 686);
		frame.getContentPane().add(lblNewLabel_1);


	}
}
