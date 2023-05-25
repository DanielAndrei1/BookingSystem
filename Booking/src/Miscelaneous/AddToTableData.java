package Miscelaneous;

import database.*;
import bookingUI.CustomerExcursion;
import bookingUI.AdminExcursion;

import java.awt.datatransfer.SystemFlavorMap;

import javax.swing.table.DefaultTableModel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.Vector;

public class AddToTableData {
		

	   public String databaseReadExcursion() throws Exception{
	    	 try {
				return Database.databaseReadExcursion();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	return null;
	    }
	    
	   public void createExcursionTable(String CustomerExOrAdminEX, DefaultTableModel model) throws Exception {
		   String inputString = databaseReadExcursion();
	        // Find the starting index of the JSON part
	        int startIndex = inputString.indexOf("{");

	        // Find the ending index of the JSON part
	        int endIndex = inputString.lastIndexOf("}");

	        // Extract the JSON part
	        String jsonString = inputString.substring(startIndex, endIndex + 1);

	        
		   System.out.println(jsonString);
		    Gson gson = new Gson();
	        // Parse the JSON string into a JsonElement
	        JsonElement jsonElement = gson.fromJson(jsonString, JsonElement.class);

	        // Get the "rows" array from the JsonElement
	        JsonArray rowsArray = jsonElement.getAsJsonObject().getAsJsonArray("rows");

	        // Convert the JsonArray to a Java array or list
	        Row[] rows = gson.fromJson(rowsArray, Row[].class);
	        // Convert to list: List<Row> rowsList = gson.fromJson(rowsArray, new TypeToken<List<Row>>() {}.getType());
	    
		    System.out.println(rows);
		    for (Row row : rows) {
		        Vector<Object> rowDataItem = new Vector<>();
		        rowDataItem.add(row.getID());
		        rowDataItem.add(row.getPORT_ID());
		        rowDataItem.add(row.getNAME());

		        if (CustomerExOrAdminEX.equals("CustomerEx")) {
		            model.addRow(rowDataItem);
		        } else if (CustomerExOrAdminEX.equals("AdminEx")) {
		            model.addRow(rowDataItem);
		        }
		    }
		}
	
	
}

       