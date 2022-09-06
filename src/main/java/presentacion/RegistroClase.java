package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Map;
import java.util.Pair;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.toedter.calendar.JDateChooser;

import datatypes.DtClase;
import datatypes.DtSocio;
import excepciones.RegistroClaseRepetidoException;
import interfaces.IControllerAltaUsuario;
import interfaces.IControllerInstitucionDeportiva;
import interfaces.IControllerRegistroClase;
import logica.InstitucionDeportiva;
import logica.Socio;
import logica.Usuario;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class RegistroClase extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControllerRegistroClase rCController;
	private IControllerInstitucionDeportiva iDController;
	private IControllerAltaUsuario aUController;
	private JComboBox<String> comboBoxInstitucion;
	private JComboBox<String> comboBoxActDepor;
	private JComboBox<String> comboBoxSocio;
	private JList<String> listSetClases;
	private JTextArea textAreaClase;
	private JDateChooser dateChooserFechaReg;
	

	public RegistroClase(IControllerRegistroClase rCController) {
		this.rCController = rCController;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Registro a dictado de Clase");
		setBounds(100, 100, 944, 563);
		getContentPane().setLayout(null);
		
		JPanel panel_clases = new JPanel();
		panel_clases.setBounds(33, 40, 505, 441);
		getContentPane().add(panel_clases);
			
		JPanel panel_registro = new JPanel();
		panel_registro.setBounds(548, 40, 351, 142);
		getContentPane().add(panel_registro);
		panel_clases.setLayout(null);
				
		JLabel lblInstitucion = new JLabel("Institución");
		lblInstitucion.setBounds(22, 16, 73, 22);
		lblInstitucion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_clases.add(lblInstitucion);
		
		JLabel lblActivDeportiva = new JLabel("Actividad deportiva");
		lblActivDeportiva.setBounds(22, 52, 138, 22);
		lblActivDeportiva.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_clases.add(lblActivDeportiva);
		panel_registro.setLayout(null);
		
		JLabel lblClase = new JLabel("Clase");
		lblClase.setBounds(19, 16, 36, 22);
		lblClase.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_registro.add(lblClase);
		
		JLabel lblSocio = new JLabel("Socio");
		lblSocio.setBounds(19, 52, 39, 22);
		lblSocio.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_registro.add(lblSocio);
		
		JLabel lblFechaReg = new JLabel("Fecha registro");
		lblFechaReg.setBounds(19, 92, 98, 22);
		lblFechaReg.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_registro.add(lblFechaReg);

		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setBounds(105, 17, 373, 21);
		comboBoxInstitucion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargaActividadesInstitucion(e);	
			}
		});
		panel_clases.add(comboBoxInstitucion);
		
		comboBoxActDepor = new JComboBox<String>();
		comboBoxActDepor.setBounds(170, 53, 308, 21);
		comboBoxActDepor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarClasesActividad(e);				
			}		
		});
		panel_clases.add(comboBoxActDepor);
		
		listSetClases = new JList<String>();
		listSetClases.setBounds(22, 94, 456, 316);
		panel_clases.add(listSetClases);
		
		textAreaClase = new JTextArea();
		textAreaClase.setBounds(71, 16, 259, 22);
		panel_registro.add(textAreaClase);
		
		comboBoxSocio = new JComboBox<String>();
		comboBoxSocio.setBounds(68, 53, 262, 21);
		panel_registro.add(comboBoxSocio);
		
		dateChooserFechaReg = new JDateChooser();
		dateChooserFechaReg.setBounds(127, 92, 203, 25);
		panel_registro.add(dateChooserFechaReg);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registroClaseCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(617, 446, 130, 35);
		getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				registroClaseAceptarActionPerformed(arg0);
			}
		});
		btnAceptar.setBounds(757, 446, 130, 35);
		getContentPane().add(btnAceptar);

	}
	
	public void inicializarBoxes() {
		DefaultComboBoxModel<String> modelinsti = new DefaultComboBoxModel<String>(rCController.listarInstituciones());
		comboBoxInstitucion.setModel(modelinsti);
		DefaultComboBoxModel<String> modelsocios = new DefaultComboBoxModel<String>(rCController.listarSocios());
		comboBoxSocio.setModel(modelsocios);
	}
	
	private void cargaActividadesInstitucion(ActionEvent e) {
		String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(rCController.listarActividadesDeportivas(institucion));
		comboBoxActDepor.setModel(modelactividades);			
	}
	
	private void cargarClasesActividad(ActionEvent e) {
		String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
		String actividad = this.comboBoxActDepor.getSelectedItem().toString();
		DefaultComboBoxModel<String> modelclases = new DefaultComboBoxModel<String>(rCController.listarClasesActividad(institucion, actividad));
		listSetClases.setModel(modelclases);		
	}	
	
	protected void registroClaseCancelarActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
		setVisible(false);
	}
	
	protected void registroClaseAceptarActionPerformed(ActionEvent arg0) {
		if(checkFormulario()) {
			String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
			String actividad = this.comboBoxActDepor.getSelectedItem().toString();
			String datClase = this.listSetClases.getSelectedValue().toString();
			String nombApe = this.comboBoxSocio.getSelectedItem().toString();
			java.util.Date fechaReg = this.dateChooserFechaReg.getDate();
									
			try{
				this.rCController.registroClase(institucion, actividad, datClase, nombApe, fechaReg);
				JOptionPane.showMessageDialog(this, "Registro a clase exitoso", "Registro a dictado de Clase", JOptionPane.INFORMATION_MESSAGE);
				limpiarFormulario();
		           setVisible(false);
			}catch(RegistroClaseRepetidoException rr){
				JOptionPane.showMessageDialog(this, rr.getMessage(), "Registro a dictado de Clase", JOptionPane.ERROR_MESSAGE);	
			}	
		}
	}
	
	private boolean checkFormulario() {
		return true;//completar 
	}
	
	private void limpiarFormulario() {
		comboBoxInstitucion.setSelectedItem("Seleccione");
		comboBoxActDepor.setSelectedItem("Seleccione");
		comboBoxSocio.setSelectedItem("Seleccione");
		textAreaClase.setText("");
		Date date = new Date();
		dateChooserFechaReg.setDate(date);
	}
}
