package practica_1_s2;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Practica_1_S2 {

    static Scanner ingreso;
    //tablero y penalizaciones
    static int[][] tablero = new int[8][8];
    static int[][] tablero2 = new int[8][8];
    //ejecicios dificiles
    static double[][] M3_1 = new double[4][4];
    static double[][] M3_2 = new double[4][4];
    static double[][] M3_3 = new double[4][4];
    static double[][] M3_4 = new double[4][4];
    static double[][] M3_5 = new double[4][4];
    static double[][] M3_6 = new double[4][4];
    //ejercicios medios
    static int[][] M2_1 = new int[5][5];
    static int[][] M2_2 = new int[5][5];
    static int[][] M2_3 = new int[5][5];
    static int[][] M2_4 = new int[5][5];
    static int[][] M2_5 = new int[5][5];
    static int[][] M2_6 = new int[5][5];
    //inversa de matrices
    static double[][] In1 = new double[4][4];
    static double[][] In2 = new double[4][4];
    static double[][] In3 = new double[4][4];
    //suma de matices
    static int[][] Suma1 = new int[5][5];
    static int[][] Suma2 = new int[5][5];
    static int[][] Suma3 = new int[5][5];
    //matriz inversa redondiada
    static double[][] R1 = new double[4][4];
    static double[][] R2 = new double[4][4];
    static double[][] R3 = new double[4][4];

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Bienvenido!!!!");
        System.out.println("Estas listo para saber si ganas o pierdes :v");
        matrices();
        tablero2();
        suma();
        guardarinversa();
        multilplicarIn();
        OperacionesFaciles();
        menu();
    }

    public static int reanudar;
    public static void menu() {
        int a = 0;
        do {

            System.out.println("========== MENU PRINCIPAL ==========");
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Retomar Juego");
            System.out.println("3. Generar Reportes");
            System.out.println("4. Salir");

            try {
                ingreso = new Scanner(System.in);
                a = ingreso.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor ingrese un numero");
                System.out.println("");
            }

            switch (a) {
                case 1:
                    posicion = 1;
                    valor = 0;
                    tablero();
                    movimientoTablero();
                    juego();
                    break;
                case 2:
                    reanudar();
                    juego();
                    break;
                case 3:
                    System.out.println("");
                    reporte();
                    System.out.println("Se ha generado su reporte con exito.");
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("Gracias por usar este juego");
                    System.exit(0);
                    break;
            }
        } while (a != 4);

    }

    public static void tablero2() {
        Random generador = new Random();
        for (int i = 0; i < tablero2.length; i++) {
            int contar1 = 0;
            int contar0 = 0;
            for (int j = 0; j < tablero2[i].length; j++) {
                if (contar1 <= 3) {
                    tablero2[i][j] = generador.nextInt(2);
                    if (tablero2[i][j] == 1) {
                        contar1++;
                    } else {
                        contar0++;
                    }
                } else {
                    tablero2[i][j] = 0;
                }

            }

        }
    }

    public static void tablero() {
        int contador = 64;
        Random generador = new Random();

        //numero del tablero ordenado segun el numero de carne
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = contador;
                contador--;
            }
        }
        System.out.println("");
    }

    
    public static void juego() {
        Scanner opcion = new Scanner(System.in);
        String b = "";
        do {

            System.out.println("1. Volver al menu principal con la letra p");
            System.out.println("2. Tirar el dado con la letra t");
            try {
                opcion = new Scanner(System.in);
                b = opcion.nextLine().toUpperCase();
            } catch (Exception e) {
                System.out.println("Por favor ingrese un valor correcto");
                System.out.println("");
            }

            switch (b.charAt(0)) {
                case 'P':
                    System.out.println("");
                    menu();
                    break;
                case 'T':
                    System.out.println("");
                    dado();
                    movimientoTablero();
                    break;
            }
        } while (b != "");

    }

    static Random generador = new Random();
    static int valor = 0;

    public static void dado() {
        //tiros del dado :v
        valor = generador.nextInt(7);
        if (valor >= 2 && valor <= 6) {
        } else if (valor == 0) {
            valor = valor + 2;
        } else if (valor == 1) {
            valor = valor + 1;
        }
        System.out.println("El numero que saco es: " + valor);
    }

    static int posicion = 1;
    static int facil = 0, medio = 0, dificil = 0;

    public static void movimientoTablero() {
        
        posicion = posicion + valor;
        boolean penalizacion = false;
        
        if (posicion <= 64) {
            boolean derecha = false;
            String pe = "";
            for (int i = 0; i < tablero.length; i++) {
                System.out.println("-----------------------------------------------------------");
                if (derecha) {
                    for (int j = 0; j < tablero[i].length; j++) {
                        System.out.print(tablero[i][j] + "|" + " \t");
                    }
                    System.out.println("");

                    for (int j = 0; j < tablero2[i].length; j++) {
                        if (tablero[i][j] == posicion && tablero2[i][j] == 1) {
                            System.out.print("#@|" + " \t");
                            if (posicion <= 16) {
                                facil++;
                            } else if (posicion > 16 && posicion <= 40) {
                                medio++;
                            } else if (posicion > 40 && posicion <= 64) {
                                dificil++;
                            }
                            penalizacion = true;
                        } else if (tablero[i][j] == posicion) {
                            System.out.print(" @|" + " \t");
                        } else if (tablero2[i][j] == 1) {
                            System.out.print(" #|" + " \t");
                        } else {
                            System.out.print("  |" + " \t");
                        }
                    }

                } else {

                    for (int j = tablero[i].length - 1; j >= 0; j--) {
                        System.out.print(tablero[i][j] + "|" + " \t");
                    }
                    System.out.println("");
                    for (int j = tablero[i].length - 1; j >= 0; j--) {
                        if (tablero[i][j] == posicion && tablero2[i][j] == 1) {
                            System.out.print(" #@|" + " \t");
                            if (posicion <= 16) {
                                facil++;
                            } else if (posicion > 16 && posicion <= 40) {
                                medio++;
                            } else if (posicion > 40 && posicion <= 64) {
                                dificil++;
                            }
                            penalizacion = true;
                        } else if (tablero[i][j] == posicion) {
                            System.out.print(" @|" + " \t");
                        } else if (tablero2[i][j] == 1) {
                            System.out.print(" #|" + " \t");
                        } else {
                            System.out.print("  |" + " \t");
                        }
                    }

                }
                System.out.println("");
                derecha = !derecha;
            }
            System.out.println("-----------------------------------------------------------");
            if (penalizacion == true) {
                System.out.println("Usted callo en una casilla penalizada");
                penalizaciones();
            }
        } else {
            System.out.println("");
            System.out.println("Usted a ganado el juego.");
            menu();
            System.out.println("");
        }
        System.out.println("");

    }

    public static void reanudar(){
        boolean penalizacion = false;
        if (posicion <= 64) {
            boolean derecha = false;
            String pe = "";
            for (int i = 0; i < tablero.length; i++) {
                System.out.println("-----------------------------------------------------------");
                if (derecha) {
                    for (int j = 0; j < tablero[i].length; j++) {
                        System.out.print(tablero[i][j] + "|" + " \t");
                    }
                    System.out.println("");

                    for (int j = 0; j < tablero2[i].length; j++) {
                        if (tablero[i][j] == posicion && tablero2[i][j] == 1) {
                            System.out.print("#@|" + " \t");
                            
                            penalizacion = true;
                        } else if (tablero[i][j] == posicion) {
                            System.out.print(" @|" + " \t");
                        } else if (tablero2[i][j] == 1) {
                            System.out.print(" #|" + " \t");
                        } else {
                            System.out.print("  |" + " \t");
                        }
                    }

                } else {

                    for (int j = tablero[i].length - 1; j >= 0; j--) {
                        System.out.print(tablero[i][j] + "|" + " \t");
                    }
                    System.out.println("");
                    for (int j = tablero[i].length - 1; j >= 0; j--) {
                        if (tablero[i][j] == posicion && tablero2[i][j] == 1) {
                            System.out.print(" #@|" + " \t");
                            
                            penalizacion = true;
                        } else if (tablero[i][j] == posicion) {
                            System.out.print(" @|" + " \t");
                        } else if (tablero2[i][j] == 1) {
                            System.out.print(" #|" + " \t");
                        } else {
                            System.out.print("  |" + " \t");
                        }
                    }
                }
                System.out.println("");
                derecha = !derecha;
            }
            System.out.println("-----------------------------------------------------------");
            if (penalizacion == true) {
                System.out.println("Usted callo en una casilla penalizada");
                penalizaciones();
            }
        } else {
            System.out.println("");
            System.out.println("Usted a ganado el juego.");
            menu();
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static void matrices() {
        // ejercicios medios
        int[] array2_1;
        int[] array2_2;
        int[] array2_3;
        int[] array2_4;
        int[] array2_5;
        int[] array2_6;
        //ejerciciso dificiles
        int[] array3_1;
        int[] array3_2;
        int[] array3_3;
        int[] array3_4;
        int[] array3_5;
        int[] array3_6;

        //matriz de operaciones intermedias
        array2_1 = new int[25];
        array2_1[0] = 7;
        array2_1[1] = 48;
        array2_1[2] = 5;
        array2_1[3] = 0;
        array2_1[4] = 1;
        array2_1[5] = 57;
        array2_1[6] = 8;
        array2_1[7] = 4;
        array2_1[8] = 6;
        array2_1[9] = 14;
        array2_1[10] = 0;
        array2_1[11] = 5;
        array2_1[12] = 6;
        array2_1[13] = 78;
        array2_1[14] = 15;
        array2_1[15] = 21;
        array2_1[16] = 14;
        array2_1[17] = 8;
        array2_1[18] = 19;
        array2_1[19] = 54;
        array2_1[20] = 32;
        array2_1[21] = 20;
        array2_1[22] = 26;
        array2_1[23] = 47;
        array2_1[24] = 12;

        int contador = 0;
        for (int i = 0;
                i < M2_1.length;
                i++) {
            for (int j = 0; j < M2_1[i].length; j++) {
                if (contador < array2_1.length) {
                    M2_1[i][j] = array2_1[contador];
                    contador++;
                }
            }
        }

        int contador1 = 0;
        array2_2 = new int[25];
        array2_2[0] = 9;
        array2_2[1] = 5;
        array2_2[2] = 2;
        array2_2[3] = 1;
        array2_2[4] = 8;
        array2_2[5] = 4;
        array2_2[6] = 2;
        array2_2[7] = 3;
        array2_2[8] = 47;
        array2_2[9] = 8;
        array2_2[10] = 48;
        array2_2[11] = 55;
        array2_2[12] = 32;
        array2_2[13] = 19;
        array2_2[14] = 6;
        array2_2[15] = 7;
        array2_2[16] = 56;
        array2_2[17] = 32;
        array2_2[18] = 14;
        array2_2[19] = 8;
        array2_2[20] = 32;
        array2_2[21] = 87;
        array2_2[22] = 0;
        array2_2[23] = 1;
        array2_2[24] = 7;

        for (int i = 0;
                i < M2_2.length;
                i++) {
            for (int j = 0; j < M2_2[i].length; j++) {
                if (contador1 < array2_2.length) {
                    M2_2[i][j] = array2_2[contador1];
                    contador1++;
                }
            }
        }

        int contador2 = 0;
        array2_3 = new int[25];
        array2_3[0] = 4;
        array2_3[1] = 9;
        array2_3[2] = 7;
        array2_3[3] = 45;
        array2_3[4] = 18;
        array2_3[5] = 7;
        array2_3[6] = 51;
        array2_3[7] = 26;
        array2_3[8] = 8;
        array2_3[9] = 38;
        array2_3[10] = 48;
        array2_3[11] = 26;
        array2_3[12] = 37;
        array2_3[13] = 21;
        array2_3[14] = 19;
        array2_3[15] = 1;
        array2_3[16] = 0;
        array2_3[17] = 6;
        array2_3[18] = 8;
        array2_3[19] = 1;
        array2_3[20] = 2;
        array2_3[21] = 19;
        array2_3[22] = 55;
        array2_3[23] = 25;
        array2_3[24] = 15;

        for (int i = 0;
                i < M2_3.length;
                i++) {
            for (int j = 0; j < M2_3[i].length; j++) {
                if (contador2 < array2_3.length) {
                    M2_3[i][j] = array2_3[contador2];
                    contador2++;
                }
            }
        }

        int contador3 = 0;
        array2_4 = new int[25];
        array2_4[0] = 0;
        array2_4[1] = 2;
        array2_4[2] = 15;
        array2_4[3] = 1;
        array2_4[4] = 66;
        array2_4[5] = 21;
        array2_4[6] = 48;
        array2_4[7] = 62;
        array2_4[8] = 7;
        array2_4[9] = 33;
        array2_4[10] = 4;
        array2_4[11] = 88;
        array2_4[12] = 0;
        array2_4[13] = 68;
        array2_4[14] = 4;
        array2_4[15] = 25;
        array2_4[16] = 18;
        array2_4[17] = 24;
        array2_4[18] = 7;
        array2_4[19] = 55;
        array2_4[20] = 24;
        array2_4[21] = 15;
        array2_4[22] = 36;
        array2_4[23] = 5;
        array2_4[24] = 98;

        for (int i = 0;
                i < M2_4.length;
                i++) {
            for (int j = 0; j < M2_4[i].length; j++) {
                if (contador3 < array2_4.length) {
                    M2_4[i][j] = array2_4[contador3];
                    contador3++;
                }
            }
        }

        int contador4 = 0;
        array2_5 = new int[25];
        array2_5[0] = 0;
        array2_5[1] = 1;
        array2_5[2] = 15;
        array2_5[3] = 5;
        array2_5[4] = 36;
        array2_5[5] = 1;
        array2_5[6] = 78;
        array2_5[7] = 65;
        array2_5[8] = 32;
        array2_5[9] = 4;
        array2_5[10] = 48;
        array2_5[11] = 66;
        array2_5[12] = 39;
        array2_5[13] = 0;
        array2_5[14] = 55;
        array2_5[15] = 14;
        array2_5[16] = 98;
        array2_5[17] = 63;
        array2_5[18] = 20;
        array2_5[19] = 15;
        array2_5[20] = 11;
        array2_5[21] = 39;
        array2_5[22] = 84;
        array2_5[23] = 7;
        array2_5[24] = 1;

        for (int i = 0;
                i < M2_5.length;
                i++) {
            for (int j = 0; j < M2_5[i].length; j++) {
                if (contador4 < array2_5.length) {
                    M2_5[i][j] = array2_5[contador4];
                    contador4++;
                }
            }
        }

        int contador5 = 0;
        array2_6 = new int[25];
        array2_6[0] = 78;
        array2_6[1] = 25;
        array2_6[2] = 66;
        array2_6[3] = 48;
        array2_6[4] = 98;
        array2_6[5] = 0;
        array2_6[6] = 45;
        array2_6[7] = 2;
        array2_6[8] = 3;
        array2_6[9] = 1;
        array2_6[10] = 2;
        array2_6[11] = 9;
        array2_6[12] = 14;
        array2_6[13] = 10;
        array2_6[14] = 20;
        array2_6[15] = 35;
        array2_6[16] = 87;
        array2_6[17] = 65;
        array2_6[18] = 2;
        array2_6[19] = 32;
        array2_6[20] = 25;
        array2_6[21] = 8;
        array2_6[22] = 4;
        array2_6[23] = 9;
        array2_6[24] = 39;

        for (int i = 0;
                i < M2_6.length;
                i++) {
            for (int j = 0; j < M2_6[i].length; j++) {
                if (contador5 < array2_6.length) {
                    M2_6[i][j] = array2_6[contador5];
                    contador5++;
                }
            }
        }

        // matrices de operaciones dificiles
        int contador6 = 0;
        array3_1 = new int[16];
        array3_1[0] = 5;
        array3_1[1] = 10;
        array3_1[2] = 1;
        array3_1[3] = 3;
        array3_1[4] = 9;
        array3_1[5] = 14;
        array3_1[6] = 2;
        array3_1[7] = 6;
        array3_1[8] = 7;
        array3_1[9] = 8;
        array3_1[10] = 15;
        array3_1[11] = 3;
        array3_1[12] = 6;
        array3_1[13] = 8;
        array3_1[14] = 9;
        array3_1[15] = 2;

        for (int i = 0;
                i < M3_1.length;
                i++) {
            for (int j = 0; j < M3_1[i].length; j++) {
                if (contador6 < array3_1.length) {
                    M3_1[i][j] = array3_1[contador6];
                    contador6++;
                }
            }
        }

        int contador7 = 0;
        array3_2 = new int[16];
        array3_2[0] = 5;
        array3_2[1] = 13;
        array3_2[2] = 9;
        array3_2[3] = 4;
        array3_2[4] = 1;
        array3_2[5] = 9;
        array3_2[6] = 6;
        array3_2[7] = 3;
        array3_2[8] = 8;
        array3_2[9] = 11;
        array3_2[10] = 69;
        array3_2[11] = 33;
        array3_2[12] = 25;
        array3_2[13] = 6;
        array3_2[14] = 7;
        array3_2[15] = 4;

        for (int i = 0;
                i < M3_2.length;
                i++) {
            for (int j = 0; j < M3_2[i].length; j++) {
                if (contador7 < array3_2.length) {
                    M3_2[i][j] = array3_2[contador7];
                    contador7++;
                }
            }
        }

        int contador8 = 0;
        array3_3 = new int[16];
        array3_3[0] = 1;
        array3_3[1] = 12;
        array3_3[2] = 9;
        array3_3[3] = 4;
        array3_3[4] = 7;
        array3_3[5] = 6;
        array3_3[6] = 3;
        array3_3[7] = 7;
        array3_3[8] = 0;
        array3_3[9] = 5;
        array3_3[10] = 6;
        array3_3[11] = 14;
        array3_3[12] = 6;
        array3_3[13] = 9;
        array3_3[14] = 6;
        array3_3[15] = 10;

        for (int i = 0;
                i < M3_3.length;
                i++) {
            for (int j = 0; j < M3_3[i].length; j++) {
                if (contador8 < array3_3.length) {
                    M3_3[i][j] = array3_3[contador8];
                    contador8++;
                }
            }
        }

        int contador9 = 0;
        array3_4 = new int[16];
        array3_4[0] = 8;
        array3_4[1] = 19;
        array3_4[2] = 20;
        array3_4[3] = 4;
        array3_4[4] = 12;
        array3_4[5] = 33;
        array3_4[6] = 6;
        array3_4[7] = 8;
        array3_4[8] = 4;
        array3_4[9] = 5;
        array3_4[10] = 9;
        array3_4[11] = 7;
        array3_4[12] = 8;
        array3_4[13] = 22;
        array3_4[14] = 14;
        array3_4[15] = 6;

        for (int i = 0;
                i < M3_4.length;
                i++) {
            for (int j = 0; j < M3_4[i].length; j++) {
                if (contador9 < array3_4.length) {
                    M3_4[i][j] = array3_4[contador9];
                    contador9++;
                }
            }
        }

        int contador10 = 0;
        array3_5 = new int[16];
        array3_5[0] = 5;
        array3_5[1] = 9;
        array3_5[2] = 14;
        array3_5[3] = 5;
        array3_5[4] = 6;
        array3_5[5] = 0;
        array3_5[6] = 5;
        array3_5[7] = 3;
        array3_5[8] = 1;
        array3_5[9] = 14;
        array3_5[10] = 68;
        array3_5[11] = 8;
        array3_5[12] = 7;
        array3_5[13] = 5;
        array3_5[14] = 3;
        array3_5[15] = 9;

        for (int i = 0;
                i < M3_5.length;
                i++) {
            for (int j = 0; j < M3_5[i].length; j++) {
                if (contador10 < array3_5.length) {
                    M3_5[i][j] = array3_5[contador10];
                    contador10++;
                }
            }
        }

        int contador11 = 0;
        array3_6 = new int[16];
        array3_6[0] = 0;
        array3_6[1] = 9;
        array3_6[2] = 7;
        array3_6[3] = 19;
        array3_6[4] = 2;
        array3_6[5] = 30;
        array3_6[6] = 5;
        array3_6[7] = 48;
        array3_6[8] = 1;
        array3_6[9] = 31;
        array3_6[10] = 2;
        array3_6[11] = 5;
        array3_6[12] = 15;
        array3_6[13] = 8;
        array3_6[14] = 4;
        array3_6[15] = 3;

        for (int i = 0;
                i < M3_6.length;
                i++) {
            for (int j = 0; j < M3_6[i].length; j++) {
                if (contador11 < array3_6.length) {
                    M3_6[i][j] = array3_6[contador11];
                    contador11++;
                }
            }
        }

        System.out.println("");

    }

    static int problema;
    public static void penalizaciones() {
        problema = generador.nextInt(3) + 1;
        if (posicion > 0 && posicion <= 16) {
            if (facil > 0 && facil <= 2) {
                System.out.println("Tiene que realiar el problema " + problema + " de la seccion facil");
                System.out.println("");
                if (problema == 1) {
                    System.out.println("Segun la ley de cosenos este es el resultado: ");
                    System.out.println("El lado B tiene el valro de: "+B1);
                    System.out.println("El angulo Betha tiene el valor de: "+Betha1);
                    System.out.println("El angulo Gamma tiene el valor de: "+Gamma1);
                } else if (problema == 2) {
                    System.out.println("El lado A tiene el valor de: "+A2);
                    System.out.println("El angulo Alpha tiene el valor de: "+Alpha2);
                    System.out.println("El angulo Gamma tiene el valor de: "+Gamma2);
                } else if (problema == 3) {
                    System.out.println("El lado C tiene el valor de: "+C3);
                    System.out.println("El angulo Alpha tiene el valor de: "+Alpha3);
                    System.out.println("El angulo Betha tiene el valor de: "+Betha3);
                }
                
            } else if (facil > 2) {
                System.out.println("ya esta exonerado de las penalizaciones faciles ");
            }
        }

        if (posicion > 16 && posicion <= 40) {
            if (medio > 0 && medio <= 2) {
                System.out.println("Tiene que realiar el problema " + problema + " de la seccion media");
                System.out.println("");
                if (problema == 1) {
                    System.out.println("La suma de matrices es: ");
                    for (int i = 0; i < Suma1.length; i++) {
                        for (int j = 0; j < Suma1[i].length; j++) {
                            System.out.print("[" + Suma1[i][j] + "]"+ "\t");
                        }
                        System.out.println("");
                    }
                }else if (problema == 2) {
                    System.out.println("La suma de matrices es: ");
                    for (int i = 0; i < Suma2.length; i++) {
                        for (int j = 0; j < Suma2[i].length; j++) {
                            System.out.print("[" + Suma2[i][j] + "]"+ "\t");
                        }
                        System.out.println("");
                    }
                }else if (problema == 3) {
                    System.out.println("La suma de matrices es: ");
                    for (int i = 0; i < Suma3.length; i++) {
                        for (int j = 0; j < Suma3[i].length; j++) {
                            System.out.print("[" + Suma3[i][j] + "]" + "\t");
                        }
                        System.out.println("");
                    }
                }
            } else if (medio > 2) {
                System.out.println("ya esta exonerado de las penalizaciones medias ");
            }
        }

        if (posicion > 40 && posicion <= 64) {
            if (dificil > 0 && dificil <= 2) {
                System.out.println("Tiene que realiar el problema " + problema + " de la seccion dififil ");
                System.out.println("");
                if (problema == 1) {
                    System.out.println("El resultado de la division de matrices es: ");
                    for (int i = 0; i < M1.length; i++) {
                        for (int j = 0; j < M1[i].length; j++) {
                            System.out.print("[" + M1[i][j] + "]" + "\t");
                        }
                        System.out.println("");
                    }
                }else if (problema == 2) {
                    System.out.println("El resultado de la division de matrices es: ");
                    for (int i = 0; i < M2.length; i++) {
                        for (int j = 0; j < M2[i].length; j++) {
                            System.out.print("[" + M2[i][j] + "]" + "\t");
                        }
                        System.out.println("");
                    }
                }else if (problema == 3) {
                    System.out.println("El resultado de la division de matrices es: ");
                    for (int i = 0; i < M3.length; i++) {
                        for (int j = 0; j < M3[i].length; j++) {
                            System.out.print("[" + M3[i][j] + "]" + "\t");
                        }
                        System.out.println("");
                    }
                }
            } else if (dificil > 2) {
                System.out.println("ya esta exonerado de las penalizaciones dificil"
                        + "+");
            }
        }

    }

    public static void suma() {
        for (int i = 0; i < M2_1.length; i++) {
            for (int j = 0; j < M2_1[i].length; j++) {
                Suma1[i][j] = M2_1[i][j] + M2_2[i][j];
            }
        }

        for (int i = 0; i < Suma1.length; i++) {
            for (int j = 0; j < Suma1[i].length; j++) {
                Suma2[i][j] = M2_3[i][j] + M2_4[i][j];
            }
        }

        for (int i = 0; i < M2_1.length; i++) {
            for (int j = 0; j < M2_1[i].length; j++) {
                Suma3[i][j] = M2_5[i][j] + M2_6[i][j];
            }
        }
    }

    //primera operacion
    static double B1;
    static double Betha1;
    static double Gamma1;
    //segunda operacion
    static double A2;
    static double Alpha2;
    static double Gamma2;
    //tercera operacion
    static double C3;
    static double Alpha3;
    static double Betha3;

    public static void OperacionesFaciles() {
        //primera operacion
        double A1 = 15;
        double C1 = 20;
        double Alpha1 = Math.toRadians(25);

        B1 = Math.round(Math.sqrt((Math.pow(A1, 2)) + (Math.pow(C1, 2)) - 2 * A1 * C1 * (Math.cos(Alpha1))) * 100) / 100;
        Betha1 = Math.round(Math.toDegrees(Math.acos(((Math.pow(C1, 2)) - (Math.pow(A1, 2)) - (Math.pow(B1, 2))) / (-2 * (A1) * (B1)))) * 100) / 100;
        Gamma1 = 180 - (Math.toDegrees(Alpha1)) - Betha1;

        double C2 = 25;
        double B2 = 10;
        double Betha2 = Math.toRadians(30);

        A2 = Math.round(Math.sqrt((Math.pow(B2, 2)) + (Math.pow(C2, 2)) - 2 * B2 * C2 * (Math.cos(Betha2))) * 100) / 100;
        Alpha2 = Math.round(Math.toDegrees(Math.acos(((Math.pow(B2, 2)) - (Math.pow(A2, 2)) - (Math.pow(C2, 2))) / (-2 * (A2) * (C2)))) * 100) / 100;
        Gamma2 = 180 - (Math.toDegrees(Betha2)) - Alpha2;

        double A3 = 18;
        double B3 = 25;
        double Gamma3 = Math.toRadians(30);

        C3 = Math.round(Math.sqrt((Math.pow(A3, 2)) + (Math.pow(B3, 2)) - 2 * A3 * B3 * (Math.cos(Gamma3))) * 100) / 100;
        Betha3 = Math.round(Math.toDegrees(Math.acos(((Math.pow(A3, 2)) - (Math.pow(B3, 2)) - (Math.pow(C3, 2))) / (-2 * (B3) * (C3)))) * 100) / 100;
        Alpha3 = 180 - (Math.toDegrees(Gamma3)) - Betha3;

    }

    public static void guardarinversa() {
        //funciond de inversa
        //matriz inversa 1
        In1 = inversa(M3_2);
        for (int i = 0; i < R1.length; i++) {
            for (int j = 0; j < R1[i].length; j++) {
                R1[i][j] = Math.round(In1[i][j] * 100.0) / 100.0;
            }
        }

        //matriz invesa 2
        In2 = inversa(M3_4);
        for (int i = 0; i < R1.length; i++) {
            for (int j = 0; j < R1[i].length; j++) {
                R2[i][j] = Math.round(In2[i][j] * 100.0) / 100.0;
            }
        }

        //matriz inversa 3
        In3 = inversa(M3_6);
        for (int i = 0; i < R3.length; i++) {
            for (int j = 0; j < R3[i].length; j++) {
                R3[i][j] = Math.round(In3[i][j] * 100.0) / 100.0;
            }
        }

    }

    public static double[][] inversa(double a[][]) {

        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i = 0; i < n; ++i) {
            b[i][i] = 1;
        }

        gaussina(a, index);

        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    b[index[j]][k] -= a[index[j]][i] * b[index[i]][k];
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            x[n - 1][i] = b[index[n - 1]][i] / a[index[n - 1]][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k = j + 1; k < n; ++k) {
                    x[j][i] -= a[index[j]][k] * x[k][i];
                }

                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

    public static void gaussina(double a[][], int index[]) 
    {

        int n = index.length;
        double c[] = new double[n];

        for (int i = 0; i < n; ++i) {
            index[i] = i;
        }

        for (int i = 0; i < n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) {
                    c1 = c0;
                }
            }
            c[i] = c1;
        }

        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            double pi1 = 0;
            for (int i = j; i < n; ++i) {

                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < n; ++i) {
                double pj = a[index[i]][j] / a[index[j]][j];

                a[index[i]][j] = pj;

                for (int l = j + 1; l < n; ++l) {
                    a[index[i]][l] -= pj * a[index[j]][l];
                }
            }
        }
    }

    static double[][] M1 = new double[4][4];
    static double[][] M2 = new double[4][4];
    static double[][] M3 = new double[4][4];

    public static void multilplicarIn() {

        for (int i = 0; i < M3_1.length; i++) {
            for (int j = 0; j < M3_1[i].length; j++) {
                for (int k = 0; k < M3_1[i].length; k++) {
                    M1[i][j] += M3_1[i][k] * In1[k][j];
                }
            }
        }

        for (int i = 0; i < M3_1.length; i++) {
            for (int j = 0; j < M3_1[i].length; j++) {
                for (int k = 0; k < M3_1[i].length; k++) {
                    M2[i][j] += M3_3[i][k] * In2[k][j];
                }
            }
        }

        for (int i = 0; i < M3_1.length; i++) {
            for (int j = 0; j < M3_1[i].length; j++) {
                for (int k = 0; k < M3_1[i].length; k++) {
                    M3[i][j] += M3_5[i][k] * In3[k][j];
                }
            }
        }
    }

    public static void reporte() {
        FileWriter fichero = null;
        PrintWriter pw = null;

        try {
            fichero = new FileWriter("Reporte.html");
            pw = new PrintWriter(fichero);

            pw.println("<!DOCTYPE html>");
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<meta charset = \"utf-8 \">");
            pw.println("<title>REPORTE DEL JUEGO</title>");
            pw.println("<style type = \"text/css\">");
            pw.println("body{\n"
                    + "	margin: 0;\n"
                    + "	font-family: Trebuchet MS, sans-serif;\n"
                    + "	background-color: #fefbe9;\n"
                    + "	background:linear-gradient(45deg,aqua,#02C7FF, #02A5FF , #0251FF , #022BFF, #6302FF,  #9402FF, #CA02FF ,#FF02F7);\n"
                    + "}\n"
                    + ".topnav {\n"
                    + "	overflow: hidden;\n"
                    + "	background-color: #DC143C;\n"
                    + "	text-align: center;\n"
                    + "}\n"
                    + "table {\n"
                    + "	border-collapse: collapse;\n"
                    + "	width: 50%;\n"
                    + "}\n"
                    + "td, th {\n"
                    + "	font-family: bahnschrift;\n"
                    + "	border: 1px solid #000;\n"
                    + "	text-align: center;\n"
                    + "	padding: 8px;\n"
                    + "}\n"
                    + "\n"
                    + "h2{\n"
                    + "	color: #000000;\n"
                    + "}"
                    + "</style>");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<div align=\"center\" class=\"topnav\"> \n"
                    + "	<h1 style = \"color: black; \">REPORTE</h1>"
                    + "	</div><br><br>");
            pw.println("<h2 align= \"center\" style=\" color: #000000;\">Operaciones Realizadas en toda la elaboracion del programa</h2>");

            pw.println("<div class=\"tabla_Clase\" align=\"center\" style=\"text-align: center;\">");
            //tablero del juego
            pw.println("<table align=\"center\">");
            pw.println("<tr>\n"
                    + "			<th colspan=\"8\" style=\"background-color: #000000; color: white;\">Tablero del Juego</th>\n"
                    + "		</tr>");

            boolean derecha = false;
            for (int i = 0; i < tablero.length; i++) {
                pw.println("<tr class = \"table-primary\">");
                if (derecha) {
                    for (int j = 0; j < tablero[i].length; j++) {
                        pw.println("<th>" + tablero[i][j] + "</th>");
                    }
                } else {
                    for (int j = tablero[i].length - 1; j >= 0; j--) {
                        pw.println("<th>" + tablero[i][j] + "</th>");
                    }
                }
                pw.println("</tr>");
                derecha = !derecha;
            }
            pw.println("</table>");
            pw.println("</div>");

            pw.println("<br></br>");

            //tablero de penalizaciones
            pw.println("<div>");
            pw.println("<table align=\"center\">");
            pw.println("<tr>\n<th colspan=\"8\" style=\"background-color: #000000; color: white;\">Tablero de penalizaciones del juego</th>\n</tr>");
            for (int i = 0; i < tablero2.length; i++) {
                pw.println("<tr class = \"table-primary\">");
                for (int j = 0; j < tablero2[i].length; j++) {
                    pw.println("<th>" + tablero2[i][j] + "</th>");
                }
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("<p align= \"center\">Donde el número 0 indica que no hay penalizaciones y el número 1 es que si hay penalización"
                    + "sabiendo que el maximo de penalizaciones por fila es de 4 y un minimo de 2.</p>");
            pw.println("</div>");
            pw.println("<br></br>");

            //Ley de coseno
            pw.println("<h2 align=\"center\" style =\"color: black;\">Calculos de la seccion facil del tablero</h2>");
            pw.println("<p align= \"center\">En esta parte se realizaron los calculos con la propiedad ade ley de consenos para encontrar los valores indicados en el problema.</p>");
            pw.println("<div>");
            pw.println("<table align=\"center\">");
            pw.println("<tr>\n<th colspan=\"2\" style=\"background-color: Black; color: white;\">Problema 1</th>\n</tr>");
            pw.println("<tr><th>Lado B</th> <th>" + B1 + "</th></tr>");
            pw.println("<tr><th>Angulo Betha </th> <th>" + Betha1 + "</th></tr>");
            pw.println("<tr><th>Angulo Gamma </th> <th>" + Gamma1 + "</th></tr>");
            pw.println("</table>");
            pw.println("</div>");
            pw.println("<br></br>");

            pw.println("<div>");
            pw.println("<table align=\"center\">");
            pw.println("<tr>\n<th colspan=\"2\" style=\"background-color: black; color: white;\">Problema 2</th>\n</tr>");
            pw.println("<tr><th>Lado A </th> <th>" + A2 + "</th></tr>");
            pw.println("<tr><th>Angulo Alpha </th> <th>" + Alpha2 + "</th></tr>");
            pw.println("<tr><th>Angulo Gamma </th> <th>" + Gamma2 + "</th></tr>");
            pw.println("</table>");
            pw.println("</div>");
            pw.println("<br></br>");

            pw.println("<div>");
            pw.println("<table align=\"center\">");
            pw.println("<tr>\n<th colspan=\"2\" style=\"background-color: black; color: white;\">Problema 3</th>\n</tr>");
            pw.println("<tr><th>Lado C </th> <th>" + C3 + "</th></tr>");
            pw.println("<tr><th>Angulo Alpha </th> <th>" + Alpha3 + "</th></tr>");
            pw.println("<tr><th>Angulo Betha </th> <th>" + Betha3 + "</th></tr>");
            pw.println("</table>");
            pw.println("</div>");

            pw.println("<br></br>");
            //suma de matrices
            pw.println("<h2 align=\"center\" style =\"color: black;\">Calculos de la seccion media</h2>");
            pw.println("<p align= \"center\">Se mostraran los calculos realizados con la suma de los 3 diferentes problemas de matrices </p>");

            pw.println("<div>");
            pw.println("<table align=\"center\">");
            pw.println("<tr>\n<th colspan=\"5\" style=\"background-color: black; color: white;\">Problema 1</th>\n</tr>");
            for (int i = 0; i < Suma1.length; i++) {
                pw.println("<tr class = \"table-primary\">");
                for (int j = 0; j < Suma1[i].length; j++) {
                    pw.println("<th>" + Suma1[i][j] + "</th>");
                }
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("</div>");
            pw.println("<br></br>");

            pw.println("<table align=\"center\">");
            pw.println("<tr>\n<th colspan=\"5\" style=\"background-color: black; color: white;\">Problema 2</th>\n</tr>");
            for (int i = 0; i < Suma2.length; i++) {
                pw.println("<tr class = \"table-primary\">");
                for (int j = 0; j < Suma2[i].length; j++) {
                    pw.println("<th>" + Suma2[i][j] + "</th>");
                }
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("</div>");
            pw.println("<br></br>");

            pw.println("<table align=\"center\">");
            pw.println("<tr>\n<th colspan=\"5\" style=\"background-color: black; color: white;\">Problema 3</th>\n</tr>");
            for (int i = 0; i < Suma3.length; i++) {
                pw.println("<tr class = \"table-primary\">");
                for (int j = 0; j < Suma3[i].length; j++) {
                    pw.println("<th>" + Suma3[i][j] + "</th>");
                }
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("</div>");
            pw.println("<br></br>");

            pw.println("<h2 align = \"center\">Calculos de la seccion dificil</h2>");
            pw.println("<p align = \"center\">Se mostrara el resultado de la division de matrices.</p>");
            pw.println("<table align=\"center\">");
            pw.println("<tr>\n<th colspan=\"5\" style=\"background-color: black; color: white;\">Problema 1</th>\n</tr>");
            for (int i = 0; i < R1.length; i++) {
                pw.println("<tr class = \"table-primary\">");
                for (int j = 0; j < M1[i].length; j++) {
                    pw.println("<th>" + M1[i][j] + "</th>");
                }
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("</div>");
            pw.println("<br></br>");

            pw.println("<table align=\"center\">");
            pw.println("<tr>\n<th colspan=\"5\" style=\"background-color: black; color: white;\">Problema 2</th>\n</tr>");
            for (int i = 0; i < R2.length; i++) {
                pw.println("<tr class = \"table-primary\">");
                for (int j = 0; j < R2[i].length; j++) {
                    pw.println("<th>" + M2[i][j] + "</th>");
                }
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("</div>");
            pw.println("<br></br>");

            pw.println("<table align=\"center\">");
            pw.println("<tr>\n<th colspan=\"5\" style=\"background-color: black; color: white;\">Problema 3</th>\n</tr>");
            for (int i = 0; i < R3.length; i++) {
                pw.println("<tr class = \"table-primary\">");
                for (int j = 0; j < R3[i].length; j++) {
                    pw.println("<th>" + M3[i][j] + "</th>");
                }
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("</div>");
            pw.println("<br></br>");
            pw.println("<p align  = \"center\">Gracias por jugar, espero que te la pasras de lo mejor, vuelve pronto!!!</p>");
            pw.println("<br></br>");
            pw.println("<br></br>");
            pw.println("</body>");
            pw.println("</html>");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }
}