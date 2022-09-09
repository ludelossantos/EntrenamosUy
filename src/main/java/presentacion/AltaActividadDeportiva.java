package presentacion;

//import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.BigDecimal;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import excepciones.ExisteActividadDepException;
import excepciones.NoExistenInstitucionesException;
import interfaces.IControllerAltaActividadDep;
import interfaces.IControllerInstitucionDeportiva;

public class AltaActividadDeportiva extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControllerAltaActividadDep altaActDepController;
	private IControllerInstitucionDeportiva instDepController;
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldDuracion;
	private JTextField textFieldCosto;
	private JTextField textFieldFechaAlta;
	private JComboBox<String> comboBoxInstitucion;

	public AltaActividadDeportiva(IControllerAltaActividadDep altaActDepController) {
		this.altaActDepController = altaActDepController;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta Actividad Deportiva");
		setBounds(100, 100, 407, 361);
		getContentPane().setLayout(null);
		
		JLabel lblInstitucion = new JLabel("Instituci\u00F3n Deportiva");
		lblInstitucion.setBounds(39, 18, 124, 22);
		getContentPane().add(lblInstitucion);
		
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setBounds(175, 18, 166, 22);
		DefaultComboBoxModel<String> inicializar = new DefaultComboBoxModel<String>(instDepController.obtenerInstituciones());
		comboBoxInstitucion.setModel(inicializar);
		getContentPane().add(comboBoxInstitucion);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(39, 58, 124, 22);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(175, 58, 166, 22);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(39, 98, 124, 22);
		getContentPane().add(lblDescripcion);

		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(175, 98, 166, 22);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Duraci\u00F3n");
		lblDuracion.setBounds(39, 138, 124, 22);
		getContentPane().add(lblDuracion);

		textFieldDuracion = new JTextField();
		textFieldDuracion.setBounds(175, 138, 166, 22);
		getContentPane().add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(39, 178, 124, 22);
		getContentPane().add(lblCosto);

		textFieldCosto = new JTextField();
		textFieldCosto.setBounds(175, 178, 166, 22);
		getContentPane().add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JLabel lblFechaAlta = new JLabel("Fecha de Alta");
		lblFechaAlta.setBounds(39, 218, 124, 22);
		getContentPane().add(lblFechaAlta);
		
		textFieldFechaAlta = new JTextField();
		textFieldFechaAlta.setBounds(175, 218, 166, 22);
		Date fecha = new Date(); //fecha y hora actual
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //se formatea la fecha en una cadena
		textFieldFechaAlta.setText(sdf.format(fecha));
		textFieldFechaAlta.setEditable(false);
		getContentPane().add(textFieldFechaAlta);
		
		JButton btnAceptar = new JButton("Aceptar");2
		btnAceptar.setBounds(66, 270, 97, 25);
		btnAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aceptarAltaActividadActionPerformed(e);
			}
		});
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(225, 270, 97, 25);
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelarAltaActividadActionPerformed(e);
			}
		});
		getContentPane().add(btnCancelar);
		
	}
	
	protected void aceptarAltaActividadActionPerformed(ActionEvent arg0) {
		if(checkFormulario()) {
			String nombre = this.textFieldNombre.getText();
			String nomInstitucion = this.comboBoxInstitucion.getSelectedItem().toString();
			String descripcion = this.textFieldDescripcion.getText();
			Float duracion = Float.parseFloat(this.textFieldDuracion.getText()); //parseo de string a float
	
			DecimalFormatSymbols simbolos = new DecimalFormatSymbols(); //el siguiente bloque de codigo es para convertir de string a bigdecimal
			simbolos.setGroupingSeparator('.');
			simbolos.setDecimalSeparator('.');
			String pattern = "#.##0,0#";
			DecimalFormat df = new DecimalFormat(pattern, simbolos);
			df.setParseBigDecimal(true);
			BigDecimal costo = new BigDecimal("0.0");
			try {
				costo = (BigDecimal) df.parse(this.textFieldCosto.getText());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //parseo de string a date
			Date fechaAlta = null;
			try {
				fechaAlta = formato.parse(this.textFieldFechaAlta.getText());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			try {
				this.altaActDepController.altaActividadDep(nombre, nomInstitucion, descripcion, duracion, costo, fechaAlta);
				JOptionPane.showMessageDialog(this, "La actividad deportiva se ha creado con éxito", "Alta Actividad Deportiva", JOptionPane.INFORMATION_MESSAGE);
				limpiarFormulario();
				setVisible(false);
			} catch(ExisteActividadDepException existe) {
				JOptionPane.showMessageDialog(this, existe.getMessage(), "Alta Actividad Deportiva", JOptionPane.INFORMATION_MESSAGE);
			} catch(NoExistenInstitucionesException inst) {
				JOptionPane.showMessageDialog(this, inst.getMessage(), "Alta Actividad Deportiva", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	protected void cancelarAltaActividadActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
		setVisible(false);
	}
	
	private boolean checkFormulario() {
		String nombre = this.textFieldNombre.getText();
		String nomInstitucion = this.comboBoxInstitucion.getSelectedItem().toString();
		String descripcion = this.textFieldDescripcion.getText();
		Float duracion = Float.parseFloat(this.textFieldDuracion.getText());
		String costo = this.textFieldCosto.getText();
		if(nombre.isEmpty() || nomInstitucion.isEmpty() || descripcion.isEmpty() || duracion == null || costo.isEmpty()){
			JOptionPane.showMessageDialog(this, "Complete los campos en blanco", "Alta Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void limpiarFormulario(){
		textFieldNombre.setText("");
		textFieldDescripcion.setText("");
		textFieldDuracion.setText("");
		textFieldCosto.setText("");
		comboBoxInstitucion.setSelectedItem("");
	 }
}
