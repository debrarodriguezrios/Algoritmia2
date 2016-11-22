package gui;

import java.awt.EventQueue;



import clases.Cliente;


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

public class DlgAcceso extends JDialog implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblContrasea;
	private JTextField txtContrasena;
	private JButton btnAceptar;
	private JButton btnSalir;

	private int  tipoOperacion;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgAcceso dialog = new DlgAcceso();
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
	public DlgAcceso() {
		setTitle("Acceso | Empleado ");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AGAF\\Desktop\\CIBERTEC\\SEGUNDO CICLO\\1814 - ALGORITMOS Y ESTRUCTURA DE DATOS\\Proyecto_Sistema_Atencion_Cine\\Proyecto\\imagenes\\Cine.png"));
		setBounds(100, 100, 469, 297);
		getContentPane().setLayout(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(85, 59, 46, 14);
		getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(this);
		txtUsuario.addActionListener(this);
		txtUsuario.setBounds(182, 56, 114, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(85, 107, 70, 14);
		getContentPane().add(lblContrasea);
		
		txtContrasena = new JTextField();
		txtContrasena.addKeyListener(this);
		txtContrasena.addActionListener(this);
		txtContrasena.setBounds(182, 104, 114, 20);
		getContentPane().add(txtContrasena);
		txtContrasena.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(97, 192, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(248, 192, 89, 23);
		getContentPane().add(btnSalir);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtContrasena) {
			actionPerformedTxtContrasena(e);
		}
		if (e.getSource() == txtUsuario) {
			actionPerformedTxtUsuario(e);
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
	

	//  Habilitar o deshabilitar las cajas de texto
	private void habilitarCajasDeTexto(boolean b) {
		
		txtUsuario.setEditable(b);
		txtContrasena.setEnabled(b);
	
	}
	
	
//  Métodos que retornan valor (sin parámetros)
	
	
	private String leerUsuario() {
		return Lib.leerCadena(txtUsuario);
	}
	
	private String leerContraseña() {
		return Lib.leerCadena(txtContrasena);
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		
	}
	
	
	protected void actionPerformedTxtUsuario(ActionEvent e) {
		txtContrasena.requestFocus();
	}
	protected void actionPerformedTxtContrasena(ActionEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtContrasena) {
			keyTypedTxtContrasena(e);
		}
		if (e.getSource() == txtUsuario) {
			keyTypedTxtUsuario(e);
		}
	}
	
	protected void keyTypedTxtUsuario(KeyEvent e) {
		Lib.soloLetras(e,txtUsuario,15);

	}
	
	protected void keyTypedTxtContrasena(KeyEvent e) {
		Lib.soloLetras(e,txtContrasena,15);

	}
}
