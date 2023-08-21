package tp.olaso;

public class Pallet {

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

    public Informe retirarPallet(Empresa e) {
        if(disponible){
        disponible = false;
        return new Informe(e, this.ubicacion);
        }else{
            System.out.println("***Error***");
            System.out.println("No se puede llevar pallet " + this.ubicacion);
            return null;
        }
    }

    @Override
    public String toString() {
        return "Pallet: " + "disponible: " + disponible + ", sector: " + sector + ", numEstanteria: " + numEstanteria + ", numPallet: " + numPallet;
    }
    
}
