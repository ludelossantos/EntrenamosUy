package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import datatypes.DtClase;
import excepciones.ClaseRepetidaException;
import excepciones.EsSocioException;
import excepciones.NoExisteUsuarioException;
import excepciones.ProfNoTrabajaInstitucion;
import interfaces.IControllerAltaDictadoClase;
import interfaces.IControllerInstitucionDeportiva;

public class AltaDictadoClase extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControllerAltaDictadoClase altaDictadoClaseController;
	private JComboBox<String> comboBoxInstitucion;
	private JList<String> listActividades;
	private JTextField textFieldNombre;
	private JDateChooser dateChooserFecha;
	private JSpinner spinnerHorario;
	private JTextField textFieldProfesor;
	private JTextField textFieldURL;
	private JTextField textFieldFechaAlta;
	
	public AltaDictadoClase(IControllerInstitucionDeportiva instDepController, IControllerAltaDictadoClase altaDictadoClaseController) {
		this.altaDictadoClaseController = altaDictadoClaseController;		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Alta de Dictado de Clase");
		setBounds(100, 100, 700, 389);
		getContentPane().setLayout(null);
		
		JLabel lblInstitucion = new JLabel("Instituci\u00F3n");
		lblInstitucion.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblInstitucion.setBounds(49, 20, 99, 22);
		getContentPane().add(lblInstitucion);
		
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBoxInstitucion.setBounds(49, 55, 146, 22);
		DefaultComboBoxModel<String> inicializar = new DefaultComboBoxModel<String>(instDepController.obtenerInstituciones());
		comboBoxInstitucion.setModel(inicializar);
		comboBoxInstitucion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarActividades(e);				
			}		
		});
		getContentPane().add(comboBoxInstitucion);
		
		JLabel lblActividades = new JLabel("Actividades Deportivas");
		lblActividades.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblActividades.setBounds(245, 20, 196, 22);
		getContentPane().add(lblActividades);
		
		listActividades = new JList<String>();
		listActividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listActividades.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		listActividades.setBounds(0, -18, 408, 79);
		listActividades.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		getContentPane().add(listActividades);
		
		JScrollPane scrollPane = new JScrollPane(listActividades);
		scrollPane.setBounds(245, 55, 408, 79);
		getContentPane().add(scrollPane);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNombre.setBounds(49, 162, 90, 21);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldNombre.setBounds(139, 162, 183, 21);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblFecha.setBounds(380, 162, 90, 21);
		getContentPane().add(lblFecha);
		
		dateChooserFecha = new JDateChooser();
		dateChooserFecha.getCalendarButton().setLocation(783, 0);
		dateChooserFecha.setBounds(470, 162, 183, 25);
		getContentPane().add(dateChooserFecha);
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblHorario.setBounds(49, 200, 90, 21);
		getContentPane().add(lblHorario);
		
		spinnerHorario = new JSpinner(new SpinnerDateModel());
		spinnerHorario.setBounds(139, 200, 183, 21);
		JSpinner.DateEditor editorHora = new JSpinner.DateEditor(spinnerHorario, "HH:mm");
		spinnerHorario.setEditor(editorHora);
		getContentPane().add(spinnerHorario);
		
		JLabel lblProfesor = new JLabel("Profesor");
		lblProfesor.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblProfesor.setBounds(380, 200, 90, 21);
		getContentPane().add(lblProfesor);
		
		textFieldProfesor = new JTextField();
		textFieldProfesor.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldProfesor.setBounds(470, 200, 183, 21);
		getContentPane().add(textFieldProfesor);
		textFieldProfesor.setColumns(10);
		
		JLabel lblURL = new JLabel("URL");
		lblURL.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblURL.setBounds(49, 239, 90, 21);
		getContentPane().add(lblURL);
		
		textFieldURL = new JTextField();
		textFieldURL.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldURL.setBounds(139, 239, 183, 21);
		getContentPane().add(textFieldURL);
		textFieldURL.setColumns(10);
		
		JLabel lblFechaAlta = new JLabel("Fecha Alta");
		lblFechaAlta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblFechaAlta.setBounds(380, 239, 90, 21);
		getContentPane().add(lblFechaAlta);
		
		textFieldFechaAlta = new JTextField();
		textFieldFechaAlta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldFechaAlta.setBounds(470, 239, 183, 21);
		Date fecha = new Date(); //fecha y hora actual
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //se formatea la fecha en una cadena
		textFieldFechaAlta.setText(sdf.format(fecha));
		textFieldFechaAlta.setEditable(false);
		getContentPane().add(textFieldFechaAlta);
		textFieldFechaAlta.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAceptar.setBounds(161, 307, 97, 25);
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aceptarAltaClaseActionPerformed(e);
			}
		});
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCancelar.setBounds(421, 307, 97, 25);
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelarAltaClaseActionPerformed(e);
			}
		});
		getContentPane().add(btnCancelar);
	}
	

	protected void aceptarAltaClaseActionPerformed(ActionEvent arg0) {
		if(checkFormulario()) {
			String nomInstitucion = this.comboBoxInstitucion.getSelectedItem().toString();
			String actividad = this.listActividades.getSelectedValue();
			String nombre = this.textFieldNombre.getText();
			String profesor = this.textFieldProfesor.getText();
			String url = this.textFieldURL.getText();
			Date fecha = this.dateChooserFecha.getDate();
			
			Calendar c  = Calendar.getInstance();
			Date hora = (Date) spinnerHorario.getValue();
			c.setTime(hora);
			
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //parseo de string a date
			Date fechaAlta = null;
			try {
				fechaAlta = formato.parse(this.textFieldFechaAlta.getText());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			DtClase clase = new DtClase(nombre, fecha, c.getTime(), url, fechaAlta, actividad, profesor, nomInstitucion);
			
			try {
				this.altaDictadoClaseController.altaClase(clase);
				JOptionPane.showMessageDialog(this, "La clase se ha programado con \u00E9xito", "Alta Dictado Clase", JOptionPane.INFORMATION_MESSAGE);
				System.out.println("crea clase "+ clase.getNombre() +"de la actividad deportiva "+ clase.getActividad() +" en la institucion "+ clase.getNomInstitucion() +"");
				limpiarFormulario();
				setVisible(false);
			} catch(ClaseRepetidaException cr) {
				JOptionPane.showMessageDialog(this, cr.getMessage(), "Alta Actividad Deportiva", JOptionPane.INFORMATION_MESSAGE);
			} catch(NoExisteUsuarioException neu) {
				JOptionPane.showMessageDialog(this, neu.getMessage(), "Alta Actividad Deportiva", JOptionPane.INFORMATION_MESSAGE);
			} catch(EsSocioException es) {
				JOptionPane.showMessageDialog(this, es.getMessage(), "Alta Actividad Deportiva", JOptionPane.INFORMATION_MESSAGE);
			} catch(ProfNoTrabajaInstitucion pnti) {
				JOptionPane.showMessageDialog(this, pnti.getMessage(), "Alta Actividad Deportiva", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	protected void cancelarAltaClaseActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
		setVisible(false);
	}
	
	protected void cargarActividades(ActionEvent e) {
		if(comboBoxInstitucion.getSelectedItem() != null) {
			String institucion = this.comboBoxInstitucion.getSelectedItem().toString();
			DefaultComboBoxModel<String> modelActividades = new DefaultComboBoxModel<>(altaDictadoClaseController.listarActividades(institucion));
			listActividades.setModel(modelActividades);
			listActividades.setSelectedIndex(0);
		}
	}
	
	private boolean checkFormulario() {
		String nomInstitucion = this.comboBoxInstitucion.getSelectedItem().toString();
		String actividad = this.listActividades.getSelectedValue().toString();
		String nombre = this.textFieldNombre.getText();
		String profesor = this.textFieldProfesor.getText();
		String url = this.textFieldURL.getText();
		Date fecha = this.dateChooserFecha.getDate();
		Date hora = (Date) this.spinnerHorario.getValue();
		
		if(nomInstitucion.isEmpty() || actividad.isEmpty() || nombre.isEmpty() || profesor.isEmpty() || url.isEmpty() || fecha == null || hora == null){
			JOptionPane.showMessageDialog(this, "Complete los campos en blanco", "Alta de Dictado de Clase", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void limpiarFormulario(){
		textFieldNombre.setText("");
		textFieldProfesor.setText("");
		textFieldURL.setText("");
		textFieldFechaAlta.setText("");
		comboBoxInstitucion.setSelectedItem("");
		dateChooserFecha.setDate(null);
		spinnerHorario.setValue(new Date());
		listActividades.removeAll();
	 }
	
	public void inicializarComboBoxes(IControllerInstitucionDeportiva instDepController) {
		DefaultComboBoxModel<String> modelinsti = new DefaultComboBoxModel<String>(instDepController.obtenerInstituciones());
		comboBoxInstitucion.setModel(modelinsti);
		//comboBoxInstitucion.setSelectedIndex(0); esto tira error en todos lados
	}
}