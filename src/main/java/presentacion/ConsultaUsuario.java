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
		setBounds(400, 500, 600, 720);
		getContentPane().setLayout(null);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(87, 23, 92, 16);
		lblNickname.setFont(new Font("Dialog", Font.BOLD, 16));
		getContentPane().add(lblNickname);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir(e);
			}
		});
		btnSalir.setBounds(243, 635, 117, 29);
		btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(btnSalir);
		
		JButton btnVerInfo = new JButton("Ver informacion");
		btnVerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verInfo(e);
			}
		});
		btnVerInfo.setBounds(338, 19, 138, 29);
		getContentPane().add(btnVerInfo);
		
		comboBoxUser = new JComboBox<String>();
		comboBoxUser.setBounds(175, 20, 117, 27);
		getContentPane().add(comboBoxUser);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(65, 100, 61, 16);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(289, 100, 61, 16);
		getContentPane().add(lblApellido);
		
		JLabel lblMail = new JLabel("E-mail");
		lblMail.setBounds(65, 133, 61, 16);
		getContentPane().add(lblMail);
		
		JLabel lblFechaNac = new JLabel("Fecha de nacimiento");
		lblFechaNac.setBounds(289, 133, 137, 16);
		getContentPane().add(lblFechaNac);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(138, 95, 130, 26);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(376, 95, 130, 26);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(123, 128, 147, 26);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setBounds(425, 128, 81, 26);
		getContentPane().add(textFieldFechaNac);
		textFieldFechaNac.setColumns(10);
		
		lblSitioWeb = new JLabel("Sitio web");
		lblSitioWeb.setBounds(65, 221, 61, 16);
		getContentPane().add(lblSitioWeb);
		
		textFieldSitioWeb = new JTextField();
		textFieldSitioWeb.setBounds(138, 216, 368, 26);
		getContentPane().add(textFieldSitioWeb);
		textFieldSitioWeb.setColumns(10);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(65, 161, 81, 16);
		getContentPane().add(lblDescripcion);
		
		textFieldBibliog = new JTextField();
		textFieldBibliog.setBounds(389, 161, 117, 53);
		getContentPane().add(textFieldBibliog);
		textFieldBibliog.setColumns(10);
		
		textFieldDescrip = new JTextField();
		textFieldDescrip.setColumns(10);
		textFieldDescrip.setBounds(160, 161, 110, 53);
		getContentPane().add(textFieldDescrip);
		
		lblBibliografia = new JLabel("Bibliografia");
		lblBibliografia.setBounds(289, 161, 81, 16);
		getContentPane().add(lblBibliografia);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 240, 576, 12);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 623, 576, 12);
		getContentPane().add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 433, 576, 12);
		getContentPane().add(separator_1_1);
		
		JLabel lblNewLabel = new JLabel("Datos Personales");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(18, 60, 138, 23);
		getContentPane().add(lblNewLabel);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 52, 576, 12);
		getContentPane().add(separator_2);
		
		JLabel lblClases = new JLabel("Clases");
		lblClases.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		lblClases.setBounds(10, 253, 138, 23);
		getContentPane().add(lblClases);
		
		JLabel lblActividades = new JLabel("Actividades");
		lblActividades.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		lblActividades.setBounds(10, 446, 138, 23);
		getContentPane().add(lblActividades);
		
		btnVerInfoClases = new JButton("Ver mas informacion");
		btnVerInfoClases.setBounds(412, 402, 164, 29);
		getContentPane().add(btnVerInfoClases);
		
		btnVerInfoActiv = new JButton("Ver mas informacion");
		btnVerInfoActiv.setBounds(414, 596, 164, 29);
		getContentPane().add(btnVerInfoActiv);
		
		comboBoxClases = new JComboBox<String>();
		comboBoxClases.setBounds(106, 264, 117, 27);
		getContentPane().add(comboBoxClases);
		
		comboBoxActiv = new JComboBox<String>();
		comboBoxActiv.setBounds(106, 457, 117, 27);
		getContentPane().add(comboBoxActiv);
		
		lblSinClases = new JLabel("No tiene clases asociadas");
		lblSinClases.setForeground(Color.RED);
		lblSinClases.setBounds(212, 324, 232, 16);
		getContentPane().add(lblSinClases);
		
		lblSinActividades = new JLabel("No tiene actividades asociadas");
		lblSinActividades.setForeground(Color.RED);
		lblSinActividades.setBounds(196, 525, 232, 16);
		getContentPane().add(lblSinActividades);
		
		lblNombreClase = new JLabel("Nombre");
		lblNombreClase.setBounds(65, 309, 61, 16);
		getContentPane().add(lblNombreClase);
		
		lblFechaClase = new JLabel("Fecha");
		lblFechaClase.setBounds(289, 309, 61, 16);
		getContentPane().add(lblFechaClase);
		
		lblHoraClase = new JLabel("Hora de inicio");
		lblHoraClase.setBounds(65, 342, 103, 16);
		getContentPane().add(lblHoraClase);
		
		lblFechaRegistroClase = new JLabel("Fecha de registro");
		lblFechaRegistroClase.setBounds(289, 342, 137, 16);
		getContentPane().add(lblFechaRegistroClase);
		
		textFieldNomClase = new JTextField();
		textFieldNomClase.setColumns(10);
		textFieldNomClase.setBounds(138, 304, 130, 26);
		getContentPane().add(textFieldNomClase);
		
		textFechaClase = new JTextField();
		textFechaClase.setColumns(10);
		textFechaClase.setBounds(342, 304, 164, 26);
		getContentPane().add(textFechaClase);
		
		textHoraClase = new JTextField();
		textHoraClase.setColumns(10);
		textHoraClase.setBounds(167, 337, 103, 26);
		getContentPane().add(textHoraClase);
		
		textFieldRegistroClase = new JTextField();
		textFieldRegistroClase.setColumns(10);
		textFieldRegistroClase.setBounds(412, 337, 94, 26);
		getContentPane().add(textFieldRegistroClase);
		
		lblNombreClase = new JLabel("Nombre");
		lblNombreClase.setBounds(67, 509, 61, 16);
		getContentPane().add(lblNombreClase);
		
		lblCostoActiv = new JLabel("Costo");
		lblCostoActiv.setBounds(291, 509, 61, 16);
		getContentPane().add(lblCostoActiv);
		
		lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(67, 542, 61, 16);
		getContentPane().add(lblDuracion);
		
		lblRegistroActiv = new JLabel("Fecha de registro");
		lblRegistroActiv.setBounds(291, 542, 137, 16);
		getContentPane().add(lblRegistroActiv);
		
		textFieldNomActiv = new JTextField();
		textFieldNomActiv.setColumns(10);
		textFieldNomActiv.setBounds(140, 504, 130, 26);
		getContentPane().add(textFieldNomActiv);
		
		textFieldCostoActiv = new JTextField();
		textFieldCostoActiv.setColumns(10);
		textFieldCostoActiv.setBounds(340, 504, 168, 26);
		getContentPane().add(textFieldCostoActiv);
		
		textFieldDuracionActiv = new JTextField();
		textFieldDuracionActiv.setColumns(10);
		textFieldDuracionActiv.setBounds(140, 537, 132, 26);
		getContentPane().add(textFieldDuracionActiv);
		
		textFieldRegistroActiv = new JTextField();
		textFieldRegistroActiv.setColumns(10);
		textFieldRegistroActiv.setBounds(414, 537, 94, 26);
		getContentPane().add(textFieldRegistroActiv);
		
		lblUrlClase = new JLabel("URL");
		lblUrlClase.setBounds(65, 375, 61, 16);
		getContentPane().add(lblUrlClase);
		
		textFieldURLClase = new JTextField();
		textFieldURLClase.setColumns(10);
		textFieldURLClase.setBounds(138, 370, 368, 26);
		getContentPane().add(textFieldURLClase);
		
		lblDescripActiv = new JLabel("Descripcion");
		lblDescripActiv.setBounds(65, 570, 81, 16);
		getContentPane().add(lblDescripActiv);
		
		textFieldDescripActiv = new JTextField();
		textFieldDescripActiv.setColumns(10);
		textFieldDescripActiv.setBounds(160, 570, 110, 53);
		getContentPane().add(textFieldDescripActiv);
		

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
		lblNombreClase.setVisible(true);
		lblFechaClase.setVisible(true);
		lblHoraClase.setVisible(true);
		lblFechaRegistroClase.setVisible(true);
		lblUrlClase.setVisible(true);
		
	}
	
	private void infoActiv(String nickname, String nombreAct) {
		DtActividadDeportiva activ = cUController.DatosActiv(nickname, nombreAct);
		textFieldNomActiv.setText(activ.getNombre());
		String costo = Float.toString(activ.getCosto());
		textFieldCostoActiv.setText(costo);
		String duracion = Integer.toString(activ.getDuracion());
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
}
