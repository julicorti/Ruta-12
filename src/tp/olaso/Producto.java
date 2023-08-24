
package tp.olaso;

import java.util.ArrayList;

public class Producto {
    String nombre;
    String desc;

    public Producto(String nombre, String desc) {
        this.nombre = nombre;
        this.desc = desc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
}
