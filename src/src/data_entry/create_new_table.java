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


public class create_new_table {
   static int number_of_rows;
    actual_header header=new actual_header();
    smp_for_create_table top=new smp_for_create_table();
    create_middle[] middle=new create_middle[10];
   actual_submit submit=new actual_submit();
   JFrame frame;
 public create_new_table(int cols) {
        this.number_of_rows=cols;
        initComponents();
        
    } 
     private void initComponents() {
          for(int i=0;i<10;++i)
          {
            middle[i]=new create_middle();
          }
         frame=new JFrame();
         Container contentPane = frame.getContentPane();
         contentPane.setLayout(new GridLayout(this.number_of_rows+3,1));
         header.jLabel1.setText("Create New Table");
         frame.add(header);
         frame.add(top);
         
         for(int i=0;i<this.number_of_rows;++i)
         {
             frame.add(middle[i]);
         }
          submit.submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_buttonActionPerformed(evt);
            }
        });
                  submit.back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });
         frame.add(submit);
         frame.setSize(600,400);
         frame.setVisible(true);
     }
     void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {   
         
         String[] labels=new String[number_of_rows];
         for(int i=0;i<number_of_rows;++i)
         {
             labels[i]=middle[i].text.getText();
         }
         String table="qwerty";
         kanishk obj = new kanishk();
  /*       Scanner in = new Scanner(System.in);
         System.out.println("Enter name");
         obj.setName(in.nextLine());
         System.out.println("Enter cols no.");
         obj.setCol(Integer.parseInt(in.nextLine()));
         int j=0;
         System.out.println("Enter name");
         for(j=0;j<obj.getCol();j++)
         {
            obj.setColName(in.nextLine(),j);
         }
    */     
         
    Connection con = null;
    PreparedStatement ps = null;
    /*
    CREATE TABLE `trial_schema`.`new_table` (
  `idnew_table` VARCHAR(45) NULL,
  `new_tablecol` VARCHAR(45) NULL);
    */
    try
    {
   con = obj.getConnection();
   //String tableName = obj.getName();
  // int col = obj.getCol();
   
    String query = "CREATE TABLE IF NOT EXISTS `" + table+ "` (" ;/*+
    "  `index` int(5) NOT NULL," +
    "  `station` int(5) NOT NULL," +
    "  PRIMARY KEY (`index`)," +
    "  UNIQUE KEY `station` (`station`)" +
    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci";*/
   String temp = "";  
   int i;
   for(i=0;i<number_of_rows-1;i++)
   {
       temp =   labels[i];
       query = query + "`" + temp + "` VARCHAR(45) NULL,";
   }
   
   temp =   labels[i];
   query = query + "`" + temp + "` VARCHAR(45) NULL);";
    ps = con.prepareStatement(query);
    ps.executeUpdate();
    
   
     }
     
      
        catch(Exception ex)
         {
        System.out.println(ex.getMessage());
            }
       /* finally
        {
             clean(con,ps);
        }*/ 
     }
     void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {
         frame.setVisible(false);
         frame.dispose();
         new admin_page();
         
     }
     public static void main(String args[])
     {
         new create_new_table(2);
     }
}
