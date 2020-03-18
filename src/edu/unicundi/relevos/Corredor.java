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
            while (true) {
                posicionActual = 1;
                if (posicionActual >= 20) {
                    synchronized (equipo) {
                        equipo.notifyAll();
                    }
                    break;
                } else {
                    synchronized (equipo) {
                        try {
                            equipo.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

                if (posicionActual == 20) {
                    while (true) {

                        if (posicionActual >= 20) {
                            equipo.setPosicionCorredor2(20);

                            synchronized (equipo) {
                                equipo.notifyAll();
                            }
                            break;
                        }
                    }
                }
            }
        }

    }

    public void correr() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Equipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        int pasos = (int) Math.floor(Math.random() * 6 + 1);
        switch (posicionActual) {
            case 1:
                equipo.setPosicionCorredor1(equipo.getPosicionCorredor1() + pasos);
                break;

            case 2:
                equipo.setPosicionCorredor2(equipo.getPosicionCorredor1() + pasos);
                break;
            case 3:
                equipo.setPosicionCorredor3(equipo.getPosicionCorredor1() + pasos);
                break;
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
