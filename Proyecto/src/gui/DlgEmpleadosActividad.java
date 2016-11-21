package gui;

import java.awt.EventQueue;



import clases.Empleado;


import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;

import libreria.*;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class DlgEmpleadosActividad extends JDialog implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private JLabel lblCdigoDeEmpleado;
	private JLabel lblNombres;
	private JTextField txtNombres;
	private JLabel lblApellidoPaterno;
	private JTextField txtApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JTextField txtApellidoMaterno;
	private JLabel lblTipoDeEmpleado;
	private JComboBox<String> cboTipoDeEmpleado;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblContrasea;
	private JTextField txtContrasena;
	private JButton btnAceptar;
	private JButton btnSalir;

	private int  tipoOperacion;
	private JLabel lblCodigoEmpleado1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgEmpleadosActividad dialog = new DlgEmpleadosActividad();
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
	public DlgEmpleadosActividad() {
		setTitle("Mantenimiento | Empleados | Ingreso");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AGAF\\Desktop\\CIBERTEC\\SEGUNDO CICLO\\1814 - ALGORITMOS Y ESTRUCTURA DE DATOS\\Proyecto_Sistema_Atencion_Cine\\Proyecto\\imagenes\\Cine.png"));
		setBounds(100, 100, 564, 395);
		getContentPane().setLayout(null);
		
		lblCdigoDeEmpleado = new JLabel("C\u00F3digo de Empleado");
		lblCdigoDeEmpleado.setBounds(22, 31, 122, 14);
		getContentPane().add(lblCdigoDeEmpleado);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(22, 62, 95, 14);
		getContentPane().add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.addKeyListener(this);
		txtNombres.addActionListener(this);
		txtNombres.setColumns(10);
		txtNombres.setBounds(182, 59, 299, 20);
		getContentPane().add(txtNombres);
		
		lblApellidoPaterno = new JLabel("Apellido Paterno");
		lblApellidoPaterno.setBounds(22, 93, 131, 14);
		getContentPane().add(lblApellidoPaterno);
		
		txtApellidoPaterno = new JTextField();
		txtApellidoPaterno.addKeyListener(this);
		txtApellidoPaterno.addActionListener(this);
		txtApellidoPaterno.setColumns(10);
		txtApellidoPaterno.setBounds(182, 90, 152, 20);
		getContentPane().add(txtApellidoPaterno);
		
		lblApellidoMaterno = new JLabel("Apellido Paterno");
		lblApellidoMaterno.setBounds(22, 124, 131, 14);
		getContentPane().add(lblApellidoMaterno);
		
		txtApellidoMaterno = new JTextField();
		txtApellidoMaterno.addKeyListener(this);
		txtApellidoMaterno.addActionListener(this);
		txtApellidoMaterno.setColumns(10);
		txtApellidoMaterno.setBounds(182, 121, 152, 20);
		getContentPane().add(txtApellidoMaterno);
		
		lblTipoDeEmpleado = new JLabel("Tipo de Empleado");
		lblTipoDeEmpleado.setBounds(22, 159, 106, 14);
		getContentPane().add(lblTipoDeEmpleado);
		
		cboTipoDeEmpleado = new JComboBox<String>();
		cboTipoDeEmpleado.setModel(new DefaultComboBoxModel<String>(new String[] {"Administrador", "Supervisor", "Cajero"}));
		cboTipoDeEmpleado.setBounds(182, 156, 141, 20);
		getContentPane().add(cboTipoDeEmpleado);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(22, 190, 46, 14);
		getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(this);
		txtUsuario.addActionListener(this);
		txtUsuario.setBounds(182, 187, 114, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(22, 221, 70, 14);
		getContentPane().add(lblContrasea);
		
		txtContrasena = new JTextField();
		txtContrasena.addKeyListener(this);
		txtContrasena.addActionListener(this);
		txtContrasena.setBounds(182, 218, 114, 20);
		getContentPane().add(txtContrasena);
		txtContrasena.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(134, 283, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(304, 283, 89, 23);
		getContentPane().add(btnSalir);
		
		lblCodigoEmpleado1 = new JLabel("");
		lblCodigoEmpleado1.setForeground(Color.BLUE);
		lblCodigoEmpleado1.setBackground(Color.WHITE);
		lblCodigoEmpleado1.setBounds(182, 28, 299, 20);
		getContentPane().add(lblCodigoEmpleado1);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtContrasena) {
			actionPerformedTxtContrasena(e);
		}
		if (e.getSource() == txtUsuario) {
			actionPerformedTxtUsuario(e);
		}
		if (e.getSource() == txtApellidoMaterno) {
			actionPerformedTxtApellidoMaterno(e);
		}
		if (e.getSource() == txtApellidoPaterno) {
			actionPerformedTxtApellidoPaterno(e);
		}
		if (e.getSource() == txtNombres) {
			actionPerformedTxtNombres(e);
		}
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
	private void adicionarModificarEmpleado(boolean adicionar) {		
		if (leerNombres().length() == 0) {
			txtNombres.requestFocus();
			Lib.mensajeError(this, "Ingrese NOMBRES");
		}
		else
			if (leerApellidoPaterno().length() == 0) {
				txtApellidoPaterno.requestFocus();
				Lib.mensajeError(this, "Ingrese APELLIDO PATERNO");
			}
			else
				if (leerApellidoMaterno().length() == 0) {
					txtApellidoMaterno.requestFocus();
					Lib.mensajeError(this, "Ingrese APELLIDO MATERNO");
				}
				else 
					if (leerUsuario().length() == 0) {
						txtUsuario.requestFocus();
						Lib.mensajeError(this, "Ingrese USUARIO");
					}
					else 
						if (leerContraseña().length() == 0) {
							txtContrasena.requestFocus();
							Lib.mensajeError(this, "Ingrese CONTRASEÑA");
						}
						else {
							if (adicionar) {
								Empleado nuevo = new Empleado(leerCodigo(), leerNombres(), 
			                                                leerApellidoPaterno(),leerApellidoMaterno(),
			                                                leerPosTipoEmpleado(),
			                                                leerUsuario(),leerContraseña());
								Proyecto.ae.adicionar(nuevo);
								Lib.mensajeInformacion(this, "El Empleado ha sido adicionado");
							}
							else {
								Empleado x = Proyecto.ae.buscar(leerCodigo());
								x.setNombres(leerNombres());
								x.setApellidoPaterno(leerApellidoPaterno());
								x.setApellidoMaterno(leerApellidoMaterno());
								x.setTipoEmpleado(leerPosTipoEmpleado());
								x.setUsuario(leerUsuario());
								x.setContraseña(leerContraseña());
								Lib.mensajeInformacion(this, "El Usuario ha sido modificado");		
							}
							dispose();
						}
	}
	
	
	private void consultarEmpleado() {
		dispose();
	}
	
//  Eliminar el área en curso
	private void eliminarEmpleado() {
		int ok = Lib.confirmacion(this, "¿Está seguro de eliminar el Usuario?");
		if (ok == 0) {
			Empleado x = Proyecto.ae.buscar(leerCodigo());
			Proyecto.ae.eliminar(x);
			Lib.mensajeInformacion(this, "El Usuario ha sido eliminado");
			dispose();
		}
	}
	
//  Establece el tipo de operación a afectuar
	public void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	
	//  Cargar los datos de un empleado
	public void cargarEmpleado(Empleado x) {
		lblCodigoEmpleado1.setText(x.getCodigoEmpleado() + "");
		txtNombres.setText(x.getNombres());
		txtApellidoPaterno.setText(x.getApellidoPaterno());
		txtApellidoMaterno.setText(x.getApellidoMaterno());
		cboTipoDeEmpleado.setSelectedIndex(x.getTipoEmpleado());
		txtUsuario.setText(x.getUsuario());
		txtContrasena.setText(x.getContraseña());
			}
	
	public void configurarFormulario() {
		switch (tipoOperacion) {
			case 0:
				lblCodigoEmpleado1.setText(Proyecto.ae.generarCodigo() + "");
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
		txtNombres.setEditable(b);
		txtApellidoPaterno.setEditable(b);
		txtApellidoMaterno.setEditable(b);
		cboTipoDeEmpleado.setEnabled(b);
		txtUsuario.setEditable(b);
		txtContrasena.setEnabled(b);
	
	}
	
	
//  Métodos que retornan valor (sin parámetros)
	private int leerCodigo() {
		return Lib.leerEntero(lblCodigoEmpleado1);
	}
	private String leerNombres() {
		return Lib.leerCadena(txtNombres);
	}
	private String leerApellidoPaterno() {
		return Lib.leerCadena(txtApellidoPaterno);
	}
	
	private String leerApellidoMaterno() {
		return Lib.leerCadena(txtApellidoMaterno);
	}
	
	private int leerPosTipoEmpleado() {
		return cboTipoDeEmpleado.getSelectedIndex();
	}
	private String leerUsuario() {
		return Lib.leerCadena(txtUsuario);
	}
	
	private String leerContraseña() {
		return Lib.leerCadena(txtContrasena);
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		
		switch (tipoOperacion) {
			case 0:			
				adicionarModificarEmpleado(true);	
				break;
			case 1:
				consultarEmpleado();
				break;
			case 2:
				adicionarModificarEmpleado(false);
				break;
			default:
				eliminarEmpleado();
		}
	}
	protected void actionPerformedTxtNombres(ActionEvent e) {
		txtApellidoPaterno.requestFocus();
	}
	protected void actionPerformedTxtApellidoPaterno(ActionEvent e) {
		txtApellidoMaterno.requestFocus();
	}
	protected void actionPerformedTxtApellidoMaterno(ActionEvent e) {
		txtUsuario.requestFocus();
	}
	protected void actionPerformedTxtUsuario(ActionEvent e) {
		txtContrasena.requestFocus();
	}
	protected void actionPerformedTxtContrasena(ActionEvent e) {
		adicionarModificarEmpleado(true);
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtContrasena) {
			keyTypedTxtContrasena(e);
		}
		if (e.getSource() == txtUsuario) {
			keyTypedTxtUsuario(e);
		}
		if (e.getSource() == txtApellidoMaterno) {
			keyTypedTxtApellidoMaterno(e);
		}
		if (e.getSource() == txtApellidoPaterno) {
			keyTypedTxtApellidoPaterno(e);
		}
		if (e.getSource() == txtNombres) {
			keyTypedTxtNombres(e);
		}
	}
	
	
	
	protected void keyTypedTxtNombres(KeyEvent e) {
		Lib.soloLetras(e,txtNombres,30);
	}
	
	protected void keyTypedTxtApellidoPaterno(KeyEvent e) {
		Lib.soloLetras(e,txtApellidoPaterno,20);
	}
	
	protected void keyTypedTxtApellidoMaterno(KeyEvent e) {
		Lib.soloLetras(e,txtApellidoMaterno,20);

	}
	
	protected void keyTypedTxtUsuario(KeyEvent e) {
		Lib.soloLetras(e,txtUsuario,15);

	}
	
	protected void keyTypedTxtContrasena(KeyEvent e) {
		Lib.soloLetras(e,txtContrasena,15);

	}
}
