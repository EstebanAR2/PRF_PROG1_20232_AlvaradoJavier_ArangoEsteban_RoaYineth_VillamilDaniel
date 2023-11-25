package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * La clase BetsCustomersTable es un componente gráfico que muestra una tabla de clientes
 * y la cantidad total de sus apuestas.
 */
public class BetsCustomersTable extends JPanel {

	/**Número de serie único para la serialización. */
    private static final long serialVersionUID = 8468383507557147994L;
    /** La tabla que muestra la información de los clientes y sus apuestas. */
    private JTable tabla;
    /** El modelo de la tabla. */
    private DefaultTableModel model;
    /** El panel de desplazamiento para la tabla. */
    private JScrollPane scroll;

    /**
     * Construye una nueva instancia de la clase BetsCustomersTable.
     * Configura y coloca los componentes gráficos necesarios para la tabla de clientes y sus apuestas.
     */
    public BetsCustomersTable() {
        propiedadesTabla();
    }

    /**
     * Configura las propiedades de la tabla y coloca los componentes en el panel.
     */
	private void propiedadesTabla() {
		setBounds(425, 120, 450, 450);
		setLayout(new FlowLayout());
		String[] columnas = {"Cedula", "Total de apuestas (COP)"};
		model = new DefaultTableModel(columnas, 0);

		tabla = new JTable(model) {
			private static final long serialVersionUID = -6608812306024822930L;

		};
		tabla.setDefaultEditor(Object.class, null);
		scroll = new JScrollPane(tabla);
		scroll.setPreferredSize(new Dimension(450,450));
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
