/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_entry;

/**
 *
 * @author kanishk
 */
import java.sql.*;
public class Table {
    String Table_name;
    int col;
    int row;
    String[] Col_name;
    String[] Data_type;
    private static final String rootUsername="root";
    private static final String rootPassword="iit2017";
    private static final String conn_string="jdbc:mysql://localhost:3306/demodb";
    private Connection conn;
    
    Table(String Table_name)
    {
        this.Table_name=Table_name;
       
        try{
                 conn=DriverManager.getConnection(conn_string,rootUsername,rootPassword);
                 Statement st=(Statement)conn.createStatement();
                 String query="SELECT * FROM "+this.Table_name;
                 ResultSet rs=st.executeQuery(query);
                 this.row=0;
                 while(rs.next())
                 {
                     ++row;
                 }
                 //Do the query where the desired table name exists
                 ResultSetMetaData rsmd = rs.getMetaData();
                 this.col = rsmd.getColumnCount();
                 Col_name=new String[this.col];
                 Data_type=new String[this.col];
                 for(int i=0;i<this.col;++i)
                 {
                     this.Col_name[i]=rsmd.getColumnName(i+1);
                     this.Data_type[i]=rsmd.getColumnTypeName(i+1);
                 }
                 this.show();
                
           }
        catch(Exception e)
        {
           System.out.println(e);
        }
    }
    void show()
    {
        for(int i=0;i<this.col;++i)
        {
            System.out.println(this.Col_name[i]+" "+this.Data_type[i]);
        }
    }
   /* public static void main(String args[])
    {
        Table data=new Table("INFO");
        data.show();
        
    }
   */
}
