package gui;




import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloEmpleados;
import arreglos.ArregloClientes;
import arreglos.ArregloCines;
import arreglos.ArregloSalas;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Proyecto extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JMenuBar menuProyecto;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JLabel lblImagen;
	private JMenu mnMantenimiento;
	private JMenuItem mntmEmpleados;
	private JMenuItem mntmClientes;
	private JMenuItem mntmCines;
	private JMenuItem mntmSalas;
	private JMenuItem mntmPelculas;
	private JMenuItem mntmFunciones;
	
	public static ArregloEmpleados ae = new ArregloEmpleados();
	public static ArregloClientes ac = new ArregloClientes();
	public static ArregloCines aci = new ArregloCines();
	public static ArregloSalas as = new ArregloSalas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyecto frame = new Proyecto();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Proyecto() {
		setTitle("Sistema de Atenci\u00F3n de Cines");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AGAF\\Desktop\\CIBERTEC\\SEGUNDO CICLO\\1814 - ALGORITMOS Y ESTRUCTURA DE DATOS\\Proyecto_Sistema_Atencion_Cine\\Proyecto\\imagenes\\Cine.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		menuProyecto = new JMenuBar();
		setJMenuBar(menuProyecto);
		
		mnArchivo = new JMenu("Archivo");
		menuProyecto.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuProyecto.add(mnMantenimiento);
		
		mntmEmpleados = new JMenuItem("Empleados");
		mntmEmpleados.addActionListener(this);
		mnMantenimiento.add(mntmEmpleados);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(this);
		mnMantenimiento.add(mntmClientes);
		
		mntmCines = new JMenuItem("Cines");
		mntmCines.addActionListener(this);
		mnMantenimiento.add(mntmCines);
		
		mntmSalas = new JMenuItem("Salas");
		mntmSalas.addActionListener(this);
		mnMantenimiento.add(mntmSalas);
		
		mntmPelculas = new JMenuItem("Pel\u00EDculas");
		mntmPelculas.addActionListener(this);
		mnMantenimiento.add(mntmPelculas);
		
		mntmFunciones = new JMenuItem("Funciones");
		mntmFunciones.addActionListener(this);
		mnMantenimiento.add(mntmFunciones);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon("C:\\Users\\AGAF\\Desktop\\CIBERTEC\\SEGUNDO CICLO\\1814 - ALGORITMOS Y ESTRUCTURA DE DATOS\\Proyecto_Sistema_Atencion_Cine\\Proyecto\\imagenes\\Cinema.jpg"));
		lblImagen.setBounds(0, 0, 784, 540);
		contentPane.add(lblImagen);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmEmpleados) {
			actionPerformedMntmEmpleados(arg0);
		}else if (arg0.getSource() == mntmCines) {
			actionPerformedMntmCines(arg0);
		}else if (arg0.getSource() == mntmClientes) {
			actionPerformedMntmClientes(arg0);
		}else if (arg0.getSource() == mntmSalas) {
			actionPerformedMntmSalas(arg0);
		}else if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		System.exit(0);
	}
	
	//GUI'S EMPLEADOS
	
	protected void actionPerformedMntmEmpleados(ActionEvent arg0) {
		DlgEmpleados de = new DlgEmpleados();
		de.setLocationRelativeTo(this);
		de.setVisible(true);
	}
	
	//GUI'S CLIENTES
	
	protected void actionPerformedMntmClientes(ActionEvent arg0) {
		DlgClientes dc = new DlgClientes();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}
	
	//GUI'S CINES
	
		protected void actionPerformedMntmCines(ActionEvent arg0) {
			DlgCines di = new DlgCines();
			di.setLocationRelativeTo(this);
			di.setVisible(true);
		}
	
	//GUI'S SALAS
		
		protected void actionPerformedMntmSalas(ActionEvent arg0) {
				DlgSalas ds = new DlgSalas();
				ds.setLocationRelativeTo(this);
				ds.setVisible(true);
		}
}
