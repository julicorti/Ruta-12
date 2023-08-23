package tp.olaso;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
        ArrayList<Pasillo> pasillos = new ArrayList<>(); 
        pasillos.add(new Pasillo('A'));
        pasillos.add(new Pasillo('B'));
        
        JPanel interfaz = new JPanel();
        Conexion conexion = new Conexion("cecytem");
        conexion.conectar();
       
        Empresa emp1 = new Empresa("Mattel", 1124613507);
    
        //System.out.println(pA.estanterias.get(0).agregarPallets(1));
        System.out.println(agregarPallets(pasillos, 17));
        
    }
    public static int agregarPallets(ArrayList<Pasillo> pasillos, int cantidad){
        for(Pasillo p : pasillos){
           cantidad = p.agregarPallets(cantidad);
           if(cantidad == 0){
               break;
           }
        }
       return cantidad;
       //negro
    }
    
}       
