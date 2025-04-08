package autonoma.Cine.exceptions;

// Excepcion personalizada que se lanza cuando una pelicula no se encuentra
public class PeliculaNoExisteException extends Exception {

    
    public PeliculaNoExisteException(String mensaje) {
        super("La pelicula ingresada no existe en cartelera.");
    }
}
