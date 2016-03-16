/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.eeob.ndrasistencias.domain;

/**
 *
 * @author ErickOre
 */
public class Apoderado {
    String dni;
    String paterno;
    String materno;
    String nombre;
    String codigo_escuela;

    public Apoderado() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo_escuela() {
        return codigo_escuela;
    }

    public void setCodigo_escuela(String codigo_escuela) {
        this.codigo_escuela = codigo_escuela;
    }
    
}
