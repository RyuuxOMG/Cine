package autonoma.Cine.exceptions;

// Excepcion personalizada que se lanza cuando una pelicula no se encuentra
public class PeliculaNoExisteException extends Exception {

    // Constructor que recibe un mensaje personalizado
    public PeliculaNoExisteException(String mensaje) {
        super(mensaje);
    }
}
