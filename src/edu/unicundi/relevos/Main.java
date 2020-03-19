/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.relevos;
import edu.unicundi.relevos.Equipo;

/**
 *
 * @author Andres Gomez-Ruby Cardenas
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Equipo equipo = new Equipo();
        int salida = 0;
        int primerRelevo = 20;
        int segundoRelevo = 40;
        int meta = 60;
        
        Equipo equipo1 = new Equipo("Cachacos");  // Rojo
        Equipo equipo2 = new Equipo("Antioqueños"); //Verde
        Equipo equipo3 = new Equipo("Llaneros"); //Amarillo
        
        Corredor corredor1Equipo1 = new Corredor(salida, primerRelevo, equipo1);
        Corredor corredor2Equipo1 = new Corredor(primerRelevo, segundoRelevo, equipo1);
        Corredor corredor3Equipo1 = new Corredor(segundoRelevo, meta, equipo1);
        
        Corredor corredor1Equipo2 = new Corredor(salida, primerRelevo, equipo2);
        Corredor corredor2Equipo2 = new Corredor(primerRelevo, segundoRelevo, equipo2);
        Corredor corredor3Equipo2 = new Corredor(segundoRelevo, meta, equipo2);
        
        Corredor corredor1Equipo3 = new Corredor(salida, primerRelevo, equipo3);
        Corredor corredor2Equipo3 = new Corredor(primerRelevo, segundoRelevo, equipo3);
        Corredor corredor3Equipo3 = new Corredor(segundoRelevo, meta, equipo3);
        
        corredor1Equipo1.start();
        corredor2Equipo1.start();
        corredor3Equipo1.start();
        
        corredor1Equipo2.start();
        corredor2Equipo2.start();
        corredor3Equipo2.start();
        
        corredor1Equipo3.start();
        corredor2Equipo3.start();
        corredor3Equipo3.start();
        
        System.out.println("¡FELICIDADES EQUIPO " + equipo.getNombreEquipo() + "HAN GANADO LA CARRERA POR RELEVOS!");
           
       System.exit(0);
        
    }
}
