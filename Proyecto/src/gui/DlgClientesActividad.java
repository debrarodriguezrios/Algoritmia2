package gui;

import java.awt.EventQueue;



import clases.Cliente;


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

public class DlgClientesActividad extends JDialog implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private JLabel lblCdigoDeCliente;
	private JLabel lblNombres;
	private JTextField txtNombres;
	private JLabel lblApellidoPaterno;
	private JTextField txtApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JTextField txtApellidoMaterno;
	private JLabel lblDireccion;
	private JTextField txtDireccion;
	private JLabel lblFechanac;
	private JComboBox <String> cboNacDia;
	private JComboBox <String> cboNacMes;
	private JComboBox <String> cboNacAño;
	private JLabel lblFechaafil;
	private JComboBox <String> cboAfilDia;
	private JComboBox <String> cboAfilMes;
	private JComboBox <String> cboAfilAño;
	private JLabel lblEstadocivil;
	private JComboBox<String> cboEstadocivil;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblContrasea;
	private JTextField txtContrasena;
	private JButton btnAceptar;
	private JButton btnSalir;

	private int  tipoOperacion;
	private JLabel lblCodigocliente1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgClientesActividad dialog = new DlgClientesActividad();
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
	public DlgClientesActividad() {
		setTitle("Mantenimiento | Clientes | Ingreso");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AGAF\\Desktop\\CIBERTEC\\SEGUNDO CICLO\\1814 - ALGORITMOS Y ESTRUCTURA DE DATOS\\Proyecto_Sistema_Atencion_Cine\\Proyecto\\imagenes\\Cine.png"));
		setBounds(100, 100, 564, 545);
		getContentPane().setLayout(null);
		
		lblCdigoDeCliente = new JLabel("C\u00F3digo de Cliente");
		lblCdigoDeCliente.setBounds(22, 31, 122, 14);
		getContentPane().add(lblCdigoDeCliente);
		
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
		
		lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setBounds(22, 124, 131, 14);
		getContentPane().add(lblApellidoMaterno);
		
		txtApellidoMaterno = new JTextField();
		txtApellidoMaterno.addKeyListener(this);
		txtApellidoMaterno.addActionListener(this);
		txtApellidoMaterno.setColumns(10);
		txtApellidoMaterno.setBounds(182, 121, 152, 20);
		getContentPane().add(txtApellidoMaterno);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(22, 151, 131, 14);
		getContentPane().add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.addKeyListener(this);
		txtDireccion.addActionListener(this);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(182, 148, 299, 20);
		getContentPane().add(txtDireccion);
		
		lblFechanac = new JLabel("Fecha de Nacimiento");
		lblFechanac.setBounds(22, 186, 148, 23);
		getContentPane().add(lblFechanac);
		
		cboNacDia = new JComboBox <String> ();
		Fecha.colocarItems(cboNacDia,1,31);
		Fecha.colocarDiaActual(cboNacDia);
		cboNacDia.addActionListener(this);
		cboNacDia.setBounds(182, 186, 40, 23);
		getContentPane().add(cboNacDia);
		
		cboNacMes = new JComboBox <String> ();
		Fecha.colocarMeses(cboNacMes);
		Fecha.colocarMesActual(cboNacMes);
		cboNacMes.addActionListener(this);
		cboNacMes.setBounds(234, 186, 90, 23);
		getContentPane().add(cboNacMes);
		
		cboNacAño = new JComboBox <String> ();
		Fecha.colocarItems(cboNacAño,Fecha.añoActual(),2000);
		cboNacAño.addActionListener(this);
		cboNacAño.setBounds(336, 186, 60, 23);
		getContentPane().add(cboNacAño);
		
		lblFechaafil = new JLabel("Fecha de Afiliaci\u00F3n");
		lblFechaafil.setBounds(22, 222, 122, 23);
		getContentPane().add(lblFechaafil);
		
		cboAfilDia = new JComboBox <String> ();
		Fecha.colocarItems(cboAfilDia,1,31);
		Fecha.colocarDiaActual(cboAfilDia);
		cboAfilDia.addActionListener(this);
		cboAfilDia.setBounds(182, 222, 40, 23);
		getContentPane().add(cboAfilDia);
		
		cboAfilMes = new JComboBox <String> ();
		Fecha.colocarMeses(cboAfilMes);
		Fecha.colocarMesActual(cboAfilMes);
		cboAfilMes.addActionListener(this);
		cboAfilMes.setBounds(234, 222, 90, 23);
		getContentPane().add(cboAfilMes);
		
		cboAfilAño = new JComboBox <String> ();
		Fecha.colocarItems(cboAfilAño,Fecha.añoActual(),2000);
		cboAfilAño.addActionListener(this);
		cboAfilAño.setBounds(336, 222, 60, 23);
		getContentPane().add(cboAfilAño);
		
		lblEstadocivil = new JLabel("Estado Civil");
		lblEstadocivil.setBounds(22, 258, 106, 14);
		getContentPane().add(lblEstadocivil);
		
		cboEstadocivil = new JComboBox<String>();
		cboEstadocivil.setModel(new DefaultComboBoxModel<String>(new String[] {"Soltero", "Casado", "Viudo", "Divorciado"}));
		cboEstadocivil.setBounds(183, 258, 141, 20);
		getContentPane().add(cboEstadocivil);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(22, 298, 131, 14);
		getContentPane().add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(this);
		txtTelefono.addActionListener(this);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(182, 295, 152, 20);
		getContentPane().add(txtTelefono);
		
		lblDni = new JLabel("Dni");
		lblDni.setBounds(22, 331, 131, 14);
		getContentPane().add(lblDni);
		
		txtDni = new JTextField();
		txtDni.addKeyListener(this);
		txtDni.addActionListener(this);
		txtDni.setColumns(10);
		txtDni.setBounds(182, 328, 152, 20);
		getContentPane().add(txtDni);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(22, 364, 46, 14);
		getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(this);
		txtUsuario.addActionListener(this);
		txtUsuario.setBounds(182, 361, 114, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(22, 400, 70, 14);
		getContentPane().add(lblContrasea);
		
		txtContrasena = new JTextField();
		txtContrasena.addKeyListener(this);
		txtContrasena.addActionListener(this);
		txtContrasena.setBounds(182, 397, 114, 20);
		getContentPane().add(txtContrasena);
		txtContrasena.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(144, 447, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(307, 447, 89, 23);
		getContentPane().add(btnSalir);
		
		lblCodigocliente1 = new JLabel("");
		lblCodigocliente1.setForeground(Color.BLUE);
		lblCodigocliente1.setBackground(Color.WHITE);
		lblCodigocliente1.setBounds(182, 28, 299, 20);
		getContentPane().add(lblCodigocliente1);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtContrasena) {
			actionPerformedTxtContrasena(e);
		}
		if (e.getSource() == txtUsuario) {
			actionPerformedTxtUsuario(e);
		}
		if (e.getSource() == txtDni) {
			actionPerformedTxtDni(e);
		}
		if (e.getSource() == txtTelefono) {
			actionPerformedTxtTelefono(e);
		}
		if (e.getSource() == txtDireccion) {
			actionPerformedTxtDireccion(e);
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
	private void adicionarModificarCliente(boolean adicionar) {		
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
					if (leerDireccion().length() == 0) {
						txtDireccion.requestFocus();
						Lib.mensajeError(this, "Ingrese DIRECCION");
					}
					else
						if(leerFechaNacimiento().length()==0){
							cboNacDia.requestFocus();
							Lib.mensajeError(this, "Ingrese una fecha de nacimiento valida");
						}else
							if(leerFechaAfiliacion().length()==0){
								cboAfilDia.requestFocus();
								Lib.mensajeError(this, "Ingrese una fecha de afiliación valida");
							}else
							if (leerTelefono().length() == 0) {
									txtTelefono.requestFocus();
									Lib.mensajeError(this, "Ingrese TELEFONO");
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
												Cliente nuevo = new Cliente(leerCodigo(), leerNombres(), 
			                                                leerApellidoPaterno(),leerApellidoMaterno(),
			                                                leerDireccion(), leerFechaNacimiento(),leerFechaAfiliacion(), 
			                                                leerEstadocivil(), leerTelefono(), leerDni(),
			                                                leerUsuario(),leerContraseña());
								Proyecto.ac.adicionar(nuevo);
								Lib.mensajeInformacion(this, "El Cliente ha sido adicionado");
							}
							else {
								Cliente x = Proyecto.ac.buscar(leerCodigo());
								x.setNombres(leerNombres());
								x.setApellidoPaterno(leerApellidoPaterno());
								x.setApellidoMaterno(leerApellidoMaterno());
								x.setDireccion(leerDireccion());
								x.setFechanac(leerFechaNacimiento());
								x.setFechaafil(leerFechaAfiliacion());
								x.setEstadocivil(leerEstadocivil());
								x.setTelefono(leerTelefono());
								x.setDni(leerDni());
								x.setUsuario(leerUsuario());
								x.setContraseña(leerContraseña());
								Lib.mensajeInformacion(this, "El Cliente ha sido modificado");		
							}
							dispose();
						}
	}
	
	
	private void consultarCliente() {
		dispose();
	}
	
//  Eliminar el área en curso
	private void eliminarCliente() {
		int ok = Lib.confirmacion(this, "¿Está seguro de eliminar el Cliente?");
		if (ok == 0) {
			Cliente x = Proyecto.ac.buscar(leerCodigo());
			Proyecto.ac.eliminar(x);
			Lib.mensajeInformacion(this, "El Cliente ha sido eliminado");
			dispose();
		}
	}
	
//  Establece el tipo de operación a afectuar
	public void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	
	//  Cargar los datos de un cliente
	public void cargarCliente(Cliente x) {
		lblCodigocliente1.setText(x.getCodigocliente() + "");
		txtNombres.setText(x.getNombres());
		txtApellidoPaterno.setText(x.getApellidoPaterno());
		txtApellidoMaterno.setText(x.getApellidoMaterno());
		txtDireccion.setText(x.getDireccion());
		
		//Fecha.setFecha(cboNacDia,cboNacMes,cboNacAño,x.getFechanac());
		//Fecha.setFecha(cboAfilDia,cboAfilMes,cboAfilAño,x.getFechaafil());
		cboEstadocivil.setSelectedIndex(x.getEstadocivil());
		txtTelefono.setText(x.getTelefono());
		txtDni.setText(x.getDni());
		txtUsuario.setText(x.getUsuario());
		txtContrasena.setText(x.getContraseña());
			}
	
	public void configurarFormulario() {
		switch (tipoOperacion) {
			case 0:
				lblCodigocliente1.setText(Proyecto.ac.generarCodigo() + "");
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
		txtDireccion.setEditable(b);
		cboNacDia.setEnabled(b);
		cboNacMes.setEnabled(b);
		cboNacAño.setEnabled(b);
		cboAfilDia.setEnabled(b);
		cboAfilMes.setEnabled(b);
		cboAfilAño.setEnabled(b);
		cboEstadocivil.setEnabled(b);
		txtTelefono.setEditable(b);
		txtDni.setEditable(b);
		txtUsuario.setEditable(b);
		txtContrasena.setEnabled(b);
	
	}
	
	
//  Métodos que retornan valor (sin parámetros)
	private int leerCodigo() {
		return Lib.leerEntero(lblCodigocliente1);
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
	private String leerDireccion() {
		return Lib.leerCadena(txtDireccion);
	}
	private String leerFechaNacimiento() {
		String dia = (String)cboNacDia.getSelectedItem();
		String mes = (String)cboNacMes.getSelectedItem();
		String año = (String)cboNacAño.getSelectedItem();
		String fecha = "";
		try {
			fecha = Lib.formatoFecha(dia, mes, año, "");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return fecha;
	}
	private String leerFechaAfiliacion() {
		String dia = (String)cboAfilDia.getSelectedItem();
		String mes = (String)cboAfilMes.getSelectedItem();
		String año = (String)cboAfilAño.getSelectedItem();
		String fecha = "";
		try {
			fecha = Lib.formatoFecha(dia, mes, año, "");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return fecha;
	}
	
	private int leerEstadocivil() {
		return cboEstadocivil.getSelectedIndex();
	}
	private String leerTelefono() {
		return Lib.leerCadena(txtTelefono);
	}
	private String leerDni() {
		return Lib.leerCadena(txtDni);
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
				adicionarModificarCliente(true);	
				break;
			case 1:
				consultarCliente();
				break;
			case 2:
				adicionarModificarCliente(false);
				break;
			default:
				eliminarCliente();
		}
	}
	protected void actionPerformedTxtNombres(ActionEvent e) {
		txtApellidoPaterno.requestFocus();
	}
	protected void actionPerformedTxtApellidoPaterno(ActionEvent e) {
		txtApellidoMaterno.requestFocus();
	}
	protected void actionPerformedTxtApellidoMaterno(ActionEvent e) {
		txtDireccion.requestFocus();
	}
	
	protected void actionPerformedTxtFechaafil(ActionEvent e) {
		txtTelefono.requestFocus();
	}
	protected void actionPerformedTxtTelefono(ActionEvent e) {
		txtDni.requestFocus();
	}
	protected void actionPerformedTxtDireccion(ActionEvent e) {
		txtDireccion.requestFocus();
	}
	protected void actionPerformedTxtDni(ActionEvent e) {
		txtUsuario.requestFocus();
	}
	protected void actionPerformedTxtUsuario(ActionEvent e) {
		txtContrasena.requestFocus();
	}
	protected void actionPerformedTxtContrasena(ActionEvent e) {
		adicionarModificarCliente(true);
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
		if (e.getSource() == txtDni) {
			keyTypedTxtDni(e);
		}
		if (e.getSource() == txtTelefono) {
			keyTypedTxtTelefono(e);
		}
		
		if (e.getSource() == txtDireccion) {
			keyTypedTxtDireccion(e);
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
	
	protected void keyTypedTxtDireccion(KeyEvent e) {
		Lib.soloLetras(e,txtDireccion,20);

	}
	
	protected void keyTypedTxtTelefono(KeyEvent e) {
		Lib.soloLetras(e,txtTelefono,20);

	}
	protected void keyTypedTxtDni(KeyEvent e) {
		Lib.soloLetras(e,txtDni,20);

	}
	
	protected void keyTypedTxtUsuario(KeyEvent e) {
		Lib.soloLetras(e,txtUsuario,15);

	}
	
	protected void keyTypedTxtContrasena(KeyEvent e) {
		Lib.soloLetras(e,txtContrasena,15);

	}
}
