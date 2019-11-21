import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class Admin_Login 
{

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private Container c;

	// Launching the application
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try
				{
					Admin_Login window = new Admin_Login();
					window.frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	// Creating the application
	public Admin_Login()
	{
		initialize();
	}

	// Initializing the contents of the frame
	private void initialize()
	{
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.setBounds(100, 100, 459, 328);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		c=frame.getContentPane();
		
		
		JLabel lblWelcomeToRto = new JLabel("WELCOME TO RTO MANAGEMENT SYSTEM");
		lblWelcomeToRto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWelcomeToRto.setBounds(31, 11, 402, 40);
		c.add(lblWelcomeToRto);
		
		JLabel lblAdminId = new JLabel("Admin ID :");
		lblAdminId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdminId.setBounds(133, 117, 80, 21);
		frame.getContentPane().add(lblAdminId);
		
		textField = new JTextField();
		textField.setBounds(213, 119, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(130, 149, 83, 14);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(213, 148, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == btnLogin) {
					try
			        { 
			        	 Class.forName("com.mysql.jdbc.Driver"); 
				            Connection conn = null;
				            conn = DriverManager.getConnection("jdbc:mysql://localhost/rto","root", ""); 
				            System.out.print("Database is connected !");
				            Statement stmt = conn.createStatement(); 
				              
				            // SELECT query 
				            @SuppressWarnings("deprecation")
							String q1 = "select * from admin WHERE adminid= '" +textField.getText() +  
				                                    "' AND password = '" + passwordField.getText() + "'"; 
				            ResultSet rs = stmt.executeQuery(q1); 
				            if (rs.next()) 
				            { 
				            	JOptionPane.showMessageDialog(frame,"login  successful");
				                 Controls ab=new Controls();
				                 ab.frame.setVisible(true);
				            } 
				            else
				            { 
				            	JOptionPane.showMessageDialog(frame,"Wrong password or adminid");
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
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(178, 189, 70, 23);
		frame.getContentPane().add(btnLogin);
	}
}
