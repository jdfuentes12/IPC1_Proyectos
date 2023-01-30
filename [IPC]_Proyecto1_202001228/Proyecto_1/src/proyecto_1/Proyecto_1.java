package proyecto_1;

import Objetos.Clientes;
import Objetos.Productos;
import Objetos.Sucursales;
import Objetos.Vendedores;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;

public class Proyecto_1 implements Serializable{

    public static Sucursales[] sucu = new Sucursales[50];
    static Object[][] sucursales = new Object[50][5];
    static Productos[] produ = new Productos[200];
    static Object[][] productos = new Object[200][5];
    static Clientes[] clien = new Clientes[100];
    static Object[][] clientes = new Object[100][5];
    static Vendedores[] vende = new Vendedores[400];
    static Object[][] vendedores = new Object[400][6];
    static Object[][] agregar = new Object[10][5];

    public static void main(String[] args) {
        
        Sesion sesion = new Sesion();
        sesion.setVisible(true);
        //LlamarDeserealizacion();
    }

    static int cSucursales;
    public static void AgregarSucursal(Sucursales Sucursales) {
        if (cSucursales < sucu.length) {
            sucu[cSucursales] = Sucursales;
            cSucursales++;
        } else {
            System.out.println("ya esta lleno todas las sucursales");
        }
        Serializar("Sucursales.bin",sucursales);
    }

    public static Object[][] convertirDatosS() {
        int filas = cSucursales;
        for (int i = 0; i < filas; i++) {
            sucursales[i][0] = sucu[i].getCodigo();
            System.out.println(sucursales[i][0]);
            sucursales[i][1] = sucu[i].getNombre();
            System.out.println(sucursales[i][1]);
            sucursales[i][2] = sucu[i].getDireccion();
            System.out.println(sucursales[i][2]);
            sucursales[i][3] = sucu[i].getCorreo();
            System.out.println(sucursales[i][3]);
            sucursales[i][4] = sucu[i].getTelefono();
            System.out.println(sucursales[i][4]);
        }
        return sucursales;
    }

    static int cProductos;
    public static void AgregarProductos(Productos Productos) {
        if (cProductos < produ.length) {
            produ[cProductos] = Productos;
            cProductos++;
        }
    }

    public static Object[][] convertirDatosP() {
        int filas = cProductos;
        for (int i = 0; i < filas; i++) {
            productos[i][0] = produ[i].getCodigoP();
            productos[i][1] = produ[i].getNombre();
            productos[i][2] = produ[i].getDescripcion();
            productos[i][3] = produ[i].getCantidad();
            productos[i][4] = produ[i].getPrecio();
        }
        return productos;
    }

    static int cClientes;

    public static void AgregarClientes(Clientes Clientes) {
        if (cClientes < clien.length) {
            clien[cClientes] = Clientes;
            cClientes++;
        }
    }

    public static Object[][] convertirDatosC() {
        int filas = cClientes;
        for (int i = 0; i < filas; i++) {
            clientes[i][0] = clien[i].getCodigoC();
            clientes[i][1] = clien[i].getNombre();
            clientes[i][2] = clien[i].getNit();
            clientes[i][3] = clien[i].getCorreo();
            clientes[i][4] = clien[i].getGenero();
        }
        return clientes;
    }

    static int cVendedor;

    public static void AgregarVendedores(Vendedores Vendedores) {
        if (cVendedor < vende.length) {
            vende[cVendedor] = Vendedores;
            cVendedor++;
        }
    }

    public static Object[][] convertirDatosV() {
        int filas = cVendedor;
        for (int i = 0; i < filas; i++) {
            vendedores[i][0] = vende[i].getCodigoV();
            vendedores[i][1] = vende[i].getNombre();
            vendedores[i][2] = vende[i].getCaja();
            vendedores[i][3] = vende[i].getVentas();
            vendedores[i][4] = vende[i].getGenero();
            vendedores[i][5] = vende[i].getPassword();
        }
        return vendedores;
    }

    static boolean consultaS = true;

    public static void ActualizarS(int codigo, String nombre, String direccion, String correo, int telefono) {

        for (int i = 0; i < cSucursales; i++) {
            if (sucu[i].getCodigo() == codigo) {
                System.out.println(sucu[i].getCodigo());
                sucu[i].setNombre(nombre);
                System.out.println(sucu[i].getNombre());
                sucu[i].setDireccion(direccion);
                System.out.println(sucu[i].getDireccion());
                sucu[i].setCorreo(correo);
                System.out.println(sucu[i].getCorreo());
                sucu[i].setTelefono(telefono);
                System.out.println(sucu[i].getTelefono());
                consultaS = false;
            }
        }
    }

    static boolean consultaP = true;

    public static void ActualizarP(int codigo, String nombre, String descipcion, int cantidad, double precio) {
        for (int i = 0; i < cProductos; i++) {
            if (produ[i].getCodigoP() == codigo) {
                produ[i].setNombre(nombre);
                produ[i].setDescripcion(descipcion);
                produ[i].setCantidad(cantidad);
                produ[i].setPrecio(precio);
                consultaP = false;
            }
        }
    }

    static boolean consultaC = true;

    public static void ActualizarC(int codigo, String nombre, int nit, String correo, String genero) {
        for (int i = 0; i < cClientes; i++) {
            if (clien[i].getCodigoC() == codigo) {
                clien[i].setNombre(nombre);
                clien[i].setNit(nit);
                clien[i].setGenero(genero);
                clien[i].setGenero(genero);
                consultaC = false;
            }
        }
    }

    static boolean consultaV = true;

    public static void ActualizarV(int codigo, String nombre, int caja, int ventas, String genero, String password) {
        for (int i = 0; i < cVendedor; i++) {
            if (vende[i].getCodigoV() == codigo) {
                vende[i].setNombre(nombre);
                vende[i].setCaja(caja);
                vende[i].setVentas(ventas);
                vende[i].setGenero(genero);
                vende[i].setPassword(password);
                consultaV = false;
            }
        }
    }

    //Eliminar Sucursales
    static boolean eliminar = true;
    public static void EliminarS(int codigo) {
        for (int i = 0; i < cSucursales; i++) {
            if (sucu[i].getCodigo() == codigo) {
                RecorrerS(i);
                eliminar = false;
            }
        }
        System.out.println(cSucursales);
    }

    public static void RecorrerS(int a) {
        for (int i = a; i < cSucursales; i++) {
            sucu[i] = sucu[i + 1];
        }
        cSucursales--;
    }
    
    //Eliminar productos
    static boolean eliminarP = true;
    public static void EliminarP(int codigo){
        for (int i = 0; i < cProductos; i++) {
            if (produ[i].getCodigoP() == codigo) {
                RecorrerS(i);
                eliminarP = false;
            }
        }
        System.out.println(cProductos);
    }
    
    public static void RecorrerP(int a){
        for (int i = a; i < cProductos; i++) {
            produ[i] = produ[i + 1];
        }
        cProductos--;
    }
    
    //Elminar Clientes
    static boolean eliminarC = true;
    public static void EliminarC(int codigo){
        for (int i = 0; i < cClientes; i++) {
            if (clien[i].getCodigoC() == codigo) {
                RecorrerC(i);
                eliminarC = false;
            }
        }
        System.out.println(cClientes);
    }
    
    public static void RecorrerC(int a){
         for (int i = a; i < cClientes; i++) {
            clien[i] = clien[i + 1];
        }
        cClientes--;
    }
    
    //Eliminar Vendedores
    static boolean eliminarV = true;
    public static void EliminarV(int codigo){
        for (int i = 0; i < cVendedor; i++) {
            if (vende[i].getCodigoV() == codigo) {
                RecorrerV(i);
                eliminarV = false;
            }
        }
        System.out.println(cVendedor);
    }
    
    public static void RecorrerV(int a){
         for (int i = a; i < cVendedor; i++) {
            vende[i] = vende[i + 1];
        }
        cVendedor--;
    }
    
    
    //serializacion
    public static void Serializar(String nombre, Object objeto){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(nombre));
            objectOutputStream.writeObject(objeto);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Object Deserealizar(String nombre) {
        // Leer un objeto serializado
        try {
            System.out.println("estoy leyendo el archivo");
            ObjectInputStream leer = new ObjectInputStream(new FileInputStream(nombre));
            Object data = leer.readObject();
            System.out.println("estoy aca");
            leer.close();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("error");
        }
        System.out.println("ya cargue el archivo ");
        return null;
    }
    
    
    public static void LlamarDeserealizacion(){
        sucu = (Sucursales[])Deserealizar("Sucursales.bin");
        vende = (Vendedores[])Deserealizar("Vendedores.bin");
        clien = (Clientes[])Deserealizar("Clientes.bin");
        produ = (Productos[])Deserealizar("Productos.bin");
        cSucursales = (int) Deserealizar("Contador_Sucursales.bin");
        cVendedor = (int) Deserealizar("Contador_Sucursales.bin");
        cClientes = (int) Deserealizar("Contador_clientes.bin");
        cProductos = (int) Deserealizar("Contador_vendedores.bin");
        convertirDatosS();
        convertirDatosP();
        convertirDatosS();
        convertirDatosV();
    }
}
