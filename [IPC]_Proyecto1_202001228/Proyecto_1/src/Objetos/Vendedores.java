package Objetos;

import java.io.Serializable;

public class Vendedores implements Serializable{
    
    private int CodigoV;
    private String Nombre;
    private int Caja;
    private int Ventas;
    private String Genero;
    private String password;
    
    public Vendedores(int CodigoV, String Nombre, int Caja, int Ventas, String Genero,String password){
        this.CodigoV = CodigoV;
        this.Nombre = Nombre;
        this.Caja = Caja;
        this.Ventas = Ventas;
        this.Genero = Genero;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCodigoV() {
        return CodigoV;
    }

    public void setCodigoV(int CodigoV) {
        this.CodigoV = CodigoV;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCaja() {
        return Caja;
    }

    public void setCaja(int Caja) {
        this.Caja = Caja;
    }

    public int getVentas() {
        return Ventas;
    }

    public void setVentas(int Ventas) {
        this.Ventas = Ventas;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }
            
}
