package proyecto_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

public class VentanaVendedores extends JFrame implements ActionListener, MouseListener {
    
    public VentanaVendedores(){
        setSize(900, 750);//tamaño y posicion
        setLayout(null);
        setDefaultCloseOperation(3);//cerrar el programa
        setLocationRelativeTo(null); //establacer la ventana en el centro de la pantalla
        setTitle("Modulo de Ventas");//titulo de la ventana
        setVisible(true);
        Sesion();
        tabla();
        JTabbePanel();
    }
    
    public JPanel Nueva, Ventas;
    public Object[][] datosS;
    public void JTabbePanel(){
        JTabbedPane pestana = new JTabbedPane();
        pestana.setBounds(20, 30, 850, 650);
        
        Nueva = new JPanel();
        Nueva.setLayout(null);
        Ventas = new JPanel();
        Ventas.setLayout(null);
        Nueva.setBackground(java.awt.Color.cyan.darker());
        
        datosS = Proyecto_1.agregar;
        String[] columnasS = {"Código", "Nombre", "Cantidad", "Precio", "Subtotal"};
        t = new JTable(datosS, columnasS);
        JScrollPane sp = new JScrollPane(t);
        sp.setBounds(40, 390, 750, 200);
        sp.setVisible(true);
        Nueva.add(sp);
        
        
        texto();
        Text();
        Botones();

        
        pestana.addTab("Nueva Venta", Nueva);
        pestana.addTab("Ventas", Ventas);
        this.add(pestana);
    }
    
    private void texto(){
        JLabel titulo = new JLabel("Seleccion Cliente");
        titulo.setBounds(10, 30, 250, 30);
        titulo.setHorizontalAlignment(SwingConstants.LEFT);
        titulo.setFont(new Font("arial", Font.BOLD, 20));//establecer fuente del texto
        Nueva.add(titulo);
        
        JLabel filtro = new JLabel("Filtrar por:");
        filtro.setBounds(20, 60, 200, 30);
        filtro.setHorizontalAlignment(SwingConstants.LEFT);
        filtro.setFont(new Font("Arial", Font.BOLD, 16));//establecer fuente del texto
        Nueva.add(filtro);
        
        JLabel nombre = new JLabel("Nombre: ");
        nombre.setBounds(150, 75, 200, 30);
        nombre.setHorizontalAlignment(SwingConstants.LEFT);
        nombre.setFont(new Font("arial", Font.ROMAN_BASELINE, 16));//establecer fuente del texto
        Nueva.add(nombre);
        
        JLabel nit = new JLabel("NIT: ");
        nit.setBounds(400, 75, 200, 30);
        nit.setHorizontalAlignment(SwingConstants.LEFT);
        nit.setFont(new Font("arial", Font.ROMAN_BASELINE, 16));//establecer fuente del texto
        Nueva.add(nit);
        
        JLabel correo = new JLabel("Correo: ");
        correo.setBounds(150, 115, 200, 30);
        correo.setHorizontalAlignment(SwingConstants.LEFT);
        correo.setFont(new Font("arial", Font.ROMAN_BASELINE, 16));//establecer fuente del texto
        Nueva.add(correo);
        
        JLabel genero = new JLabel("Genero: ");
        genero.setBounds(400, 115, 200, 30);
        genero.setHorizontalAlignment(SwingConstants.LEFT);
        genero.setFont(new Font("arial", Font.ROMAN_BASELINE, 16));//establecer fuente del texto
        Nueva.add(genero);
        
        JLabel filtro2 = new JLabel("Filtrar:");
        filtro2.setBounds(20, 210, 200, 30);
        filtro2.setHorizontalAlignment(SwingConstants.LEFT);
        filtro2.setFont(new Font("Arial", Font.BOLD, 16));//establecer fuente del texto
        Nueva.add(filtro2);
        
        JLabel cliente = new JLabel("Cliente");
        cliente.setBounds(150, 210, 200, 30);
        cliente.setHorizontalAlignment(SwingConstants.LEFT);
        cliente.setFont(new Font("arial", Font.ROMAN_BASELINE, 16));//establecer fuente del texto
        Nueva.add(cliente);
        
        JLabel titulo2 = new JLabel("Agregar Producto:");
        titulo2.setBounds(10, 300, 250, 30);
        titulo2.setHorizontalAlignment(SwingConstants.LEFT);
        titulo2.setFont(new Font("arial", Font.BOLD, 20));//establecer fuente del texto
        Nueva.add(titulo2);
        
        JLabel fecha = new JLabel("Fecha: ");
        fecha.setBounds(400, 300, 200, 30);
        fecha.setHorizontalAlignment(SwingConstants.LEFT);
        fecha.setFont(new Font("arial", Font.ROMAN_BASELINE, 16));//establecer fuente del texto
        Nueva.add(fecha);
        
        JLabel no = new JLabel("No: ");
        no.setBounds(580, 300, 200, 30);
        no.setHorizontalAlignment(SwingConstants.LEFT);
        no.setFont(new Font("arial", Font.ROMAN_BASELINE, 16));//establecer fuente del texto
        Nueva.add(no);
        
        JLabel codigo = new JLabel("Código:");
        codigo.setBounds(40, 350, 200, 30);
        codigo.setHorizontalAlignment(SwingConstants.LEFT);
        codigo.setFont(new Font("Arial", Font.ROMAN_BASELINE, 16));//establecer fuente del texto
        Nueva.add(codigo);
        
        JLabel cantidad = new JLabel("Cantidad:");
        cantidad.setBounds(300, 350, 200, 30);
        cantidad.setHorizontalAlignment(SwingConstants.LEFT);
        cantidad.setFont(new Font("Arial", Font.ROMAN_BASELINE, 16));//establecer fuente del texto
        Nueva.add(cantidad);
    }
    
    JTextField ingrese_nombre, ingrese_nit,ingrese_correo,ingrese_genero,ingrese_codigo,ingrese_cantidad;
    JComboBox cliente;
    
    private void Text(){
        ingrese_nombre = new JTextField();
        ingrese_nombre.setBounds(215, 75, 160, 30);
        Nueva.add(ingrese_nombre);
        
        ingrese_nit = new JTextField();
        ingrese_nit.setBounds(490, 75, 160, 30);
        Nueva.add(ingrese_nit);
        
        ingrese_correo = new JTextField();
        ingrese_correo.setBounds(215, 115, 160, 30);
        Nueva.add(ingrese_correo);
        
        ingrese_genero = new JTextField();
        ingrese_genero.setBounds(490, 115, 160, 30);
        Nueva.add(ingrese_genero);
        
        ingrese_codigo = new JTextField();
        ingrese_codigo.setBounds(115, 350, 160, 30);
        Nueva.add(ingrese_codigo);
        
        ingrese_cantidad = new JTextField();
        ingrese_cantidad.setBounds(400, 350, 160, 30);
        Nueva.add(ingrese_cantidad);
    }
    
    public JTable t;
    private void tabla(){
        
    }
    
    Button filtro, nuevo, agregar ;
    private void Botones(){
        filtro = new Button("Aplicar Filtro");
        filtro.setBounds(150, 170, 500, 30);
        filtro.setEnabled(true); //encendido del  boton
        filtro.setForeground(Color.BLACK);
        filtro.setFont(new Font("arial", Font.BOLD, 12));
        Nueva.add(filtro);
        
        nuevo = new Button("Nuevo cliente");
        nuevo.setBounds(450, 210, 200, 30);
        nuevo.setEnabled(true); //encendido del  boton
        nuevo.setForeground(Color.BLACK);
        nuevo.setFont(new Font("arial", Font.BOLD, 12));
        Nueva.add(nuevo);
        
        agregar = new Button("Agregar");
        agregar.setBounds(590, 350, 100, 30);
        agregar.setEnabled(true); //encendido del  boton
        agregar.setForeground(Color.BLACK);
        agregar.setFont(new Font("arial", Font.BOLD, 12));
        Nueva.add(agregar);
        
        
    }
    
    //Regresar al inicion de sesion 
    public Button sesion;
    private void Sesion() {
        sesion = new Button("Cerrar Sesion");
        sesion.setBackground(java.awt.Color.LIGHT_GRAY);
        sesion.setBounds(720, 5, 100, 40);
        sesion.setVisible(true);
        add(sesion);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Sesion sesion = new Sesion();
                sesion.setVisible(true);
                Proyecto_1.Serializar("Agregar.bin", Proyecto_1.agregar);
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
