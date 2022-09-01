package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.EmailRepetidoException;
import excepciones.NicknameRepetidoException;
import interfaces.IControllerAltaUsuario;
import javax.swing.ScrollPaneConstants;

public class AltaUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IControllerAltaUsuario aUController;
	private JTextField textFieldNickname;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldSitioWeb;
	private JDateChooser dateChooser;
	private JComboBox<String> comboBoxUsuario;
	private JTextArea textAreaDescripcion;
	private JTextArea textAreaBiografia;


	public AltaUsuario(IControllerAltaUsuario aUC) {
		aUController = aUC;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta Usuario");	
		setBounds(100, 100, 910, 555);
		getContentPane().setLayout(null);

		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setBackground(new Color(240, 240, 240));
		lblNickname.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNickname.setBounds(61, 34, 100, 20);
		getContentPane().add(lblNickname);

		textFieldNickname = new JTextField();
		textFieldNickname.setForeground(Color.DARK_GRAY);
		textFieldNickname.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldNickname.setBounds(143, 29, 297, 25);
		getContentPane().add(textFieldNickname);
		textFieldNickname.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBackground(new Color(240, 240, 240));
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNombre.setBounds(61, 71, 89, 25);
		getContentPane().add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setForeground(Color.DARK_GRAY);
		textFieldNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldNombre.setBounds(143, 71, 297, 25);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBackground(new Color(240, 240, 240));
		lblApellido.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblApellido.setBounds(460, 71, 74, 25);
		getContentPane().add(lblApellido);

		textFieldApellido = new JTextField();
		textFieldApellido.setForeground(Color.DARK_GRAY);
		textFieldApellido.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldApellido.setBounds(534, 71, 292, 25);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBackground(new Color(240, 240, 240));
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblEmail.setBounds(61, 107, 45, 25);
		getContentPane().add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldEmail.setBounds(143, 107, 378, 25);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JLabel lblFechaNac = new JLabel("Fecha nacimiento:");
		lblFechaNac.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblFechaNac.setBackground(new Color(240, 240, 240));
		lblFechaNac.setBounds(534, 107, 142, 25);
		getContentPane().add(lblFechaNac);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBackground(new Color(240, 240, 240));
		lblTipo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblTipo.setBounds(61, 147, 45, 25);
		getContentPane().add(lblTipo);

		JComboBox<String> comboBoxUsuario = new JComboBox<String>();
		comboBoxUsuario.setBackground(Color.WHITE);
		comboBoxUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBoxUsuario.setBounds(143, 147, 204, 25);
		comboBoxUsuario.addItem("Profesor");
		comboBoxUsuario.addItem("Socio");
		comboBoxUsuario.setSelectedItem("Socio");
		getContentPane().add(comboBoxUsuario);

		JPanel panel = new JPanel();
		panel.setBounds(49, 189, 790, 240);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblDescripcion.setBackground(new Color(240, 240, 240));
		lblDescripcion.setBounds(12, 10, 117, 25);
		panel.add(lblDescripcion);

		JLabel lblSitioWeb = new JLabel("Sitio web:");
		lblSitioWeb.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSitioWeb.setBackground(new Color(240, 240, 240));
		lblSitioWeb.setBounds(12, 203, 73, 25);
		panel.add(lblSitioWeb);

		textFieldSitioWeb = new JTextField();
		textFieldSitioWeb.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldSitioWeb.setBounds(93, 203, 687, 25);
		panel.add(textFieldSitioWeb);
		textFieldSitioWeb.setColumns(10);

		JLabel lblBiografia = new JLabel("Biografía:");
		lblBiografia.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblBiografia.setBackground(new Color(240, 240, 240));
		lblBiografia.setBounds(388, 10, 130, 25);
		panel.add(lblBiografia);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(12, 43, 365, 150);
		panel.add(scrollPane);

		textAreaDescripcion = new JTextArea(8,43);
		textAreaDescripcion.setLineWrap(true);
		scrollPane.setViewportView(textAreaDescripcion);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(390, 43, 390, 150);
		panel.add(scrollPane_1);

		textAreaBiografia = new JTextArea(8,43);
		textAreaBiografia.setLineWrap(true);
		scrollPane_1.setViewportView(textAreaBiografia);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				altaUsuarioAceptarActionPerformed(arg0);
			}
		});
		btnAceptar.setBounds(709, 444, 130, 35);
		getContentPane().add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				altaUsuarioCancelarActionPerformed(arg0);
			}
		});
		btnCancelar.setBounds(564, 444, 130, 35);
		getContentPane().add(btnCancelar);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setLocation(783, 0);
		dateChooser.setBounds(670, 107, 156, 25);
		getContentPane().add(dateChooser);

	}

	protected void altaUsuarioAceptarActionPerformed(ActionEvent arg0){
		String nickname = this.textFieldNickname.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String email = this.textFieldEmail.getText();
		String tipo = this.comboBoxUsuario.getSelectedItem().toString(); //agrego toString porque no funciona con casteo
		Date fechaNac = (Date) this.dateChooser.getDate();
		String descripcion = this.textAreaDescripcion.getText();
		String biografia = this.textAreaBiografia.getText();
		String sitioWeb = this.textFieldSitioWeb.getText();
		DtUsuario dt = null;
		if(tipo.equals("Profesor")) {
			dt = new DtProfesor(nickname, nombre, apellido, email, fechaNac, descripcion, biografia, sitioWeb);
		}else {
			dt = new DtSocio(nickname, nombre, apellido, email, fechaNac);
		}
		try {
			this.aUController.altaUsuario(dt);
			JOptionPane.showMessageDialog(this, "El usuario se ha creado con éxito", "Alta usuario", JOptionPane.INFORMATION_MESSAGE);	
		} catch(NicknameRepetidoException rn) {
			JOptionPane.showMessageDialog(this, rn.getMessage(), "Alta usuario", JOptionPane.ERROR_MESSAGE);
		} catch(EmailRepetidoException re) {
			JOptionPane.showMessageDialog(this, re.getMessage(), "Alta usuario", JOptionPane.ERROR_MESSAGE);
		}

		limpiarFormulario();
		setVisible(false);
	}

	protected void altaUsuarioCancelarActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
		setVisible(false);
	}

	 private void limpiarFormulario(){
		 this.textFieldNickname.setText("");
		 this.textFieldNombre.setText("");
		 this.textFieldApellido.setText("");
		 this.textFieldEmail.setText("");
		 this.textFieldSitioWeb.setText("");
		 this.comboBoxUsuario.setSelectedItem("Socio");
		 this.textAreaDescripcion.setText("");
		 this.textAreaBiografia.setText("");
	 }
}