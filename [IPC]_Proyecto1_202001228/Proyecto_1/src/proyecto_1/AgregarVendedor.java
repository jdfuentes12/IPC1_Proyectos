package proyecto_1;

import Objetos.Vendedores;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AgregarVendedor extends JFrame implements ActionListener, MouseListener {

    public JPanel panel;

    public AgregarVendedor() {
        setSize(450, 450);//tamaño y posicion
        setDefaultCloseOperation(3);//cerrar el programa
        setLocationRelativeTo(null); //establacer la ventana en el centro de la pantalla
        setTitle("Agregar Producto");//titulo de la ventana
        setVisible(true);
        PanelSucursal();
    }

    private void PanelSucursal() {
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
        JLabel titulo = new JLabel("Crear Nuevo Vendedor");
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

        JLabel caja = new JLabel("Caja:");
        caja.setBounds(30, 160, 60, 30);
        caja.setHorizontalAlignment(SwingConstants.LEFT);
        caja.setFont(new Font("arial", Font.BOLD, 12));//establecer fuente del texto
        panel.add(caja);

        JLabel ventas = new JLabel("Ventas:");
        ventas.setBounds(30, 200, 60, 30);
        ventas.setHorizontalAlignment(SwingConstants.LEFT);
        ventas.setFont(new Font("arial", Font.BOLD, 12));//establecer fuente del texto
        panel.add(ventas);

        JLabel genero = new JLabel("Genero:");
        genero.setBounds(30, 240, 60, 30);
        genero.setHorizontalAlignment(SwingConstants.LEFT);
        genero.setFont(new Font("arial", Font.BOLD, 12));//establecer fuente del texto
        panel.add(genero);

        JLabel password = new JLabel("Pasword:");
        password.setBounds(30, 280, 60, 30);
        password.setHorizontalAlignment(SwingConstants.LEFT);
        password.setFont(new Font("arial", Font.BOLD, 12));//establecer fuente del texto
        panel.add(password);

    }

    public JTextField ingrese_codigo, ingrese_nombre, ingrese_caja, ingrese_ventas, ingrese_genero, ingrese_contraseña;

    private void JTexField() {
        ingrese_codigo = new JTextField();
        ingrese_codigo.setBounds(150, 80, 200, 30);
        panel.add(ingrese_codigo);

        ingrese_nombre = new JTextField();
        ingrese_nombre.setBounds(150, 120, 200, 30);
        panel.add(ingrese_nombre);

        ingrese_caja = new JTextField();
        ingrese_caja.setBounds(150, 160, 200, 30);
        panel.add(ingrese_caja);

        ingrese_ventas = new JTextField();
        ingrese_ventas.setBounds(150, 200, 200, 30);
        panel.add(ingrese_ventas);

        ingrese_genero = new JTextField();
        ingrese_genero.setBounds(150, 240, 200, 30);
        panel.add(ingrese_genero);

        ingrese_contraseña = new JPasswordField();
        ingrese_contraseña.setBounds(150, 280, 200, 30);
        panel.add(ingrese_contraseña);

    }

    private void ButtonAgregar() {
        Button agregar = new Button("Agregar");
        agregar.setBounds(150, 330, 200, 30);
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

                String caja = ingrese_caja.getText();
                int cajaI = Integer.parseInt(caja);

                String ventas = ingrese_caja.getText();
                int ventasI = Integer.parseInt(ventas);

                String genero = ingrese_genero.getText();

                String password = ingrese_contraseña.getText();

                Vendedores nuevo = new Vendedores(codigoI, nombre, cajaI, ventasI, genero, password);
                Proyecto_1.AgregarVendedores(nuevo);
                Proyecto_1.convertirDatosV();
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
