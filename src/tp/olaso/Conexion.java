package tp.olaso;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
////base de datos

public class Conexion {

    static Scanner teclado = new Scanner(System.in);
    String bd = "cecytem";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "rene";
    String password = "8)jfm7mExnnWVsxa";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;

    public Conexion(String bd) {
        this.bd = bd;
    }

    public Connection conectar() {
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, user, password);
            System.out.println("SE CONECTO A BD " + bd);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("NO SE CONECTO A BD " + bd);
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }

    public void deconectar() {
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /////////
    public static void main(String[] args) {
        ArrayList<Pasillo> pasillos = new ArrayList<>();
        pasillos.add(new Pasillo('A'));
        pasillos.add(new Pasillo('B'));
        pasillos.add(new Pasillo('C'));
        pasillos.add(new Pasillo('D'));
        pasillos.add(new Pasillo('F'));
        pasillos.add(new Pasillo('G'));
        pasillos.add(new Pasillo('H'));

        Conexion conexion = new Conexion("cecytem");
        conexion.conectar();

        //System.out.println(pA.estanterias.get(0).agregarPallets(1));
        //Variables
        int cantidad;
        
        boolean seguir = true;
        while (seguir) {
            int opc = menu();
            if (opc == 1) {
                System.out.println("Cuantos pallets vas agregar?: ");
                cantidad = teclado.nextInt();
                int respuesta = agregarPallets(pasillos, cantidad);
                if (respuesta > 0) {
                    System.out.println("***No hay espacio para agregar mas pallets***");

                }

            } else if (opc == 2) {
                int tam = 0;
                System.out.println("Ingrese el nombre de la empresa: ");
                String nombreEmpresa = teclado.next();
                System.out.println("Ingrese el telefono: ");
                int telEmpresa = teclado.nextInt();

                Empresa emp = new Empresa(nombreEmpresa, telEmpresa);
                System.out.println("Ingrese la cantidad de pallets que va a retirar: ");
                cantidad = teclado.nextInt();

                int respuesta = egresoPallet(pasillos, cantidad, emp);
                if (respuesta > 0) {
                    System.out.println("***No hay mas pallets para retirar***");

                }
                Informe i = new Informe(emp, cantidad);
                System.out.println(i.mostrarDatos());

            } else if (opc == 3) {
                String text = "";
                text += "Seleccione un pasillo";
                int index = 0;
                for (Pasillo p : pasillos) {
                    text += "\n" + index++ + ". " + p.sector;

                }
                System.out.println(text);
                int pasillo = teclado.nextInt();

                text = "";
                text += "Seleccione estanteria";
                index = 0;
                for (Estanteria e : pasillos.get(pasillo).estanterias) {
                    text += "\n" + index++ + ". " + e.getNumEstanteria();

                }
                System.out.println(text);
                int estanteria = teclado.nextInt();
                System.out.println(pasillos.get(pasillo).estanterias.get(estanteria).showContent());
            }
            System.out.println("Desea seguir? si/no");
            String opc2 = teclado.next();

            if (opc2.equalsIgnoreCase("no")) {
                break;
            }

        }
    }

    public static int agregarPallets(ArrayList<Pasillo> pasillos, int cantidad) {
        for (Pasillo p : pasillos) {
            cantidad = p.agregarPallets(cantidad);
            if (cantidad == 0) {
                break;
            }

        }

        return cantidad;

    }

    public static int egresoPallet(ArrayList<Pasillo> pasillos, int cantidad, Empresa empresa) {
        for (Pasillo p : pasillos) {
            cantidad = p.egresarPallets(cantidad);
            if (cantidad == 0) {
                break;
            }
        }

        return cantidad;

    }

    public static int menu() {
        String text = "";
        text += "---Menu---";
        text += "\n1- Agregar pallet";
        text += "\n2- Egreso pallet";
        text += "\n3- Navegar el deposito";
        System.out.println(text);
        System.out.println("Elija la opcion que desee: ");
        int opc = teclado.nextInt();
        return opc;
    }

    public static int telefono() {
        int[] digitos = new int[11];
        int tam = 0;
        String cadena = "";
        do {
            System.out.println("Ingrese el telefono: ");
            int telEmpresa = teclado.nextInt();
            cadena = String.valueOf(telEmpresa);
            tam = cadena.length();
        } while (tam != 11);
        for (int i = 0; i < tam; i++) {
            digitos[i] = Integer.parseInt(cadena);
           
        }
       
        return digitos;
    }
}
