import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class Admin_Login 
{

	JFrame frame;
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
		frame.setBounds(100, 100, 1200, 733);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		c=frame.getContentPane();
		
		
		JLabel lblWelcomeToRto = new JLabel("WELCOME TO NAMMA RTO");
		lblWelcomeToRto.setForeground(new Color(255, 255, 0));
		lblWelcomeToRto.setBackground(Color.LIGHT_GRAY);
		lblWelcomeToRto.setFont(new Font("Bodoni MT Black", Font.BOLD, 38));
		lblWelcomeToRto.setBounds(275, 34, 710, 93);
		c.add(lblWelcomeToRto);
		
		JLabel lblAdminId = new JLabel("Admin ID :");
		lblAdminId.setForeground(new Color(0, 0, 0));
		lblAdminId.setFont(new Font("Sylfaen", Font.BOLD, 24));
		lblAdminId.setBounds(362, 177, 147, 49);
		frame.getContentPane().add(lblAdminId);
		
		textField = new JTextField();
		textField.setFont(new Font("Sylfaen", Font.PLAIN, 23));
		textField.setBounds(521, 178, 240, 49);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Sylfaen", Font.BOLD, 24));
		lblPassword.setBounds(362, 273, 147, 54);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Sylfaen", Font.PLAIN, 23));
		passwordField.setBounds(521, 277, 240, 48);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.DARK_GRAY);
		btnLogin.setForeground(new Color(255, 204, 0));
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
				                  frame.setVisible(false);
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
		btnLogin.setFont(new Font("Sylfaen", Font.BOLD, 22));
		btnLogin.setBounds(557, 385, 110, 42);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LC\\eclipse-workspace\\RTOproject\\images\\pic1.jpg"));
		lblNewLabel.setBounds(0, 0, 1182, 686);
		frame.getContentPane().add(lblNewLabel);
	}
}
