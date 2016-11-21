package gui;

import java.awt.EventQueue;



import clases.Sala;


import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;


import libreria.*;

import javax.swing.JComboBox;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class DlgSalasActividad extends JDialog implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private JLabel lblCdigoDeSala;
	private JLabel lblCdigoDeCine;
	private JLabel lblNumsala;
	private JComboBox <String> cboNumsala;
	private JLabel lblNumfila;
	private JComboBox <String> cboNumfila;
	private JLabel lblNumbutaca;
	private JComboBox <String> cboNumbutaca;
	
	private JButton btnAceptar;
	private JButton btnSalir;

	private int  tipoOperacion;
	private JLabel lblCodigoSala1;
	private JComboBox<String> cboCine;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgSalasActividad dialog = new DlgSalasActividad();
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
	public DlgSalasActividad() {
		setTitle("Mantenimiento | Salas | Ingreso");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AGAF\\Desktop\\CIBERTEC\\SEGUNDO CICLO\\1814 - ALGORITMOS Y ESTRUCTURA DE DATOS\\Proyecto_Sistema_Atencion_Cine\\Proyecto\\imagenes\\Cine.png"));
		setBounds(100, 100, 508, 395);
		getContentPane().setLayout(null);
		
		lblCdigoDeSala = new JLabel("C\u00F3digo de Sala");
		lblCdigoDeSala.setBounds(22, 28, 122, 14);
		getContentPane().add(lblCdigoDeSala);
		
		lblCdigoDeCine = new JLabel("C\u00F3digo de Cine");
		lblCdigoDeCine.setBounds(22, 55, 122, 14);
		getContentPane().add(lblCdigoDeCine);
		
		lblNumsala = new JLabel("Número de Sala");
		lblNumsala.setBounds(22, 93, 95, 14);
		getContentPane().add(lblNumsala);
		
		cboNumsala = new JComboBox <String> ();
		Fecha.colocarItems(cboNumsala,0,15);		
		cboNumsala.addActionListener(this);
		cboNumsala.setBounds(164, 89, 95, 23);
		getContentPane().add(cboNumsala);
		
		lblNumfila = new JLabel("Número de fila");
		lblNumfila.setBounds(22, 124, 131, 14);
		getContentPane().add(lblNumfila);
		
		cboNumfila = new JComboBox <String> ();
		Fecha.colocarItems(cboNumfila,0,25);
		cboNumfila.addActionListener(this);
		cboNumfila.setBounds(164, 120, 95, 23);
		getContentPane().add(cboNumfila);
		
		lblNumbutaca = new JLabel("Número de butaca");
		lblNumbutaca.setBounds(22, 162, 131, 14);
		getContentPane().add(lblNumbutaca);
		
		cboNumbutaca = new JComboBox <String> ();
		Fecha.colocarItems(cboNumbutaca,0,20);
		cboNumbutaca.addActionListener(this);
		cboNumbutaca.setBounds(164, 158, 95, 23);
		getContentPane().add(cboNumbutaca);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(134, 283, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(304, 283, 89, 23);
		getContentPane().add(btnSalir);
		
		lblCodigoSala1 = new JLabel("");
		lblCodigoSala1.setForeground(Color.BLUE);
		lblCodigoSala1.setBackground(Color.WHITE);
		lblCodigoSala1.setBounds(164, 28, 170, 20);
		getContentPane().add(lblCodigoSala1);
		
		cboCine = new JComboBox<String>();
		cboCine.setBounds(164, 55, 170, 23);
		Lib.colocarCines(cboCine);
		getContentPane().add(cboCine);

	}
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {
		dispose();
	}
	
//  Adicionar un nuevo usuario
	private void adicionarModificarSala(boolean adicionar) {
		
		if (leerNumsala() == 0) {
			cboNumsala.requestFocus();
			Lib.mensajeError(this, "Ingrese NUMERO DE SALA");
		}else if (leerNumfila() == 0) {
			cboNumfila.requestFocus();
			Lib.mensajeError(this, "Ingrese NUMERO DE FILA");
		}else if (leerNumbutaca() == 0) {
			cboNumbutaca.requestFocus();
			Lib.mensajeError(this, "Ingrese NUMERO DE BUTACA");
		}else if (adicionar) {
			Sala nuevo = new Sala(	leerCodigoSala(), 
									leerCodigocine(), 
                                    leerNumsala(),
                                    leerNumfila(),
                                    leerNumbutaca());
			Proyecto.as.adicionar(nuevo);
			Proyecto.as.grabarSala();
			Lib.mensajeInformacion(this, "La Sala ha sido adicionada");
		}else {
			Sala x = Proyecto.as.buscar(leerCodigoSala());
			x.setNumsala(leerNumsala());
			x.setNumfila(leerNumfila());
			x.setNumbutaca(leerNumbutaca());
			Lib.mensajeInformacion(this, "La Sala ha sido modificada");		
		}
		dispose();
		
	}
	
	
	
	private void consultarSala() {
		dispose();
	}
	
//  Eliminar el área en curso
	private void eliminarSala() {
		int ok = Lib.confirmacion(this, "¿Está seguro de eliminar la sala?");
		if (ok == 0) {
			Sala x = Proyecto.as.buscar(leerCodigoSala());
			Proyecto.as.eliminar(x);
			Lib.mensajeInformacion(this, "La Sala ha sido eliminada");
			dispose();
		}
	}
	
//  Establece el tipo de operación a afectuar
	public void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	
	//  Cargar los datos de un sala
	public void cargarSala(Sala x) {
		lblCodigoSala1.setText(x.getCodigosala() + "");
		cboCine.setSelectedIndex(x.getCodigocine());
		cboNumsala.setSelectedIndex(x.getNumsala());
		cboNumfila.setSelectedIndex(x.getNumfila());
		cboNumbutaca.setSelectedIndex(x.getNumbutaca());
		}
	
	public void configurarFormulario() {
		switch (tipoOperacion) {
			case 0:
				lblCodigoSala1.setText(Proyecto.as.generarCodigo() + "");
				
				Proyecto.aci.tamaño();
				//lblCodigoCine1.setText(Cine.);
				habilitarCajasDeTexto(true);
				break;
			case 1:
				btnSalir.setVisible(false);
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
		cboNumsala.setEnabled(b);
		cboNumfila.setEnabled(b);
		cboNumbutaca.setEnabled(b);
			
	}
	
	
//  Métodos que retornan valor (sin parámetros)
	private int leerCodigoSala() {
		return Lib.leerEntero(lblCodigoSala1);
	}
	private int leerCodigocine() {
		return Lib.leerEntero(cboCine);
	}
	private int leerNumsala() {
		return Lib.leerEntero(cboNumsala);
	}
	private int leerNumfila() {
		return Lib.leerEntero(cboNumfila);
	}
	
	private int leerNumbutaca() {
		return Lib.leerEntero(cboNumbutaca);
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		
		switch (tipoOperacion) {
			case 0:			
				adicionarModificarSala(true);	
				break;
			case 1:
				consultarSala();
				break;
			case 2:
				adicionarModificarSala(false);
				break;
			default:
				eliminarSala();
		}
	}
	
	protected void actionPerformedTxtNumbutaca(ActionEvent e) {
		adicionarModificarSala(true);
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
