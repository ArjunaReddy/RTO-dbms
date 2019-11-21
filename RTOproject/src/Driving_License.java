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

public class Driving_License {

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


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 733);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setBounds(566, 0, 616, 686);
		frame.getContentPane().add(textArea);
		textArea.setText("DL No\tCOV\tDOI\tExpiry Date\tUser_aadhar\n");

		try
        { 
			 Class.forName("com.mysql.jdbc.Driver"); 
	            Connection conn = null;
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/rto","root", ""); 
	            System.out.print("Database is connected !");
	            Statement stmt1 = conn.createStatement();
	            String q2="select * from drivinglicense;";
	            ResultSet rs = stmt1.executeQuery(q2);
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

		JLabel lblAddNewUser = new JLabel("Add new DL Information");
		lblAddNewUser.setForeground(Color.WHITE);
		lblAddNewUser.setFont(new Font("Bodoni MT Black", Font.PLAIN, 30));
		lblAddNewUser.setBounds(61, 41, 438, 51);
		frame.getContentPane().add(lblAddNewUser);

		JLabel lblName = new JLabel("COV :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(61, 230, 117, 39);
		frame.getContentPane().add(lblName);

		JLabel lblDlNumber = new JLabel("DL Number: ");
		lblDlNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDlNumber.setForeground(Color.WHITE);
		lblDlNumber.setBounds(61, 161, 117, 39);
		frame.getContentPane().add(lblDlNumber);

		JLabel lblDoi = new JLabel("DOI :");
		lblDoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDoi.setForeground(Color.WHITE);
		lblDoi.setBounds(61, 295, 117, 39);
		frame.getContentPane().add(lblDoi);

		JLabel lblExpiryDate = new JLabel("Expiry Date :");
		lblExpiryDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblExpiryDate.setForeground(Color.WHITE);
		lblExpiryDate.setBounds(59, 363, 117, 38);
		frame.getContentPane().add(lblExpiryDate);

		JLabel lblUserId = new JLabel("User ID :");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserId.setForeground(Color.WHITE);
		lblUserId.setBounds(61, 435, 117, 39);
		frame.getContentPane().add(lblUserId);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(190, 161, 217, 39);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(190, 230, 217, 39);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(188, 298, 222, 39);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(188, 366, 219, 38);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(190, 429, 217, 39);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

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
				            String q1 = "insert into drivinglicense values('" +textField.getText() +  
				                                    "','" + textField_1.getText()+"','"+textField_2.getText()+
				                                    "','"+textField_3.getText()+"',"+textField_4.getText()+")";
				            int a=stmt.executeUpdate(q1);

				            Statement stmt1 = conn.createStatement();

				            String q2="select * from drivinglicense;";
				            ResultSet rs = stmt1.executeQuery(q2);
				            if(rs.last())
				            {
				            	String data1 = rs.getString("DLno");String data2 = rs.getString("cov");String data3 = rs.getString("doi");
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

		btnSubmit.setBounds(232, 505, 116, 39);
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
		btnPrev.setBounds(0, 647, 84, 39);
		frame.getContentPane().add(btnPrev);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LC\\eclipse-workspace\\RTOproject\\images\\pic8 - Copy (2).png"));
		lblNewLabel.setBounds(0, 0, 1182, 686);
		frame.getContentPane().add(lblNewLabel);
	}

}
