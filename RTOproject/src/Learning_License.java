import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
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
		frame.setBounds(100, 100, 1200, 733);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setTabSize(12);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBounds(487, 0, 697, 686);
		frame.getContentPane().add(textArea);
textArea.setText(" LL_No\tCOV\tDOI\tExp_Date\t T_Date\tUser_aadhar\n");

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
	            	String data4 = rs.getString("doe");String data5 = rs.getString("usr_aadhar");String data6 = rs.getString("T_Date");
	            	textArea.setText(pre+" "+data1+"\t"+data2+"\t"+data3+"\t"+data4+"\t "+data6+"\t"+data5+"\n");

	            } 
	            conn.close(); 
        } 
        catch(Exception ex) 
        { 
            System.out.println(ex); 
        }


		JLabel lblAddNewUser = new JLabel("Add new LL Information");
		lblAddNewUser.setForeground(Color.WHITE);
		lblAddNewUser.setFont(new Font("Bodoni MT Black", Font.PLAIN, 30));
		lblAddNewUser.setBounds(56, 13, 438, 51);
		frame.getContentPane().add(lblAddNewUser);

		JLabel lblName = new JLabel("COV :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(66, 199, 117, 39);
		frame.getContentPane().add(lblName);

		JLabel lblDlNumber = new JLabel("LL Number: ");
		lblDlNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDlNumber.setForeground(Color.WHITE);
		lblDlNumber.setBounds(66, 130, 117, 39);
		frame.getContentPane().add(lblDlNumber);

		JLabel lblDoi = new JLabel("DOI :");
		lblDoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDoi.setForeground(Color.WHITE);
		lblDoi.setBounds(66, 264, 117, 39);
		frame.getContentPane().add(lblDoi);

		JLabel lblExpiryDate = new JLabel("Expiry Date :");
		lblExpiryDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblExpiryDate.setForeground(Color.WHITE);
		lblExpiryDate.setBounds(64, 332, 117, 38);
		frame.getContentPane().add(lblExpiryDate);

		JLabel lblUserId = new JLabel("User_aadhar:");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserId.setForeground(Color.WHITE);
		lblUserId.setBounds(56, 404, 127, 39);
		frame.getContentPane().add(lblUserId);

		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField.setBounds(195, 130, 217, 39);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_1.setBounds(195, 199, 217, 39);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_2.setBounds(193, 267, 222, 39);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_3.setBounds(193, 335, 219, 38);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_4.setBounds(195, 398, 217, 39);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblTestDate = new JLabel("Test Date :");
		lblTestDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTestDate.setForeground(Color.WHITE);
		lblTestDate.setBounds(59, 468, 124, 38);
		frame.getContentPane().add(lblTestDate);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_5.setBounds(195, 469, 217, 39);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Sylfaen", Font.PLAIN, 20));
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
				                                    "','"+textField_3.getText()+"',"+textField_4.getText()+",'"+textField_5.getText()+"')";
				            int a=stmt.executeUpdate(q1);

				            Statement stmt1 = conn.createStatement();

				            String q2="select * from learninglicence;";
				            ResultSet rs = stmt1.executeQuery(q2);
				            if(rs.last())
				            {
				            	String data1 = rs.getString("LLno");String data2 = rs.getString("cov");String data3 = rs.getString("doi");
				            	String data4 = rs.getString("doe");String data5 = rs.getString("usr_aadhar");String data6 = rs.getString("T_Date");
				            	textArea.setText(textArea.getText()+data1+"\t"+data2+"\t"+data3+"\t"+data4+"\t"+data6+"\t"+data5+"\t"+"\n");
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
		btnSubmit.setBounds(238, 538, 117, 38);
		frame.getContentPane().add(btnSubmit);

		JButton btnPrev = new JButton("prev");
		btnPrev.setBackground(new Color(255, 255, 102));
		btnPrev.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnPrev.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Users u=new Users();
				frame.setVisible(false);
				u.frame.setVisible(true);
			}
		});
		btnPrev.setBounds(0, 647, 83, 39);
		frame.getContentPane().add(btnPrev);
		

		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LC\\eclipse-workspace\\RTOproject\\images\\DL - Copy.png"));
		lblNewLabel.setBounds(0, 0, 1182, 686);
		frame.getContentPane().add(lblNewLabel);
		
	}

}
