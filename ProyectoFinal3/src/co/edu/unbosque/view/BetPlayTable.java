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
 * La clase BetPlayTable representa una tabla que muestra información relacionada con las apuestas de BetPlay.
 */
public class BetPlayTable extends JPanel{

	/**Número de serie único para la serialización. */
	private static final long serialVersionUID = -3813530206101997670L;
    /** La tabla para mostrar la información de las apuestas. */
    private JTable tabla;
    /** El modelo de la tabla. */
    private DefaultTableModel model;
    /** El panel de desplazamiento para la tabla. */
    private JScrollPane scroll;

    /**
     * Construye una nueva instancia de la clase BetPlayTable.
     * Configura y coloca los componentes gráficos necesarios para la tabla de apuestas de BetPlay.
     */
    public BetPlayTable() {
        propiedadesTabla();
    }

    /**
     * Configura las propiedades de la tabla, como las columnas, el modelo y el renderizador.
     */
	private void propiedadesTabla() {
        setBounds(50, 40, 1200, 380);
        setLayout(new FlowLayout());

        String[] columnas = {"ID", "Sede", "Cedula", "Dia", "Apuesta", "Res1", "Res2", "Res3", "Res4", "Res5", "Res6", "Res7", "Res8", "Res9"
        		, "Res10", "Res11", "Res12", "Res13", "Res14"};
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
        scroll.setPreferredSize(new Dimension(1200, 380));
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
