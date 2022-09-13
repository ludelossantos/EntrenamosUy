package presentacion;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import datatypes.DtActividadDeportiva;
import interfaces.IControllerConsultaActividad;
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
	private JTextArea textArea;
	private String institucion;
	private String actividad;

	public JComboBox<String> getComboBoxInstitucion() {
		return comboBoxInstitucion;
	}

	public void setComboBoxInstitucion(JComboBox<String> comboBoxInstitucion) {
		this.comboBoxInstitucion = comboBoxInstitucion;
	}

	public JComboBox<String> getComboBoxActividades() {
		return comboBoxActividades;
	}

	public void setComboBoxActividades(JComboBox<String> comboBoxActividades) {
		this.comboBoxActividades = comboBoxActividades;
	}

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
		setBounds(100, 100, 579, 616);
		getContentPane().setLayout(null);
		
		JLabel lblNickname = new JLabel("Institución");
		lblNickname.setBounds(31, 37, 92, 16);
		lblNickname.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(lblNickname);
		
		JList<String> list = new JList<String>();
		list.setBounds(154, 57, 1, 1);
		list.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(list);
		
		JButton btnVerInfo = new JButton("Ver información");
		btnVerInfo.setBounds(396, 108, 130, 35);
		btnVerInfo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnVerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mostrarDatos(institucion, actividad);
				//mostrarDatos2();
			}
		});
		getContentPane().add(btnVerInfo);
		
		comboBoxInstitucion = new JComboBox<String>();		
		comboBoxInstitucion.setBounds(133, 33, 393, 25);
		comboBoxInstitucion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		/*
		comboBoxInstitucion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargaActividadesInstitucion(e);	
			}
		});
		comboBoxInstitucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxActividades.setEnabled(true);
			}
		});*/
		comboBoxInstitucion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarActividades(e);				
			}		
		});
		getContentPane().add(comboBoxInstitucion);
		cargarComboInstituciones();

		 
		comboBoxActividades = new JComboBox<String>();
		comboBoxActividades.setBounds(133, 72, 393, 25);
		comboBoxActividades.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		//cargarComboActividades(institucion);
		comboBoxActividades.setEnabled(false);
		getContentPane().add(comboBoxActividades);

		
		JLabel lblActividades = new JLabel("Actividad");
		lblActividades.setBounds(42, 73, 92, 16);
		lblActividades.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(lblActividades);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(42, 154, 61, 25);
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setBounds(132, 153, 393, 25);
		textFieldNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldNombre.setColumns(10);
		getContentPane().add(textFieldNombre);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setEditable(false);
		textFieldDuracion.setBounds(133, 418, 253, 25);
		textFieldDuracion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldDuracion.setColumns(10);
		getContentPane().add(textFieldDuracion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setEditable(false);
		textFieldDescripcion.setBounds(133, 200, 253, 130);
		textFieldDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldDescripcion.setColumns(10);
		getContentPane().add(textFieldDescripcion);
		
		JLabel lblDuracion = new JLabel("Duración");
		lblDuracion.setBounds(45, 419, 78, 25);
		lblDuracion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(lblDuracion);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(73, 365, 47, 25);
		lblCosto.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(lblCosto);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setEditable(false);
		textFieldCosto.setBounds(133, 364, 253, 26);
		textFieldCosto.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldCosto.setColumns(10);
		getContentPane().add(textFieldCosto);
		
		JLabel lblFechaReg = new JLabel("Registrado");
		lblFechaReg.setBounds(31, 470, 84, 25);
		lblFechaReg.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(lblFechaReg);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setEditable(false);
		textFieldFecha.setBounds(133, 469, 253, 26);
		textFieldFecha.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldFecha.setColumns(10);
		getContentPane().add(textFieldFecha);
		
		JButton btnLimpiarPantalla = new JButton("Limpiar");
		btnLimpiarPantalla.setBounds(396, 526, 130, 35);
		btnLimpiarPantalla.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnLimpiarPantalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNombre.setText("");
				textFieldDuracion.setText("");
				textFieldCosto.setText("");
				textFieldDescripcion.setText("");
				textFieldFecha.setText("");
				textArea.setText("");
			}
		});
		getContentPane().add(btnLimpiarPantalla);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(396, 200, 130, 295);
		getContentPane().add(scrollPane);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		scrollPane.setViewportView(textArea_1);
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setWrapStyleWord(true);
		this.textArea = textArea_1;
		
		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setBounds(25, 201, 128, 128);
		getContentPane().add(lblDescripcion);
		lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
	}
	
	public void cargarComboInstituciones() {
		DefaultComboBoxModel<String> modelinst = new DefaultComboBoxModel<String>(cAController.listarInstituciones());
		comboBoxInstitucion.setModel(modelinst);
		this.institucion =(String)comboBoxInstitucion.getSelectedItem();
	}
	
	protected void cargarActividades(ActionEvent e) {
		if(comboBoxInstitucion.getSelectedItem() != null) {
			String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
			DefaultComboBoxModel<String> modelActividades = new DefaultComboBoxModel<>(cAController.listarActividades(institucion));
			comboBoxActividades.setModel(modelActividades);
			comboBoxActividades.setEnabled(true);
			//comboBoxActividades.setSelectedIndex(0);
		}
	}
	/*
	public void cargarComboActividades(String nombreInstitucion) {
		DefaultComboBoxModel<String> modelactiv = new DefaultComboBoxModel<String>(cAController.listarActividades(nombreInstitucion));
		comboBoxActividades.setModel(modelactiv);
		this.actividad =(String)comboBoxActividades.getSelectedItem();
	}
	
	protected void cargaActividadesInstitucion(ActionEvent e) {
		if(comboBoxInstitucion.getSelectedIndex()!=0) {
			String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
			DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(cAController.listarActividades(institucion));
			comboBoxActividades.setModel(modelactividades);
			comboBoxActividades.setSelectedIndex(0);
		}
	}
	*/
	protected void mostrarDatos2() {
		String nombreInstitucion = this.comboBoxInstitucion.getSelectedItem().toString();
		String nombreActividad = this.comboBoxInstitucion.getSelectedItem().toString();
		mostrarDatos(nombreInstitucion,nombreActividad);
	}
	
	//@SuppressWarnings("deprecation")
	public void mostrarDatos(String nombreInstitucion, String nombreActividad) {
		DtActividadDeportiva DtAct = cAController.obtenerDatosActividad(nombreInstitucion ,nombreActividad);
		setVisible(true);
		this.textFieldNombre.setText(DtAct.getNombre());
		this.textFieldDuracion.setText(String.valueOf(DtAct.getDuracion()));
		this.textFieldCosto.setText(String.valueOf(DtAct.getCosto()));
		this.textFieldDescripcion.setText(DtAct.getDescripcion());
		this.textFieldFecha.setText(DtAct.getFechaReg().toLocaleString());
		this.textArea.setText(DtAct.getClasesAsociadas());
	}
}