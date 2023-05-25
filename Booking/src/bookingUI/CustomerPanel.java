package bookingUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Arrays;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class CustomerPanel extends JPanel
{
    private LoginPanel  loginPanel = new  LoginPanel();
    private JTextField user;
    private JTextField exid;
    private JTextField tickets;
    private JTextField status;
    private JButton exit;
    private JButton addBooking;
    private JButton deleteBooking;
    private JButton selectExid;
    public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	public JTextField getUser() {
		return user;
	}

	public JTextField getExid() {
		return exid;
	}

	public JTextField getTickets() {
		return tickets;
	}

	public JTextField getStatus() {
		return status;
	}

	public JButton getExit() {
		return exit;
	}

	public JButton getAddBooking() {
		return addBooking;
	}

	public JButton getDeleteBooking() {
		return deleteBooking;
	}

	public JButton getSelectExid() {
		return selectExid;
	}

	public JTable getTable() {
		return table;
	}

	JTable table;
    DefaultTableModel model;
    
    public DefaultTableModel getModel() {
		return model;
	}

	String[] column = {"BookingID","Excursion ID","Tickets","Confirmation"}; 

    public CustomerPanel()
    {
        setOpaque(false);
        setLayout(new GridBagLayout());
        JLabel exidLabel = new JLabel("Excursion ID:");
        exidLabel.setForeground(Color.WHITE);
        JLabel ticketsLabel = new JLabel("Tickets:");
        ticketsLabel.setForeground(Color.WHITE);
        JLabel statusLabel = new JLabel("Confirmation:");
        statusLabel.setForeground(Color.WHITE);
        JLabel space = new JLabel("    ");
        space.setForeground(Color.WHITE);
        
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

        
        
        table.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e){
                int p = table.getSelectedRow();
                exid.setText(model.getValueAt(p, 1).toString());
                tickets.setText(model.getValueAt(p,2).toString());
               
            }
        });
        
        selectExid = new JButton("Excursion List");
        exit = new JButton("Logout");
        addBooking = new JButton("Add");
        deleteBooking = new JButton("Delete");
                            
        GridBagConstraints gbc = new GridBagConstraints();

        
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(sp, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(exid, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(selectExid, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(exidLabel, gbc);
        
        
        
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

        