package gui;

import clases.TipoIncidencia;
import libreria.Lib;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class DlgTipoIncidenciaActividad extends JDialog implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;

	private JLabel lblCodigo;
	private JLabel lblDescripcion;	
	private JLabel lblAbreviacion;
	private JLabel lblEstado;
	private JTextArea txtDescripcion;
	private JScrollPane scrollPane;
	private JTextField txtAbreviacion;
	private JComboBox <String> cboEstado;
	private JButton btnAceptar;
	private JButton btnVolver;
	
	private int  tipoOperacion;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgTipoIncidenciaActividad dialog = new DlgTipoIncidenciaActividad();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgTipoIncidenciaActividad() {
		getContentPane().setFont(new Font("Cambria", Font.BOLD, 12));
		setResizable(false);
		setBounds(100, 100, 415, 350);
		getContentPane().setLayout(null);
	
		lblCodigo = new JLabel("C\u00D3DIGO");
		lblCodigo.setBounds(10, 11, 102, 23);
		getContentPane().add(lblCodigo);
		
		lblCodigo = new JLabel();
		lblCodigo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodigo.setBounds(102, 11, 126, 23);
		getContentPane().add(lblCodigo);
	
		lblDescripcion = new JLabel("DESCRIPCI\u00D3N");
		lblDescripcion.setBounds(10, 41, 94, 23);
		getContentPane().add(lblDescripcion);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 41, 300, 43);
		getContentPane().add(scrollPane);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollPane.setViewportView(txtDescripcion);
		
		lblAbreviacion = new JLabel("ABREVIACI\u00D3N");
		lblAbreviacion.setBounds(10, 91, 94, 23);
		getContentPane().add(lblAbreviacion);
		
		txtAbreviacion = new JTextField();
		txtAbreviacion.addActionListener(this);
		txtAbreviacion.addKeyListener(this);
		txtAbreviacion.setHorizontalAlignment(SwingConstants.LEFT);
		txtAbreviacion.setColumns(10);
		txtAbreviacion.setBounds(100, 91, 126, 23);
		getContentPane().add(txtAbreviacion);

		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(10, 121, 49, 23);
		getContentPane().add(lblEstado);
		
		cboEstado = new JComboBox <String> ();
		cboEstado.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeEstado));
		cboEstado.setBounds(100, 121, 80, 23);
		getContentPane().add(cboEstado);

		btnAceptar = new JButton("aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnAceptar.setBounds(150, 270, 109, 45);
		btnAceptar.setIcon(new ImageIcon("imagenes/aceptar.png"));
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("volver");
		btnVolver.setFont(new Font("Cambria", Font.BOLD, 12));
		btnVolver.addActionListener(this);
		btnVolver.setBounds(270, 270, 109, 45);
		btnVolver.setIcon(new ImageIcon("imagenes/volver.png"));
		getContentPane().add(btnVolver);	
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			actionPerformedBtnVolver(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == txtAbreviacion) {
			actionPerformedTxtAbreviacion(e);
		}
	}
	protected void actionPerformedTxtAbreviacion(ActionEvent e) {
		adicionarModificarTipoIncidencia(true);
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		switch (tipoOperacion) {
			case 0:			
				adicionarModificarTipoIncidencia(true);	
				break;
			case 1:
				consultarTipoIncidencia();
				break;
			case 2:
				adicionarModificarTipoIncidencia(false);
				break;
			default:
				eliminarTipoIncidencia();
		}
	}
	protected void actionPerformedBtnVolver(ActionEvent e) {
		dispose();	
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtAbreviacion) {
			keyPressedTxtAbreviacion(e);
		}
	}
	protected void keyPressedTxtAbreviacion(KeyEvent e) {
		Lib.soloLetras(e,txtAbreviacion,15);
	}
	//  Adicionar un nuevo tipo de incidencia
	private void adicionarModificarTipoIncidencia(boolean adicionar) {
		if (leerDescripcion().length() == 0) {
			txtDescripcion.requestFocus();
			Lib.mensajeError(this, "Ingrese DESCRIPCIÓN");
		}
		else
			if (leerAbreviacion().length() == 0) {
				txtAbreviacion.requestFocus();
				Lib.mensajeError(this, "Ingrese ABREVIACIÓN");
			}
			else {
				if (adicionar) {
					TipoIncidencia nueva = new TipoIncidencia(leerCodigo(), leerDescripcion(), 
								                              leerAbreviacion(), leerEstado());
					Proyecto_AED_2015_1.ati.adicionar(nueva);
					Lib.mensajeInformacion(this, "El Tipo de incidencia ha sido adicionada");
				}
				else {
					TipoIncidencia  x = Proyecto_AED_2015_1.ati.buscar(leerCodigo());
					x.setDescripcion(leerDescripcion());
					x.setAbreviacion(leerAbreviacion());
					x.setEstado(leerEstado());
					Lib.mensajeInformacion(this, "El Tipo de incidencia ha sido modificado");
				}
				dispose();
			}
	}
	//  Consultar el tipo de incidencia en curso
	private void consultarTipoIncidencia() {
		dispose();
	}
	//  Eliminar el tipo de inicidencia en curso
	private void eliminarTipoIncidencia() {
		int ok = Lib.confirmacion(this, "¿Está seguro de eliminar el Tipo de incidencia?");
		if (ok == 0) {
			TipoIncidencia x = Proyecto_AED_2015_1.ati.buscar(leerCodigo());
			Proyecto_AED_2015_1.ati.eliminar(x);
			Lib.mensajeInformacion(this, "El Tipo de incidencia ha sido eliminado");
			dispose();
		}
	}
	//  Establece el tipo de operación a afectuar
	public void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	//  Cargar los datos de un tipo de inicidencia
	public void cargarTipoIncidencia(TipoIncidencia x) {
		lblCodigo.setText(x.getCodigo() + "");
		txtDescripcion.setText(x.getDescripcion());
		txtAbreviacion.setText(x.getAbreviacion());	
		cboEstado.setSelectedIndex(x.getEstado());	
	}
	//  Configurar el formulario para la operación a efectuar
	public void configurarFormulario() {
		switch (tipoOperacion) {
			case 0:
				lblCodigo.setText(Proyecto_AED_2015_1.ati.generarCodigo() + "");
				habilitarCajasDeTexto(true);
				break;
			case 1:
				btnVolver.setVisible(false);
				habilitarCajasDeTexto(false);
				break;
			case 2:				
				habilitarCajasDeTexto(true);
				break;
			default:
				habilitarCajasDeTexto(false);
				break;
		}
	}
	//  Habilitar o deshabilitar las cajas de texto
	private void habilitarCajasDeTexto(boolean b) {
		txtDescripcion.setEditable(b);
		txtAbreviacion.setEditable(b);
		cboEstado.setEnabled(b);
	}
	//  Métodos que retornan valor sin parámetros
	private int leerCodigo() {
		return Lib.leerEntero(lblCodigo);
	}
	private String leerDescripcion() {
		return Lib.leerCadenaGrande(txtDescripcion);
	}
	private String leerAbreviacion() {
		return Lib.leerCadena(txtAbreviacion);
	}
	private int leerEstado() {
		return cboEstado.getSelectedIndex();
	}
}
