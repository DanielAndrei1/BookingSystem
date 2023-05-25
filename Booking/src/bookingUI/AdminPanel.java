package bookingUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Arrays;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class AdminPanel extends JPanel
{
   // Database database = new Database();
    JTextField user;
    JTextField exid;
    JTextField tickets;
    JTextField status;
    JButton exit;
   
	JButton addBooking;
    JButton deleteBooking;
    JButton selectUser;
    JButton selectExid;
    JTable table;
    DefaultTableModel model;
    String[] column = {"BookingID","UserId","Excursion ID","Tickets","Confirmation"}; 
    
    public JButton getExit() {
		return exit;
	}
	public JButton getAddBooking() {
		return addBooking;
	}
	public JButton getDeleteBooking() {
		return deleteBooking;
	}
	public JButton getSelectUser() {
		return selectUser;
	}
	public JButton getSelectExid() {
		return selectExid;
	}
    
    public AdminPanel()
    {
        setOpaque(false);
        setLayout(new GridBagLayout());
        JLabel userLabel = new JLabel("User ID:");
        userLabel.setForeground(Color.WHITE);
        JLabel exidLabel = new JLabel("Excursion ID:");
        exidLabel.setForeground(Color.WHITE);
        JLabel ticketsLabel = new JLabel("Tickets:");
        ticketsLabel.setForeground(Color.WHITE);
        JLabel statusLabel = new JLabel("Confirmation:");
        statusLabel.setForeground(Color.WHITE);
        JLabel space = new JLabel("    ");
        space.setForeground(Color.WHITE);
        
        user = new JTextField(15);
        exid = new JTextField(15);
        tickets = new JTextField(15);
        
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

        /*try
        {
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
                
                model.addRow(row);
            }
                         
        } 
        catch(SQLException er)
        {
            er.printStackTrace();
        }
        table.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e){
                int p = table.getSelectedRow();
                
                user.setText(model.getValueAt(p,1).toString());
                exid.setText(model.getValueAt(p,2).toString());
                tickets.setText(model.getValueAt(p,3).toString());
               
            }
        });
        */
        selectUser = new JButton("User List");
        selectExid = new JButton("Excursion List");
        exit = new JButton("Logout");
        addBooking = new JButton("Add");
        deleteBooking = new JButton("Delete");
                            
        GridBagConstraints gbc = new GridBagConstraints();

        
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(sp, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(user, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(userLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(selectUser, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(exid, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(exidLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        add(selectExid, gbc);
        
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        add(tickets, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        add(ticketsLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        add(addBooking, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        add(deleteBooking, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(space, gbc);
        
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.CENTER;
        add(exit, gbc);
    }
}

        