package Objetos;

import java.io.Serializable;

public class Sucursales implements Serializable{

    private int CodigoS;
    private String Nombre;
    private String Direccion;
    private String Correo;
    private int Telefono;

    public Sucursales(int Codigo, String Nombre, String Direccion, String Correo, int Telefono) {
        this.CodigoS = Codigo;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Correo = Correo;
        this.Telefono = Telefono;

    }

    public int getCodigo() {
        return CodigoS;
    }

    public void setCodigo(int codigo) {
        this.CodigoS = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

}
