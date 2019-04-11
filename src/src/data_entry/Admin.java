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
import javax.swing.table.DefaultTableModel;
import java.util.*;
/**
 *
 * @author kanishk
 */
public class Admin {
    String Name;
    
    private static final String rootUsername="root";//System.getenv("SE_SQL_USER");
    private static final String rootPassword="iit2017";//System.getenv("SE_SQL_PASS");
    private static final String conn_string= "jdbc:mysql://localhost:3306/demodb";//System.getenv("SE_SQL_CONN");
    
    private Connection conn=null;
    void add_column(String col_name,String table,String type)
    {
                    try{
                         
                          conn= DriverManager.getConnection(conn_string, rootUsername, rootPassword);
                          Statement st=(Statement) conn.createStatement();
                          //System.out.println("Entered into admin");
                          int n = st.executeUpdate("ALTER TABLE "+table+" ADD "+col_name+" "+type);
                         // System.out.println("Query OK, "+n+" rows affected");
                       }
                    catch(SQLException e)
                    {
                       System.out.println(e);
                    }
    }
    void add_row(String table,String user,String pass,String nam)
    {
 
        try{
                          conn= DriverManager.getConnection(conn_string, rootUsername, rootPassword);
                          Statement st=(Statement)conn.createStatement();
                          if(table=="Pending_Requests")
                          {
                            String sql = "INSERT INTO "+table+"(Name,username,password)"+"VALUES('"+nam+"','"+user+"','"+pass+"');";
                            //System.out.println(sql);
                            int rs=st.executeUpdate(sql);
  
                          }
                          else
                          {
                            String sql = "INSERT INTO "+table+"(username,password)"+"VALUES('"+user+"','"+pass+"');";
                            //System.out.println(sql);
                            int rs=st.executeUpdate(sql);
                          }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    Integer add_new(String table,String user,String pass)
    {
 
        try{
                          conn= DriverManager.getConnection(conn_string, rootUsername, rootPassword);
                          Statement st=(Statement)conn.createStatement();
                          
                          String query="select * from "+table+";";
                          ResultSet r_size=st.executeQuery(query);
                          int size = 0;
                          if (r_size!=null){
                              r_size.last();
                              size = r_size.getRow();
                          }
                          
                          if (size>=1){
                              return 0;
                          }
                          
         /*                 if(table=="Pending_Requests")
                          {
                            String sql = "INSERT INTO "+table+"(Name,username,password)"+"VALUES('"+nam+"','"+user+"','"+pass+"');";
                            //System.out.println(sql);
                            int rs=st.executeUpdate(sql);
  
                          }
                          else
                          {
                            String sql = "INSERT INTO "+table+"(username,password)"+"VALUES('"+user+"','"+pass+"');";
                            //System.out.println(sql);
                            int rs=st.executeUpdate(sql);
                          }*/
                          return 1;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return(0);
        }
    }
    void delete(String table,String name)
    {
         String sql = "delete from Pending_Requests where Name='"+name+"';";
         try{
                          conn= DriverManager.getConnection(conn_string, rootUsername, rootPassword);
                          Statement st=(Statement) conn.createStatement();
                         // String query="drop table "+table+";";
                         // System.out.println("I am inside delete table");
                          st.executeUpdate(sql);
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
                          String query="drop table "+table+";";
                          //System.out.println("I am inside drop table");
                          st.executeUpdate(query);
                    }
                    catch(SQLException e)
                    {
                        System.out.println(e);
                    }
    }
    void view_table(String table)
    {
        try{
                          conn= DriverManager.getConnection(conn_string, rootUsername, rootPassword);
                          Statement st=(Statement) conn.createStatement();
                          JTable tab=new JTable();
                          Table t=new Table(table);
                          String[] object=new String[t.col];
                          DefaultTableModel model = new DefaultTableModel();
                          model.setColumnIdentifiers(t.Col_name);
                          tab.setModel(model);
                          tab.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                          tab.setFillsViewportHeight(true);
                          JScrollPane scroll = new JScrollPane(tab);
                          scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                          scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                          System.out.println("I am inside drop table");
                          
                          JFrame f=new JFrame();
                          f.setTitle(table);
                          String query="select * from "+table+";";
                          ResultSet rs=st.executeQuery(query);
                          while(rs.next())
                          {
                              for(int i=0;i<t.col;++i)
                              {
                                  object[i]=rs.getString(i+1);
                              }
                              model.addRow(object);
                          }
                          
                          f.add(scroll);
                          f.setVisible(true);
                          f.setSize(600,400);
            }
            catch(SQLException e)
            {
                        System.out.println(e);
            }
    }
   public static void main(String args[])
    {
        Admin admin=new Admin();
        admin.add_row("Pending_Requests","user","pass","Shivam");
    }

  
}
