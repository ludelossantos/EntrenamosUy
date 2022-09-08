package presentacion;

import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import interfaces.IControllerConsultaUsuario;

import javax.swing.JTextField;

import datatypes.DtProfesor;
//import datatypes.DtSocio;
import datatypes.DtUsuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaUsuario extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IControllerConsultaUsuario cUController;
	private JComboBox<String> comboBoxUser;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldFechaNac;
	private JTextField textFieldSitioWeb;
	private JTextField textFieldBibliog;
	private JTextField textFieldDescrip;

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
		setBounds(100, 100, 463, 311);
		getContentPane().setLayout(null);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(18, 24, 92, 16);
		lblNickname.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(lblNickname);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(161, 230, 117, 29);
		btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(btnSalir);
		
		JButton btnVerInfo = new JButton("Ver informacion");
		btnVerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verInfo(e);
			}
		});
		btnVerInfo.setBounds(269, 20, 138, 29);
		getContentPane().add(btnVerInfo);
		
		comboBoxUser = new JComboBox<String>();
		comboBoxUser.setBounds(106, 21, 117, 27);
		getContentPane().add(comboBoxUser);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(18, 75, 61, 16);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(218, 75, 61, 16);
		getContentPane().add(lblApellido);
		
		JLabel lblMail = new JLabel("E-mail");
		lblMail.setBounds(18, 108, 61, 16);
		getContentPane().add(lblMail);
		
		JLabel lblFechaNac = new JLabel("Fecha de nacimiento");
		lblFechaNac.setBounds(218, 108, 137, 16);
		getContentPane().add(lblFechaNac);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(76, 70, 130, 26);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(290, 70, 130, 26);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(76, 103, 130, 26);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setBounds(353, 103, 67, 26);
		getContentPane().add(textFieldFechaNac);
		textFieldFechaNac.setColumns(10);
		
		JLabel lblSitioWeb = new JLabel("Sitio web");
		lblSitioWeb.setBounds(18, 196, 61, 16);
		getContentPane().add(lblSitioWeb);
		
		textFieldSitioWeb = new JTextField();
		textFieldSitioWeb.setBounds(79, 191, 341, 26);
		getContentPane().add(textFieldSitioWeb);
		textFieldSitioWeb.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(18, 136, 81, 16);
		getContentPane().add(lblDescripcion);
		
		textFieldBibliog = new JTextField();
		textFieldBibliog.setBounds(303, 136, 117, 53);
		getContentPane().add(textFieldBibliog);
		textFieldBibliog.setColumns(10);
		
		textFieldDescrip = new JTextField();
		textFieldDescrip.setColumns(10);
		textFieldDescrip.setBounds(96, 136, 110, 53);
		getContentPane().add(textFieldDescrip);
		
		JLabel lblBibliografia = new JLabel("Bibliografia");
		lblBibliografia.setBounds(218, 136, 81, 16);
		getContentPane().add(lblBibliografia);
		

	}
	
	public void iniciarlizarComboBoxes() {
		DefaultComboBoxModel<String> modeluser = new DefaultComboBoxModel<String>(cUController.listarUsuarios());
		comboBoxUser.setModel(modeluser);
	}
	
	public void verInfo(ActionEvent e) {
		String nickname = this.comboBoxUser.getSelectedItem().toString();
//		int id = Integer.parseInt(nickname);
		DtUsuario dtU;
		DtProfesor dtP;
//		DtSocio dtS;
		dtU = this.cUController.DatosUsuario(nickname);
		textFieldNombre.setText(dtU.getNombre());
		textFieldApellido.setText(dtU.getApellido());
		textFieldEmail.setText(dtU.getEmail());
		textFieldFechaNac.setText(dtU.getFechaNac().toString());
		if(dtU instanceof DtProfesor) {
			dtP = (DtProfesor) dtU;
			textFieldBibliog.setText(dtP.getBiografia());
			textFieldDescrip.setText(dtP.getDescripcion());
			textFieldSitioWeb.setText(dtP.getSitioWeb());
		}
	}
}
