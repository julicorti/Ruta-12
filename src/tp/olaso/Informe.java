
package tp.olaso;

import java.time.LocalDate;

public class Informe {
    private Empresa empresa;
    public LocalDate fecha = LocalDate.now();
    public static int nroInforme = 1;
    public int cantPallets;
    public Informe(Empresa empresa, int cantidad) {
        this.empresa = empresa;
        this.cantPallets = cantidad;
        this.nroInforme = nroInforme++;
    }
   public String mostrarDatos(){
        String text = "";
        text += "---Informe de retiro---" ;
        text += "\nNº Informe: " + this.nroInforme;  
        this.nroInforme++;
        text += "- Empresa: " + this.empresa.toString();
        text += "\nFecha: " + this.fecha;
        text += "\nCantidad de pallets: " + this.cantPallets;
         
        
        return text;
            
   }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public static int getNroInforme() {
        return nroInforme;
    }

    public static void setNroInforme(int nroInforme) {
        Informe.nroInforme = nroInforme;
    }

    public int getCantPallets() {
        return cantPallets;
    }

    public void setCantPallets(int cantPallets) {
        this.cantPallets = cantPallets;
    }
   
}
