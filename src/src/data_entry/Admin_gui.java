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
import javax.swing.*;
import java.awt.*;
import java.lang.*;
public class Admin_gui extends javax.swing.JFrame {

    /**
     * Creates new form Admin_gui
     */
    private String username;
    private String password;
    private String usertype;
    private static final String rootUsername="root";//System.getenv("SE_SQL_USER");
    private static final String rootPassword="iit2017";//System.getenv("SE_SQL_PASS");
    private static final String conn_string= "jdbc:mysql://localhost:3306";//System.getenv("SE_SQL_CONN");
    private Connection conn;
    private Admin admin=new Admin();
    public Admin_gui() {
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
        delete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        approve = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WELCOME MY ADMIN");
        setAlwaysOnTop(true);
        setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "WELCOME MY ADMIN:)", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Liberation Sans", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel1.setText("Current Datatables");


        add_col.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        add_col.setText("Add Column");
        add_col.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        add_col.setText("Add Column");
        add_col.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_colActionPerformed(evt);
            }
        });

        view_table.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        view_table.setText("View Table");
        view_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_tableActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        this.list_reset();
        jScrollPane2.setViewportView(jList2);

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel2.setText("Pending Requests");

        approve.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        approve.setText("Approve ");
        approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        jLabel3.setText("New Table?");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        jLabel4.setText("Columns:");

        jButton5.setFont(new java.awt.Font("Liberation Sans", 1, 12)); // NOI18N
        jButton5.setText("Create Table");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(add_col, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(view_table, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(approve, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(44, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
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
                    .addComponent(delete)
                    .addComponent(approve))
                .addGap(32, 32, 32)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        
     private void approveActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String a=jList2.getSelectedValue().toString();
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
        admin.add_row("USERS", data[0], data[1], "");
        admin.delete("Pending_Requests",a);
        this.list_reset();
        
    }                                        

    private void add_colActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String a=jList1.getSelectedValue().toString();
        add_column add=new add_column(a);
        this.setVisible(false);
        this.dispose();
                
    }                                        

    private void view_tableActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String a = jList1.getSelectedValue().toString();
        admin.view_table(a);
        this.list_reset();
    }                                        

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String a = jList1.getSelectedValue().toString();
        admin.drop_table(a);
        this.list_reset();
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Admin_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         System.out.println("We are here from admin");
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton delete;
    private javax.swing.JButton add_col;
    private javax.swing.JButton view_table;
    private javax.swing.JButton approve;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}
