/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_entry;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
/**
 *
 * @author kanishk
 */
public class Admin {
    String Name;
    
    
    private static final String rootUsername=System.getenv("SE_SQL_USER");
    private static final String rootPassword=System.getenv("SE_SQL_PASS");
    private static final String conn_string=System.getenv("SE_SQL_CONN");
    
    private Connection conn=null;
    void add_column(String col_name,String table,String type)
    {
                    try{
                         
                          conn= DriverManager.getConnection(conn_string, rootUsername, rootPassword);
                          Statement st=(Statement) conn.createStatement();
                          int n = st.executeUpdate("ALTER TABLE "+table+" ADD "+col_name+" "+type);
                          System.out.println("Query OK, "+n+" rows affected");
                       }
                    catch(SQLException e)
                    {
                       System.out.println(e);
                    }
    }
    void drop_table(String table)
    {
                    try{
                          conn= DriverManager.getConnection(conn_string, rootUsername, rootPassword);
                          Statement st=(Statement) conn.createStatement();
                          st.execute("drop table "+table);
                    }
                    catch(SQLException e)
                    {
                        System.out.println(e);
                    }
    }
    public static void main(String args[])
    {
        Admin admin=new Admin();
        admin.drop_table("INFO");
    }
}
