/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Estudiante
 */
public class ListandoDirectorio {

    String dirname = "..\\..\\joeL";

    ListandoDirectorio() {
        File directorio = new File(dirname);
        if (!directorio.exists()) {
            System.out.println("error no existe " + dirname);
            return;
        }
        if (!directorio.isDirectory()) {
            System.out.println("error " + dirname + " no es un directorio");
            return;
        }
        String[] nombres = directorio.list();
        try {
            System.out.println("abspath: " + directorio.getAbsolutePath());
            System.out.println("canpath: " + directorio.getCanonicalPath());
            System.out.println("name: " + directorio.getAbsoluteFile());
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i]);
        }
    }

    public static void main(String[] args) {
        ListandoDirectorio ld = new ListandoDirectorio();
    }
}
