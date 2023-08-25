package tp.olaso;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

////base de datos
public class Ejecutable {

    static Scanner teclado = new Scanner(System.in);

    /////////
    public static void main(String[] args) throws SQLException {

        ArrayList<Pasillo> pasillos = new ArrayList<>();
        pasillos.add(new Pasillo('A'));
        pasillos.add(new Pasillo('B'));
        pasillos.add(new Pasillo('C'));
        pasillos.add(new Pasillo('D'));
        pasillos.add(new Pasillo('F'));
        pasillos.add(new Pasillo('G'));
        pasillos.add(new Pasillo('H'));

        Connection con = SqlConnection.getConnection();

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
                if (cantidad - respuesta != 0) {
                    Informe i = new Informe(emp, cantidad - respuesta);
                    System.out.println(i.mostrarDatos());
                    PreparedStatement ps = con.prepareStatement("INSERT INTO informes(nombreEmpresa, telefono, cantidad, fecha) values(?,?,?,?);");
                    ps.setString(1, i.getEmpresa().nombre);
                    ps.setInt(2, i.getEmpresa().telefono);
                    ps.setInt(3, cantidad - respuesta);
                    ps.setString(4, i.getFecha().toString());
                    ps.executeUpdate();
                }

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
            } else {
                System.out.println("***OPCION INCORRECTA***");
                continue;
            }
            System.out.println("Desea seguir? si/no");
            String opc2 = teclado.next();

            if (opc2.equalsIgnoreCase("no")) {
                
                break;
            }

        }
    }

    public static int agregarPallets(ArrayList<Pasillo> pasillos, int cantidad) throws SQLException {
        for (Pasillo p : pasillos) {
            cantidad = p.agregarPallets(cantidad);
            if (cantidad == 0) {
                break;
            }

        }

        return cantidad;

    }

    public static int egresoPallet(ArrayList<Pasillo> pasillos, int cantidad, Empresa empresa) throws SQLException {
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

    
}
