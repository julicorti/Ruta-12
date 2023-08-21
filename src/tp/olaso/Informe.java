
package tp.olaso;

import java.time.LocalDate;

public class Informe {
    private Empresa empresa;
    public LocalDate fecha = LocalDate.now();

    public Informe(Empresa empresa) {
        this.empresa = empresa;
    }
   public void informe(){
        String text = "";
        text = "Empresa: " + this.empresa;
        
       
   }
}
