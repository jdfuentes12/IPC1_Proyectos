package Objetos;

import java.io.Serializable;

public class Productos implements Serializable{
    
    private int CodigoP;
    private String Nombre;
    private String Descripcion;
    private int Cantidad;
    private double Precio;
    
    public Productos (int CodigoP, String Nombre, String Descripcion, int Cantidad, double precio){
        this.CodigoP = CodigoP;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Cantidad = Cantidad;
        this.Precio = precio;
        
    }

    public int getCodigoP() {
        return CodigoP;
    }

    public void setCodigoP(int CodigoP) {
        this.CodigoP = CodigoP;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
    
}
