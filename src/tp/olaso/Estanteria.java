package tp.olaso;

import java.util.ArrayList;

public class Estanteria {

    ArrayList<Pallet> pallets = new ArrayList<>();
    private char sector;
    private int numEstanteria;

    public Estanteria(char sector, int numEstanteria) {
        this.numEstanteria = numEstanteria;
        this.sector = sector;
        for (int i = 1; i < 5; i++) {
            pallets.add(new Pallet(sector, numEstanteria, i));
        }
    }

    public ArrayList<Pallet> getPallets() {
        return pallets;
    }

    @Override
    public String toString() {
        return "pallets: " + pallets + ", sector=" + sector + ", numEstanteria=" + numEstanteria + '}';
    }

    public String showContent() {
        String text = "";

        text += "Pallets: ";
        for (Pallet p : this.pallets) {
            text += "\n" + p.toString();

        }
        return text;
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

    public void setPallets(ArrayList<Pallet> pallets) {
        this.pallets = pallets;
    }

    public int contPallets() {
        int sumaTotal = 0;

        for (Pallet p : pallets) {
            if (p.isDisponible()) {
                sumaTotal++;
            }
        }
        return sumaTotal;
    }

    public int agregarPallets(int cantidad) {

        for (Pallet p : this.pallets) {

            cantidad = cantidad - p.agregarPallet();
            if (cantidad == 0) {

                break;

            }
        }

        return cantidad;

    }

    public int egresarPallets(int cantidad) {

        for (Pallet p : this.pallets) {

            cantidad = cantidad - p.egresarPallet();
            if (cantidad == 0) {

                break;

            }
        }

        return cantidad;

    }
}
