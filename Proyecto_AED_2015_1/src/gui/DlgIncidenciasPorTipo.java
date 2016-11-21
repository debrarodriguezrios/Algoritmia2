package gui;

import clases.Incidencia;
import clases.TipoIncidencia;
import libreria.Lib;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class DlgIncidenciasPorTipo extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblTipoIncidencia;
	private JComboBox <String> cboTipoIncidencia;
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
			DlgIncidenciasPorTipo dialog = new DlgIncidenciasPorTipo();
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
	public DlgIncidenciasPorTipo() {
		getContentPane().setLayout(null);
		setResizable(false);
		setTitle("Reporte | Incidencias por Tipo");
		setBounds(100, 100, 595, 520);
		
		lblTipoIncidencia = new JLabel("CÓDIGO DEL TIPO DE INCIDENCIA:");
		lblTipoIncidencia.setBounds(10, 23, 200, 23);
		getContentPane().add(lblTipoIncidencia);
		
		cboTipoIncidencia = new JComboBox <String> ();
		colocarTipoIncidencias();
		cboTipoIncidencia.addActionListener(this);
		cboTipoIncidencia.setBounds(205, 23, 70, 23);
		getContentPane().add(cboTipoIncidencia);
		
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
		if (arg0.getSource() == cboTipoIncidencia) {
			actionPerformedCboTipoIncidencia(arg0);
		}
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
	}
	protected void actionPerformedCboTipoIncidencia(ActionEvent arg0) {
		buscarIncidencia();
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		dispose();
	}
	void colocarTipoIncidencias() {
		TipoIncidencia x;
		for (int i=0; i<Proyecto_AED_2015_1.ati.tamaño(); i++) {
			x = Proyecto_AED_2015_1.ati.obtener(i);
			cboTipoIncidencia.addItem(x.getCodigo() + "");
		}	
	}
	void buscarIncidencia() {
		txtS.setText("");
		Incidencia x;
		for (int i=0; i<Proyecto_AED_2015_1.ai.tamaño(); i++) {							
			x = Proyecto_AED_2015_1.ai.obtener(i);				
			if (codigoSeleccionado() == x.getCodigoTipoIncidencia()) {
				imprimir("Código de usuario                    :  " + x.getCodigoUsuario());
				imprimir("Código de especialista               :  " + x.getCodigoEspecialista());
				imprimir("Código de incidencia                 :  " + x.getCodigo());
				imprimir("Descripción                          :  " + x.getDescripcion());
				imprimir("Comentario                           :  " + x.getComentario());
				imprimir("Tiempo estimado de solución en horas :  " + x.getTiempoEstimadoSol());
				imprimir("Tiempo real de solución en horas     :  " + x.getTiempoRealSol());
				imprimir("Fecha de registro                    :  " + Lib.formatoFecha(x.getFechaRegistro()));
				imprimir("Fecha de inicio de atención          :  " + Lib.formatoFecha(x.getFechaInicioAtencion()));
				imprimir("Fecha de fin de atención             :  " + Lib.formatoFecha(x.getFechaFinAtencion()));
				imprimir("Estado                               :  " + Lib.tiposDeIncidencia[x.getEstado()]); 
				imprimir("------------------------------------------------------------------------------");		
			}
		}
	}
	void imprimir(String s) {
		txtS.append(s + "\n"); 
	}
	int codigoSeleccionado() {
		return Integer.parseInt(cboTipoIncidencia.getSelectedItem().toString());		
	}
}
