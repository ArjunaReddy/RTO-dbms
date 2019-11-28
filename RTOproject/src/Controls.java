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
		lblWelcomeAdmin.setForeground(new Color(255, 255, 0));
		lblWelcomeAdmin.setFont(new Font("Bodoni MT Black", Font.BOLD, 34));
		lblWelcomeAdmin.setBounds(430, 41, 333, 62);
		frame.getContentPane().add(lblWelcomeAdmin);

		JButton btnUsers = new JButton("Users");
		btnUsers.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnUsers.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				frame.setVisible(false);
				Users usr=new Users();
				usr.frame.setVisible(true);
			}
		});
		btnUsers.setBounds(497, 207, 176, 44);
		frame.getContentPane().add(btnUsers);

		JButton btnRegistrations = new JButton("Registrations");
		btnRegistrations.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnRegistrations.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				Registrations usr=new Registrations();
				usr.frame.setVisible(true);
			}
		});
		btnRegistrations.setBounds(497, 321, 176, 44);
		frame.getContentPane().add(btnRegistrations);

		JButton btnTransfers = new JButton("Transfers");
		btnTransfers.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnTransfers.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				frame.setVisible(false);
				Transfer usr=new Transfer();
				usr.frame.setVisible(true);
			}
		});
		btnTransfers.setBounds(497, 438, 176, 44);
		frame.getContentPane().add(btnTransfers);

		JButton btnPrev = new JButton("prev");
		btnPrev.setBackground(new Color(255, 255, 102));
		btnPrev.setForeground(new Color(0, 0, 0));
		btnPrev.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnPrev.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{	
				frame.setVisible(false);
				Admin_Login al=new Admin_Login();
				al.frame.setVisible(true);
			}
		});
		btnPrev.setBounds(0, 642, 102, 44);
		frame.getContentPane().add(btnPrev);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LC\\eclipse-workspace\\RTOproject\\images\\pic8alter - Copy.png"));
		lblNewLabel.setBounds(0, 0, 1182, 686);
		frame.getContentPane().add(lblNewLabel);
	}
}
