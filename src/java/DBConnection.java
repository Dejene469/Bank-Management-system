
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hp
 */
class DBConnection {
  static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";

    //  Database credentials
    static final String USER = "MARS";
    static final String PASS = "9999";
    Connection con = null;
    Connection connMethod() throws ClassNotFoundException, SQLException {

        Class.forName(JDBC_DRIVER);
       System.out.println("Connecting to a selected database...");
        con = DriverManager.getConnection(DB_URL, USER, PASS);
      if (con != null) {
          System.out.println("Connected database successfully...");
      } else {
            System.out.println("nFailed to connect to Oracle DB");
      }
        return con;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        DBConnection db=new DBConnection();
        db.connMethod();
    }
    }
    

