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
 * @author Andres Gomez-Ruby Cardenas
 */
public class Corredor extends Thread {

    private String equipo1;
    private String equipo2;
    private String equipo3;
    private int posicion1;
    private int posicion2;
    Equipo equipo;
    private int posicionActual;

    public Corredor(int posicion1, int posicion2, Equipo equipo) {
        this.equipo = equipo;
        this.posicion1 = posicion1;
        this.posicion2 = posicion2;
    }

    @Override
    public void run() {
        if (posicion1 == 0) {
            corredorUno();
        } else {
            esperaJugadores();
        }
        if (posicion1 == 20) {
            corredorDos();
        } else {
            esperaJugadores();
        }
        if (posicion1 == 60) {
            corredorTres();
        } else {
            esperaJugadores();
        }

    }

    public void corredorUno() {
        while (true) {
            posicionActual=1;
            int pasoActual = correr();
            if (pasoActual >= 20) {
                equipo.setPosicionCorredor1(20);
                synchronized (equipo) {
                    equipo.notifyAll();
                }
                break;
            }
        }
    }

    public void corredorDos() {
        while (true) {
            posicionActual=2;
            int pasoActual = correr();
            if (pasoActual >= 40) {
                equipo.setPosicionCorredor2(40);
                synchronized (equipo) {
                    equipo.notifyAll();
                }
                break;
            }
        }
    }

    public void corredorTres() {
        posicionActual=3;
        while (true) {
            int pasoActual = correr();
            if (pasoActual >= 60) {
                equipo.setPosicionCorredor3(60);

                if (equipo.getNombreEquipo().equals("Cachacos")) {
                    equipo.setNombreEquipo("Cachacos");

                } else if (equipo.getNombreEquipo().equals("Antioqueños")) {
                    equipo.setNombreEquipo("Antioqueños");

                } else if (equipo.getNombreEquipo().equals("Llaneros")) {
                    equipo.setNombreEquipo("Llaneros");

                }
                    equipo.getNombreEquipo();
                //System.exit(0);
            }
        }
    }

    public int correr() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException ex) {
            Logger.getLogger(Equipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        int pasos = (int) Math.floor(Math.random() * 6 + 1);
        switch (posicionActual) {
            case 1:
                equipo.setPosicionCorredor1(equipo.getPosicionCorredor1() + pasos);
                equipos();
                return equipo.getPosicionCorredor1();

            case 2:
                equipo.setPosicionCorredor2(equipo.getPosicionCorredor1() + pasos);
                equipos();
                return equipo.getPosicionCorredor2();

            case 3:
                equipo.setPosicionCorredor3(equipo.getPosicionCorredor1() + pasos);
                equipos();
                return equipo.getPosicionCorredor3();
        }
        return 0;
    }

    public void equipos() {
        switch (equipo.imprimirPosicion()) {
            case "Cachacos":
                equipo1 = equipo.imprimirPosicion();
                System.out.println(equipo1);
                break;

            case "Antioqueños":
                equipo2 = equipo.imprimirPosicion();
                System.out.println(equipo2);
                break;
            case "Llaneros":
                equipo3 = equipo.imprimirPosicion();
                System.out.println(equipo3);
                System.out.println();
                System.out.println();
                System.out.println();
        }
    }

    public void esperaJugadores() {
        synchronized (equipo) {
            try {
                equipo.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
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
