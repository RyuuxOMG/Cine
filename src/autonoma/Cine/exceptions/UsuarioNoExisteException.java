package autonoma.Cine.exceptions;

// Excepcion personalizada que se lanza cuando un usuario no se encuentra
public class UsuarioNoExisteException extends Exception {

    // Constructor que recibe un mensaje personalizado
    public UsuarioNoExisteException(String mensaje) {
        super("El usuario ingresado no se encuentra registrado.");
    }
}
