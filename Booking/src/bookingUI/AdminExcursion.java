package bookingUI;
import java.awt.*;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Miscelaneous.AddToTableData;


public class AdminExcursion extends JPanel
{	
   // Database database = new Database();
    String[] column = {"Excursion ID", "Port ID", "Excursion Description"};
    JButton select;
    JButton back;
    JTable table;
    DefaultTableModel model;
    public JButton getSelect() {
		return select;
	}

	public JButton getBack() {
		return back;
	}

	public JTable getTable() {
		return table;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public AdminExcursion()
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
            database.resultset = database.statement.executeQuery("select ID,PORT_ID, NAME from Excursion;"  );
            Object[] row = new Object[3];
            
            while(database.resultset.next())
            {
                row[0] = String.valueOf(database.resultset.getInt("ID"));
                row[1] = String.valueOf(database.resultset.getString("PORT_ID"));
                row[2] = String.valueOf(database.resultset.getString("NAME"));
                model.addRow(row);
            }
                         
        } 
        catch(SQLException er)
        {
            er.printStackTrace(); 
            JOptionPane.showMessageDialog(null,
                            "Could not update excursion list",
                            "Error",
                            JOptionPane.WARNING_MESSAGE);
        } */
        JLabel space1 = new JLabel("    ");
        JLabel space2 = new JLabel("    ");
        select = new JButton("Select Excursion");
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
    
    public void tableCreate() {
    	
    	
    }
}
