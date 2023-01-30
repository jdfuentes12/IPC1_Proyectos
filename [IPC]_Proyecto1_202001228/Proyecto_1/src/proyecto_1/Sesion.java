package proyecto_1;

import Objetos.Sucursales;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import static proyecto_1.Proyecto_1.Deserealizar;


public class Sesion extends JFrame {

    public JPanel panel;

    public Sesion() {
        setSize(450, 250);//tamaño
        setDefaultCloseOperation(3);//cerrar el programa
        setLocationRelativeTo(null); //establacer la ventana en el centro de la pantalla
        setTitle("Iniciar Seción");//titulo de la ventana
        setVisible(true);
        PanelSesion();

    }

    private void PanelSesion() {
        panel = new JPanel();
        panel.setSize(450, 250);
        panel.setBackground(Color.lightGray); //establece el color del panel
        this.getContentPane().add(panel);
        panel.setLayout(null);
        Etiquetas();
        Text();
        BottunIniciar();

    }

    private void Etiquetas() {
        JLabel nombre = new JLabel("Usuario:");
        nombre.setBounds(30, 40, 60, 30);
        nombre.setHorizontalAlignment(SwingConstants.LEFT);
        nombre.setFont(new Font("arial", Font.BOLD, 12));//establecer fuente del texto

        panel.add(nombre);

        JLabel contraseña = new JLabel();
        contraseña.setText("Contraseña:");
        contraseña.setBackground(Color.BLACK);
        contraseña.setFont(new Font("arial", Font.BOLD, 12));
        contraseña.setBounds(30, 80, 80, 30);
        panel.add(contraseña).setVisible(true);
    }
    public JTextField ingrese_codigo;
    public JPasswordField ingrese_contraseña;

    public String codigo;
    private void Text() {
        ingrese_codigo = new JTextField();
        ingrese_codigo.setBounds(180, 40, 120, 30);
        panel.add(ingrese_codigo);
        

        ingrese_contraseña = new JPasswordField();
        ingrese_contraseña.setBounds(180, 80, 120, 30);
        panel.add(ingrese_contraseña);
    }

    private void BottunIniciar() {
        Button iniciar = new Button("Iniciar Seción");
        iniciar.setBounds(170, 150, 100, 30);
        iniciar.setEnabled(true); //encendido del  boton
        iniciar.setForeground(Color.BLACK);
        iniciar.setFont(new Font("arial", Font.BOLD, 12));
        panel.add(iniciar);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if ("admin".equals(ingrese_codigo.getText()) && "admin".equals(ingrese_contraseña.getText())) {
                    dispose();
                    Administracion admin = new Administracion();
                    admin.setVisible(true);
                    
                } else if ( "".equals(ingrese_codigo.getText()) && "".equals(ingrese_contraseña.getText()) ){
                    JOptionPane.showMessageDialog(null, "Debe ingresar algun Usuario");
                }else if (Proyecto_1.cVendedor > 0){
                    codigo =  ingrese_codigo.getText();
                    int usuario = Integer.parseInt(codigo);
                    System.out.println(usuario);
                    for (int i = 0; i < Proyecto_1.cVendedor ; i++) {
                        if ((usuario == Proyecto_1.vende[i].getCodigoV()) && ingrese_contraseña.getText().equals(Proyecto_1.vende[i].getPassword())) {
                            dispose();
                            VentanaVendedores vende = new VentanaVendedores();
                            vende.setVisible(true);
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "El usuario no existe en la base de datos. Intente nuevamente.");
                    ingrese_codigo.setText("");
                    ingrese_contraseña.setText("");   
                }
            }
            
            
        };
        iniciar.addActionListener(accion);

    }

}
