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
public class USER_GUI extends javax.swing.JFrame{
    
    public USER_GUI()
    {
        initComponents();
    }
    private String username;
    private String password;
    private String usertype;
    private static final String rootUsername="root";
    private static final String rootPassword="iit2017";
    private static final String conn_string="jdbc:mysql://localhost:3306/demodb";
    private Connection conn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    
    private void initComponents()
    {
             this.conn=null;
             

             try{
                
                 conn=DriverManager.getConnection(conn_string,rootUsername,rootPassword);
                 Statement st=(Statement)conn.createStatement();
                 String query="SELECT DataTable FROM USERS WHERE Username='"+this.username+"' AND Password='"+this.password+"'";
                 ResultSet rs=st.executeQuery(query);
                 Table User_data=new Table(query);

                         
                }
             catch(SQLException e)
             {
                 System.out.println(e);
             }
    }
}
