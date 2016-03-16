package pe.eeob.ndrasistencias.domain;

/**
 *
 * @author ErickOre
 */
public class Escuela {
    String codigo;
    String nombre;
    String codigo_sede;

    public Escuela() {
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

    public String getCodigo_sede() {
        return codigo_sede;
    }

    public void setCodigo_sede(String codigo_sede) {
        this.codigo_sede = codigo_sede;
    }
    
}
