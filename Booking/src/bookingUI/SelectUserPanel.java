package bookingUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Arrays;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class SelectUserPanel extends JPanel
{
	JButton select;
    JButton back;
    JTable table;
  
   //  Database database = new Database();
    
    String[] column = {"User Name", "First Name", "Surname","Cabin","Mobile","E-mail"};
    
    DefaultTableModel model;
    public SelectUserPanel()
    {
        setOpaque(false);
        setLayout(new GridBagLayout());
        model = new DefaultTableModel(column, 0);
        table = new JTable(model)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane sp=new JScrollPane(table);
        sp.setOpaque(false);
        JScrollBar bar = sp.getVerticalScrollBar();
        sp.setPreferredSize(new Dimension(1000, 600)); 
         /* try
        {
            database.resultset = database.statement.executeQuery("select User_ID, First_Name, Surname, Mobile_no, Cabin_no, Email from User;"  );
            Object[] row = new Object[6];
            
            while(database.resultset.next())
            {
                row[0] = String.valueOf(database.resultset.getString("User_ID"));
                row[1] = String.valueOf(database.resultset.getString("First_Name"));
                row[2] = String.valueOf(database.resultset.getString("Surname"));
                row[3] = String.valueOf(database.resultset.getString("Mobile_no"));
                row[4] = String.valueOf(database.resultset.getInt("Cabin_no"));
                row[5] = String.valueOf(database.resultset.getString("Email"));
                model.addRow(row);
            }
                         
        } 
        catch(SQLException er)
        {
             JOptionPane.showMessageDialog(null,
                            "Could not update user list",
                            "Error",
                            JOptionPane.WARNING_MESSAGE);
        } */
	
        JLabel space1 = new JLabel("    ");
        JLabel space2 = new JLabel("    ");
        select = new JButton("Select User");
        back = new JButton("Back");
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(sp, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(space1, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(select, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(space2, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(back, gbc);
    
}
}
