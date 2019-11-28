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
import java.awt.Color;

public class Registrations
{
	String pre;
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
				try {
					Registrations window = new Registrations();
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
	public Registrations()
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
		textArea.setTabSize(15);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setBounds(0, 0, 1182, 552);
		frame.getContentPane().add(textArea);
		textArea.setText("Regno\tEngno\tFuel\tCOV\tDOI\tDOE\tModel\tOwnerid\n");

		try
        { 
			 Class.forName("com.mysql.jdbc.Driver"); 
	            Connection conn = null;
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/rto","root", ""); 
	            System.out.print("Database is connected !");
	            Statement stmt1 = conn.createStatement();
	            String q2="select * from rc;";
	            ResultSet rs = stmt1.executeQuery(q2);
	            while(rs.next())
	            {
	                pre=textArea.getText();
	            	String data1 = rs.getString("regno");String data2 = rs.getString("engno");String data3 = rs.getString("fuel");
	            	String data4 = rs.getString("cov");String data5 = rs.getString("doi");String data6 = rs.getString("doe");
	            	String data7 = rs.getString("model");String data8 = rs.getString("ownerid");
	            	textArea.setText(pre+data1+"\t"+data2+"\t"+data3+"\t"+data4+"\t"+data5+"\t"+data6+"\t"+data7+"\t"+data8+"\n");

	            } 
	            conn.close(); 
        } 
        catch(Exception ex) 
        { 
            System.out.println(ex); 
        }

		JButton btnAddRc = new JButton("Add RC");
		btnAddRc.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnAddRc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				frame.setVisible(false);
				Add_RC usr=new Add_RC();
				usr.frame.setVisible(true);
			}
		});
		btnAddRc.setBounds(517, 574, 134, 58);
		frame.getContentPane().add(btnAddRc);

		JButton btnPrev = new JButton("prev");
		btnPrev.setBackground(new Color(255, 255, 102));
		btnPrev.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnPrev.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				Controls c=new Controls();
				c.frame.setVisible(true);
				
			}
		});
		btnPrev.setBounds(0, 648, 82, 38);
		frame.getContentPane().add(btnPrev);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("C:\\Users\\LC\\eclipse-workspace\\RTOproject\\images\\pic8 - Copy.png"));
		label.setBounds(0, 0, 1182, 686);
		frame.getContentPane().add(label);
	}

}
