package StoreManagementSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JToolBar;

/**
 * Launches a GUI for entering a username and password, with
 * password validation taking place within the Staff class.
 * @author Conor Clarke
 */
public class Login extends JFrame {
	@SuppressWarnings("javadoc")
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JLabel lblNewLabel;
	private JPasswordField passwordField;
	private boolean login;
	private String usernameText = new String();
	private final Action action = new SwingAction();

	/**
	 * Launches the window for the login screen
	 */
	public void run() {
		try {
			Login frame = new Login();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Constructor for setting up the login screen with text fields 
	 * for the username and password and a button
	 */
	public Login() {
		Staff employee = new Staff(23,"hres",2);
		
		//Setup code for the JFrame and Panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Setup code for the username text field
		username = new JTextField();
		username.setBounds(162, 84, 86, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		//Label for the username
		JLabel Username = new JLabel("Username");
		Username.setBounds(162, 59, 86, 14);
		contentPane.add(Username);
		
		//Setup code for the password field
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 140, 86, 20);
		contentPane.add(passwordField);
		
		//Label for the password
		lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(162, 115, 86, 14);
		contentPane.add(lblNewLabel);
		
		//Login button and event handler
		JButton btnNewButton = new JButton();
		btnNewButton.setAction(action);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usernameText = username.getText();
				char [] validate = passwordField.getPassword();
				login = employee.passwordValidation(validate);
			}
		});
		
		//Add the login button to the panel
		btnNewButton.setBounds(162, 205, 89, 23);
		contentPane.add(btnNewButton);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Login");
			putValue(SHORT_DESCRIPTION, "Log in to the system");
		}
		public void actionPerformed(ActionEvent e) {
			if(login){
				JOptionPane.showMessageDialog(null,"Login successful");
				setVisible(false);
				dispose();
				MainDisplay display = new MainDisplay();
				//Access level
				display.run();
			}
			else
				JOptionPane.showMessageDialog(null,"Invalid username or password!");
		}
	}
}
