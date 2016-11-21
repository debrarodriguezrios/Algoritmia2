package gui;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.TableColumnModel;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.Font;

public class DlgUsuario extends JDialog implements ActionListener, WindowListener {

	private static final long serialVersionUID = 1L;
	
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JScrollPane scpScroll;
	private JTable tblUsuario;
	
	private int tipoOperacion;
		
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
					DlgUsuario dialog = new DlgUsuario();
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
	public DlgUsuario() {
		addWindowListener(this);
		setResizable(false);
		setTitle("Mantenimiento | Usuario");
		setBounds(100, 100, 850, 500);		
		getContentPane().setLayout(null);
		
		btnAdicionar = new JButton("adicionar");		
		btnAdicionar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(10, 10, 166, 56);
		btnAdicionar.setIcon(new ImageIcon("imagenes/adicionar.png"));
		getContentPane().add(btnAdicionar);
		
		btnConsultar = new JButton("consultar");		
		btnConsultar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(175, 10, 166, 56);
		btnConsultar.setIcon(new ImageIcon("imagenes/consultar.png"));
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("modificar");
		btnModificar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(340, 10, 166, 56);
		btnModificar.setIcon(new ImageIcon("imagenes/modificar.png"));
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("eliminar");
		btnEliminar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(505, 10, 166, 56);
		btnEliminar.setIcon(new ImageIcon("imagenes/eliminar.png"));
		getContentPane().add(btnEliminar);
		
		btnSalir = new JButton("salir");
		btnSalir.setFont(new Font("Cambria", Font.BOLD, 12));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(670, 10, 166, 56);
		btnSalir.setIcon(new ImageIcon("imagenes/salir.png"));
		getContentPane().add(btnSalir);
	
		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 80, 827, 380);
		getContentPane().add(scpScroll);
		
		tblUsuario = new JTable();
		tblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scpScroll.setViewportView(tblUsuario);
		tblUsuario.setModel(Proyecto_AED_2015_1.au);
		tblUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblUsuario.setFillsViewportHeight(true);
		scpScroll.setViewportView(tblUsuario);
		
		tblUsuario.getSelectionModel().setSelectionInterval(0, 0);
		ajustarAnchoColumnas();	
	}
	private int anchoColumna(int porcentaje) {
		return porcentaje * scpScroll.getWidth() / 100;
	}
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblUsuario.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 7));  // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(12));  // nombres
		tcm.getColumn(2).setPreferredWidth(anchoColumna(14));  // apellidos
		tcm.getColumn(3).setPreferredWidth(anchoColumna(12));  // tipoID
		tcm.getColumn(4).setPreferredWidth(anchoColumna( 6));  // númeroID
		tcm.getColumn(5).setPreferredWidth(anchoColumna(12));  // area
		tcm.getColumn(6).setPreferredWidth(anchoColumna(16));  // correo
		tcm.getColumn(7).setPreferredWidth(anchoColumna( 7));  // telefono
		tcm.getColumn(8).setPreferredWidth(anchoColumna( 7));  // fechaIngreso
		tcm.getColumn(9).setPreferredWidth(anchoColumna( 7));  // estado
	}	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		tipoOperacion = 0;
		lanzarFormulario();
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		tipoOperacion = 1;
		lanzarFormulario();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		tipoOperacion = 2;
		lanzarFormulario();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		tipoOperacion = 3;
		lanzarFormulario();
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {
		Proyecto_AED_2015_1.au.grabarUsuarios();		
		dispose();
	}
	private String obtenerTitulo() {
		String titulo[] = { "Adicionar", "Consultar" ,
				            "Modificar", "Eliminar" };
		return titulo[tipoOperacion];
	}
	private void lanzarFormulario() {
		DlgUsuarioActividad dua = new DlgUsuarioActividad();
		dua.setTipoOperacion(tipoOperacion);
		dua.setTitle(this.getTitle() + " | " + obtenerTitulo());
		dua.configurarFormulario();
		dua.setLocationRelativeTo(this);
		if (tipoOperacion != 0)
			dua.cargarUsuario(Proyecto_AED_2015_1.au.obtener(tblUsuario.getSelectedRow()));
		dua.setVisible(true);
	}
	public void windowActivated(WindowEvent e) {
	}
	public void windowClosed(WindowEvent e) {
	}
	public void windowClosing(WindowEvent e) {
		Proyecto_AED_2015_1.au.grabarUsuarios();
	}
	public void windowDeactivated(WindowEvent e) {
	}
	public void windowDeiconified(WindowEvent e) {
	}
	public void windowIconified(WindowEvent e) {
	}
	public void windowOpened(WindowEvent e) {
	}
}
