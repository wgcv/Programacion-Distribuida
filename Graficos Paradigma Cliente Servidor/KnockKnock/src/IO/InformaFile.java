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
public class InformaFile {
    public static void main( String args[] ) throws IOException {
// Se comprueba que nos han indicado alg�n fichero
       args = new String[2];
        args[0] = "C:\\Users\\CIDT Soporte Tecnico\\Documents\\GIS DataBase\\nc_spm_08";
        args[1] = "C:\\eclipse\\eclipse.exe";
if( args.length > 0 ) {
// Vamos comprobando cada uno de los ficheros que se hayan pasado
// en la l�nea de comandos
for( int i=0; i < args.length; i++ ) {
// Se crea un objeto File para tener una referencia al fichero
// f�sico del disco
File f = new File( args[i] );
// Se presenta el nombre y directorio donde se encuentra
System.out.println( "Nombre: "+f.getName() );
System.out.println( "Camino: "+f.getPath() );
// Si el fichero existe se presentan los permisos de lectura y
// escritura y su longitud en bytes
if( f.exists() ) {
System.out.print( "Fichero existente" );
System.out.print( (f.canRead() ? " y se puede Leer" : "" ) );
System.out.print( (f.canWrite() ? " y se puese Escribir" : "" ) );
System.out.println( "." );
System.out.println( "La longitud del fichero es de "+
f.length()+" bytes" );
}
else {
System.out.println( "El fichero no existe." );
}
}
}
else {
System.out.println( "Debe indicar un fichero." );
}
}
}
