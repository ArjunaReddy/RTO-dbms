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

public class Transfer 
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
				try
				{
					Transfer window = new Transfer();
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
	public Transfer() 
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
		textArea.setBounds(0, 0, 434, 208);
		frame.getContentPane().add(textArea);
textArea.setText("Regno\tEngno\tFuel\tCOV\tDOI\tDOE\tModel\tOwnerid\n");

		try
        { 
			 Class.forName("com.mysql.jdbc.Driver"); 
	            Connection conn = null;
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/rto","root", ""); 
	            System.out.print("Database is connected !");
	            Statement stmt1 = conn.createStatement();
	            String q2="select * from transfer;";
	            ResultSet rs = stmt1.executeQuery(q2);
	            while(rs.next())
	            {
	                pre=textArea.getText();
	            	String data1 = rs.getString("t_no");String data2 = rs.getString("b_id");String data3 = rs.getString("s_id");
	            	String data4 = rs.getString("regno");String data5 = rs.getString("fuel");String data6 = rs.getString("tdate");
	            	String data7 = rs.getString("cov");
	            	textArea.setText(pre+data1+"\t"+data2+"\t"+data3+"\t"+data4+"\t"+data5+"\t"+data6+"\t"+data7+"\n");

	            } 
	            conn.close(); 
        } 
        catch(Exception ex) 
        { 
            System.out.println(ex); 
        }

		JButton btnAddTransfer = new JButton("Add Transfer");
		btnAddTransfer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Add_Transfer usr=new Add_Transfer();
				usr.frame.setVisible(true);
			}
		});
		btnAddTransfer.setBounds(172, 219, 102, 23);
		frame.getContentPane().add(btnAddTransfer);

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
