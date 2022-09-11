package presentacion;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import interfaces.Factory;
import interfaces.IControllerAltaUsuario;
import interfaces.IControllerRegistroClase;
import interfaces.IControllerInstitucionDeportiva;
import interfaces.IControllerConsultaActividad;
import interfaces.IControllerConsultaUsuario;

public class Principal {
	
	private JFrame frame;
	private AltaUsuario altaUsuarioInternalFrame;
	private RegistroClase registroClaseInternalFrame;
	private AltaInstitucionDeportiva altaInstitucionDeportivaInternalFrame;
	private ConsultaUsuario consultaUsuarioInternalFrame;
	private ConsultaActividad consultaActividadInternalFrame;

	/**
     * Launch the application.
     */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
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
		IControllerRegistroClase rCController = fabrica.getIControllerRegistroClase();
		IControllerConsultaUsuario cUController = fabrica.getIControllerConsultaUsuario(); 
		IControllerInstitucionDeportiva aIDController = fabrica.getIControllerInstitucionDeportiva();
		IControllerConsultaActividad cAController = fabrica.getIControllerConsultaActividad();

		Dimension desktopSize = frame.getSize();
		Dimension jInternalFrameSize;
		
		altaUsuarioInternalFrame = new AltaUsuario(aUController);
		jInternalFrameSize = altaUsuarioInternalFrame.getSize();
		altaUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		altaUsuarioInternalFrame.setVisible(false);
		frame.getContentPane().add(altaUsuarioInternalFrame);
		
		registroClaseInternalFrame = new RegistroClase(rCController);
				jInternalFrameSize = registroClaseInternalFrame.getSize();
		registroClaseInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		registroClaseInternalFrame.setVisible(false);
		frame.getContentPane().add(registroClaseInternalFrame);					
	
		altaInstitucionDeportivaInternalFrame = new AltaInstitucionDeportiva(aIDController);
		jInternalFrameSize = altaInstitucionDeportivaInternalFrame.getSize();
		altaInstitucionDeportivaInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2, 
				(desktopSize.height - jInternalFrameSize.height) / 2);
		altaInstitucionDeportivaInternalFrame.setVisible(false);
		frame.getContentPane().add(altaInstitucionDeportivaInternalFrame);
		
		consultaUsuarioInternalFrame = new ConsultaUsuario(cUController);
		jInternalFrameSize = consultaUsuarioInternalFrame.getSize();
		consultaUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- (jInternalFrameSize.height)*2)/70);
		consultaUsuarioInternalFrame.setVisible(false);
		frame.getContentPane().add(consultaUsuarioInternalFrame);
		
		consultaActividadInternalFrame = new ConsultaActividad(cAController);
		jInternalFrameSize = consultaActividadInternalFrame.getSize();
		consultaActividadInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
		    (desktopSize.height- jInternalFrameSize.height)/2);
		consultaActividadInternalFrame.setVisible(false);
		frame.getContentPane().add(consultaActividadInternalFrame);

	}
	/**
     * Initialize the contents of the frame.
     */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

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
		mntmUsuarioConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaUsuarioInternalFrame.iniciarlizarComboBoxes();
				consultaUsuarioInternalFrame.setVisible(true);
			}
		});
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
		mnActividadDeportiva.add(mntmActDepoAlta);

		JMenuItem mntmActDepoConsulta = new JMenuItem("Consulta");
		mntmActDepoConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaActividadInternalFrame.cargarComboInstituciones();
				consultaActividadInternalFrame.setVisible(true);
			}
		});
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
		mnClase.add(mntmClaseAlta);

		JMenuItem mntmClaseRegistro = new JMenuItem("Registro");
		mntmClaseRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmClaseRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registroClaseInternalFrame.inicializarComboBoxes();
				registroClaseInternalFrame.setVisible(true);				
			}
		});
		mnClase.add(mntmClaseRegistro);

		JMenuItem mntmClaseConsulta = new JMenuItem("Consulta");
		mntmClaseConsulta.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnClase.add(mntmClaseConsulta);

		JMenuItem mntmClaseRanking = new JMenuItem("Ranking");
		mntmClaseRanking.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnClase.add(mntmClaseRanking);

		frame.setLocationRelativeTo(null);
	}
}