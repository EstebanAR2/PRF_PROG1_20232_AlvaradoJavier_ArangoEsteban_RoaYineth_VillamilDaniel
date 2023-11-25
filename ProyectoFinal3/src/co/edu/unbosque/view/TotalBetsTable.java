package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * La clase TotalBetsTable representa una tabla de resumen de apuestas.
 */
public class TotalBetsTable extends JPanel {

    /** Identificador único para la serialización. */
    private static final long serialVersionUID = -7466374607263684453L;
    /** Tabla para mostrar información sobre las apuestas totales. */
    private JTable tabla;
    /** Modelo de la tabla. */
    private DefaultTableModel model;
    /** Panel de desplazamiento para la tabla. */
    private JScrollPane scroll;

    /**
     * Construye una nueva instancia de la clase TotalBetsTable.
     * Inicializa y configura los elementos gráficos presentes en la tabla de resumen de apuestas.
     */
    public TotalBetsTable() {
        propiedadesTabla();
    }

    /**
     * Configura las propiedades de la tabla de resumen de apuestas.
     * Se establece el diseño, las columnas, y se crea la tabla y el panel de desplazamiento.
     */
	private void propiedadesTabla() {
		setBounds(225, 120, 700, 450);
		setLayout(new FlowLayout());
		String[] columnas = {"Sede", "Juego", "Tipo de juego", "Total de apuestas"};
		model = new DefaultTableModel(columnas, 0);

		tabla = new JTable(model) {
			private static final long serialVersionUID = -6608812306024822930L;

		};
		tabla.setDefaultEditor(Object.class, null);
		scroll = new JScrollPane(tabla);
		scroll.setPreferredSize(new Dimension(700,450));
		add(scroll);
		setVisible(true);
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
}
