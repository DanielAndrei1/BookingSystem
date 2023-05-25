package bookingUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RegisterPanel extends JPanel
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField userName;
    protected JTextField firstName;
    protected JTextField surname;
    protected JTextField cabin;
    protected JTextField mobile;
    protected JTextField email;
    protected JPasswordField password;
    protected JButton register;
    protected JButton back;
    JLabel space;
    
    
    public JTextField getUserName() {
		return userName;
	}


	public JTextField getFirstName() {
		return firstName;
	}


	public JTextField getSurname() {
		return surname;
	}


	public JTextField getCabin() {
		return cabin;
	}


	public JTextField getMobile() {
		return mobile;
	}


	public JTextField getEmail() {
		return email;
	}


	public JPasswordField getPassword() {
		return password;
	}


	public JButton getRegister() {
		return register;
	}

	public JButton getBack() {
		return back;
	}
	public RegisterPanel()
    {
        setOpaque(false);
        setLayout(new GridBagLayout());
        JLabel userNameLabel = new JLabel("User name");
        userNameLabel.setForeground(Color.WHITE);
        JLabel firstNameLabel = new JLabel("First name");
        firstNameLabel.setForeground(Color.WHITE);
        JLabel surnameLabel = new JLabel("Surname");
        surnameLabel.setForeground(Color.WHITE);
        JLabel cabinLabel = new JLabel("Cabin no.");
        cabinLabel.setForeground(Color.WHITE);
        JLabel mobileLabel = new JLabel("mobile");
        mobileLabel.setForeground(Color.WHITE);
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setForeground(Color.WHITE);
        JLabel passwordLabel = new JLabel("password");
        passwordLabel.setForeground(Color.WHITE);
        space = new JLabel("    ");
        space.setForeground(Color.WHITE);
        
        userName = new JTextField(20);
        firstName = new JTextField(20);

        surname = new JTextField(20);
        cabin = new JTextField(20);
        mobile = new JTextField(20);
        email = new JTextField(20);
        password = new JPasswordField(20);
        register = new JButton("Register");
        back = new JButton("Back");
        
        GridBagConstraints gbc = new GridBagConstraints();
        
       
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(userNameLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(userName, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(firstNameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(firstName, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(surnameLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(surname, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(cabinLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(cabin, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        add(mobileLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        add(mobile, gbc);
        
        gbc.gridx = 0;
        gbc.gridy =10;
        add(emailLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 11;
        add(email, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 12;
        add(passwordLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 13;
        add(password, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 14;
        add(register, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 15;
        add(back, gbc);
         
        gbc.gridx = 0;
        gbc.gridy = 16;
        add(space, gbc);
    }
}