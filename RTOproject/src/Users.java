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
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

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
		frame.setBounds(100, 100, 1200, 733);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setBounds(0, 0, 1198, 531);
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
            textArea.setText("FName\t\tMName\t\tLName\t\tPhone_No\t\tAddress\t\tAadhar\n");
            while(rs.next())
            {
            	String pre=textArea.getText();
            	String data1 = rs.getString("FName");String data2 = rs.getString("MName");String data3 = rs.getString("LName");
            	String data4 = rs.getString("aadhar");String data5 = rs.getString("address");String data6 = rs.getString("phno");
            	textArea.setText(pre+data1+"\t\t"+data2+"\t\t"+data3+"\t\t"+data6+"\t\t"+data5+"\t\t"+data4+"\n");
            } 
			conn.close();
		}
		catch(Exception e) {};

		JButton btnAddUser = new JButton("Add User");
		btnAddUser.setFont(new Font("Sylfaen", Font.PLAIN, 23));
		btnAddUser.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				Add_User usr=new Add_User();
				usr.frame.setVisible(true);
			}
		});
		btnAddUser.setBounds(190, 563, 145, 55);
		frame.getContentPane().add(btnAddUser);

		JButton btnDl = new JButton("DL");
		btnDl.setFont(new Font("Sylfaen", Font.PLAIN, 23));
		btnDl.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Driving_License usr=new Driving_License();
				usr.frame.setVisible(true);
			}
		});
		btnDl.setBounds(510, 563, 145, 55);
		frame.getContentPane().add(btnDl);

		JButton btnLl = new JButton("LL");
		btnLl.setFont(new Font("Sylfaen", Font.PLAIN, 23));
		btnLl.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				Learning_License usr=new Learning_License();
				usr.frame.setVisible(true);
			}
		});
		btnLl.setBounds(838, 563, 145, 55);
		frame.getContentPane().add(btnLl);

		JButton btnPrev = new JButton("prev");
		btnPrev.setFont(new Font("Sylfaen", Font.PLAIN, 23));
		btnPrev.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
			}
		});
		btnPrev.setBounds(0, 647, 93, 39);
		frame.getContentPane().add(btnPrev);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LC\\eclipse-workspace\\RTOproject\\images\\pic8.png"));
		lblNewLabel.setBounds(0, 0, 1182, 686);
		frame.getContentPane().add(lblNewLabel);
	}
}
