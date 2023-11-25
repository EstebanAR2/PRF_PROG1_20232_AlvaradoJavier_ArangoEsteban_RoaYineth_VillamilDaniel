package co.edu.unbosque.modulo1.model.persistence;

/**
 * La interfaz CRUDOperation define las operaciones basicas de creacion, lectura, actualizacion y eliminacion (CRUD).
 */
public interface CRUDOperation {

    /**
     * Crea un nuevo objeto utilizando los datos proporcionados.
     * @param args Los datos de tipo String necesarios para la creación del objeto.
     */
    public void create(String... args);

    /**
     * Lee y devuelve una representacion en cadena de todos los datos almacenados.
     * @return Una cadena que contiene la lectura de todos los datos.
     */
    public String readData();

    /**
     * Actualiza los datos de un objeto en la posición especificada del conjunto de datos.
     * @param index La posicion del objeto en la lista de datos.
     * @param args  Los nuevos datos de tipo String para la actualizacion del objeto.
     * @return true si la actualizacion fue exitosa, false si el indice está fuera de rango.
     */
    public boolean update(int index, String... args);

    /**
     * Elimina un objeto del conjunto de datos en la posicion especificada.
     * @param index La posicion del objeto en el conjunto de datos.
     * @return true si la eliminacion fue exitosa, false si el indice está fuera de rango.
     */
    public boolean delete(int index);

}
