package gui;

import clases.Incidencia;
import clases.Usuario;
import libreria.Lib;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DlgIncidenciasPorArea extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblArea;
	private JComboBox <String> cboArea;
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
			DlgIncidenciasPorArea dialog = new DlgIncidenciasPorArea();
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
	public DlgIncidenciasPorArea() {
		getContentPane().setLayout(null);
		setResizable(false);
		setTitle("Reporte | Incidencias por Area");
		setBounds(100, 100, 595, 520);
		
		lblArea = new JLabel("AREA DE:");
		lblArea.setBounds(10, 23, 100, 23);
		getContentPane().add(lblArea);
		
		cboArea = new JComboBox <String> ();
		cboArea.addActionListener(this);
		cboArea.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeArea));
		cboArea.setBounds(70, 23, 150, 23);
		getContentPane().add(cboArea);
		
		btnVolver = new JButton("volver");
		btnVolver.addActionListener(this);
		btnVolver.setBounds(470, 11, 109, 45);
		btnVolver.setIcon(new ImageIcon("imagenes/volver.png"));
		getContentPane().add(btnVolver);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 569, 407);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 11));
		scrollPane.setViewportView(txtS);
		
		buscarIncidencia();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboArea) {
			actionPerformedCboArea(arg0);
		}
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
	}
	protected void actionPerformedCboArea(ActionEvent arg0) {
		buscarIncidencia();
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		dispose();
	}
	void buscarIncidencia() {
		txtS.setText("");
		Usuario x;
		Incidencia y;
		for (int i=0; i<Proyecto_AED_2015_1.au.tama�o(); i++) {							
			x = Proyecto_AED_2015_1.au.obtener(i);				
			if (posArea() == x.getArea())
				for (int j=0; j<Proyecto_AED_2015_1.ai.tama�o(); j++) {
					y = Proyecto_AED_2015_1.ai.obtener(j);
					if (x.getCodigo() == y.getCodigoUsuario()) {
						imprimir("C�digo de usuario                    :  " + y.getCodigoUsuario());
						imprimir("C�digo del tipo de incidencia        :  " + y.getCodigoTipoIncidencia());
						imprimir("C�digo de especialista               :  " + y.getCodigoEspecialista());
						imprimir("C�digo de incidencia                 :  " + y.getCodigo());
						imprimir("Descripci�n                          :  " + y.getDescripcion());
						imprimir("Comentario                           :  " + y.getComentario());
						imprimir("Tiempo estimado de soluci�n en horas :  " + y.getTiempoEstimadoSol());
						imprimir("Tiempo real de soluci�n en horas     :  " + y.getTiempoRealSol());
						imprimir("Fecha de registro                    :  " + Lib.formatoFecha(y.getFechaRegistro()));
						imprimir("Fecha de inicio de atenci�n          :  " + Lib.formatoFecha(y.getFechaInicioAtencion()));
						imprimir("Fecha de fin de atenci�n             :  " + Lib.formatoFecha(y.getFechaFinAtencion()));
						imprimir("Estado                               :  " + Lib.tiposDeIncidencia[y.getEstado()]); 
						imprimir("------------------------------------------------------------------------------");
					}
				}
		}
	}
	void imprimir(String s) {
		txtS.append(s + "\n"); 
	}
	int posArea() {
		return cboArea.getSelectedIndex();		
	}
}
