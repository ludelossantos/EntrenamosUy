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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import excepciones.RegistroClaseRepetidoException;
import interfaces.IControllerInstitucionDeportiva;
import interfaces.IControllerRegistroClase;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class RegistroClase extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControllerRegistroClase rCController;
	private JComboBox<String> comboBoxInstitucion;
	private JComboBox<String> comboBoxActDepor;
	private JComboBox<String> comboBoxSocio;
	private JList<String> listSetClases;
	private JTextField textFieldRegistro;
	

	public RegistroClase(IControllerRegistroClase rCController, IControllerInstitucionDeportiva instDepController) {
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
				
		JLabel lblInstitucion = new JLabel("Instituci\u00F3n");
		lblInstitucion.setBounds(22, 16, 108, 22);
		lblInstitucion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_clases.add(lblInstitucion);
		
		JLabel lblActivDeportiva = new JLabel("Actividad Deportiva");
		lblActivDeportiva.setBounds(22, 52, 150, 22);
		lblActivDeportiva.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_clases.add(lblActivDeportiva);
		
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBoxInstitucion.setBounds(170, 13, 665, 28);
		comboBoxInstitucion.setSelectedItem("Seleccione una insitucion");
		comboBoxInstitucion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargaActividadesInstitucion(e);	
			}
		});
		panel_clases.add(comboBoxInstitucion);
		
		comboBoxActDepor = new JComboBox<String>();
		comboBoxActDepor.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBoxActDepor.setBounds(170, 49, 665, 28);
		comboBoxActDepor.setSelectedItem("Seleccione una actividad deportiva");
		comboBoxActDepor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarClasesActividad(e);				
			}		
		});
		panel_clases.add(comboBoxActDepor);
		
		listSetClases = new JList<String>();
		listSetClases.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		listSetClases.setBounds(22, 94, 813, 245);
		listSetClases.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		panel_clases.add(listSetClases);
		
		JLabel lblSocio = new JLabel("Socio");
		lblSocio.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSocio.setBounds(22, 362, 39, 22);
		panel_clases.add(lblSocio);
		
		JLabel lblFechaReg = new JLabel("Fecha Registro");
		lblFechaReg.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblFechaReg.setBounds(519, 362, 114, 22);
		panel_clases.add(lblFechaReg);
		
		comboBoxSocio = new JComboBox<String>();
		comboBoxSocio.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBoxSocio.setBounds(71, 359, 436, 28);
		comboBoxSocio.setSelectedItem("Seleccione un socio");
		panel_clases.add(comboBoxSocio);
		
		textFieldRegistro = new JTextField();
		textFieldRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		Date fecha = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		textFieldRegistro.setText(sdf.format(fecha));
		textFieldRegistro.setEditable(false);
		textFieldRegistro.setColumns(10);
		textFieldRegistro.setBounds(643, 359, 192, 28);
		panel_clases.add(textFieldRegistro);
		
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
	
	public void inicializarComboBoxes(IControllerInstitucionDeportiva instDepController) {
		DefaultComboBoxModel<String> modelinsti = new DefaultComboBoxModel<String>(instDepController.obtenerInstituciones());
		comboBoxInstitucion.setModel(modelinsti);
		DefaultComboBoxModel<String> modelsocios = new DefaultComboBoxModel<String>(rCController.listarSocios());
		comboBoxSocio.setModel(modelsocios);
	}
	
	protected void cargaActividadesInstitucion(ActionEvent e) {
		String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(rCController.listarActividadesDeportivas(institucion));
		comboBoxActDepor.setModel(modelactividades);
	}
	
	protected void cargarClasesActividad(ActionEvent e) {
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
			
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //parseo de string a date
			Date fechaReg = new Date();
			try {
				fechaReg = formato.parse(this.textFieldRegistro.getText());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
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
		if(comboBoxInstitucion.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(this, "Seleccione la institución.", "Registro a dictado de Clase", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		String actividad = this.comboBoxActDepor.getSelectedItem().toString();
		if(listSetClases.getSelectedValue() != null) {
		    String datClase = this.listSetClases.getSelectedValue().toString();
	        String nombApe = this.comboBoxSocio.getSelectedItem().toString();
	        
	        if(actividad.isEmpty() || nombApe.isEmpty()){     
	            JOptionPane.showMessageDialog(this, "Complete todos los campos.", "Registro a dictado de Clase", JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
		}else {
		    JOptionPane.showMessageDialog(this, "Complete todos los campos.", "Registro a dictado de Clase", JOptionPane.ERROR_MESSAGE);
		    return false;
		}
		return true;
	}
	
	private void limpiarFormulario() {
		comboBoxInstitucion.setSelectedIndex(0);
		comboBoxActDepor.setSelectedIndex(0);
		comboBoxSocio.setSelectedIndex(0);
		listSetClases.clearSelection();
	}
}
