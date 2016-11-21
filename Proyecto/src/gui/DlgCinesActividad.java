package gui;

import java.awt.EventQueue;

import clases.Cine;


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

public class DlgCinesActividad extends JDialog implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private JLabel lblCdigoDeCine;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblDepartamento;
	private JTextField txtDepartamento;
	private JLabel lblProvincia;
	private JTextField txtProvincia;
	private JLabel lblDistrito;
	private JTextField txtDistrito;
	private JLabel lblFechainicio;
	private JComboBox <String> cboIniDia;
	private JComboBox <String> cboIniMes;
	private JComboBox <String> cboIniAño;
	private JLabel lblTipocine;
	private JComboBox<String> cboTipocine;
	private JButton btnAceptar;
	private JButton btnSalir;

	private int  tipoOperacion;
	private JLabel lblCodigoCine1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgCinesActividad dialog = new DlgCinesActividad();
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
	public DlgCinesActividad() {
		setTitle("Mantenimiento | Cines | Ingreso");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AGAF\\Desktop\\CIBERTEC\\SEGUNDO CICLO\\1814 - ALGORITMOS Y ESTRUCTURA DE DATOS\\Proyecto_Sistema_Atencion_Cine\\Proyecto\\imagenes\\Cine.png"));
		setBounds(100, 100, 564, 395);
		getContentPane().setLayout(null);
		
		lblCdigoDeCine = new JLabel("C\u00F3digo de Cine");
		lblCdigoDeCine.setBounds(22, 31, 122, 14);
		getContentPane().add(lblCdigoDeCine);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(22, 62, 95, 14);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.addActionListener(this);
		txtNombre.setColumns(10);
		txtNombre.setBounds(192, 59, 299, 20);
		getContentPane().add(txtNombre);
		
		lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(22, 93, 131, 14);
		getContentPane().add(lblDepartamento);
		
		txtDepartamento = new JTextField();
		txtDepartamento.addKeyListener(this);
		txtDepartamento.addActionListener(this);
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(192, 90, 152, 20);
		getContentPane().add(txtDepartamento);
		
		lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(22, 124, 131, 14);
		getContentPane().add(lblProvincia);
		
		txtProvincia = new JTextField();
		txtProvincia.addKeyListener(this);
		txtProvincia.addActionListener(this);
		txtProvincia.setColumns(10);
		txtProvincia.setBounds(192, 121, 152, 20);
		getContentPane().add(txtProvincia);
		
		lblDistrito = new JLabel("Distrito");
		lblDistrito.setBounds(22, 157, 46, 14);
		getContentPane().add(lblDistrito);
		
		txtDistrito = new JTextField();
		txtDistrito.addKeyListener(this);
		txtDistrito.addActionListener(this);
		txtDistrito.setBounds(192, 154, 152, 20);
		getContentPane().add(txtDistrito);
		txtDistrito.setColumns(10);
		
		lblFechainicio = new JLabel("Fecha de Inicio Operaciones");
		lblFechainicio.setBounds(22, 190, 169, 14);
		getContentPane().add(lblFechainicio);
		
		cboIniDia = new JComboBox <String> ();
		Fecha.colocarItems(cboIniDia,1,31);
		Fecha.colocarDiaActual(cboIniDia);
		cboIniDia.addActionListener(this);
		cboIniDia.setBounds(192, 186, 40, 23);
		getContentPane().add(cboIniDia);
		
		cboIniMes = new JComboBox <String> ();
		Fecha.colocarMeses(cboIniMes);
		Fecha.colocarMesActual(cboIniMes);
		cboIniMes.addActionListener(this);
		cboIniMes.setBounds(244, 186, 90, 23);
		getContentPane().add(cboIniMes);
		
		cboIniAño = new JComboBox <String> ();
		Fecha.colocarItems(cboIniAño,Fecha.añoActual(),2000);
		cboIniAño.addActionListener(this);
		cboIniAño.setBounds(346, 186, 60, 23);
		getContentPane().add(cboIniAño);
		
		lblTipocine = new JLabel("Tipo de Cine");
		lblTipocine.setBounds(22, 221, 106, 14);
		getContentPane().add(lblTipocine);
		
		cboTipocine = new JComboBox<String>();
		cboTipocine.setModel(new DefaultComboBoxModel<String>(new String[] {"Standar", "Prime"}));
		cboTipocine.setBounds(192, 220, 152, 20);
		getContentPane().add(cboTipocine);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(134, 283, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(304, 283, 89, 23);
		getContentPane().add(btnSalir);
		
		lblCodigoCine1 = new JLabel("");
		lblCodigoCine1.setForeground(Color.BLUE);
		lblCodigoCine1.setBackground(Color.WHITE);
		lblCodigoCine1.setBounds(192, 25, 299, 20);
		getContentPane().add(lblCodigoCine1);

	}
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == txtDistrito) {
			actionPerformedTxtDistrito(e);
		}
		if (e.getSource() == txtProvincia) {
			actionPerformedTxtProvincia(e);
		}
		if (e.getSource() == txtDepartamento) {
			actionPerformedTxtDepartamento(e);
		}
		if (e.getSource() == txtNombre) {
			actionPerformedTxtNombre(e);
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
	
//  Adicionar un nuevo cine
	private void adicionarModificarCine(boolean adicionar) {		
		if (leerNombre().length() == 0) {
			txtNombre.requestFocus();
			Lib.mensajeError(this, "Ingrese NOMBRE");
		}
		else
			if (leerDepartamento().length() == 0) {
				txtDepartamento.requestFocus();
				Lib.mensajeError(this, "Ingrese DEPARTAMENTO");
			}
			else
				if (leerProvincia().length() == 0) {
					txtProvincia.requestFocus();
					Lib.mensajeError(this, "Ingrese PROVINCIA");
				}
				else 
					if (leerDistrito().length() == 0) {
						txtDistrito.requestFocus();
						Lib.mensajeError(this, "Ingrese DISTRITO");
					}
					else 
						if(leerFechainicio().length()==0){
							cboIniDia.requestFocus();
							Lib.mensajeError(this, "Ingrese una fecha de nacimiento valida");
						}
						else {
							if (adicionar) {
								Cine nuevo = new Cine(leerCodigo(), leerNombre(), 
			                                                leerDepartamento(),leerProvincia(),
			                                                leerDistrito(),
			                                                leerFechainicio(),leerTipocine());
								Proyecto.aci.adicionar(nuevo);
								Proyecto.aci.grabarCine();
								Lib.mensajeInformacion(this, "El Cine ha sido adicionado");
							}
							else {
								Cine x = Proyecto.aci.buscar(leerCodigo());
								x.setNombre(leerNombre());
								x.setDepartamento(leerDepartamento());
								x.setProvincia(leerProvincia());
								x.setDistrito(leerDistrito());
								x.setFechainicio(leerFechainicio());
								x.setTipocine(leerTipocine());
								Lib.mensajeInformacion(this, "El Cine ha sido modificado");		
							}
							dispose();
						}
	}
	
	
	private void consultarCine() {
		dispose();
	}
	
//  Eliminar el área en curso
	private void eliminarCine() {
		int ok = Lib.confirmacion(this, "¿Está seguro de eliminar el Cine?");
		if (ok == 0) {
			Cine x = Proyecto.aci.buscar(leerCodigo());
			Proyecto.aci.eliminar(x);
			Lib.mensajeInformacion(this, "El Cine ha sido eliminado");
			dispose();
		}
	}
	
//  Establece el tipo de operación a afectuar
	public void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	
	//  Cargar los datos de un cine
	public void cargarCine(Cine x) {
		lblCodigoCine1.setText(x.getCodigocine() + "");
		txtNombre.setText(x.getNombre());
		txtDepartamento.setText(x.getDepartamento());
		txtProvincia.setText(x.getProvincia());
		txtDistrito.setText(x.getDistrito());
		
		cboTipocine.setSelectedIndex(x.getTipocine());
			}
	
	public void configurarFormulario() {
		switch (tipoOperacion) {
			case 0:
				lblCodigoCine1.setText(Proyecto.aci.generarCodigo() + "");
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
		txtNombre.setEditable(b);
		txtDepartamento.setEditable(b);
		txtProvincia.setEditable(b);
		txtDistrito.setEditable(b);
		cboIniDia.setEnabled(b);
		cboIniMes.setEnabled(b);
		cboIniAño.setEnabled(b);
		cboTipocine.setEnabled(b);
	
	}
	
	
//  Métodos que retornan valor (sin parámetros)
	private int leerCodigo() {
		return Lib.leerEntero(lblCodigoCine1);
	}
	private String leerNombre() {
		return Lib.leerCadena(txtNombre);
	}
	private String leerDepartamento() {
		return Lib.leerCadena(txtDepartamento);
	}
	
	private String leerProvincia() {
		return Lib.leerCadena(txtProvincia);
	}
		
	private String leerDistrito() {
		return Lib.leerCadena(txtDistrito);
	}
	
	private String leerFechainicio() {
		String dia = (String)cboIniDia.getSelectedItem();
		String mes = (String)cboIniMes.getSelectedItem();
		String año = (String)cboIniAño.getSelectedItem();
		String fecha = "";
		try {
			fecha = Lib.formatoFecha(dia, mes, año, "");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return fecha;
	}
	private int leerTipocine() {
		return cboTipocine.getSelectedIndex();
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		
		switch (tipoOperacion) {
			case 0:			
				adicionarModificarCine(true);	
				break;
			case 1:
				consultarCine();
				break;
			case 2:
				adicionarModificarCine(false);
				break;
			default:
				eliminarCine();
		}
	}
	protected void actionPerformedTxtNombre(ActionEvent e) {
		txtDepartamento.requestFocus();
	}
	protected void actionPerformedTxtDepartamento(ActionEvent e) {
		txtProvincia.requestFocus();
	}
	protected void actionPerformedTxtProvincia(ActionEvent e) {
		txtDistrito.requestFocus();
	}
	protected void actionPerformedTxtDistrito(ActionEvent e) {
		adicionarModificarCine(true);
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		
		if (e.getSource() == txtDistrito) {
			keyTypedTxtDistrito(e);
		}
		if (e.getSource() == txtProvincia) {
			keyTypedTxtProvincia(e);
		}
		if (e.getSource() == txtDepartamento) {
			keyTypedTxtDepartamento(e);
		}
		if (e.getSource() == txtNombre) {
			keyTypedTxtNombre(e);
		}
	}
	
	
	
	protected void keyTypedTxtNombre(KeyEvent e) {
		Lib.soloLetras(e,txtNombre,30);
	}
	
	protected void keyTypedTxtDepartamento(KeyEvent e) {
		Lib.soloLetras(e,txtDepartamento,20);
	}
	
	protected void keyTypedTxtProvincia(KeyEvent e) {
		Lib.soloLetras(e,txtProvincia,20);

	}
	
	protected void keyTypedTxtDistrito(KeyEvent e) {
		Lib.soloLetras(e,txtDistrito,15);

	}
	
	

}
