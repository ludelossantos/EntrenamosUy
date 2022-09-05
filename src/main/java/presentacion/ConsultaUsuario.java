package presentacion;

import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ConsultaUsuario extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public ConsultaUsuario() {
		setTitle("Consulta de Usuario");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuarios");
		lblNewLabel.setBounds(17, 40, 61, 16);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(lblNewLabel);
		
		JList<String> list = new JList<String>();
		list.setBounds(154, 57, 1, 1);
		list.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(list);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.setBounds(142, 200, 117, 29);
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(btnNewButton_1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(90, 36, 100, 27);
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(47, 93, 323, 88);
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		getContentPane().add(textField);
		textField.setColumns(10);

	}
}
