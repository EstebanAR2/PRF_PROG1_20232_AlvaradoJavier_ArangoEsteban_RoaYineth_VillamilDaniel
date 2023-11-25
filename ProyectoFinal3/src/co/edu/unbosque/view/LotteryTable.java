package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * La clase LotteryTable representa una tabla para mostrar información relacionada con las loterias.
 */
public class LotteryTable extends JPanel{

	/**Número de serie único para la serialización. */
	private static final long serialVersionUID = -839165849670498873L;
    /** La tabla que muestra la información. */
    private JTable tabla;
    /** El modelo de datos para la tabla. */
    private DefaultTableModel model;
    /** El panel de desplazamiento para la tabla. */
    private JScrollPane scroll;
	
    /**
     * Construye una nueva instancia de la clase LotteryTable.
     * Configura y coloca los componentes gráficos para mostrar información tabular relacionada con la loteria.
     */
	public LotteryTable() {
		propiedadesTabla();
	}
	
    /**
     * Configura las propiedades de la tabla y sus componentes asociados.
     * Se establecen las columnas, el modelo, la capacidad de edición de celdas y otros aspectos visuales.
     */
	private void propiedadesTabla() {
	        setBounds(130, 50, 600, 550);
	        setLayout(new FlowLayout());

	        String[] columnas = {"ID", "Sede", "Cedula", "Dia", "Apuesta", "Loteria", "Números", "Serie"};
	        model = new DefaultTableModel(columnas, 0);

	        tabla = new JTable(model) {
	            private static final long serialVersionUID = -6608812306024822930L;

	            @Override
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }
	        };

	        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
	            private static final long serialVersionUID = 1L;

	            @Override
	            public JLabel getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	                label.setText("<html>" + value.toString().replaceAll("\n", "<br/>") + "</html>");
	                return label;
	            }
	        };

	        tabla.setDefaultRenderer(Object.class, cellRenderer);
	        tabla.setRowHeight(50); 
	        scroll = new JScrollPane(tabla);
	        scroll.setPreferredSize(new Dimension(600, 550));
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
