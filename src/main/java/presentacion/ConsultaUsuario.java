package presentacion;

import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;


import interfaces.IControllerConsultaUsuario;

import javax.swing.JTextField;

public class ConsultaUsuario extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IControllerConsultaUsuario cUController;
	private JComboBox<String> comboBoxUser;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the frame.
	 */
	public ConsultaUsuario(IControllerConsultaUsuario cUController) {
		setTitle("Consulta de Usuario");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(18, 24, 92, 16);
		lblNickname.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(lblNickname);
		
		JList<String> list = new JList<String>();
		list.setBounds(154, 57, 1, 1);
		list.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(list);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(162, 219, 117, 29);
		btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(btnSalir);
		
		JButton btnVerInfo = new JButton("Ver informacion");
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
		
		textField = new JTextField();
		textField.setBounds(76, 70, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(290, 70, 130, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(76, 103, 130, 26);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(353, 103, 67, 26);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSitioWeb = new JLabel("Sitio web");
		lblSitioWeb.setBounds(18, 196, 61, 16);
		getContentPane().add(lblSitioWeb);
		
		textField_4 = new JTextField();
		textField_4.setBounds(79, 191, 341, 26);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(18, 136, 81, 16);
		getContentPane().add(lblDescripcion);
		
		textField_5 = new JTextField();
		textField_5.setBounds(303, 136, 117, 53);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(96, 136, 110, 53);
		getContentPane().add(textField_6);
		
		JLabel lblBibliografia = new JLabel("Bibliografia");
		lblBibliografia.setBounds(218, 136, 81, 16);
		getContentPane().add(lblBibliografia);
		

	}
	
	public void iniciarlizarComboBoxes() {
		DefaultComboBoxModel<String> modelusers = new DefaultComboBoxModel<String>(cUController.listarUsuarios());
		comboBoxUser.setModel(modelusers);
	}
}
