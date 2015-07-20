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
public class FabulaTh {

    /**
     * @param args the command line arguments
     */
    
    public FabulaTh(){
        // ---- Creando una liebre
        AnimalTh laliebre = new AnimalTh("L",5);
        AnimalTh latortuga = new AnimalTh("T", 1);
        latortuga.start();
        laliebre.start();
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        FabulaTh f = new FabulaTh();
    }
    
}
