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
 *
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Inicialización de variables
        int salida = 0;
        int primerRelevo = 20;
        int segundoRelevo = 40;
        int meta = 60;

        try {
            //MENSAJE DE BIENVENIDA
            System.out.println("");
            System.out.println("                       !BIENVENIDOS A LA COMPETENCIA ANUAL DE RELEVOS¡");
            System.out.println("                                  DESAFIO SUPER REGIONES 2020         ");
            System.out.println("");
            Thread.sleep(3 * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Creacion de los Equipos
        Equipo equipo1 = new Equipo("Cachacos    ");
        Equipo equipo2 = new Equipo("Antioqueños ");
        Equipo equipo3 = new Equipo("Llaneros    ");

        //Creacion de los Corredores
        Corredor corredor1Equipo1 = new Corredor(salida, primerRelevo, equipo1);
        Corredor corredor2Equipo1 = new Corredor(primerRelevo, segundoRelevo, equipo1);
        Corredor corredor3Equipo1 = new Corredor(segundoRelevo, meta, equipo1);

        Corredor corredor1Equipo2 = new Corredor(salida, primerRelevo, equipo2);
        Corredor corredor2Equipo2 = new Corredor(primerRelevo, segundoRelevo, equipo2);
        Corredor corredor3Equipo2 = new Corredor(segundoRelevo, meta, equipo2);

        Corredor corredor1Equipo3 = new Corredor(salida, primerRelevo, equipo3);
        Corredor corredor2Equipo3 = new Corredor(primerRelevo, segundoRelevo, equipo3);
        Corredor corredor3Equipo3 = new Corredor(segundoRelevo, meta, equipo3);

        //Inicialización de los Hilos
        corredor1Equipo1.start();
        corredor2Equipo1.start();
        corredor3Equipo1.start();

        corredor1Equipo2.start();
        corredor2Equipo2.start();
        corredor3Equipo2.start();

        corredor1Equipo3.start();
        corredor2Equipo3.start();
        corredor3Equipo3.start();

    }

}
