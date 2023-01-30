package practica_2_s2;

import java.awt.*;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static practica_2_s2.Configuracion.tiempo;

public class Juego extends javax.swing.JFrame {

    public static int time;
    public static Cuenta_regresiva htiempo = new Cuenta_regresiva();

    public Juego() {

        initComponents();
        setTitle("Torres de Hanoi - FIUSAC");
        setLocationRelativeTo(null);
        setResizable(false);

        if (Configuracion.discos == 3) {
            discos3();
        } else if (Configuracion.discos == 4) {
            discos4();
        } else if (Configuracion.discos == 5) {
            discos5();
        } else if (Configuracion.discos == 6) {
            discos6();
        } else if (Configuracion.discos == 7) {
            discos7();
        }

        try {
            htiempo.start();
        } catch (Exception ex) {
            htiempo.resume();
        }
    }

    public static Label b1, b2, b3, b4, b5, b6, b7;
    public int Cmovimientos;

    private void discos3() {
        b1 = new Label("1");
        b1.setName("1");
        b1.setAlignment(1);
        b1.setBounds(140, 190, 70, 30);
        b1.setBackground(Color.GREEN);
        torre1.add(b1);

        b2 = new Label("2");
        b2.setName("2");
        b2.setAlignment(1);
        b2.setBounds(110, 220, 120, 30);
        b2.setBackground(Color.YELLOW);
        torre1.add(b2);

        b3 = new Label("3");
        b3.setName("3");
        b3.setAlignment(1);
        b3.setBounds(90, 250, 160, 30);
        b3.setBackground(Color.BLUE);
        torre1.add(b3);

        torre1.setVisible(true);
    }

    private void discos4() {
        b1 = new Label("1");
        b1.setName("1");
        b1.setAlignment(1);
        b1.setBounds(140, 160, 70, 30);
        b1.setBackground(Color.GREEN);
        torre1.add(b1);

        b2 = new Label("2");
        b2.setName("2");
        b2.setAlignment(1);
        b2.setBounds(110, 190, 120, 30);
        b2.setBackground(Color.YELLOW);
        torre1.add(b2);

        b3 = new Label("3");
        b3.setName("3");
        b3.setAlignment(1);
        b3.setBounds(90, 220, 160, 30);
        b3.setBackground(Color.BLUE);
        torre1.add(b3);

        b4 = new Label("4");
        b4.setName("4");
        b4.setAlignment(1);
        b4.setBounds(70, 250, 200, 30);
        b4.setBackground(Color.RED);
        torre1.add(b4);

    }

    private void discos5() {
        b1 = new Label("1");
        b1.setName("1");
        b1.setAlignment(1);
        b1.setBounds(140, 130, 70, 30);
        b1.setBackground(Color.GREEN);
        torre1.add(b1);

        b2 = new Label("2");
        b2.setName("2");
        b2.setAlignment(1);
        b2.setBounds(110, 160, 120, 30);
        b2.setBackground(Color.YELLOW);
        torre1.add(b2);

        b3 = new Label("3");
        b3.setName("3");
        b3.setAlignment(1);
        b3.setBounds(90, 190, 160, 30);
        b3.setBackground(Color.BLUE);
        torre1.add(b3);

        b4 = new Label("4");
        b4.setName("4");
        b4.setAlignment(1);
        b4.setBounds(70, 220, 200, 30);
        b4.setBackground(Color.RED);
        torre1.add(b4);

        b5 = new Label("5");
        b5.setName("5");
        b5.setAlignment(1);
        b5.setBounds(50, 250, 240, 30);
        b5.setBackground(Color.GRAY);
        torre1.add(b5);
    }

    private void discos6() {
        b1 = new Label("1");
        b1.setName("1");
        b1.setAlignment(1);
        b1.setBounds(140, 100, 70, 30);
        b1.setBackground(Color.GREEN);
        torre1.add(b1);

        b2 = new Label("2");
        b2.setName("2");
        b2.setAlignment(1);
        b2.setBounds(110, 130, 120, 30);
        b2.setBackground(Color.YELLOW);
        torre1.add(b2);

        b3 = new Label("3");
        b3.setName("3");
        b3.setAlignment(1);
        b3.setBounds(90, 160, 160, 30);
        b3.setBackground(Color.BLUE);
        torre1.add(b3);

        b4 = new Label("4");
        b4.setName("4");
        b4.setAlignment(1);
        b4.setBounds(70, 190, 200, 30);
        b4.setBackground(Color.RED);
        torre1.add(b4);

        b5 = new Label("5");
        b5.setName("5");
        b5.setAlignment(1);
        b5.setBounds(50, 220, 240, 30);
        b5.setBackground(Color.GRAY);
        torre1.add(b5);

        b6 = new Label("6");
        b6.setName("6");
        b6.setAlignment(1);
        b6.setBounds(30, 250, 280, 30);
        b6.setBackground(Color.ORANGE);
        torre1.add(b6);
    }

    private void discos7() {
        b1 = new Label("1");
        b1.setName("1");
        b1.setAlignment(1);
        b1.setBounds(130, 70, 70, 30);
        b1.setBackground(Color.GREEN);
        torre1.add(b1);

        b2 = new Label("2");
        b2.setName("2");
        b2.setAlignment(1);
        b2.setBounds(110, 100, 120, 30);
        b2.setBackground(Color.YELLOW);
        torre1.add(b2);

        b3 = new Label("3");
        b3.setName("3");
        b3.setAlignment(1);
        b3.setBounds(90, 130, 160, 30);
        b3.setBackground(Color.BLUE);
        torre1.add(b3);

        b4 = new Label("4");
        b4.setName("4");
        b4.setAlignment(1);
        b4.setBounds(70, 160, 200, 30);
        b4.setBackground(Color.RED);
        torre1.add(b4);

        b5 = new Label("5");
        b5.setName("5");
        b5.setAlignment(1);
        b5.setBounds(50, 190, 240, 30);
        b5.setBackground(Color.GRAY);
        torre1.add(b5);

        b6 = new Label("6");
        b6.setName("6");
        b6.setAlignment(1);
        b6.setBounds(30, 220, 280, 30);
        b6.setBackground(Color.ORANGE);
        torre1.add(b6);

        b7 = new Label("7");
        b7.setName("7");
        b7.setAlignment(1);
        b7.setBounds(10, 250, 320, 30);
        b7.setBackground(Color.CYAN);
        torre1.add(b7);
    }

    public void cerrar() {
        System.out.println("cerre la ventana");
        dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cuentaRegresiva = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        movimientos = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        torre1 = new javax.swing.JLayeredPane();
        torre2 = new javax.swing.JLayeredPane();
        torre3 = new javax.swing.JLayeredPane();
        Contenedor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel2.setText("Tiempo");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        cuentaRegresiva.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        cuentaRegresiva.setText("000");
        jPanel2.add(cuentaRegresiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 140, -1));

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel5.setText("Movimiento");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        movimientos.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        movimientos.setText("00");
        jPanel2.add(movimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        jButton1.setText(">");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, -1, -1));

        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, -1));

        jButton3.setText(">");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, -1, -1));

        jButton4.setText("<");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, -1, -1));

        jButton5.setText(">");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 400, -1, -1));

        jButton6.setText("<");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 400, -1, -1));

        salir.setBackground(new java.awt.Color(255, 51, 51));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel2.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 480, -1, -1));

        javax.swing.GroupLayout torre1Layout = new javax.swing.GroupLayout(torre1);
        torre1.setLayout(torre1Layout);
        torre1Layout.setHorizontalGroup(
            torre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        torre1Layout.setVerticalGroup(
            torre1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        jPanel2.add(torre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 340, 280));

        javax.swing.GroupLayout torre2Layout = new javax.swing.GroupLayout(torre2);
        torre2.setLayout(torre2Layout);
        torre2Layout.setHorizontalGroup(
            torre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        torre2Layout.setVerticalGroup(
            torre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        jPanel2.add(torre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 340, 280));

        javax.swing.GroupLayout torre3Layout = new javax.swing.GroupLayout(torre3);
        torre3.setLayout(torre3Layout);
        torre3Layout.setHorizontalGroup(
            torre3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        torre3Layout.setVerticalGroup(
            torre3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        jPanel2.add(torre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 340, 280));

        Contenedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica_2_s2/bases.png"))); // NOI18N
        jPanel2.add(Contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        dispose();
        Configuracion.reiniciar();
        htiempo.suspend();
        inicio i = new inicio();
        i.setVisible(true);
    }//GEN-LAST:event_salirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AC();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AB();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        BA();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        BC();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        CB();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        CA();
    }//GEN-LAST:event_jButton5ActionPerformed

    static int contadorM;
    static Label a;

    public void AC() {
        if (torre1.getComponentCount() > 0) {
            Component n1 = torre1.getComponent(0);
            System.out.println(torre3.getComponentCount());

            if (torre3.getComponentCount() == 0) {
                torre1.remove(0);
                n1.setLocation(n1.getX(), 250);
                Cmovimientos++;
                movimientos.setText(String.valueOf(Cmovimientos));
                torre3.add(n1);
            } else if (torre3.getComponentCount() == 1) {
                if (Integer.valueOf(torre3.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre1.remove(0);
                    n1.setLocation(n1.getX(), 220);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre3.add(n1);
                }
            } else if (torre3.getComponentCount() == 2) {
                if (Integer.valueOf(torre3.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre1.remove(0);
                    n1.setLocation(n1.getX(), 190);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre3.add(n1);
                }
            } else if (torre3.getComponentCount() == 3) {
                if (Integer.valueOf(torre3.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre1.remove(0);
                    n1.setLocation(n1.getX(), 160);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre3.add(n1);
                }
            } else if (torre3.getComponentCount() == 4) {
                if (Integer.valueOf(torre3.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre1.remove(0);
                    n1.setLocation(n1.getX(), 130);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre3.add(n1);
                }
            } else if (torre3.getComponentCount() == 5) {
                if (Integer.valueOf(torre3.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre1.remove(0);
                    n1.setLocation(n1.getX(), 100);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre3.add(n1);
                }
            } else if (torre3.getComponentCount() == 6) {
                if (Integer.valueOf(torre3.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre1.remove(0);
                    n1.setLocation(n1.getX(), 70);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre3.add(n1);
                }
            }
        }
    }

    public void AB() {
        if (torre1.getComponentCount() > 0) {
            Component n1 = torre1.getComponent(0);
            System.out.println(torre2.getComponentCount());

            if (torre2.getComponentCount() == 0) {
                torre1.remove(0);
                n1.setLocation(n1.getX(), 250);
                Cmovimientos++;
                movimientos.setText(String.valueOf(Cmovimientos));
                torre2.add(n1);
            } else if (torre2.getComponentCount() == 1) {
                if (Integer.valueOf(torre2.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre1.remove(0);
                    n1.setLocation(n1.getX(), 220);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre2.add(n1);
                }
            } else if (torre2.getComponentCount() == 2) {
                if (Integer.valueOf(torre2.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre1.remove(0);
                    n1.setLocation(n1.getX(), 190);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre2.add(n1);
                }
            } else if (torre2.getComponentCount() == 3) {
                if (Integer.valueOf(torre2.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre1.remove(0);
                    n1.setLocation(n1.getX(), 160);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre2.add(n1);
                }
            } else if (torre2.getComponentCount() == 4) {
                if (Integer.valueOf(torre2.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre1.remove(0);
                    n1.setLocation(n1.getX(), 130);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre2.add(n1);
                }
            } else if (torre2.getComponentCount() == 5) {
                if (Integer.valueOf(torre2.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre1.remove(0);
                    n1.setLocation(n1.getX(), 100);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre2.add(n1);
                }
            } else if (torre2.getComponentCount() == 6) {
                if (Integer.valueOf(torre2.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre1.remove(0);
                    n1.setLocation(n1.getX(), 70);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre2.add(n1);
                }
            }
        }
    }

    public void BA() {
        if (torre2.getComponentCount() > 0) {
            Component n1 = torre2.getComponent(0);
            System.out.println(torre1.getComponentCount());

            if (torre1.getComponentCount() == 0) {
                torre2.remove(0);
                n1.setLocation(n1.getX(), 250);
                Cmovimientos++;
                movimientos.setText(String.valueOf(Cmovimientos));
                torre1.add(n1);
            } else if (torre1.getComponentCount() == 1) {
                if (Integer.valueOf(torre1.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre2.remove(0);
                    n1.setLocation(n1.getX(), 220);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre1.add(n1);
                }
            } else if (torre1.getComponentCount() == 2) {
                if (Integer.valueOf(torre1.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre2.remove(0);
                    n1.setLocation(n1.getX(), 190);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre1.add(n1);
                }
            } else if (torre1.getComponentCount() == 3) {
                if (Integer.valueOf(torre1.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre2.remove(0);
                    n1.setLocation(n1.getX(), 160);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre1.add(n1);
                }
            } else if (torre1.getComponentCount() == 4) {
                if (Integer.valueOf(torre1.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre2.remove(0);
                    n1.setLocation(n1.getX(), 130);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre1.add(n1);
                }
            } else if (torre1.getComponentCount() == 5) {
                if (Integer.valueOf(torre1.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre2.remove(0);
                    n1.setLocation(n1.getX(), 100);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre1.add(n1);
                }
            } else if (torre1.getComponentCount() == 6) {
                if (Integer.valueOf(torre1.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre2.remove(0);
                    n1.setLocation(n1.getX(), 70);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre1.add(n1);
                }
            }
        }
    }

    public void BC() {
        if (torre2.getComponentCount() > 0) {
            Component n1 = torre2.getComponent(0);
            System.out.println(torre3.getComponentCount());

            if (torre3.getComponentCount() == 0) {
                if (Integer.valueOf(torre3.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre2.remove(0);
                    n1.setLocation(n1.getX(), 220);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre3.add(n1);
                }
            } else if (torre3.getComponentCount() == 1) {
                if (Integer.valueOf(torre3.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre2.remove(0);
                    n1.setLocation(n1.getX(), 220);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre3.add(n1);
                }
            } else if (torre3.getComponentCount() == 2) {
                if (Integer.valueOf(torre3.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre2.remove(0);
                    n1.setLocation(n1.getX(), 190);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre3.add(n1);
                }
            } else if (torre3.getComponentCount() == 3) {
                if (Integer.valueOf(torre3.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre2.remove(0);
                    n1.setLocation(n1.getX(), 160);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre3.add(n1);
                }
            } else if (torre3.getComponentCount() == 4) {
                if (Integer.valueOf(torre3.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre2.remove(0);
                    n1.setLocation(n1.getX(), 130);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre3.add(n1);
                }
            } else if (torre3.getComponentCount() == 5) {
                if (Integer.valueOf(torre3.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre2.remove(0);
                    n1.setLocation(n1.getX(), 100);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre3.add(n1);
                }
            } else if (torre3.getComponentCount() == 6) {
                if (Integer.valueOf(torre3.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre2.remove(0);
                    n1.setLocation(n1.getX(), 70);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre3.add(n1);
                }
            }
        }
    }
    
    public void CA(){
        if (torre3.getComponentCount() > 0) {
            Component n1 = torre3.getComponent(0);
            System.out.println(torre1.getComponentCount());

            if (torre1.getComponentCount() == 0) {
                if (Integer.valueOf(torre1.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre3.remove(0);
                    n1.setLocation(n1.getX(), 220);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre1.add(n1);
                }
            } else if (torre1.getComponentCount() == 1) {
                if (Integer.valueOf(torre1.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre3.remove(0);
                    n1.setLocation(n1.getX(), 220);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre1.add(n1);
                }
            } else if (torre1.getComponentCount() == 2) {
                if (Integer.valueOf(torre1.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre3.remove(0);
                    n1.setLocation(n1.getX(), 190);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre1.add(n1);
                }
            } else if (torre1.getComponentCount() == 3) {
                if (Integer.valueOf(torre1.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre3.remove(0);
                    n1.setLocation(n1.getX(), 160);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre1.add(n1);
                }
            } else if (torre1.getComponentCount() == 4) {
                if (Integer.valueOf(torre1.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre3.remove(0);
                    n1.setLocation(n1.getX(), 130);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre1.add(n1);
                }
            } else if (torre1.getComponentCount() == 5) {
                if (Integer.valueOf(torre1.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre3.remove(0);
                    n1.setLocation(n1.getX(), 100);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre1.add(n1);
                }
            } else if (torre1.getComponentCount() == 6) {
                if (Integer.valueOf(torre1.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    JOptionPane.showMessageDialog(null, "Felicidades, ha ganado el juego ☺");
                }
            }
        }
    }

    public void CB(){
        if (torre3.getComponentCount() > 0) {
            Component n1 = torre3.getComponent(0);
            System.out.println(torre2.getComponentCount());

            if (torre2.getComponentCount() == 0) {
                if (Integer.valueOf(torre2.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre3.remove(0);
                    n1.setLocation(n1.getX(), 220);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre2.add(n1);
                }
            } else if (torre2.getComponentCount() == 1) {
                if (Integer.valueOf(torre2.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre3.remove(0);
                    n1.setLocation(n1.getX(), 220);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre2.add(n1);
                }
            } else if (torre2.getComponentCount() == 2) {
                if (Integer.valueOf(torre2.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre3.remove(0);
                    n1.setLocation(n1.getX(), 190);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre2.add(n1);
                }
            } else if (torre2.getComponentCount() == 3) {
                if (Integer.valueOf(torre2.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre3.remove(0);
                    n1.setLocation(n1.getX(), 160);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre2.add(n1);
                }
            } else if (torre2.getComponentCount() == 4) {
                if (Integer.valueOf(torre2.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre3.remove(0);
                    n1.setLocation(n1.getX(), 130);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre2.add(n1);
                }
            } else if (torre2.getComponentCount() == 5) {
                if (Integer.valueOf(torre2.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre3.remove(0);
                    n1.setLocation(n1.getX(), 100);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre2.add(n1);
                }
            } else if (torre2.getComponentCount() == 6) {
                if (Integer.valueOf(torre2.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    if (Integer.valueOf(torre2.getComponent(0).getName()) > Integer.valueOf(n1.getName())) {
                    torre3.remove(0);
                    n1.setLocation(n1.getX(), 100);
                    Cmovimientos++;
                    movimientos.setText(String.valueOf(Cmovimientos));
                    torre2.add(n1);
                }
                }
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Contenedor;
    public static javax.swing.JLabel cuentaRegresiva;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel movimientos;
    private javax.swing.JButton salir;
    public static javax.swing.JLayeredPane torre1;
    public static javax.swing.JLayeredPane torre2;
    public static javax.swing.JLayeredPane torre3;
    // End of variables declaration//GEN-END:variables
}
