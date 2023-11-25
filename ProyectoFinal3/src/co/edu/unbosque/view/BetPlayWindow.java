package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;

/**
 * La clase BetPlayWindow representa una ventana de apuestas para el juego BetPlay.
 */
public class BetPlayWindow extends JLayeredPane {

	/**Número de serie único para la serialización. */
    private static final long serialVersionUID = 5239526211513542986L;

    /** La imagen de fondo de la ventana. */
    private JLabel backg;

    /** Botones para realizar acciones: volver, ver información y realizar apuesta. */
    private JButton back, stake, information;

    /** Campo de texto para ingresar el valor de la apuesta. */
    private JTextField betValue;

    /** Listas de equipos para los enfrentamientos. */
    private ArrayList<String> equipos, equipos2, equipos3, equipos4;

    /** Listas de espacios para mostrar los enfrentamientos. */
    private ArrayList<JLabel> labelsEnfrentamientos, labelsEnfrentamientos2, labelsEnfrentamientos3, labelsEnfrentamientos4;

    /** Spinners para seleccionar el resultado de cada enfrentamiento. */
    private JSpinner resultado, resultado2, resultado3, resultado4, resultado5, resultado6, resultado7, resultado8,
            resultado9, resultado10, resultado11, resultado12, resultado13, resultado14;

    /** Modelos para los spinners. */
    private SpinnerListModel spinnerModel, spinnerModel2, spinnerModel3, spinnerModel4, spinnerModel5, spinnerModel6,
            spinnerModel7, spinnerModel8, spinnerModel9, spinnerModel10, spinnerModel11, spinnerModel12, spinnerModel13, spinnerModel14;

    /**
     * Construye una nueva instancia de la clase BetPlayWindow.
     * Configura y coloca los componentes gráficos necesarios para la ventana de apuestas de BetPlay.
     */

	public BetPlayWindow() {
        spinnerModel = new SpinnerListModel(new String[]{"Gana local", "Empate", "Pierde local"});
        resultado = new JSpinner(spinnerModel);
		resultado.setBounds(260, 175, 100, 30);
		resultado.setBorder(null);
		resultado.setOpaque(false);
        JComponent editor = resultado.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor;
            spinnerEditor.getTextField().setForeground(Color.BLACK);
            spinnerEditor.getTextField().setBackground(Color.YELLOW);
            spinnerEditor.getTextField().setEditable(false);
        }
        
        spinnerModel2 = new SpinnerListModel(new String[]{"Gana local", "Empate", "Pierde local"});
        resultado2 = new JSpinner(spinnerModel2);
		resultado2.setBounds(260, 253, 100, 30);
		resultado2.setBorder(null);
		resultado2.setOpaque(false);
        JComponent editor2 = resultado2.getEditor();
        if (editor2 instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor2;
            spinnerEditor.getTextField().setForeground(Color.BLACK);
            spinnerEditor.getTextField().setBackground(Color.YELLOW);
            spinnerEditor.getTextField().setEditable(false);
        }
        spinnerModel3 = new SpinnerListModel(new String[]{"Gana local", "Empate", "Pierde local"});
        resultado3 = new JSpinner(spinnerModel3);
        resultado3.setBounds(260, 332, 100, 30);
        resultado3.setBorder(null);
        resultado3.setOpaque(false);
        JComponent editor3 = resultado3.getEditor();
        if (editor3 instanceof JSpinner.DefaultEditor) {
        	JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor3;
        	spinnerEditor.getTextField().setForeground(Color.BLACK);
        	spinnerEditor.getTextField().setBackground(Color.YELLOW);
        	spinnerEditor.getTextField().setEditable(false);
        }
        spinnerModel4 = new SpinnerListModel(new String[]{"Gana local", "Empate", "Pierde local"});
        resultado4 = new JSpinner(spinnerModel4);
        resultado4.setBounds(260, 410, 100, 30);
        resultado4.setBorder(null);
        resultado4.setOpaque(false);
        JComponent editor4 = resultado4.getEditor();
        if (editor4 instanceof JSpinner.DefaultEditor) {
        	JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor4;
        	spinnerEditor.getTextField().setForeground(Color.BLACK);
        	spinnerEditor.getTextField().setBackground(Color.YELLOW);
        	spinnerEditor.getTextField().setEditable(false);
        }
        spinnerModel5 = new SpinnerListModel(new String[]{"Gana local", "Empate", "Pierde local"});
        resultado5 = new JSpinner(spinnerModel5);
        resultado5.setBounds(260, 487, 100, 30);
        resultado5.setBorder(null);
        resultado5.setOpaque(false);
        JComponent editor5 = resultado5.getEditor();
        if (editor5 instanceof JSpinner.DefaultEditor) {
        	JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor5;
        	spinnerEditor.getTextField().setForeground(Color.BLACK);
        	spinnerEditor.getTextField().setBackground(Color.YELLOW);
        	spinnerEditor.getTextField().setEditable(false);
        }
        spinnerModel6 = new SpinnerListModel(new String[]{"Gana local", "Empate", "Pierde local"});
        resultado6 = new JSpinner(spinnerModel6);
        resultado6.setBounds(260, 565, 100, 30);
        resultado6.setBorder(null);
        resultado6.setOpaque(false);
        JComponent editor6 = resultado6.getEditor();
        if (editor6 instanceof JSpinner.DefaultEditor) {
        	JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor6;
        	spinnerEditor.getTextField().setForeground(Color.BLACK);
        	spinnerEditor.getTextField().setBackground(Color.YELLOW);
        	spinnerEditor.getTextField().setEditable(false);
        }
        spinnerModel7 = new SpinnerListModel(new String[]{"Gana local", "Empate", "Pierde local"});
        resultado7 = new JSpinner(spinnerModel7);
        resultado7.setBounds(260, 641, 100, 30);
        resultado7.setBorder(null);
        resultado7.setOpaque(false);
        JComponent editor7 = resultado7.getEditor();
        if (editor7 instanceof JSpinner.DefaultEditor) {
        	JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor7;
        	spinnerEditor.getTextField().setForeground(Color.BLACK);
        	spinnerEditor.getTextField().setBackground(Color.YELLOW);
        	spinnerEditor.getTextField().setEditable(false);
        }
        spinnerModel8 = new SpinnerListModel(new String[]{"Gana local", "Empate", "Pierde local"});
        resultado8 = new JSpinner(spinnerModel8);
        resultado8.setBounds(870, 100, 100, 30);
        resultado8.setBorder(null);
        resultado8.setOpaque(false);
        JComponent editor8 = resultado8.getEditor();
        if (editor8 instanceof JSpinner.DefaultEditor) {
        	JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor8;
        	spinnerEditor.getTextField().setForeground(Color.BLACK);
        	spinnerEditor.getTextField().setBackground(Color.YELLOW);
        	spinnerEditor.getTextField().setEditable(false);
        }
        spinnerModel9 = new SpinnerListModel(new String[]{"Gana local", "Empate", "Pierde local"});
        resultado9 = new JSpinner(spinnerModel9);
        resultado9.setBounds(870, 177, 100, 30);
        resultado9.setBorder(null);
        resultado9.setOpaque(false);
        JComponent editor9 = resultado9.getEditor();
        if (editor9 instanceof JSpinner.DefaultEditor) {
        	JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor9;
        	spinnerEditor.getTextField().setForeground(Color.BLACK);
        	spinnerEditor.getTextField().setBackground(Color.YELLOW);
        	spinnerEditor.getTextField().setEditable(false);
        }
        spinnerModel10 = new SpinnerListModel(new String[]{"Gana local", "Empate", "Pierde local"});
        resultado10 = new JSpinner(spinnerModel10);
        resultado10.setBounds(870, 253, 100, 30);
        resultado10.setBorder(null);
        resultado10.setOpaque(false);
        JComponent editor10 = resultado10.getEditor();
        if (editor10 instanceof JSpinner.DefaultEditor) {
        	JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor10;
        	spinnerEditor.getTextField().setForeground(Color.BLACK);
        	spinnerEditor.getTextField().setBackground(Color.YELLOW);
        	spinnerEditor.getTextField().setEditable(false);
        }
        spinnerModel11 = new SpinnerListModel(new String[]{"Gana local", "Empate", "Pierde local"});
        resultado11 = new JSpinner(spinnerModel11);
        resultado11.setBounds(870, 333, 100, 30);
        resultado11.setBorder(null);
        resultado11.setOpaque(false);
        JComponent editor11 = resultado11.getEditor();
        if (editor11 instanceof JSpinner.DefaultEditor) {
        	JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor11;
        	spinnerEditor.getTextField().setForeground(Color.BLACK);
        	spinnerEditor.getTextField().setBackground(Color.YELLOW);
        	spinnerEditor.getTextField().setEditable(false);
        }
        spinnerModel12 = new SpinnerListModel(new String[]{"Gana local", "Empate", "Pierde local"});
        resultado12 = new JSpinner(spinnerModel12);
        resultado12.setBounds(870, 412, 100, 30);
        resultado12.setBorder(null);
        resultado12.setOpaque(false);
        JComponent editor12 = resultado12.getEditor();
        if (editor12 instanceof JSpinner.DefaultEditor) {
        	JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor12;
        	spinnerEditor.getTextField().setForeground(Color.BLACK);
        	spinnerEditor.getTextField().setBackground(Color.YELLOW);
        	spinnerEditor.getTextField().setEditable(false);
        }
        spinnerModel13 = new SpinnerListModel(new String[]{"Gana local", "Empate", "Pierde local"});
        resultado13 = new JSpinner(spinnerModel13);
        resultado13.setBounds(870, 487, 100, 30);
        resultado13.setBorder(null);
        resultado13.setOpaque(false);
        JComponent editor13 = resultado13.getEditor();
        if (editor13 instanceof JSpinner.DefaultEditor) {
        	JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor13;
        	spinnerEditor.getTextField().setForeground(Color.BLACK);
        	spinnerEditor.getTextField().setBackground(Color.YELLOW);
        	spinnerEditor.getTextField().setEditable(false);
        }
        spinnerModel14 = new SpinnerListModel(new String[]{"Gana local", "Empate", "Pierde local"});
        resultado14 = new JSpinner(spinnerModel14);
        resultado14.setBounds(870, 565, 100, 30);
        resultado14.setBorder(null);
        resultado14.setOpaque(false);
        JComponent editor14 = resultado14.getEditor();
        if (editor14 instanceof JSpinner.DefaultEditor) {
        	JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor14;
        	spinnerEditor.getTextField().setForeground(Color.BLACK);
        	spinnerEditor.getTextField().setBackground(Color.YELLOW);
        	spinnerEditor.getTextField().setEditable(false);
        }
		equipos = new ArrayList<>(Arrays.asList("FC Barcelona", "AC Milan", "PSG", "Real Madrid", "Bayern Munich", "Galatasaray","Manchester United"));
		
		equipos2 = new ArrayList<>(Arrays.asList("Borussia Dortmund", "Newcastle", "Manchester City", "RB Leipzig",
				"FC Porto", "PSV Eindhoven", "FC Copenhague"));
		 
		equipos3 = new ArrayList<>(Arrays.asList("RB Salzburgo", "Benfica", "Feyenoord"
				,"Celtic", "Shakhtar Donetsk", "Estrella Roja", "Union Berlin"));
		
		equipos4 = new ArrayList<>(Arrays.asList("Arsenal", "Sevilla FC", "Napoli", "Real Sociedad", "Inter Milan", 
				"Atletico de Madrid", "Lazio"));
		
		
		labelsEnfrentamientos = new ArrayList<>();
		labelsEnfrentamientos2 = new ArrayList<>();
		labelsEnfrentamientos3 = new ArrayList<>();
		labelsEnfrentamientos4 = new ArrayList<>();
		
		
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		backg = new JLabel(new ImageIcon("src/Imagenes/13.png"));
		backg.setBounds(-8, -29, 1280, 720);
		
        int labelWidth = 585;
        int labelHeight = 35;
		
        for (int i = 0; i < equipos.size(); i++) {
            JLabel labelEnfrentamiento = new JLabel();
            labelsEnfrentamientos.add(labelEnfrentamiento);

            int x = 80;  // Posición en el eje x
            int y = 140 + i * 80;  // Posición en el eje y (aumenta verticalmente)

            labelEnfrentamiento.setBounds(x, y, labelWidth, labelHeight);
            labelEnfrentamiento.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            labelEnfrentamiento.setForeground(Color.WHITE);
            add(labelEnfrentamiento);
        }

        int numEquipos = equipos.size(); // Obtener el número total de equipos

        for (int i = 0; i < numEquipos; i++) {
            String equipo1 = equipos.remove(0);

            String nuevoEnfrentamiento = equipo1;
            labelsEnfrentamientos.get(i).setText(nuevoEnfrentamiento);
            labelsEnfrentamientos.get(4).setBounds(80, 455, 500, 35);
            labelsEnfrentamientos.get(5).setBounds(80, 530, 500, 35);
            labelsEnfrentamientos.get(6).setBounds(80, 610, 500, 35);
        }
      
        
        for (int i = 0; i < equipos2.size(); i++) {
            JLabel labelEnfrentamiento2 = new JLabel();
            labelsEnfrentamientos2.add(labelEnfrentamiento2);

            int x = 400;  // Posición en el eje x
            int y = 140 + i * 80;  // Posición en el eje y (aumenta verticalmente)

            labelEnfrentamiento2.setBounds(x, y, labelWidth, labelHeight);
            labelEnfrentamiento2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            labelEnfrentamiento2.setForeground(Color.WHITE);
            add(labelEnfrentamiento2);
        }
		

       

        int numEquipos2 = equipos2.size(); // Obtener el número total de equipos

        for (int i = 0; i < numEquipos2; i++) {
            String equipo2 = equipos2.remove(0);

            String nuevoEnfrentamiento2 = equipo2;
            labelsEnfrentamientos2.get(i).setText(nuevoEnfrentamiento2);
            labelsEnfrentamientos2.get(4).setBounds(400, 455, 500, 35);
            labelsEnfrentamientos2.get(5).setBounds(400, 530, 500, 35);
            labelsEnfrentamientos2.get(6).setBounds(400, 610, 500, 35);
            
        }
        
        for (int i = 0; i < equipos3.size(); i++) {
            JLabel labelEnfrentamiento3 = new JLabel();
            labelsEnfrentamientos3.add(labelEnfrentamiento3);

            int x = 690;  // Posición en el eje x
            int y = 65 + i * 80;  // Posición en el eje y (aumenta verticalmente)

            labelEnfrentamiento3.setBounds(x, y, labelWidth, labelHeight);
            labelEnfrentamiento3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            labelEnfrentamiento3.setForeground(Color.WHITE);
            add(labelEnfrentamiento3);
        }
		

        


        int numEquipos3 = equipos3.size(); // Obtener el número total de equipos

        for (int i = 0; i < numEquipos3; i++) {
            String equipo3 = equipos3.remove(0);

            String nuevoEnfrentamiento3 = equipo3;
            labelsEnfrentamientos3.get(i).setText(nuevoEnfrentamiento3);
            labelsEnfrentamientos3.get(4).setBounds(690, 380, 500, 35);
            labelsEnfrentamientos3.get(5).setBounds(690, 455, 500, 35);
            labelsEnfrentamientos3.get(6).setBounds(690, 530, 500, 35);

        }
        
        for (int i = 0; i < equipos4.size(); i++) {
            JLabel labelEnfrentamiento4 = new JLabel();
            labelsEnfrentamientos4.add(labelEnfrentamiento4);

            int x = 1020;  // Posición en el eje x
            int y = 65 + i * 80;  // Posición en el eje y (aumenta verticalmente)

            labelEnfrentamiento4.setBounds(x, y, labelWidth, labelHeight);
            labelEnfrentamiento4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            labelEnfrentamiento4.setForeground(Color.WHITE);
            add(labelEnfrentamiento4);
        }
		



        int numEquipos4 = equipos4.size(); // Obtener el número total de equipos

        for (int i = 0; i < numEquipos4; i++) {
            String equipo3 = equipos4.remove(0);

            String nuevoEnfrentamiento3 = equipo3;
            labelsEnfrentamientos4.get(i).setText(nuevoEnfrentamiento3);
            labelsEnfrentamientos4.get(4).setBounds(1020, 380, 500, 35);
            labelsEnfrentamientos4.get(5).setBounds(1020, 455, 500, 35);
            labelsEnfrentamientos4.get(6).setBounds(1020, 530, 500, 35);
 
        }
		
		betValue = new JTextField();
		betValue.setEditable(true);
		betValue.setBounds(440, 90, 180, 38);
		betValue.setForeground(Color.WHITE);
		betValue.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		betValue.setBorder(null);
		betValue.setOpaque(false);
		
		information = new JButton();
		information.setToolTipText("Click aqui para ver la información del juego");
		information.setBounds(650, 10, 230, 30);
		information.setOpaque(false);
		information.setContentAreaFilled(false);
		information.setBorderPainted(false);
		
		stake = new JButton();
		stake.setToolTipText("Click aqui para realizar su apuesta");
		stake.setBounds(805, 610, 220, 60);
		stake.setOpaque(false);
		stake.setContentAreaFilled(false);
		stake.setBorderPainted(false);

		back = new JButton();
		back.setToolTipText("Volver al menu anterior");
		back.setBounds(1120, 610, 130, 50);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		
		add(resultado);
		add(resultado2);
		add(resultado3);
		add(resultado4);
		add(resultado5);
		add(resultado6);
		add(resultado7);
		add(resultado8);
		add(resultado9);
		add(resultado10);
		add(resultado11);
		add(resultado12);
		add(resultado13);
		add(resultado14);
		add(betValue);
		add(information);
		add(stake);
		add(back);
		add(backg);    
	}


	public JLabel getBackg() {
		return backg;
	}


	public void setBackg(JLabel backg) {
		this.backg = backg;
	}


	public JButton getBack() {
		return back;
	}


	public void setBack(JButton back) {
		this.back = back;
	}


	public JButton getStake() {
		return stake;
	}


	public void setStake(JButton stake) {
		this.stake = stake;
	}


	public JButton getInformation() {
		return information;
	}


	public void setInformation(JButton information) {
		this.information = information;
	}


	public JTextField getBetValue() {
		return betValue;
	}


	public void setBetValue(JTextField betValue) {
		this.betValue = betValue;
	}


	public ArrayList<String> getEquipos() {
		return equipos;
	}


	public void setEquipos(ArrayList<String> equipos) {
		this.equipos = equipos;
	}


	public ArrayList<String> getEquipos2() {
		return equipos2;
	}


	public void setEquipos2(ArrayList<String> equipos2) {
		this.equipos2 = equipos2;
	}


	public ArrayList<String> getEquipos3() {
		return equipos3;
	}


	public void setEquipos3(ArrayList<String> equipos3) {
		this.equipos3 = equipos3;
	}


	public ArrayList<String> getEquipos4() {
		return equipos4;
	}


	public void setEquipos4(ArrayList<String> equipos4) {
		this.equipos4 = equipos4;
	}


	public ArrayList<JLabel> getLabelsEnfrentamientos() {
		return labelsEnfrentamientos;
	}


	public void setLabelsEnfrentamientos(ArrayList<JLabel> labelsEnfrentamientos) {
		this.labelsEnfrentamientos = labelsEnfrentamientos;
	}


	public ArrayList<JLabel> getLabelsEnfrentamientos2() {
		return labelsEnfrentamientos2;
	}


	public void setLabelsEnfrentamientos2(ArrayList<JLabel> labelsEnfrentamientos2) {
		this.labelsEnfrentamientos2 = labelsEnfrentamientos2;
	}


	public ArrayList<JLabel> getLabelsEnfrentamientos3() {
		return labelsEnfrentamientos3;
	}


	public void setLabelsEnfrentamientos3(ArrayList<JLabel> labelsEnfrentamientos3) {
		this.labelsEnfrentamientos3 = labelsEnfrentamientos3;
	}


	public ArrayList<JLabel> getLabelsEnfrentamientos4() {
		return labelsEnfrentamientos4;
	}


	public void setLabelsEnfrentamientos4(ArrayList<JLabel> labelsEnfrentamientos4) {
		this.labelsEnfrentamientos4 = labelsEnfrentamientos4;
	}

	public JSpinner getResultado() {
		return resultado;
	}


	public void setResultado(JSpinner resultado) {
		this.resultado = resultado;
	}


	public JSpinner getResultado2() {
		return resultado2;
	}


	public void setResultado2(JSpinner resultado2) {
		this.resultado2 = resultado2;
	}


	public JSpinner getResultado3() {
		return resultado3;
	}


	public void setResultado3(JSpinner resultado3) {
		this.resultado3 = resultado3;
	}


	public JSpinner getResultado4() {
		return resultado4;
	}


	public void setResultado4(JSpinner resultado4) {
		this.resultado4 = resultado4;
	}


	public JSpinner getResultado5() {
		return resultado5;
	}


	public void setResultado5(JSpinner resultado5) {
		this.resultado5 = resultado5;
	}


	public JSpinner getResultado6() {
		return resultado6;
	}


	public void setResultado6(JSpinner resultado6) {
		this.resultado6 = resultado6;
	}


	public JSpinner getResultado7() {
		return resultado7;
	}


	public void setResultado7(JSpinner resultado7) {
		this.resultado7 = resultado7;
	}


	public JSpinner getResultado8() {
		return resultado8;
	}


	public void setResultado8(JSpinner resultado8) {
		this.resultado8 = resultado8;
	}


	public JSpinner getResultado9() {
		return resultado9;
	}


	public void setResultado9(JSpinner resultado9) {
		this.resultado9 = resultado9;
	}


	public JSpinner getResultado10() {
		return resultado10;
	}


	public void setResultado10(JSpinner resultado10) {
		this.resultado10 = resultado10;
	}


	public JSpinner getResultado11() {
		return resultado11;
	}


	public void setResultado11(JSpinner resultado11) {
		this.resultado11 = resultado11;
	}


	public JSpinner getResultado12() {
		return resultado12;
	}


	public void setResultado12(JSpinner resultado12) {
		this.resultado12 = resultado12;
	}


	public JSpinner getResultado13() {
		return resultado13;
	}


	public void setResultado13(JSpinner resultado13) {
		this.resultado13 = resultado13;
	}


	public JSpinner getResultado14() {
		return resultado14;
	}


	public void setResultado14(JSpinner resultado14) {
		this.resultado14 = resultado14;
	}


	public SpinnerListModel getSpinnerModel() {
		return spinnerModel;
	}


	public void setSpinnerModel(SpinnerListModel spinnerModel) {
		this.spinnerModel = spinnerModel;
	}


	public SpinnerListModel getSpinnerModel2() {
		return spinnerModel2;
	}


	public void setSpinnerModel2(SpinnerListModel spinnerModel2) {
		this.spinnerModel2 = spinnerModel2;
	}


	public SpinnerListModel getSpinnerModel3() {
		return spinnerModel3;
	}


	public void setSpinnerModel3(SpinnerListModel spinnerModel3) {
		this.spinnerModel3 = spinnerModel3;
	}


	public SpinnerListModel getSpinnerModel4() {
		return spinnerModel4;
	}


	public void setSpinnerModel4(SpinnerListModel spinnerModel4) {
		this.spinnerModel4 = spinnerModel4;
	}


	public SpinnerListModel getSpinnerModel5() {
		return spinnerModel5;
	}


	public void setSpinnerModel5(SpinnerListModel spinnerModel5) {
		this.spinnerModel5 = spinnerModel5;
	}


	public SpinnerListModel getSpinnerModel6() {
		return spinnerModel6;
	}


	public void setSpinnerModel6(SpinnerListModel spinnerModel6) {
		this.spinnerModel6 = spinnerModel6;
	}


	public SpinnerListModel getSpinnerModel7() {
		return spinnerModel7;
	}


	public void setSpinnerModel7(SpinnerListModel spinnerModel7) {
		this.spinnerModel7 = spinnerModel7;
	}


	public SpinnerListModel getSpinnerModel8() {
		return spinnerModel8;
	}


	public void setSpinnerModel8(SpinnerListModel spinnerModel8) {
		this.spinnerModel8 = spinnerModel8;
	}


	public SpinnerListModel getSpinnerModel9() {
		return spinnerModel9;
	}


	public void setSpinnerModel9(SpinnerListModel spinnerModel9) {
		this.spinnerModel9 = spinnerModel9;
	}


	public SpinnerListModel getSpinnerModel10() {
		return spinnerModel10;
	}


	public void setSpinnerModel10(SpinnerListModel spinnerModel10) {
		this.spinnerModel10 = spinnerModel10;
	}


	public SpinnerListModel getSpinnerModel11() {
		return spinnerModel11;
	}


	public void setSpinnerModel11(SpinnerListModel spinnerModel11) {
		this.spinnerModel11 = spinnerModel11;
	}


	public SpinnerListModel getSpinnerModel12() {
		return spinnerModel12;
	}


	public void setSpinnerModel12(SpinnerListModel spinnerModel12) {
		this.spinnerModel12 = spinnerModel12;
	}


	public SpinnerListModel getSpinnerModel13() {
		return spinnerModel13;
	}


	public void setSpinnerModel13(SpinnerListModel spinnerModel13) {
		this.spinnerModel13 = spinnerModel13;
	}


	public SpinnerListModel getSpinnerModel14() {
		return spinnerModel14;
	}


	public void setSpinnerModel14(SpinnerListModel spinnerModel14) {
		this.spinnerModel14 = spinnerModel14;
	}


}
