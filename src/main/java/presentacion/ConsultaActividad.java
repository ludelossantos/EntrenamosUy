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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNickname = new JLabel("Institucion");
		lblNickname.setBounds(10, 11, 92, 16);
		lblNickname.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(lblNickname);
		
		JList<String> list = new JList<String>();
		list.setBounds(154, 57, 1, 1);
		list.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(list);
		
		JButton btnVerInfo = new JButton("Ver informacion");
		btnVerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDatos(institucion, actividad);
			}
		});
		btnVerInfo.setBounds(304, 37, 120, 29);
		getContentPane().add(btnVerInfo);
		
		comboBoxInstitucion = new JComboBox<String>();		
		comboBoxInstitucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxActividades.setEnabled(true);
			}
		});
		comboBoxInstitucion.setBounds(10, 38, 117, 27);
		getContentPane().add(comboBoxInstitucion);
		cargarComboInstituciones();
		//comboBoxInstitucion.addItem("x");
		//comboBoxInstitucion.setSelectedItem("x");
		 
		comboBoxActividades = new JComboBox<String>();
		cargarComboActividades(institucion);
		comboBoxActividades.setEnabled(false);
		comboBoxActividades.setBounds(154, 38, 117, 27);
		getContentPane().add(comboBoxActividades);
		//comboBoxActividades.addItem("x");
		//comboBoxActividades.setSelectedItem("x");
		
		JLabel lblActividades = new JLabel("Actividad");
		lblActividades.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblActividades.setBounds(154, 11, 92, 16);
		getContentPane().add(lblActividades);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 92, 61, 16);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(75, 87, 110, 26);
		textFieldNombre.setEnabled(false);
		//textFieldNombre.setSelectedTextColor(getBackground());
		getContentPane().add(textFieldNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 134, 61, 16);
		getContentPane().add(lblDescripcion);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setColumns(10);
		textFieldDuracion.setBounds(75, 196, 110, 26);
		textFieldDuracion.setEnabled(false);
		getContentPane().add(textFieldDuracion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setBounds(75, 132, 110, 53);
		textFieldDescripcion.setEnabled(false);
		getContentPane().add(textFieldDescripcion);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(10, 201, 61, 16);
		getContentPane().add(lblDuracion);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(259, 134, 61, 16);
		getContentPane().add(lblCosto);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setColumns(10);
		textFieldCosto.setBounds(294, 129, 130, 26);
		textFieldCosto.setEnabled(false);
		getContentPane().add(textFieldCosto);
		
		JLabel lblFechaReg = new JLabel("Fecha de registro");
		lblFechaReg.setBounds(203, 92, 92, 16);
		getContentPane().add(lblFechaReg);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(294, 87, 130, 26);
		textFieldFecha.setEnabled(false);
		getContentPane().add(textFieldFecha);
		
		JButton btnLimpiarPantalla = new JButton("Limpiar");
		btnLimpiarPantalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNombre.setText("");
				textFieldDuracion.setText("");
				textFieldCosto.setText("");
				textFieldDescripcion.setText("");
				textFieldFecha.setText("");
			}
		});
		btnLimpiarPantalla.setBounds(304, 198, 120, 29);
		getContentPane().add(btnLimpiarPantalla);
		

	}
	
	public void cargarComboInstituciones() {
		DefaultComboBoxModel<String> modelinst = new DefaultComboBoxModel<String>(cAController.listarInstituciones());
		comboBoxInstitucion.setModel(modelinst);
		this.institucion =(String)comboBoxInstitucion.getSelectedItem();
	}
	
	public void cargarComboActividades(String nombreInstitucion) {
		DefaultComboBoxModel<String> modelactiv = new DefaultComboBoxModel<String>(cAController.listarActividades(nombreInstitucion));
		comboBoxActividades.setModel(modelactiv);
		this.actividad =(String)comboBoxActividades.getSelectedItem();
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
