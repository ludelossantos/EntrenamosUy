package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import datatypes.DtInstitucionDeportiva;
import excepciones.InstitucionDeportivaRepetidaException;
import interfaces.IControllerInstitucionDeportiva;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class AltaInstitucionDeportiva extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IControllerInstitucionDeportiva aIDController;

	private JTextField txtNombre;
	private JTextArea txtADescripcion;
	private JTextField txtUrl;


	public AltaInstitucionDeportiva(IControllerInstitucionDeportiva aIDC) {
		aIDController = aIDC;

		setResizable(false);
        setIconifiable(false);
        setMaximizable(false);
        setBounds(100, 100, 450, 355);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta Instituci\u00F3n Deportiva");	
		getContentPane().setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNombre.setBounds(50, 23, 84, 28);
		getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtNombre.setBounds(156, 23, 213, 28);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblDescripcion.setBounds(50, 77, 98, 31);
		getContentPane().add(lblDescripcion);

		txtADescripcion = new JTextArea();
		txtADescripcion.setWrapStyleWord(true);
		txtADescripcion.setLineWrap(true);
		txtADescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtADescripcion.setBounds(156, 77, 213, 70);
		getContentPane().add(txtADescripcion);

		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblUrl.setBounds(50, 173, 51, 28);
		getContentPane().add(lblUrl);

		txtUrl = new JTextField();
		txtUrl.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtUrl.setColumns(10);
		txtUrl.setBounds(156, 173, 213, 28);
		getContentPane().add(txtUrl);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				altaInstitucionDeportivaCancelarActionPerformed(e);
			}
		});
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCancelar.setBounds(75, 248, 115, 37);
		getContentPane().add(btnCancelar);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAceptar.setBounds(244, 248, 115, 37);
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				altaInstitucionDeportivaAceptarActionPerformed(e);
			}
		});
		getContentPane().add(btnAceptar);

	}


	protected void altaInstitucionDeportivaAceptarActionPerformed(ActionEvent arg0) {
		if(checkFormulario()) {
			String nombre = this.txtNombre.getText();
			String descripcion = this.txtADescripcion.getText();
			String url = this.txtUrl.getText();
	
			DtInstitucionDeportiva dtReturn = null;
			dtReturn = new DtInstitucionDeportiva(nombre, descripcion, url);
			try {
				this.aIDController.altaInstitucion(dtReturn);
				JOptionPane.showMessageDialog(this, "La Institucion Deportiva se ha creado con exito", 
						"Alta Institucion Deportiva", JOptionPane.INFORMATION_MESSAGE);
				System.out.println("crea institucion deportiva "+ dtReturn.getNombre() +"");
				cleanForm();
				setVisible(false);
			} catch (InstitucionDeportivaRepetidaException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Institucion Deportiva", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	protected void altaInstitucionDeportivaCancelarActionPerformed(ActionEvent arg0) {
		cleanForm();
		setVisible(false);
	}

	 private void cleanForm(){
		 this.txtNombre.setText("");
		 this.txtADescripcion.setText("");
		 this.txtUrl.setText("");
	 }
	 
	 private boolean checkFormulario() {
			String nombre = this.txtNombre.getText();
			String descripcion = this.txtADescripcion.getText();
			String url = this.txtUrl.getText();
			
			if(nombre.isEmpty() || descripcion.isEmpty() || url.isEmpty()){		
				JOptionPane.showMessageDialog(this, "Complete los campos en blanco.", "Alta usuario", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			return true;
		}
}