package gui;

import clases.Area;
import libreria.Lib;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DlgAreaActividad extends JDialog implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;

	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblDescripcion;	
	private JLabel lblNombreCorto;
	private JLabel lblNombreLargo;
	private JLabel lblEstado;
	private JTextField txtNombre;
	private JTextField txtNombreCorto;
	private JTextField txtNombreLargo;
	private JTextArea txtDescripcion;
	private JScrollPane scrollPane;
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
					DlgAreaActividad dialog = new DlgAreaActividad();
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
	public DlgAreaActividad() {
		getContentPane().setFont(new Font("Cambria", Font.BOLD, 12));
		setResizable(false);
		setBounds(100, 100, 375, 350);
		getContentPane().setLayout(null);
	
		lblCodigo = new JLabel("C\u00D3DIGO");
		lblCodigo.setBounds(10, 11, 102, 23);
		getContentPane().add(lblCodigo);
		
		lblCodigo = new JLabel();
		lblCodigo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodigo.setBounds(102, 11, 126, 23);
		getContentPane().add(lblCodigo);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(10, 41, 94, 23);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.addActionListener(this);
		txtNombre.addKeyListener(this);
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombre.setColumns(10);
		txtNombre.setBounds(100, 41, 126, 23);
		getContentPane().add(txtNombre);
	
		lblDescripcion = new JLabel("DESCRIPCI\u00D3N");
		lblDescripcion.setBounds(10, 71, 94, 23);
		getContentPane().add(lblDescripcion);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 71, 260, 43);
		getContentPane().add(scrollPane);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollPane.setViewportView(txtDescripcion);
		
		lblNombreCorto = new JLabel("NOMBRE CORTO");
		lblNombreCorto.setBounds(10, 121, 94, 23);
		getContentPane().add(lblNombreCorto);
		
		txtNombreCorto = new JTextField();
		txtNombreCorto.addActionListener(this);
		txtNombreCorto.addKeyListener(this);
		txtNombreCorto.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombreCorto.setColumns(10);
		txtNombreCorto.setBounds(100, 121, 126, 23);
		getContentPane().add(txtNombreCorto);

		lblNombreLargo = new JLabel("NOMBRE LARGO");
		lblNombreLargo.setBounds(10, 151, 94, 23);
		getContentPane().add(lblNombreLargo);
		
		txtNombreLargo = new JTextField();
		txtNombreLargo.addActionListener(this);
		txtNombreLargo.addKeyListener(this);
		txtNombreLargo.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombreLargo.setColumns(10);
		txtNombreLargo.setBounds(100, 151, 260, 23);
		getContentPane().add(txtNombreLargo);		

		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(10, 181, 49, 23);
		getContentPane().add(lblEstado);
		
		cboEstado = new JComboBox <String> ();
		cboEstado.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeEstado));
		cboEstado.setBounds(100, 181, 80, 23);
		getContentPane().add(cboEstado);

		btnAceptar = new JButton("aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnAceptar.setBounds(130, 270, 109, 45);
		btnAceptar.setIcon(new ImageIcon("imagenes/aceptar.png"));
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("volver");
		btnVolver.setFont(new Font("Cambria", Font.BOLD, 12));
		btnVolver.addActionListener(this);
		btnVolver.setBounds(250, 270, 109, 45);
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
		if (e.getSource() == txtNombreLargo) {
			actionPerformedTxtNombreLargo(e);
		}
		if (e.getSource() == txtNombreCorto) {
			actionPerformedTxtNombreCorto(e);
		}
		if (e.getSource() == txtNombre) {
			actionPerformedTxtNombre(e);
		}
	}
	protected void actionPerformedTxtNombre(ActionEvent e) {
		txtDescripcion.requestFocus();
	}
	protected void actionPerformedTxtNombreCorto(ActionEvent e) {
		txtNombreLargo.requestFocus();
	}
	protected void actionPerformedTxtNombreLargo(ActionEvent e) {
		adicionarModificarArea(true);
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		switch (tipoOperacion) {
			case 0:			
				adicionarModificarArea(true);	
				break;
			case 1:
				consultarArea();
				break;
			case 2:
				adicionarModificarArea(false);
				break;
			default:
				eliminarArea();
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
		if (e.getSource() == txtNombreLargo) {
			keyTypedTxtNombreLargo(e);
		}
		if (e.getSource() == txtNombreCorto) {
			keyTypedTxtNombreCorto(e);
		}
		if (e.getSource() == txtNombre) {
			keyTypedTxtNombreLargo(e);
		}
	}
	protected void keyTypedTxtNombre(KeyEvent e) {
		Lib.soloLetras(e,txtNombre,20);
	}
	protected void keyTypedTxtNombreCorto(KeyEvent e) {
		Lib.soloLetras(e,txtNombreCorto,20);
	}
	protected void keyTypedTxtNombreLargo(KeyEvent e) {
		Lib.soloLetras(e,txtNombreLargo,40);
	}
	//  Adicionar una nueva área
	private void adicionarModificarArea(boolean adicionar) {
		if (leerNombre().length() == 0) {
			txtNombre.requestFocus();
			Lib.mensajeError(this, "Ingrese NOMBRE");
		}
		else
			if (leerDescripcion().length() == 0) {
				txtDescripcion.requestFocus();
				Lib.mensajeError(this, "Ingrese DESCRIPCIÓN");
			}
			else
				if (leerNombreCorto().length() == 0) {
					txtNombreCorto.requestFocus();
					Lib.mensajeError(this, "Ingrese NOMBRE CORTO");
				}
				else 
					if (leerNombreLargo().length() == 0) {
						txtNombreLargo.requestFocus();
						Lib.mensajeError(this, "Ingrese NOMBRE LARGO");
					}
					else {
						if (adicionar) {
							Area nueva = new Area(leerCodigo(), leerNombre(), 
			                                      leerDescripcion(), leerNombreCorto(),
					                              leerNombreLargo(), leerEstado());
							Proyecto_AED_2015_1.aa.adicionar(nueva);
							Lib.mensajeInformacion(this, "El Área ha sido adicionada");
						}
						else {
							Area  x = Proyecto_AED_2015_1.aa.buscar(leerCodigo());
							x.setNombre(leerNombre());
							x.setDescripcion(leerDescripcion());
							x.setNombreCorto(leerNombreCorto());
							x.setNombreLargo(leerNombreLargo());
							x.setEstado(leerEstado());
							Lib.mensajeInformacion(this, "El Área ha sido modificada");
						}
						dispose();
					}
	}
	//  Consultar el área en curso
	private void consultarArea() {
		dispose();
	}
	//  Eliminar el área en curso
	private void eliminarArea() {
		int ok = Lib.confirmacion(this, "¿Está seguro de eliminar el Área?");
		if (ok == 0) {
			Area x = Proyecto_AED_2015_1.aa.buscar(leerCodigo());
			Proyecto_AED_2015_1.aa.eliminar(x);
			Lib.mensajeInformacion(this, "El Área ha sido eliminada");
			dispose();
		}
	}
	//  Establece el tipo de operación a afectuar
	public void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	//  Cargar los datos de un área
	public void cargarArea(Area x) {
		lblCodigo.setText(x.getCodigo() + "");
		txtNombre.setText(x.getNombre());
		txtNombreCorto.setText(x.getNombreCorto());
		txtNombreLargo.setText(x.getNombreLargo());
		txtDescripcion.setText(x.getDescripcion());			
		cboEstado.setSelectedIndex(x.getEstado());	
	}
	//  Configurar el formulario para la operación a efectuar
	public void configurarFormulario() {
		switch (tipoOperacion) {
			case 0:
				mostrarCodigoAutogenerado();
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
	//  Mostrar el código autogenerado
	private void mostrarCodigoAutogenerado() {
		lblCodigo.setText(Proyecto_AED_2015_1.aa.generarCodigo() + "");
	}
	//  Habilitar o deshabilitar las cajas de texto
	private void habilitarCajasDeTexto(boolean b) {
		txtNombre.setEditable(b);
		txtDescripcion.setEditable(b);
		txtNombreCorto.setEditable(b);
		txtNombreLargo.setEditable(b);
		cboEstado.setEnabled(b);
	}
	//  Métodos que retornan valor sin parámetros
	private int leerCodigo() {
		return Lib.leerEntero(lblCodigo);
	}
	private String leerNombre() {
		return Lib.leerCadena(txtNombre);
	}
	private String leerDescripcion() {
		return Lib.leerCadenaGrande(txtDescripcion);
	}
	private String leerNombreCorto() {
		return Lib.leerCadena(txtNombreCorto);
	}
	private String leerNombreLargo() {
		return Lib.leerCadena(txtNombreLargo);
	}
	private int leerEstado() {
		return cboEstado.getSelectedIndex();
	}
}
