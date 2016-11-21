package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.TableColumnModel;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Font;

public class DlgIncidencia extends JDialog implements ActionListener, WindowListener {

	private static final long serialVersionUID = 1L;
	
	private JButton btnIngresar;
	private JButton btnActualizar;
	private JButton btnSalir;
	private JScrollPane scpScroll;
	private JTable tblIncidencia;
	
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
					DlgIncidencia dialog = new DlgIncidencia();
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
	public DlgIncidencia() {
		addWindowListener(this);
		setResizable(false);
		setTitle("Edición | Incidencia");
		setBounds(100, 100, 890, 550);		
		getContentPane().setLayout(null);
		
		btnIngresar = new JButton("ingresar");		
		btnIngresar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(10, 10, 146, 56);
		btnIngresar.setIcon(new ImageIcon("imagenes/adicionar.png"));
		getContentPane().add(btnIngresar);
		
		btnActualizar = new JButton("actualizar");
		btnActualizar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(155, 10, 146, 56);
		btnActualizar.setIcon(new ImageIcon("imagenes/modificar.png"));
		getContentPane().add(btnActualizar);
		
		btnSalir = new JButton("salir");
		btnSalir.setFont(new Font("Cambria", Font.BOLD, 12));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(728, 10, 146, 56);
		btnSalir.setIcon(new ImageIcon("imagenes/salir.png"));
		getContentPane().add(btnSalir);
	
		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 80, 864, 430);
		getContentPane().add(scpScroll);
		
		tblIncidencia = new JTable();
		tblIncidencia.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scpScroll.setViewportView(tblIncidencia);
		tblIncidencia.setModel(Proyecto_AED_2015_1.ai);
		tblIncidencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblIncidencia.setFillsViewportHeight(true);
		scpScroll.setViewportView(tblIncidencia);
		
		tblIncidencia.getSelectionModel().setSelectionInterval(0, 0);
		ajustarAnchoColumnas();	
	}
	private int anchoColumna(int porcentaje) {
		return porcentaje * scpScroll.getWidth() / 100;
	}
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblIncidencia.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 6));  // código
		tcm.getColumn(1).setPreferredWidth(anchoColumna( 6));  // codigoUsuario
		tcm.getColumn(2).setPreferredWidth(anchoColumna( 6));  // codigoEspecialista
		tcm.getColumn(3).setPreferredWidth(anchoColumna( 6));  // codigoTipoIncidencia
		tcm.getColumn(4).setPreferredWidth(anchoColumna(18));  // descripcion
		tcm.getColumn(5).setPreferredWidth(anchoColumna(26));  // comentario
		tcm.getColumn(6).setPreferredWidth(anchoColumna( 4));  // tiempoEstimadoSol
		tcm.getColumn(7).setPreferredWidth(anchoColumna( 4));  // tiempoRealSol
		tcm.getColumn(8).setPreferredWidth(anchoColumna( 6));  // fechaRegistro
		tcm.getColumn(9).setPreferredWidth(anchoColumna( 6));  // fechaInicioAtencion
		tcm.getColumn(10).setPreferredWidth(anchoColumna(6));  // fechaFinAtencion
		tcm.getColumn(11).setPreferredWidth(anchoColumna(6));  // estado
	}	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		tipoOperacion = 0;
		lanzarFormulario();
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		tipoOperacion = 1;
		lanzarFormulario();
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {
		Proyecto_AED_2015_1.ai.grabarIncidencias();		
		dispose();
	}
	private String obtenerTitulo() {
		String titulo[] = { "Ingresar", "Actualizar" };
		return titulo[tipoOperacion];
	}
	private void lanzarFormulario() {
		DlgIncidenciaActividad dia = new DlgIncidenciaActividad();
		dia.setTipoOperacion(tipoOperacion);
		dia.setTitle(this.getTitle() + " | " + obtenerTitulo());
		dia.configurarFormulario();
		dia.setLocationRelativeTo(this);
		if (tipoOperacion != 0)
			dia.cargarIncidencia(Proyecto_AED_2015_1.ai.obtener(tblIncidencia.getSelectedRow()));
		dia.setVisible(true);
	}
	public void windowActivated(WindowEvent e) {
	}
	public void windowClosed(WindowEvent e) {
	}
	public void windowClosing(WindowEvent e) {
		Proyecto_AED_2015_1.ai.grabarIncidencias();
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
