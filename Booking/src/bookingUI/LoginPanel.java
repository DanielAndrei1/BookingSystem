package bookingUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class LoginPanel extends JPanel
{
    protected JTextField userName = new JTextField(20);;
    protected JPasswordField password = new JPasswordField(20);;
	protected JButton login  = new JButton("Login");;
    protected JButton register = new JButton("Register");;
    JLabel space;
    

	public LoginPanel()
    {
        setOpaque(false);
        setLayout(new GridBagLayout());
        setSize(300, 300);
        JLabel userNameLabel = new JLabel("User name");
        userNameLabel.setForeground(Color.WHITE);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.WHITE);
        space = new JLabel("    ");
        
        space.setForeground(Color.WHITE);
        
        
       
        GridBagConstraints gbc = new GridBagConstraints();
        
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(userNameLabel, gbc);
        
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(userName, gbc);
        
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(passwordLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(password, gbc);
        
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(login, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(register, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(space, gbc);
        
    }
	
	
    public JTextField getUserName() {
		return userName;
	}



	public JPasswordField getPassword() {
		return password;
	}



	public JButton getLogin() {
		return login;
	}



	public JButton getRegister() {
		return register;
	}



}
        
        
        
        
        