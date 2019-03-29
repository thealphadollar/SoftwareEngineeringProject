/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_entry;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
/**
 *
 * @author kanishk
 */
public class USER_GUI extends javax.swing.JFrame{
    
    public USER_GUI()
    {
        initComponents();
        this.setSize(300,100);
        this.setVisible(true);
    }
    private String username;
    private String password;
    private String usertype;
    private static final String rootUsername="root";
    private static final String rootPassword="iit2017";
    private static final String conn_string="jdbc:mysql://localhost:3306/demodb";
    private Connection conn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel[] jLabel=new javax.swing.JLabel[6];
    private javax.swing.JTextField[] jtexts=new javax.swing.JTextField[6];
    private javax.swing.JButton submit;

    
    
    private void initComponents()
    {
             this.conn=null;
             

             try{
                
                 conn=DriverManager.getConnection(conn_string,rootUsername,rootPassword);
                 Statement st=(Statement)conn.createStatement();
                 String query="Students";
                 //ResultSet rs=st.executeQuery(query);
                 Table User_data=new Table(query);
                 int num_labels=User_data.col;
                 setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                 jPanel1 = new javax.swing.JPanel(new GridLayout(4,1));
                 //jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "WELCOME_MY_USER", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Liberation Sans", 1, 14))); // NOI18N
                 add(jPanel1,BorderLayout.CENTER);
                 setTitle("Welcome_my_user");
                 for(int i=0;i<num_labels;++i)
                 {  
                     jLabel[i]=new javax.swing.JLabel();
                     jtexts[i]=new javax.swing.JTextField();
                     jLabel[i].setText(User_data.Col_name[i]);
                     jLabel[i].setFont(new java.awt.Font("Liberation Sans",1, 12)); // NOI18N
                     jPanel1.add(jLabel[i]);  
                     jPanel1.add(jtexts[i]);
                 }
               
                 submit = new javax.swing.JButton();
                 submit.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
                 submit.setText("Submit");
                 jPanel1.add(submit);
                 submit.addActionListener(new java.awt.event.ActionListener() 
                 {
                    public void actionPerformed(java.awt.event.ActionEvent evt)
                    {
                         submitActionPerformed(evt);
                    }
                 
                 });
             }
             catch(SQLException e)
             {
                 System.out.println(e);
             }
    }
    private void submitActionPerformed(java.awt.event.ActionEvent event){                                       
         
         this.conn=null;
         try{
               
                
                 conn=DriverManager.getConnection(conn_string,rootUsername,rootPassword);
                 Statement st=(Statement)conn.createStatement();
                 String query="Students";
                 Table User_data=new Table(query);
                 int num_labels=User_data.col;
                 for(int i=0;i<num_labels;++i)
                 {
                     String text=jtexts[i].getText();
                     String col_name=User_data.Col_name[i];
                     
                     System.out.println(col_name+" "+text);
                     String sql ="UPDATE Students SET "+col_name+"="+text+";";
                     int rs=st.executeUpdate(sql);
                     System.out.println(rs);
                 }
         }
         catch(SQLException e)
         {
             System.out.println("MIND_Fuck_HelpME   "+e);
         }
    } 
    public static void main(String args[])
    {

      try{
            USER_GUI frame=new USER_GUI();
         }
         catch(Exception e){
        }
    }
    
}
