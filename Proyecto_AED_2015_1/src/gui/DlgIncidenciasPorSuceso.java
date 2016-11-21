package gui;

import clases.Incidencia;
import libreria.Lib;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DlgIncidenciasPorSuceso extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblEstado;
	private JComboBox <String> cboSucesos;
	private JButton btnVolver;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DlgIncidenciasPorSuceso dialog = new DlgIncidenciasPorSuceso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgIncidenciasPorSuceso() {
		getContentPane().setLayout(null);
		setResizable(false);
		setTitle("Reporte | B�squeda de Incidencias");
		setBounds(100, 100, 595, 520);
		
		lblEstado = new JLabel("ESTADO:");
		lblEstado.setBounds(10, 10, 69, 23);
		getContentPane().add(lblEstado);
		
		cboSucesos = new JComboBox <String> ();
		cboSucesos.addActionListener(this);
		cboSucesos.setModel(new DefaultComboBoxModel <String>
				           (new String[] {"Incidencia que m\u00E1s demor\u00F3",
				        		          "Incidencia que menos demor\u00F3",
				        		          "Cantidad de Incidencias canceladas",
				        		          "Cantidad de Incidencias cerradas"}));
		cboSucesos.setBounds(60, 10, 232, 23);
		getContentPane().add(cboSucesos);

		btnVolver = new JButton("volver");
		btnVolver.addActionListener(this);
		btnVolver.setBounds(470, 11, 109, 45);
		btnVolver.setIcon(new ImageIcon("imagenes/volver.png"));
		getContentPane().add(btnVolver);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 569, 402);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 11));
		scrollPane.setViewportView(txtS);	
		
		incidenciaQueMasDemoro();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == cboSucesos) {
			actionPerformedCboSucesos(arg0);
		}		
	}
	protected void actionPerformedCboSucesos(ActionEvent arg0) {
		txtS.setText("");
		switch (leerPosCboSucesos()) {				
			case 0:
				incidenciaQueMasDemoro();
				break;
			case 1:
				incidenciaQueMenosDemoro();
				break;
			case 2:
				cantidadDeIncidenciasCanceladas();
				break;
			default:
				cantidadDeIncidenciasCerradas();
				break;
		}
	}
	public void incidenciaQueMasDemoro() {
		Incidencia x;
		int mayorTiempo = Proyecto_AED_2015_1.ai.obtener(0).getTiempoRealSol();	
		for (int i=1; i<Proyecto_AED_2015_1.ai.tama�o(); i++) {
			x = Proyecto_AED_2015_1.ai.obtener(i);
			if (mayorTiempo < x.getTiempoRealSol())
				mayorTiempo = x.getTiempoRealSol();
		}
		for (int i=0; i<Proyecto_AED_2015_1.ai.tama�o(); i++) {
			x = Proyecto_AED_2015_1.ai.obtener(i);
			if (mayorTiempo == x.getTiempoRealSol()) {
				imprimir("C�digo de usuario                    :  " + x.getCodigoUsuario());
				imprimir("C�digo de especialista               :  " + x.getCodigoEspecialista());
				imprimir("C�digo de incidencia                 :  " + x.getCodigo());
				imprimir("Descripci�n                          :  " + x.getDescripcion());
				imprimir("Comentario                           :  " + x.getComentario());
				imprimir("Tiempo estimado de soluci�n en horas :  " + x.getTiempoEstimadoSol());
				imprimir("Tiempo real de soluci�n en horas     :  " + x.getTiempoRealSol());
				imprimir("Fecha de registro                    :  " + Lib.formatoFecha(x.getFechaRegistro()));
				imprimir("Fecha de inicio de atenci�n          :  " + Lib.formatoFecha(x.getFechaInicioAtencion()));
				imprimir("Fecha de fin de atenci�n             :  " + Lib.formatoFecha(x.getFechaFinAtencion()));
				imprimir("Estado                               :  " + Lib.tiposDeIncidencia[x.getEstado()]);
				imprimir("----------------------------------------------------");
			}
		}
	}
	public void incidenciaQueMenosDemoro() {
		Incidencia x;
		int menorTiempo = Proyecto_AED_2015_1.ai.obtener(0).getTiempoRealSol();	
		for (int i=1; i<Proyecto_AED_2015_1.ai.tama�o(); i++) {
			x = Proyecto_AED_2015_1.ai.obtener(i);
			if (menorTiempo > x.getTiempoRealSol())
				menorTiempo = x.getTiempoRealSol();
		}
		for (int i=0; i<Proyecto_AED_2015_1.ai.tama�o(); i++) {
			x = Proyecto_AED_2015_1.ai.obtener(i);
			if (menorTiempo == x.getTiempoRealSol()) {
				imprimir("C�digo de usuario                    :  " + x.getCodigoUsuario());
				imprimir("C�digo de especialista               :  " + x.getCodigoEspecialista());
				imprimir("C�digo de incidencia                 :  " + x.getCodigo());
				imprimir("Descripci�n                          :  " + x.getDescripcion());
				imprimir("Comentario                           :  " + x.getComentario());
				imprimir("Tiempo estimado de soluci�n en horas :  " + x.getTiempoEstimadoSol());
				imprimir("Tiempo real de soluci�n en horas     :  " + x.getTiempoRealSol());
				imprimir("Fecha de registro                    :  " + Lib.formatoFecha(x.getFechaRegistro()));
				imprimir("Fecha de inicio de atenci�n          :  " + Lib.formatoFecha(x.getFechaInicioAtencion()));
				imprimir("Fecha de fin de atenci�n             :  " + Lib.formatoFecha(x.getFechaFinAtencion()));
				imprimir("Estado                               :  " + Lib.tiposDeIncidencia[x.getEstado()]);
				imprimir("----------------------------------------------------");
			}
		}
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		dispose();
	}
	
	void cantidadDeIncidenciasCanceladas() {
		int c = 0;
		Incidencia x;
		for (int i=0; i<Proyecto_AED_2015_1.ai.tama�o(); i++) {
			x = Proyecto_AED_2015_1.ai.obtener(i);
			if (x.getEstado() == 3)
				c ++;
		}
		imprimir("Cantidad de incidencias canceladas : " + c);
	}
	void cantidadDeIncidenciasCerradas() {
		int c = 0;
		Incidencia x;
		for (int i=0; i<Proyecto_AED_2015_1.ai.tama�o(); i++) {
			x = Proyecto_AED_2015_1.ai.obtener(i);
			if (x.getEstado() == 4)
				c ++;
		}
		imprimir("Cantidad de incidencias cerradas : " + c);
	}
	int leerPosCboSucesos() {
		return cboSucesos.getSelectedIndex();		
	}
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	
}
