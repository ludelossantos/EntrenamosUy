package presentacion;

import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;

import interfaces.IControllerConsultaUsuario;

import javax.swing.JTextField;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;

import java.awt.event.ActionListener;
import java.text.Format;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import java.awt.Label;
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
		setBounds(400, 400, 500, 500);
		getContentPane().setLayout(null);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(18, 24, 92, 16);
		lblNickname.setFont(new Font("Dialog", Font.BOLD, 16));
		getContentPane().add(lblNickname);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir(e);
			}
		});
		btnSalir.setBounds(182, 403, 117, 29);
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
		lblNombre.setBounds(18, 95, 61, 16);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(242, 95, 61, 16);
		getContentPane().add(lblApellido);
		
		JLabel lblMail = new JLabel("E-mail");
		lblMail.setBounds(18, 128, 61, 16);
		getContentPane().add(lblMail);
		
		JLabel lblFechaNac = new JLabel("Fecha de nacimiento");
		lblFechaNac.setBounds(242, 128, 137, 16);
		getContentPane().add(lblFechaNac);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(91, 90, 130, 26);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(329, 90, 130, 26);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(76, 123, 147, 26);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setBounds(378, 123, 81, 26);
		getContentPane().add(textFieldFechaNac);
		textFieldFechaNac.setColumns(10);
		
		lblSitioWeb = new JLabel("Sitio web");
		lblSitioWeb.setBounds(18, 216, 61, 16);
		getContentPane().add(lblSitioWeb);
		
		textFieldSitioWeb = new JTextField();
		textFieldSitioWeb.setBounds(91, 211, 368, 26);
		getContentPane().add(textFieldSitioWeb);
		textFieldSitioWeb.setColumns(10);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(18, 156, 81, 16);
		getContentPane().add(lblDescripcion);
		
		textFieldBibliog = new JTextField();
		textFieldBibliog.setBounds(342, 156, 117, 53);
		getContentPane().add(textFieldBibliog);
		textFieldBibliog.setColumns(10);
		
		textFieldDescrip = new JTextField();
		textFieldDescrip.setColumns(10);
		textFieldDescrip.setBounds(113, 156, 110, 53);
		getContentPane().add(textFieldDescrip);
		
		lblBibliografia = new JLabel("Bibliografia");
		lblBibliografia.setBounds(242, 156, 81, 16);
		getContentPane().add(lblBibliografia);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 240, 476, 12);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 385, 476, 12);
		getContentPane().add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 310, 476, 12);
		getContentPane().add(separator_1_1);
		
		JLabel lblNewLabel = new JLabel("Datos Personales");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(18, 60, 138, 23);
		getContentPane().add(lblNewLabel);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 52, 476, 12);
		getContentPane().add(separator_2);
		
		JLabel lblClases = new JLabel("Clases");
		lblClases.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		lblClases.setBounds(10, 253, 138, 23);
		getContentPane().add(lblClases);
		
		JLabel lblActividades = new JLabel("Actividades");
		lblActividades.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		lblActividades.setBounds(10, 321, 138, 23);
		getContentPane().add(lblActividades);
		
		btnVerInfoClases = new JButton("Ver informacion");
		btnVerInfoClases.setBounds(269, 264, 138, 29);
		getContentPane().add(btnVerInfoClases);
		
		btnVerInfoActiv = new JButton("Ver informacion");
		btnVerInfoActiv.setBounds(269, 344, 138, 29);
		getContentPane().add(btnVerInfoActiv);
		
		comboBoxClases = new JComboBox();
		comboBoxClases.setBounds(106, 264, 117, 27);
		getContentPane().add(comboBoxClases);
		
		comboBoxActiv = new JComboBox();
		comboBoxActiv.setBounds(104, 345, 117, 27);
		getContentPane().add(comboBoxActiv);
		
		lblSinClases = new JLabel("No tiene clases asociadas");
		lblSinClases.setForeground(Color.RED);
		lblSinClases.setBounds(147, 282, 232, 16);
		getContentPane().add(lblSinClases);
		
		lblSinActividades = new JLabel("No tiene actividades asociadas");
		lblSinActividades.setForeground(Color.RED);
		lblSinActividades.setBounds(147, 356, 232, 16);
		getContentPane().add(lblSinActividades);
		

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
	}
	
	public void verInfo(ActionEvent e) {
		String nickname = this.comboBoxUser.getSelectedItem().toString();
//		int id = Integer.parseInt(nickname);
		DtUsuario dtU;
		DtProfesor dtP;
		DtSocio dtS;
		dtU = this.cUController.DatosUsuario(nickname);
		textFieldNombre.setText(dtU.getNombre());
		textFieldApellido.setText(dtU.getApellido());
		textFieldEmail.setText(dtU.getEmail());
		textFieldFechaNac.setText(dtU.getFechaNac().toString());
		if(cUController.listarClases(nickname) != null) {
			DefaultComboBoxModel<String> modelclase = new DefaultComboBoxModel<String>(cUController.listarClases(nickname));
			comboBoxClases.setModel(modelclase);
			comboBoxClases.setVisible(true);
			btnVerInfoClases.setVisible(true);
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
			}else {
				lblSinActividades.setVisible(true);
			}
		}
		
		if (dtU instanceof DtSocio) {
			dtS = (DtSocio) dtU;
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
