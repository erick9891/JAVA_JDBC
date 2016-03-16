package pe.eeob.ndrasistencias.domain;

/**
 *
 * @author ErickOre
 */
public class Sede {
    String codigo;
    String nombre;
    String ciudad;

    public Sede() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
}
