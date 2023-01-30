package proyecto_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.*;

public class ActualizarClientes extends JFrame implements ActionListener, MouseListener{
    
    public JPanel panel ;
    
    public ActualizarClientes(){
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
        ButtonActualizar();
        Etiqueta();
        JTexField();
        
    }
    
    private void Etiqueta() {
        JLabel titulo = new JLabel("Crear Nuevo Cliente");
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

        JLabel nit = new JLabel("NIT:");
        nit.setBounds(30, 160, 60, 30);
        nit.setHorizontalAlignment(SwingConstants.LEFT);
        nit.setFont(new Font("arial", Font.BOLD, 12));//establecer fuente del texto
        panel.add(nit);

        JLabel corrreo = new JLabel("Correo:");
        corrreo.setBounds(30, 200, 60, 30);
        corrreo.setHorizontalAlignment(SwingConstants.LEFT);
        corrreo.setFont(new Font("arial", Font.BOLD, 12));//establecer fuente del texto
        panel.add(corrreo);
        
        JLabel genero = new JLabel("Genero:");
        genero.setBounds(30, 240, 60, 30);
        genero.setHorizontalAlignment(SwingConstants.LEFT);
        genero.setFont(new Font("arial", Font.BOLD, 12));//establecer fuente del texto
        panel.add(genero);
        
        
        
    }
    
    public JTextField ingrese_codigo,ingrese_nombre,ingrese_nit,ingrese_correo,ingrese_genero;
    private void JTexField() {
        ingrese_codigo = new JTextField();
        ingrese_codigo.setBounds(150, 80, 200, 30);
        panel.add(ingrese_codigo);

        ingrese_nombre = new JTextField();
        ingrese_nombre.setBounds(150, 120, 200, 30);
        panel.add(ingrese_nombre);

        ingrese_nit = new JTextField();
        ingrese_nit.setBounds(150, 160, 200, 30);
        panel.add(ingrese_nit);
        
        ingrese_correo = new JTextField();
        ingrese_correo.setBounds(150, 200, 200, 30);
        panel.add(ingrese_correo);
        
        ingrese_genero = new JTextField();
        ingrese_genero.setBounds(150, 240, 200, 30);
        panel.add(ingrese_genero);
    }
    
    private void ButtonActualizar(){
        Button agregar = new Button("Actualizar");
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

                String nit = ingrese_nit.getText();
                int nitI = Integer.parseInt(nit);

                String correo = ingrese_correo.getText();

                String genero  = ingrese_genero.getText();

                Proyecto_1.ActualizarC(codigoI, nombre, nitI, correo, genero);
                Proyecto_1.convertirDatosC();
                
                if (Proyecto_1.consultaC == false) {
                    JOptionPane.showMessageDialog(null, "Su actualizacion fue exitosa");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro el codigo en la base de datos");
                    dispose();
                }
                
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
