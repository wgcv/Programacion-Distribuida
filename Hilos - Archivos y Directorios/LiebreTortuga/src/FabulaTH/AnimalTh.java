/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FabulaTH;

/**
 *
 * @author Estudiante
 */
public class AnimalTh extends Thread {
    String nombre;
    int velocidad;
    public AnimalTh(String nombre, int velocidad){
        this.nombre = nombre;
        this.velocidad = velocidad;
        
    }
   /* public void sleep(int timepo){
        for(int i =0; i<timepo;i++){
            ;
        }
        
    }*/
    
    public void run(){
        for (int i=0;i<10;i++){
            System.out.print(nombre);
            try {            System.out.print(nombre);

                Thread.sleep(1000/velocidad);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("\n"+nombre+" ha llegado!!!");
        
    }
}
