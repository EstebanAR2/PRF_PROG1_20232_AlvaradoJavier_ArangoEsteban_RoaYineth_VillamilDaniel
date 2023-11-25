package co.edu.unbosque.modulo5.model.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import co.edu.unbosque.modulo1.model.GameDTO;
import co.edu.unbosque.modulo1.model.persistence.GameDAO;
import co.edu.unbosque.modulo2.model.BranchDTO;
import co.edu.unbosque.modulo2.model.persistence.BranchDAO;
import co.edu.unbosque.modulo3.model.ApostadorDTO;
import co.edu.unbosque.modulo3.model.persistence.ApostadorDAO;
import co.edu.unbosque.modulo4.model.BalotoDTO;
import co.edu.unbosque.modulo4.model.BetPlayDTO;
import co.edu.unbosque.modulo4.model.ChanceDTO;
import co.edu.unbosque.modulo4.model.LoteriaDTO;
import co.edu.unbosque.modulo4.model.SuperAstroDTO;
import co.edu.unbosque.modulo4.model.persistence.BalotoDAO;
import co.edu.unbosque.modulo4.model.persistence.BetPlayDAO;
import co.edu.unbosque.modulo4.model.persistence.ChanceDAO;
import co.edu.unbosque.modulo4.model.persistence.LoteriaDAO;
import co.edu.unbosque.modulo4.model.persistence.SuperAstroDAO;

/**
 * Clase que representa un conjunto de métodos para generar informes y reportes relacionados con las apuestas.
 */
public class Reportes {
    private ArrayList<ApostadorDTO> apostadoresEnSede;


    /** Constructor de la clase Reportes que inicializa las instancias de las clases DAO necesarias. */
    public Reportes() {
        apostadoresEnSede = new ArrayList<>();

    }

    /**
     * Obtiene la lista de apostadores en una sede específica.
     * @param aDAO Instancia de ApostadorDAO.
     * @param sede Nombre de la sede.
     * @return Lista de apostadores en la sede.
     */
    public ArrayList<ApostadorDTO> obtenerApostadoresEnSede(ApostadorDAO aDAO, String sede) {
        apostadoresEnSede = new ArrayList<>();

        for (ApostadorDTO apostador : aDAO.getListaApostadores()) {
            if (apostador.getSede().equalsIgnoreCase(sede)) {
                apostadoresEnSede.add(apostador);
            }
        }

        return apostadoresEnSede;
    }

    /**
     * Obtiene una cadena de texto con la lista de apostadores por sede.
     * @param bDAO Instancia de BranchDAO.
     * @param aDAO Instancia de ApostadorDAO.
     * @return Cadena de texto con la lista de apostadores por sede.
     */
    public String obtenerListaApostadoresPorSede(BranchDAO bDAO, ApostadorDAO aDAO) {
        StringBuilder resultado = new StringBuilder();

        for (BranchDTO sede : bDAO.getListaSedes()) {
            resultado.append("Apostadores en la sede de ").append(sede.getLocation()).append(":\n");

            ArrayList<ApostadorDTO> apostadoresEnSede = obtenerApostadoresEnSede(aDAO, sede.getLocation());

            for (ApostadorDTO apostador : apostadoresEnSede) {
                resultado.append("Nombre: ").append(apostador.getNombre()).append(", Cédula: ")
                        .append(apostador.getCedula()).append("\n");
            }

            resultado.append("\n");
        }

        return resultado.toString();
    }

    /**
     * Obtiene una cadena de texto con detalles de las apuestas realizadas por cliente y sede.
     * @param aDAO  Instancia de ApostadorDAO.
     * @param bDAO  Instancia de BranchDAO.
     * @param baDAO Instancia de BalotoDAO.
     * @param saDAO Instancia de SuperAstroDAO.
     * @param lDAO  Instancia de LoteriaDAO.
     * @param cDAO  Instancia de ChanceDAO.
     * @param bpDAO Instancia de BetPlayDAO.
     * @return Cadena de texto con detalles de las apuestas por cliente y sede.
     */
    public String obtenerDetallesApuestasPorClienteYSede(ApostadorDAO aDAO, BranchDAO bDAO, BalotoDAO baDAO, SuperAstroDAO saDAO, LoteriaDAO lDAO, ChanceDAO cDAO, BetPlayDAO bpDAO) {
        StringBuilder detalles = new StringBuilder();

        // Iterar sobre todos los apostadores
        for (ApostadorDTO apostador : aDAO.getListaApostadores()) {
            detalles.append("Detalles de apuestas para el cliente ").append(apostador.getNombre())
                    .append(" (Cédula: ").append(apostador.getCedula()).append("):\n");

            // Iterar sobre todas las sedes
            for (BranchDTO sede : bDAO.getListaSedes()) {
                detalles.append("En la sede ").append(sede.getLocation()).append(":\n");

                // Iterar sobre todas las apuestas y verificar si corresponden al cliente y sede
                for (BalotoDTO baloto : baDAO.getBalotos()) {
                    if (baloto.getCc() == apostador.getCedula()
                            && baloto.getSedeName().equalsIgnoreCase(sede.getLocation())) {
                        detalles.append(obtenerDetallesBaloto(baloto)).append("\n\n");
                    }
                }

                for (SuperAstroDTO superAstro : saDAO.getSuperAstros()) {
                    if (superAstro.getCc() == apostador.getCedula()
                            && superAstro.getSedeName().equalsIgnoreCase(sede.getLocation())) {
                        detalles.append(obtenerDetallesSuperAstro(superAstro)).append("\n\n");
                    }
                }

                for (LoteriaDTO loteria : lDAO.getLoterias()) {
                    if (loteria.getCc() == apostador.getCedula()
                            && loteria.getSedeName().equalsIgnoreCase(sede.getLocation())) {
                        detalles.append(obtenerDetallesLoteria(loteria)).append("\n\n");
                    }
                }

                for (ChanceDTO chance : cDAO.getChances()) {
                    if (chance.getCc() == apostador.getCedula()
                            && chance.getSedeName().equalsIgnoreCase(sede.getLocation())) {
                        detalles.append(obtenerDetallesChance(chance)).append("\n\n");
                    }
                }

                for (BetPlayDTO betPlay : bpDAO.getResultados()) {
                    if (betPlay.getCc() == apostador.getCedula()
                            && betPlay.getSedeName().equalsIgnoreCase(sede.getLocation())) {
                        detalles.append(obtenerDetallesBetPlay(betPlay)).append("\n\n");
                    }
                }

                detalles.append("\n");
            }

            detalles.append("\n");
        }

        return detalles.toString();
    }

    /**
     * Obtiene una cadena de texto con detalles de una apuesta de tipo Baloto.
     * @param baloto Instancia de BalotoDTO.
     * @return Cadena de texto con detalles de la apuesta de tipo Baloto.
     */
    public String obtenerDetallesBaloto(BalotoDTO baloto) {
        return "Baloto - Números: " + baloto.getNumbers() + "\nValor pagado: " + baloto.getBetValue();
    }

    /**
     * Obtiene una cadena de texto con detalles de una apuesta de tipo SuperAstro.
     * @param superAstro Instancia de SuperAstroDTO.
     * @return Cadena de texto con detalles de la apuesta de tipo SuperAstro.
     */
    public String obtenerDetallesSuperAstro(SuperAstroDTO superAstro) {
        return "SuperAstro - Números: " + superAstro.getNumbers() + "\nSigno del zodiaco: "
                + superAstro.getSignoZodiacal() + "\nValor pagado: " + superAstro.getBetValue();
    }

    /**
     * Obtiene una cadena de texto con detalles de una apuesta de tipo Loteria.
     * @param loteria Instancia de LoteriaDTO.
     * @return Cadena de texto con detalles de la apuesta de tipo Loteria.
     */
    public String obtenerDetallesLoteria(LoteriaDTO loteria) {
        return "Lotería - Nombre: " + loteria.getName() + "\nNúmeros: " + loteria.getNumbers()
                + "\nSerie: " + loteria.getSerie() + "\nValor pagado: " + loteria.getBetValue();
    }

    /**
     * Obtiene una cadena de texto con detalles de una apuesta de tipo Chance.
     * @param chance Instancia de ChanceDTO.
     * @return Cadena de texto con detalles de la apuesta de tipo Chance.
     */
    public String obtenerDetallesChance(ChanceDTO chance) {
        return "Chance - Nombre: " + chance.getName() + "\nNúmeros: " + chance.getNumbers()
                + "\nValor pagado: " + chance.getBetValue();
    }

    /**
     * Obtiene una cadena de texto con detalles de una apuesta de tipo BetPlay.
     * @param betPlay Instancia de BetPlayDTO.
     * @return Cadena de texto con detalles de la apuesta de tipo BetPlay.
     */
    public String obtenerDetallesBetPlay(BetPlayDTO betPlay) {
        return "BetPlay - Resultados: " + betPlay.getResultados() + "\nValor pagado: " + betPlay.getBetValue();
    }

    /**
     * Obtiene una cadena de texto con el total de apuestas realizadas por cada cliente.
     * @param baDAO Instancia de BalotoDAO.
     * @param saDAO Instancia de SuperAstroDAO.
     * @param lDAO  Instancia de LoteriaDAO.
     * @param bpDAO Instancia de BetPlayDAO.
     * @param cDAO  Instancia de ChanceDAO.
     * @return Cadena de texto con el total de apuestas realizadas por cada cliente.
     */
    public String obtenerTotalApuestasPorCliente(BalotoDAO baDAO, SuperAstroDAO saDAO, LoteriaDAO lDAO, BetPlayDAO bpDAO, ChanceDAO cDAO) {

        StringBuilder resultado = new StringBuilder();

        Map<Long, Double> totalApuestasPorCliente = new HashMap<>();

        for (BalotoDTO baloto : baDAO.getBalotos()) {
            actualizarTotalApuestasPorCliente(totalApuestasPorCliente, baloto.getCc(), baloto.getBetValue());
        }

        for (SuperAstroDTO superAstro : saDAO.getSuperAstros()) {
            actualizarTotalApuestasPorCliente(totalApuestasPorCliente, superAstro.getCc(), superAstro.getBetValue());
        }

        for (LoteriaDTO loteria : lDAO.getLoterias()) {
            actualizarTotalApuestasPorCliente(totalApuestasPorCliente, loteria.getCc(), loteria.getBetValue());
        }

        for (BetPlayDTO betPlay : bpDAO.getResultados()) {
            actualizarTotalApuestasPorCliente(totalApuestasPorCliente, betPlay.getCc(), betPlay.getBetValue());
        }

        for (ChanceDTO chance : cDAO.getChances()) {
            actualizarTotalApuestasPorCliente(totalApuestasPorCliente, chance.getCc(), chance.getBetValue());
        }

        for (Map.Entry<Long, Double> entry : totalApuestasPorCliente.entrySet()) {
            resultado.append("Cédula: ").append(entry.getKey()).append(", Valor total de apuestas: ")
                    .append(entry.getValue()).append("\n");
        }

        return resultado.toString();
    }

    /**
     * Actualiza el total de apuestas realizadas por cada cliente.
     * @param totalApuestasPorCliente Mapa con el total de apuestas por cliente.
     * @param l                      Cédula del cliente.
     * @param valorApuesta            Valor de la apuesta.
     */
    public void actualizarTotalApuestasPorCliente(Map<Long, Double> totalApuestasPorCliente, long l, double valorApuesta) {
        totalApuestasPorCliente.put(l, totalApuestasPorCliente.getOrDefault(l, 0.0) + valorApuesta);
    }

    /**
     * Genera un informe con el total de apuestas por sede y tipo de juego.
     * @param bDAO  Instancia de BranchDAO.
     * @param gDAO  Instancia de GameDAO.
     * @param aDAO  Instancia de ApostadorDAO.
     * @param lDAO  Instancia de LoteriaDAO.
     * @param saDAO Instancia de SuperAstroDAO.
     * @param baDAO Instancia de BalotoDAO.
     * @param bpDAO Instancia de BetPlayDAO.
     * @param cDAO  Instancia de ChanceDAO.
     * @return Cadena de texto con el informe del total de apuestas por sede y tipo de juego.
     */	public String generarInformeTotalApuestasPorSedeYTipoJuego(BranchDAO bDAO, GameDAO gDAO, ApostadorDAO aDAO, LoteriaDAO lDAO, SuperAstroDAO saDAO, BalotoDAO baDAO, BetPlayDAO bpDAO, ChanceDAO cDAO) {
	    StringBuilder informe = new StringBuilder();

	    informe.append("Informe total de apuestas por sede y tipo de Juego:\n");

	    for (BranchDTO sede : bDAO.getListaSedes()) {
	        informe.append("Sede: ").append(sede.getLocation()).append("\n");

	        for (GameDTO juego : gDAO.getlistOfGames()) {
	            String tipoJuego = juego.getGameType();

	            long totalApuestas = 0;

	            for (ApostadorDTO apostador : aDAO.getListaApostadores()) {
	                for (LoteriaDTO loteria : lDAO.getLoterias()) {
	                    if (loteria.getCc() == apostador.getCedula() && loteria.getSedeName().equalsIgnoreCase(sede.getLocation()) && juego.getGameName().equalsIgnoreCase("Loteria")) {
	                        totalApuestas++;
	                    }
	                }
	            }
	            
	            for (ApostadorDTO apostador : aDAO.getListaApostadores()) {
	            	for (SuperAstroDTO superAstros : saDAO.getSuperAstros()) {
	            		if (superAstros.getCc() == apostador.getCedula() && superAstros.getSedeName().equalsIgnoreCase(sede.getLocation()) && juego.getGameName().equalsIgnoreCase("Super Astro")) {
	            			totalApuestas++;
	            		}
	            	}	
	            }
	            
	            for (ApostadorDTO apostador : aDAO.getListaApostadores()) {
	            	for (BalotoDTO baloto : baDAO.getBalotos()) {
	            		if (baloto.getCc() == apostador.getCedula() && baloto.getSedeName().equalsIgnoreCase(sede.getLocation()) && juego.getGameName().equalsIgnoreCase("Baloto")) {
	            			totalApuestas++;
	            		}
	            	}
	            }
	            
	            for (ApostadorDTO apostador : aDAO.getListaApostadores()) {
	            	for (BetPlayDTO betPlay : bpDAO.getResultados()) {
	            		if (betPlay.getCc() == apostador.getCedula() && betPlay.getSedeName().equalsIgnoreCase(sede.getLocation()) && juego.getGameName().equalsIgnoreCase("BetPlay")) {
	            			totalApuestas++;
	            		}
	            	}
	            }
	            
	            for (ApostadorDTO apostador : aDAO.getListaApostadores()) {
	            	for (ChanceDTO chance : cDAO.getChances()) {
	            		if (chance.getCc() == apostador.getCedula() && chance.getSedeName().equalsIgnoreCase(sede.getLocation()) && juego.getGameName().equalsIgnoreCase("Chance")) {
	            			totalApuestas++;
	            		}
	            	}
	            }

	            informe.append("- Juego: ").append(juego.getGameName()).append("\nTipo: ").append(tipoJuego)
	                    .append("\nTotal de apuestas realizadas: ").append(totalApuestas).append("\n");
	        }

	        informe.append("\n");
	    }

	    return informe.toString();
	}

}
