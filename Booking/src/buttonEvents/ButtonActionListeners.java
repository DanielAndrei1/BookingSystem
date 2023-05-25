package buttonEvents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import bookingUI.LoginPanel;
import bookingUI.RegisterPanel;
import bookingUI.SelectUserPanel;
import database.BackgroundWorker;
import database.Database;
import image.ImagePanel;
import main.Main;
import bookingUI.AdminExcursion;
import bookingUI.AdminPanel;
import bookingUI.CustomerExcursion;
import bookingUI.CustomerPanel;
import com.google.gson.*;
import Miscelaneous.*;

public class ButtonActionListeners implements ActionListener {
	private LoginPanel loginPanel;
	private RegisterPanel registerPanel;
	private CustomerPanel customerPanel;
	private CustomerExcursion customerExcursion;
	private Main main;
	ImagePanel imagePanel = new ImagePanel();
	AdminPanel adminPanel;
	SelectUserPanel selectUserPanel = new SelectUserPanel();
	AdminExcursion adminExcursion;
	Database database = new Database();
    private BackgroundWorker backgroundWorker = new BackgroundWorker(database);

    
	String user;
    String pass;
    String fN;
    String sN;
    String cabin;
    String mobile;
    String email;
    String userPass;
    int admin;
    String book;
    String confirm;
    String tickets;
    int total =0;
    int rowCount = 0;
    String ee;
    int hello;
    
    
    public ButtonActionListeners(LoginPanel loginPanel, RegisterPanel registerPanel, CustomerPanel customerPanel, CustomerExcursion customerExcursion,AdminPanel adminPanel, AdminExcursion adminExcursion ,Main main ) {
        this.loginPanel = loginPanel;
        this.registerPanel = registerPanel;
        this.customerPanel = customerPanel;
        this.customerExcursion = customerExcursion;
        this.adminPanel = adminPanel;
        this.adminExcursion = adminExcursion;
        this.main = main;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginPanel.getRegister()) {
        	registerPanel.setVisible(true);
            loginPanel.setVisible(false);
     
        }else if (e.getSource() == loginPanel.getLogin()) {
            // Handle login button click
        	//-------------------------
        	//--------------------------
              user = loginPanel.getUserName().getText().toLowerCase();
              pass = new String(loginPanel.getPassword().getPassword());
              if(user.equals("nimbus") && pass.equals("123456789"))
              {
            	  adminPanel.setVisible(true);
                  loginPanel.setVisible(false);
                  if(admin==1)
                  {
                      
                     

                  }
              }else {
           // Validate user input against the allowed characters pattern
              if (!user.matches("[^@=\\/\\+]+") || !pass.matches("[^@=\\/\\+]+")) {
                  JOptionPane.showMessageDialog(null,
                          "Invalid characters in username or password",
                          "Error",
                          JOptionPane.WARNING_MESSAGE);
                  return;
              }
              
              if(!user.isBlank() || !user.isEmpty() || !pass.isBlank() || !pass.isEmpty()) {
              backgroundWorker.doInBackground("Read",user,pass);
             
              if(database.getStatusCode() == 200) {
            	  customerPanel.setVisible(true);
                  loginPanel.setVisible(false);
                  main.setSize(1100, 870);
                  main.setLocationRelativeTo(null);

                   
              }else if(database.getStatusCode() == 429) {
            	  JOptionPane.showMessageDialog(null,
                          "Too many requests. Please try again later.",
                          "Warning",
                          JOptionPane.WARNING_MESSAGE);
              }else if(database.getStatusCode() == 403) {
            	  JOptionPane.showMessageDialog(null,
                          "You have been banned for making too many requests.",
                          "Ban",
                          JOptionPane.ERROR_MESSAGE);
              }
              }else {
            	  JOptionPane.showMessageDialog(null,
                          "No Username or password, please add",
                          "Error",
                          JOptionPane.WARNING_MESSAGE);
              }
        
              
              }
        
        }else if (e.getSource() == registerPanel.getRegister())
        {
        ////Register:
        	user = registerPanel.getUserName().getText().toLowerCase();
            String pass= new String(registerPanel.getPassword().getPassword());
            fN = registerPanel.getFirstName().getText();
            sN = registerPanel.getSurname().getText();
            cabin = registerPanel.getCabin().getText();
            mobile = registerPanel.getMobile().getText();
            email = registerPanel.getEmail().getText().trim();
            
         // Validate user input against the allowed characters pattern
            if (!user.matches("[^=\\/\\+]+") || !pass.matches("[^=\\/\\+]+")) {
                JOptionPane.showMessageDialog(null,
                        "Invalid characters in username or password",
                        "Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if(!user.isBlank() || !user.isEmpty() || !pass.isBlank() || !pass.isEmpty()) {
            backgroundWorker.doInBackground("Insert", user,pass,fN,sN,mobile, email,cabin, "0" );
            registerPanel.setVisible(false);
            loginPanel.setVisible(true);
            }
            else {
            	JOptionPane.showMessageDialog(null,
                    "Please complete the missing information",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
           
            
           }
           
        }
        else if (e.getSource() == registerPanel.getBack()) {
            registerPanel.setVisible(false);
            loginPanel.setVisible(true);
        }else if (e.getSource() == customerPanel.getExit()) {
        	customerPanel.setVisible(false);
            loginPanel.setVisible(true);
        }else if (e.getSource() == customerPanel.getSelectExid()) {
        	customerExcursion.setVisible(true);
            customerPanel.setVisible(false);
            AddToTableData addToTableData = new AddToTableData();
            try {
    			addToTableData.createExcursionTable("CustomerEx", customerExcursion.getModel());
    		} catch (Exception e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
        	
        }else if (e.getSource() == customerExcursion.getBack()) {
           customerPanel.setVisible(true);
     	   customerExcursion.setVisible(false);
     	   
    	
        }else if (e.getSource() == adminPanel.getSelectExid()) {
        	main.setSize(1300, 1000);
       	   	main.setLocationRelativeTo(null);
        	adminExcursion.setVisible(true);
        	adminPanel.setVisible(false);
      	   
      	 AddToTableData addToTableData = new AddToTableData();
         try {
 			addToTableData.createExcursionTable("AdminEx", adminExcursion.getModel());
 		} catch (Exception e1) {
 			// TODO Auto-generated catch block
 			e1.printStackTrace();
 		}
      	  
        }else if(e.getSource() == adminExcursion.getBack()) {
        	adminPanel.setVisible(true);
        	adminExcursion.setVisible(false);
        	
        } 
      	
    }
   
    
    public void AdminPanelActions(){
    	
    }
 
   
}
    