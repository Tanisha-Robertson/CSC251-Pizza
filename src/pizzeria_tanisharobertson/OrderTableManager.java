/**
 * Takes Pizza order and saves to database
 * 11 Dec 2017
 * CSC 251 Project 2 -Pizzeria
 * @author Tanisha Robertson
 */

package pizzeria_tanisharobertson;

import java.sql.*;

public class OrderTableManager
{

// link to database
    public final String DB_URL = "jdbc:derby://localhost:1527/Pizza";    
       
    
    // Connection to database
    private Connection conn;
    
        public OrderTableManager() throws SQLException {
        // log and pass to connect to database
        conn = DriverManager.getConnection(DB_URL, "group1", "group1");
    }
    
    public void insert(String size, String crustStyle,
            String toppingList, double cost) throws SQLException {
        String query = "INSERT INTO ordertable VALUES" + "(" + "'" + size +
                "', " + "'" + crustStyle + "', " + "'" + toppingList +
                "', " + "'" + cost + "'" + ")";
        
        // Create data to send to database
        Statement stmt = conn.createStatement();
        
        // Send data to database
        stmt.executeUpdate(query);
        
        // Close database connection
        conn.close();
        stmt.close();
    }
       
}
