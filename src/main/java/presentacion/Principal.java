package presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.JFrame;
//import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import interfaces.Factory;
import interfaces.IControllerAltaUsuario;
import interfaces.IControllerInstitucionDeportiva;
import interfaces.IControllerAltaActividadDep;
import interfaces.IControllerAltaDictadoClase;

public class Principal {

	private JFrame frmEntrenamosUy;
	private AltaUsuario altaUsuarioInternalFrame;
	private AltaInstitucionDeportiva altaInstitucionDeportivaInternalFrame;
	private AltaActividadDeportiva altaActividadDeportivaInternalFrame;
	private AltaDictadoClase altaDictadoClaseInternalFrame;

	/**
     * Launch the application.
     */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmEntrenamosUy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 /**
     * Create the application.
     */
	public Principal() {
		initialize();

		Factory fabrica = Factory.getInstance();
		IControllerAltaUsuario aUController = fabrica.getIControllerAltaUsuario();
		IControllerInstitucionDeportiva aIDController = fabrica.getIControllerInstitucionDeportiva();
		IControllerAltaActividadDep aADController = fabrica.getIControllerAltaActividadDep();
		IControllerAltaDictadoClase aDCController = fabrica.getIControllerAltaDictadoClase();

		Dimension desktopSize = frmEntrenamosUy.getSize();
		Dimension jInternalFrameSize;

		altaUsuarioInternalFrame = new AltaUsuario(aUController);
		jInternalFrameSize = altaUsuarioInternalFrame.getSize();
		altaUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		altaUsuarioInternalFrame.setVisible(false);
		frmEntrenamosUy.getContentPane().add(altaUsuarioInternalFrame);

		altaInstitucionDeportivaInternalFrame = new AltaInstitucionDeportiva(aIDController);
		jInternalFrameSize = altaInstitucionDeportivaInternalFrame.getSize();
		altaInstitucionDeportivaInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2, 
				(desktopSize.height - jInternalFrameSize.height) / 2);
		altaInstitucionDeportivaInternalFrame.setVisible(false);
		frmEntrenamosUy.getContentPane().add(altaInstitucionDeportivaInternalFrame);

		altaActividadDeportivaInternalFrame = new AltaActividadDeportiva(aADController);
		jInternalFrameSize = altaActividadDeportivaInternalFrame.getSize();
		altaActividadDeportivaInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
		altaActividadDeportivaInternalFrame.setVisible(false);
		frmEntrenamosUy.getContentPane().add(altaActividadDeportivaInternalFrame);
		
		altaDictadoClaseInternalFrame = new AltaDictadoClase(aIDController, aDCController);
		jInternalFrameSize = altaDictadoClaseInternalFrame.getSize();
		altaDictadoClaseInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
		altaDictadoClaseInternalFrame.setVisible(false);
		frmEntrenamosUy.getContentPane().add(altaDictadoClaseInternalFrame);
	}
    /**
     * Initialize the contents of the frame.
     */
	private void initialize() {
		frmEntrenamosUy = new JFrame();
		frmEntrenamosUy.setTitle("Entrenamos Uy");
		frmEntrenamosUy.setBounds(100, 100, 1200, 900);
		frmEntrenamosUy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEntrenamosUy.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		frmEntrenamosUy.setJMenuBar(menuBar);

		JMenu mnUsuario = new JMenu("Usuario");
		mnUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnUsuario);

		JMenuItem mntmUsuarioAlta = new JMenuItem("Alta");
		mntmUsuarioAlta.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmUsuarioAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioInternalFrame.setVisible(true);
			}
		});
		mnUsuario.add(mntmUsuarioAlta);

		JMenuItem mntmUsuarioConsulta = new JMenuItem("Consulta");
		mntmUsuarioConsulta.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnUsuario.add(mntmUsuarioConsulta);

		JMenuItem mntmUsuarioModificar = new JMenuItem("Modificar");
		mntmUsuarioModificar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnUsuario.add(mntmUsuarioModificar);

		JMenu mnInstitucion = new JMenu("Institución");
		mnInstitucion.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnInstitucion);

		JMenuItem mnInstitucionAlta = new JMenuItem("Alta");
		mnInstitucionAlta.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnInstitucionAlta.addActionListener(new ActionListener ( ) {
			public void actionPerformed(ActionEvent e) {
				altaInstitucionDeportivaInternalFrame.setVisible(true);
			}
		});
		mnInstitucion.add(mnInstitucionAlta);

		JMenuItem mntmInstitucionModificar = new JMenuItem("Modificar");
		mntmInstitucionModificar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnInstitucion.add(mntmInstitucionModificar);

		JMenu mnActividadDeportiva = new JMenu("Actividad Deportiva");
		mnActividadDeportiva.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnActividadDeportiva);

		JMenuItem mntmActDepoAlta = new JMenuItem("Alta");
		mntmActDepoAlta.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmActDepoAlta.addActionListener(new ActionListener ( ) {
			public void actionPerformed(ActionEvent e) {
				Factory fabrica = Factory.getInstance();
				IControllerInstitucionDeportiva aIDController = fabrica.getIControllerInstitucionDeportiva();
				altaActividadDeportivaInternalFrame.inicializarComboBoxes(aIDController);
				altaActividadDeportivaInternalFrame.setVisible(true);
			}
		});
		mnActividadDeportiva.add(mntmActDepoAlta);

		JMenuItem mntmActDepoConsulta = new JMenuItem("Consulta");
		mntmActDepoConsulta.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnActividadDeportiva.add(mntmActDepoConsulta);

		JMenuItem mntmActDepoModificar = new JMenuItem("Modificar");
		mntmActDepoModificar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnActividadDeportiva.add(mntmActDepoModificar);

		JMenuItem mntmActDepoRanking = new JMenuItem("Ranking");
		mntmActDepoRanking.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnActividadDeportiva.add(mntmActDepoRanking);

		JMenu mnClase = new JMenu("Clase");
		mnClase.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnClase);

		JMenuItem mntmClaseAlta = new JMenuItem("Alta");
		mntmClaseAlta.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmClaseAlta.addActionListener(new ActionListener ( ) {
			public void actionPerformed(ActionEvent e) {
				Factory fabrica = Factory.getInstance();
				IControllerInstitucionDeportiva aIDController = fabrica.getIControllerInstitucionDeportiva();
				altaDictadoClaseInternalFrame.inicializarComboBoxes(aIDController);
				altaDictadoClaseInternalFrame.setVisible(true);
			}
		});
		mnClase.add(mntmClaseAlta);

		JMenuItem mntmClaseRegistro = new JMenuItem("Registro");
		mntmClaseRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnClase.add(mntmClaseRegistro);

		JMenuItem mntmClaseConsulta = new JMenuItem("Consulta");
		mntmClaseConsulta.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnClase.add(mntmClaseConsulta);

		JMenuItem mntmClaseRanking = new JMenuItem("Ranking");
		mntmClaseRanking.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnClase.add(mntmClaseRanking);

		frmEntrenamosUy.setLocationRelativeTo(null);
	}

}