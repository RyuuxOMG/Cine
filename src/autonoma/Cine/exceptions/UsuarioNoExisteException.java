package autonoma.Cine.exceptions;

// Excepcion personalizada que se lanza cuando un usuario no se encuentra
public class UsuarioNoExisteException extends Exception {

    
    public UsuarioNoExisteException(String mensaje) {
        super("El usuario ingresado no se encuentra registrado.");
    }
}
