/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_entry;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author kanishk
 */
public class Admin {
    String Name;
    
    
    private static final String rootUsername="root";
    private static final String rootPassword="iit2017";
    private static final String conn_string="jdbc:mysql://localhost:3306/demodb";
    
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
