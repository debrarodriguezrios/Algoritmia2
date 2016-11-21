package gui;

import clases.Usuario;
import clases.Especialista;
import clases.Incidencia;
import clases.TipoIncidencia;
import libreria.*;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;

import java.awt.event.KeyEvent;
import java.awt.Font;

public class DlgIncidenciaActividad extends JDialog implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;

	private JLabel lblCodigo;
	private JLabel lblCodigoTipoIncidencia;
	private JLabel lblTiempoRealSol;	
	private JLabel lblCodigoUsuario;
	private JLabel lblTiempoEstimadoSol;
	private JLabel lblCodigoEspecialista;
	private JLabel lblDescripcion;
	private JLabel lblComentario;
	private JLabel lblFechaRegistro;
	private JLabel lblFechaInicioAtencion;
	private JLabel lblFechaFinAtencion;
	private JLabel lblEstado;
	private JTextArea txtDescripcion;
	private JTextArea txtComentario;
	private JTextField txtTiempoEstimadoSol;
	private JTextField txtTiempoRealSol;
	private JComboBox <String> cboCodigoUsuario;
	private JComboBox <String> cboCodigoEspecialista;
	private JComboBox <String> cboCodigoTipoIncidencia;
	private JComboBox <String> cboRegistroDia;
	private JComboBox <String> cboRegistroMes;
	private JComboBox <String> cboRegistroAño;
	private JComboBox <String> cboInicioAtencionDia;
	private JComboBox <String> cboInicioAtencionMes;
	private JComboBox <String> cboInicioAtencionAño;
	private JComboBox <String> cboFinAtencionDia;
	private JComboBox <String> cboFinAtencionMes;
	private JComboBox <String> cboFinAtencionAño;
	private JComboBox <String> cboEstado;
	private JScrollPane scrollPane;
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
					DlgIncidenciaActividad dialog = new DlgIncidenciaActividad();
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
	public DlgIncidenciaActividad() {
		getContentPane().setFont(new Font("Cambria", Font.BOLD, 12));
		setResizable(false);
		setBounds(100, 100, 520, 500);
		getContentPane().setLayout(null);
	
		lblCodigo = new JLabel("C\u00D3DIGO");
		lblCodigo.setBounds(10, 11, 102, 23);
		getContentPane().add(lblCodigo);
	
		lblCodigo = new JLabel();
		lblCodigo.setBounds(209, 11, 102, 23);
		getContentPane().add(lblCodigo);
		
		lblCodigoUsuario = new JLabel("CÓDIGO DE USUARIO");
		lblCodigoUsuario.setBounds(10, 41, 180, 23);
		getContentPane().add(lblCodigoUsuario);
		
		cboCodigoUsuario = new JComboBox <String> ();
		colocarUsuarios();
		cboCodigoUsuario.setBounds(205, 41, 126, 23);
		getContentPane().add(cboCodigoUsuario);
		
		lblCodigoEspecialista = new JLabel("CÓDIGO DE ESPECIALISTA");
		lblCodigoEspecialista.setBounds(10, 71, 190, 23);
		getContentPane().add(lblCodigoEspecialista);
		
		cboCodigoEspecialista = new JComboBox <String> ();
		colocarEspecialistas();
		cboCodigoEspecialista.setBounds(205, 71, 126, 23);
		getContentPane().add(cboCodigoEspecialista);
	
		lblCodigoTipoIncidencia = new JLabel("CÓDIGO DE TIPO DE INCIDENCIA");
		lblCodigoTipoIncidencia.setBounds(10, 101, 190, 23);
		getContentPane().add(lblCodigoTipoIncidencia);
		
		cboCodigoTipoIncidencia = new JComboBox <String> ();
		colocarTipoIncidencias();
		cboCodigoTipoIncidencia.setBounds(205, 101, 126, 23);
		getContentPane().add(cboCodigoTipoIncidencia);
		
		lblDescripcion = new JLabel("DESCRIPCIÓN");
		lblDescripcion.setBounds(10, 131, 190, 23);
		getContentPane().add(lblDescripcion);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(205, 131, 300, 43);
		getContentPane().add(scrollPane);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollPane.setViewportView(txtDescripcion);
		
		lblComentario = new JLabel("COMENTARIO");
		lblComentario.setBounds(10, 190, 180, 23);
		getContentPane().add(lblComentario);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(205, 180, 300, 43);
		getContentPane().add(scrollPane);
		
		txtComentario = new JTextArea();
		scrollPane.setViewportView(txtComentario);
		txtComentario.setFont(new Font("Arial", Font.PLAIN, 11));

		lblTiempoEstimadoSol = new JLabel("TIEMPO ESTIMADO DE SOLUCIÓN");
		lblTiempoEstimadoSol.setBounds(10, 230, 190, 23);
		getContentPane().add(lblTiempoEstimadoSol);
		
		txtTiempoEstimadoSol = new JTextField();
		txtTiempoEstimadoSol.addKeyListener(this);
		txtTiempoEstimadoSol.addActionListener(this);
		txtTiempoEstimadoSol.setHorizontalAlignment(SwingConstants.LEFT);
		txtTiempoEstimadoSol.setColumns(10);
		txtTiempoEstimadoSol.setBounds(205, 230, 126, 23);
		getContentPane().add(txtTiempoEstimadoSol);		
		
		lblTiempoRealSol = new JLabel("TIEMPO REAL DE SOLUCIÓN");
		lblTiempoRealSol.setBounds(10, 260, 190, 23);
		getContentPane().add(lblTiempoRealSol);
	
		txtTiempoRealSol = new JTextField();
		txtTiempoRealSol.addKeyListener(this);
		txtTiempoRealSol.addActionListener(this);
		txtTiempoRealSol.setHorizontalAlignment(SwingConstants.LEFT);
		txtTiempoRealSol.setColumns(10);
		txtTiempoRealSol.setBounds(205, 260, 126, 23);
		getContentPane().add(txtTiempoRealSol);
		
		lblFechaRegistro = new JLabel("FECHA DE REGISTRO");
		lblFechaRegistro.setBounds(10, 290, 190, 23);
		getContentPane().add(lblFechaRegistro);
		
		cboRegistroDia = new JComboBox <String> ();
		Fecha.colocarItems(cboRegistroDia,1,31);
		Fecha.colocarDiaActual(cboRegistroDia);
		cboRegistroDia.addActionListener(this);
		cboRegistroDia.setBounds(205, 290, 40, 23);
		getContentPane().add(cboRegistroDia);
		
		cboRegistroMes = new JComboBox <String> ();
		Fecha.colocarMeses(cboRegistroMes);
		Fecha.colocarMesActual(cboRegistroMes);
		cboRegistroMes.addActionListener(this);
		cboRegistroMes.setBounds(245, 290, 90, 23);
		getContentPane().add(cboRegistroMes);
		
		cboRegistroAño = new JComboBox <String> ();
		Fecha.colocarItems(cboRegistroAño,Fecha.añoActual(),2000);
		cboRegistroAño.addActionListener(this);
		cboRegistroAño.setBounds(335, 290, 60, 23);
		getContentPane().add(cboRegistroAño);
		
		lblFechaInicioAtencion = new JLabel("FECHA DE INICIO DE ATENCIÓN");
		lblFechaInicioAtencion.setBounds(10, 320, 190, 23);
		getContentPane().add(lblFechaInicioAtencion);
	
		cboInicioAtencionDia = new JComboBox <String> ();
		Fecha.colocarItems(cboInicioAtencionDia,1,31);
		Fecha.colocarDiaActual(cboInicioAtencionDia);
		cboInicioAtencionDia.addActionListener(this);
		cboInicioAtencionDia.setBounds(205, 320, 40, 23);
		getContentPane().add(cboInicioAtencionDia);
		
		cboInicioAtencionMes = new JComboBox <String> ();
		Fecha.colocarMeses(cboInicioAtencionMes);
		Fecha.colocarMesActual(cboInicioAtencionMes);
		cboInicioAtencionMes.addActionListener(this);
		cboInicioAtencionMes.setBounds(245, 320, 90, 23);
		getContentPane().add(cboInicioAtencionMes);
		
		cboInicioAtencionAño = new JComboBox <String> ();
		Fecha.colocarItems(cboInicioAtencionAño,Fecha.añoActual(),2000);
		cboInicioAtencionAño.addActionListener(this);
		cboInicioAtencionAño.setBounds(335, 320, 60, 23);
		getContentPane().add(cboInicioAtencionAño);

		lblFechaFinAtencion = new JLabel("FECHA DE FIN DE ATENCIÓN");
		lblFechaFinAtencion.setBounds(10, 350, 190, 23);
		getContentPane().add(lblFechaFinAtencion);
	
		cboFinAtencionDia = new JComboBox <String> ();
		Fecha.colocarItems(cboFinAtencionDia,1,31);
		Fecha.colocarDiaActual(cboFinAtencionDia);
		cboFinAtencionDia.addActionListener(this);
		cboFinAtencionDia.setBounds(205, 350, 40, 23);
		getContentPane().add(cboFinAtencionDia);
		
		cboFinAtencionMes = new JComboBox <String> ();
		Fecha.colocarMeses(cboFinAtencionMes);
		Fecha.colocarMesActual(cboFinAtencionMes);
		cboFinAtencionMes.addActionListener(this);
		cboFinAtencionMes.setBounds(245, 350, 90, 23);
		getContentPane().add(cboFinAtencionMes);
		
		cboFinAtencionAño = new JComboBox <String> ();
		Fecha.colocarItems(cboFinAtencionAño,Fecha.añoActual(),2000);
		cboFinAtencionAño.addActionListener(this);
		cboFinAtencionAño.setBounds(335, 350, 60, 23);
		getContentPane().add(cboFinAtencionAño);
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(10, 380, 55, 23);
		getContentPane().add(lblEstado);
		
		cboEstado = new JComboBox <String> ();
		cboEstado.setModel(new DefaultComboBoxModel <String> (Lib.tiposDeIncidencia));
		cboEstado.setBounds(205, 380, 90, 23);
		getContentPane().add(cboEstado);

		btnAceptar = new JButton("aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnAceptar.setBounds(275, 420, 109, 45);
		btnAceptar.setIcon(new ImageIcon("imagenes/aceptar.png"));
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("volver");
		btnVolver.setFont(new Font("Cambria", Font.BOLD, 12));
		btnVolver.addActionListener(this);
		btnVolver.setBounds(395, 420, 109, 45);
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
		if (e.getSource() == txtTiempoRealSol) {
			actionPerformedTxtTiempoRealSol(e);
		}
		if (e.getSource() == txtTiempoEstimadoSol) {
			actionPerformedTxtTiempoEstimadoSol(e);
		}
	}
	protected void actionPerformedTxtTiempoEstimadoSol(ActionEvent e) {
		txtTiempoRealSol.requestFocus();
	}
	protected void actionPerformedTxtTiempoRealSol(ActionEvent e) {
		adicionarActualizarIncidencia(true);
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		switch (tipoOperacion) {
			case 0:		
				adicionarActualizarIncidencia(true);
				break;
			default:
				adicionarActualizarIncidencia(false);
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
		if (e.getSource() == txtTiempoEstimadoSol) {
			keyTypedTiempoEstimadoSol(e);
		}
		if (e.getSource() == txtTiempoRealSol) {
			keyTypedTiempoRealSol(e);
		}
	}
	protected void keyTypedTiempoEstimadoSol(KeyEvent e) {
		Lib.soloNumeros(e,txtTiempoEstimadoSol,2);
	}
	protected void keyTypedTiempoRealSol(KeyEvent e) {
		Lib.soloNumeros(e,txtTiempoRealSol,2);
	}
	//  Adicionar una nueva incidencia
	private void adicionarActualizarIncidencia(boolean adicionar) {
		if (leerDescripcion().length() == 0) {
			txtDescripcion.requestFocus();
			Lib.mensajeError(this, "Ingrese DESCRIPCIÓN");
		}
		else
			if (leerComentario().length() == 0) {
				txtComentario.requestFocus();
				Lib.mensajeError(this, "Ingrese COMENTARIO");
			}
			else 
				if (leerTiempoEstimadoSol() == -1) {
					txtTiempoEstimadoSol.requestFocus();
					Lib.mensajeError(this, "Ingrese TIEMPO ESTIMADO DE SOLUCIÓN");
				}
				else
					if (leerTiempoRealSol() == -1) {
						txtTiempoRealSol.requestFocus();
						Lib.mensajeError(this, "Ingrese TIEMPO REAL DE SOLUCIÓN");
					}
					else {
						if (adicionar) {
							Incidencia nueva = new Incidencia(leerCodigo(), leerCodigoUsuario(), 
							   	                              leerCodigoEspecialista(),leerCodigoTipoIncidencia(),
			                                                  leerDescripcion(),leerComentario(),
			                                                  leerTiempoEstimadoSol(),leerTiempoRealSol(),
			                                                  leerFechaRegistro(),leerFechaInicioAtencion(),
			                                                  leerFechaFinAtencion(),leerPosEstado());
							Proyecto_AED_2015_1.ai.adicionar(nueva);
							Lib.mensajeInformacion(this, "La incidencia ha sido adicionada");
						}
						else {
							Incidencia x = Proyecto_AED_2015_1.ai.buscar(leerCodigo());
							x.setCodigoUsuario(leerCodigoUsuario());
							x.setCodigoEspecialista(leerCodigoEspecialista());
							x.setCodigoTipoIncidencia(leerCodigoTipoIncidencia());
							x.setDescripcion(leerDescripcion());
							x.setComentario(leerComentario());
							x.setTiempoEstimadoSol(leerTiempoEstimadoSol());
							x.setTiempoRealSol(leerTiempoRealSol());
							x.setFechaRegistro(leerFechaRegistro());
							x.setFechaInicioAtencion(leerFechaInicioAtencion());
							x.setFechaFinAtencion(leerFechaFinAtencion());
							x.setEstado(leerPosEstado());
							Lib.mensajeInformacion(this, "El Usuario ha sido modificado");
						}
						dispose();
					}
	}
	//  Establece el tipo de operación a afectuar
	public void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}	
	//  Cargar los datos de una incidencia
	public void cargarIncidencia(Incidencia x) {
		lblCodigo.setText(x.getCodigo() + "");
		cboCodigoUsuario.setSelectedItem(x.getCodigoUsuario() + "");
		cboCodigoEspecialista.setSelectedItem(x.getCodigoEspecialista() + "");
		cboCodigoTipoIncidencia.setSelectedItem(x.getCodigoTipoIncidencia() + "");
		txtDescripcion.setText(x.getDescripcion());		
		txtComentario.setText(x.getComentario());	
		txtTiempoEstimadoSol.setText(x.getTiempoEstimadoSol() + "");	
		txtTiempoRealSol.setText(x.getTiempoRealSol() + "");
		Fecha.setFecha(cboRegistroDia,cboRegistroMes,cboRegistroAño,x.getFechaRegistro());
		Fecha.setFecha(cboInicioAtencionDia,cboInicioAtencionMes,cboInicioAtencionAño,x.getFechaInicioAtencion());
		Fecha.setFecha(cboFinAtencionDia,cboFinAtencionMes,cboFinAtencionAño,x.getFechaFinAtencion());
		cboEstado.setSelectedIndex(x.getEstado());
	}	
	//  Configurar el formulario para la operación a efectuar
	public void configurarFormulario() {
		switch (tipoOperacion) {
			case 0:
				lblCodigo.setText(Proyecto_AED_2015_1.ai.generarCodigo() + "");
				habilitarCajasDeTexto(true);
				break;
			default:
				habilitarCajasDeTexto(false);
		}
	}
	//  Habilitar o deshabilitar las cajas de texto
	private void habilitarCajasDeTexto(boolean b) {
		cboRegistroDia.setEnabled(b);
		cboRegistroMes.setEnabled(b);
		cboRegistroAño.setEnabled(b);
	}
	//  Métodos tipo void (sin parámetros)	
	void colocarUsuarios() {
		Usuario x;
		for (int i=0; i<Proyecto_AED_2015_1.au.tamaño(); i++) {
			x = Proyecto_AED_2015_1.au.obtener(i);
			cboCodigoUsuario.addItem(x.getCodigo() + "");
		}	
	}
	void colocarEspecialistas() {
		Especialista x;
		for (int i=0; i<Proyecto_AED_2015_1.ae.tamaño(); i++) {
			x = Proyecto_AED_2015_1.ae.obtener(i);
			cboCodigoEspecialista.addItem(x.getCodigo() + "");
		}	
	}
	void colocarTipoIncidencias() {
		TipoIncidencia x;
		for (int i=0; i<Proyecto_AED_2015_1.ati.tamaño(); i++) {
			x = Proyecto_AED_2015_1.ati.obtener(i);
			cboCodigoTipoIncidencia.addItem(x.getCodigo() + "");
		}	
	}
	//  Métodos que retornan valor (sin parámetros)
	private int leerCodigo() {
		return Lib.leerEntero(lblCodigo);
	}
	private int leerCodigoUsuario() {
		return Integer.parseInt(cboCodigoUsuario.getSelectedItem().toString());
	}
	private int leerCodigoEspecialista() {
		return Integer.parseInt(cboCodigoEspecialista.getSelectedItem().toString());
	}
	private int leerCodigoTipoIncidencia() {
		return Integer.parseInt(cboCodigoTipoIncidencia.getSelectedItem().toString());
	}
	private String leerDescripcion() {
		return Lib.leerCadenaGrande(txtDescripcion);
	}
	private String leerComentario() {
		return Lib.leerCadenaGrande(txtComentario);
	}
	private int leerTiempoEstimadoSol() {
		return Lib.leerEntero(txtTiempoEstimadoSol);
	}
	private int leerTiempoRealSol() {
		return Lib.leerEntero(txtTiempoRealSol);
	}
	private int leerFechaRegistro() {
		return Fecha.getFecha(cboRegistroDia,cboRegistroMes,cboRegistroAño);
	}
	private int leerFechaInicioAtencion() {
		return Fecha.getFecha(cboInicioAtencionDia,cboInicioAtencionMes,cboInicioAtencionAño);
	}
	private int leerFechaFinAtencion() {
		return Fecha.getFecha(cboFinAtencionDia,cboFinAtencionMes,cboFinAtencionAño);
	}
	private int leerPosEstado() {
		return cboEstado.getSelectedIndex();
	}
}
