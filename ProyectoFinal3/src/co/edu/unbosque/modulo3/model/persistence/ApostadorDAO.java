package co.edu.unbosque.modulo3.model.persistence;
import java.util.ArrayList;

import co.edu.unbosque.modulo1.model.persistence.CRUDOperation;
import co.edu.unbosque.modulo1.model.persistence.FileHandler;
import co.edu.unbosque.modulo3.model.ApostadorDTO;



/**
 * ApostadorDAO implementa la interfaz CRUDOperation y proporciona
 * métodos para realizar operaciones CRUDen la lista de apostadores.
 */
public class ApostadorDAO implements CRUDOperation {

    /** Lista que almacena los objetos ApostadorDTO. */
    private ArrayList<ApostadorDTO> listaApostadores;
    /** Ruta del archivo serializado que almacena los datos de los apostadores. */
    public final String SERIAL_FILENAME = "src/co/edu/unbosque/modulo3/model/persistence/apostadores.dat";
    /** Índice utilizado para realizar un seguimiento de la posición en la lista de apostadores. */
    int index = 0;

    /**
     * Constructor de la clase ApostadorDAO. Inicializa la lista de apostadores
     * y carga los datos desde el archivo serializado si existe.
     */
    public ApostadorDAO() {
        listaApostadores = new ArrayList<>();
        if (FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME) != null) {
            Object temp = FileHandler.serializableOpenAndReadFile(SERIAL_FILENAME);
            @SuppressWarnings("unchecked")
            ArrayList<ApostadorDTO> temp2 = (ArrayList<ApostadorDTO>) temp;
            listaApostadores = temp2;
        } else {
            listaApostadores = new ArrayList<>();
        }
    }

    /**
     * Guarda la lista de apostadores en un archivo serializado.
     */
    public void writeSerializable() {
        FileHandler.serializableOpenAndWriteFile(SERIAL_FILENAME, listaApostadores);
    }

    /**
     * Crea un nuevo apostador con los datos proporcionados y lo agrega a la lista.
     * @param args Arreglo de Strings con los datos del nuevo apostador.
     */
	@Override
	public void create(String... args) {
		ApostadorDTO newApostador = new ApostadorDTO();
		newApostador.setNombre(args[0]);
		newApostador.setCedula(Long.parseLong(args[1]));
		newApostador.setSede(args[2]);
		newApostador.setDireccion(args[3]);
		newApostador.setCelular(Long.parseLong(args[4]));
		newApostador.setUsuario(args[5]);
		newApostador.setContrasena(args[6]);
		listaApostadores.add(newApostador);
		writeSerializable();
	}
	
    /**
     * Método para iniciar sesión de un apostador.
     * @param usuario   Nombre de usuario del apostador.
     * @param contrasena Contraseña del apostador.
     * @return Objeto ApostadorDTO si las credenciales son válidas, null de lo contrario.
     */
	public ApostadorDTO iniciarSesion(String usuario, String contrasena) {
        for (ApostadorDTO a : listaApostadores) {
            if (a.getUsuario().equals(usuario) && a.getContrasena().equals(contrasena)) {
                return a; 
            }
        }
        return null; 
	}
	
    /**
     * Obtiene la posición de un apostador en la lista.
     * @param apostador ApostadorDTO cuya posición se desea conocer.
     * @return Posición del apostador en la lista.
     */
    public int obtenerPosicionApostador(ApostadorDTO apostador) {
        return listaApostadores.indexOf(apostador);
    }
	
    /**
     * Comprueba si ya existe un registro con el mismo nombre de usuario o cédula.
     * @param usuario Nombre de usuario a comprobar.
     * @param cedula  Cédula a comprobar.
     * @return true si ya existe un registro con el mismo nombre de usuario o cédula, false de lo contrario.
     */
    public boolean comprobarRegistro(String usuario, long cedula) {
        for (ApostadorDTO u : listaApostadores) {
            if (u.getUsuario().equals(usuario) || u.getCedula() == cedula) {
                return true;
            }
        }
        return false;
    }

    /**
     * Lee y devuelve una representación en cadena de los apostadores en la lista.
     * @return Cadena con la información de los apostadores.
     */
	@Override
	public String readData() {
		index = 0;
		StringBuilder sb = new StringBuilder();
		listaApostadores.forEach(apostador -> {
			sb.append(index+1 + " -> " + (apostador.toString() + "\n"));
			index++;
		});
		return sb.toString();
	}

    /**
     * Actualiza los datos de un apostador en la lista en la posición dada.
     * @param index Posición del apostador en la lista.
     * @param args  Arreglo de Strings con los nuevos datos del apostador.
     * @return true si la actualización fue exitosa, false si la posición es inválida.
     */
	@Override
	public boolean update(int index, String... args) {
		if (index < 0 || index >= listaApostadores.size()) {
			return false;
		} else {
			if (!args[0].isBlank() || !args[0].isEmpty()) {
				listaApostadores.get(index).setNombre(args[0]);
			}
			if (!args[1].isBlank() || !args[1].isEmpty() || !args[1].equals("")) {
				listaApostadores.get(index).setCedula(Long.parseLong(args[1]));
			}
			if (!args[2].isBlank() || !args[2].isEmpty()) {
				listaApostadores.get(index).setSede(args[2]);
			}
			if (!args[3].isBlank() || !args[3].isEmpty() || !args[3].equals("")) {
				listaApostadores.get(index).setDireccion(args[3]);
			}
			if (!args[4].isBlank() || !args[4].isEmpty() || !args[4].equals("")) {
				listaApostadores.get(index).setCelular(Long.parseLong(args[4]));
			}
			if (!args[5].isBlank() || !args[5].isEmpty()) {
				listaApostadores.get(index).setUsuario(args[5]);
			}
			if (!args[6].isBlank() || !args[6].isEmpty()) {
				listaApostadores.get(index).setContrasena(args[6]);
			}
			writeSerializable();
			return true;
		}
	}

    /**
     * Elimina un apostador de la lista en la posición dada.
     * @param index Posición del apostador en la lista.
     * @return true si la eliminación fue exitosa, false si la posición es inválida.
     */
	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= listaApostadores.size()) {
			return false;
		} else {
			listaApostadores.remove(index);
			writeSerializable();
			return true;
		}
		
	}

    /**
     * Obtiene la lista de apostadores.
     * @return Lista de apostadores.
     */
    public ArrayList<ApostadorDTO> getListaApostadores() {
        return listaApostadores;
    }

    /**
     * Establece la lista de apostadores con la proporcionada.
     * @param listaApostadores Nueva lista de apostadores.
     */
    public void setListaApostadores(ArrayList<ApostadorDTO> listaApostadores) {
        this.listaApostadores = listaApostadores;
    }
	
}
