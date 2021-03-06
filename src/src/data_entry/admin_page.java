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
public class admin_page extends javax.swing.JFrame {

    /**
     * Creates new form admin_page
     */
    private String username;
    private String password;
    private String usertype;
    private static final String rootUsername="root";//System.getenv("SE_SQL_USER");
    private static final String rootPassword="iit2017";//System.getenv("SE_SQL_PASS");
    private static final String conn_string= "jdbc:mysql://localhost:3306";//System.getenv("SE_SQL_CONN");
    private Connection conn;
    private Admin admin=new Admin();
    public admin_page() {
              System.out.println("We are here from admin_gui");
        this.setVisible(true);
        initComponents();
   
    }
     void list_reset()
    {
        int count=0;
        int i=0;
        String[] table_name=new String[10];
        try{
                conn=DriverManager.getConnection(conn_string,rootUsername,rootPassword);
                Statement st=(Statement)conn.createStatement();
                String query="SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'demodb'";
                ResultSet rs=st.executeQuery(query);
                rs.next();
                count=(rs.getInt(1));
                query="SELECT table_name FROM information_schema.tables WHERE table_type = 'base table' AND table_schema='demodb';";
                rs=st.executeQuery(query);
               
                while(rs.next())
                {
                 table_name[i]=rs.getString(1);
                 //System.out.println(table_name[i]);
                 ++i;
                }
                
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
        final int Count=count;
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return Count; }
            public String getElementAt(int i) { return table_name[i]; }
        });
        jScrollPane1.setViewportView(jList1);
        count=0;i=0;
        String[] pending=new String[10];
        try{
                conn=DriverManager.getConnection(conn_string+"/demodb",rootUsername,rootPassword);
                Statement st=(Statement)conn.createStatement();
                String query="SELECT * FROM  Pending_Requests";
                ResultSet rs=st.executeQuery(query);
                while(rs.next())
                {
                 pending[i]=rs.getString(1);
                 //System.out.println(table_name[i]);
                 ++i;
                }
                count=i;
                
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
         final int Count2=count;
        jList2.setModel(new javax.swing.AbstractListModel<String>() {

            public int getSize() { return Count2; }
            public String getElementAt(int i) { return pending[i]; }
        });
        jScrollPane2.setViewportView(jList2);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        add_col = new javax.swing.JButton();
        view_table = new javax.swing.JButton();
        delete_table = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        approve = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        create_table = new javax.swing.JButton();
        view_message = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        back_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WELCOME MY ADMIN");
        setAlwaysOnTop(true);
        setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(41, 241, 195));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel1.setForeground(java.awt.Color.black);
        jLabel1.setText("Current Datatables");



        add_col.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        add_col.setForeground(java.awt.Color.black);
        add_col.setText("Add Column");
        add_col.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_colActionPerformed(evt);
            }
        });

        view_table.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        view_table.setForeground(java.awt.Color.black);
        view_table.setText("View Table");
        view_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_tableActionPerformed(evt);
            }
        });

        delete_table.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        delete_table.setForeground(java.awt.Color.black);
        delete_table.setText("Delete");
        delete_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_tableActionPerformed(evt);
            }
        });

        this.list_reset();

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel2.setForeground(java.awt.Color.black);
        jLabel2.setText("Pending Requests");

        approve.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        approve.setForeground(java.awt.Color.black);
        approve.setText("Approve ");
        approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        jLabel3.setForeground(java.awt.Color.black);
        jLabel3.setText("New Table?");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        jLabel4.setForeground(java.awt.Color.black);
        jLabel4.setText("Columns:");

        create_table.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        create_table.setForeground(java.awt.Color.black);
        create_table.setText("Create Table");
        create_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_tableActionPerformed(evt);
            }
        });

        view_message.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        view_message.setForeground(java.awt.Color.black);
        view_message.setText("View Message");
        view_message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_messageActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(36, 37, 42));

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("WELCOME ADMIN ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        back_button.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        back_button.setForeground(java.awt.Color.black);
        back_button.setText("Back");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gobacktologin(evt);
            }
        });
        

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(76, 76, 76)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(create_table)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(add_col, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(view_table, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(delete_table, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(view_message, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(approve, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(42, 42, 42))))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_col)
                    .addComponent(view_table)
                    .addComponent(delete_table)
                    .addComponent(approve)
                    .addComponent(view_message))
                .addGap(32, 32, 32)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(create_table)
                    .addComponent(back_button))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void approveActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
         String a=jList2.getSelectedValue().toString();
         String b=jList1.getSelectedValue().toString();
         Table t1=new Table(b);
         String[] A=new String[t1.col];
         for(int i=0;i<t1.col;++i)
         {
             A[i]=null;
         }
        admin.add_row_dynamically(b, A,t1.col);
        System.out.println(a);
        String[] data=new String[2];
        int i=0;
         try{
                          conn= DriverManager.getConnection(conn_string+"/demodb", rootUsername, rootPassword);
                          Statement st=(Statement)conn.createStatement();
                         
                          String sql ="Select * from Pending_Requests where Name='"+a+"';";
                          ResultSet rs=st.executeQuery(sql);
                          rs.next();
                          data[0]=rs.getString(2);
                          data[1]=rs.getString(3);
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }        
        admin.add_row("USERS", data[0], data[1], "","");
        admin.delete("Pending_Requests",a);
        this.list_reset();
    }                                       

    private void add_colActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
         String a=jList1.getSelectedValue().toString();
        add_column_revised add=new add_column_revised(a);
        this.setVisible(false);
        this.dispose();
    }                                       

    private void create_tableActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        int x=Integer.parseInt(jTextField1.getText());
        this.setVisible(false);
        this.dispose();
        new create_new_table(x);
    }                                            

    private void view_messageActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
         try{
                          conn= DriverManager.getConnection(conn_string+"/demodb", rootUsername, rootPassword);
                          Statement st=(Statement)conn.createStatement();
                          String a=jList2.getSelectedValue().toString();
                          String sql ="Select * from Pending_Requests where Name='"+a+"';";
                          ResultSet rs=st.executeQuery(sql);
                          rs.next();
                          
                          String message=rs.getString(4);
                     
                          javax.swing.JOptionPane.showMessageDialog(getContentPane(),message);
                    
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }        
        
    }     
    
    private void  gobacktologin(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
        new login();
    } 

    private void view_tableActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
              String a = jList1.getSelectedValue().toString();
        admin.view_table(a);
        this.list_reset();
    }                                          

    private void delete_tableActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
                String a = jList1.getSelectedValue().toString();
        admin.drop_table(a);
        this.list_reset();
    }                                            

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(admin_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton add_col;
    private javax.swing.JButton approve;
    private javax.swing.JButton back_button;
    private javax.swing.JButton create_table;
    private javax.swing.JButton delete_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton view_message;
    private javax.swing.JButton view_table;
    // End of variables declaration                   
}
