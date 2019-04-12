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
public class USER_GUI {
    
    public USER_GUI(String username)
    {
        this.username=username;
        initComponents();
    }
     String username;
     static final String rootUsername="root";
     static final String rootPassword="iit2017";
     static final String conn_string="jdbc:mysql://localhost:3306/demodb";
     Connection conn;
     actual_header header=new actual_header();
     actual_submit submit=new actual_submit();
     String[] text_fields=new String[10];
     String[] labels=new String[10];

    JFrame frame;
    actual_user[] y=new actual_user[10];
    
     void initComponents()
    {
             this.conn=null;
             for(int i=0;i<10;++i)
             {
                 y[i]=new actual_user();
             }

             try{
                
                 conn=DriverManager.getConnection(conn_string,rootUsername,rootPassword);
                 Statement st=(Statement)conn.createStatement();
                 String query="Select * from Students where username='"+this.username+"';";
                 ResultSet rs=st.executeQuery(query);
                 Table User_data=new Table("Students");
                 int num_labels=User_data.col;
                 frame=new JFrame();
                 System.out.println(num_labels);

                 Container contentPane = frame.getContentPane();
                 contentPane.setLayout(new GridLayout(num_labels+2,1));
                 header.jLabel1.setText("Students");
                 frame.add(header);
                 if(rs.next())
                 {
                     for(int i=0;i<num_labels;++i)
                     {
                         text_fields[i]=rs.getString(i+1);
                         if(text_fields[i]!=null)
                         {
                           y[i].text.setText(text_fields[i]);
                         }
                     }
                 }
                     
                 for(int i=0;i<num_labels;++i)
                 {
                         y[i].jLabel1.setText(User_data.Col_name[i]);
                         labels[i]=User_data.Col_name[i];
                 }
                 
                 for(int i=0;i<num_labels;++i)
                 {  
                      frame.add(y[i]);
                 }
                         submit.submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_buttonActionPerformed(evt);
            }
        });
                frame.add(submit);
                frame.setSize(600, 400);
		frame.setVisible(true);
               
      

             }
             catch(SQLException e)
             {
                 System.out.println(e);
             }
    }
    void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        this.conn=null;
         try{
               
                
                 conn=DriverManager.getConnection(conn_string,rootUsername,rootPassword);
                 PreparedStatement st = null;
                 
                 String query="Students";
                 Table User_data=new Table(query);

                 int num_labels=User_data.col;
                 for(int i=0;i<num_labels;++i)
                 {
                     String text=y[i].text.getText();
                     String col_name=y[i].jLabel1.getText();
                     
                     System.out.println(col_name+" "+text);

                    
                  String sql ="UPDATE Students SET "+col_name+"="+text+" where username= "+this.username+";";
                   st=conn.prepareStatement(sql);
                   st.executeUpdate();
                   //System.out.println(rs);

                    
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
            new USER_GUI("jha");
         }
         catch(Exception e){
        }
    }
    
}
