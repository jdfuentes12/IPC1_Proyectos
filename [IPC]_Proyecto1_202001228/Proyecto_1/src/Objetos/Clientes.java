package Objetos;

import java.io.Serializable;

public class Clientes implements Serializable{

    private int CodigoC;
    private String Nombre;
    private int Nit;
    private String Correo;
    private String Genero;

    public Clientes(int CodigoC, String Nombre, int Nit, String Correo, String Genero) {
        this.CodigoC = CodigoC;
        this.Nombre = Nombre;
        this.Nit = Nit;
        this.Correo = Correo;
        this.Genero = Genero;
    }

    public int getCodigoC() {
        return CodigoC;
    }

    public void setCodigoC(int CodigoC) {
        this.CodigoC = CodigoC;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNit() {
        return Nit;
    }

    public void setNit(int Nit) {
        this.Nit = Nit;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }
    
}
