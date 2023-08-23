
package tp.olaso;

import java.time.LocalDate;

public class Empresa {
    public String nombre;
   
    public int telefono; 

    public Empresa(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre + " - telefono: " + telefono;
    }
    
    
}
