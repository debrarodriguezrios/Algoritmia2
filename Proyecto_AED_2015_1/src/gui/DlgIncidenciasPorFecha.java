package gui;

import clases.Incidencia;
import libreria.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class DlgIncidenciasPorFecha extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblFechaInicio;
	private JLabel lblFechaFin;
	private JComboBox <String> cboInicioDia;
	private JComboBox <String> cboInicioMes;
	private JComboBox <String> cboInicioAño;
	private JComboBox <String> cboFinDia;
	private JComboBox <String> cboFinMes;
	private JComboBox <String> cboFinAño;
	private JButton btnVolver;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgIncidenciasPorFecha dialog = new DlgIncidenciasPorFecha();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgIncidenciasPorFecha() {
		getContentPane().setLayout(null);
		setResizable(false);
		setTitle("Reporte | Incidencias por rango de Fecha");
		setBounds(100, 100, 595, 520);
		
		lblFechaInicio = new JLabel("INICIO DE ATENCI\u00D3N:");
		lblFechaInicio.setBounds(10, 10, 120, 23);
		getContentPane().add(lblFechaInicio);
		
		lblFechaFin = new JLabel("FIN DE ATENCI\u00D3N:");
		lblFechaFin.setBounds(10, 40, 120, 23);
		getContentPane().add(lblFechaFin);
		
		cboInicioDia = new JComboBox <String> ();
		colocarItems(cboInicioDia,1,31);
		cboInicioDia.addActionListener(this);
		cboInicioDia.setBounds(135, 10, 40, 23);
		getContentPane().add(cboInicioDia);
		
		cboInicioMes = new JComboBox <String> ();
		colocarMeses(cboInicioMes);
		cboInicioMes.addActionListener(this);
		cboInicioMes.setBounds(175, 10, 90, 23);
		getContentPane().add(cboInicioMes);
		
		cboInicioAño = new JComboBox <String> ();
		colocarItems(cboInicioAño,añoActual(),2000);
		cboInicioAño.addActionListener(this);
		cboInicioAño.setBounds(265, 10, 60, 23);
		getContentPane().add(cboInicioAño);
		
		cboFinDia = new JComboBox <String> ();
		colocarItems(cboFinDia,1,31);
		colocarDiaActual();
		cboFinDia.addActionListener(this);
		cboFinDia.setBounds(135, 40, 40, 23);
		getContentPane().add(cboFinDia);
		
		cboFinMes = new JComboBox <String> ();
		colocarMeses(cboFinMes);
		colocarMesActual();
		cboFinMes.addActionListener(this);
		cboFinMes.setBounds(175, 40, 90, 23);
		getContentPane().add(cboFinMes);
		
		cboFinAño = new JComboBox <String> ();
		colocarItems(cboFinAño,añoActual(),2000);
		cboFinAño.addActionListener(this);
		cboFinAño.setBounds(265, 40, 60, 23);
		getContentPane().add(cboFinAño);
		
		btnVolver = new JButton("volver");
		btnVolver.addActionListener(this);
		btnVolver.setBounds(470, 11, 109, 45);
		btnVolver.setIcon(new ImageIcon("imagenes/volver.png"));
		getContentPane().add(btnVolver);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 569, 402);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 11));
		scrollPane.setViewportView(txtS);
		
		filtrar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboFinAño) {
			actionPerformedCboFinAño(arg0);
		}
		if (arg0.getSource() == cboFinMes) {
			actionPerformedCboFinMes(arg0);
		}
		if (arg0.getSource() == cboFinDia) {
			actionPerformedCboFinDia(arg0);
		}
		if (arg0.getSource() == cboInicioAño) {
			actionPerformedCboInicioAño(arg0);
		}
		if (arg0.getSource() == cboInicioMes) {
			actionPerformedCboInicioMes(arg0);
		}
		if (arg0.getSource() == cboInicioDia) {
			actionPerformedCboInicioDia(arg0);
		}
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}		
	}
	protected void actionPerformedCboInicioDia(ActionEvent arg0) {
		filtrar();
	}
	protected void actionPerformedCboInicioMes(ActionEvent arg0) {
		filtrar();
	}
	protected void actionPerformedCboInicioAño(ActionEvent arg0) {
		filtrar();
	}
	protected void actionPerformedCboFinDia(ActionEvent arg0) {
		filtrar();
	}
	protected void actionPerformedCboFinMes(ActionEvent arg0) {
		filtrar();
	}
	protected void actionPerformedCboFinAño(ActionEvent arg0) {
		filtrar();
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		dispose();
	}
	void colocarDiaActual() {
		Calendar calendario = new GregorianCalendar();
		cboFinDia.setSelectedIndex(calendario.get(Calendar.DAY_OF_MONTH)-1);
	}
	void colocarMesActual() {
		Calendar calendario = new GregorianCalendar();
		cboFinMes.setSelectedIndex(calendario.get(Calendar.MONTH));
	}
	void filtrar() {
		int inicio = Fecha.getFecha(cboInicioDia,cboInicioMes,cboInicioAño),
		    fin = Fecha.getFecha(cboFinDia,cboFinMes,cboFinAño),
		    inicioAtencion, finAtencion;
		Incidencia x;
		txtS.setText("");
		for (int i=0; i<Proyecto_AED_2015_1.ai.tamaño(); i++) {
			x = Proyecto_AED_2015_1.ai.obtener(i);
			inicioAtencion = x.getFechaInicioAtencion();
			finAtencion = x.getFechaFinAtencion();
			if (inicio <= inicioAtencion  &&  fin >= finAtencion) {
				imprimir("Fecha de inicio de atención          :  " + Lib.formatoFecha(inicioAtencion));
				imprimir("Fecha de fin de atención             :  " + Lib.formatoFecha(finAtencion));
				imprimir("Código de usuario                    :  " + x.getCodigoUsuario());
				imprimir("Código del tipo de incidencia        :  " + x.getCodigoTipoIncidencia());
				imprimir("Código de especialista               :  " + x.getCodigoEspecialista());
				imprimir("Código de incidencia                 :  " + x.getCodigo());
				imprimir("Descripción                          :  " + x.getDescripcion());
				imprimir("Comentario                           :  " + x.getComentario());
				imprimir("Tiempo estimado de solución en horas :  " + x.getTiempoEstimadoSol());
				imprimir("Tiempo real de solución en horas     :  " + x.getTiempoRealSol());
				imprimir("Fecha de registro                    :  " + Lib.formatoFecha(x.getFechaRegistro()));
				imprimir("Estado                               :  " + Lib.tiposDeIncidencia[x.getEstado()]); 
				imprimir("------------------------------------------------------------------------------");
			}
		}
	}
	void colocarItems(JComboBox <String> cbo, int inicio, int fin) {
		if (inicio < fin)
			while (inicio <= fin) {
				cbo.addItem("" + inicio);
				inicio ++;
			}
		else
			while (inicio >= fin) {
				cbo.addItem("" + inicio);
				inicio --;
			}
	}
	void colocarMeses(JComboBox <String> cbo) {
		cbo.addItem("Enero");
		cbo.addItem("Febrero");
		cbo.addItem("Marzo");
		cbo.addItem("Abril");
		cbo.addItem("Mayo");
		cbo.addItem("Junio");
		cbo.addItem("Julio");
		cbo.addItem("Agosto");
		cbo.addItem("Setiembre");
		cbo.addItem("Octubre");
		cbo.addItem("Noviembre");
		cbo.addItem("Diciembre");
	}
	void imprimir(String s) {
		txtS.append(s + "\n"); 
	}
	int añoActual() {
		Calendar calendario = new GregorianCalendar();
		return calendario.get(Calendar.YEAR);
	}
	
}
