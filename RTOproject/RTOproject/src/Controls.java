import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Controls
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
					Controls window = new Controls();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Controls()
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
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome Admin");
		lblWelcomeAdmin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcomeAdmin.setBounds(136, 11, 224, 28);
		frame.getContentPane().add(lblWelcomeAdmin);
		
		JButton btnUsers = new JButton("Users");
		btnUsers.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				Users usr=new Users();
				usr.frame.setVisible(true);
			}
		});
		btnUsers.setBounds(167, 106, 112, 23);
		frame.getContentPane().add(btnUsers);
		
		JButton btnRegistrations = new JButton("Registrations");
		btnRegistrations.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Registrations usr=new Registrations();
				usr.frame.setVisible(true);
			}
		});
		btnRegistrations.setBounds(167, 151, 112, 23);
		frame.getContentPane().add(btnRegistrations);
		
		JButton btnTransfers = new JButton("Transfers");
		btnTransfers.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				Transfer usr=new Transfer();
				usr.frame.setVisible(true);
			}
		});
		btnTransfers.setBounds(167, 195, 112, 23);
		frame.getContentPane().add(btnTransfers);
		
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
