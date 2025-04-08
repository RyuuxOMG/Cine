package autonoma.Cine.models;

// Clase que representa una pelicula en cartelera
public class Pelicula {
    private String nombre;
    private int costoBase;

    // Constructor que inicializa el nombre y el costo base
    public Pelicula(String nombre, int costoBase) {
        this.nombre = nombre;
        this.costoBase = costoBase;
    }

    // Metodo para obtener el nombre de la pelicula
    public String getNombre() {
        return nombre;
    }

    // Metodo para obtener el costo base de la pelicula
    public int getCostoBase() {
        return costoBase;
    }
}