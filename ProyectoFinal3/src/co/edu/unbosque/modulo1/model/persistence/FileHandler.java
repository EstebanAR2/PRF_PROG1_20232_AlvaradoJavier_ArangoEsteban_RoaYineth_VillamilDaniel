package co.edu.unbosque.modulo1.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * FileHandler proporciona metodos para la manipulacion de archivos serializados.
 */
public class FileHandler {
    /** Entrada para la lectura de archivos. */
    private static FileInputStream fis;
    /** Objeto para la lectura de objetos desde la entrada. */
    private static ObjectInputStream ois;
    /** Salida para la escritura de archivos. */
    private static FileOutputStream fos;
    /** Objeto para la escritura de objetos en la Salida. */
    private static ObjectOutputStream oos;

    /**
     * Constructor vacio de la clase FileHandler.
     */
    public FileHandler() {

    }

    /**
     * Abre y lee un archivo serializado.
     * @param fileName El nombre del archivo a abrir y leer.
     * @return El objeto leído desde el archivo serializado.
     */
    public static Object serializableOpenAndReadFile(String fileName) {
        try {
            fis = new FileInputStream(new File(fileName));
        } catch (FileNotFoundException e) {
            try {
                System.out.println("Archivo serializado no encontrado, creándolo ahora.");
                File temp = new File(fileName);
                temp.createNewFile();
                fis = new FileInputStream(temp);
            } catch (IOException e1) {
                System.out.println("Error: no se pudo crear el archivo serializado.");
                e1.printStackTrace();
            }
        }
        Object content = null;
        try {
            ois = new ObjectInputStream(fis);
            content = ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.out.println("No se pudo leer en el archivo serializado (input).");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Error al obtener el contenido.");
            e.printStackTrace();
        }
        return content;
    }

    /**
     * Abre y escribe en un archivo serializado.
     * @param fileName El nombre del archivo a abrir y escribir.
     * @param content  El objeto a escribir en el archivo serializado.
     */
    public static void serializableOpenAndWriteFile(String fileName, Object content) {

        try {
            fos = new FileOutputStream(new File(fileName));
        } catch (FileNotFoundException e) {
            File temp = new File(fileName);
            try {
                fos = new FileOutputStream(temp);
            } catch (FileNotFoundException e1) {
                System.out.println("Problemas al crear o buscar el archivo serializado (escritura).");
                e1.printStackTrace();
            }
        }
        try {
            oos = new ObjectOutputStream(fos);
            oos.writeObject(content);
            oos.close();
        } catch (IOException e) {
            System.out.println("Problemas al abrir el archivo serializado (escritura).");
            e.printStackTrace();
        }
    }

}
