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
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

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
		frame.setBounds(100, 100, 1200, 733);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setTabSize(17);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setBounds(0, 0, 1200, 557);
		frame.getContentPane().add(textArea);
textArea.setText("t_no\tb_id\ts_id\tRegno\tFuel\tt_date\tCOV\n");

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
		btnAddTransfer.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnAddTransfer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				Add_Transfer usr=new Add_Transfer();
				usr.frame.setVisible(true);
			}
		});
		btnAddTransfer.setBounds(497, 578, 169, 53);
		frame.getContentPane().add(btnAddTransfer);

		JButton btnPrev = new JButton("prev");
		btnPrev.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnPrev.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Controls c=new Controls();
				c.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnPrev.setBounds(0, 646, 85, 40);
		frame.getContentPane().add(btnPrev);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LC\\eclipse-workspace\\RTOproject\\images\\pic8.png"));
		lblNewLabel.setBounds(0, 0, 1182, 686);
		frame.getContentPane().add(lblNewLabel);
	}

}
