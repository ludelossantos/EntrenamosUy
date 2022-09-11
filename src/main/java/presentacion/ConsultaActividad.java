package presentacion;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import datatypes.DtActividadDeportiva;
import interfaces.IControllerConsultaActividad;
import interfaces.IControllerConsultaUsuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class ConsultaActividad extends JInternalFrame{
	
	private static final long serialVersionUID = 1L;
	private IControllerConsultaActividad cAController;
	private JComboBox<String> comboBoxInstitucion;
	private JComboBox<String> comboBoxActividades;
	private JTextField textFieldNombre;
	private JTextField textFieldDuracion;
	private JTextField textFieldDescripcion;
	private JTextField textFieldCosto;
	private JTextField textFieldFecha;
	private String institucion;
	private String actividad;

	/**
	 * Create the frame.
	 */
	public ConsultaActividad(IControllerConsultaActividad cAController) {
		this.cAController = cAController;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setTitle("Consulta de Actividad");
		setBounds(100, 100, 579, 503);
		getContentPane().setLayout(null);
		
		JLabel lblNickname = new JLabel("Institución");
		lblNickname.setBounds(42, 34, 92, 16);
		lblNickname.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(lblNickname);
		
		JList<String> list = new JList<String>();
		list.setBounds(154, 57, 1, 1);
		list.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(list);
		
		JButton btnVerInfo = new JButton("Ver información");
		btnVerInfo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnVerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDatos(institucion, actividad);
			}
		});
		btnVerInfo.setBounds(363, 108, 163, 35);
		getContentPane().add(btnVerInfo);
		
		comboBoxInstitucion = new JComboBox<String>();		
		comboBoxInstitucion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBoxInstitucion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargaActividadesInstitucion(e);	
			}
		});
		/*comboBoxInstitucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxActividades.setEnabled(true);
			}
		});*/
		comboBoxInstitucion.setBounds(133, 33, 393, 25);
		getContentPane().add(comboBoxInstitucion);
		cargarComboInstituciones();
		//comboBoxInstitucion.addItem("x");
		//comboBoxInstitucion.setSelectedItem("x");
		 
		comboBoxActividades = new JComboBox<String>();
		comboBoxActividades.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		//cargarComboActividades(institucion);
		comboBoxActividades.setEnabled(false);
		comboBoxActividades.setBounds(133, 72, 393, 25);
		getContentPane().add(comboBoxActividades);
		//comboBoxActividades.addItem("x");
		//comboBoxActividades.setSelectedItem("x");
		
		JLabel lblActividades = new JLabel("Actividad");
		lblActividades.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblActividades.setBounds(42, 73, 92, 16);
		getContentPane().add(lblActividades);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNombre.setBounds(42, 154, 61, 25);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(132, 153, 393, 25);
		textFieldNombre.setEnabled(false);
		//textFieldNombre.setSelectedTextColor(getBackground());
		getContentPane().add(textFieldNombre);
		
		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblDescripcion.setBounds(42, 192, 130, 25);
		getContentPane().add(lblDescripcion);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldDuracion.setColumns(10);
		textFieldDuracion.setBounds(123, 364, 160, 25);
		textFieldDuracion.setEnabled(false);
		getContentPane().add(textFieldDuracion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setBounds(42, 224, 484, 130);
		textFieldDescripcion.setEnabled(false);
		getContentPane().add(textFieldDescripcion);
		
		JLabel lblDuracion = new JLabel("Duración");
		lblDuracion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblDuracion.setBounds(42, 365, 78, 25);
		getContentPane().add(lblDuracion);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblCosto.setBounds(309, 366, 47, 25);
		getContentPane().add(lblCosto);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldCosto.setColumns(10);
		textFieldCosto.setBounds(366, 364, 160, 26);
		textFieldCosto.setEnabled(false);
		getContentPane().add(textFieldCosto);
		
		JLabel lblFechaReg = new JLabel("Fecha de registro");
		lblFechaReg.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblFechaReg.setBounds(266, 192, 130, 25);
		getContentPane().add(lblFechaReg);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(396, 191, 130, 26);
		textFieldFecha.setEnabled(false);
		getContentPane().add(textFieldFecha);
		
		JButton btnLimpiarPantalla = new JButton("Limpiar");
		btnLimpiarPantalla.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnLimpiarPantalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNombre.setText("");
				textFieldDuracion.setText("");
				textFieldCosto.setText("");
				textFieldDescripcion.setText("");
				textFieldFecha.setText("");
			}
		});
		btnLimpiarPantalla.setBounds(406, 401, 120, 35);
		getContentPane().add(btnLimpiarPantalla);
		

	}
	
	public void cargarComboInstituciones() {
		DefaultComboBoxModel<String> modelinst = new DefaultComboBoxModel<String>(cAController.listarInstituciones());
		comboBoxInstitucion.setModel(modelinst);
		this.institucion =(String)comboBoxInstitucion.getSelectedItem();
	}
	/*
	public void cargarComboActividades(String nombreInstitucion) {
		DefaultComboBoxModel<String> modelactiv = new DefaultComboBoxModel<String>(cAController.listarActividades(nombreInstitucion));
		comboBoxActividades.setModel(modelactiv);
		this.actividad =(String)comboBoxActividades.getSelectedItem();
	}*/
	
	protected void cargaActividadesInstitucion(ActionEvent e) {
		if(comboBoxInstitucion.getSelectedIndex()!=0) {
			String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
			DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(cAController.listarActividades(institucion));
			comboBoxActividades.setModel(modelactividades);
			comboBoxActividades.setSelectedIndex(0);
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public void mostrarDatos(String nombreInstitucion, String nombreActividad) {
		DtActividadDeportiva DtAct = cAController.obtenerDatosActividad(nombreInstitucion ,nombreActividad);
		this.textFieldNombre.setText(DtAct.getNombre());
		this.textFieldDuracion.setText(String.valueOf(DtAct.getDuracion()));
		this.textFieldCosto.setText(String.valueOf(DtAct.getCosto()));
		this.textFieldDescripcion.setText(DtAct.getDescripcion());
		this.textFieldFecha.setText(DtAct.getFechaReg().toLocaleString());
	}
}
