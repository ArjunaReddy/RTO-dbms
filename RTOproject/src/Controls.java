import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

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
		frame.setBounds(100, 100, 1200, 733);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblWelcomeAdmin = new JLabel("Welcome Admin");
		lblWelcomeAdmin.setForeground(Color.WHITE);
		lblWelcomeAdmin.setFont(new Font("Bodoni MT Black", Font.BOLD, 34));
		lblWelcomeAdmin.setBounds(430, 41, 333, 62);
		frame.getContentPane().add(lblWelcomeAdmin);

		JButton btnUsers = new JButton("Users");
		btnUsers.setFont(new Font("Sylfaen", Font.BOLD, 22));
		btnUsers.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				Users usr=new Users();
				usr.frame.setVisible(true);
			}
		});
		btnUsers.setBounds(497, 207, 176, 44);
		frame.getContentPane().add(btnUsers);

		JButton btnRegistrations = new JButton("Registrations");
		btnRegistrations.setFont(new Font("Sylfaen", Font.BOLD, 22));
		btnRegistrations.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Registrations usr=new Registrations();
				usr.frame.setVisible(true);
			}
		});
		btnRegistrations.setBounds(497, 321, 176, 44);
		frame.getContentPane().add(btnRegistrations);

		JButton btnTransfers = new JButton("Transfers");
		btnTransfers.setFont(new Font("Sylfaen", Font.BOLD, 22));
		btnTransfers.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				Transfer usr=new Transfer();
				usr.frame.setVisible(true);
			}
		});
		btnTransfers.setBounds(497, 438, 176, 44);
		frame.getContentPane().add(btnTransfers);

		JButton btnPrev = new JButton("prev");
		btnPrev.setFont(new Font("Sylfaen", Font.BOLD, 22));
		btnPrev.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
			}
		});
		btnPrev.setBounds(0, 642, 102, 44);
		frame.getContentPane().add(btnPrev);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LC\\eclipse-workspace\\RTOproject\\images\\pic8alter.png"));
		lblNewLabel.setBounds(0, 0, 1182, 686);
		frame.getContentPane().add(lblNewLabel);
	}
}
