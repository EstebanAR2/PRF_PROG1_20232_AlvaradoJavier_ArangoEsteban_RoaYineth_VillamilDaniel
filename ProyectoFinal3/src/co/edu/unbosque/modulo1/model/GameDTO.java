package co.edu.unbosque.modulo1.model;

import java.io.Serializable;

/**
 * La clase GameDTO representa un objeto de transferencia de datos (DTO) para la información de un juego.
 * Implementa Serializable para permitir la serialización de objetos.
 */

public class GameDTO implements Serializable {
	
	/** El número de versión para la serialización */
	private static final long serialVersionUID = -5286163648420403882L;
	/** El nombre del juego */
	private String gameName;
	/** El tipo de juego (lotería/chance/deportivo) */
	private String gameType;
	/** El presupuesto designado para el juego */
	private long gameEstimate;
	
	/** Constructor vacio de la clase GameDT. */
	public GameDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que inicializa un objeto GameDTO con valores específicos
	 * @param gameName el nombre del juego
	 * @param gameType el tipo de juego (lotería/chance/deportivo)
	 * @param gameEstimate el presupuesto designado para el juego
	 */
	public GameDTO(String gameName, String gameType, long gameEstimate) {
		super();
		this.gameName = gameName;
		this.gameType = gameType;
		this.gameEstimate = gameEstimate;
	}

	/**
	 * Obtiene el nombre del juego
	 * @return El nombre del juego
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * Establece el nombre del juego
	 * @param gameName El nuevo nombre del juego
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/**
	 * Obtiene el tipo de juego
	 * @return El tipo de juego
	 */
	public String getGameType() {
		return gameType;
	}

	/**
	 * Establece el tipo de juego
	 * @param gameType El nuevo tipo de juego
	 */
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	
	/**
	 * Obtiene el presupuesto designado para el juego
	 * @return El presupuesto designado para el juego
	 */
	public long getGameEstimate() {
		return gameEstimate;
	}

	/**
	 * Establece el presupuesto designado para el juego
	 * @param gameEstimate El nuevo presupuesto designado para el juego
	 */
	public void setGameEstimate(long gameEstimate) {
		this.gameEstimate = gameEstimate;
	}

	/**
	 * Genera una cadena String del objeto GameDTO
	 * @return Una cadena que representa el objeto GameDTO
	 */
	@Override
	public String toString() {
		StringBuilder chain=new StringBuilder();
		chain.append("Nombre del juego: "+gameName+"\n");
		chain.append("\n"+"Tipo de juego (loteria/chance/deportivo): "+gameType+"\n");
		chain.append("\n"+"Presupuesto designado para el juego: "+gameEstimate+"\n");
		
		return chain.toString();
	}

}
