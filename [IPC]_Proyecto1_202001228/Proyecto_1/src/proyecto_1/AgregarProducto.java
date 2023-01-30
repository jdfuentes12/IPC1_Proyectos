package proyecto_1;

import Objetos.Productos;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AgregarProducto extends JFrame implements ActionListener, MouseListener{
    
    public JPanel panel ;
    
    public AgregarProducto(){
        setSize(450, 400);//tamaño y posicion
        setDefaultCloseOperation(3);//cerrar el programa
        setLocationRelativeTo(null); //establacer la ventana en el centro de la pantalla
        setTitle("Agregar Producto");//titulo de la ventana
        setVisible(true);
        PanelSucursal();
    }
    
    private void PanelSucursal(){
        panel = new JPanel();
        panel.setSize(450, 400);
        panel.setBackground(Color.LIGHT_GRAY); //establece el color del panel
        this.getContentPane().add(panel);
        panel.setLayout(null);
        ButtonAgregar();
        Etiqueta();
        JTexField();
        
    }
    
    private void Etiqueta() {
        JLabel titulo = new JLabel("Crear Nuevo Producto");
        titulo.setBounds(30, 30, 250, 30);
        titulo.setHorizontalAlignment(SwingConstants.LEFT);
        titulo.setFont(new Font("arial", Font.BOLD, 16));//establecer fuente del texto
        panel.add(titulo);

        JLabel codigo = new JLabel("Código:");
        codigo.setBounds(30, 80, 60, 30);
        codigo.setHorizontalAlignment(SwingConstants.LEFT);
        codigo.setFont(new Font("arial", Font.BOLD, 12));//establecer fuente del texto
        panel.add(codigo);

        JLabel nombre = new JLabel("Nombre:");
        nombre.setBounds(30, 120, 60, 30);
        nombre.setHorizontalAlignment(SwingConstants.LEFT);
        nombre.setFont(new Font("arial", Font.BOLD, 12));//establecer fuente del texto
        panel.add(nombre);

        JLabel descripcion = new JLabel("Descripcion:");
        descripcion.setBounds(30, 160, 80, 30);
        descripcion.setHorizontalAlignment(SwingConstants.LEFT);
        descripcion.setFont(new Font("arial", Font.BOLD, 12));//establecer fuente del texto
        panel.add(descripcion);

        JLabel cantidad = new JLabel("Cantidad:");
        cantidad.setBounds(30, 200, 60, 30);
        cantidad.setHorizontalAlignment(SwingConstants.LEFT);
        cantidad.setFont(new Font("arial", Font.BOLD, 12));//establecer fuente del texto
        panel.add(cantidad);
        
        JLabel precio = new JLabel("Precio:");
        precio.setBounds(30, 240, 60, 30);
        precio.setHorizontalAlignment(SwingConstants.LEFT);
        precio.setFont(new Font("arial", Font.BOLD, 12));//establecer fuente del texto
        panel.add(precio);
        
        
        
    }
    
    public JTextField ingrese_codigo,ingrese_nombre,ingrese_descripcion,ingrese_cantidad,ingrese_precio;
    private void JTexField() {
        ingrese_codigo = new JTextField();
        ingrese_codigo.setBounds(150, 80, 200, 30);
        panel.add(ingrese_codigo);

        ingrese_nombre = new JTextField();
        ingrese_nombre.setBounds(150, 120, 200, 30);
        panel.add(ingrese_nombre);

        ingrese_descripcion = new JTextField();
        ingrese_descripcion.setBounds(150, 160, 200, 30);
        panel.add(ingrese_descripcion);
        
        ingrese_cantidad = new JTextField();
        ingrese_cantidad.setBounds(150, 200, 200, 30);
        panel.add(ingrese_cantidad);
        
        ingrese_precio = new JTextField();
        ingrese_precio.setBounds(150, 240, 200, 30);
        panel.add(ingrese_precio);
    }
        
    private void ButtonAgregar(){
        Button agregar = new Button("Agregar");
        agregar.setBounds(150, 300, 200, 30);
        agregar.setEnabled(true); //encendido del  boton
        agregar.setForeground(Color.BLACK);
        agregar.setFont(new Font("arial", Font.BOLD, 12));
        panel.add(agregar);
        
        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String codigo = ingrese_codigo.getText();
                int codigoI = Integer.parseInt(codigo);

                String nombre = ingrese_nombre.getText();

                String direccion = ingrese_descripcion.getText();

                String cantidad = ingrese_cantidad.getText();
                int cantidadI = Integer.parseInt(cantidad);

                String precio  = ingrese_precio.getText();
                double precioI = Double.parseDouble(precio);

                Productos nuevo = new Productos(codigoI, nombre, direccion, cantidadI, precioI);
                Proyecto_1.AgregarProductos(nuevo);
                Proyecto_1.convertirDatosP();
                dispose();
                
                Administracion admin = new Administracion();
                admin.setVisible(true);
            }

        };
        agregar.addActionListener(accion);
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
