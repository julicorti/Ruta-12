package tp.olaso;

import java.util.ArrayList;




public class Estanteria {
     ArrayList<Pallet> pallets = new ArrayList<>();
     private char sector;
     private int numEstanteria;
    public Estanteria(char sector, int numEstanteria) {
        this.numEstanteria = numEstanteria;
        this.sector = sector;
        for(int i = 1; i < 5; i++){
            pallets.add(new Pallet(sector, numEstanteria, i));
        }
    }

    public ArrayList<Pallet> getPallets() {
        return pallets;
    }

    public void setPallets(ArrayList<Pallet> pallets) {
        this.pallets = pallets;
    }
    
    public int contPallets(){
        int sumaTotal = 0;
                
        for(Pallet p : pallets){
            if(p.isDisponible()){
                sumaTotal++;
            }
        }
        return sumaTotal;
    } 
}
