/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.olaso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlConnection {

    private static Connection cx = null;
    private static String bd = "cecytem";
    static {
        try {
            
            String url = "jdbc:mysql://localhost:3306/";
            String user = "rene";
            String password = "8)jfm7mExnnWVsxa";
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, user, password);
            System.out.println("SE CONECTO A BD " + bd);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("NO SE CONECTO A BD " + bd);
            //Logger.getLogger(Ejecutable.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    /*public void deconectar() {
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Ejecutable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     */
    public static Connection getConnection() {
        return cx;
    }

}
