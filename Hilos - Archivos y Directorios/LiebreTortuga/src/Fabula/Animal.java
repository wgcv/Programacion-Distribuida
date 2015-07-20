/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fabula;

/**
 *
 * @author Estudiante
 */
public class Animal {
    String nombre;
    int velocidad;
    public Animal(String nombre, int velocidad){
        this.nombre = nombre;
        this.velocidad = velocidad;
        
    }
    public void sleep(int timepo){
        for(int i =0; i<timepo;i++){
            ;
        }
        
    }
    public void run(){
        for (int i=0;i<10;i++){
            System.out.print(nombre);
            sleep(1000/velocidad);
            
        }
        System.out.println("\n"+nombre+" ha llegado!!!");
        
    }
}
