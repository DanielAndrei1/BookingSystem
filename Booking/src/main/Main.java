package main;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.UIManager.*;
import bookingUI.*;
import database.*;
import encryption.EncryptionUtil;
import image.*;
import buttonEvents.*;
import com.google.gson.Gson;

import Miscelaneous.*;

public class Main extends JFrame
{	
	
    LoginPanel loginPanel = new LoginPanel();
    RegisterPanel registerPanel = new RegisterPanel();
    ImagePanel imagePanel = new ImagePanel();
    CustomerPanel customerPanel = new CustomerPanel();
    AdminPanel adminPanel = new AdminPanel();
    SelectUserPanel selectUserPanel = new SelectUserPanel();
    AdminExcursion adminExcursion = new AdminExcursion();
    CustomerExcursion customerExcursion = new CustomerExcursion();
    Database database;

    int width = 800;
    int height = 600;
	static Main frame;
    public Main()
    {   
        setSize(width, height);
        setLayout(new BorderLayout());
        setVisibility();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(true);
        setTitle("Booking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        	

    }
    
  
    
    public void setVisibility()
    {
        add(imagePanel, BorderLayout.CENTER);
        imagePanel.add(registerPanel);
        imagePanel.add(loginPanel);
        imagePanel.add(customerPanel);
        imagePanel.add(adminPanel);
        imagePanel.add(selectUserPanel);
        imagePanel.add(adminExcursion);
        imagePanel.add(customerExcursion);
        customerPanel.setVisible(false);
        adminPanel.setVisible(false);
        registerPanel.setVisible(false);
        selectUserPanel.setVisible(false);
        adminExcursion.setVisible(false);
        customerExcursion.setVisible(false);
        validate();
    }

   
/*
    
         adminPanel.addBooking.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  try{

                        String sqltest ="select Booking_ID from Booking where ID="+adminPanel.exid.getText()+" and User_ID ='"+adminPanel.user.getText()+"'";
                        database.resultset = database.statement.executeQuery(sqltest);

                        if(database.resultset.next()){
                            JOptionPane.showMessageDialog(getContentPane(),
                                "Duplicate entry",
                                "Error",
                                JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                            String sql9 ="select Tickets from Booking where ID ="+adminPanel.exid.getText();
                            database.resultset = database.statement.executeQuery(sql9);
                            total = 0;
                            while(database.resultset.next())
                            {
                                total = total + database.resultset.getInt("Tickets");

                            }
                            if((total+Integer.parseInt(adminPanel.tickets.getText()))<=32){
                                String sql10 = "INSERT INTO Booking (User_ID,ID,Tickets,Confirmation)VALUES('"
                                    +adminPanel.user.getText()+"',"
                                    +adminPanel.exid.getText()+","
                                    +adminPanel.tickets.getText()+",1);";

                                database.statement.executeUpdate(sql10);
                            }
                            else
                            {
                                String sql100 = "INSERT INTO Booking (User_ID,ID,Tickets,Confirmation)VALUES('"
                                    +adminPanel.user.getText()+"',"
                                    +adminPanel.exid.getText()+","
                                    +adminPanel.tickets.getText()+",0);";

                                database.statement.executeUpdate(sql100);
                            }
                            adminPanel.model.setRowCount(0);

                            database.resultset = database.statement.executeQuery("select Booking_ID, User_ID, ID , Confirmation, Tickets from Booking;"  );
                            Object[] row = new Object[5];

                            while(database.resultset.next())
                            {
                                row[0] = String.valueOf(database.resultset.getInt("Booking_ID"));
                                row[1] = String.valueOf(database.resultset.getString("User_ID"));
                                row[2] = String.valueOf(database.resultset.getInt("ID"));
                                row[4] = String.valueOf(database.resultset.getInt("Tickets"));
                                if(database.resultset.getInt("Confirmation")==1){
                                    row[3] = "Confirmed";
                                }
                                else
                                {
                                    row[3] = "Waitlist";
                                }

                                adminPanel.model.addRow(row);
                            }

                        }
                        adminPanel.model.setRowCount(0);
                        database.resultset = database.statement.executeQuery("select Booking_ID, User_ID, ID , Confirmation, Tickets from Booking;"  );
                        Object[] row = new Object[5];

                        while(database.resultset.next())
                        {
                            row[0] = String.valueOf(database.resultset.getInt("Booking_ID"));
                            row[1] = String.valueOf(database.resultset.getString("User_ID"));
                            row[2] = String.valueOf(database.resultset.getInt("ID"));
                            row[3] = String.valueOf(database.resultset.getInt("Tickets"));
                            if(database.resultset.getInt("Confirmation")==1){
                                row[4] = "Confirmed";
                            }
                            else
                            {
                                row[4] = "Waitlist";
                            }

                            // fill the row
                            adminPanel.model.addRow(row);
                        }
                    } 
                    catch(SQLException er)
                    {
                        JOptionPane.showMessageDialog(getContentPane(),
                            "Incorrect Values",
                            "Error",
                            JOptionPane.WARNING_MESSAGE);
                    }

                }
            });

         
        customerPanel.addBooking.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                 try{

                        String sqltest1 ="select Booking_ID from Booking where ID="+customerPanel.exid.getText()+" and User_ID ='"+ loginPanel.userName.getText() + "'";
                        database.resultset = database.statement.executeQuery(sqltest1);

                        if(database.resultset.next()){
                            JOptionPane.showMessageDialog(getContentPane(),
                                "Duplicate entry",
                                "Error",
                                JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                            String sql9 ="select Tickets from Booking where ID =" + customerPanel.exid.getText();
                            database.resultset = database.statement.executeQuery(sql9);
                            total = 0;
                            while(database.resultset.next())
                            {
                                total = total + database.resultset.getInt("Tickets");

                            }
                            if((total+Integer.parseInt(customerPanel.tickets.getText()))<=32){
                                String sql1010 = "INSERT INTO Booking (User_ID,ID,Tickets,Confirmation)VALUES('"
                                    +loginPanel.userName.getText()+"',"
                                    +customerPanel.exid.getText()+","
                                    +customerPanel.tickets.getText()+",1);";

                                database.statement.executeUpdate(sql1010);
                            }
                            else
                            {
                                String sql1001 = "INSERT INTO Booking (User_ID,ID,Tickets,Confirmation)VALUES('"
                                    +loginPanel.userName.getText()+"',"
                                    +customerPanel.exid.getText()+","
                                    +customerPanel.tickets.getText()+",0);";

                                database.statement.executeUpdate(sql1001);
                            }

                            String sql101 = "select Booking_ID, ID, Tickets, Confirmation from Booking where User_ID =" + loginPanel.userName.getText();
                            database.resultset = database.statement.executeQuery(sql101);
                            customerPanel.model.setRowCount(0);
                            Object[] row = new Object[4];

                            while(database.resultset.next())
                            {
                                row[0] = String.valueOf(database.resultset.getInt("Booking_ID"));
                                row[1] = String.valueOf(database.resultset.getInt("ID"));
                                row[2] = String.valueOf(database.resultset.getInt("Tickets"));
                                if(database.resultset.getInt("Confirmation")==1){
                                    row[3] = "Confirmed";
                                }
                                else
                                {
                                    row[3] = "Waitlist";
                                }
                                customerPanel.model.addRow(row);
                            }
                        }

                    } 
                    catch(SQLException er)
                    {
                        er.printStackTrace();
                        JOptionPane.showMessageDialog(getContentPane(),
                            "Incorrect Values",
                            "Error",
                            JOptionPane.WARNING_MESSAGE);
                    }
                }

            });  

        adminPanel.deleteBooking.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try
                    {
                        int p = adminPanel.table.getSelectedRow();
                        String sqq = "select ID from Booking where Booking_ID = "+adminPanel.model.getValueAt(p,0).toString();
                        System.out.println(sqq);

                        database.resultset = database.statement.executeQuery(sqq);
                        if(database.resultset.next()){
                            ee =  String.valueOf(database.resultset.getInt("ID"));
                        }
                        String sql11 = "delete from Booking where Booking_ID = "+adminPanel.model.getValueAt(p,0).toString();
                        database.statement.executeUpdate(sql11);

                        boolean c = true;
                        while(c)
                        {
                            String sql11331 = ("SELECT SUM(Tickets) FROM Booking WHERE Confirmation = 1 and ID = "+ee);
                            database.resultset = database.statement.executeQuery(sql11331);
                            while(database.resultset.next()){
                                hello = database.resultset.getInt("SUM(Tickets)");
                            }
                            hello = 32 - hello;
                            String sql11332 = ("select Tickets, Booking_ID from Booking where ID= "+ee+" and Confirmation = 0 and Tickets <= "+hello);
                            database.resultset = database.statement.executeQuery(sql11332);
                            if(database.resultset.next())
                            { 
                                String sql1121 = "UPDATE Booking SET  Confirmation = 1 WHERE Booking_ID = "+String.valueOf(database.resultset.getString("Booking_ID"));
                                database.statement.executeUpdate(sql1121);
                            }
                            else
                            {
                                c = false;
                            }

                        }

                        adminPanel.model.setRowCount(0);
                        database.resultset = database.statement.executeQuery("select Booking_ID, User_ID, ID , Confirmation, Tickets from Booking;"  );
                        Object[] row = new Object[5];

                        while(database.resultset.next())
                        {
                            row[0] = String.valueOf(database.resultset.getInt("Booking_ID"));
                            row[1] = String.valueOf(database.resultset.getString("User_ID"));
                            row[2] = String.valueOf(database.resultset.getInt("ID"));
                            if(database.resultset.getInt("Confirmation")==1){
                                row[4] = "Confirmed";
                            }
                            else
                            {
                                row[4] = "Waitlist";
                            }
                            row[3] = String.valueOf(database.resultset.getInt("Tickets"));
                            // fill the row
                            adminPanel.model.addRow(row);
                        }
                    }
                    catch(SQLException er)
                    {
                        er.printStackTrace();
                        JOptionPane.showMessageDialog(getContentPane(),
                            "Unable to delete",
                            "Error",
                            JOptionPane.WARNING_MESSAGE);
                    }
                }

            });

        customerPanel.deleteBooking.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try
                    {
                        int p = customerPanel.table.getSelectedRow();
                        String sqq = "select ID from Booking where Booking_ID = "+customerPanel.model.getValueAt(p,0).toString();
                        System.out.println(sqq);

                        database.resultset = database.statement.executeQuery(sqq);
                        if(database.resultset.next()){
                            ee =  String.valueOf(database.resultset.getInt("ID"));
                        }
                        String sql1122 = "delete from Booking where Booking_ID = "+customerPanel.model.getValueAt(p,0).toString();
                        database.statement.executeUpdate(sql1122);

                        boolean c = true;
                        while(c)
                        {
                            String sql11331 = ("SELECT SUM(Tickets) FROM Booking WHERE Confirmation = 1 and ID = "+ee);
                            database.resultset = database.statement.executeQuery(sql11331);
                            while(database.resultset.next()){
                                hello = database.resultset.getInt("SUM(Tickets)");
                            }
                            hello = 32 - hello;
                            String sql11332 = ("select Tickets, Booking_ID from Booking where ID= "+ee+" and Confirmation = 0 and Tickets <= "+hello);
                            database.resultset = database.statement.executeQuery(sql11332);
                            if(database.resultset.next())
                            { 
                                String sql1121 = "UPDATE Booking SET  Confirmation = 1 WHERE Booking_ID = "+String.valueOf(database.resultset.getString("Booking_ID"));
                                database.statement.executeUpdate(sql1121);
                            }
                            else
                            {
                                c = false;
                            }

                        }

                        String sql101 = "select Booking_ID, ID, Tickets, Confirmation from Booking where User_ID =" + loginPanel.userName.getText();
                        database.resultset = database.statement.executeQuery(sql101);
                        customerPanel.model.setRowCount(0);
                        Object[] row = new Object[4];

                        while(database.resultset.next())
                        {
                            row[0] = String.valueOf(database.resultset.getInt("Booking_ID"));
                            row[1] = String.valueOf(database.resultset.getInt("ID"));
                            row[2] = String.valueOf(database.resultset.getInt("Tickets"));
                            if(database.resultset.getInt("Confirmation")==1){
                                row[3] = "Confirmed";
                            }
                            else
                            {
                                row[3] = "Waitlist";
                            }
                            customerPanel.model.addRow(row);
                        }
                    }
                    catch(SQLException er)
                    {
                        JOptionPane.showMessageDialog(getContentPane(),
                            "Unable to delete",
                            "Error",
                            JOptionPane.WARNING_MESSAGE);
                    }
                }

            });

        adminPanel.selectUser.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectUserPanel.setVisible(true);
                    adminPanel.setVisible(false);
                }

            });

        adminPanel.selectExid.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    adminExcursion.setVisible(true);
                    adminPanel.setVisible(false);
                }

            });

        customerPanel.selectExid.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    customerExcursion.setVisible(true);
                    customerPanel.setVisible(false);
                }

            });

        selectUserPanel.back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectUserPanel.setVisible(false);
                    adminPanel.setVisible(true);
                }

            });

        selectUserPanel.select.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int p = selectUserPanel.table.getSelectedRow();
                    adminPanel.user.setText(selectUserPanel.model.getValueAt(p,0).toString());
                    selectUserPanel.setVisible(false);
                    adminPanel.setVisible(true);
                }

            });

        adminExcursion.back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    adminExcursion.setVisible(false);
                    adminPanel.setVisible(true);
                }

            });

        customerExcursion.back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    customerExcursion.setVisible(false);
                    customerPanel.setVisible(true);
                }

            });

        adminExcursion.select.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int p = adminExcursion.table.getSelectedRow();
                    adminPanel.exid.setText(adminExcursion.model.getValueAt(p,0).toString());
                    adminExcursion.setVisible(false);
                    adminPanel.setVisible(true);
                }

            });

        customerExcursion.select.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int p = customerExcursion.table.getSelectedRow();
                    customerPanel.exid.setText(customerExcursion.model.getValueAt(p,0).toString());
                    customerExcursion.setVisible(false);
                    customerPanel.setVisible(true);
                }

            });

    }
    
    */
    

    public static void main(String[] args)
    {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        
      Main.frame = new Main();
      frame.database = new Database();
      ButtonActionListeners buttonActionListeners = new ButtonActionListeners(frame.loginPanel, frame.registerPanel, frame.customerPanel, frame.customerExcursion, frame.adminPanel ,frame.adminExcursion ,  Main.frame);
      // Attach button action listeners
      frame.loginPanel.getRegister().addActionListener(buttonActionListeners);
      frame.loginPanel.getLogin().addActionListener(buttonActionListeners);
      frame.registerPanel.getRegister().addActionListener(buttonActionListeners);
      frame.registerPanel.getBack().addActionListener(buttonActionListeners);
      frame.customerPanel.getAddBooking().addActionListener(buttonActionListeners);
      frame.customerPanel.getSelectExid().addActionListener(buttonActionListeners);
      frame.customerPanel.getExit().addActionListener(buttonActionListeners);
      frame.customerExcursion.getBack().addActionListener(buttonActionListeners);
      
     /* String ro = EncryptionUtil.encrypt("infinitystudiogames/booking/read.php").getInitializationVector()+ EncryptionUtil.encrypt("http://infinitystudiogames/booking/read.php").getEncryptedValue();
      System.out.println(ro);
      String iv = "XdSbm1UpBE21iRiv+JMYlA==";
      String encryptedValue = "fglkaN+KqjlWLTgw+qJ66sGEh/I84KHiC03re8Q5vLn4KJmYHPtqL3sXEABoiWRz";
      String combinedData = iv + encryptedValue;
      String key = "Jar12345Jar12345";

      String decryptedValue = EncryptionUtil.decrypt(combinedData, key);

      System.out.println(decryptedValue); */

      //Admin
      frame.adminPanel.getSelectExid().addActionListener(buttonActionListeners);
      frame.adminExcursion.getBack().addActionListener(buttonActionListeners);
     

    }
 
}
  
