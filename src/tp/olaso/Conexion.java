package tp.olaso;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Conexion {
    String bd ="cecytem";
    String url="jdbc:mysql://localhost:3306/";
    String user="rene";
    String password="8)jfm7mExnnWVsxa";
    String driver ="com.mysql.cj.jdbc.Driver";
    Connection cx;
    public Conexion(String bd){
        this.bd=bd;
    }
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx=DriverManager.getConnection(url+bd, user, password);
            System.out.println("SE CONECTO A BD "+bd);
        } catch (ClassNotFoundException |SQLException ex) {
            System.out.println("NO SE CONECTO A BD "+bd);
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }
    public void deconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args){
        JPanel interfaz = new JPanel();
        Conexion conexion = new Conexion("cecytem");
        conexion.conectar();
        Pasillo pA = new Pasillo('A');
        Pasillo pB = new Pasillo('B');
        
        
    }
}       
