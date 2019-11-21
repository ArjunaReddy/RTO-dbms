import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Users 
{

	JFrame frame;

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
					Users window = new Users();
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
	public Users()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 548, 292);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 522, 180);
		frame.getContentPane().add(textArea);
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost/rto","root", ""); 
            System.out.print("Database is connected !");
            Statement stmt = conn.createStatement();
            String q1="select * from users;";
            ResultSet rs = stmt.executeQuery(q1); 
            textArea.setText("FName\tMName\tLName\tAadhar\tAddress\tPhone No\n");
            while(rs.next())
            {
            	String pre=textArea.getText();
            	String data1 = rs.getString("FName");String data2 = rs.getString("MName");String data3 = rs.getString("LName");
            	String data4 = rs.getString("aadhar");String data5 = rs.getString("address");String data6 = rs.getString("phno");
            	textArea.setText(pre+data1+"\t"+data2+"\t"+data3+"\t"+data4+"\t"+data5+"\t"+data6+"\n");
            } 
			conn.close();
		}
		catch(Exception e) {};
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				Add_User usr=new Add_User();
				usr.frame.setVisible(true);
			}
		});
		btnAddUser.setBounds(95, 207, 89, 23);
		frame.getContentPane().add(btnAddUser);
		
		JButton btnDl = new JButton("DL");
		btnDl.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Driving_License usr=new Driving_License();
				usr.frame.setVisible(true);
			}
		});
		btnDl.setBounds(228, 207, 89, 23);
		frame.getContentPane().add(btnDl);
		
		JButton btnLl = new JButton("LL");
		btnLl.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				Learning_License usr=new Learning_License();
				usr.frame.setVisible(true);
			}
		});
		btnLl.setBounds(367, 207, 89, 23);
		frame.getContentPane().add(btnLl);
		
		JButton btnPrev = new JButton("prev");
		btnPrev.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
			}
		});
		btnPrev.setBounds(0, 230, 59, 23);
		frame.getContentPane().add(btnPrev);
	}
}
