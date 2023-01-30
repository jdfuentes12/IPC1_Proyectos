package practica_2_s2;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static practica_2_s2.Configuracion.tiempo;
import static practica_2_s2.Juego.htiempo;
import static practica_2_s2.Juego.torre3;
import static practica_2_s2.inicio.juego;

public class Cuenta_regresiva extends Thread {

    public void run() {
        while (true) {
            try {
                Juego.cuentaRegresiva.setText(Configuracion.tiempo + " segundos");
                sleep(1000);
                Configuracion.tiempo--;

                if (torre3.getComponentCount() == Configuracion.discos) {
                    JOptionPane.showMessageDialog(null, "Felicidades, ha ganado el juego ☺");
                    accionGanar();
                    System.out.println("estoy aca");
                }

                if (Configuracion.tiempo < 0) {
                    accion();
                }
            } catch (Exception ex) {

            }
        }
    }

    public void accion() {
        JOptionPane.showMessageDialog(null, "Su tiempo ha terminado!!!");
        inicio inicio = new inicio();
        inicio.setVisible(true);
        Configuracion.reiniciar();
        juego.dispose();
        htiempo.suspend();
    }

    public static void accionGanar() {
        htiempo.suspend();
        JOptionPane.showMessageDialog(null, "Felicidades, ha ganado el juego ☺");
        juego.dispose();
        Ganador win = new Ganador();
        win.setVisible(true);

    }

}
