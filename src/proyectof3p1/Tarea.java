/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectof3p1;


/**
 *
 * @author Jorge Aguirre
 */
public class Tarea {
    private String fecha;
    private String detalles;
    private String tipo;
    private boolean completada;

    public Tarea(String fecha, String detalles, String tipo) {
        this.fecha = fecha;
        this.detalles = detalles;
        this.tipo = tipo;
        this.completada = false;
    }

    // Getters y Setters
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void completarTarea() {
        this.completada = true;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Detalles: " + detalles + ", Tipo: " + tipo + ", Completada: " + completada;
    }
}



