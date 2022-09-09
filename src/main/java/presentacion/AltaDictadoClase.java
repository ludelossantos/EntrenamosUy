package presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.toedter.calendar.JDateChooser;

import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import excepciones.ClaseRepetidaException;
import excepciones.EsSocioException;
import excepciones.NoExisteUsuarioException;
import excepciones.ProfNoTrabajaInstitucion;
import interfaces.IControllerAltaActividadDep;
import interfaces.IControllerAltaDictadoClase;
import interfaces.IControllerInstitucionDeportiva;
import javax.swing.JTextField;

public class AltaDictadoClase extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControllerAltaDictadoClase altaDictadoClaseController;
	private IControllerInstitucionDeportiva instDepController;
	private JComboBox<String> comboBoxInstitucion;
	private JList<DtActividadDeportiva> listActividades;
	private JTextField textFieldNombre;
	private JDateChooser dateChooserFecha;
	private JSpinner spinnerHorario;
	private JTextField textFieldProfesor;
	private JTextField textFieldURL;
	private JTextField textFieldFechaAlta; 
	
	public AltaDictadoClase(IControllerAltaDictadoClase altaDictadoClaseController) {
		this.altaDictadoClaseController = altaDictadoClaseController;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Alta de Dictado de Clase");
		setBounds(100, 100, 700, 430);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Instituci\u00F3n");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblNewLabel.setBounds(51, 33, 99, 22);
		getContentPane().add(lblNewLabel);
		
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBoxInstitucion.setBounds(51, 68, 146, 22);
		DefaultComboBoxModel<String> inicializar = new DefaultComboBoxModel<String>(instDepController.obtenerInstituciones());
		comboBoxInstitucion.setModel(inicializar);
		getContentPane().add(comboBoxInstitucion);
		
		JLabel lblActividades = new JLabel("Actividades Deportivas");
		lblActividades.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblActividades.setBounds(247, 29, 196, 31);
		getContentPane().add(lblActividades);
		
		listActividades = new JList<DtActividadDeportiva>();
		listActividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listActividades.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		listActividades.setBounds(247, 68, 408, 79);
		listActividades.setModel(inicializarListaActividades());
		getContentPane().add(listActividades);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(176, 68, 21, 107);
		getContentPane().add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(634, 68, 21, 79);
		getContentPane().add(scrollBar_1);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNombre.setBounds(51, 200, 90, 21);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldNombre.setBounds(141, 200, 183, 21);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblFecha.setBounds(382, 200, 90, 21);
		getContentPane().add(lblFecha);
		
		dateChooserFecha = new JDateChooser();
		dateChooserFecha.getCalendarButton().setLocation(783, 0);
		dateChooserFecha.setBounds(472, 200, 183, 25);
		getContentPane().add(dateChooserFecha);
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblHorario.setBounds(51, 238, 90, 21);
		getContentPane().add(lblHorario);
		
		spinnerHorario = new JSpinner(new SpinnerDateModel());
		spinnerHorario.setBounds(141, 238, 183, 21);
		JSpinner.DateEditor editorHora = new JSpinner.DateEditor(spinnerHorario, "HH:mm");
		spinnerHorario.setEditor(editorHora);
		getContentPane().add(spinnerHorario);
		
		JLabel lblProfesor = new JLabel("Profesor");
		lblProfesor.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblProfesor.setBounds(382, 238, 90, 21);
		getContentPane().add(lblProfesor);
		
		textFieldProfesor = new JTextField();
		textFieldProfesor.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldProfesor.setBounds(472, 238, 183, 21);
		getContentPane().add(textFieldProfesor);
		textFieldProfesor.setColumns(10);
		
		JLabel lblURL = new JLabel("URL");
		lblURL.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblURL.setBounds(51, 277, 90, 21);
		getContentPane().add(lblURL);
		
		textFieldURL = new JTextField();
		textFieldURL.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldURL.setBounds(141, 277, 183, 21);
		getContentPane().add(textFieldURL);
		textFieldURL.setColumns(10);
		
		JLabel lblFechaAlta = new JLabel("Fecha Alta");
		lblFechaAlta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblFechaAlta.setBounds(382, 277, 90, 21);
		getContentPane().add(lblFechaAlta);
		
		textFieldFechaAlta = new JTextField();
		textFieldFechaAlta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldFechaAlta.setBounds(472, 277, 183, 21);
		Date fecha = new Date(); //fecha y hora actual
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //se formatea la fecha en una cadena
		textFieldFechaAlta.setText(sdf.format(fecha));
		textFieldFechaAlta.setEditable(false);
		getContentPane().add(textFieldFechaAlta);
		textFieldFechaAlta.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAceptar.setBounds(163, 345, 97, 25);
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//aceptarAltaClaseActionPerformed(e);
			}
		});
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCancelar.setBounds(423, 345, 97, 25);
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//cancelarAltaActividadActionPerformed(e);
			}
		});
		getContentPane().add(btnCancelar);
		
		
	}
	
	protected void aceptarAltaClaseActionPerformed(ActionEvent arg0) {
		if(checkFormulario()) {
			String nomInstitucion = this.comboBoxInstitucion.getSelectedItem().toString();
			DtActividadDeportiva actividad = this.listActividades.getSelectedValue();
			String nombre = this.textFieldNombre.getText();
			String profesor = this.textFieldProfesor.getText();
			String url = this.textFieldURL.getText();
			Date fecha = this.dateChooserFecha.getDate();
			Time hora = (Time) spinnerHorario.getValue();
			
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //parseo de string a date
			Date fechaAlta = null;
			try {
				fechaAlta = formato.parse(this.textFieldFechaAlta.getText());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			DtClase clase = new DtClase(nombre, fecha, hora, url, fechaAlta, actividad.getNombre(), profesor, nomInstitucion);
			
			try {
				this.altaDictadoClaseController.altaClase(clase);
				JOptionPane.showMessageDialog(this, "La clase se ha programado con éxito", "Alta Dictado Clase", JOptionPane.INFORMATION_MESSAGE);
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
	
	protected void cancelarAltaActividadActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
		setVisible(false);
	}
	
	public DefaultListModel<DtActividadDeportiva> inicializarListaActividades() {
		ArrayList<DtActividadDeportiva> actividades = altaDictadoClaseController.listarActividades(comboBoxInstitucion.getSelectedItem().toString());
		DefaultListModel<DtActividadDeportiva> inicializarAct = new DefaultListModel<DtActividadDeportiva>();
		for(DtActividadDeportiva dtad : actividades) {
			inicializarAct.addElement(dtad);
		}
		return inicializarAct;
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
		spinnerHorario.setValue(null);
		listActividades.removeAll();
	 }
	
}