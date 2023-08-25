package tp.olaso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pallet {

    private boolean disponible = false;
    private char sector;
    private int numEstanteria;
    private int numPallet;
    private String ubicacion;
    private Connection con = SqlConnection.getConnection();


    public Pallet(char sector, int numEstanteria, int numPallet) throws SQLException {
        this.numPallet = numPallet;
        this.numEstanteria = numEstanteria;
        this.sector = sector;
        this.ubicacion = sector + "" + numEstanteria + "" + numPallet;


        PreparedStatement ps = con.prepareStatement("SELECT * FROM pallets WHERE ubicacion = ?");
        ps.setString(1, this.ubicacion);

        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            PreparedStatement ps2 = con.prepareStatement("INSERT INTO pallets(ubicacion, disponible) values(?,?)");
            ps2.setString(1, ubicacion);
            ps2.setBoolean(2, false);
            ps2.executeUpdate();
        } else {
            boolean d = rs.getBoolean("disponible");
            this.disponible = d;
        }

    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public char getSector() {
        return sector;
    }

    public void setSector(char sector) {
        this.sector = sector;
    }

    public int getNumEstanteria() {
        return numEstanteria;
    }

    public void setNumEstanteria(int numEstanteria) {
        this.numEstanteria = numEstanteria;
    }

    public int getNumPallet() {
        return numPallet;
    }

    public void setNumPallet(int numPallet) {
        this.numPallet = numPallet;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Pallet: " + "disponible: " + disponible + ", sector: " + sector + ", numEstanteria: " + numEstanteria + ", numPallet: " + numPallet;
    }

    public int agregarPallet() throws SQLException {
        if (this.disponible) {

            return 0;
        } else {
            this.disponible = true;
            saveChanges();

            return 1;
        }
    }

    public int egresarPallet() throws SQLException {
        if (this.disponible) {
            this.disponible = false;
            saveChanges();

            return 1;

        } else {

            return 0;
        }
    }

    public void saveChanges() throws SQLException {
        PreparedStatement ps = con.prepareStatement("UPDATE pallets SET disponible = ? WHERE ubicacion = ?");
        ps.setBoolean(1,this.disponible);
        ps.setString(2,this.ubicacion);
        ps.executeUpdate();
        
    }

    public void add(Pallet p) throws SQLException {
        Connection con = SqlConnection.getConnection();

        String query;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            query = "INSERT INTO (sector, numEstanteria, numPallet) values(?,?,?,?,?,?);";
            ps = con.prepareStatement(query);
            ps.setString(3, p.getUbicacion());
            ps.setInt(1, p.numPallet);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null && ps != null) {
                    rs.close();
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

    }
}
