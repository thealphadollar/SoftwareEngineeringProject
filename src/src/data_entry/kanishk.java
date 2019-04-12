
package data_entry; 

import java.sql.*;
import java.util.*;

/**
 *
 * @author udit
 */
public class kanishk {
private int col;    
private String name;
private String[] colName  = new String[20];
    private static final String rootUsername="root";//System.getenv("SE_SQL_USER");
    private static final String rootPassword="iit2017";//System.getenv("SE_SQL_PASS");
    private static final String conn_string= "jdbc:mysql://localhost:3306/demodb";//System.getenv("SE_SQL_CONN");
       public  void clean(Connection con, PreparedStatement ps){ 
   try{
        if ( ps != null )  ps.close();
        if ( con != null) con.close();
   }
    catch(Exception ex)
    { System.out.println(ex.getMessage()); }
 }

    
    
     public Connection getConnection() throws Exception {
         Class.forName("com.mysql.jdbc.Driver"); 
        // connect using Thin driver
        Connection con =   DriverManager.getConnection(conn_string,rootUsername,rootPassword);
     return con;
    }
    
     public static void main(String[] args)
     {
         kanishk obj = new kanishk();
         Scanner in = new Scanner(System.in);
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
   String tableName = obj.getName();
   int col = obj.getCol();
   
   String query = "CREATE TABLE IF NOT EXISTS `" + tableName + "` (" ;/*+
    "  `index` int(5) NOT NULL," +
    "  `station` int(5) NOT NULL," +
    "  PRIMARY KEY (`index`)," +
    "  UNIQUE KEY `station` (`station`)" +
    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci";*/
   String temp = "";  
   int i;
   for(i=0;i<col-1;i++)
   {
       temp =   obj.getColName()[i];
       query = query + "`" + temp + "` VARCHAR(45) NULL,";
   }
   
   temp =   obj.getColName()[i];
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

    /**
     * @return the col
     */
    public int getCol() {
        return col;
    }

    /**
     * @param col the col to set
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the colName
     */
    public String[] getColName() {
        return colName;
    }

    /**
     * @param colName the colName to set
     */
    public void setColName(String colName,int k) {
        this.colName[k] = colName;
    }
}