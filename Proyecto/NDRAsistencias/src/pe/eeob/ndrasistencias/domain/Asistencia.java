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
public class Asistencia {
    String codigo_curso;
    String dni_estudiante;
    String fecha;

    public Asistencia() {
    }

    public String getCodigo_curso() {
        return codigo_curso;
    }

    public void setCodigo_curso(String codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    public String getDni_estudiante() {
        return dni_estudiante;
    }

    public void setDni_estudiante(String dni_estudiante) {
        this.dni_estudiante = dni_estudiante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
