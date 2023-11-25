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
 * La clase BalotoTable representa una tabla para mostrar información relacionada con el juego Baloto.
 */
public class BalotoTable extends JPanel{

	/**Número de serie único para la serialización. */
	private static final long serialVersionUID = 5499689096475929600L;
    /** La tabla que muestra la información. */
    private JTable tabla;
    /** El modelo de datos para la tabla. */
    private DefaultTableModel model;
    /** El panel de desplazamiento para la tabla. */
    private JScrollPane scroll;

    /**
     * Construye una nueva instancia de la clase BalotoTable.
     * Configura y coloca los componentes gráficos para mostrar información tabular relacionada con el juego Baloto.
     */
	public BalotoTable() {
		propiedadesTabla();
	}
	
    /**
     * Configura las propiedades de la tabla y sus componentes asociados.
     * Se establecen las columnas, el modelo, la capacidad de edición de celdas y otros aspectos visuales.
     */
	private void propiedadesTabla() {
        setBounds(130, 50, 580, 550);
        setLayout(new FlowLayout());

        String[] columnas = {"ID", "Sede", "Cedula", "Dia", "Apuesta", "Numeros"};
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
        scroll.setPreferredSize(new Dimension(580, 550));
        add(scroll);
        setVisible(true);
    }
	

    /**
     * Obtiene la tabla que muestra la información.
     * @return La tabla asociada a la instancia de la clase.
     */
    public JTable getTabla() {
        return tabla;
    }

    /**
     * Establece la tabla que muestra la información.
     * @param tabla La nueva tabla a asociar.
     */
    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    /**
     * Obtiene el modelo de datos de la tabla.
     * @return El modelo de datos de la tabla.
     */
    public DefaultTableModel getModel() {
        return model;
    }

    /**
     * Establece el modelo de datos de la tabla.
     * @param model El nuevo modelo de datos.
     */
    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    /**
     * Obtiene el panel de desplazamiento para la tabla.
     * @return El panel de desplazamiento asociado a la tabla.
     */
    public JScrollPane getScroll() {
        return scroll;
    }

    /**
     * Establece el panel de desplazamiento para la tabla.
     * @param scroll El nuevo panel de desplazamiento.
     */
    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }
}
