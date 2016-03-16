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
public class Estudiante {
    String dni;
    String paterno;
    String materno;
    String nombre;
    String edad;
    String distrito;
    String dni_apoderado;

    public Estudiante() {
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDni_apoderado() {
        return dni_apoderado;
    }

    public void setDni_apoderado(String dni_apoderado) {
        this.dni_apoderado = dni_apoderado;
    }
    
}
