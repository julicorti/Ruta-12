
package tp.olaso;

import java.sql.SQLException;
import java.util.ArrayList;


public class Pasillo {
    ArrayList<Estanteria> estanterias = new ArrayList<>();
    public char sector;
    public Pasillo(char sector) throws SQLException {
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

    public char getSector() {
        return sector;
    }

    public void setSector(char sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return  "estanterias: " + estanterias + ", sector: " + sector;
    }
    
   public int contPallets(){
        int sumaTotal = 0;
                
        for(Estanteria e : estanterias){
            sumaTotal+=e.contPallets();//contando los pallets que estan en las estanterias
                
        }
        return sumaTotal;
    } 
   public int agregarPallets(int cantidad) throws SQLException {
        for(Estanteria e : this.estanterias){
           cantidad = e.agregarPallets(cantidad);
           if(cantidad == 0){
               break;
           }
        }
       return cantidad;
    
    }
    public int egresarPallets(int cantidad) throws SQLException {
        for(Estanteria e : this.estanterias){
           cantidad = e.egresarPallets(cantidad);
           if(cantidad == 0){
               break;
           }
        }
       return cantidad;
      
    }
}
