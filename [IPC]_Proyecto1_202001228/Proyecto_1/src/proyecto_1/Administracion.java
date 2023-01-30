package proyecto_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import Objetos.Clientes;
import Objetos.Productos;
import Objetos.Sucursales;
import Objetos.Vendedores;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.*;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.io.*;
import java.text.MessageFormat;
import java.util.Locale;
import javafx.scene.paint.Color;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;

public class Administracion extends JFrame implements ActionListener, MouseListener {

    Button sesion;

    public Administracion() {
        setSize(850, 650);//tamaño y posicion
        setLayout(null);
        setDefaultCloseOperation(3);//cerrar el programa
        setLocationRelativeTo(null); //establacer la ventana en el centro de la pantalla
        setTitle("Administacion");//titulo de la ventana
        setVisible(true);
        Sesion();
        JTabbePanel();
    }

    public JPanel Clientes, Productos, Sucursales, Vendedores;
    public static JTable t, tV, tP, tC;
    public static Object[][] datosS, datosP, datosC, datosV;

    public void JTabbePanel() {
        JTabbedPane pestana = new JTabbedPane();
        pestana.setBounds(30, 40, 750, 550);

        //sucursales 
        Sucursales = new JPanel();
        Sucursales.setLayout(null);
        Sucursales.setBackground(java.awt.Color.cyan);

        datosS = Proyecto_1.sucursales;
        String[] columnasS = {"Código", "Nombre", "Dirección", "Correo", "Télefono"};
        t = new JTable(datosS, columnasS);
        JScrollPane sp = new JScrollPane(t);
        sp.setBounds(10, 20, 450, 400);
        sp.setVisible(true);
        Sucursales.add(sp);

        ButtonSucursalCrear();
        ButtonSucursalActualizar();
        ButtonSucursalEliminar();
        ButtonSucursalExportar();
        ButtonSucursalCarga();

        //productos
        Productos = new JPanel();
        Productos.setLayout(null);
        Productos.setBackground(java.awt.Color.cyan);

        datosP = Proyecto_1.productos;
        String[] columnasP = {"Codigo", "Nombre", "Descripcion", "Cantidad", "Precio"};
        tP = new JTable(datosP, columnasP);
        JScrollPane spP = new JScrollPane(tP);
        spP.setBounds(10, 20, 450, 400);
        spP.setVisible(true);
        Productos.add(spP);

        ButtonProductosCrear();
        ButtonProductosCarga();
        ButtonProductosActualizar();
        ButtonProductosEliminar();
        ButtonProductosExportar();

        //clientes
        Clientes = new JPanel();
        Clientes.setLayout(null);
        Clientes.setBackground(java.awt.Color.cyan);

        datosC = Proyecto_1.clientes;
        String[] columnasC = {"Codigo", "Nombre", "NIT", "Correo", "Genero"};
        tC = new JTable(datosC, columnasC);
        JScrollPane spC = new JScrollPane(tC);
        spC.setBounds(10, 20, 450, 400);
        spC.setVisible(true);
        Clientes.add(spC);

        GraficaClientes();
        ButtonClientesCrear();
        ButtonClientesCarga();
        ButtonClientesActualizar();
        ButtonClientesEliminar();
        ButtonClientesExportar();

        //vendedores 
        Vendedores = new JPanel();
        Vendedores.setLayout(null);
        Vendedores.setBackground(java.awt.Color.cyan);

        datosV = Proyecto_1.vendedores;
        String[] columnasV = {"Codigo", "Nombre", "Caja", "Ventas", "Genero"};
        tV = new JTable(datosV, columnasV);
        JScrollPane spV = new JScrollPane(tV);
        spV.setBounds(10, 20, 450, 400);
        spV.setVisible(true);
        Vendedores.add(spV);

        ButtonVendedoresCrear();
        ButtonVendedoresCarga();
        ButtonVendedoresActualizar();
        ButtonVendedoresEliminar();
        ButtonVendedoresExportar();

        pestana.addTab("Sucursales", Sucursales);
        pestana.addTab("Productos", Productos);
        pestana.addTab("Clientes", Clientes);
        pestana.addTab("Vendedores", Vendedores);
        this.add(pestana);
    }

    //botones de sucursal
    private void ButtonSucursalCrear() {
        Button crear = new Button("Crear");
        crear.setBounds(500, 40, 100, 50);
        Sucursales.add(crear);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                AgregarSucursal agregar = new AgregarSucursal();
                agregar.setVisible(true);
                dispose();
            }
        };
        crear.addActionListener(accion);
    }

    private void ButtonSucursalCarga() {
        Button carga = new Button("Carga Masiva");
        carga.setBounds(620, 40, 100, 50);
        Sucursales.add(carga);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                LeerArchivosS();
                System.out.println(contenidoS);
                JsonParser parser = new JsonParser();
                JsonArray arreglo = parser.parse(contenidoS).getAsJsonArray();
                System.out.println("Cantidad de Objetos: " + arreglo.size());
                System.out.println("ya carge los archivos");
                for (int i = 0; i < arreglo.size(); i++) {
                    JsonObject objeto = arreglo.get(i).getAsJsonObject();
                    int codigo = objeto.get("codigo").getAsInt();
                    String nombre = objeto.get("nombre").getAsString();
                    String direccion = objeto.get("direccion").getAsString();
                    String correo = objeto.get("correo").getAsString();
                    int telefono = objeto.get("telefono").getAsInt();

                    Sucursales nuevo = new Sucursales(codigo, nombre, direccion, correo, telefono);
                    Proyecto_1.AgregarSucursal(nuevo);
                }
                Proyecto_1.convertirDatosS();
                dispose();
                Administracion admin = new Administracion();
                admin.setVisible(true);
            }
        };
        carga.addActionListener(accion);
    }

    static File archivoS;
    static FileReader frS;
    static BufferedReader brS;
    static String contenidoS = "";

    private void LeerArchivosS() {
        try {
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                archivoS = fc.getSelectedFile();
            }

            frS = new FileReader(archivoS);
            brS = new BufferedReader(frS);
            String linea;
            while ((linea = brS.readLine()) != null) {
                contenidoS += linea;
            }
            System.out.println("ya lei el archivo");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != frS) {
                    frS.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void ButtonSucursalActualizar() {
        Button actualizar = new Button("Actualizar");
        actualizar.setBounds(500, 100, 100, 50);
        Sucursales.add(actualizar);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                ActualizarSucursales actu = new ActualizarSucursales();
                actu.setVisible(true);
                dispose();
            }
        };
        actualizar.addActionListener(accion);
    }

    private void ButtonSucursalEliminar() {
        Button eliminar = new Button("Eliminar");
        eliminar.setBounds(620, 100, 100, 50);
        Sucursales.add(eliminar);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String dato = JOptionPane.showInputDialog("Introduzca el numero de codigo de la sucursal que desea eliminar:");
                int codigo = Integer.parseInt(dato);
                Proyecto_1.EliminarS(codigo);
                dispose();
                System.out.println(Proyecto_1.cSucursales);
                Proyecto_1.convertirDatosS();

                Administracion admin = new Administracion();
                admin.setVisible(true);
            }
        };
        eliminar.addActionListener(accion);

    }

    private void ButtonSucursalExportar() {
        Button exportar = new Button("Exportar Listado PDF");
        exportar.setBounds(500, 160, 220, 50);
        Sucursales.add(exportar);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean fitWidth = true;
                boolean interactive = true;
                boolean showPrintDialog = true;
                // (Definimos el modo de impresión)
                JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
                try {
                    // Print the table (Imprimo la tabla)             
                    boolean complete = t.print(mode,
                            new MessageFormat("Datos de Sucursales"),
                            new MessageFormat("Sucursales"),
                            showPrintDialog,
                            null,
                            interactive);
                    if (complete) {
                        // Mostramos el mensaje de impresión existosa
                        JOptionPane.showMessageDialog(t,
                                "Print complete (Impresión completa)",
                                "Print result (Resultado de la impresión)",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Mostramos un mensaje indicando que la impresión fue cancelada                 
                        JOptionPane.showMessageDialog(t,
                                "Print canceled (Impresión cancelada)",
                                "Print result (Resultado de la impresión)",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } catch (PrinterException pe) {
                    JOptionPane.showMessageDialog(t,
                            "Print fail (Fallo de impresión): " + pe.getMessage(),
                            "Print result (Resultado de la impresión)",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        exportar.addActionListener(accion);
    }

    //botones de productos
    private void ButtonProductosCrear() {
        Button crear = new Button("Crear");
        crear.setBounds(500, 40, 100, 50);
        Productos.add(crear);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                AgregarProducto agregar = new AgregarProducto();
                agregar.setVisible(true);
                dispose();
            }
        };
        crear.addActionListener(accion);
    }

    static File archivoP;
    static FileReader frP;
    static BufferedReader brP;
    static String contenidoP = "";

    private void LeerArchivosP() {
        try {
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                archivoP = fc.getSelectedFile();
            }

            frP = new FileReader(archivoP);
            brP = new BufferedReader(frP);
            String linea;
            while ((linea = brP.readLine()) != null) {
                contenidoP += linea;
            }
            System.out.println("ya lei el archivo");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != frP) {
                    frP.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void ButtonProductosCarga() {
        Button carga = new Button("Carga Masiva");
        carga.setBounds(620, 40, 100, 50);
        Productos.add(carga);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                LeerArchivosP();
                System.out.println(contenidoP);
                JsonParser parser = new JsonParser();
                JsonArray arreglo = parser.parse(contenidoP).getAsJsonArray();
                System.out.println("Cantidad de Objetos: " + arreglo.size());
                System.out.println("ya carge los archivos");
                for (int i = 0; i < arreglo.size(); i++) {
                    JsonObject objeto = arreglo.get(i).getAsJsonObject();
                    int codigo = objeto.get("codigo").getAsInt();
                    String nombre = objeto.get("nombre").getAsString();
                    String descripcion = objeto.get("descripcion").getAsString();
                    int cantidad = objeto.get("cantidad").getAsInt();
                    double precio = objeto.get("precio").getAsDouble();
                    Productos nuevo = new Productos(codigo, nombre, descripcion, cantidad, precio);
                    Proyecto_1.AgregarProductos(nuevo);
                }
                Proyecto_1.convertirDatosP();
                dispose();
                Administracion admin = new Administracion();
                admin.setVisible(true);
            }
        };
        carga.addActionListener(accion);
    }

    private void ButtonProductosActualizar() {
        Button actualizar = new Button("Actualizar");
        actualizar.setBounds(500, 100, 100, 50);
        Productos.add(actualizar);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                ActualizarProductos actu = new ActualizarProductos();
                actu.setVisible(true);
                dispose();
            }
        };
        actualizar.addActionListener(accion);
    }

    private void ButtonProductosEliminar() {
        Button eliminar = new Button("Eliminar");
        eliminar.setBounds(620, 100, 100, 50);
        Productos.add(eliminar);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String dato = JOptionPane.showInputDialog("Introduzca el numero de codigo de la sucursal que desea eliminar:");
                int codigo = Integer.parseInt(dato);
                Proyecto_1.EliminarP(codigo);
                dispose();
                System.out.println(Proyecto_1.cProductos);
                Proyecto_1.convertirDatosP();

                Administracion admin = new Administracion();
                admin.setVisible(true);
            }
        };
        eliminar.addActionListener(accion);

    }

    private void ButtonProductosExportar() {
        Button exportar = new Button("Exportar Listado PDF");
        exportar.setBounds(500, 160, 220, 50);
        Productos.add(exportar);
        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean fitWidth = true;
                boolean interactive = true;
                boolean showPrintDialog = true;
                // (Definimos el modo de impresión)
                JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
                try {
                    // Print the table (Imprimo la tabla)             
                    boolean complete = tP.print(mode,
                            new MessageFormat("Datos de Productos"),
                            new MessageFormat("Productos"),
                            showPrintDialog,
                            null,
                            interactive);
                    if (complete) {
                        // Mostramos el mensaje de impresión existosa
                        JOptionPane.showMessageDialog(tP,
                                "Print complete (Impresión completa)",
                                "Print result (Resultado de la impresión)",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Mostramos un mensaje indicando que la impresión fue cancelada                 
                        JOptionPane.showMessageDialog(tP,
                                "Print canceled (Impresión cancelada)",
                                "Print result (Resultado de la impresión)",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } catch (PrinterException pe) {
                    JOptionPane.showMessageDialog(tP,
                            "Print fail (Fallo de impresión): " + pe.getMessage(),
                            "Print result (Resultado de la impresión)",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        exportar.addActionListener(accion);
        
    }

    //botenes de clientes 
    private void ButtonClientesCrear() {
        Button crear = new Button("Crear");
        crear.setBounds(500, 40, 100, 50);
        Clientes.add(crear);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                AgregarCliente agregar = new AgregarCliente();
                agregar.setVisible(true);
                dispose();
            }
        };
        crear.addActionListener(accion);

    }

    static File archivoC;
    static FileReader frC;
    static BufferedReader brC;
    static String contenidoC = "";

    private void LeerArchivoC() {

        try {
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                //System.out.println(fc.getSelectedFile());
                archivoC = fc.getSelectedFile();
            }

            frC = new FileReader(archivoC);
            brC = new BufferedReader(frC);
            String linea;
            while ((linea = brC.readLine()) != null) {
                contenidoC += linea;

            }
            System.out.println("ya lei el archivo");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != frC) {
                    frC.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    int contadorHombre, contadorMujeres;

    private void ButtonClientesCarga() {
        Button carga = new Button("Carga Masiva");
        carga.setBounds(620, 40, 100, 50);
        Clientes.add(carga);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                LeerArchivoC();
                System.out.println(contenidoC);
                JsonParser parser = new JsonParser();
                JsonArray arreglo = parser.parse(contenidoC).getAsJsonArray();
                System.out.println("Cantidad de Objetos: " + arreglo.size());
                System.out.println("ya carge los archivos");
                for (int i = 0; i < arreglo.size(); i++) {
                    JsonObject objeto = arreglo.get(i).getAsJsonObject();

                    int codigo = objeto.get("codigo").getAsInt();
                    String nombre = objeto.get("nombre").getAsString();
                    int nit = objeto.get("nit").getAsInt();
                    String correo = objeto.get("correo").getAsString();
                    String genero = objeto.get("genero").getAsString();

                    System.out.println(genero);

                    if ("M".equals(genero.toUpperCase())) {
                        contadorHombre++;
                    } else if ("F".equals(genero.toUpperCase())) {
                        contadorMujeres++;
                    }

                    Clientes nuevo = new Clientes(codigo, nombre, nit, correo, genero);
                    Proyecto_1.AgregarClientes(nuevo);
                }
                Proyecto_1.convertirDatosC();
                dispose();
                Administracion admin = new Administracion();
                admin.setVisible(true);
            }
        };
        carga.addActionListener(accion);
    }

    private void ButtonClientesActualizar() {
        Button actualizar = new Button("Actualizar");
        actualizar.setBounds(500, 100, 100, 50);
        Clientes.add(actualizar);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                ActualizarClientes actu = new ActualizarClientes();
                actu.setVisible(true);
                dispose();
            }
        };
        actualizar.addActionListener(accion);

    }

    private void ButtonClientesEliminar() {
        Button eliminar = new Button("Eliminar");
        eliminar.setBounds(620, 100, 100, 50);
        Clientes.add(eliminar);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String dato = JOptionPane.showInputDialog("Introduzca el numero de codigo de la sucursal que desea eliminar:");
                int codigo = Integer.parseInt(dato);
                Proyecto_1.EliminarC(codigo);
                dispose();
                Proyecto_1.convertirDatosC();

                Administracion admin = new Administracion();
                admin.setVisible(true);
            }
        };
        eliminar.addActionListener(accion);
    }

    private void ButtonClientesExportar() {
        Button exportar = new Button("Exportar Listado PDF");
        exportar.setBounds(500, 160, 220, 50);
        Clientes.add(exportar);
        
        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean fitWidth = true;
                boolean interactive = true;
                boolean showPrintDialog = true;
                // (Definimos el modo de impresión)
                JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
                try {
                    // Print the table (Imprimo la tabla)             
                    boolean complete = t.print(mode,
                            new MessageFormat("Datos de Clientes"),
                            new MessageFormat("Clientes"),
                            showPrintDialog,
                            null,
                            interactive);
                    if (complete) {
                        // Mostramos el mensaje de impresión existosa
                        JOptionPane.showMessageDialog(tC,
                                "Print complete (Impresión completa)",
                                "Print result (Resultado de la impresión)",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Mostramos un mensaje indicando que la impresión fue cancelada                 
                        JOptionPane.showMessageDialog(tC,
                                "Print canceled (Impresión cancelada)",
                                "Print result (Resultado de la impresión)",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } catch (PrinterException pe) {
                    JOptionPane.showMessageDialog(tC,
                            "Print fail (Fallo de impresión): " + pe.getMessage(),
                            "Print result (Resultado de la impresión)",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        exportar.addActionListener(accion);
    }

    private void GraficaClientes() {
        DefaultPieDataset data = new DefaultPieDataset();
        for (int i = 0; i < Proyecto_1.cClientes; i++) {
            if (Proyecto_1.clien[i].getGenero().equals("f")) {
                contadorMujeres++;
            } else if (Proyecto_1.clien[i].getGenero().equals("m")) {
                contadorHombre++;
            }
        }
        System.out.println(contadorHombre + "-----" + contadorMujeres);
        data.setValue("Mujeres", contadorMujeres);
        data.setValue("Hombres", contadorHombre);

        JFreeChart chart = ChartFactory.createPieChart(
                "Generos de clientes",
                data,
                true,
                true,
                false);
        ChartPanel panel = new ChartPanel(chart);
        panel.setLayout(null);
        panel.setBounds(495, 240, 240, 200);
        panel.setVisible(true);
        Clientes.add(panel);
    }

    //botones de vendedores
    private void ButtonVendedoresCrear() {
        Button crear = new Button("Crear");
        crear.setBounds(500, 40, 100, 50);
        Vendedores.add(crear);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                AgregarVendedor agregar = new AgregarVendedor();
                agregar.setVisible(true);
                dispose();
            }
        };
        crear.addActionListener(accion);
    }

    static File archivoV;
    static FileReader frV;
    static BufferedReader brV;
    static String contenidoV = "";

    private void LeerArchivoV() {

        try {
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                //System.out.println(fc.getSelectedFile());
                archivoV = fc.getSelectedFile();
            }

            frV = new FileReader(archivoV);
            brV = new BufferedReader(frV);
            String linea;
            while ((linea = brV.readLine()) != null) {
                contenidoV += linea;

            }
            System.out.println("ya lei el archivo");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != frV) {
                    frV.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    private void ButtonVendedoresCarga() {
        Button carga = new Button("Carga Masiva");
        carga.setBounds(620, 40, 100, 50);
        Vendedores.add(carga);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                LeerArchivoV();
                System.out.println(contenidoV);
                JsonParser parser = new JsonParser();
                JsonArray arreglo = parser.parse(contenidoV).getAsJsonArray();
                System.out.println("Cantidad de Objetos: " + arreglo.size());
                System.out.println("ya carge los archivos");
                for (int i = 0; i < arreglo.size(); i++) {
                    JsonObject objeto = arreglo.get(i).getAsJsonObject();

                    int codigo = objeto.get("codigo").getAsInt();
                    String nombre = objeto.get("nombre").getAsString();
                    int caja = objeto.get("caja").getAsInt();
                    int ventas = objeto.get("ventas").getAsInt();
                    String genero = objeto.get("genero").getAsString();
                    String password = objeto.get("password").getAsString();
                    Vendedores nuevo = new Vendedores(codigo, nombre, caja, ventas, genero, password);
                    Proyecto_1.AgregarVendedores(nuevo);
                }
                Proyecto_1.convertirDatosV();
                dispose();
                Administracion admin = new Administracion();
                admin.setVisible(true);
            }
        };
        carga.addActionListener(accion);
    }

    private void ButtonVendedoresActualizar() {
        Button actualizar = new Button("Actualizar");
        actualizar.setBounds(500, 100, 100, 50);
        Vendedores.add(actualizar);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                ActualizarVendedor actu = new ActualizarVendedor();
                actu.setVisible(true);
                dispose();
            }
        };
        actualizar.addActionListener(accion);
    }

    private void ButtonVendedoresEliminar() {
        Button eliminar = new Button("Eliminar");
        eliminar.setBounds(620, 100, 100, 50);
        Vendedores.add(eliminar);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String dato = JOptionPane.showInputDialog("Introduzca el numero de codigo de la sucursal que desea eliminar:");
                int codigo = Integer.parseInt(dato);
                Proyecto_1.EliminarV(codigo);
                dispose();
                Proyecto_1.convertirDatosV();

                Administracion admin = new Administracion();
                admin.setVisible(true);
            }
        };
        eliminar.addActionListener(accion);

    }

    private void ButtonVendedoresExportar() {
        Button exportar = new Button("Exportar Listado PDF");
        exportar.setBounds(500, 160, 220, 50);
        Vendedores.add(exportar);
        
        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean fitWidth = true;
                boolean interactive = true;
                boolean showPrintDialog = true;
                // (Definimos el modo de impresión)
                JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
                try {
                    // Print the table (Imprimo la tabla)             
                    boolean complete = t.print(mode,
                            new MessageFormat("Datos de Vendedores"),
                            new MessageFormat("Vendedores"),
                            showPrintDialog,
                            null,
                            interactive);
                    if (complete) {
                        // Mostramos el mensaje de impresión existosa
                        JOptionPane.showMessageDialog(tV,
                                "Print complete (Impresión completa)",
                                "Print result (Resultado de la impresión)",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Mostramos un mensaje indicando que la impresión fue cancelada                 
                        JOptionPane.showMessageDialog(tV,
                                "Print canceled (Impresión cancelada)",
                                "Print result (Resultado de la impresión)",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } catch (PrinterException pe) {
                    JOptionPane.showMessageDialog(tV,
                            "Print fail (Fallo de impresión): " + pe.getMessage(),
                            "Print result (Resultado de la impresión)",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        exportar.addActionListener(accion);
    }

    //cerrar sesion
    private void Sesion() {
        sesion = new Button("Cerrar Sesion");
        sesion.setBackground(java.awt.Color.red);
        sesion.setBounds(720, 5, 100, 40);
        sesion.setVisible(true);
        add(sesion);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Proyecto_1.Serializar("Sucursales.bin", Proyecto_1.sucu);
                Proyecto_1.Serializar("Productos.bin", Proyecto_1.produ);
                Proyecto_1.Serializar("Clientes.bin", Proyecto_1.clien);
                Proyecto_1.Serializar("Vendedores.bin", Proyecto_1.vende);
                Proyecto_1.Serializar("Contador_Sucursales.bin", Proyecto_1.cSucursales);
                Proyecto_1.Serializar("Contador_Productos.bin", Proyecto_1.cProductos);
                Proyecto_1.Serializar("Contador_clientes.bin", Proyecto_1.cClientes);
                Proyecto_1.Serializar("Contador_vendedores.bin", Proyecto_1.cVendedor);
                Sesion sesion = new Sesion();
                sesion.setVisible(true);
                dispose();
            }
        };
        sesion.addActionListener(accion);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
