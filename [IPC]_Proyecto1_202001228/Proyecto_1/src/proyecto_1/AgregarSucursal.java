package proyecto_1;

import Objetos.Sucursales;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class AgregarSucursal extends JFrame implements ActionListener, MouseListener{
    public JPanel panel ;
    
    public AgregarSucursal(){
        setSize(450, 400);//tamaño y posicion
        setDefaultCloseOperation(3);//cerrar el programa
        setLocationRelativeTo(null); //establacer la ventana en el centro de la pantalla
        setTitle("Agregar Sucursal");//titulo de la ventana
        setVisible(true);
        PanelSucursal();
    }
    
    private void PanelSucursal(){
        panel = new JPanel();
        panel.setSize(500, 500);
        panel.setBackground(Color.LIGHT_GRAY); //establece el color del panel
        this.getContentPane().add(panel);
        panel.setLayout(null);
        ButtonAgregar();
        Etiqueta();
        JTexField();
        
    }
    
    private void Etiqueta() {
        JLabel titulo = new JLabel("Crear nueva Sucursal");
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

        JLabel direccion = new JLabel("Direccion:");
        direccion.setBounds(30, 160, 60, 30);
        direccion.setHorizontalAlignment(SwingConstants.LEFT);
        direccion.setFont(new Font("arial", Font.BOLD, 12));//establecer fuente del texto
        panel.add(direccion);

        JLabel correo = new JLabel("Correo:");
        correo.setBounds(30, 200, 60, 30);
        correo.setHorizontalAlignment(SwingConstants.LEFT);
        correo.setFont(new Font("arial", Font.BOLD, 12));//establecer fuente del texto
        panel.add(correo);
        
        JLabel telefono = new JLabel("Telefono:");
        telefono.setBounds(30, 240, 60, 30);
        telefono.setHorizontalAlignment(SwingConstants.LEFT);
        telefono.setFont(new Font("arial", Font.BOLD, 12));//establecer fuente del texto
        panel.add(telefono);
        
        
        
    }
    
    public JTextField ingrese_codigo,ingrese_nombre,ingrese_direccion,ingrese_correo,ingrese_telefono;
    private void JTexField() {
        ingrese_codigo = new JTextField();
        ingrese_codigo.setBounds(150, 80, 200, 30);
        panel.add(ingrese_codigo);

        ingrese_nombre = new JTextField();
        ingrese_nombre.setBounds(150, 120, 200, 30);
        panel.add(ingrese_nombre);

        ingrese_direccion = new JTextField();
        ingrese_direccion.setBounds(150, 160, 200, 30);
        panel.add(ingrese_direccion);
        
        ingrese_correo = new JTextField();
        ingrese_correo.setBounds(150, 200, 200, 30);
        panel.add(ingrese_correo);
        
        ingrese_telefono = new JTextField();
        ingrese_telefono.setBounds(150, 240, 200, 30);
        panel.add(ingrese_telefono);
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

                String direccion = ingrese_direccion.getText();

                String correo = ingrese_correo.getText();

                String telefono = ingrese_telefono.getText();
                int telefonoI = Integer.parseInt(telefono);

                Sucursales nuevo = new Sucursales(codigoI, nombre, direccion, correo, telefonoI);
                Proyecto_1.AgregarSucursal(nuevo);
                Proyecto_1.convertirDatosS();
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
