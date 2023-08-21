
package tp.olaso;

import java.util.ArrayList;


public class Pasillo {
    ArrayList<Estanteria> estanterias = new ArrayList<>();
    public char sector;
    public Pasillo(char sector) {
        this.sector = sector;
        estanterias.add(new Estanteria(sector, 1));
        estanterias.add(new Estanteria(sector, 2));
    }

    public ArrayList<Estanteria> getEstanterias() {
        return estanterias;
    }

    public void setEstanterias(ArrayList<Estanteria> estanterias) {
        this.estanterias = estanterias;
    }
    
   public int contPallets(){
        int sumaTotal = 0;
                
        for(Estanteria e : estanterias){
            sumaTotal+=e.contPallets();//contando los pallets que estan en las estanterias
                
        }
        return sumaTotal;
    } 
}
