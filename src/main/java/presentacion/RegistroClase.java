package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.toedter.calendar.JDateChooser;
import excepciones.RegistroClaseRepetidoException;
import interfaces.IControllerRegistroClase;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class RegistroClase extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControllerRegistroClase rCController;
	private JComboBox<String> comboBoxInstitucion;
	private JComboBox<String> comboBoxActDepor;
	private JComboBox<String> comboBoxSocio;
	private JList<String> listSetClases;
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
		panel_clases.setBounds(33, 40, 854, 407);
		getContentPane().add(panel_clases);
		panel_clases.setLayout(null);
				
		JLabel lblInstitucion = new JLabel("Institución");
		lblInstitucion.setBounds(22, 16, 73, 22);
		lblInstitucion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_clases.add(lblInstitucion);
		
		JLabel lblActivDeportiva = new JLabel("Actividad deportiva");
		lblActivDeportiva.setBounds(22, 52, 138, 22);
		lblActivDeportiva.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_clases.add(lblActivDeportiva);
		
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBoxInstitucion.setBounds(170, 17, 665, 25);
		comboBoxInstitucion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargaActividadesInstitucion(e);	
			}
		});
		panel_clases.add(comboBoxInstitucion);
		
		comboBoxActDepor = new JComboBox<String>();
		comboBoxActDepor.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBoxActDepor.setBounds(170, 53, 665, 25);
		comboBoxActDepor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarClasesActividad(e);				
			}		
		});
		panel_clases.add(comboBoxActDepor);
		
		listSetClases = new JList<String>();
		listSetClases.setBounds(22, 94, 813, 245);
		listSetClases.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		panel_clases.add(listSetClases);
		
		JLabel lblSocio = new JLabel("Socio");
		lblSocio.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSocio.setBounds(22, 362, 39, 22);
		panel_clases.add(lblSocio);
		
		JLabel lblFechaReg = new JLabel("Fecha registro");
		lblFechaReg.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblFechaReg.setBounds(524, 362, 98, 22);
		panel_clases.add(lblFechaReg);
		
		comboBoxSocio = new JComboBox<String>();
		comboBoxSocio.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBoxSocio.setBounds(71, 359, 436, 25);
		panel_clases.add(comboBoxSocio);
		
		dateChooserFechaReg = new JDateChooser();
		dateChooserFechaReg.setBounds(632, 359, 203, 25);
		panel_clases.add(dateChooserFechaReg);
	
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registroClaseCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(617, 457, 130, 35);
		getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				registroClaseAceptarActionPerformed(arg0);
			}
		});
		btnAceptar.setBounds(757, 457, 130, 35);
		getContentPane().add(btnAceptar);

	}
	
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelinsti = new DefaultComboBoxModel<String>(rCController.listarInstituciones());
		comboBoxInstitucion.setModel(modelinsti);
		comboBoxInstitucion.setSelectedIndex(0);
		DefaultComboBoxModel<String> modelsocios = new DefaultComboBoxModel<String>(rCController.listarSocios());
		comboBoxSocio.setModel(modelsocios);
		comboBoxSocio.setSelectedIndex(0);
	}
	
	protected void cargaActividadesInstitucion(ActionEvent e) {
		if(comboBoxInstitucion.getSelectedIndex()!=0) {
			String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
			DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(rCController.listarActividadesDeportivas(institucion));
			comboBoxActDepor.setModel(modelactividades);
			comboBoxActDepor.setSelectedIndex(0);
		}
	}
	
	protected void cargarClasesActividad(ActionEvent e) {
		if(comboBoxActDepor.getSelectedIndex()!=0) {
			String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
			String actividad = this.comboBoxActDepor.getSelectedItem().toString();
			DefaultComboBoxModel<String> modelclases = new DefaultComboBoxModel<String>(rCController.listarClasesActividad(institucion, actividad));
			listSetClases.setModel(modelclases);
			listSetClases.setSelectedIndex(0);
		}		
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
		Date date = new Date();
		dateChooserFechaReg.setDate(date);
	}
}
