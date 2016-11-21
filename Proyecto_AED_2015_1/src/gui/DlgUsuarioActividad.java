package gui;

import clases.Usuario;
import libreria.*;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.event.KeyListener;

public class DlgUsuarioActividad extends JDialog implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;

	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JLabel lblApellidos;	
	private JLabel lblTipoID;
	private JLabel lblNumeroID;
	private JLabel lblArea;
	private JLabel lblCorreo;
	private JLabel lblTelefono;
	private JLabel lblFechaIngreso;
	private JLabel lblEstado;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtNumeroID;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JComboBox <String> cboTipoID;
	private JComboBox <String> cboArea;
	private JComboBox <String> cboIngresoDia;
	private JComboBox <String> cboIngresoMes;
	private JComboBox <String> cboIngresoAño;
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
					DlgUsuarioActividad dialog = new DlgUsuarioActividad();
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
	public DlgUsuarioActividad() {
		getContentPane().setFont(new Font("Cambria", Font.BOLD, 12));
		setResizable(false);
		setBounds(100, 100, 375, 430);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("C\u00D3DIGO");
		lblCodigo.setBounds(10, 11, 102, 23);
		getContentPane().add(lblCodigo);
		
		lblCodigo = new JLabel();
		lblCodigo.setBounds(102, 11, 126, 23);
		getContentPane().add(lblCodigo);
		
		lblNombres = new JLabel("NOMBRES");
		lblNombres.setBounds(10, 41, 94, 23);
		getContentPane().add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.addKeyListener(this);
		txtNombres.addActionListener(this);
		txtNombres.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombres.setColumns(10);
		txtNombres.setBounds(100, 41, 126, 23);
		getContentPane().add(txtNombres);
	
		lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setBounds(10, 71, 94, 23);
		getContentPane().add(lblApellidos);
	
		txtApellidos = new JTextField();
		txtApellidos.addKeyListener(this);
		txtApellidos.addActionListener(this);
		txtApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(100, 71, 126, 23);
		getContentPane().add(txtApellidos);
		
		lblTipoID = new JLabel("TIPO ID");
		lblTipoID.setBounds(10, 101, 94, 23);
		getContentPane().add(lblTipoID);

		cboTipoID = new JComboBox <String> ();
		cboTipoID.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeID));
		cboTipoID.setBounds(100, 101, 126, 23);
		getContentPane().add(cboTipoID);
		
		lblNumeroID = new JLabel("NÚMERO ID");
		lblNumeroID.setBounds(10, 131, 126, 19);
		getContentPane().add(lblNumeroID);
		
		txtNumeroID = new JTextField();
		txtNumeroID.addKeyListener(this);
		txtNumeroID.addActionListener(this);
		txtNumeroID.setHorizontalAlignment(SwingConstants.LEFT);
		txtNumeroID.setColumns(10);
		txtNumeroID.setBounds(100, 131, 126, 23);
		getContentPane().add(txtNumeroID);		

		lblArea = new JLabel("ÁREA");
		lblArea.setBounds(10, 161, 55, 23);
		getContentPane().add(lblArea);	

		cboArea = new JComboBox <String> ();
		cboArea.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeArea));
		
		cboArea.setBounds(100, 161, 126, 23);
		getContentPane().add(cboArea);
		
		lblCorreo = new JLabel("CORREO");
		lblCorreo.setBounds(10, 191, 55, 23);
		getContentPane().add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.addKeyListener(this);
		txtCorreo.addActionListener(this);
		txtCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(100, 191, 126, 23);
		getContentPane().add(txtCorreo);	
		
		lblTelefono = new JLabel("TELÉFONO");
		lblTelefono.setBounds(10, 221, 126, 23);
		getContentPane().add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(this);
		txtTelefono.addActionListener(this);
		txtTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(100, 221, 126, 23);
		getContentPane().add(txtTelefono);	
		
		lblFechaIngreso = new JLabel("INGRESO");
		lblFechaIngreso.setBounds(10, 251, 94, 23);
		getContentPane().add(lblFechaIngreso);
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(10, 281, 55, 23);
		getContentPane().add(lblEstado);

		cboIngresoDia = new JComboBox <String> ();
		Fecha.colocarItems(cboIngresoDia,1,31);
		Fecha.colocarDiaActual(cboIngresoDia);
		cboIngresoDia.addActionListener(this);
		cboIngresoDia.setBounds(100, 251, 40, 23);
		getContentPane().add(cboIngresoDia);
		
		cboIngresoMes = new JComboBox <String> ();
		Fecha.colocarMeses(cboIngresoMes);
		Fecha.colocarMesActual(cboIngresoMes);
		cboIngresoMes.addActionListener(this);
		cboIngresoMes.setBounds(140, 251, 90, 23);
		getContentPane().add(cboIngresoMes);
		
		cboIngresoAño = new JComboBox <String> ();
		Fecha.colocarItems(cboIngresoAño,Fecha.añoActual(),2000);
		cboIngresoAño.addActionListener(this);
		cboIngresoAño.setBounds(230, 251, 60, 23);
		getContentPane().add(cboIngresoAño);
		
		cboEstado = new JComboBox <String> ();
		cboEstado.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeEstado));
		cboEstado.setBounds(100, 281, 80, 23);
		getContentPane().add(cboEstado);

		btnAceptar = new JButton("aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnAceptar.setBounds(130, 350, 109, 45);
		btnAceptar.setIcon(new ImageIcon("imagenes/aceptar.png"));
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("volver");
		btnVolver.setFont(new Font("Cambria", Font.BOLD, 12));
		btnVolver.addActionListener(this);
		btnVolver.setBounds(250, 350, 109, 45);
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
		if (e.getSource() == txtTelefono) {
			actionPerformedTxtTelefono(e);
		}
		if (e.getSource() == txtCorreo) {
			actionPerformedTxtCorreo(e);
		}
		if (e.getSource() == txtNumeroID) {
			actionPerformedTxtNumeroID(e);
		}
		if (e.getSource() == txtApellidos) {
			actionPerformedTxtApellidos(e);
		}
		if (e.getSource() == txtNombres) {
			actionPerformedTxtNombres(e);
		}
	}
	protected void actionPerformedTxtNombres(ActionEvent e) {
		txtApellidos.requestFocus();
	}
	protected void actionPerformedTxtApellidos(ActionEvent e) {
		txtNumeroID.requestFocus();
	}
	protected void actionPerformedTxtNumeroID(ActionEvent e) {
		txtCorreo.requestFocus();
	}
	protected void actionPerformedTxtCorreo(ActionEvent e) {
		txtTelefono.requestFocus();
	}
	protected void actionPerformedTxtTelefono(ActionEvent e) {
		adicionarModificarUsuario(true);
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		switch (tipoOperacion) {
			case 0:			
				adicionarModificarUsuario(true);	
				break;
			case 1:
				consultarUsuario();
				break;
			case 2:
				adicionarModificarUsuario(false);
				break;
			default:
				eliminarUsuario();
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
		if (e.getSource() == txtTelefono) {
			keyTypedTxtTelefono(e);
		}
		if (e.getSource() == txtCorreo) {
			keyTypedTxtCorreo(e);
		}
		if (e.getSource() == txtNumeroID) {
			keyTypedTxtNumeroID(e);
		}
		if (e.getSource() == txtApellidos) {
			keyTypedTxtApellidos(e);
		}
		if (e.getSource() == txtNombres) {
			keyTypedTxtNombres(e);
		}
	}
	protected void keyTypedTxtNombres(KeyEvent e) {
		Lib.soloLetras(e,txtNombres,10);
	}
	protected void keyTypedTxtApellidos(KeyEvent e) {
		Lib.soloLetras(e,txtApellidos,10);
	}
	protected void keyTypedTxtNumeroID(KeyEvent e) {
		Lib.soloNumeros(e,txtApellidos,8);
	}
	protected void keyTypedTxtCorreo(KeyEvent e) {
		Lib.soloLetras(e,txtCorreo,20);
	}
	protected void keyTypedTxtTelefono(KeyEvent e) {
		Lib.soloNumeros(e,txtTelefono,9);
	}
	//  Adicionar un nuevo usuario
	private void adicionarModificarUsuario(boolean adicionar) {		
		if (leerNombres().length() == 0) {
			txtNombres.requestFocus();
			Lib.mensajeError(this, "Ingrese NOMBRES");
		}
		else
			if (leerApellidos().length() == 0) {
				txtApellidos.requestFocus();
				Lib.mensajeError(this, "Ingrese APELLIDOS");
			}
			else
				if (leerNumeroID().length() == 0) {
					txtNumeroID.requestFocus();
					Lib.mensajeError(this, "Ingrese NÚMERO DE ID");
				}
				else 
					if (leerCorreo().length() == 0) {
						txtCorreo.requestFocus();
						Lib.mensajeError(this, "Ingrese CORREO");
					}
					else 
						if (leerTelefono().length() == 0) {
							txtTelefono.requestFocus();
							Lib.mensajeError(this, "Ingrese TELEFONO");
						}
						else {
							if (adicionar) {
								Usuario nuevo = new Usuario(leerCodigo(), leerNombres(), 
			                                                leerApellidos(),leerPosTipoID(),
			                                                leerNumeroID(),leerPosArea(),
			                                                leerCorreo(),leerTelefono(),
			                                                leerFechaIngreso(),leerPosEstado());
								Proyecto_AED_2015_1.au.adicionar(nuevo);
								Lib.mensajeInformacion(this, "El Usuario ha sido adicionado");
							}
							else {
								Usuario x = Proyecto_AED_2015_1.au.buscar(leerCodigo());
								x.setNombres(leerNombres());
								x.setApellidos(leerApellidos());
								x.setTipoID(leerPosTipoID());
								x.setNumeroID(leerNumeroID());
								x.setArea(leerPosArea());
								x.setCorreo(leerCorreo());
								x.setTelefono(leerTelefono());	
								x.setFechaIngreso(leerFechaIngreso());
								x.setEstado(leerPosEstado());
								Lib.mensajeInformacion(this, "El Usuario ha sido modificado");		
							}
							dispose();
						}
	}
	//  Consultar el usuario en curso
	private void consultarUsuario() {
		dispose();
	}
	//  Eliminar el área en curso
	private void eliminarUsuario() {
		int ok = Lib.confirmacion(this, "¿Está seguro de eliminar el Usuario?");
		if (ok == 0) {
			Usuario x = Proyecto_AED_2015_1.au.buscar(leerCodigo());
			Proyecto_AED_2015_1.au.eliminar(x);
			Lib.mensajeInformacion(this, "El Usuario ha sido eliminado");
			dispose();
		}
	}
	//  Establece el tipo de operación a afectuar
	public void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	//  Cargar los datos de un usuario
	public void cargarUsuario(Usuario x) {
		lblCodigo.setText(x.getCodigo() + "");
		txtNombres.setText(x.getNombres());
		txtApellidos.setText(x.getApellidos());
		cboTipoID.setSelectedIndex(x.getTipoID());
		txtNumeroID.setText(x.getNumeroID());
		cboArea.setSelectedIndex(x.getArea());
		txtCorreo.setText(x.getCorreo());
		txtTelefono.setText(x.getTelefono());
		Fecha.setFecha(cboIngresoDia,cboIngresoMes,cboIngresoAño,x.getFechaIngreso());
		cboEstado.setSelectedIndex(x.getEstado());
	}
	//  Configurar el formulario para la operación a efectuar
	public void configurarFormulario() {
		switch (tipoOperacion) {
			case 0:
				lblCodigo.setText(Proyecto_AED_2015_1.au.generarCodigo() + "");
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
		txtNombres.setEditable(b);
		txtApellidos.setEditable(b);
		cboTipoID.setEnabled(b);
		txtNumeroID.setEditable(b);
		cboArea.setEnabled(b);
		txtCorreo.setEditable(b);
		txtTelefono.setEditable(b);
		cboIngresoDia.setEnabled(b);
		cboIngresoMes.setEnabled(b);
		cboIngresoAño.setEnabled(b);
		cboEstado.setEnabled(b);
	}
	//  Métodos que retornan valor (sin parámetros)
	private int leerCodigo() {
		return Lib.leerEntero(lblCodigo);
	}
	private String leerNombres() {
		return Lib.leerCadena(txtNombres);
	}
	private String leerApellidos() {
		return Lib.leerCadena(txtApellidos);
	}
	private int leerPosTipoID() {
		return cboTipoID.getSelectedIndex();
	}
	private String leerNumeroID() {
		return Lib.leerCadena(txtNumeroID);
	}
	private int leerPosArea() {
		return cboArea.getSelectedIndex();
	}
	private String leerCorreo() {
		return Lib.leerCadena(txtCorreo);
	}
	private String leerTelefono() {
		return Lib.leerCadena(txtTelefono);
	}
	private int leerFechaIngreso() {
		return Fecha.getFecha(cboIngresoDia,cboIngresoMes,cboIngresoAño);
	}
	private int leerPosEstado() {
		return cboEstado.getSelectedIndex();
	}	
}
