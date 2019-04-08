/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_entry;
import java.sql.*;
/**
 *
 * @author kanishk
 */
public class DATA_ENTRY {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Connection conn = null;
                try{
                String user = "root";
                String pass = "iit2017";
                String url = "jdbc:mysql://localhost:3306";
                conn = DriverManager.getConnection (url,user,pass);
                System.out.println ("Database connection established");
                }
                catch (Exception e) {
                System.err.println ("Cannot connect to database server:"+e);
                } finally {
                if (conn != null) 
                {
                   try {
                        conn.close ();
                        System.out.println("Database connection terminated:");
                       } 
                   catch (Exception e) { /* ignore close errors */ }
                }
                    }
                 new login().setVisible(true);
    }
    
}
