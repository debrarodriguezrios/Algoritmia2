package gui;

import java.awt.EventQueue;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.TableColumnModel;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.Font;

public class DlgCines extends JDialog implements ActionListener, WindowListener {
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable tblCines;
	private JButton btnIngreso;         //////////////ver
	private JButton btnModificacion;    
	private JButton btnEliminacion;     
	private JButton btnSalir;           
	private JButton btnConsulta;       //////////////ver
	
	
	private int tipoOperacion;

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
					DlgCines dialog = new DlgCines();
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
	public DlgCines() {
		addWindowListener(this);
		setResizable(false);
		setTitle("Mantenimiento | Cines");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AGAF\\Desktop\\CIBERTEC\\SEGUNDO CICLO\\1814 - ALGORITMOS Y ESTRUCTURA DE DATOS\\Proyecto_Sistema_Atencion_Cine\\Proyecto\\imagenes\\Cine.png"));
		setBounds(100, 100, 1305, 628);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 180, 1269, 382);
		getContentPane().add(scrollPane);
		
		tblCines = new JTable();
		tblCines.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCines);
		tblCines.setModel(Proyecto.aci);   //////////////ver
		tblCines.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //////////////ver
		tblCines.setFillsViewportHeight(true); //////////////ver
		scrollPane.setViewportView(tblCines); //////////////ver
		
				
		btnIngreso = new JButton("Ingreso");
		btnIngreso.addActionListener(this);
		btnIngreso.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		btnIngreso.setBounds(-7, 41, 267, 105);
		getContentPane().add(btnIngreso);
		
		btnModificacion = new JButton("Modificaci\u00F3n");
		btnModificacion.addActionListener(this);
		btnModificacion.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		btnModificacion.setBounds(513, 41, 267, 105);
		getContentPane().add(btnModificacion);
		
		btnEliminacion = new JButton("Eliminaci\u00F3n");
		btnEliminacion.addActionListener(this);
		btnEliminacion.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		btnEliminacion.setBounds(773, 41, 267, 105);
		getContentPane().add(btnEliminacion);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		btnSalir.setBounds(1033, 41, 267, 105);
		getContentPane().add(btnSalir);
		
		btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(this);
		btnConsulta.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		btnConsulta.setBounds(253, 41, 267, 105);
		getContentPane().add(btnConsulta);
		
		tblCines.getSelectionModel().setSelectionInterval(0, 0);
		ajustarAnchoColumnas();	


	}
	
	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblCines.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(25));  // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(32));  // nombres
		tcm.getColumn(2).setPreferredWidth(anchoColumna(22));  // apellido paterno
		tcm.getColumn(3).setPreferredWidth(anchoColumna(22));  // apellido materno
		tcm.getColumn(4).setPreferredWidth(anchoColumna(16));  // tipo de empleado
		tcm.getColumn(5).setPreferredWidth(anchoColumna(15));  // usuario
		tcm.getColumn(6).setPreferredWidth(anchoColumna(15));  // contraseņa
	
	}	
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnEliminacion) {
			actionPerformedBtnEliminacion(e);
		}
		if (e.getSource() == btnModificacion) {
			actionPerformedBtnModificacion(e);
		}
		if (e.getSource() == btnConsulta) {
			actionPerformedBtnConsulta(e);
		}
		if (e.getSource() == btnIngreso) {
			actionPerformedBtnIngreso(e);
		}
	}
	protected void actionPerformedBtnIngreso(ActionEvent e) {  //////////////ver
		tipoOperacion = 0;
		lanzarFormulario();   
	}
	protected void actionPerformedBtnConsulta(ActionEvent e) {  //////////////ver
		tipoOperacion = 1;
		lanzarFormulario();
	}
	
	protected void actionPerformedBtnModificacion(ActionEvent e) {  //////////////ver
		tipoOperacion = 2;
		lanzarFormulario();
	}
	protected void actionPerformedBtnEliminacion(ActionEvent e) {  //////////////ver
		tipoOperacion = 3;
		lanzarFormulario();
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {  //////////////ver
		Proyecto.ae.grabarEmpleado();		
		dispose();
	}
	
	private String obtenerTitulo() { //////////////ver
		String titulo[] = { "Adicionar", "Consultar" ,
				            "Modificar", "Eliminar" };
		return titulo[tipoOperacion];
	}
	
	private void lanzarFormulario() { //////////////ver
		DlgCinesActividad dea = new DlgCinesActividad();
		dea.setTipoOperacion(tipoOperacion);
		dea.setTitle(this.getTitle() + " | " + obtenerTitulo());
		dea.configurarFormulario();
		dea.setLocationRelativeTo(this);
		if (tipoOperacion != 0)
			dea.cargarCine(Proyecto.aci.obtener(tblCines.getSelectedRow()));
		dea.setVisible(true);
	}
	
	public void windowActivated(WindowEvent e) {  //////////////ver
	}
	public void windowClosed(WindowEvent e) {  //////////////ver
	}
	public void windowClosing(WindowEvent e) {  //////////////ver
		Proyecto.aci.grabarCine();
	}
	public void windowDeactivated(WindowEvent e) {  //////////////ver
	}
	public void windowDeiconified(WindowEvent e) {  //////////////ver
	}
	public void windowIconified(WindowEvent e) {  //////////////ver
	}
	public void windowOpened(WindowEvent e) {   //////////////ver
	}

}
