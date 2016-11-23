package gui;

import java.awt.EventQueue;

import clases.Pelicula;


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

public class DlgPeliculasActividad extends JDialog implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private JLabel lblCdigoDePelicula;
	private JLabel lblTitdistrib;
	private JTextField txtTitdistrib;
	private JLabel lblTitoriginal;
	private JTextField txtTitoriginal;
	private JLabel lblFechaestreno;
	private JComboBox <String> cboEstDia;
	private JComboBox <String> cboEstMes;
	private JComboBox <String> cboEstAño;
	private JLabel lblTipoproyeccion;
	private JComboBox<String> cboTipoproyeccion;
	private JLabel lblGenero;
	private JTextField txtGenero;
	private JLabel lblPaisorigen;
	private JTextField txtPaisorigen;
	private JLabel lblSinopsis;
	private JTextField txtSinopsis;
	private JLabel lblDuracion;
	private JTextField txtDuracion;
	private JLabel lblTipocensura;
	private JComboBox<String> cboTipocensura;
	private JLabel lblEstadoproyeccion;
	private JComboBox<String> cboEstadoproyeccion;
	private JLabel lblRecaudacion;
	private JTextField txtRecaudacion;
	
	private JButton btnAceptar;
	private JButton btnSalir;

	private int  tipoOperacion;
	private JLabel lblCodigoPelicula1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgPeliculasActividad dialog = new DlgPeliculasActividad();
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
	public DlgPeliculasActividad() {
		setTitle("Mantenimiento | Peliculas | Ingreso");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AGAF\\Desktop\\CIBERTEC\\SEGUNDO CICLO\\1814 - ALGORITMOS Y ESTRUCTURA DE DATOS\\Proyecto_Sistema_Atencion_Cine\\Proyecto\\imagenes\\Cine.png"));
		setBounds(100, 100, 564, 582);
		getContentPane().setLayout(null);
		
		lblCdigoDePelicula = new JLabel("C\u00F3digo de Película");
		lblCdigoDePelicula.setBounds(22, 31, 122, 14);
		getContentPane().add(lblCdigoDePelicula);
		
		lblTitdistrib = new JLabel("Título de distribución");
		lblTitdistrib.setBounds(22, 62, 131, 14);
		getContentPane().add(lblTitdistrib);
		
		txtTitdistrib = new JTextField();
		txtTitdistrib.addKeyListener(this);
		txtTitdistrib.addActionListener(this);
		txtTitdistrib.setColumns(10);
		txtTitdistrib.setBounds(192, 59, 299, 20);
		getContentPane().add(txtTitdistrib);
		
		lblTitoriginal = new JLabel("T\u00EDtulo Original");
		lblTitoriginal.setBounds(22, 93, 131, 14);
		getContentPane().add(lblTitoriginal);
		
		txtTitoriginal = new JTextField();
		txtTitoriginal.addKeyListener(this);
		txtTitoriginal.addActionListener(this);
		txtTitoriginal.setColumns(10);
		txtTitoriginal.setBounds(192, 90, 299, 20);
		getContentPane().add(txtTitoriginal);
		
		lblFechaestreno = new JLabel("Fecha de Estreno");
		lblFechaestreno.setBounds(22, 124, 169, 14);
		getContentPane().add(lblFechaestreno);
		
		cboEstDia = new JComboBox <String> ();
		Fecha.colocarItems(cboEstDia,1,31);
		Fecha.colocarDiaActual(cboEstDia);
		cboEstDia.addActionListener(this);
		cboEstDia.setBounds(192, 123, 40, 23);
		getContentPane().add(cboEstDia);
		
		cboEstMes = new JComboBox <String> ();
		Fecha.colocarMeses(cboEstMes);
		Fecha.colocarMesActual(cboEstMes);
		cboEstMes.addActionListener(this);
		cboEstMes.setBounds(244, 123, 90, 23);
		getContentPane().add(cboEstMes);
		
		cboEstAño = new JComboBox <String> ();
		Fecha.colocarItems(cboEstAño,Fecha.añoActual(),2000);
		cboEstAño.addActionListener(this);
		cboEstAño.setBounds(346, 123, 60, 23);
		getContentPane().add(cboEstAño);
		
		lblTipoproyeccion = new JLabel("Tipo de Proyección");
		lblTipoproyeccion.setBounds(22, 160, 122, 14);
		getContentPane().add(lblTipoproyeccion);
		
		cboTipoproyeccion = new JComboBox<String>();
		cboTipoproyeccion.setModel(new DefaultComboBoxModel(new String[] {"Estreno", "Fuera de estreno"}));
		cboTipoproyeccion.setBounds(192, 159, 152, 20);
		getContentPane().add(cboTipoproyeccion);
		
		lblGenero = new JLabel("Género");
		lblGenero.setBounds(22, 192, 131, 14);
		getContentPane().add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.addKeyListener(this);
		txtGenero.addActionListener(this);
		txtGenero.setColumns(10);
		txtGenero.setBounds(192, 192, 152, 20);
		getContentPane().add(txtGenero);
		
		lblPaisorigen = new JLabel("País de origen");
		lblPaisorigen.setBounds(22, 228, 106, 14);
		getContentPane().add(lblPaisorigen);
		
		txtPaisorigen = new JTextField();
		txtPaisorigen.addKeyListener(this);
		txtPaisorigen.addActionListener(this);
		txtPaisorigen.setBounds(192, 225, 152, 20);
		getContentPane().add(txtPaisorigen);
		txtPaisorigen.setColumns(10);
		
		lblSinopsis = new JLabel("Sinopsis");
		lblSinopsis.setBounds(22, 261, 95, 14);
		getContentPane().add(lblSinopsis);
		
		txtSinopsis = new JTextField();
		txtSinopsis.addKeyListener(this);
		txtSinopsis.addActionListener(this);
		txtSinopsis.setBounds(192, 258, 299, 20);
		getContentPane().add(txtSinopsis);
		txtSinopsis.setColumns(10);
		
		lblDuracion = new JLabel("Duración");
		lblDuracion.setBounds(22, 294, 106, 14);
		getContentPane().add(lblDuracion);
		
		txtDuracion = new JTextField();
		txtDuracion.addKeyListener(this);
		txtDuracion.addActionListener(this);
		txtDuracion.setBounds(192, 291, 152, 20);
		getContentPane().add(txtDuracion);
		txtDuracion.setColumns(10);
		
		lblTipocensura = new JLabel("Tipo de Censura");
		lblTipocensura.setBounds(22, 327, 106, 14);
		getContentPane().add(lblTipocensura);
		
		cboTipocensura = new JComboBox<String>();
		cboTipocensura.setModel(new DefaultComboBoxModel<String>(new String[] {"Apta para todos", 
						"Mayores de 14 años","Mayores de 18 años"}));
		cboTipocensura.setBounds(192, 324, 152, 20);
		getContentPane().add(cboTipocensura);
		
		lblEstadoproyeccion = new JLabel("Estado de proyeccion");
		lblEstadoproyeccion.setBounds(22, 363, 122, 14);
		getContentPane().add(lblEstadoproyeccion);
		
		cboEstadoproyeccion = new JComboBox<String>();
		cboEstadoproyeccion.setModel(new DefaultComboBoxModel<String>(new String[] {"En cartelera", 
						"Fuera de cartelera"}));
		cboEstadoproyeccion.setBounds(192, 360, 152, 20);
		getContentPane().add(cboEstadoproyeccion);
		
		lblRecaudacion = new JLabel("Recaudación");
		lblRecaudacion.setBounds(22, 396, 106, 14);
		getContentPane().add(lblRecaudacion);
		
		txtRecaudacion = new JTextField();
		txtRecaudacion.addKeyListener(this);
		txtRecaudacion.addActionListener(this);
		txtRecaudacion.setBounds(192, 393, 152, 20);
		getContentPane().add(txtRecaudacion);
		txtRecaudacion.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(143, 459, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(315, 459, 89, 23);
		getContentPane().add(btnSalir);
		
		lblCodigoPelicula1 = new JLabel("");
		lblCodigoPelicula1.setForeground(Color.BLUE);
		lblCodigoPelicula1.setBackground(Color.WHITE);
		lblCodigoPelicula1.setBounds(192, 25, 299, 20);
		getContentPane().add(lblCodigoPelicula1);

	}
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == txtRecaudacion) {
			actionPerformedTxtRecaudacion(e);
		}
		if (e.getSource() == txtSinopsis) {
			actionPerformedTxtSinopsis(e);
		}
		if (e.getSource() == txtPaisorigen) {
			actionPerformedTxtPaisorigen(e);
		}
		if (e.getSource() == txtGenero) {
			actionPerformedTxtGenero(e);
		}
		if (e.getSource() == txtTitoriginal) {
			actionPerformedTxtTitoriginal(e);
		}
		if (e.getSource() == txtTitdistrib) {
			actionPerformedTxtTitdistrib(e);
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
	
//  Adicionar un nuevo pelicula
	private void adicionarModificarPelicula(boolean adicionar) {		
		if (leerTitdistrib().length() == 0) {
			txtTitdistrib.requestFocus();
			Lib.mensajeError(this, "Ingrese TÍTULO DE DISTRIBUCIÓN");
		}
		else
			if (leerTitoriginal().length() == 0) {
				txtTitoriginal.requestFocus();
				Lib.mensajeError(this, "Ingrese TÍTULO ORIGINAL");
			}
			else
				if(leerFechaestreno().length()==0){
					cboEstDia.requestFocus();
					Lib.mensajeError(this, "Ingrese una fecha de estreno valida");
				}
				else
					if (leerGenero().length() == 0) {
						txtGenero.requestFocus();
						Lib.mensajeError(this, "Ingrese GÉNERO");
				}
				else 
					if (leerPaisorigen().length() == 0) {
						txtPaisorigen.requestFocus();
						Lib.mensajeError(this, "Ingrese PAÍS DE ORIGEN");
					}
					else 
						if (leerSinopsis().length() == 0) {
							txtSinopsis.requestFocus();
							Lib.mensajeError(this, "Ingrese SINOPSIS");
						}
						else 
							{
							if (adicionar) {
								Pelicula nuevo = new Pelicula(leerCodigopelicula(), leerTitdistrib(), 
			                                                leerTitoriginal(),leerFechaestreno(),
			                                                leerTipoproyeccion(),leerGenero(),leerPaisorigen(),
			                                                leerSinopsis(),leerDuracion(),leerTipocensura(),leerEstadoproyeccion(), leerRecaudacion());
								Proyecto.ap.adicionar(nuevo);
								Proyecto.ap.grabarPelicula();
								Lib.mensajeInformacion(this, "La película ha sido agregada");
							}
							else {
								Pelicula x = Proyecto.ap.buscar(leerCodigopelicula());
								x.setTitdistrib(leerTitdistrib());
								x.setTitoriginal(leerTitoriginal());
								x.setFechaestreno(leerFechaestreno());
								x.setTipoproyeccion(leerTipoproyeccion());
								x.setGenero(leerGenero());
								x.setPaisorigen(leerPaisorigen());
								x.setSinopsis(leerSinopsis());
								x.setDuracion(leerDuracion());
								x.setTipocensura(leerTipocensura());
								x.setEstadoproyeccion(leerEstadoproyeccion());
								x.setRecaudacion(leerRecaudacion());
								Lib.mensajeInformacion(this, "La pelicula ha sido modificada");		
							}
							dispose();
						}
	}
	
	
	private void consultarPelicula() {
		dispose();
	}
	
//  Eliminar el área en curso
	private void eliminarPelicula() {
		int ok = Lib.confirmacion(this, "¿Está seguro de eliminar la pelicula?");
		if (ok == 0) {
			Pelicula x = Proyecto.ap.buscar(leerCodigopelicula());
			Proyecto.ap.eliminar(x);
			Lib.mensajeInformacion(this, "La película ha sido eliminada");
			dispose();
		}
	}
	
//  Establece el tipo de operación a afectuar
	public void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	
	//  Cargar los datos de una pelicula
	public void cargarPelicula(Pelicula x) {
		lblCodigoPelicula1.setText(x.getCodigopelicula() + "");
		txtTitdistrib.setText(x.getTitdistrib());
		txtTitoriginal.setText(x.getTitoriginal());
		cboTipoproyeccion.setSelectedIndex(x.getTipoproyeccion());
		txtGenero.setText(x.getGenero());
		txtPaisorigen.setText(x.getPaisorigen());
		txtSinopsis.setText(x.getSinopsis());
		//txtDuracion.setSelectedIndex(x.getDuracion());
		cboTipocensura.setSelectedIndex(x.getTipocensura());
		cboEstadoproyeccion.setSelectedIndex(x.getEstadoproyeccion());
		//txtRecaudacion.set(x.getRecaudacion());
			}
	
	public void configurarFormulario() {
		switch (tipoOperacion) {
			case 0:
				lblCodigoPelicula1.setText(Proyecto.aci.generarCodigo() + "");
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
		txtTitdistrib.setEditable(b);
		txtTitoriginal.setEditable(b);
		cboEstDia.setEnabled(b);
		cboEstMes.setEnabled(b);
		cboEstAño.setEnabled(b);
		cboTipoproyeccion.setEnabled(b);
		txtGenero.setEditable(b);
		txtPaisorigen.setEditable(b);
		txtSinopsis.setEditable(b);
		txtDuracion.setEditable(b);
		cboTipocensura.setEnabled(b);
		cboEstadoproyeccion.setEnabled(b);
		txtRecaudacion.setEditable(b);
	}
	
	
//  Métodos que retornan valor (sin parámetros)
	private int leerCodigopelicula() {
		return Lib.leerEntero(lblCodigoPelicula1);
	}
	private String leerTitdistrib() {
		return Lib.leerCadena(txtTitdistrib);
	}
	private String leerTitoriginal() {
		return Lib.leerCadena(txtTitoriginal);
	}
	private String leerFechaestreno() {
		String dia = (String)cboEstDia.getSelectedItem();
		String mes = (String)cboEstMes.getSelectedItem();
		String año = (String)cboEstAño.getSelectedItem();
		String fecha = "";
		try {
			fecha = Lib.formatoFecha(dia, mes, año, "");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return fecha;
	}
	private int leerTipoproyeccion() {
		return cboTipoproyeccion.getSelectedIndex();
	}
	private String leerGenero() {
		return Lib.leerCadena(txtGenero);
	}
		
	private String leerPaisorigen() {
		return Lib.leerCadena(txtPaisorigen);
	}
	private String leerSinopsis() {
		return Lib.leerCadena(txtSinopsis);
	}
	private int leerDuracion() {
		return Lib.leerEntero(txtDuracion);
	}
	private int leerTipocensura() {
		return cboTipocensura.getSelectedIndex();
	}
	private int leerEstadoproyeccion() {
		return cboEstadoproyeccion.getSelectedIndex();
	}
	private double leerRecaudacion() {
		return Lib.leerReal(txtRecaudacion);
	}
	
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		
		switch (tipoOperacion) {
			case 0:			
				adicionarModificarPelicula(true);	
				break;
			case 1:
				consultarPelicula();
				break;
			case 2:
				adicionarModificarPelicula(false);
				break;
			default:
				eliminarPelicula();
		}
	}
	protected void actionPerformedTxtTitdistrib(ActionEvent e) {
		txtTitoriginal.requestFocus();
	}
	protected void actionPerformedTxtTitoriginal(ActionEvent e) {
		txtGenero.requestFocus();
	}
	protected void actionPerformedTxtGenero(ActionEvent e) {
		txtPaisorigen.requestFocus();
	}
	protected void actionPerformedTxtPaisorigen(ActionEvent e) {
		txtSinopsis.requestFocus();
	}
	protected void actionPerformedTxtSinopsis(ActionEvent e) {
		txtDuracion.requestFocus();
	}
	protected void actionPerformedTxtDuracion(ActionEvent e) {
		txtRecaudacion.requestFocus();
	}
	protected void actionPerformedTxtRecaudacion(ActionEvent e) {
		adicionarModificarPelicula(true);
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtRecaudacion) {
			keyTypedTxtRecaudacion(e);
		}
		if (e.getSource() == txtDuracion) {
			keyTypedTxtDuracion(e);
		}
		if (e.getSource() == txtSinopsis) {
			keyTypedTxtSinopsis(e);
		}
		if (e.getSource() == txtPaisorigen) {
			keyTypedTxtPaisorigen(e);
		}
		if (e.getSource() == txtGenero) {
			keyTypedTxtGenero(e);
		}
		if (e.getSource() == txtTitoriginal) {
			keyTypedTxtTitoriginal(e);
		}
		if (e.getSource() == txtTitdistrib) {
			keyTypedTxtTitdistrib(e);
		}
	}
	
	
	
	protected void keyTypedTxtTitdistrib(KeyEvent e) {
		Lib.soloLetras(e,txtTitdistrib,30);
	}
	
	protected void keyTypedTxtTitoriginal(KeyEvent e) {
		Lib.soloLetras(e,txtTitoriginal,20);
	}
	
	protected void keyTypedTxtGenero(KeyEvent e) {
		Lib.soloLetras(e,txtGenero,20);

	}
	
	protected void keyTypedTxtPaisorigen(KeyEvent e) {
		Lib.soloLetras(e,txtPaisorigen,15);

	}
	
	protected void keyTypedTxtSinopsis(KeyEvent e) {
		Lib.soloLetras(e,txtSinopsis,15);

	}
	
	protected void keyTypedTxtDuracion(KeyEvent e) {
		Lib.soloNumeros(e,txtDuracion,15);

	}
	
	protected void keyTypedTxtRecaudacion(KeyEvent e) {
		Lib.soloNumeros(e,txtRecaudacion,15);

	}
	
	

}
