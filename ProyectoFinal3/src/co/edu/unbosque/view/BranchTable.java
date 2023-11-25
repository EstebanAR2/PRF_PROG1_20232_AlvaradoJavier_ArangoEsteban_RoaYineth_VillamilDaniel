package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * La clase BranchTable representa una tabla para mostrar información relacionada con las sedes.
 */
public class BranchTable extends JPanel{

	/**Número de serie único para la serialización. */
	private static final long serialVersionUID = -8615117642535428544L;
    /** La tabla que muestra la información. */
    private JTable tabla;
    /** El modelo de datos para la tabla. */
    private DefaultTableModel model;
    /** El panel de desplazamiento para la tabla. */
    private JScrollPane scroll;
	
    /**
     * Construye una nueva instancia de la clase BranchTable.
     * Configura y coloca los componentes gráficos para mostrar información tabular relacionada con las sedes.
     */
	public BranchTable() {
		propiedadesTabla();
	}
	
    /**
     * Configura las propiedades de la tabla y sus componentes asociados.
     * Se establecen las columnas, el modelo, la capacidad de edición de celdas y otros aspectos visuales.
     */
	private void propiedadesTabla() {
		setBounds(130, 50, 400, 550);
		setLayout(new FlowLayout());
		String[] columnas = {"Sede","Número de Empleados"};
		model = new DefaultTableModel(columnas, 0);

		tabla = new JTable(model) {
			private static final long serialVersionUID = -6608812306024822930L;

		};
		tabla.setDefaultEditor(Object.class, null);
		scroll = new JScrollPane(tabla);
		scroll.setPreferredSize(new Dimension(400,550));
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
