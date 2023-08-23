
package tp.olaso;

import java.time.LocalDate;

public class Informe {
    private Empresa empresa;
    public LocalDate fecha = LocalDate.now();
    private String ubicacion;
    public Informe(Empresa empresa, String ubicacion ) {
        this.empresa = empresa;
        this.ubicacion = ubicacion;
    }
   public String mostrarDatos(){
        String text = "";
        text += "---Informe de retiro---" ;
        text += "\nEmpresa: " + this.empresa.toString();
        text += "\nUbicacion: " + this.ubicacion;    
        text += "\nFecha: " + this.fecha;
        return text;
            
   }
}
