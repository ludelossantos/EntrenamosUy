package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
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

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.EmailRepetidoException;
import excepciones.NicknameRepetidoException;
import interfaces.IControllerAltaUsuario;
import logica.InstitucionDeportiva;

import javax.swing.ScrollPaneConstants;

import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;

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
	private JComboBox<String> comboBoxInstitucion;
	

	public AltaUsuario(IControllerAltaUsuario aUController) {
		this.aUController = aUController;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta Usuario");	
		setBounds(100, 100, 910, 555);
		getContentPane().setLayout(null);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBackground(new Color(240, 240, 240));
		lblNickname.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNickname.setBounds(438, 52, 100, 25);
		getContentPane().add(lblNickname);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setForeground(Color.DARK_GRAY);
		textFieldNickname.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldNickname.setBounds(521, 52, 305, 25);
		getContentPane().add(textFieldNickname);
		textFieldNickname.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBackground(new Color(240, 240, 240));
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNombre.setBounds(60, 87, 89, 25);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setForeground(Color.DARK_GRAY);
		textFieldNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldNombre.setBounds(131, 87, 292, 25);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBackground(new Color(240, 240, 240));
		lblApellido.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblApellido.setBounds(438, 87, 74, 25);
		getContentPane().add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setForeground(Color.DARK_GRAY);
		textFieldApellido.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldApellido.setBounds(521, 87, 304, 25);
		getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBackground(new Color(240, 240, 240));
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblEmail.setBounds(60, 122, 45, 25);
		getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldEmail.setBounds(131, 122, 292, 25);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblFechaNac = new JLabel("Fecha de nacimiento");
		lblFechaNac.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblFechaNac.setBackground(new Color(240, 240, 240));
		lblFechaNac.setBounds(438, 122, 152, 25);
		getContentPane().add(lblFechaNac);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBackground(new Color(240, 240, 240));
		lblTipo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblTipo.setBounds(60, 52, 45, 25);
		getContentPane().add(lblTipo);
		
		comboBoxUsuario = new JComboBox<String>();
		comboBoxUsuario.setBackground(Color.WHITE);
		comboBoxUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBoxUsuario.setBounds(131, 52, 292, 25);
		comboBoxUsuario.addItem("Profesor");
		comboBoxUsuario.addItem("Socio");
		comboBoxUsuario.setSelectedItem("Socio");
		getContentPane().add(comboBoxUsuario);
			
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(49, 165, 790, 270);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblDescripcion.setBackground(new Color(240, 240, 240));
		lblDescripcion.setBounds(12, 45, 117, 25);
		panel.add(lblDescripcion);
		
		JLabel lblSitioWeb = new JLabel("Sitio web");
		lblSitioWeb.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSitioWeb.setBackground(new Color(240, 240, 240));
		lblSitioWeb.setBounds(12, 235, 73, 25);
		panel.add(lblSitioWeb);
		
		textFieldSitioWeb = new JTextField();
		textFieldSitioWeb.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textFieldSitioWeb.setBounds(93, 235, 687, 25);
		panel.add(textFieldSitioWeb);
		textFieldSitioWeb.setColumns(10);
		textFieldSitioWeb.setEnabled(false);
		
		JLabel lblBiografia = new JLabel("Biograf\u00EDa");
		lblBiografia.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblBiografia.setBackground(new Color(240, 240, 240));
		lblBiografia.setBounds(389, 45, 130, 25);
		panel.add(lblBiografia);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(11, 74, 365, 150);
		panel.add(scrollPane);
		
		textAreaDescripcion = new JTextArea(8,43);
		textAreaDescripcion.setLineWrap(true);
		scrollPane.setViewportView(textAreaDescripcion);
		textAreaDescripcion.setEnabled(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(389, 74, 390, 150);
		panel.add(scrollPane_1);
		
		textAreaBiografia = new JTextArea(8,43);
		textAreaBiografia.setLineWrap(true);
		scrollPane_1.setViewportView(textAreaBiografia);
		textAreaBiografia.setEnabled(false);
		
		JLabel lblInstitucion = new JLabel("Instituci\u00F3n");
		lblInstitucion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblInstitucion.setBounds(12, 12, 94, 25);
		panel.add(lblInstitucion);
		
		comboBoxInstitucion = new JComboBox<String>();
		comboBoxInstitucion.setBounds(105, 12, 675, 25);
		panel.add(comboBoxInstitucion);
		comboBoxInstitucion.setEnabled(false);
		
		comboBoxUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eve) {
				String tipoU = (String) comboBoxUsuario.getSelectedItem();
				if(tipoU.equals("Profesor")) {
					comboBoxUsuario.setSelectedItem(true);
					textAreaDescripcion.setEnabled(true);
					textAreaBiografia.setEnabled(true);
					textFieldSitioWeb.setEnabled(true);
					comboBoxInstitucion.setEnabled(true);
					//inicializarInstituciones();
				}else {
					comboBoxUsuario.setSelectedItem(true);
					textAreaDescripcion.setEnabled(false);
					textAreaBiografia.setEnabled(false);
					textFieldSitioWeb.setEnabled(false);
					comboBoxInstitucion.setEnabled(false);
				}				
			}
		});		
		
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
			public void actionPerformed(ActionEvent e) {
				altaUsuarioCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(564, 444, 130, 35);
		getContentPane().add(btnCancelar);
		
		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setLocation(783, 0);
		dateChooser.setBounds(600, 122, 225, 25);
		getContentPane().add(dateChooser);
	}
	
	public void inicializarInstituciones() {
		DefaultComboBoxModel<String> modelinsti = new DefaultComboBoxModel<String>(aUController.listarInstituciones());
		comboBoxInstitucion.setModel(modelinsti);
	}
	
	protected void altaUsuarioAceptarActionPerformed(ActionEvent arg0){
		if(checkFormulario()) {
			String nickname = this.textFieldNickname.getText();
			String nombre = this.textFieldNombre.getText();
			String apellido = this.textFieldApellido.getText();
			String email = this.textFieldEmail.getText();
			
			java.util.Date fechaNac = dateChooser.getDate();
			//Long fechaL = fechaS.getTime();
			//java.sql.Date fechaSQL = new java.sql.Date(fechaL);

			String tipo = this.comboBoxUsuario.getSelectedItem().toString();		
			DtUsuario dt = null;			
			if(tipo.equals("Profesor")) {
				String descripcion = this.textAreaDescripcion.getText();
				String biografia = this.textAreaBiografia.getText();
				String sitioWeb = this.textFieldSitioWeb.getText();
				String insti = this.comboBoxInstitucion.getSelectedItem().toString();
				InstitucionDeportiva institucion = this.aUController.buscarInstitucion(insti);	
				System.out.println("crea profesor");
				dt = new DtProfesor(nickname, nombre, apellido, email, fechaNac, descripcion, biografia, sitioWeb, institucion);
			}else {
				System.out.println("crea socio");
				dt = new DtSocio(nickname, nombre, apellido, email, fechaNac);
			}
			
			try {
				this.aUController.altaUsuario(dt);
				JOptionPane.showMessageDialog(this, "El usuario se ha creado con éxito", "Alta usuario", JOptionPane.INFORMATION_MESSAGE);
				limpiarFormulario();
	            setVisible(false);
			} catch(NicknameRepetidoException rn) {
				JOptionPane.showMessageDialog(this, rn.getMessage(), "Alta usuario", JOptionPane.ERROR_MESSAGE);
			} catch(EmailRepetidoException re) {
				JOptionPane.showMessageDialog(this, re.getMessage(), "Alta usuario", JOptionPane.ERROR_MESSAGE);
			}
							
		}
}
	
private boolean checkFormulario() {		
	String nickname = this.textFieldNickname.getText();
	String nombre = this.textFieldNombre.getText();
	String apellido = this.textFieldApellido.getText();
	String email = this.textFieldEmail.getText();
	java.util.Date fechaNac = this.dateChooser.getDate();
	String tipoU = this.comboBoxUsuario.getSelectedItem().toString();
	String descripcion = this.textAreaDescripcion.getText();
	
	if(nickname.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || (fechaNac==null)){		
		/*if(nickname.isEmpty())
			this.textFieldNickname.setBackground(Color.PINK);
		if(nombre.isEmpty())
			this.textFieldNombre.setBackground(Color.PINK);
		if (apellido.isEmpty())
			this.textFieldApellido.setBackground(Color.PINK);
		if(email.isEmpty())
			this.textFieldEmail.setBackground(Color.PINK);
		if(fechaNac==null)
			this.dateChooser.setBackground(Color.PINK);*/
		JOptionPane.showMessageDialog(this, "Complete los campos en blanco.", "Alta usuario", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	if(tipoU.equals("Profesor") && comboBoxInstitucion.getSelectedItem() == null) {
		JOptionPane.showMessageDialog(this, "Seleccione la institución.", "Alta usuario", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	if(tipoU.equals("Profesor") && descripcion.isEmpty()) {
		JOptionPane.showMessageDialog(this, "Ingrese una descripción.", "Alta usuario", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	return true;
}
		
	protected void altaUsuarioCancelarActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
		setVisible(false);
	}
	
	 private void limpiarFormulario(){
		 textFieldNickname.setText("");
		 textFieldNombre.setText("");
		 textFieldApellido.setText("");
		 textFieldEmail.setText("");
		 textFieldSitioWeb.setText("");
		 comboBoxUsuario.setSelectedItem("Socio"); //NO SE BORRA REVISAR
		 textAreaDescripcion.setText("");  //NO SE BORRA REVISAR
		 textAreaBiografia.setText("");  //NO SE BORRA REVISAR
	 }
}