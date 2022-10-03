package presentacion;

import java.awt.Color;
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
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import excepciones.ExisteActividadDepException;
import excepciones.NoExistenInstitucionesException;
import interfaces.IControllerAltaActividadDep;
import interfaces.IControllerInstitucionDeportiva;

public class AltaActividadDeportiva extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IControllerAltaActividadDep altaActDepController;
	private JTextField textFieldNombre;
	private JTextArea textAreaDescripcion;
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
		setBounds(100, 100, 407, 416);
		getContentPane().setLayout(null);
		
		JLabel lblInstitucion = new JLabel("Instituci\u00F3n Deportiva");
		lblInstitucion.setBounds(39, 27, 144, 22);
		lblInstitucion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(lblInstitucion);
		
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxInstitucion.setBounds(188, 27, 166, 22);
		getContentPane().add(comboBoxInstitucion);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(39, 67, 124, 22);
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldNombre.setBounds(188, 67, 166, 22);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(39, 107, 124, 22);
		lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(lblDescripcion);

		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setWrapStyleWord(true);
		textAreaDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textAreaDescripcion.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		textAreaDescripcion.setLineWrap(true);
		textAreaDescripcion.setBounds(188, 107, 166, 81);
		getContentPane().add(textAreaDescripcion);
		
		JLabel lblDuracion = new JLabel("Duraci\u00F3n");
		lblDuracion.setBounds(39, 206, 124, 22);
		lblDuracion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(lblDuracion);

		textFieldDuracion = new JTextField();
		textFieldDuracion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldDuracion.setBounds(188, 206, 166, 22);
		getContentPane().add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(39, 246, 124, 22);
		lblCosto.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(lblCosto);

		textFieldCosto = new JTextField();
		textFieldCosto.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldCosto.setBounds(188, 246, 166, 22);
		getContentPane().add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JLabel lblFechaAlta = new JLabel("Fecha de Alta");
		lblFechaAlta.setBounds(39, 286, 124, 22);
		lblFechaAlta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(lblFechaAlta);
		
		textFieldFechaAlta = new JTextField();
		textFieldFechaAlta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldFechaAlta.setBounds(188, 286, 166, 22);
		Date fecha = new Date(); //fecha y hora actual
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //se formatea la fecha en una cadena
		textFieldFechaAlta.setText(sdf.format(fecha));
		textFieldFechaAlta.setEditable(false);
		getContentPane().add(textFieldFechaAlta);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(66, 338, 97, 25);
		btnAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aceptarAltaActividadActionPerformed(e);
			}
		});
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(225, 338, 97, 25);
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelarAltaActividadActionPerformed(e);
			}
		});
		getContentPane().add(btnCancelar);
		
	}
	
	public void inicializarComboBoxes(IControllerInstitucionDeportiva instDepController) {
		DefaultComboBoxModel<String> modelinsti = new DefaultComboBoxModel<String>(instDepController.obtenerInstituciones());
		comboBoxInstitucion.setModel(modelinsti);
	}
	
	protected void aceptarAltaActividadActionPerformed(ActionEvent arg0) {
		if(checkFormulario()) {
			String nombre = this.textFieldNombre.getText();
			String nomInstitucion = this.comboBoxInstitucion.getSelectedItem().toString();
			String descripcion = this.textAreaDescripcion.getText();
			Float duracion = Float.parseFloat(this.textFieldDuracion.getText()); //parseo de string a float
	
			DecimalFormatSymbols simbolos = new DecimalFormatSymbols(); //el siguiente bloque de codigo es para convertir de string a bigdecimal
			simbolos.setGroupingSeparator(',');
			simbolos.setDecimalSeparator('.');
			String pattern = "#,##0.0#";
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
				JOptionPane.showMessageDialog(this, "La actividad deportiva se ha creado con \u00E9xito", "Alta Actividad Deportiva", JOptionPane.INFORMATION_MESSAGE);
				System.out.println("crea actividad deportiva "+ nombre +" en la institucion "+ nomInstitucion +"");
				limpiarFormulario();
				setVisible(false);
			} catch(ExisteActividadDepException existe) {
				JOptionPane.showMessageDialog(this, existe.getMessage(), "Alta Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
			} catch(NoExistenInstitucionesException inst) {
				JOptionPane.showMessageDialog(this, inst.getMessage(), "Alta Actividad Deportiva", JOptionPane.ERROR_MESSAGE);
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
		String descripcion = this.textAreaDescripcion.getText();
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
		textAreaDescripcion.setText("");
		textFieldDuracion.setText("");
		textFieldCosto.setText("");
		comboBoxInstitucion.setSelectedItem("");
	 }
}