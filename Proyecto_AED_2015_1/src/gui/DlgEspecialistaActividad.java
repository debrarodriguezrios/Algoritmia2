package gui;

import clases.Especialista;
import libreria.Fecha;
import libreria.Lib;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class DlgEspecialistaActividad extends JDialog implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;

	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JLabel lblApellidos;	
	private JLabel lblEspecialidad;
	private JLabel lblAnexo;
	private JLabel lblFechaIngreso;
	private JLabel lblEstado;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtEspecialidad;
	private JTextField txtAnexo;
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
					DlgEspecialistaActividad dialog = new DlgEspecialistaActividad();
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
	public DlgEspecialistaActividad() {
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
		txtNombres.addActionListener(this);
		txtNombres.addKeyListener(this);
		txtNombres.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombres.setColumns(10);
		txtNombres.setBounds(100, 41, 126, 23);
		getContentPane().add(txtNombres);
	
		lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setBounds(10, 71, 94, 23);
		getContentPane().add(lblApellidos);
	
		txtApellidos = new JTextField();
		txtApellidos.addActionListener(this);
		txtApellidos.addKeyListener(this);
		txtApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(100, 71, 126, 23);
		getContentPane().add(txtApellidos);
		
		lblEspecialidad = new JLabel("ESPECIALIDAD");
		lblEspecialidad.setBounds(10, 101, 94, 23);
		getContentPane().add(lblEspecialidad);

		txtEspecialidad = new JTextField();
		txtEspecialidad.addActionListener(this);
		txtEspecialidad.addKeyListener(this);
		txtEspecialidad.setHorizontalAlignment(SwingConstants.LEFT);
		txtEspecialidad.setColumns(10);
		txtEspecialidad.setBounds(100, 101, 126, 23);
		getContentPane().add(txtEspecialidad);		

		lblAnexo = new JLabel("ANEXO");
		lblAnexo.setBounds(10, 131, 55, 23);
		getContentPane().add(lblAnexo);	

		txtAnexo = new JTextField();
		txtAnexo.addActionListener(this);
		txtAnexo.addKeyListener(this);
		txtAnexo.setHorizontalAlignment(SwingConstants.LEFT);
		txtAnexo.setColumns(10);
		txtAnexo.setBounds(100, 131, 126, 23);
		getContentPane().add(txtAnexo);
		
		lblFechaIngreso = new JLabel("INGRESO");
		lblFechaIngreso.setBounds(10, 161, 94, 23);
		getContentPane().add(lblFechaIngreso);

		cboIngresoDia = new JComboBox <String> ();
		Fecha.colocarItems(cboIngresoDia,1,31);
		Fecha.colocarDiaActual(cboIngresoDia);
		cboIngresoDia.addActionListener(this);
		cboIngresoDia.setBounds(100, 161, 40, 23);
		getContentPane().add(cboIngresoDia);
		
		cboIngresoMes = new JComboBox <String> ();
		Fecha.colocarMeses(cboIngresoMes);
		Fecha.colocarMesActual(cboIngresoMes);
		cboIngresoMes.addActionListener(this);
		cboIngresoMes.setBounds(140, 161, 90, 23);
		getContentPane().add(cboIngresoMes);
		
		cboIngresoAño = new JComboBox <String> ();
		Fecha.colocarItems(cboIngresoAño,Fecha.añoActual(),2000);
		cboIngresoAño.addActionListener(this);
		cboIngresoAño.setBounds(230, 161, 60, 23);
		getContentPane().add(cboIngresoAño);
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(10, 191, 55, 23);
		getContentPane().add(lblEstado);
		
		cboEstado = new JComboBox <String> ();
		cboEstado.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeEstado));
		cboEstado.setBounds(100, 191, 80, 23);
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
		if (e.getSource() == txtAnexo) {
			actionPerformedTxtAnexo(e);
		}
		if (e.getSource() == txtEspecialidad) {
			actionPerformedTxtEspecialidad(e);
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
		txtEspecialidad.requestFocus();
	}
	protected void actionPerformedTxtEspecialidad(ActionEvent e) {
		txtAnexo.requestFocus();
	}
	protected void actionPerformedTxtAnexo(ActionEvent e) {
		adicionarModificarEspecialista(true);
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		switch (tipoOperacion) {
			case 0:			
				adicionarModificarEspecialista(true);	
				break;
			case 1:
				consultarEspecialista();
				break;
			case 2:
				adicionarModificarEspecialista(false);	
				break;
			default:
				eliminarEspecialista();
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
		if (e.getSource() == txtNombres) {
			keyTypedTxtNombres(e);
		}
		if (e.getSource() == txtApellidos) {
			keyTypedTxtApellidos(e);
		}
		if (e.getSource() == txtEspecialidad) {
			keyTypedTxtEspecialidad(e);
		}
		if (e.getSource() == txtAnexo) {
			keyTypedTxtAnexo(e);
		}
	}
	protected void keyTypedTxtNombres(KeyEvent e) {
		Lib.soloLetras(e,txtNombres,10);
	}
	protected void keyTypedTxtApellidos(KeyEvent e) {
		Lib.soloLetras(e,txtApellidos,10);
	}
	protected void keyTypedTxtEspecialidad(KeyEvent e) {
		Lib.soloLetras(e,txtEspecialidad,10);
	}
	protected void keyTypedTxtAnexo(KeyEvent e) {
		Lib.soloLetras(e,txtAnexo,20);
	}
	//  Adicionar un nuevo especialista
	private void adicionarModificarEspecialista(boolean adicionar) {
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
				if (leerEspecialidad().length() == 0) {
					txtEspecialidad.requestFocus();
					Lib.mensajeError(this, "Ingrese ESPECIALIDAD");
				}
				else 
					if (leerAnexo().length() == 0) {
						txtAnexo.requestFocus();
						Lib.mensajeError(this, "Ingrese ANEXO");
					}
					else {
						if (adicionar) {
							Especialista nuevo = new Especialista(leerCodigo(), leerNombres(), leerApellidos(),
			                                                      leerEspecialidad(), leerAnexo(),
			                                                      leerFechaIngreso(), leerEstado());
							Proyecto_AED_2015_1.ae.adicionar(nuevo);
							Lib.mensajeInformacion(this, "El Especialista ha sido adicionado");
						} 
						else {
							Especialista x = Proyecto_AED_2015_1.ae.buscar(leerCodigo());
							x.setNombres(leerNombres());
							x.setApellidos(leerApellidos());
							x.setEspecialidad(leerEspecialidad());
							x.setAnexo(leerAnexo());
							x.setFechaIngreso(leerFechaIngreso());
							x.setEstado(leerEstado());
							Lib.mensajeInformacion(this, "El Especialista ha sido modificado");
						}
						dispose();
					}
	}
	//  Consultar el especialista en curso
	private void consultarEspecialista() {
		dispose();
	}
	//  Eliminar el especialista en curso
	private void eliminarEspecialista() {
		int ok = Lib.confirmacion(this, "¿Está seguro de eliminar el Especialista?");
		if (ok == 0) {
			Especialista x = Proyecto_AED_2015_1.ae.buscar(leerCodigo());
			Proyecto_AED_2015_1.ae.eliminar(x);
			Lib.mensajeInformacion(this, "El Especialista ha sido eliminado");
			dispose();
		}
	}
	//  Establece el tipo de operación a afectuar
	public void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	//  Cargar los datos de un especialista
	public void cargarEspecialista(Especialista x) {
		lblCodigo.setText(x.getCodigo() + "");
		txtNombres.setText(x.getNombres());
		txtApellidos.setText(x.getApellidos());
		txtEspecialidad.setText(x.getEspecialidad());
		txtAnexo.setText(x.getAnexo());
		Fecha.setFecha(cboIngresoDia,cboIngresoMes,cboIngresoAño,x.getFechaIngreso());	
		cboEstado.setSelectedIndex(x.getEstado());
	}
	//  Configurar el formulario para la operación a efectuar
	public void configurarFormulario() {
		switch (tipoOperacion) {
			case 0:
				lblCodigo.setText(Proyecto_AED_2015_1.ae.generarCodigo() + "");
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
		txtEspecialidad.setEditable(b);
		txtAnexo.setEditable(b);
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
	private String leerEspecialidad() {
		return Lib.leerCadena(txtEspecialidad);
	}
	private String leerAnexo() {
		return Lib.leerCadena(txtAnexo);
	}
	private int leerFechaIngreso() {
		return Fecha.getFecha(cboIngresoDia,cboIngresoMes,cboIngresoAño);
	}
	private int leerEstado() {
		return cboEstado.getSelectedIndex();
	}
	
}
