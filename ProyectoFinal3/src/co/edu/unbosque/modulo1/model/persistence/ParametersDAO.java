package co.edu.unbosque.modulo1.model.persistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import co.edu.unbosque.modulo1.model.ParametersDTO;



/**
 * ParametersDAO gestiona la carga y almacenamiento de parametros de la casa de apuestas utilizando un archivo de propiedades.
 */
public class ParametersDAO {
    /** Mensaje de comentario para indicar que los parametros se han modificado con exito. */
    private static final String COMMENT = "Se han modificado los parametros con exito";
    /** Propiedades para cargar y almacenar datos de la casa de apuestas. */
    private Properties prop;
    /** Ruta del archivo de configuración. */
    private String config = "src/co/edu/unbosque/modulo1/model/persistence/config.properties";

    /**
     * Constructor de la clase ParametersDAO.
     * Inicializa las propiedades.
     */
    public ParametersDAO() {
        prop = new Properties();
    }

    /**
     * Constructor que permite especificar la ruta del archivo de configuracion.
     * @param config La ruta del archivo de configuracion.
     */
    public ParametersDAO(String config) {
        this.config = config;
    }

    /**
     * Carga los parametros desde el archivo de configuracion y devuelve un objeto ParametersDTO.
     * @return Un objeto ParametersDTO con los parámetros cargados.
     * @throws IOException Si ocurre un error durante la lectura del archivo.
     */
    public ParametersDTO cargarParametros() throws IOException {
        if (prop == null) {
            prop = new Properties();
            try {
                prop.load(new BufferedReader(new FileReader("src/co/edu/unbosque/modulo1/model/persistence/config.properties")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        prop.load(new FileReader(config));

        ParametersDTO par = new ParametersDTO();
        par.setShopName(prop.getProperty("NombreCasaDeApuestas"));
        par.setSedesNum(Integer.parseInt(prop.getProperty("NumeroDeSedes")));
        par.setTotalBudget(Double.parseDouble(prop.getProperty("PresupuestoDisponibleTotal")));

        return par;
    }

    /**
     * Guarda los parametros proporcionados en el archivo de configuracion.
     * @param parametersDTO Los parámetros a guardar.
     * @throws IOException Si ocurre un error durante la escritura en el archivo.
     */
    public void guardarParametros(ParametersDTO parametersDTO) throws IOException {
        prop.setProperty("NombreCasaDeApuestas", parametersDTO.getShopName());
        prop.setProperty("NumeroDeSedes", String.valueOf(parametersDTO.getSedesNum()));
        prop.setProperty("PresupuestoDisponibleTotal", String.valueOf(parametersDTO.getTotalBudget()));

        prop.store(new FileWriter(config), COMMENT);
    }
}
