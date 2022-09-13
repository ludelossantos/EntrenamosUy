package presentacion;

import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.text.SimpleDateFormat;

import interfaces.IControllerConsultaUsuario;

import javax.swing.JTextField;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import presentacion.ConsultaActividad;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;

public class ConsultaUsuario extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IControllerConsultaUsuario cUController;
	private JComboBox<String> comboBoxUser;
	private JComboBox <String> comboBoxClases;
	private JComboBox<String> comboBoxActiv;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldFechaNac;
	private JTextField textFieldSitioWeb;
	private JTextField textFieldBibliog;
	private JTextField textFieldDescrip;
	private JComponent lblBibliografia;
	private JComponent lblDescripcion;
	private JComponent lblSitioWeb;
	private JButton btnVerInfoClases;
	private JButton btnVerInfoActiv;
	private JLabel lblSinClases;
	private JLabel lblSinActividades;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat horaformatter = new SimpleDateFormat("h:mm a");
	private JLabel lblNombreClase;
	private JLabel lblNombreClase_1;
	private JLabel lblFechaClase;
	private JLabel lblHoraClase;
	private JLabel lblFechaRegistroClase;
	private JTextField textFieldNomClase;
	private JTextField textFechaClase;
	private JTextField textHoraClase;
	private JTextField textFieldRegistroClase;
	private JLabel lblCostoActiv;
	private JLabel lblDuracion;
	private JLabel lblRegistroActiv;
	private JTextField textFieldNomActiv;
	private JTextField textFieldCostoActiv;
	private JTextField textFieldDuracionActiv;
	private JTextField textFieldRegistroActiv;
	private JLabel lblUrlClase;
	private JTextField textFieldURLClase;
	private JLabel lblDescripActiv;
	private JTextField textFieldDescripActiv;
	private ConsultaActividad consultaActividad;
	//private ConsultaActividad consultaActividadInternalFrame;
	/**
	 * Create the frame.
	 */
	public ConsultaUsuario(IControllerConsultaUsuario cUController) {
		this.cUController = cUController;
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		
		setTitle("Consulta de Usuario");
		setBounds(400, 500, 934, 775);
		getContentPane().setLayout(null);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(53, 40, 92, 16);
		lblNickname.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(lblNickname);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir(e);
			}
		});
		btnSalir.setBounds(758, 687, 117, 35);
		btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(btnSalir);
		
		JButton btnVerInfo = new JButton("Ver informacion");
		btnVerInfo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnVerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verInfo(e);
			}
		});
		btnVerInfo.setBounds(657, 31, 218, 35);
		getContentPane().add(btnVerInfo);
		
		comboBoxUser = new JComboBox<String>();
		comboBoxUser.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBoxUser.setBounds(138, 36, 502, 25);
		getContentPane().add(comboBoxUser);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNombre.setBounds(52, 120, 61, 25);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblApellido.setBounds(459, 120, 61, 25);
		getContentPane().add(lblApellido);
		
		JLabel lblMail = new JLabel("E-mail");
		lblMail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblMail.setBounds(53, 161, 61, 25);
		getContentPane().add(lblMail);
		
		JLabel lblFechaNac = new JLabel("Fecha de nacimiento");
		lblFechaNac.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblFechaNac.setBounds(551, 161, 151, 25);
		getContentPane().add(lblFechaNac);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldNombre.setBounds(123, 120, 316, 25);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(530, 119, 345, 26);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(124, 160, 407, 26);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setBounds(702, 160, 174, 26);
		getContentPane().add(textFieldFechaNac);
		textFieldFechaNac.setColumns(10);
		
		lblSitioWeb = new JLabel("Sitio web");
		lblSitioWeb.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSitioWeb.setBounds(53, 289, 103, 25);
		getContentPane().add(lblSitioWeb);
		
		textFieldSitioWeb = new JTextField();
		textFieldSitioWeb.setBounds(138, 288, 738, 26);
		getContentPane().add(textFieldSitioWeb);
		textFieldSitioWeb.setColumns(10);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblDescripcion.setBounds(53, 196, 126, 25);
		getContentPane().add(lblDescripcion);
		
		textFieldBibliog = new JTextField();
		textFieldBibliog.setBounds(461, 222, 416, 53);
		getContentPane().add(textFieldBibliog);
		textFieldBibliog.setColumns(10);
		
		textFieldDescrip = new JTextField();
		textFieldDescrip.setColumns(10);
		textFieldDescrip.setBounds(53, 222, 388, 53);
		getContentPane().add(textFieldDescrip);
		
		lblBibliografia = new JLabel("Bibliografia");
		lblBibliografia.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblBibliografia.setBounds(461, 196, 81, 25);
		getContentPane().add(lblBibliografia);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(124, 342, 752, 12);
		getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("Datos Personales");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(53, 76, 164, 23);
		getContentPane().add(lblNewLabel);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(219, 87, 657, 12);
		getContentPane().add(separator_2);
		
		JLabel lblClases = new JLabel("Clases");
		lblClases.setForeground(Color.DARK_GRAY);
		lblClases.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		lblClases.setBounds(52, 331, 55, 23);
		getContentPane().add(lblClases);
		
		JLabel lblActividades = new JLabel("Actividades");
		lblActividades.setForeground(Color.DARK_GRAY);
		lblActividades.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		lblActividades.setBounds(53, 503, 138, 23);
		getContentPane().add(lblActividades);
		
		btnVerInfoClases = new JButton("Ver mas informacion");
		btnVerInfoClases.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnVerInfoClases.setBounds(657, 363, 218, 35);
		getContentPane().add(btnVerInfoClases);
		
		btnVerInfoActiv = new JButton("Ver mas informacion");
		btnVerInfoActiv.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnVerInfoActiv.setBounds(658, 536, 218, 35);
		btnVerInfoActiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verMasActiv(e);
				salir(e);		
			}
		});
		btnVerInfoActiv.setBounds(414, 596, 164, 29);
		getContentPane().add(btnVerInfoActiv);
		
		comboBoxClases = new JComboBox<String>();
		comboBoxClases.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBoxClases.setBounds(52, 368, 588, 25);
		getContentPane().add(comboBoxClases);
		
		comboBoxActiv = new JComboBox<String>();
		comboBoxActiv.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBoxActiv.setBounds(53, 540, 588, 27);
		getContentPane().add(comboBoxActiv);
		
		lblSinClases = new JLabel("No tiene clases asociadas");
		lblSinClases.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSinClases.setForeground(Color.RED);
		lblSinClases.setBounds(359, 433, 183, 16);
		getContentPane().add(lblSinClases);
		
		lblSinActividades = new JLabel("No tiene actividades asociadas");
		lblSinActividades.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSinActividades.setForeground(Color.RED);
		lblSinActividades.setBounds(359, 617, 218, 25);
		getContentPane().add(lblSinActividades);
		
		lblNombreClase = new JLabel("Nombre");
		lblNombreClase.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNombreClase.setBounds(52, 408, 61, 25);
		getContentPane().add(lblNombreClase);
		
		lblFechaClase = new JLabel("Fecha");
		lblFechaClase.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblFechaClase.setBounds(432, 408, 48, 25);
		getContentPane().add(lblFechaClase);
		
		lblHoraClase = new JLabel("Hora de inicio");
		lblHoraClase.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblHoraClase.setBounds(660, 408, 103, 25);
		getContentPane().add(lblHoraClase);
		
		lblFechaRegistroClase = new JLabel("Fecha de registro");
		lblFechaRegistroClase.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblFechaRegistroClase.setBounds(586, 448, 130, 25);
		getContentPane().add(lblFechaRegistroClase);
		
		textFieldNomClase = new JTextField();
		textFieldNomClase.setColumns(10);
		textFieldNomClase.setBounds(124, 407, 283, 26);
		getContentPane().add(textFieldNomClase);
		
		textFechaClase = new JTextField();
		textFechaClase.setColumns(10);
		textFechaClase.setBounds(490, 407, 141, 26);
		getContentPane().add(textFechaClase);
		
		textHoraClase = new JTextField();
		textHoraClase.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textHoraClase.setColumns(10);
		textHoraClase.setBounds(773, 408, 103, 25);
		getContentPane().add(textHoraClase);
		
		textFieldRegistroClase = new JTextField();
		textFieldRegistroClase.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldRegistroClase.setColumns(10);
		textFieldRegistroClase.setBounds(714, 447, 160, 25);
		getContentPane().add(textFieldRegistroClase);
		
		lblNombreClase_1 = new JLabel("Nombre");
		lblNombreClase_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNombreClase_1.setBounds(53, 581, 69, 25);
		getContentPane().add(lblNombreClase_1);
		
		lblCostoActiv = new JLabel("Costo");
		lblCostoActiv.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblCostoActiv.setBounds(255, 617, 48, 25);
		getContentPane().add(lblCostoActiv);
		
		lblDuracion = new JLabel("Duracion");
		lblDuracion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblDuracion.setBounds(53, 617, 69, 25);
		getContentPane().add(lblDuracion);
		
		lblRegistroActiv = new JLabel("Fecha de registro");
		lblRegistroActiv.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblRegistroActiv.setBounds(53, 652, 137, 25);
		getContentPane().add(lblRegistroActiv);
		
		textFieldNomActiv = new JTextField();
		textFieldNomActiv.setColumns(10);
		textFieldNomActiv.setBounds(124, 581, 316, 25);
		getContentPane().add(textFieldNomActiv);
		
		textFieldCostoActiv = new JTextField();
		textFieldCostoActiv.setColumns(10);
		textFieldCostoActiv.setBounds(308, 616, 132, 26);
		getContentPane().add(textFieldCostoActiv);
		
		textFieldDuracionActiv = new JTextField();
		textFieldDuracionActiv.setColumns(10);
		textFieldDuracionActiv.setBounds(124, 616, 117, 26);
		getContentPane().add(textFieldDuracionActiv);
		
		textFieldRegistroActiv = new JTextField();
		textFieldRegistroActiv.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldRegistroActiv.setColumns(10);
		textFieldRegistroActiv.setBounds(181, 652, 259, 25);
		getContentPane().add(textFieldRegistroActiv);
		
		lblUrlClase = new JLabel("URL");
		lblUrlClase.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblUrlClase.setBounds(52, 447, 61, 25);
		getContentPane().add(lblUrlClase);
		
		textFieldURLClase = new JTextField();
		textFieldURLClase.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldURLClase.setColumns(10);
		textFieldURLClase.setBounds(123, 447, 439, 25);
		getContentPane().add(textFieldURLClase);
		
		lblDescripActiv = new JLabel("Descripcion");
		lblDescripActiv.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblDescripActiv.setBounds(460, 581, 92, 25);
		getContentPane().add(lblDescripActiv);
		
		textFieldDescripActiv = new JTextField();
		textFieldDescripActiv.setColumns(10);
		textFieldDescripActiv.setBounds(460, 612, 416, 65);
		getContentPane().add(textFieldDescripActiv);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(172, 514, 704, 12);
		getContentPane().add(separator_1_1_1);
		

	}
	
	public void iniciarlizarComboBoxes() {
		DefaultComboBoxModel<String> modeluser = new DefaultComboBoxModel<String>(cUController.listarUsuarios());
		comboBoxUser.setModel(modeluser);
		textFieldBibliog.setVisible(false);
		textFieldDescrip.setVisible(false);
		textFieldSitioWeb.setVisible(false);
		lblBibliografia.setVisible(false);
		lblSitioWeb.setVisible(false);
		lblDescripcion.setVisible(false);
		comboBoxClases.setVisible(false);
		comboBoxActiv.setVisible(false);
		btnVerInfoClases.setVisible(false);
		btnVerInfoActiv.setVisible(false);
		lblSinActividades.setVisible(false);
		lblSinClases.setVisible(false);
		textFieldNomClase.setVisible(false);
		textFechaClase.setVisible(false);
		textHoraClase.setVisible(false);
		textFieldRegistroClase.setVisible(false);
		textFieldURLClase.setVisible(false);
		lblNombreClase.setVisible(false);
		lblNombreClase_1.setVisible(false);
		lblFechaClase.setVisible(false);
		lblHoraClase.setVisible(false);
		lblFechaRegistroClase.setVisible(false);
		lblUrlClase.setVisible(false);
		textFieldNomActiv.setVisible(false);
		textFieldCostoActiv.setVisible(false);
		textFieldDuracionActiv.setVisible(false);
		textFieldDescripActiv.setVisible(false);
		textFieldRegistroActiv.setVisible(false);
		lblDescripActiv.setVisible(false);
		lblRegistroActiv.setVisible(false);
		lblCostoActiv.setVisible(false);
		lblDuracion.setVisible(false);
	}
	

	public void verInfo(ActionEvent e) {
		String nickname = this.comboBoxUser.getSelectedItem().toString();
//		int id = Integer.parseInt(nickname);
		DtUsuario dtU;
		DtProfesor dtP;
		dtU = this.cUController.DatosUsuario(nickname);
		textFieldNombre.setText(dtU.getNombre());
		textFieldApellido.setText(dtU.getApellido());
		textFieldEmail.setText(dtU.getEmail());
		String fecha = formatter.format((dtU.getFechaNac()));
		textFieldFechaNac.setText(fecha);
		if(cUController.listarClases(nickname) != null) {
			DefaultComboBoxModel<String> modelclase = new DefaultComboBoxModel<String>(cUController.listarClases(nickname));
			comboBoxClases.setModel(modelclase);
			comboBoxClases.setVisible(true);
			btnVerInfoClases.setVisible(true);
			String clase = (String) comboBoxClases.getSelectedItem();
			infoClase(nickname, clase);
		} else {
			lblSinClases.setVisible(true);
		}

		if(dtU instanceof DtProfesor) {
			dtP = (DtProfesor) dtU;
			textFieldBibliog.setText(dtP.getBiografia());
			textFieldDescrip.setText(dtP.getDescripcion());
			textFieldSitioWeb.setText(dtP.getSitioWeb());
			textFieldBibliog.setVisible(true);
			textFieldDescrip.setVisible(true);
			textFieldSitioWeb.setVisible(true);
			lblBibliografia.setVisible(true);
			lblSitioWeb.setVisible(true);
			lblDescripcion.setVisible(true);
			
			if(cUController.listarActividades(nickname) != null) {
				DefaultComboBoxModel<String> modelactiv = new DefaultComboBoxModel<String>(cUController.listarActividades(nickname));
				comboBoxActiv.setModel(modelactiv);
				comboBoxActiv.setVisible(true);
				btnVerInfoActiv.setVisible(true);
				String activ = (String) comboBoxActiv.getSelectedItem();
				infoActiv(nickname, activ);
			}else {
				lblSinActividades.setVisible(true);
			}
		}
		
		if (dtU instanceof DtSocio) {
			textFieldBibliog.setVisible(false);
			textFieldDescrip.setVisible(false);
			textFieldSitioWeb.setVisible(false);
			lblBibliografia.setVisible(false);
			lblSitioWeb.setVisible(false);
			lblDescripcion.setVisible(false);
			btnVerInfoActiv.setVisible(false);
			comboBoxActiv.setVisible(false);
		}
	}
	
	private void infoClase(String nickname, String nombreAct) {
		DtClase clase = cUController.DatosClase(nickname, nombreAct);
		textFieldNomClase.setText(clase.getNombre());
		String fecha = formatter.format((clase.getFecha()));
		textFechaClase.setText(fecha);
		String hora = horaformatter.format(clase.getFecha());
		textHoraClase.setText(hora);
		String fechaR = formatter.format(clase.getFechaReg());
		textFieldRegistroClase.setText(fechaR);
		textFieldURLClase.setText(clase.getUrl());
		lblSinClases.setVisible(true);
		textFieldNomClase.setVisible(true);
		textFechaClase.setVisible(true);
		textHoraClase.setVisible(true);
		textFieldRegistroClase.setVisible(true);
		textFieldURLClase.setVisible(true);
		lblNombreClase_1.setVisible(true);
		lblFechaClase.setVisible(true);
		lblHoraClase.setVisible(true);
		lblFechaRegistroClase.setVisible(true);
		lblUrlClase.setVisible(true);
		
	}
	
	private void infoActiv(String nickname, String nombreAct) {
		DtActividadDeportiva activ = cUController.DatosActiv(nickname, nombreAct);
		textFieldNomActiv.setText(activ.getNombre());
		//String costo = Float.toString(activ.getCosto());
		String costo = activ.getCosto().toString();
		textFieldCostoActiv.setText(costo);
		//String duracion = Integer.toString(activ.getDuracion());
		String duracion = activ.getDuracion().toString();
		textFieldDuracionActiv.setText(duracion);
		textFieldDescripActiv.setText(activ.getDescripcion());
		String fecha = formatter.format(activ.getFechaReg());
		textFieldRegistroActiv.setText(fecha);
		textFieldNomActiv.setVisible(true);
		textFieldCostoActiv.setVisible(true);
		textFieldDuracionActiv.setVisible(true);
		textFieldDescripActiv.setVisible(true);
		textFieldRegistroActiv.setVisible(true);
		lblDescripActiv.setVisible(true);
		lblRegistroActiv.setVisible(true);
		lblCostoActiv.setVisible(true);
		lblDuracion.setVisible(true);
	}
	
	private void salir (ActionEvent e) {
		setVisible(false);
		limpiarFormulario();
	}
	
	private void limpiarFormulario () {
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldEmail.setText("");
		textFieldFechaNac.setText("");
		textFieldBibliog.setText("");
		textFieldDescrip.setText("");
		textFieldSitioWeb.setText("");
	}
	
	private void verMasActiv(ActionEvent e) {
		String activ = (String) comboBoxActiv.getSelectedItem();
		String nickname = this.comboBoxUser.getSelectedItem().toString();
		String insti = cUController.obtenerInstitucion(nickname);
		consultaActividad.mostrarDatos(insti,activ);
		consultaActividad.setVisible(true);
	}
}
