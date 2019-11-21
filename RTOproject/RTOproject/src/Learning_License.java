import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.JTextField;

public class Learning_License 
{
	String pre;
	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
					Learning_License window = new Learning_License();
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
	public Learning_License()
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
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(206, 0, 228, 262);
		frame.getContentPane().add(textArea);
textArea.setText("DL No\tCOV\tDOI\tExpiry Date\tUser_aadhar\n");
		
		try
        { 
			 Class.forName("com.mysql.jdbc.Driver"); 
	            Connection conn = null;
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/rto","root", ""); 
	            System.out.print("Database is connected !");
	            Statement stmt1 = conn.createStatement();
	            String q2="select * from learninglicence;";
	            ResultSet rs = stmt1.executeQuery(q2);
	            while(rs.next())
	            {
	                pre=textArea.getText();
	            	String data1 = rs.getString("LLno");String data2 = rs.getString("cov");String data3 = rs.getString("doi");
	            	String data4 = rs.getString("doe");String data5 = rs.getString("usr_aadhar");
	            	textArea.setText(pre+data1+"\t"+data2+"\t"+data3+"\t"+data4+"\t"+data5+"\t"+"\n");
	            	
	            } 
	            conn.close(); 
        } 
        catch(Exception ex) 
        { 
            System.out.println(ex); 
        }
		
		
		JLabel lblAddNewUser = new JLabel("Add new DL Information");
		lblAddNewUser.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAddNewUser.setBounds(10, 11, 200, 24);
		frame.getContentPane().add(lblAddNewUser);
		
		JLabel lblName = new JLabel("COV :");
		lblName.setBounds(50, 67, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblDlNumber = new JLabel("LL Number: ");
		lblDlNumber.setBounds(20, 46, 76, 14);
		frame.getContentPane().add(lblDlNumber);
		
		JLabel lblDoi = new JLabel("DOI :");
		lblDoi.setBounds(50, 89, 46, 14);
		frame.getContentPane().add(lblDoi);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date :");
		lblExpiryDate.setBounds(13, 107, 63, 14);
		frame.getContentPane().add(lblExpiryDate);
		
		JLabel lblUserId = new JLabel("User ID :");
		lblUserId.setBounds(30, 128, 46, 14);
		frame.getContentPane().add(lblUserId);
		
		textField = new JTextField();
		textField.setBounds(80, 43, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 64, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(80, 86, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(80, 104, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(80, 125, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//2017-01-26   2014-05-23
				if (e.getSource() == btnSubmit)
				{
					try
			        { 
						 Class.forName("com.mysql.jdbc.Driver"); 
				            Connection conn = null;
				            conn = DriverManager.getConnection("jdbc:mysql://localhost/rto","root", ""); 
				            System.out.print("Database is connected !");
				            Statement stmt = conn.createStatement();
				            String q1 = "insert into learninglicence values('" +textField.getText() +  
				                                    "','" + textField_1.getText()+"','"+textField_2.getText()+
				                                    "','"+textField_3.getText()+"',"+textField_4.getText()+")";
				            int a=stmt.executeUpdate(q1);
				           
				            Statement stmt1 = conn.createStatement();
				            
				            String q2="select * from learninglicence;";
				            ResultSet rs = stmt1.executeQuery(q2);
				            if(rs.last())
				            {
				            	String data1 = rs.getString("LLno");String data2 = rs.getString("cov");String data3 = rs.getString("doi");
				            	String data4 = rs.getString("doe");String data5 = rs.getString("usr_aadhar");
				            	textArea.setText(textArea.getText()+data1+"\t"+data2+"\t"+data3+"\t"+data4+"\t"+data5+"\t"+"\n");
				            } 
				            conn.close(); 
			        } 
			        catch(Exception ex) 
			        { 
			            System.out.println(ex); 
			        }
			        }
			}
		});
		btnSubmit.setBounds(77, 177, 89, 23);
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
