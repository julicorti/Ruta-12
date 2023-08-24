package tp.olaso;

public class Pallet {

    private Producto producto = null;
    private boolean disponible = false;
    private char sector;
    private int numEstanteria;
    private int numPallet;
    private String ubicacion;

    public Pallet(char sector, int numEstanteria, int numPallet) {
        this.numPallet = numPallet;
        this.numEstanteria = numEstanteria;
        this.sector = sector;
        this.ubicacion = sector + "" + numEstanteria + "" + numPallet;

    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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

    public int agregarPallet() {
        if (this.disponible) {

            return 0;
        } else {
            this.disponible = true;
            return 1;
        }
    }

    public int egresarPallet() {
        if (this.disponible) {
            this.disponible = false;
            return 1;

        } else {

            return 0;
        }
    }

}
