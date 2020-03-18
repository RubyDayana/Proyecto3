/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.relevos;

/**
 *
 * @author PIPE
 */
public class Equipo {
    private String nombreEquipo;    
    private int posicionCorredor1;
    private int posicionCorredor2;
    private int posicionCorredor3;    
    private int posicion;

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.posicionCorredor1=0;
        this.posicionCorredor2=20;
        this.posicionCorredor3=40;
        
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

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    
    
    
}
