package co.edu.unbosque.controller;
import java.io.IOException;

/**
 * Clase principal que inicia el programa.
* @author Fernando Alvarado, Yineth Roa, Daniel Villamil, Esteban Arango
*/
public class AplMain {

   /**
    * El metodo main es el punto de entrada principal para el programa.
    * Crea una instancia de Controller y ejecuta su metodo run.
    * 
    * @param args (no se utilizan en este caso).
    * @throws IOException En caso de que ocurra un error en el proceso de manejo de archivos
    */
   public static void main(String[] args) throws IOException {
       
	   Controller c = new Controller();
       c.run();
   }

}
