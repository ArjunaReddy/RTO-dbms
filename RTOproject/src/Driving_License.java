import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.sql.Date;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;  

public class Driving_License {

	String pre;
	JFrame frame;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Driving_License window = new Driving_License();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Driving_License() {
		initialize();
	}
	public void view(JTextArea textArea) {
		try
        { 
			 Class.forName("com.mysql.jdbc.Driver"); 
	            Connection conn = null;
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/rto","root", ""); 
	            System.out.print("Database is connected !");
	            Statement stmt1 = conn.createStatement();
	            String q2="select * from drivinglicense;";
	            ResultSet rs = stmt1.executeQuery(q2);
	            textArea.setText("DL_No\tCOV\tDOI\tExpiry_Date\tUser_aadhar\n");
	            while(rs.next())
	            {
	                pre=textArea.getText();
	            	String data1 = rs.getString("DLno");String data2 = rs.getString("cov");String data3 = rs.getString("doi");
	            	String data4 = rs.getString("doe");String data5 = rs.getString("usr_aadhar");
	            	textArea.setText(pre+data1+"\t"+data2+"\t"+data3+"\t"+data4+"\t"+data5+"\t"+"\n");

	            } 
	            conn.close(); 
        } 
        catch(Exception ex) 
        { 
            System.out.println(ex); 
        }
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 733);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setTabSize(13);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBounds(522, 11, 660, 675);
		frame.getContentPane().add(textArea);
	
		
		view(textArea);
		
		JLabel lblAddNewUser = new JLabel("Add new DL Information");
		lblAddNewUser.setForeground(Color.WHITE);
		lblAddNewUser.setFont(new Font("Bodoni MT Black", Font.PLAIN, 30));
		lblAddNewUser.setBounds(32, 24, 408, 51);
		frame.getContentPane().add(lblAddNewUser);

		JLabel lblDlNumber = new JLabel("DL Number: ");
		lblDlNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDlNumber.setForeground(Color.WHITE);
		lblDlNumber.setBounds(61, 232, 117, 39);
		frame.getContentPane().add(lblDlNumber);

		JLabel lblExpiryDate = new JLabel("Expiry Date :");
		lblExpiryDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblExpiryDate.setForeground(Color.WHITE);
		lblExpiryDate.setBounds(61, 300, 117, 38);
		frame.getContentPane().add(lblExpiryDate);

		JLabel lblUserId = new JLabel("User ID :");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserId.setForeground(Color.WHITE);
		lblUserId.setBounds(61, 168, 117, 39);
		frame.getContentPane().add(lblUserId);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(190, 232, 217, 39);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setBounds(188, 304, 219, 38);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setBounds(190, 168, 217, 39);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Sylfaen", Font.PLAIN, 20));
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
				            String q1 = "update drivinglicense set DLno='" +textField.getText() +  
				                                    "',doe='"+textField_3.getText()+"' where usr_aadhar="+textField_4.getText();
				            int a=stmt.executeUpdate(q1);

				            Statement stmt1 = conn.createStatement();

				            String q2="select * from drivinglicense;";
				            ResultSet rs = stmt1.executeQuery(q2);
				            if(rs.last())
				            {
				            	String data1 = rs.getString("DLno");String data2 = rs.getString("cov");String data3 = rs.getString("doi");
				            	String data4 = rs.getString("doe");String data5 = rs.getString("usr_aadhar");
				            	textArea.setText(" DL_No\t\tCOV\tDOI\tExpiry Date\tUser_aadhar\n"+data1+"\t\t"+data2+"\t"+data3+"\t"+data4+"\t"+data5+"\t"+"\n");
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

		btnSubmit.setBounds(223, 436, 116, 39);
		frame.getContentPane().add(btnSubmit);

		JButton btnPrev = new JButton("prev");
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
		btnPrev.setBounds(0, 647, 84, 39);
		frame.getContentPane().add(btnPrev);
		
	
		
		JButton button = new JButton("View All");
		button.setBackground(UIManager.getColor("Button.background"));
		button.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				if (e.getSource() == button)
				{
					view(textArea);
			     }
			}
		});
		button.setBounds(89, 510, 153, 39);
		frame.getContentPane().add(button);
		
		JButton button1 = new JButton("New Entries");
		button1.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		button1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				if (e.getSource() == button1)
				{
					try
			        { 
						 Class.forName("com.mysql.jdbc.Driver"); 
				            Connection conn = null;
				            conn = DriverManager.getConnection("jdbc:mysql://localhost/rto","root", ""); 
				            System.out.print("Database is connected !");
				            Statement stmt1 = conn.createStatement();

				            String q2="select usr_aadhar from drivinglicense where DLno='NULL' ";
				            ResultSet rs = stmt1.executeQuery(q2);
				            textArea.setText("User_aadhar\n");
				            while(rs.next())
				            {
				            	String data1 = rs.getString("usr_aadhar");
				            	textArea.setText(textArea.getText()+"\n"+data1+"\n");
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
		button1.setBounds(317, 509, 153, 40);
		frame.getContentPane().add(button1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LC\\eclipse-workspace\\RTOproject\\images\\pic8 - Copy (2).png"));
		lblNewLabel.setBounds(0, 11, 1182, 686);
		frame.getContentPane().add(lblNewLabel);
	}
}
