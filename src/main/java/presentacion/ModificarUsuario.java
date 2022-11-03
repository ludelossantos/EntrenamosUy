package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.NoExisteUsuarioException;
import interfaces.IControllerConsultaUsuario;
import interfaces.IControllerInstitucionDeportiva;
import interfaces.IControllerModificarUsuario;

public class ModificarUsuario extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    private IControllerModificarUsuario mUController;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldPass;
    private JTextField textFieldFoto;
    private JTextField textFieldBuscar;
    private JTextField textFieldSitioWeb;
    private JDateChooser dateChooser;
    private JTextArea textAreaDescripcion;
    private JTextArea textAreaBiografia;
    private JComboBox<String> comboBoxUsuario;
    private JComboBox<String> comboBoxInstitucion;
    

    public ModificarUsuario(IControllerModificarUsuario mUController, IControllerConsultaUsuario cUController, IControllerInstitucionDeportiva instDepController) {
        this.mUController = mUController;
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Modificar Datos de Usuario"); 
        setBounds(100, 100, 900, 628);
        getContentPane().setLayout(null);
        
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBackground(new Color(240, 240, 240));
        lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblNombre.setBounds(61, 134, 89, 25);
        getContentPane().add(lblNombre);
        
        textFieldNombre = new JTextField();
        textFieldNombre.setForeground(Color.DARK_GRAY);
        textFieldNombre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textFieldNombre.setBounds(132, 134, 292, 25);
        getContentPane().add(textFieldNombre);
        textFieldNombre.setColumns(10);
        
        JLabel lblApellido = new JLabel("Apellido");
        lblApellido.setBackground(new Color(240, 240, 240));
        lblApellido.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblApellido.setBounds(439, 134, 74, 25);
        getContentPane().add(lblApellido);
        
        textFieldApellido = new JTextField();
        textFieldApellido.setForeground(Color.DARK_GRAY);
        textFieldApellido.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textFieldApellido.setBounds(522, 134, 304, 25);
        getContentPane().add(textFieldApellido);
        textFieldApellido.setColumns(10);
        
        JLabel lblFechaNac = new JLabel("Fecha de Nacimiento");
        lblFechaNac.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblFechaNac.setBackground(new Color(240, 240, 240));
        lblFechaNac.setBounds(61, 169, 152, 25);
        getContentPane().add(lblFechaNac);
        
        JLabel lblUsuario = new JLabel("Seleccione el usuario");
        lblUsuario.setBackground(new Color(240, 240, 240));
        lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblUsuario.setBounds(61, 85, 167, 25);
        getContentPane().add(lblUsuario);
        
        comboBoxUsuario = new JComboBox<String>();
        comboBoxUsuario.setBackground(Color.WHITE);
        comboBoxUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        comboBoxUsuario.setBounds(228, 85, 598, 25);
        comboBoxUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUsuarioActionPerformed(e);
            }
        });
        getContentPane().add(comboBoxUsuario);
            
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panel.setBounds(48, 239, 790, 270);
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
        DefaultComboBoxModel<String> modelinsti = new DefaultComboBoxModel<String>(instDepController.obtenerInstituciones());
        comboBoxInstitucion.setModel(modelinsti);
        panel.add(comboBoxInstitucion);
        comboBoxInstitucion.setEnabled(false);
        
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                modificarUsuarioAceptarActionPerformed();
            }
        });
        btnAceptar.setBounds(708, 519, 130, 35);
        getContentPane().add(btnAceptar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarUsuarioCancelarActionPerformed();
            }
        });
        btnCancelar.setBounds(563, 519, 130, 35);
        getContentPane().add(btnCancelar);
        
        dateChooser = new JDateChooser();
        dateChooser.getCalendarButton().setLocation(783, 0);
        dateChooser.setBounds(223, 169, 201, 25);
        getContentPane().add(dateChooser);
        
        JLabel lblPass = new JLabel("Contraseña");
        lblPass.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblPass.setBackground(SystemColor.menu);
        lblPass.setBounds(439, 169, 89, 25);
        getContentPane().add(lblPass);
        
        textFieldPass = new JTextField();
        textFieldPass.setForeground(Color.DARK_GRAY);
        textFieldPass.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textFieldPass.setColumns(10);
        textFieldPass.setBounds(522, 169, 305, 25);
        getContentPane().add(textFieldPass);
        
        JLabel lblFoto = new JLabel("URL de foto");
        lblFoto.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblFoto.setBackground(SystemColor.menu);
        lblFoto.setBounds(61, 204, 130, 25);
        getContentPane().add(lblFoto);
        
        textFieldFoto = new JTextField();
        textFieldFoto.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textFieldFoto.setColumns(10);
        textFieldFoto.setBounds(201, 204, 626, 25);
        getContentPane().add(textFieldFoto);
        
        JLabel lblBuscar = new JLabel("Ingrese nickname o correo");
        lblBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblBuscar.setBackground(SystemColor.menu);
        lblBuscar.setBounds(61, 46, 201, 25);
        getContentPane().add(lblBuscar);

        textFieldBuscar = new JTextField();
        textFieldBuscar.setForeground(Color.DARK_GRAY);
        textFieldBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textFieldBuscar.setColumns(10);
        textFieldBuscar.setBounds(259, 45, 427, 25);
        getContentPane().add(textFieldBuscar);
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btnBuscar.setBounds(696, 41, 130, 35);
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUsuarioActionPerformed(e);
            }
        });
        getContentPane().add(btnBuscar);
    }

    private DtUsuario buscarUsuario(){
        DtUsuario usuario = null;
        String usu = textFieldBuscar.getText();
        String usuBox = (String) this.comboBoxUsuario.getSelectedItem();
        if(!usu.equals("")){
            try{
                usuario = mUController.obtenerDtUsuario(usu);
                textFieldBuscar.setText("");
            } catch (NoExisteUsuarioException ne){
                JOptionPane.showMessageDialog(this, ne.getMessage(), "Modificar usuario", JOptionPane.ERROR_MESSAGE);
            }
        }else {
            if(!usuBox.equals("")){
                try{
                    usuario = mUController.obtenerDtUsuario(usuBox);
                } catch (NoExisteUsuarioException ne){
                    JOptionPane.showMessageDialog(this, ne.getMessage(), "Modificar usuario", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        return usuario;
    }

    private void buscarUsuarioActionPerformed(ActionEvent e){
        DtUsuario usuario = buscarUsuario();
        comboBoxUsuario.setSelectedItem(usuario.getNickname());
        cargarDatos(usuario);
    }

    private void cargarDatos(DtUsuario usuario){
        this.comboBoxUsuario.setSelectedItem(usuario.getNickname());
        this.textFieldNombre.setText(usuario.getNombre());
        this.textFieldApellido.setText(usuario.getApellido());
        this.textFieldFoto.setText(usuario.getFoto());
        this.textFieldPass.setText(usuario.getPass());
        Date nac = usuario.getFechaNac();
        this.dateChooser.setDate(nac);
        
        String tipo = mUController.tipoUsuario(usuario.getNickname());        
        
        if(tipo.equals("P")){
            DtProfesor dtP = mUController.obtenerDtProfesor(usuario.getNickname());
            textAreaDescripcion.setEnabled(true);
            textAreaBiografia.setEnabled(true);
            textFieldSitioWeb.setEnabled(true);
            comboBoxInstitucion.setEnabled(true);          
            this.textAreaDescripcion.setText(dtP.getDescripcion());
            this.textAreaBiografia.setText(dtP.getBiografia());
            this.textFieldSitioWeb.setText(dtP.getSitioWeb());
            this.comboBoxInstitucion.setSelectedItem(dtP.getInstitucion());
        }else{
            System.out.println("instancia dt socio");
            this.textAreaDescripcion.setText("");
            this.textAreaBiografia.setText("");
            this.textFieldSitioWeb.setText("");
            this.comboBoxInstitucion.setSelectedItem("");
            textAreaDescripcion.setEnabled(false);
            textAreaBiografia.setEnabled(false);
            textFieldSitioWeb.setEnabled(false);
            comboBoxInstitucion.setEnabled(false);
        }
    }

    protected void modificarUsuarioAceptarActionPerformed(){
        if(checkFormulario()) {
            DtUsuario usu = buscarUsuario();
            String nickname = usu.getNickname();
            String email = usu.getEmail();
            String nombre = this.textFieldNombre.getText();
            String apellido = this.textFieldApellido.getText();
            String pass= this.textFieldPass.getText();
            String foto= this.textFieldFoto.getText();
            java.util.Date fechaNac = dateChooser.getDate();
            
            String tipo = mUController.tipoUsuario(usu.getNickname());        
            
            if(tipo.equals("P")){          
                String descripcion = this.textAreaDescripcion.getText();
                String biografia = this.textAreaBiografia.getText();
                String sitioWeb = this.textFieldSitioWeb.getText();
                String insti = (String) this.comboBoxInstitucion.getSelectedItem();
                usu = new DtProfesor(nickname, nombre, apellido, email, fechaNac, pass, foto, descripcion, biografia, sitioWeb, insti);
                System.out.println("crea un dt profe");
            }else {
                usu = new DtSocio(nickname, nombre, apellido, email, fechaNac, pass, foto);
                System.out.println("crea un dt socio");
            }

            try {
                this.mUController.modificarUsuario(usu);
                JOptionPane.showMessageDialog(this, "El usuario se ha modificado con \u00E9xito", "Modificar Datos de Usuario", JOptionPane.INFORMATION_MESSAGE);
                limpiarFormulario();
                setVisible(false);
            } catch(Exception e) {
                e.printStackTrace();
            }
                            
        }
      }

    public void inicializarUsuarios(IControllerConsultaUsuario cUController) {
        DefaultComboBoxModel<String> modeluser = new DefaultComboBoxModel<String>(cUController.listarUsuarios());
        comboBoxUsuario.setModel(modeluser);
    }


    private boolean checkFormulario() {
        String nombre = this.textFieldNombre.getText();
        String apellido = this.textFieldApellido.getText();
        java.util.Date fechaNac = this.dateChooser.getDate();
        String descripcion = this.textAreaDescripcion.getText();
        String pass = this.textFieldPass.getText();
        DtUsuario usu = buscarUsuario();
    
        if(nombre.isEmpty() || apellido.isEmpty() || (fechaNac==null) || pass.isEmpty()){
            JOptionPane.showMessageDialog(this, "Complete los campos en blanco.", "Alta usuario", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(usu instanceof DtProfesor && comboBoxInstitucion.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Seleccione la instituci\u00F3n.", "Alta usuario", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(usu instanceof DtProfesor && descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese una descripci\u00F3n.", "Alta usuario", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
        
    protected void modificarUsuarioCancelarActionPerformed() {
        limpiarFormulario();
        setVisible(false);
    }
    
     private void limpiarFormulario(){
         textFieldBuscar.setText("");
         textFieldNombre.setText("");
         textFieldApellido.setText("");
         textFieldSitioWeb.setText("");
         textFieldPass.setText("");
         comboBoxUsuario.setSelectedItem("");
         comboBoxInstitucion.setSelectedItem("");
         textAreaDescripcion.setText("");
         textAreaBiografia.setText("");
         textFieldFoto.setText("");
         Date myObj = new Date();
         dateChooser.setDate(myObj);
         dateChooser.setDate(new Date());
     }
}
