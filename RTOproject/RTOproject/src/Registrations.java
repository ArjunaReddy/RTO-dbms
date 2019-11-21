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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 434, 200);
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
		btnAddRc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				Add_RC usr=new Add_RC();
				usr.frame.setVisible(true);
			}
		});
		btnAddRc.setBounds(163, 216, 89, 23);
		frame.getContentPane().add(btnAddRc);
		
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
