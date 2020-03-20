/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.relevos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres Gomez-Ruby Cardenas la clase corredor lidera la ejecución de
 * los hilos.
 */
public class Corredor extends Thread {

    private String equipo1;
    private String equipo2;
    private String equipo3;
    private int posicion1;
    private int posicion2;
    Equipo equipo;
    private static final int testigo1 = 20;
    private static final int testigo2 = 40;
    private static final int testigo3 = 60;
    private static final int salida1 = 1;
    private static final int salida2 = 2;
    private static final int salida3 = 3;

    public Corredor(int posicion1, int posicion2, Equipo equipo) {
        this.equipo = equipo;
        this.posicion1 = posicion1;
        this.posicion2 = posicion2;
    }

    /*
     Método que arranca los hilos.
     */
    @Override
    public void run() {
        if (posicion1 == 0) {
            corredorUno();
        } else {
            corredoresEnEspera();
        }
        if (posicion1 == testigo2) {
            corredorDos();
        } else {
            corredoresEnEspera();
        }
        if (posicion1 == testigo2) {
            corredorTres();
        } else {
            corredoresEnEspera();
        }

    }

    /*
     Método que asigna la cantidad de pasos que da cada corredor según un número aleatorio.
     */
    public int correr(int posicionActual) {

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Equipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        int pasos = (int) (Math.random() * 5 + 1);

        switch (posicionActual) {
            case 1:
                equipo.setPosicionCorredor1(equipo.getPosicionCorredor1() + pasos);

                if (equipo.getPosicionCorredor1() > testigo1) {
                    equipo.setPosicionCorredor1(testigo1);
                }
                equipos();
                return equipo.getPosicionCorredor1();

            case 2:
                equipo.setPosicionCorredor2(equipo.getPosicionCorredor2() + pasos);
                if (equipo.getPosicionCorredor2() > testigo2) {
                    equipo.setPosicionCorredor2(testigo2);
                }
                equipos();
                return equipo.getPosicionCorredor2();

            case 3:
                equipo.setPosicionCorredor3(equipo.getPosicionCorredor3() + pasos);
                equipos();
                return equipo.getPosicionCorredor3();
        }

        return 0;
    }

    /*
     Método que determina a que equipo pertenece cada corredor para poder imprimir la posición.
     */
    public void equipos() {

        if (equipo.imprimirPosicion().contains("Cachacos    ")) {
            equipo1 = equipo.imprimirPosicion();
            System.out.println(equipo1);
        } else if (equipo.imprimirPosicion().contains("Antioqueños ")) {
            equipo2 = equipo.imprimirPosicion();
            System.out.println(equipo2);
        } else if (equipo.imprimirPosicion().contains("Llaneros    ")) {
            equipo3 = equipo.imprimirPosicion();
            System.out.println(equipo3);
            System.out.println();
        }
    }

    /*
     Metodo que inhabilita a dos de los tres corredores.
     */
    public void corredoresEnEspera() {
        synchronized (equipo) {
            try {
                equipo.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /*
     Método que permite al primer corredor de cada equipo avanzar hasta la seguda posición.
     */
    public void corredorUno() {
        while (true) {

            int paso = correr(salida1);
            if (paso >= testigo1) {
                equipo.setPosicionCorredor1(testigo1);
                synchronized (equipo) {
                    equipo.notifyAll();
                }
                break;
            }
        }
    }

    /*
     Método que permite al segundo corredor de cada equipo avanzar hasta la tercera posición.
     */
    public void corredorDos() {
        while (true) {

            int paso = correr(salida2);
            if (paso >= testigo2) {
                equipo.setPosicionCorredor2(testigo2);
                synchronized (equipo) {
                    equipo.notifyAll();
                }
                break;
            }
        }
    }
    
    /*
    Método que permite al tercer corredor de cada equipo avanzar hasta la Meta.
    */
    public void corredorTres() {

        while (true) {
            int paso = correr(salida3);
            if (paso >= testigo3) {
                equipo.setPosicionCorredor3(testigo3);

                switch (equipo.getNombreEquipo()) {
                    case "Cachacos    ":
                        equipo.setNombreEquipo("Cachacos    ");
                        break;
                    case "Antioqueños ":
                        equipo.setNombreEquipo("Antioqueños ");
                        break;
                    case "Llaneros    ":
                        equipo.setNombreEquipo("Llaneros    ");
                        break;
                }
                String colorGanador = equipo.getColor();
                System.out.println(colorGanador + " ");
                System.out.println(colorGanador + " " + equipo.getNombreEquipo().toUpperCase() + " HAN GANADO LA COMPETENCIA POR RELEVOS...  ");
                System.out.println(colorGanador + " ¡FELICITACIONES!");
                System.out.println(colorGanador + " ");
                System.exit(0);

            }
        }
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public String getEquipo3() {
        return equipo3;
    }

    public void setEquipo3(String equipo3) {
        this.equipo3 = equipo3;
    }

    public int getPosicion1() {
        return posicion1;
    }

    public void setPosicion1(int posicion1) {
        this.posicion1 = posicion1;
    }

    public int getPosicion2() {
        return posicion2;
    }

    public void setPosicion2(int posicion2) {
        this.posicion2 = posicion2;
    }

}
