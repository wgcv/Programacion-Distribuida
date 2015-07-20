/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fabula;

import Fabula.Fabula;
import Fabula.Animal;

/**
 *
 * @author Estudiante
 */
public class Fabula {

    /**
     * @param args the command line arguments
     */
    
    public Fabula(){
        // ---- Creando una liebre
        Animal laliebre = new Animal("L",5);
        Animal latortuga = new Animal("T", 1);
        latortuga.run();
        laliebre.run();
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Fabula f = new Fabula();
    }
    
}
