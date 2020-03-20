/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.relevos;

/**
 *
 * @author Andres Gomez-Ruby Cardenas
 */
public class Equipo {

    private String nombreEquipo;
    private int posicionCorredor1;
    private int posicionCorredor2;
    private int posicionCorredor3;
    private String posicion;
    
    private String color=null;

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.posicionCorredor1 = 0;
        this.posicionCorredor2 = 20;
        this.posicionCorredor3 = 40;

    }

    public Equipo() {

    }

    
    public synchronized String imprimirPosicion() {
        switch (nombreEquipo) {
            case "Cachacos":
                color = "\033[31m";
                break;
            case "Antioqueños":
                color = "\033[32m";
                break;
            case "Llaneros":
                color = "\033[33m";
                break;
        }
        posicion = color + "Equipo: " + nombreEquipo;
        for (int j = 0; j <= 60; j++) {
           
            if (j == posicionCorredor1 && nombreEquipo.contains("Cachacos")) {
                posicion += "C";
            } else if (j == posicionCorredor2 && nombreEquipo.contains("Cachacos")) {
                posicion += "C";
            } else if (j == posicionCorredor3 && nombreEquipo.contains("Cachacos")) {
                posicion += "C";
            } else if (j == posicionCorredor1 && nombreEquipo.contains("Antioqueños")) {
                posicion += "A";
            } else if (j == posicionCorredor2 && nombreEquipo.contains("Antioqueños")) {
                posicion += "A";
            } else if (j == posicionCorredor3 && nombreEquipo.contains("Antioqueños")) {
                posicion += "A";
            } else if (j == posicionCorredor1 && nombreEquipo.contains("Llaneros")) {
                posicion += "L";
            } else if (j == posicionCorredor2 && nombreEquipo.contains("Llaneros")) {
                posicion += "L";
            } else if (j == posicionCorredor3 && nombreEquipo.contains("Llaneros")) {
                posicion += "L";
            } else {
                posicion += ".";
            }
        }
        return posicion;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getPosicionCorredor1() {
        return posicionCorredor1;
    }

    public void setPosicionCorredor1(int posicionCorredor1) {
        this.posicionCorredor1 = posicionCorredor1;
    }

    public int getPosicionCorredor2() {
        return posicionCorredor2;
    }

    public void setPosicionCorredor2(int posicionCorredor2) {
        this.posicionCorredor2 = posicionCorredor2;
    }

    public int getPosicionCorredor3() {
        return posicionCorredor3;
    }

    public void setPosicionCorredor3(int posicionCorredor3) {
        this.posicionCorredor3 = posicionCorredor3;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

}
