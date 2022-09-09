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
        setBounds(100, 100, 450, 450);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta Institucion Deportiva");	
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Alta de Institución Deportiva");
		lblTitulo.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblTitulo.setBounds(87, 36, 271, 42);
		getContentPane().add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNombre.setBounds(49, 118, 84, 28);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setToolTipText("Ingrese Nombre de la Institución");
		txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtNombre.setBounds(155, 118, 213, 28);
		txtNombre.setColumns(10);
		getContentPane().add(txtNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblDescripcion.setBounds(49, 172, 98, 31);
		getContentPane().add(lblDescripcion);
		
		/*JTextArea*/ txtADescripcion = new JTextArea();
		txtADescripcion.setToolTipText("Ingrese Descripcion");
		txtADescripcion.setLineWrap(true);
		txtADescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtADescripcion.setBounds(155, 172, 213, 70);
		getContentPane().add(txtADescripcion);
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblUrl.setBounds(49, 268, 51, 28);
		getContentPane().add(lblUrl);
		
		txtUrl = new JTextField();
		txtUrl.setToolTipText("Ingrese URL (www...)");
		txtUrl.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtUrl.setColumns(10);
		txtUrl.setBounds(155, 268, 213, 28);
		getContentPane().add(txtUrl);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				altaInstitucionDeportivaCancelar();
				cleanForm();
			}
		});
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnCancelar.setBounds(74, 343, 115, 37);
		getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaInstitucionDeportivaAceptar();				
			}
		});
		btnAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAceptar.setBounds(243, 343, 115, 37);
		getContentPane().add(btnAceptar);

	}
	
	
	protected void altaInstitucionDeportivaAceptar() {
		String nombre = this.txtNombre.getText();
		String descripcion = this.txtADescripcion.getText();
		String url = this.txtUrl.getText();
		
		DtInstitucionDeportiva instiDepor = new DtInstitucionDeportiva(nombre, descripcion, url);
				
		try {
			boolean res = this.aIDController.existeInstitucionDeportiva(nombre);
			System.out.printf("Existe Institución: " + res);
			if (!res) {
				this.aIDController.altaInstitucion(instiDepor);
				JOptionPane.showMessageDialog(this, "Se agrego correctamente la Institucion Deportiva");
			} /*else {
				int mod = JOptionPane.showConfirmDialog(AltaInstitucionDeportiva.this,
						"Ya existe la Institucion, ¿desea modificarla?", "MODIFICAR PLATAFORMA",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (mod == 0) {
					this.aIDController.mod(this.controlador.find(txtNombre.getText()), txtNombre.getText(),
							txtDesc.getText(), txtUrl.getText());
				}
			}*/
			

		} catch (InstitucionDeportivaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		DtInstitucionDeportiva dtReturn = null;
		dtReturn = new DtInstitucionDeportiva(nombre, descripcion, url);
		try {
			this.aIDController.altaInstitucion(dtReturn);
			JOptionPane.showMessageDialog(this, "La Institucion Deportiva se ha creado con exito", 
					"Alta Institucion Deportiva", JOptionPane.INFORMATION_MESSAGE);
		} catch (InstitucionDeportivaRepetidaException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Institucion Deportiva", JOptionPane.ERROR_MESSAGE);
		}*/
		cleanForm();
	}
	
	protected void altaInstitucionDeportivaCancelar() {
		cleanForm();
		setVisible(false);
	}

	 private void cleanForm(){
		 this.txtNombre.setText("");
		 this.txtADescripcion.setText("");
		 this.txtUrl.setText("");
	 }
}
