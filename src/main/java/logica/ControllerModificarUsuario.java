package logica;

import datatypes.DtProfesor;
import datatypes.DtUsuario;
import excepciones.NoExisteUsuarioException;
import interfaces.IControllerModificarUsuario;
import persistencia.Conexion;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;


public class ControllerModificarUsuario implements IControllerModificarUsuario {
    public ControllerModificarUsuario(){
        super();
    }

    @Override
    public DtUsuario obtenerDtUsuario(String usuario) throws NoExisteUsuarioException {
        UsuarioHandler usuHand = UsuarioHandler.getInstancia();
        Usuario usu = usuHand.buscarUsuarioNick(usuario);
        if(usu == null) {
            usu = usuHand.buscarUsuarioEmail(usuario);
        }
        if(usu == null) {
            throw new NoExisteUsuarioException("No existe el usuario buscado");
        }        
        return usu.getDtUsuarioFoto();
    }

    @Override
    public String tipoUsuario(String usuario) {
        UsuarioHandler usuHnd = UsuarioHandler.getInstancia();
        return usuHnd.tipoUsuario(usuario);
    }
    
    public DtProfesor obtenerDtProfesor(String nickname) {
        UsuarioHandler usuHand = UsuarioHandler.getInstancia();
        Usuario usu = usuHand.buscarUsuarioNick(nickname);
        Profesor prof = (Profesor) usu;
        return (DtProfesor) prof.getDtUsuarioCompl();
    }
    
    @Override
    public void modificarUsuario(DtUsuario nuevo){
        UsuarioHandler usuH = UsuarioHandler.getInstancia();
        try {
            boolean resultado = usuH.actualizarUsuario(nuevo);
            if(resultado) {
                System.out.println("El usuario fue modificado correctamente.");
            } else {
                System.out.println("Error al modificar usuario.");
            }            
        } catch (Exception e) {
            
        }
        
    }
 }
